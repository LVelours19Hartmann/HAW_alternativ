package aufgabenblatt1;

import static org.junit.Assert.*;

import org.junit.Test;

public class StudentTest {

	@Test
	public void testStudent(){
		Student st = new Student("Ab", "Cd", 123);
		assertEquals("Falscher Vorname", "Ab", st.getVorname());
		assertEquals("Falscher Nachname", "Cd", st.getNachname());
		assertEquals("Falsche Matrikelnummer",123, st.getMatrikelnummer());
	}
	
	@Test
	public void testToString() {
		  Student std=new Student("Max","Mustermann", 2355456);
		  std.addPruefungsleistung(new Pruefungsleistung("MG", 15));
		  std.addPruefungsleistung(new Pruefungsleistung("GE1", 15));
		
		assertEquals("Falsche Textausgabe", "Max Mustermann\n2355456\nPruefungsleistungen:"
				+ "\nMG | 15 Punkte\nGE1 | 15 Punkte", std.toString());
	}
	
	@Test
	public void testAddPruefungsleistung(){
		Student std = new Student("Max","Mustermann", 2355456);
		Pruefungsleistung pruefung = new Pruefungsleistung("Testpruefung", 15); 
		
		std.addPruefungsleistung(pruefung);
		assertTrue("Pruefung nicht enthalten!",std.getPruefungsleistungen().contains(pruefung));
	}
	
	@Test
	public void testCompareTo(){
		Student st1 = new Student("A", "B", 45756);
		Student st2 = new Student("C", "D", 45756);
		Student st3 = new Student("E", "F", 45856);
		assertTrue("Fehler bei gleichheit", st1.compareTo(st2) == 0);
		assertTrue("Fehler bei Student1 < Student2", st1.compareTo(st3) < 0);
		assertTrue("Fehler bei Student1 < Student2", st3.compareTo(st1) > 0);
	}
}
