package aufgabenblatt4a;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Klasse zum Modellieren eines Polygons
 * 
 * @author Helena Lajevardi, Lennart Hartmann
 *
 */
public class PolygonModell extends Observable implements Observer {
	/**
	 * Liste der Polygone
	 */
	private List<Polygon> polygone = new ArrayList<Polygon>();
	private Polygon aktuellesPolygon;

	/**
	 * Methode zum abschliessen der Bearbeitung eines Polygons
	 */
	public void finalisiereBearbeitung() {
		aktuellesPolygon.toString();
		polygone.add(aktuellesPolygon);
		aktuellesPolygon = new Polygon(this);
//		aktuellesPolygon= new Polygon();
//		aktuellesPolygon.addObserver(this);
		setChanged();
		notifyObservers();
	}

	/**
	 * Kostruktor
	 */
	public PolygonModell(Observer o) {
		aktuellesPolygon = new Polygon(this);
//		aktuellesPolygon=new Polygon();
//		aktuellesPolygon.addObserver(this);
		this.addObserver(o);
	}

	/**
	 * Default Konstruktor, nur fuer die Testklasse geeignet
	 */
	public PolygonModell() {
		aktuellesPolygon = new Polygon(this);
//		aktuellesPolygon = new Polygon();
//		aktuellesPolygon.addObserver(this);
	}

	/**
	 * Kostruktor
	 * 
	 * @param polygon  Referenz auf das zu bearbeitende Polygon
	 */
	public PolygonModell(Polygon polygon) {
		aktuellesPolygon = polygon;
	}

	/**
	 * Getter
	 * 
	 * @return Gibt das aktuelle zu bearbeitende Polygon zurueck
	 */
	public Polygon getPolygon() {
		return aktuellesPolygon;
	}

	/**
	 * Getter
	 * 
	 * @return Gibt die Liste der Polygone zurueck
	 */
	public List<Polygon> getListePolygone() {
		return polygone;
	}

	@Override
	public String toString() {
		return "Anzahl der Polygone in der Liste: " + polygone.size() + ", aktuelles " + aktuellesPolygon.toString();
	}

	@Override
	public void update(Observable o, Object arg) {
		setChanged();
		notifyObservers();
	}

}