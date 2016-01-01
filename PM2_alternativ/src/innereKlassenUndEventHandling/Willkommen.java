package innereKlassenUndEventHandling;

public class Willkommen {
	public Willkommen(final String name){
		/**
		 * Innere Klasse zur Konsolenausgabe.
		 */
		class ConsoleOutput{
			public ConsoleOutput(final String text){
				System.out.println(text);
			}
		}
		new ConsoleOutput("Willkommen "+name+"!");
	}	
	public static void main(final String[] args){
		new Willkommen("Philipp");
	}
}
