/**
 * BTI1-PTP/03, WS 15
 * Gruppe: Helena Lajevardi (helena.lajevardi@haw-hamburg.de)
 * 		   Lennart Hartmann (lennart.hartmann@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 3
 * 
 */
package aufgabenblatt3;
import java.util.Observable;
import java.util.Random;

/**
 * Repraesentiert eine Klasse zur Simulation eines Rangierbahnhofs.
 * 
 * @author Helena Lajevardi, Lennart Hartmann
 */
public class Simulation extends Observable implements Runnable{
	
	/**
	* Der simulierte Rangierbahnhof.
	*/
	public final Rangierbahnhof bhf;
	
	/**
	* Legt die Aufgabe des Lokfuherers per Zufall fest.
	*/
	private Random zufall;
	
	/**
	* Legt fest, ob die Simulation laeuft.
	*/
	private boolean runnning;
	
	public Simulation() {
		
		bhf = new Rangierbahnhof();
		zufall = new Random();
		runnning = true;
	}

	@Override
	public void run() {
		while(runnning){
			setChanged();
			notifyObservers();
			Lokfuehrer lokfuehrer = new Lokfuehrer(zufall.nextBoolean(), bhf);
			System.err.println("Neuer Lokfuehrer erzeugt.");
			lokfuehrer.start();
			try{
				Thread.sleep(500);
			}catch(InterruptedException e){
			}
		}
	}
	
	/**
	* Beendet die Simulation.
	*/
	public void beenden(){
		runnning=false;
	}
	
}
