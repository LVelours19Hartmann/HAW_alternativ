package aufgabenblatt1;

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.Test;

import aufgabenblatt1.Student;
import aufgabenblatt1.StudentenComparator;

public class StudentenComparatorTest {

	@Test
	public void testCompare() {
		Comparator<Student> cmp = new StudentenComparator();
		//Studenten die sich nur in der Matrikelnummer unterscheiden
		Student st1 = new Student("Ab", "Cd", 45722);
		Student st2 = new Student("Ab", "Cd", 45712);
		//Student mit gleichem Vornamen
		Student st3 = new Student("Ab", "De", 34521);
		//Student mit gleichem Nachnamen
		Student st4 = new Student("Ef", "Cd", 562134);
		//Vollstaendig unterschiedlicher Student
		Student st5 = new Student("Gh", "Ij", 56834);
		
		//"gleiche" Studenten
		assertTrue("\"Gleiche\" Studenten werden unterschieden", cmp.compare(st1,st2) == 0);		
		
		//unterschiedliche Nachnamen
		assertTrue("Fehler bei ungleichen Nachnamen; st1 < st2", cmp.compare(st1,st3) < 0);
		assertTrue("Fehler bei ungleichen Nachnamen; st1 > st2", cmp.compare(st3, st1) > 0);
		
		//unterschiedliche Vornamen
		assertTrue("Fehler bei ungleichen Vornamen; st1 < st2", cmp.compare(st1, st4) < 0);
		assertTrue("Fehler bei ungleichen Vornamen; st1 > st2", cmp.compare(st4, st1) > 0);
		
		//Vollstaendig unterschiedliche Studenten
		assertTrue("Fehler bei vollstaendig unterschiedlichen Studenten; st1 < st2", cmp.compare(st1, st5) < 0);
		assertTrue("Fehler bei vollstaendig unterschiedlichen Studenten; st1 < st2", cmp.compare(st5, st1) > 0);
	}
}
