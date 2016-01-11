/**
 * BTI1-PTP/03, WS 15
 * Gruppe: Helena Lajevardi (helena.lajevardi@haw-hamburg.de)
 * 		   Lennart Hartmann (lennart.hartmann@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 2, Aufgabe 2.3
 * 
 */

package aufgabenblatt2;

/**
 * Simmuliert einen Rennwagen
 * @author Helena Lajevardi, Lennart Hartmann
 * @version 14.11.2015
 *
 */
public class Rennauto extends Thread{
	/**
	 * Laufende Nummer zur eindeutigen Kennzeichnung von Autos
	 */
	private static int id = 1;
	
	/**
	 * Bezeichner des Autos
	 */
	private String name;
	
	/**
	 * Mittlere Geschwindigkeit in m/s
	 */
	private double durchschnittsgeschwindigkeit;
	
	/**
	 * Die Laenge der befahrenen Rennstrecke
	 */
	private double laengeDerRennstrecke;
	
	/**
	 * Die bis zum aktuellen Zeitpunkt zurueckgelegte Strecke in Metern
	 */
	private double aktuellePosition;
	
	/**
	 * Der Zeitpunkt des Rennstarts
	 */
	private double startzeitpunkt;
	
	/**
	 * Die Gesamtzeit, die zum Absolvieren des Kurses/ bis zum Rennabbruch vergangen ist
	 */
	private double benoetigteZeit =-1;
	
	public Rennauto(double durchschnittsgeschwindigkeit, Rennstrecke strecke){
		name = "Wagen"+id;
		id++;
		this.durchschnittsgeschwindigkeit = durchschnittsgeschwindigkeit;
		laengeDerRennstrecke = strecke.LAENGE;
		startzeitpunkt = System.currentTimeMillis();
	}
	
	/**
	 * Steuert den Rennfortschritt
	 */
	@Override
	public void run(){
		startzeitpunkt = System.currentTimeMillis();
		while(aktuellePosition<laengeDerRennstrecke && !interrupted()){
			
			int dT = 800 + (int)(400*Math.random());
			try{
				Thread.sleep(dT);
			}catch(InterruptedException e){
//				e.printStackTrace();
				interrupt();
				
			}
			aktuellePosition += durchschnittsgeschwindigkeit*1;
			System.out.format("Position von "+getBez()+": %.3f m       dt/[ms] = %d\n",aktuellePosition, dT);
		}
		benoetigteZeit = System.currentTimeMillis()-startzeitpunkt;
	}
	
	/**
	 * Liefert die seit Rennstart zurueckgelegte Distanz
	 * @return	die zuruckgelegte Distanz in Metern
	 */
	public double getAktuelleRosition(){
		return aktuellePosition;
	}
	
	/**
	 * Liefert die Bezeichnung des Rennwagens
	 * @return der Bezeichner des Rennwagens
	 */
	public String getBez(){
		return name;
	}
	
	/**
	 * Liefert nach ende des Rennen die benoetigte Zeit bis zum Ziel/Rennabbruch
	 * sonst -1
	 * @return	die Zeit bis zum Rennende
	 */
	public double getBenoetigteZeit(){
		return benoetigteZeit;
	}
}
