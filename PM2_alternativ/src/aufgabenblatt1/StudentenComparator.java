package aufgabenblatt1;

import java.util.Comparator;

/**
 * BTI1-PTP/03, WS 15
 * Gruppe: Helena Lajevardi (helena.lajevardi@haw-hamburg.de)
 * 		   Lennart Hartmann (lennart.hartmann@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 1, Aufgabe 1.2
 * 
 */


/**
 * Diese Klasse repraesentiert einen Comparator fuer Studenten.
 * 
 * @author Lennart Hartmann
 * 		   Helena Lajevardi
 * @version 1.0
 */
public class StudentenComparator implements Comparator<Student>{

	@Override
	public int compare(Student student1, Student student2) {
	  int rueckgabe = 0;
	  rueckgabe = student1.getNachname().compareTo(student2.getNachname());
	  if(rueckgabe == 0){
		rueckgabe = student1.getVorname().compareTo(student2.getVorname());  
	  }
	  return rueckgabe;
  }
}
