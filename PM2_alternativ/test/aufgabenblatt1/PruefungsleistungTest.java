package aufgabenblatt1;

import static org.junit.Assert.*;

import org.junit.Test;

public class PruefungsleistungTest {

	@Test
	public void testPruefungsleistung() {
		Pruefungsleistung pl = new Pruefungsleistung("MG", 15);
		assertTrue("Objekt nicht erzeugt", pl != null);
		assertEquals("Falsche oder nicht gesetzte Modulbezeichnung", "MG", pl.getModulname());
		assertEquals("Falsche Note", 15, pl.getNote());
	}
	
	@Test
	public void testGetModulname(){
		Pruefungsleistung pl = new Pruefungsleistung("MG", 15);
		assertEquals("Falsche oder nicht gesetzte Modulbezeichnung", "MG", pl.getModulname());
	}
	
	@Test
	public void testGetNote(){
		Pruefungsleistung pl = new Pruefungsleistung("MG", 15);
		assertEquals("Falsche Note", 15, pl.getNote());		
	}

}
