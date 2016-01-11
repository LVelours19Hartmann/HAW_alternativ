/**
 * BTI1-PTP/03, WS 15
 * Gruppe: Helena Lajevardi (helena.lajevardi@haw-hamburg.de)
 * 		   Lennart Hartmann (lennart.hartmann@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 2, Aufgabe 2.3
 * 
 */

package aufgabenblatt2;

/**
 * Repraesentiert Kontrollthreads fuer Simulierte Autorennen. Fuehrt mit bestimmter Wahrscheinlichkeit
 * Rennabbrueche herbei
 * @author Helena Lajevardi, Lennart Hartmann
 * @version 14.11.2015
 *
 */
public class Rennabbruch extends Thread{
	/**
	 * Die kontrollierte Rennstrecke
	 */
	Rennstrecke strecke;
	
	public Rennabbruch(Rennstrecke strecke) {
		this.strecke=strecke;
	}
	
	/**
	 * Die Rennabbruchsteuerung
	 */
	@Override
	public void run(){
		while(Math.random() < 1.0 && !interrupted()){
			
			System.err.println("pruefe Abbruchbedingung");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
//				break;
//				e.printStackTrace();
				this.interrupt();
			}
		}
		strecke.brecheRennenAb();
	}
}
