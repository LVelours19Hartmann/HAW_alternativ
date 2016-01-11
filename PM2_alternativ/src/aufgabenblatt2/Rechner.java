/**
 * BTI1-PTP/03, WS 15
 * Gruppe: Helena Lajevardi (helena.lajevardi@haw-hamburg.de)
 * 		   Lennart Hartmann (lennart.hartmann@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 2, Aufgabe 2.1
 * 
 */

package aufgabenblatt2;

import java.util.HashMap;
import java.util.function.BinaryOperator;

/**
 * Repraesentiert einen einfachen Taschenrechner
 * 
 * @author Helena Lajevardi, Lennart Hartmann
 * @version 14.11.2015
 */
public class Rechner {

	public enum Operation {
		PLUS, MINUS, MAL, GETEILT
	}

	/**
	 * Haelt die zur Verfuegung stehenden Rechenoperationen
	 */
	private HashMap<Operation, BinaryOperator<Double>> operationMap;

	public Rechner() {
		operationMap = new HashMap<Operation, BinaryOperator<Double>>();
		operationMap.put(Operation.PLUS, (x, y) -> x + y);
		operationMap.put(Operation.MINUS, (x, y) -> x - y);
		operationMap.put(Operation.MAL, (x, y) -> x * y);
		operationMap.put(Operation.GETEILT, (x, y) -> {
			if (y != 0.0) {
				return x / y;
			}
			throw new IllegalArgumentException("Division durch Null");
		});
	}

	/**
	 * Wendet die gewaehlte Rechenoperation auf das übergebenene Zahlenpaar an
	 * 
	 * @param operation
	 *            die gewaehlte Rechenoperation
	 * @param zahl1
	 *            der 1.Operand
	 * @param zahl2
	 *            der 2.Operand
	 * @return das Ergebnis der Rechenoperation
	 */
	public double berechne(Operation operation, double zahl1, double zahl2) {
		return operationMap.get(operation).apply(zahl1, zahl2);
	}

}
