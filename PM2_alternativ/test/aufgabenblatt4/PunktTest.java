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

public class PunktTest {

public static final double EPSILON=1e-10;
	
	@Test
	public void KunstruktorTest() {
		Punkt p = new Punkt(1.78, 7.2); 
		assertTrue("Instanziierung mit double Koo. fehlgeschlagen",p!=null);
		p = new Punkt(1, 7); 
		assertTrue("Instanziierung mit int Koo. fehlgeschlagen",p!=null);
	}

	
	@Test
	public void getterTest() {
	
		Punkt[] pkte = getTestpunkte();
		double[] xKoos = getTestKoosX();
		double[] yKoos = getTestKoosY();
		
		int anzPunkte = pkte.length;
		for(int i=0;i<anzPunkte; i++){
			assertTrue("Fehler fuer xKoo von Punkt "+i, Math.abs(xKoos[i] - pkte[i].getX()) < EPSILON);
			assertTrue("Fehler fuer yKoo von Punkt "+i, Math.abs(yKoos[i] - pkte[i].getY()) < EPSILON);
		}		
	}
	
	@Test
	public void setterTest(){
		Punkt pkt=new Punkt(0,0);
		double[] xKoos=getTestKoosX();
		double[] yKoos=getTestKoosY();
		int anzahlWerpaare=xKoos.length;
		for(int i=0; i<anzahlWerpaare;i++){
			pkt.setX(xKoos[i]);
			pkt.setY(yKoos[i]);
			assertTrue("Fehler bei "+i+"-ter xKoordinate!",xKoos[i]==pkt.getX());
		}
	}
	
	@Test
	public void equalsTest(){
		Punkt[] pkte = getTestpunkte();
		assertTrue("Identische Punkte nicht erkannt", pkte[0].equals(pkte[0]));
		assertTrue("Unterschiedliche Punkte nicht unterschieden", !pkte[1].equals(pkte[3]));
	}
	
	@Test 
	public void toStringTest(){
		Punkt pkt = new Punkt(4.1,5);
		assertTrue("Falscher Text",pkt.toString().equals("Punkt [x=" + pkt.getX() + ", y=" + pkt.getY() + "]"));
	}
	
	private Punkt[] getTestpunkte(){
		Punkt[] punkte  = new Punkt[5];
		punkte[0] = new Punkt(1,2);			// -> index 0
		punkte[1] = new Punkt(-25, 1.264); 	// -> index 1
		punkte[2] = new Punkt(0.2, -2.745); // -> index 2
		punkte[3] = new Punkt(0, 0); 		// -> index 3
		punkte[4] = new Punkt(16, 16); 		// -> index 4
		return punkte;
	}
	
	private double[] getTestKoosX(){
		double[] testKoosX = new double[5];
		testKoosX[0]=1;
		testKoosX[1]=-25;
		testKoosX[2]=0.2;
		testKoosX[3]=0;
		testKoosX[4]=16;
		return testKoosX;
	}
	
	private double[] getTestKoosY(){
		double[] testKoosY = new double[5];
		testKoosY[0]= 2;
		testKoosY[1]= 1.264;
		testKoosY[2]= -2.745;
		testKoosY[3]=0;
		testKoosY[4]=16;
		return testKoosY;
	}

}
