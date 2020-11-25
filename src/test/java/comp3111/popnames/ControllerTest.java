package comp3111.popnames;

import static org.junit.Assert.*;
import org.junit.Test;

public class ControllerTest {
	int year;
	String name, gender;
	
	@Test
	public void testNumberOfBorn() {
    	int number = AnalyzeNames.getNumberOfBorn(1880, "Dave", "M");
    	assertEquals(131, number);
    }
	
	@Test
	public void testNumberOfBornWithInvalidYear() {
		int number = AnalyzeNames.getNumberOfBorn(1879, "Dave", "M");
    	assertEquals(-1, number);
	}
}
