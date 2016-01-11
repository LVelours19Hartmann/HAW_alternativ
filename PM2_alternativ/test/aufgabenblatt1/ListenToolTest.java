package aufgabenblatt1;

import static org.junit.Assert.*;

import org.junit.Test;

public class ListenToolTest {

	@Test
	public void istErstesElementZahlTest() {
		ArrayListe<Integer> intLst = new ArrayListe<>();
		assertEquals("Gibt bei leerer Liste true zurueck", false, ListenTool.istErstesElementZahl(intLst));
		intLst.hinzufuegen(1);
		assertEquals("Zahl nicht erkannt", true, ListenTool.istErstesElementZahl(intLst));
		ArrayListe<Boolean> boolLst = new ArrayListe<Boolean>();
		boolLst.hinzufuegen(true);
		assertEquals("Boolean als Zahl erkannt", false, ListenTool.istErstesElementZahl(boolLst));
		
	}
	@Test
	public void bildeSummeTest(){
		ArrayListe<Integer> intLst = new ArrayListe<>();
		assertEquals("Fehler bei leerem Array", 0, ListenTool.bildeSumme(intLst));
		intLst.hinzufuegen(1);
		intLst.hinzufuegen(2);
		intLst.hinzufuegen(3);
		intLst.hinzufuegen(4);
		assertEquals("Fehler beim zusammenrechnen",10 , ListenTool.bildeSumme(intLst));
		
	}
}
