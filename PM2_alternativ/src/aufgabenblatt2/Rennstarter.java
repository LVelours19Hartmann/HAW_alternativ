/**
 * BTI1-PTP/03, WS 15
 * Gruppe: Helena Lajevardi (helena.lajevardi@haw-hamburg.de)
 * 		   Lennart Hartmann (lennart.hartmann@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 2, Aufgabe 2.3
 * 
 */

package aufgabenblatt2;

/**
 * Klasse zum Sterten von simulierten Rennen
 * @author Helena Lajevardi, Lennart Hartmann
 * @version 14.11.2015
 */
public class Rennstarter {
	
	/**
	 * Fuegt einem Rennen Teilnehmer hinzu und startet es
	 * @param args nichts
	 */
	public static void main(String[] args) {
		
		Rennstrecke strecke = new Rennstrecke();
			
		//Rennautos erzeugen und an Rennstrecke übergeben
		for(int i=0; i<5; i++){
			strecke.addTeilnehmer(new Rennauto(50, strecke));
		}
		strecke.starteRennen();
	}
}
