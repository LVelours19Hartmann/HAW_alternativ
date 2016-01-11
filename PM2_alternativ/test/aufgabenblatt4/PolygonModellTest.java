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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class PolygonModellTest {

	@Test
	public void KonstruktorTest(){
		PolygonModell pModel = new PolygonModell();
		assertTrue("Instanzierung fehlgeschlagen", pModel!=null);
		assertTrue("AktuellesPolygon nicht gesetzt", pModel.getAktuellesPolygon() != null);
		assertTrue("PolygonListe nicht angelegt", pModel.getPolygonListe() != null);
		assertTrue("Polygonliste nicht leer",pModel.getPolygonListe().size() == 0);
	}
	
	@Test
	public void polygonBearbeitungAbschliessenTest() {	
		PolygonModell pm = new PolygonModell();
		//alter Zustand des Polygonmodells
		Polygon altesAktuellesPolygon = pm.getAktuellesPolygon();
		int alteGroessePolygonListe = pm.getPolygonListe().size();
		
		pm.polygonBearbeitungAbschliessen();
		assertTrue("Kein neues aktuellesPolygon gesetzt",!altesAktuellesPolygon.equals(pm.getAktuellesPolygon()));
		assertTrue("Liste nicht vergroessert",pm.getPolygonListe().size() == alteGroessePolygonListe+1);
		int letzterIndex = pm.getPolygonListe().size()-1;
		assertTrue("Altes aktuellesPolygon nicht in Liste aufgenommen",pm.getPolygonListe().get(letzterIndex).equals(altesAktuellesPolygon));
	}
	
	public void updateImBetriebTest(){
		PolygonModell pm = getBeispielTestmodell();
		//alter Zustand des Polygonmodells
		Polygon altesAktuellesPolygon = pm.getAktuellesPolygon();
		int alteGroessePolygonListe = pm.getPolygonListe().size();
		
		pm.polygonBearbeitungAbschliessen();
		assertTrue("Kein neues aktuellesPolygon gesetzt",!altesAktuellesPolygon.equals(pm.getAktuellesPolygon()));
		assertTrue("Liste nicht vergroessert",pm.getPolygonListe().size() == alteGroessePolygonListe+1);
		int letzterIndex = pm.getPolygonListe().size()-1;
		assertTrue("Altes aktuellesPolygon nicht in Liste aufgenommen",pm.getPolygonListe().get(letzterIndex).equals(altesAktuellesPolygon));
		assertTrue("Zustandsaenderung nicht gemeldet", pm.hasChanged());
	}
	
	
	@Test
	public void getPolygonListe(){
		PolygonModell mp = getBeispielTestmodell();
		assertTrue("null zuruckgegeben",mp.getPolygonListe()!= null);
		assertTrue("Leere Liste zuruckgegeben", !mp.getPolygonListe().isEmpty());
		assertTrue("Falscher Listentyp zuruckgegeben", mp.getPolygonListe() instanceof ObservableList<?>);
		assertTrue("Falscher Typ in der Liste", mp.getPolygonListe().get(2) instanceof Polygon);
	}
	
	@Test
	public void getAktuellesPolygonTest(){
		PolygonModell pm = new PolygonModell();
		assertTrue("Nach Instnzierung gueltiges Polygon zurueckgegeben", pm.getAktuellesPolygon() != null && pm.getAktuellesPolygon() instanceof Polygon);
		pm = getBeispielTestmodell();
		assertTrue("Im laufenden Betrieb gueltiges Polygon zurueckgegeben", pm.getAktuellesPolygon() != null && pm.getAktuellesPolygon() instanceof Polygon);
	}
	
	@Test
	public void setAktuellesPolygonTest(){
		PolygonModell pm = getBeispielTestmodell();
		Polygon altesPolygon = pm.getAktuellesPolygon();
		Polygon neuesPolygon = new Polygon();
		pm.setAktuellesPolygon(neuesPolygon);
		assertTrue("Aktualisierung fehlgeschlagen", !pm.getAktuellesPolygon().equals(altesPolygon) && pm.getAktuellesPolygon().equals(neuesPolygon));
	}  
	
	private PolygonModell getBeispielTestmodell(){
		PolygonModell pModel = new PolygonModell();
		pModel.getPolygonListe().addAll(getTestpolygone());
		pModel.setAktuellesPolygon(getTestpolygon());
		pModel.polygonBearbeitungAbschliessen();
		return pModel;
	}
	
	private ObservableList<Polygon> getTestpolygone(){
		ObservableList<Polygon> tpList = FXCollections.observableArrayList();
		//erzeuge unterschiedliche Polygone zum befuellen
		for(int i=0; i<70 ;i+=10){
			Polygon p = new Polygon();
			p.punktHinzufuegen(new Punkt(1+i,2+i));			// -> index 0
			p.punktHinzufuegen(new Punkt(-25+i, 1.264+i)); 	// -> index 1
			p.punktHinzufuegen(new Punkt(0.2+i, -2.745+i)); // -> index 2
			p.punktHinzufuegen(new Punkt(0+i, 0+i)); 		// -> index 3
			p.punktHinzufuegen(new Punkt(16+i, 16+i)); 		// -> index 4
			tpList.add(p);
		}
		return tpList;
	}
	
	private Polygon getTestpolygon(){
		Polygon p = new Polygon();
		p.punktHinzufuegen(new Punkt(0,3));			// -> index 0
		p.punktHinzufuegen(new Punkt(-5, 1.24)); 	// -> index 1
		p.punktHinzufuegen(new Punkt(0.23, -2.75)); // -> index 2
		p.punktHinzufuegen(new Punkt(1, 0.2)); 		// -> index 3
		p.punktHinzufuegen(new Punkt(6, 1)); 		// -> index 4
		return p;
	}
}
