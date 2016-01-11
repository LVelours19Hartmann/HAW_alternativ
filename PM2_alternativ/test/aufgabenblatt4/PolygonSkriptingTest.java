/**
 * BTI1-PTP/03, WS 15
 * Gruppe: Helena Lajevardi (helena.lajevardi@haw-hamburg.de)
 *         Lennart Hartmann (lennart.hartmann@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 4
 * 
 */
package aufgabenblatt4;

import static org.junit.Assert.*;
import org.junit.Test;

public class PolygonSkriptingTest {

	@Test
	public void polygonSkriptingTest() {
		PolygonSkripting polygon = new PolygonSkripting();
		assertEquals("Gueltiger Befehl nicht erkannt", polygon.istGueltigerBefehl("bewege -> 1.0,3.0"), true);
	}

	@Test
	public void GueltigerBefehlFalsch() {
		PolygonSkripting polygon2 = new PolygonSkripting();
		assertEquals("Ungueltiger Befehl nicht erkannt", polygon2.istGueltigerBefehl("bewege > 1.0,3.0"), false);
		assertEquals("Ungueltiger Befehl nicht erkannt", polygon2.istGueltigerBefehl("trololo"), false);
	}

	@Test
	public void polygonSkriptingTestgetX() {
		PolygonSkripting polygon3 = new PolygonSkripting();
		try {
			assertEquals(3.0, polygon3.getX("bewege -> 1.0,3.0"), 0e-10);
			assertEquals(-03.0, polygon3.getX("bewege -> 1.0,-03.0"), 0e-10);
			assertEquals(345, polygon3.getX("bewege -> 1.0,345"), 0e-10);
		} catch (Exception e) {
		}

	}

	@Test
	public void polygonSkriptingTestgetY() {
		PolygonSkripting polygon3 = new PolygonSkripting();

		try {
			assertEquals(1.0, polygon3.getY("bewege -> 1.0,3.0"), 0e-10);
			assertEquals(-03.0, polygon3.getY("bewege -> -03.0,0.1"), 0e-10);
			assertEquals(345, polygon3.getY("bewege -> 345,1.0"), 0e-10);
		} catch (Exception e) {
		}
}
}
