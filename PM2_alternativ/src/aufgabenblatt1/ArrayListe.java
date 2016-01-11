package aufgabenblatt1;


/**
 * BTI1-PTP/03, WS 15
 * Gruppe: Helena Lajevardi (helena.lajevardi@haw-hamburg.de)
 * 		   Lennart Hartmann (lennart.hartmann@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 1, Aufgabe 1.4
 * 
 */


/**
 * Diese Klasse repräsentiert eine ArrayList.
 * 
 * @author Lennart Hartmann
 * 		   Helena Lajevardi
 * @version 1.0
 */
public class ArrayListe<T> {
  
/**
  * Die Anzahl der Elemente.
  */	
  private int anzahlElemente;
 /**
  * Eine Liste der Elemente.
  */
  private Object[] liste;
  
 /**
  * Konstruktor.
  */
  public ArrayListe(){
	anzahlElemente = 0;  
    liste = new Object[0];	  
  }
  
 /**
  * Fuegt ein Element der Liste hinzu.
  * 
  * @param element das element das hinzugefuegt wird.
  */
  public void hinzufuegen(T element){
	anzahlElemente += 1;  
	Object[] kopie = new Object[anzahlElemente];
	for(int i=0; i<anzahlElemente-1; i++){
	  kopie[i] = liste[i];
	}
	kopie[anzahlElemente-1] = element;
	liste = kopie;
  }
  
 /**
  * Gibt das Objekt am uebergebenen Index zurueck.
  * 
  * @param index der uebergebene Index.
  * @return das Objekt am uebergebenen Index, falls vorhanden, ansonsten null.
  */
  @SuppressWarnings("unchecked")
  public Object get(int index){
	if(index < anzahlElemente){  
		return (T) liste[index];
	}
	return null;
  }
  
 /**
  * Entfernt das uebergebene Element genau einmal aus der Liste (Falls enthalten).
  * 
  * @param element das uebergebene Element.
  */
  public void entfernen(T element){
	int gesuchterIndex = -1;
	int i = 0;
	while(i<anzahlElemente){	
	  if(liste[i].equals(element)){
		gesuchterIndex = i;
		break;
	  }
	  i++;
	}
	if(gesuchterIndex != -1){
	  entferneElementAtIndex(gesuchterIndex);
	}
  }
  
 /**
  * Entfernt ein Element an der uebergebenen Position.
  * 
  * @param i die ubergebene Position.
  */
  public void entferneElementAtIndex(int i){
	//nkb aufschieben UND das letze Element entfernen 
	if(i < anzahlElemente){  
		for(int k=i; k<anzahlElemente-1; k++){
			liste[k] = liste[k+1];
		}
		liste[anzahlElemente-1]=null;
		anzahlElemente--;
	}
  }
  
 /**
  * Gibt die Anzahl der Elemente in der Liste zurueck.
  * 
  * @return die anzahl der Elemente.
  */
  public int getAnzahlElemente(){
    return anzahlElemente;
  }
  
  @Override
  public String toString(){
	String string = "";  
	if(anzahlElemente > 0){
	  for(int i=0; i<anzahlElemente; i++){
	    string += liste[i].toString()+" ";
	  }
	}
	return string;
  }
  
 /**
  * Gibt das kleinste Element einer Liste zurueck.
  * 
  * @return kleinstes Element.
  */
  @SuppressWarnings("unchecked")
public Object getKleinstesElement(){
	  Object kleinstesElement = null;
	  if(anzahlElemente > 0){
		kleinstesElement = liste[0];
		for(Object element : liste){
		  if(element.toString().compareTo(kleinstesElement.toString()) < 0){
			kleinstesElement = element;
		  }
		}
	  }
	return (T) kleinstesElement;
  }
 
}