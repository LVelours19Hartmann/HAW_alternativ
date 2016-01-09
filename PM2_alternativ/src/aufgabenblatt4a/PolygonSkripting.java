package aufgabenblatt4a;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Klasse Verarbeitung von Texteingaben
 * @author  Helena Lajevardi, Lennart Hartmann
 */
public class PolygonSkripting {
	private final Pattern pattern;
	private Matcher matcher;

	/**
	 * Konstruktor
	 */
	public PolygonSkripting() {
		pattern = Pattern.compile("(bewege)\\s->" + "\\s(0|-?[0-9]*\\.?[0-9]*),\\s?(0|-?[0-9]*\\.?[0-9]*)");
		matcher = null;
	}

	/**
	 * Methode zum ueberpruefen, ob der eingebene Befehl gueltig ist
	 * 
	 * @param befehl   Der eingegebene Befehl
	 * @return  gueltig, oder nicht
	 */
	public boolean istGueltigerBefehl(String befehl) {
		matcher = pattern.matcher(befehl);
		return matcher.matches();
	}

	/**
	 * Methode, um aus dem Eingabe String die X-Koordinate zu extrahieren
	 * 
	 * @param befehl    Eingabe-String
	 * @return X-Koordinate aus dem Eingabe-String
	 * @throws Exception  Bei falschen Befehl wird eine Exception geworfen
	 */
	public double getX(String befehl) throws Exception {
		if (istGueltigerBefehl(befehl)) {
			return new Double(matcher.group(3));
		} else {
			throw new Exception("Kein gueltiger Befehl!");
		}
	}

	/**
	 * Methode, um aus dem Eingabe String die X-Koordinate zu extrahieren
	 * 
	 * @param befehl  Eingabe-String
	 * @return Y-Koordinate aus dem Eingabe-String
	 * @throws Exception
	 *             Bei falschen Befehl wird eine Exception geworfen
	 */
	public double getY(String befehl) throws Exception {
		if (istGueltigerBefehl(befehl)) {
			return new Double(matcher.group(2));
		} else {
			throw new Exception("Kein gueltiger Befehl!");
		}
	}

}
