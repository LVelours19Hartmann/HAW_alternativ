package aufgabenblatt4a;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
//import javafx.scene.control.Tooltip;
//import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
//import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Klasse zur Darstellung des Benutzerinterfaces
 * 
 * @author Helena Lajevardi, Lennart Hartmann
 *
 */
public class Gui extends Application {

	private Stage primaryStage;
	private Pane pane;
	private TableView<Polygon> tabelle;
	private PolygonTabelle polyTabelle;
	private TextArea textbereich;
	private PolygonSkripting polySkript = new PolygonSkripting();

	//Breite und Hoehe der Anwendung
	private int fensterbreite, fensterhoehe;
	
	private PolygonDarstellung polygonDarstellung;



	/**
	 * Default-Konstruktor, legt Fenstergroesse bei Appstart fest
	 */
	public Gui() {
		fensterhoehe = 600;
		fensterbreite = 1000;
	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Polygon-Zeicheneditor");
		pane = paneInit();
		this.primaryStage.setScene(new Scene(pane, fensterbreite, fensterhoehe));
		PolygonModell polygonModell = new PolygonModell(polygonDarstellung);
		polygonDarstellung.setPolygonModell(polygonModell);
		polyTabelle = new PolygonTabelle(this.tabelle, polygonModell);
		polyTabelle.inititalisiere();
		this.primaryStage.show();

		// Beispiel Polygon
		Polygon polygon1 = polygonModell.getPolygon();
		polygon1.setPunkt(25, 25);
		polygon1.setPunkt(150.5, 75.5);
		polygon1.setPunkt(50, 50);
		polygonModell.finalisiereBearbeitung();
		polyTabelle.refresh();
	}

	/**
	 * Getter
	 * 
	 * @return Gibt die Pane zurueck
	 */
	public Pane getPane() {
		return pane;
	}

	/**
	 * Methode zum erstellen der GUI
	 * 
	 * @return Gibt die GUI als BorderPane zurueck
	 */
	private Pane paneInit() {
		BorderPane pane = new BorderPane();
		pane.setCenter(getZeichenflaeche());
		pane.setRight(getPolygontabelle());
		pane.setBottom(befehlInput());
		return pane;
	}

	/**
	 * Methode zum erstellen der Befehlseingabe
	 * 
	 * @return Gibt die Befehlseingabe als BorderPane zurueck
	 */
	private Pane befehlInput() {
		BorderPane pane = new BorderPane();
		textbereich = new TextArea();
		textbereich.setMaxHeight(50);
		pane.setCenter(textbereich);
		pane.setBottom(befehlButtons());
		return pane;
	}

	/**
	 * Methode zum erstellen der Buttons fuer die Befehlseingabe
	 * 
	 * @return Gibt die Buttons in einer HBox zureuck
	 */
	private Pane befehlButtons() {
		HBox pane = new HBox();
		pane.setSpacing(15);
		Button befehl = new Button("Eingabe");
		
		befehl.setOnAction(event -> {
			String text = textbereich.toString();
			try {
				polygonDarstellung.getPolygonmodell().getPolygon().setPunkt(polySkript.getX(text),polySkript.getY(text));
				textbereich.clear();
			} catch (Exception e) {
				textbereich.setText(e.getMessage()
						+ " --- Bitte einen gueltigen Befehl eingeben!\n"
						+ "-->> Siehe \"?\" fuer gueltige Befehle! <<--");
			}
		});
		
		Button fertig = new Button("Fertig");
		fertig.setOnAction(event -> {
//			polygonDarstellung.getModell().finalisiereBearbeitung();
			polygonDarstellung.getPolygonmodell().finalisiereBearbeitung();

			polyTabelle.refresh();
			textbereich.clear();
		});
		
		Button close = new Button("Exit");
		close.setOnAction(event -> primaryStage.close());
		pane.getChildren().addAll(befehl, fertig, close);
		return pane;
	}

	/**
	 * Methode zum erstellen der PolygonDarstellung
	 * 
	 * @return Gibt die PolygonDarstellung zurueck
	 */
	private Pane getZeichenflaeche() {
		BorderPane pane = new BorderPane();
		polygonDarstellung = new PolygonDarstellung(pane);
		return pane;
	}

	/**
	 * Methode zum erstellen einer Tabelle, die die gezeichneten Polygone
	 * anzeigt
	 * 
	 * @return Gibt eine Tabelle als BorderPane zurueck
	 */
	private Pane getPolygontabelle() {
		BorderPane pane = new BorderPane();
		tabelle = new TableView<Polygon>();
		pane.setCenter(tabelle);
		return pane;
	}
	
	/**
	 * Starter
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
