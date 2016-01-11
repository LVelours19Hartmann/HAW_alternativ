/**
 * BTI1-PTP/03, WS 15
 * Gruppe: Helena Lajevardi (helena.lajevardi@haw-hamburg.de)
 * 		   Lennart Hartmann (lennart.hartmann@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 2, Aufgabe 2.3
 * 
 */

package aufgabenblatt2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Repraesentiert eine Renstrecke mit Rennleitung
 * @author Helena Lajevardi, Lennart Hartmann
 * @version 14.11.2015
 *
 */
public class Rennstrecke{
	
	/**
	 * Die gesamtlaenge des Rennens in Metern
	 */
	public final double LAENGE;
	
	/**
	 * Rennen abgebrochen oder nicht
	 */
	boolean abgebrochen=false;
	
	/**
	 * die Teilnehmer des Rennens
	 */
	List<Rennauto> rennautos;
	
	/**
	 * Thread der Rennabbrueche kontrolliert
	 */
	Thread beender;
	
	public Rennstrecke(){
		this(1000);
	}
	
	public Rennstrecke(double laenge){
		rennautos = new ArrayList<Rennauto>();
		beender = new Rennabbruch(this);		
		this.LAENGE=laenge;
	}
	
	/**
	 * Laest die Rennwagen starten
	 */
	public void starteRennen(){
		if(rennautos.size()==0){
			System.err.println("Rennen hat keine Teilnehmer!");
			return;
		}

		//Threads starten
		for(Rennauto auto : rennautos){
			auto.start();
		}
		beender.start();
		
		//auf beenden der Rennauto-Threads warten
		for(Rennauto auto: rennautos){
			try {
				auto.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		beender.interrupt();
		zeigeErgebnisse();
	}
	
	/**
	 * bricht das Rennen ab
	 */
	public void brecheRennenAb(){
		for(Rennauto auto : rennautos){
			auto.interrupt();
		}
	beender.interrupt();
		abgebrochen = true;
	}
	
	/**
	 * Fuegt dem Wettbewerb einen weiteren Teilnehmer hinzu
	 * @param auto	der Rennwagen des Teilnehmers
	 */
	public void addTeilnehmer(Rennauto auto){
		rennautos.add(auto);
	}
	
	/**
	 * Zeigt Platzierung der Teilnehmer:
	 * Sortiert nach Rundenzeit bei regulaerem Rennabschluss
	 * Sortiert nach Position bei Rennabbruch sonst
	 */
	public void zeigeErgebnisse(){
		if(abgebrochen){
			System.err.println("Rennen abgebrochen\nPositionierung bei Rennabbruch:");
			Collections.sort(rennautos, (auto1,auto2) -> auto1.getAktuelleRosition() > auto2.getAktuelleRosition() ? 1 : -1);
			System.err.println("Ergebnis:");
			
			for(int i=0; i<rennautos.size();i++){
				System.err.format("%d. %s\n",i+1,rennautos.get(i).getBez());
			}
		}else{
			Collections.sort(rennautos, (auto1,auto2) -> auto1.getBenoetigteZeit() > auto2.getBenoetigteZeit() ? 1 : -1);
			System.err.println("Rennen erfolgreich abgeschlossen\nErgebnis:");
			for(Rennauto auto:rennautos){
				System.err.format("%s:  %.1f sek\n",auto.getBez(),auto.getBenoetigteZeit()/1000);
			}
		}
	}
}
