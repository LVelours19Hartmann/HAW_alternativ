/**
 * BTI1-PTP/03, WS 15
 * Gruppe: Helena Lajevardi (helena.lajevardi@haw-hamburg.de)
 * 		   Lennart Hartmann (lennart.hartmann@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 2, Tests zu Aufgabe 2.3
 */

package aufgabenblatt2;

import static org.junit.Assert.*;

import org.junit.Test;


public class RennautoTest {
	public static final double EPSILON = 1e-12;


	@Test
	public void KonstruktorTest() {
		Rennauto auto1 = new Rennauto(50.0, new Rennstrecke());
		assertTrue("Rennauto nicht erzeugt", auto1!=null);
		assertTrue("falscher Startwert fuer benoetigte Zeit", Math.abs(-1- auto1.getBenoetigteZeit())<EPSILON);
		assertTrue("falsche Startposition",Math.abs(0-auto1.getAktuelleRosition())<EPSILON);
	}
	
	@Test 
	public void bezeichnerTest(){
		Rennauto auto2 = new Rennauto(30, new Rennstrecke());
		Rennauto auto3 = new Rennauto(40, new Rennstrecke());
		assertTrue("Falscher Bezeichner", auto2.getBez().contains("Wagen"));
		assertTrue("Fehler bei Nummerierung", auto3.getBez().compareTo(auto2.getBez()) > 0);
	}
	
	@Test
	public void getAktuelleRositionTest(){
		Rennauto auto4 = new Rennauto(30, new Rennstrecke());
		assertTrue("Falsche Startposition", Math.abs(0.0 - auto4.getAktuelleRosition())<EPSILON);
	}
	
	@Test
	public void getBenoetigteZeitTest(){
		Rennauto auto5 = new Rennauto(50, new Rennstrecke());
		assertTrue("falscher Startwert fuer benoetigte Zeit", Math.abs(-1- auto5.getBenoetigteZeit())<EPSILON);
	}
	
	@Test 
	public void runTest(){
		Rennstrecke strecke = new Rennstrecke(500);
		Rennauto auto6 = new Rennauto(100, strecke);
		String idBeiRennstart = auto6.getBez();
		double benoetigteZeitInitialisierung = auto6.getBenoetigteZeit();
		
		auto6.start();
		try {
			auto6.join();
		} catch (InterruptedException e) {
			fail("Rennwagen-Thread endet nicht");
		}
		assertEquals("Bezeicher des Wagens hat sich geaendert", idBeiRennstart, auto6.getBez());
		assertTrue("AktuellePosition falsch erfasst", auto6.getAktuelleRosition() >= strecke.LAENGE);
		assertTrue("Rennzeiterfassung funktioniert nicht", auto6.getBenoetigteZeit() > benoetigteZeitInitialisierung);
		assertTrue("Negative Rennzeit moeglich", auto6.getBenoetigteZeit() >= 0);
	}
}
