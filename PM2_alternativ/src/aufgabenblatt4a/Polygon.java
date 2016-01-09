package aufgabenblatt4a;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Klasse zum verwalten einer Liste mit Punkten fuer ein entsprechendes Polygon
 * 
 * @author grimmilenko
 *
 */
public class Polygon extends Observable {
	/**
	 * Innere Klasse zur Bestimmung der x- und y- Koordinate eines Punktes des
	 * Polygons
	 * 
	 * @author Helena Lajevardi, Lennart Hartmann
	 * @version 8.1.2016
	 */
	private class Punkt {
		private double xPos;
		private double yPos;

		/**
		 * Konstruktor
		 * @param xPos   x-Koordinate eines Punktes des Polygons
		 * @param yPos	 y-Koordinate eines Punktes des Polygons
		 */
		public Punkt(double xPos, double yPos) {
			this.xPos = xPos;
			this.yPos = yPos;
		}
	}

	/**
	 * Konstruktor
	 * 
	 * @param observer 	ein Observer
	 */
	public Polygon(Observer observer) {
		punkte = new ArrayList<Punkt>();
		addObserver(observer);
	}

	/**
	 * Liste der Punkte
	 */
	private List<Punkt> punkte;

	private String beschreibung;

	/**
	 * Getter
	 * 
	 * @return Gibt die Liste der Punkte zurueck
	 */
	public List<Punkt> getPunktliste() {
		return punkte;
	}

	/**
	 * Setter
	 *
	 * @param x
	 *            x-Koordinate die der Punkt bekommen soll
	 * @param y
	 *            y-Koordinate die der Punkt bekommen soll
	 */
	public void setPunkt(double x, double y) {
		punkte.add(new Punkt(x, y));
		setChanged();
		notifyObservers();
	}

	/**
	 * Getter
	 */
	public double getXPosZuEcke(int index) throws IndexOutOfBoundsException {
		if (index >= 0 && index < punkte.size()) {
			return punkte.get(index).xPos;
		} else {
			throw new IndexOutOfBoundsException("Polygon hat keien Ecke mit diesem Index");
		}
	}

	/**
	 * Getter
	 */
	public double getYPosZuEcke(int index) throws IndexOutOfBoundsException {
		if (index >= 0 && index < punkte.size()) {
			return punkte.get(index).yPos;
		} else {
			throw new IndexOutOfBoundsException("Polygon hat keien Ecke mit diesem Index");
		}
	}

	@Override
	public String toString() {
		String punkteAnz = Integer.toString(punkte.size());
		if (punkte.size() > 1 || punkte.size() == 0) {
			punkteAnz += " Punkten";
		} else {
			punkteAnz += " Punkt";
		}
		beschreibung = "Polygon mit " + punkteAnz;
		return beschreibung;
	}

	/**
	 * Getter
	 */
	public String getInfo() {
		//return beschreibung;
		return toString();
	}

}