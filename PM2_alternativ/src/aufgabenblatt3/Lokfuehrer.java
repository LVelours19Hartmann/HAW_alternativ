/**
 * BTI1-PTP/03, WS 15
 * Gruppe: Helena Lajevardi (helena.lajevardi@haw-hamburg.de)
 * 		   Lennart Hartmann (lennart.hartmann@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 3
 * 
 */
package aufgabenblatt3;

import java.util.Random;

/**
 * Repraesentiert einen Lokfuehrer, der einen Zug entweder einfaehrt oder ausfaehrt.
 * 
 * @author Helena Lajevardi, Lennart Hartmann
 */
public class Lokfuehrer extends Thread{
	
	/**
	 * Legt fest, ob ein Zug ein- oder ausgefahren wird.
	 */
	public final boolean faehrtEin;
	
	/**
	 * Der Zielbahnhof.
	 */
	public final Rangierbahnhof bhf;
	
	/**
	 * Das Gleis auf den der Zug eingefahren oder ausgefahren werden soll.
	 */
	public final int gleisNr;
	
	/**
	 * Konstruktor.
	 */
	public Lokfuehrer(boolean faehrtEin, Rangierbahnhof bhf){
		this.faehrtEin=faehrtEin;
		this.bhf=bhf;
		Random zufall = new Random();
		gleisNr = zufall.nextInt(Rangierbahnhof.ANZ_GLEISE);
	}
	
	@Override
	public void run(){
		if(faehrtEin){
			zugEinfahren();
		}else{
			zugAusfahren();
		}
	}
	
	/**
	 * Versuche einen neuen Zug einfahren zu lassen.
	 */
	private void zugEinfahren(){
		System.err.println("Versucht Zug auf Gleis "+gleisNr+" aunzufahren.");
		try{
			bhf.einfahren(gleisNr, new Zug());
			}catch(IllegalAccessException e){
				System.err.println(e.getMessage());
		}
	}
	
	/**
	 * Versuche einen Zug vom Gleis auszufahren.
	 */
	private void zugAusfahren(){
		System.err.println("Versucht Zug von Gleis "+gleisNr+" auszufahren.");
		try{
			bhf.ausfahren(gleisNr);
			}catch(IllegalAccessException e){
				System.err.println(e.getMessage());
			}
	}
	
	@Override
	public String toString(){
		return this.getName()+" faehrt Zug ein: "+ faehrtEin+"  Auf Gleis Nr.: "+gleisNr+"  Bahnhof:"+bhf;
	}
	
}

