package aufgabenblatt4_soloversion;

import java.util.Observable;
import java.util.Observer;

//import javafx.beans.InvalidationListener;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

/**
 * Bietet eine grafische Darstellung der Polygone
 * @author Helena Lajevardi, Lennart Hartmann
 * @version 9.1.2016
 */
public class PolygonDarstellung extends Canvas implements Observer {
	//Verwaltet die auszufuehrenden Darstellungsaenderungen
	private GraphicsContext grafikpuffer;
	//Wurzel des Graphen
	private BorderPane root;
	
//	private InvalidationListener listener;
	private PolygonModell polygonModell;

	/**
	 * Kostruktor
	 * @param pane  StackPane auf die die Darstellung gezeichnet wird
	 */
	public PolygonDarstellung(BorderPane pane) {
		//Instantiiert Canvas
		super(750, 525);
		
		root = pane;
		pane.getChildren().add(this);
		
		//Bindet diese Darstellung an den Puffer
		grafikpuffer = getGraphicsContext2D();
		grafikpuffer.setFill(Color.gray(0.95));
		
//		pane.getChildren().add(this);
		
//		listener = new InvalidationListener() {
//
//			@Override
//			public void invalidated(javafx.beans.Observable observable) {
//				
//				//clearScreen();
//				zeichnePolygon(polygonModell.getPolygon());
//				zeichneFertigePolygone();
//				
//				setFenster();
//				if (polygonModell != null) {
//					zeichnePolygon(polygonModell.getPolygon());
//				}
//			}
//		};
//		root.widthProperty().addListener(listener);
//		root.heightProperty().addListener(listener);

		addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				Polygon aktuellesPolygon = polygonModell.getPolygon();
				aktuellesPolygon.setPunkt(event.getX(), event.getY());
				event.consume();
			}
		});
	}

	@Override
	public void update(Observable o, Object arg) {
		//clearScreen();
		zeichnePolygon(polygonModell.getPolygon());
		zeichneFertigePolygone();
	}
	
	/**
	 * Methode zum anpassen der Groesse des Zeichenfensters
	 */
	public void setFenster() {
		setWidth(root.getLayoutBounds().getWidth());
		setHeight(root.getLayoutBounds().getHeight());
	}

	/**
	 * Methode zum zeichnen eines Polygons
	 * @param polygon  Das zu zeichnende Polygon
	 */
	public synchronized void zeichnePolygon(Polygon polygon) {
		zeichnePolygon(polygon, Color.RED);
	}

	/**
	 * Zeichnet ein gegebenes Polygon in der gewuenschten Farbe
	 * @param polygon  Das zu zeichnende Polygon
	 */
	private synchronized void zeichnePolygon(Polygon polygon, Color color) {
		if (polygon != null) {
			grafikpuffer.setStroke(color);

			for (int i = 0; i < polygon.getPunktliste().size(); i++) {
				double x1 = polygon.getXPosZuEcke(i);
				double y1 = polygon.getYPosZuEcke(i);
				double x2, y2;
				
				grafikpuffer.strokeOval(x1 - 2.5, y1 - 2.5, 5, 5);
				if (i + 1 >= polygon.getPunktliste().size()) {
					x2 = polygon.getXPosZuEcke(i);
					y2 = polygon.getYPosZuEcke(i);
				} else {
					x2 = polygon.getXPosZuEcke(i + 1);
					y2 = polygon.getYPosZuEcke(i + 1);
				}
				grafikpuffer.strokeLine(x1, y1, x2, y2);
			}
		}
	}
	
	public void zeichneFertigePolygone() {
		for (int i = 0; i < polygonModell.getListePolygone().size(); i++) {
			zeichnePolygon(polygonModell.getListePolygone().get(i), Color.BLACK);
		}
	}

	/**
	 * Methode zum Waehlen des Polygonmodells
	 * @param polygonModell  Das zu verknuepfende Polygonmodell
	 */
	public synchronized void setPolygonModell(PolygonModell polygonModell) {
		this.polygonModell = polygonModell;
	}

	/**
	 * Getter
	 */
	public PolygonModell getPolygonmodell() {
		return polygonModell;
	}
}
