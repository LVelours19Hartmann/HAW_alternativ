/**
 * BTI1-PTP/03, WS 15
 * Gruppe: Helena Lajevardi (helena.lajevardi@haw-hamburg.de)
 * 		   Lennart Hartmann (lennart.hartmann@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 3
 * 
 */
package aufgabenblatt3;

import java.util.Observable;

import aufgabenblatt3.Zug;
/**
 * Repraesentiert einen Rangierbahnhof.
 * 
 * @author Helena Lajevardi, Lennart Hartmann
 */
public class Rangierbahnhof extends Observable{
	
	/**
	 * Die Anzahl der Gleise im Rangierbahnhof.
	 */
	public static final int ANZ_GLEISE = 3;
	
	/**
	 * Eine Liste der Gleise fuer die Belegung der Gleise durch Zuege.
	 */
	Zug[] gleise = new Zug[ANZ_GLEISE];
	
	/**
	 * Laesst einen Zug einfahren.
	 * 
	 * @param gleisNr	die Nr des zu belegenden Gleises.
	 * @param zug		der einfahrende Zug.
	 * @throws IllegalAccessException 
	 */
	public synchronized void einfahren(int gleisNr, Zug zug) throws IllegalAccessException{
		if (gleisNr>ANZ_GLEISE || gleisNr<0){
			throw new IllegalAccessException("Es existiert kein Gleis mit der angegegbenen Nummer");
		}
		//solange Gleis besetzt ist
		while(gleise[gleisNr]!=null){
			System.err.println("Gleis besetzt");
			try{
				this.wait();
			}catch(InterruptedException e){
				Thread.currentThread().interrupt();
				return;
			}
		}
		//Zug auf Gleis abstellen
		gleise[gleisNr]=zug;
		System.err.println("Zug auf Gleis "+gleisNr+" eingefahren");
		try{
			Thread.sleep(500);		
		}catch(InterruptedException e){
		}
		this.notifyAll();
		//neu
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Laesst einen Zug ausfahren.
	 * 
	 * @param gleisNr	die Nummer des Gleises, von welchem der Zug abfahren soll.
	 * @return			der ausfahrende Zug, null falls Gleis nicht belegt.
	 * @throws IllegalAccessException 
	 */
	public synchronized Zug ausfahren(int gleisNr) throws IllegalAccessException{
		if (gleisNr>ANZ_GLEISE || gleisNr<0){
			throw new IllegalAccessException("Es existiert kein Gleis mit der angegegbenen Nummer");
		}
		//solange kein Zug auf dem Gleis
		while(gleise[gleisNr]==null){
			System.err.println("Kein Zug auf diesem Gleis.");
			try{
				this.wait();
			}catch(InterruptedException e){
				Thread.currentThread().interrupt();
				return null;
			}
		}
		//Zug auswaehlen und vom Gleis entfernen
		Zug zug = gleise[gleisNr];
		gleise[gleisNr]=null;
		
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
		}
		
		System.err.println("Zug auf Gleis"+gleisNr+" faehrt aus.");
		this.notifyAll();
		//neu
		setChanged();
		notifyObservers();
		//end neu
		return zug;
	}
	
	/**
	 * Pueft, ob Gleis belegt ist.
	 * 
	 * @param gleisNr	die Nummer des zu pruefenden Gleises.
	 * @return			belegt, oder nicht belegt.
	 * @throws IllegalAccessException 
	 */
	public boolean istBelegt(int gleisNr) throws IllegalAccessException{
		
		if (gleisNr>ANZ_GLEISE || gleisNr<0){
			throw new IllegalAccessException("Es existiert kein Gleis mit der angegegbenen Nummer");
		}
		if (gleise[gleisNr]!=null){
			return true;
			}
		return false;
	}
}

