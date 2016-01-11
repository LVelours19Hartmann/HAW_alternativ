/**
 * BTI1-PTP/03, WS 15
 * Gruppe: Helena Lajevardi (helena.lajevardi@haw-hamburg.de)
 * 		   Lennart Hartmann (lennart.hartmann@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 2, Tests zu Aufgabe 2.1
 */

package aufgabenblatt2;

import static org.junit.Assert.*;

import org.junit.Test;

import aufgabenblatt2.DoubleDoubleZuDouble;

public class DoubleDoubleZuDoubleTest {
public final double EPSILON = 1e-12;
	@Test
	public void ITest() {
		DoubleDoubleZuDouble mult = (a,b)->a*b;
		assertTrue("keine Instanz erzeugt", mult !=null);
		assertTrue("Falsches Ergebnis bei Multiplikation",Math.abs(4.2-mult.werteAus(2.1, 2.0)) < EPSILON);
	}

	@Test
	public void berechneNullstelleTest() {
		assertTrue("Falsche Ausgabe bei y=-2x+2",Math.abs(1-berechneNullstelle(-2, 2))<EPSILON);
		assertTrue("Falsche Ausgabe bei y=3x",Math.abs(0-berechneNullstelle(3, 0))<EPSILON);
		assertTrue("Falsche Ausgabe bei y=4x-1",Math.abs(0.25-berechneNullstelle(4, -1))<EPSILON);
		
		//Teste, ob bei nicht existierender Nullstelle die richtige Exception geworfen wird
		try{
			berechneNullstelle(0, 0);
			fail("Exception bei nicht lösbarer Gleichung nicht geworfen");
		}catch(IllegalArgumentException e){
			assertTrue(e.getMessage().equals("Es existiert keine Nullstelle!"));
		}
	}
	
	public static double berechneNullstelle(double a, double b){ 
		try{
			DoubleDoubleZuDouble geteilt = (x,y) -> {if(y!=0.0){return x/y;}; throw new IllegalArgumentException("Es existiert keine Nullstelle!");};
			return -geteilt.werteAus(b, a);
		}catch(IllegalArgumentException e){
			throw e;
		}
	}
}
