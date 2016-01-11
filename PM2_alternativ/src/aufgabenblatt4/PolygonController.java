/**
 * BTI1-PTP/03, WS 15
 * Gruppe: Helena Lajevardi (helena.lajevardi@haw-hamburg.de)
 *         Lennart Hartmann (lennart.hartmann@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 4
 * 
 */
package aufgabenblatt4;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Repraesentiert einen Controller fuer Polygone.
 * 
 * @author Helena Lajevardi, Lennart Hartmann
 */
public class PolygonController extends Application {

	/**
	 * Die Darstellung fuer die Polygone.
	 */
	private PolygonView view;
	
	/**
	 * Die Daten fuer die Darstellung.
	 */
	private PolygonModell model;
	
	/**
	 * Dient der Verarbeitung der eingegebenen Befehle.
	 */
	PolygonSkripting polySkript = new PolygonSkripting();
	
	/**
	 * Startet die Anwendung.
	 * @param args nichts
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		model = new PolygonModell();
		view = new PolygonView(model);
		initialisiereGUI(primaryStage, model);
	}
	
	private void initialisiereGUI(Stage primaryStage, PolygonModell model) {
		
		int GROESSE = 500;
		
		primaryStage.setTitle("Polygon Zeicheneditor");
		
		SplitPane container = new SplitPane();
		ObservableList<Node> containerContent = container.getItems();
		container.setOrientation(Orientation.HORIZONTAL);

		GridPane controlPane = new GridPane();
		
		ListView<Polygon> polygonListView = new ListView<>();
		TableColumn<Polygon, String> polygonName = new TableColumn<Polygon, String>("Polygone");
		polygonName.setCellValueFactory(new PropertyValueFactory<Polygon, String>("name"));
		
		Button setzenNeuButton = new Button("Setzen/Neu");
		setzenNeuButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				model.polygonBearbeitungAbschliessen();
				polygonListView.setItems(model.getPolygonListe());
			}
		});
		
		TextField consoleField = new TextField();
		
		Button eingabeButton = new Button("Eingabe");
		eingabeButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				String eingabe = consoleField.getText();
				Punkt punkt;
				try {
					punkt = new Punkt(polySkript.getX(eingabe),polySkript.getY(eingabe));
					Polygon aktuellesPolygon = model.getAktuellesPolygon();
					if(aktuellesPolygon!= null){
						aktuellesPolygon.punktHinzufuegen(punkt);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				consoleField.clear();
			}
		});

		view.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				Punkt punkt = new Punkt(event.getSceneX(), event.getSceneY());
				Polygon aktuellesPolygon = model.getAktuellesPolygon();
				if(aktuellesPolygon!= null){
					aktuellesPolygon.punktHinzufuegen(punkt);
				}
			}
		});
		
		controlPane.add(setzenNeuButton, 0, 0);
		controlPane.add(polygonListView, 0, 1);
		controlPane.add(consoleField, 0, 2);
		controlPane.add(eingabeButton, 0, 3);
		
		containerContent.add(view);
		containerContent.add(controlPane);
		
		Scene scene = new Scene(container, GROESSE, GROESSE + 100);
		
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
}
