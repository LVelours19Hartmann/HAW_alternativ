/**
 * BTI1-PTP/03, WS 15
 * Gruppe: Helena Lajevardi (helena.lajevardi@haw-hamburg.de)
 * 		   Lennart Hartmann (lennart.hartmann@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 2, Tests zu Aufgabe 2.1
 */

package aufgabenblatt2;

import static org.junit.Assert.*;

import org.junit.Test;

import aufgabenblatt2.Rechner.Operation;

public class RechnerTest {
	Rechner r= new Rechner();
	public final double DELTA = 1e-12;

	@Test
	public void berechnePlusTest(){
		assertTrue("Falsches Ergebnis fuer 2.1 + 3.4 ",Math.abs(5.5- r.berechne(Operation.PLUS, 2.1, 3.4))<DELTA);
		assertTrue("Falsches Ergebnis fuer 4.1 + 0",Math.abs(4.1 - r.berechne(Operation.PLUS, 4.1, 0))<DELTA);
		assertTrue("Falsches Ergebnis fuer 0 + 7.3",Math.abs(7.3 - r.berechne(Operation.PLUS, 0, 7.3))<DELTA);
		//assertTrue("Falsches Ergebnis fuer 0 + 7.3",Math.abs(7.3 - r.berechne(null, 0, 7.3))<DELTA);
	}
	
	@Test
	public void berechneMinusTest(){
		assertTrue("Falsches Ergebnis fuer 2.1 - 2.1 ",Math.abs(0- r.berechne(Operation.MINUS, 2.1, 2.1))<DELTA);
		assertTrue("Falsches Ergebnis fuer 4.1 - 1",Math.abs(3.1 - r.berechne(Operation.MINUS, 4.1, 1))<DELTA);
		assertTrue("Falsches Ergebnis fuer 1.2 - 6.3",Math.abs(-5.1 - r.berechne(Operation.MINUS, 1.2, 6.3))<DELTA);
	}
	
	@Test
	public void berechneMalTest(){
		assertTrue("Falsches Ergebnis fuer 2 * 3.4 ",Math.abs(6.8 - r.berechne(Operation.MAL, 2.0, 3.4))<DELTA);
		assertTrue("Falsches Ergebnis fuer 4.1 * 0",Math.abs(0.0 - r.berechne(Operation.MAL, 4.1, 0))<DELTA);
		assertTrue("Falsches Ergebnis fuer 3.1 1.2",Math.abs(3.72 - r.berechne(Operation.MAL, 3.1, 1.2))<DELTA);
	}
	
	@Test
	public void berechneGeteiltTest(){
//		assertTrue("Falsches Ergebnis fuer 0/7.2 ",Math.abs(0.0 - r.berechne(Operation.GETEILT, 0.0, 7.2))<DELTA);
//		assertTrue("Falsches Ergebnis fuer 4.1 * 2.0",Math.abs(2.05 - r.berechne(Operation.GETEILT, 4.1, 2.0))<DELTA);
//		assertTrue("Falsches Ergebnis fuer 3.1 1.2",Math.abs(1.2 - r.berechne(Operation.GETEILT,3.72, 3.1))<DELTA);
		
		//Teste, ob bei Division durch 0 die richtige Exception geworfen wird
		try{
			r.berechne(Operation.GETEILT, 3.4, 0.0);
			fail("Bei Division durch 0 keine Exception geworfen");
		} catch(IllegalArgumentException e){
			assertTrue(e.getMessage().equals("Division durch Null"));
		}

	}
	@Test
	public void samTest(){
		DoubleDoubleZuDouble sam = (x,y)->x+y;
		assertTrue("Instanzierung fehlgeschlagen",sam != null);
		assertTrue("Falscher Rueckgabetyp",sam.werteAus(1.1, 3.4) instanceof Double);
		
	}
}
