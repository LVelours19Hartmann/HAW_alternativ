package aufgabenblatt1;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayListeTest {

	
	@Test
	public void testArrayListe(){
		ArrayListe<Object> liste = new ArrayListe<>();
		assertTrue("Objekt nicht erzeugt", liste != null);
		assertEquals("Falsche \"anzElemente\" bei Erzeugung",0,liste.getAnzahlElemente());
	}
	
	@Test
	public void testGetAnzahlElemente(){
		String el0 = "element0";
		String el1 = "element1";
		String el2 = "element2";
		ArrayListe<String> lst = new ArrayListe<String>();
		assertEquals("Falsche Angabe Abtahl bei 0 Elementen", 0, lst.getAnzahlElemente());
		lst.hinzufuegen(el0);
		assertEquals("Falsche Angabe Abtahl bei 0 Elementen", 1, lst.getAnzahlElemente());
		lst.hinzufuegen(el1);
		assertEquals("Falsche Angabe Abtahl bei 0 Elementen", 2, lst.getAnzahlElemente());
		lst.hinzufuegen(el2);
		assertEquals("Falsche Angabe Abtahl bei 0 Elementen", 3, lst.getAnzahlElemente());
	}
	
	@Test
	public void testHinzufuegen(){
		ArrayListe<String> lst = new ArrayListe<String>();
		assertEquals("Falsche \"anzElemente\" nach Initialisierung",0, lst.getAnzahlElemente());
		lst.hinzufuegen("elementA");
		assertEquals("Falsche \"anzElemente\" bei 1 hinzugefuegtem Element",1, lst.getAnzahlElemente());
		lst.hinzufuegen("elementB");
		assertEquals("Falsche \"anzElemente\" bei 2 hinzugefuegtem Element",2, lst.getAnzahlElemente());
		lst.hinzufuegen("elementC");
		assertEquals("Falsche \"anzElemente\" bei 3 hinzugefuegtem Element",3, lst.getAnzahlElemente());
	}
	
	@Test 
	public void testGet(){
		
		ArrayListe<String> lst = makeArrayListe();
		assertEquals("Keine Rueckgabe von null bei ungueltigem Index", null, lst.get(3));
		assertTrue("Falsches Element an Index 0",lst.get(0).equals("elementB"));
		assertTrue("Falsches Element an Index 1",lst.get(1).equals("elementA"));
		assertTrue("Falsches Element an Index 2",lst.get(2).equals("elementC"));
	}
	
	@Test
	public void testEntfernen(){
		String el0 = "element0";
		String el1 = "element1";
		String el2 = "element2";
		ArrayListe<String> lst = new ArrayListe<String>();
		lst.hinzufuegen(el0);
		lst.hinzufuegen(el1);
		lst.hinzufuegen(el2);
		lst.entfernen("ungueltigesElement");
		assertEquals("Fehler bei nicht enthaltenem Element", 3, lst.getAnzahlElemente());
		lst.entfernen(el0);
		assertTrue("Fehler beim entfernen des nullten Elements", lst.getAnzahlElemente() == 2 && lst.get(0).equals(el1) );
		lst.entfernen(el2);
		assertTrue("Fehler beim entfernen des letzten Elements", lst.getAnzahlElemente() == 1 && lst.get(0).equals(el1) );
	}
	
	@Test
	public void testEntferneElementAtIndex(){
		String el0 = "element0";
		String el1 = "element1";
		String el2 = "element2";
		ArrayListe<String> lst = new ArrayListe<String>();
		lst.hinzufuegen(el0);
		lst.hinzufuegen(el1);
		lst.hinzufuegen(el2);
		lst.entferneElementAtIndex(4);
		assertEquals("Fehler bei nicht enthaltenem Element", 3, lst.getAnzahlElemente());
		lst.entferneElementAtIndex(0);
		assertTrue("Fehler beim entfernen des nullten Elements", lst.getAnzahlElemente() == 2 && lst.get(0).equals(el1) );
		lst.entferneElementAtIndex(1);
		assertTrue("Fehler beim entfernen des letzten Elements", lst.getAnzahlElemente() == 1 && lst.get(0).equals(el1) );
	}
	
	@Test
	public void testToString(){
		String el0 = "element0";
		String el1 = "element1";
		String el2 = "element2";
		ArrayListe<String> lst = new ArrayListe<String>();
		assertEquals("Falsche String bei 0 Elementen", "", lst.toString());
		lst.hinzufuegen(el0);
		assertEquals("Falsche String bei 1 Elementen", el0 + " ", lst.toString());
		lst.hinzufuegen(el1);
		assertEquals("Falsche String bei 2 Elementen", el0+ " " + el1 + " ", lst.toString());
		lst.hinzufuegen(el2);
		assertEquals("Falsche String bei 3 Elementen", el0+ " " + el1 + " " + el2 +" ", lst.toString());
	}
	
	@Test
	public void testGetKleinstesElement(){
		ArrayListe<String> lst = new ArrayListe<>();
		lst.hinzufuegen("elementB");
		lst.hinzufuegen("elementA");
		lst.hinzufuegen("elementC");
		assertEquals("Falsches Element zurueckgegeben bei 2.Stelle","elementA" ,lst.getKleinstesElement());
		
		lst = new ArrayListe<>();
		lst.hinzufuegen("elementA");
		lst.hinzufuegen("elementB");
		lst.hinzufuegen("elementC");
		assertEquals("Falsches Element zurueckgegeben bei 1.Stelle","elementA" ,lst.getKleinstesElement());
		
		lst = new ArrayListe<>();
		lst.hinzufuegen("elementC");
		lst.hinzufuegen("elementB");
		lst.hinzufuegen("elementA");
		assertEquals("Falsches Element zurueckgegeben bei letzter Stelle","elementA" ,lst.getKleinstesElement());
	}
	
	private ArrayListe<String> makeArrayListe(){
		ArrayListe<String> liste = new ArrayListe<>();
		liste.hinzufuegen("elementB");
		liste.hinzufuegen("elementA");
		liste.hinzufuegen("elementC");
		return liste;
	}
}
