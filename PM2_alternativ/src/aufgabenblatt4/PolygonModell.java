/**
 * BTI1-PTP/03, WS 15
 * Gruppe: Helena Lajevardi (helena.lajevardi@haw-hamburg.de)
 *         Lennart Hartmann (lennart.hartmann@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 4
 * 
 */
package aufgabenblatt4;

import java.util.Observable;
import java.util.Observer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Repraesentiert ein Polygonmodell zur Verwaltung von Polygonen.
 * 
 * @author Helena Lajevardi, Lennart Hartmann
 */
public class PolygonModell extends Observable implements Observer{
	
	/**
	 * Das aktuelle Polygon.
	 */
	private Polygon aktuellesPolygon;
	
	/**
	 * Eine Liste der bearbeiteten Polygone.
	 */
	private ObservableList<Polygon> polygonListe;
	
	/**
	 * Konstruktor.
	 */
	public PolygonModell() {
		polygonListe = FXCollections.observableArrayList();
		aktuellesPolygon = new Polygon();
		aktuellesPolygon.addObserver(this);
	}
	
	/**
	 * Schliesst die Bearbeitung des aktuellen Polygons ab.
	 */
	public void polygonBearbeitungAbschliessen(){
		this.polygonListe.add(this.aktuellesPolygon);
		this.aktuellesPolygon = new Polygon();
		aktuellesPolygon.addObserver(this);
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Getter & Setter.
	 */
	public ObservableList<Polygon> getPolygonListe() {
		return polygonListe;
	}

	public Polygon getAktuellesPolygon() {
		return aktuellesPolygon;
	}

	public void setAktuellesPolygon(Polygon aktuellesPolygon) {
		this.aktuellesPolygon = aktuellesPolygon;
	}

	@Override
	public void update(Observable o, Object arg) {
		setChanged();
		notifyObservers();
	}

}
