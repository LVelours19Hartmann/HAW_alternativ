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




public class PolygonTest {

	public static final double EPSILON=1e-10;
	
	@Test
	public void KunstruktorTest() {
		Polygon p =  new Polygon();
		assertTrue("Instanziierung fehlgeschlagen",p!=null);
	}

	@Test 
	public void punktHinzufuegenTest(){
		Polygon p = new Polygon();
		p.getPunkte().add(new Punkt(5, 4));
		assertTrue("Hinzufuegen eines Punktes fehlgeschlagen",p.getPunkte().size()>0);
		p.getPunkte().add(new Punkt(6,3));
		assertTrue("Hinzufuegen eines weiteren Punktes fehlgeschlagen",p.getPunkte().size()==2);
	}
		
	@Test
	public void xKoordinatenTest() {
		
		Polygon p = getTestpolygon();

		assertTrue("Fehler fuer xKoo von Punkt 0", Math.abs(1 - p.getPunkte().get(0).getX()) < EPSILON);
		assertTrue("Fehler fuer xKoo von Punkt 1", Math.abs(-25 - p.getPunkte().get(1).getX()) < EPSILON);
		assertTrue("Fehler fuer xKoo von Punkt 2", Math.abs(0.2 - p.getPunkte().get(2).getX()) < EPSILON);
		assertTrue("Fehler fuer xKoo von Punkt 3", Math.abs(0 - p.getPunkte().get(3).getX()) < EPSILON);
		assertTrue("Fehler fuer xKoo von Punkt 4", Math.abs(16 - p.getPunkte().get(4).getX()) < EPSILON);
	}

	@Test
	public void yKoordinatenTest() {
	
		Polygon p = getTestpolygon();
		assertTrue("Fehler fuer yKoo von Punkt 0", Math.abs(2 - p.getPunkte().get(0).getY()) < EPSILON);
		assertTrue("Fehler fuer yKoo von Punkt 1", Math.abs(1.264 - p.getPunkte().get(1).getY()) < EPSILON);
		assertTrue("Fehler fuer yKoo von Punkt 2", Math.abs(-2.745 - p.getPunkte().get(2).getY()) < EPSILON);
		assertTrue("Fehler fuer yKoo von Punkt 3", Math.abs(0 - p.getPunkte().get(3).getY()) < EPSILON);
		assertTrue("Fehler fuer yKoo von Punkt 4", Math.abs(16 - p.getPunkte().get(4).getY()) < EPSILON);		
	}
	
	@Test
	public void illegalerZugriffTest(){

		Polygon p = getTestpolygon();
		
		try {
//			p.getXPosZuEcke(-1);
			p.getPunkte().get(-1);
			assertTrue("Fehler! Keine Exception wurde geworfen", false);
		} catch (IndexOutOfBoundsException e) {

		}
		try {
//			p.getXPosZuEcke(25);
			p.getPunkte().get(10);
			assertTrue("Fehler! Keine Exception wurde geworfen", false);
		} catch (IndexOutOfBoundsException e) {

		}
	}
	
	private Polygon getTestpolygon(){
		Polygon p = new Polygon();
		p.punktHinzufuegen(new Punkt(1,2));			// -> index 0
		p.punktHinzufuegen(new Punkt(-25, 1.264)); 	// -> index 1
		p.punktHinzufuegen(new Punkt(0.2, -2.745)); // -> index 2
		p.punktHinzufuegen(new Punkt(0, 0)); 		// -> index 3
		p.punktHinzufuegen(new Punkt(16, 16)); 		// -> index 4
		return p;
	}
}


