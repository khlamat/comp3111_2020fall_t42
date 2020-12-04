package comp3111.popnames;

import org.junit.Test;
import static org.junit.Assert.*;

public class AnalyzeNamesTest {
	
    @Test 
    public void testGetRankNotFound() {
    	AnalyzeNames a = new AnalyzeNames();
    	int i = a.getRank(2019, "XXX", "M");
		assertEquals(i, -1);
    }
    
    @Test 
    public void testGetRankMale() {
    	AnalyzeNames a = new AnalyzeNames();
    	int i = a.getRank(2019, "David", "M");
    	assertTrue(i==27);
    }
    
    @Test 
    public void testGetRankFemale() {
    	AnalyzeNames a = new AnalyzeNames();
    	int i = a.getRank(2019, "Desire", "F");
    	assertTrue(i==2192);
    }
    	
    @Test 
    public void testGetNameMale() {
    	AnalyzeNames a = new AnalyzeNames();
    	String name = a.getName(2019, 27, "M");
    	assertTrue(name.equals("David"));
    }
    
    @Test 
    public void testGetNameFemale() {
    	AnalyzeNames a = new AnalyzeNames();
    	String name = a.getName(2019, 2192, "F");
    	assertTrue(name.equals("Desire"));
    }
    
    @Test
	public void testNumberOfBornMale() {
    	AnalyzeNames a = new AnalyzeNames();
    	int number = a.getNumberOfBorn(1880, "Dave", "M");
    	assertEquals(131, number);
    }
    
    @Test
	public void testNumberOfBornFemale() {
    	AnalyzeNames a = new AnalyzeNames();
    	int number = a.getNumberOfBorn(2019, "Emma", "F");
    	assertEquals(17102, number);
    }
    
	@Test
	public void testNumberOfBornWithInvalidSmallYear() {
		AnalyzeNames a = new AnalyzeNames();
		int number = a.getNumberOfBorn(1879, "Dave", "M");
    	assertEquals(-1, number);
	}
	
	@Test
	public void testNumberOfBornWithInvalidBigYear() {
		AnalyzeNames a = new AnalyzeNames();
		int number = a.getNumberOfBorn(2020, "Dave", "M");
    	assertEquals(-1, number);
	}
	
	@Test
	public void testNumberOfBornWithNotFoundMale() {
		AnalyzeNames a = new AnalyzeNames();
		int number = a.getNumberOfBorn(1880, "haha", "M");
		assertEquals(-1, number);
	}
	
	@Test
	public void testNumberOfBornWithNotFoundFemale() {
		AnalyzeNames a = new AnalyzeNames();
		int number = a.getNumberOfBorn(1880, "haha", "F");
		assertEquals(-1, number);
	}
}