package aufgabenblatt1;

/**
 * BTI1-PTP/03, WS 15
 * Gruppe: Helena Lajevardi (helena.lajevardi@haw-hamburg.de)
 * 		   Lennart Hartmann (lennart.hartmann@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 1, Aufgabe 1.4
 * 
 */

/**
 * Diese Klasse repräsentiert ein Werkzeug mit Hilfsmethoden für Listen.
 * 
 * @author Lennart Hartmann
 * 		   Helena Lajevardi
 * @version 1.0
 */
public class ListenTool {
	
  /**
   * Prueft, ob das erste Element einer Liste eine Zahl ist.
   * 
   * @param liste die zu pruefende Liste.
   * @return wahr, wenn erstes Element eine Zahl ist, ansonsten falsch.
   */
  public static <T> boolean istErstesElementZahl(ArrayListe<T> liste){
	if(liste.getAnzahlElemente()>0){
	  return liste.get(0) instanceof Number;
	}
	return false;
  }
  
  /**
   * Bildet die Summe der Zahlen in einer Liste mit ganzzahlen.
   * 
   * @param liste die Liste mit ganzzahlen, in der die Summe aus den Zahlen gebildet werden soll.
   * @return die Summe aus den Zahlen.
   */
  public static int bildeSumme(ArrayListe<Integer> liste){
	int summe = 0;
	int anzElemente = liste.getAnzahlElemente();
	if(anzElemente > 0){
	  for(int i=0; i<anzElemente; i++){
		summe += (Integer)liste.get(i);
	  }
	}
	return summe;
  }
}