/**
 * BTI1-PTP/03, WS 15
 * Gruppe: Helena Lajevardi (helena.lajevardi@haw-hamburg.de)
 * 		   Lennart Hartmann (lennart.hartmann@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 2, Aufgabe 2.2
 */

package aufgabenblatt2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.function.Predicate;

/**
 * Bietet eine Methode zur Formatierung von Stringlisten
 * 
 * @author Helena Lajevardi, Lennart Hartmann
 * @version 15.11.2015
 */
public class Stringverarbeitung {

	/**
	 * Veraendere eine Liste von Strings durch entfernen von Null-Elementen,
	 * Abschneiden von Leerzeichen, Umwandlung in Grossbuchstaben, ersaetzen von
	 * Umlauten und kuerzen auf 8 Zeichen
	 * 
	 * @param strList
	 *            die Liste von Strings
	 * @return die bearbeitete Liste
	 */
	public static List<String> verarbeite(List<String> strList) {
		if (strList != null) {

			// gibt an, ob untersuchter String ungleich null ist
			Predicate<String> nichtNull = str -> str != null;

			List<String> neueListe = strList.stream().filter(nichtNull)
					.map(str -> str.trim()).map(str -> str.toUpperCase())
					.map(str -> str.replace("Ä", "AE"))
					.map(str -> str.replace("Ö", "OE"))
					.map(str -> str.replace("Ü", "UE"))
					.map(str -> str.replace("ß", "SS"))
					.map(str -> str.length() >= 8 ? str.substring(0, 8) : str)
					.collect(Collectors.toList());
			return neueListe;
		}
		return null;
	}
}
