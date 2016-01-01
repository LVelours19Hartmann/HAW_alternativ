package innereKlassenUndEventHandling;

public class VerschluesselungMitGedaechtnis {
	
	/**
	 * Innere Klasse
	 */
	private class Verschluesseler{
		/*
		 * Merkt sich den letzten Buchastaben
		 */
		char letzterBuchstabe = 'a';
		
		/**
		 * Berechnung des verschluesselten Buchstaben
		 * 
		 * @param	buchstabe	Buchstabe der verschluesselt werden soll.
		 * @return	Verchluesselter Buchstabe
		 */
		public char kodiere(char buchstabe){
			char kodierterBuchstabe = (char)(buchstabe + letzterBuchstabe -'a');
			letzterBuchstabe = buchstabe;
			while(kodierterBuchstabe > 'z'){
				kodierterBuchstabe = (char)(kodierterBuchstabe - 26);
			}
			return kodierterBuchstabe;
		}
	}
	
	/**
	 * Referenz auf Mitgliedsklasse
	 */
	private Verschluesseler verschluesseler = new Verschluesseler();
	
	/**
	 * Kodiert den Buchstaben durch 'Addition' des Index letzten Buchstabens im Alphabet
	 * (a = 0, b = 1, ...)
	 */
	public char kodiere(char buchstabe){
		return verschluesseler.kodiere(buchstabe);
	}
	
	public static void main(String[] args) {
		VerschluesselungMitGedaechtnis verschl = new VerschluesselungMitGedaechtnis();
		System.out.println(verschl.kodiere('c'));
	}
}
