package aufgabenblatt1;

/**
 * BTI1-PTP/03, WS 15
 * Gruppe: Helena Lajevardi (helena.lajevardi@haw-hamburg.de)
 * 		   Lennart Hartmann (lennart.hartmann@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 1, Aufgabe 1.2
 * 
 */


/**
 * Diese Klasse repräsentiert eine Pruefungsleistung.
 * 
 * @author Lennart Hartmann
 * 		   Helena Lajevardi
 * @version 1.0
 */
public class Pruefungsleistung {
	
   /**
	* Der Name des Moduls.
	*/
	private final String modulname;
	
	/**
	 * Die Note des Moduls in Punkten.
	 */
	private final int note;
	
   /**
    * Im Konstruktor werden die Objektvariablen initialisiert.
	* 
	* @param modulname
	*            Initialisierungswert fuer den Namen des Moduls.
	* 
	* @param note
	*            Initalisierungswert fuer die Note.
	* 
	*/
	public Pruefungsleistung(String modulname, int note){
		this.modulname = modulname;
		this.note=note;	
	}
	
   /**
	* Getter.
	*/
	public String getModulname() {
		return modulname;
	}

	public int getNote() {
		return note;
	}

}
