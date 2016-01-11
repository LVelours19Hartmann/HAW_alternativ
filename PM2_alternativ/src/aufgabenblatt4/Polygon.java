/**
 * BTI1-PTP/03, WS 15
 * Gruppe: Helena Lajevardi (helena.lajevardi@haw-hamburg.de)
 *         Lennart Hartmann (lennart.hartmann@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 4
 * 
 */
package aufgabenblatt4;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;


/**
 * Repraesentiert ein Polygon.
 * 
 * @author Helena Lajevardi, Lennart Hartmann
 */
public class Polygon extends Observable {
	
	/**
	 * Eine Liste der Polygonpunkte.
	 */
	private List<Punkt> punkte;
	
	/**
	 * Die Bezeichnung fuer das Polygon.
	 */
	private String name;
	
	/**
	 * Konstruktor.
	 */
	public Polygon() {
		this.punkte = new ArrayList<Punkt>();
	}
	
	/**
	 * Fuegt dem Polygon einen neuen Punkt hinzu.
	 * 
	 * @param punkt der neue Punkt der hinzugefuegt werden soll.
	 */
	public void punktHinzufuegen(Punkt punkt){
		punkte.add(punkt);
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Verschiebt einen Punkt im Polygon um die angegebenen Koordinaten.
	 * 
	 * @param punkt der Punkt der verschoben werden soll.
	 * @param x die X-Koordinate, um die der Punkt verschoben werden soll.
	 * @param y die Y-Koordinate, um die der Punkt verschoben werden soll.
	 */
	public void punktVerschieben(Punkt punkt,int x, int y){
		//todo: um fehlende Anweisungen ergnzen
		setChanged();
		notifyObservers();
	}

	/**
	 * Getter.
	 */
	public List<Punkt> getPunkte() {
		return punkte;
	}
	
	@Override
	public String toString() {
		return name = "Polygon mit " + punkte.size() + " Punkten";
	}

	
	
	
	

}
