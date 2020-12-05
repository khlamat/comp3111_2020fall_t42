package comp3111.popnames;

import static org.junit.Assert.*;
import org.junit.Test;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit.ApplicationTest;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class JavaFXTest extends ApplicationTest {

	private Scene s;
	private TextArea t;
	
	@Override
	public void start(Stage stage) throws Exception {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/ui.fxml"));
   		VBox root = (VBox) loader.load();
   		Scene scene =  new Scene(root);
   		stage.setScene(scene);
   		stage.setTitle("Popular Names");
   		stage.show();
   		s = scene;
		t = (TextArea)s.lookup("#textAreaConsole");
	}
	
	@Test
	public void testButtonRankTrue() {	
		//clickOn("#tabTaskZero");
		clickOn("#buttonRankM");
		//sleep(1000);
		String s1 = t.getText();
		clickOn("#buttonRankM");
		//sleep(1000);
		String s2 = t.getText();
		assertTrue(s1.equals(s2));
	}
	
	
	@Test
	public void testButtonRankFalse() {	
		//clickOn("#tabTaskZero");
		clickOn("#buttonRankM");
		//sleep(1000);
		String s1 = t.getText();
		clickOn("#buttonRankF");
		//sleep(1000);
		String s2 = t.getText();
		assertFalse(s1.equals(s2));
	}
	
	
	@Test
	public void testTextAreaConsole() {	
		t.setText("David");
		String s = t.getText();
		assertTrue(s.equals("David"));
	}
	
	
	/**
	 * Task 1 test case: default input 
	 * 
	 */
	@Test
	public void testTask1DefaultInput() {
		clickOn("#tabReport1");
		clickOn("#task1Report");
		String s1 = t.getText();
		assertTrue(s1.equals(String.format("Year\tTop 1          \tTop 2          \tTop 3          \tTop 4          \tTop 5          \tTop 6          \tTop 7          \tTop 8          \tTop 9          \tTop 10         \t\n" + 
				"1941\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t\n" + 
				"1942\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t\n" + 
				"1943\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t\n" + 
				"1944\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t\n" + 
				"1945\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t%-15s\t\n" + 
				"Over the period 1941 to 1945, James for M has hold the top spot most often for a total of 375534 times.",
				AnalyzeNames.getName(1941, 1, "M"), AnalyzeNames.getName(1941, 2, "M"), AnalyzeNames.getName(1941, 3, "M"),
				AnalyzeNames.getName(1941, 4, "M"), AnalyzeNames.getName(1941, 5, "M"), AnalyzeNames.getName(1941, 6, "M"),
				AnalyzeNames.getName(1941, 7, "M"), AnalyzeNames.getName(1941, 8, "M"), AnalyzeNames.getName(1941, 9, "M"),
				AnalyzeNames.getName(1941, 10, "M"), AnalyzeNames.getName(1942, 1, "M"), AnalyzeNames.getName(1942, 2, "M"),
				AnalyzeNames.getName(1942, 3, "M"), AnalyzeNames.getName(1942, 4, "M"), AnalyzeNames.getName(1942, 5, "M"),
				AnalyzeNames.getName(1942, 6, "M"), AnalyzeNames.getName(1942, 7, "M"), AnalyzeNames.getName(1942, 8, "M"),
				AnalyzeNames.getName(1942, 9, "M"), AnalyzeNames.getName(1942, 10, "M"), AnalyzeNames.getName(1943, 1, "M"),
				AnalyzeNames.getName(1943, 2, "M"), AnalyzeNames.getName(1943, 3, "M"), AnalyzeNames.getName(1943, 4, "M"),
				AnalyzeNames.getName(1943, 5, "M"), AnalyzeNames.getName(1943, 6, "M"), AnalyzeNames.getName(1943, 7, "M"),
				AnalyzeNames.getName(1943, 8, "M"), AnalyzeNames.getName(1943, 9, "M"), AnalyzeNames.getName(1943, 10, "M"),
				AnalyzeNames.getName(1944, 1, "M"), AnalyzeNames.getName(1944, 2, "M"), AnalyzeNames.getName(1944, 3, "M"),
				AnalyzeNames.getName(1944, 4, "M"), AnalyzeNames.getName(1944, 5, "M"), AnalyzeNames.getName(1944, 6, "M"),
				AnalyzeNames.getName(1944, 7, "M"), AnalyzeNames.getName(1944, 8, "M"), AnalyzeNames.getName(1944, 9, "M"),
				AnalyzeNames.getName(1944, 10, "M"), AnalyzeNames.getName(1945, 1, "M"), AnalyzeNames.getName(1945, 2, "M"),
				AnalyzeNames.getName(1945, 3, "M"), AnalyzeNames.getName(1945, 4, "M"), AnalyzeNames.getName(1945, 5, "M"),
				AnalyzeNames.getName(1945, 6, "M"), AnalyzeNames.getName(1945, 7, "M"), AnalyzeNames.getName(1945, 8, "M"),
				AnalyzeNames.getName(1945, 9, "M"), AnalyzeNames.getName(1945, 10, "M"))));		
    }
	
	
	/**
	 * Task 1 test case: empty top N 
	 * 
	 */
	@Test
	public void testTask1TopNIsEmpty() {
		clickOn("#tabReport1");
		TextField topN = (TextField)s.lookup("#task1TopN");
		topN.setText("");
		clickOn("#task1Report");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nTop N is empty.\n"));
	}
	
	
	/**
	 * Task 1 test case: Top N is not an integer
	 * 
	 */
	@Test
	public void testTask1TopNIsNotInteger() {
		clickOn("#tabReport1");
		TextField topN = (TextField)s.lookup("#task1TopN");
		topN.setText("@");
		clickOn("#task1Report");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nTop N is not an integer.\n"));
	}
	
	
	/**
	 * Task 1 test case: Top N is not a positive integer
	 * 
	 */
	@Test
	public void testTask1TopNIsNotPositive() {
		clickOn("#tabReport1");
		TextField topN = (TextField)s.lookup("#task1TopN");
		topN.setText("0");
		clickOn("#task1Report");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nTop N is not positive.\n"));
	}
	
	
	/**
	 * Task 1 test case: Top N is larger than the number of recorded names for a particular year
	 * 
	 */
	@Test
	public void testTask1TopNIsTooLarge() {
		clickOn("#tabReport1");
		TextField topN = (TextField)s.lookup("#task1TopN");
		topN.setText("10001");
		clickOn("#task1Report");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nTop N is more than the number of recorded names for each year.\n"));
	}
	
	
	/**
	 * Task 1 test case: starting year is empty
	 * 
	 */
	@Test
	public void testTask1StartingYearIsEmpty() {
		clickOn("#tabReport1");
		TextField topN = (TextField)s.lookup("#task1TopN");
		topN.setText("1");
		TextField startingYear = (TextField)s.lookup("#task1StartingYear");
		startingYear.setText("");
		clickOn("#task1Report");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nStartingYear is empty.\n"));
	}
	
	
	/**
	 * Task 1 test case: starting year is not an integer
	 * 
	 */
	@Test
	public void testTask1StartingYearIsNotInteger() {
		clickOn("#tabReport1");
		TextField topN = (TextField)s.lookup("#task1TopN");
		topN.setText("1");
		TextField startingYear = (TextField)s.lookup("#task1StartingYear");
		startingYear.setText("f");
		clickOn("#task1Report");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nStartingYear is not an integer.\n"));
	}
	
	
	/**
	 * Task 1 test case: starting year is less than the earliest recorded year
	 * 
	 */
	@Test
	public void testTask1StartingYearIsLessThanRange() {
		clickOn("#tabReport1");
		TextField topN = (TextField)s.lookup("#task1TopN");
		topN.setText("1");
		TextField startingYear = (TextField)s.lookup("#task1StartingYear");
		startingYear.setText("1879");
		clickOn("#task1Report");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nStartingYear is not in [1880, 2019].\n"));	
	}
	
	
	/**
	 * Task 1 test case: starting year is larger than the latest recorded year
	 * 
	 */
	@Test
	public void testTask1StartingYearIsMoreThanRange() {
		clickOn("#tabReport1");
		TextField topN = (TextField)s.lookup("#task1TopN");
		topN.setText("1");
		TextField startingYear = (TextField)s.lookup("#task1StartingYear");
		startingYear.setText("2020");
		clickOn("#task1Report");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nStartingYear is not in [1880, 2019].\n"));	
	}
	
	
	/**
	 * Task 1 test case: ending year is empty
	 * 
	 */
	@Test
	public void testTask1EndingYearIsEmpty() {
		clickOn("#tabReport1");
		TextField topN = (TextField)s.lookup("#task1TopN");
		topN.setText("1");
		TextField startingYear = (TextField)s.lookup("#task1StartingYear");
		startingYear.setText("1941");
		TextField endingYear = (TextField)s.lookup("#task1EndingYear");
		endingYear.setText("");
		clickOn("#task1Report");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nEndingYear is empty.\n"));
	}
	
	
	/**
	 * Task 1 test case: ending year is not an integer
	 * 
	 */
	@Test
	public void testTask1EndingYearIsNotInteger() {
		clickOn("#tabReport1");
		TextField topN = (TextField)s.lookup("#task1TopN");
		topN.setText("1");
		TextField startingYear = (TextField)s.lookup("#task1StartingYear");
		startingYear.setText("1941");
		TextField endingYear = (TextField)s.lookup("#task1EndingYear");
		endingYear.setText("-");
		clickOn("#task1Report");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nEndingYear is not an integer.\n"));
	}
	
	
	/**
	 * Task 1 test case: ending year is less than the earliest recorded year
	 * 
	 */
	@Test
	public void testTask1EndingYearIsLessThanRange() {
		clickOn("#tabReport1");
		TextField topN = (TextField)s.lookup("#task1TopN");
		topN.setText("1");
		TextField startingYear = (TextField)s.lookup("#task1StartingYear");
		startingYear.setText("1941");
		TextField endingYear = (TextField)s.lookup("#task1EndingYear");
		endingYear.setText("1879");
		clickOn("#task1Report");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nEndingYear is not in [1880, 2019].\n"));
	}
	
	
	/**
	 * Task 1 test case: ending year is larger than the latest recorded year
	 * 
	 */
	@Test
	public void testTask1EndingYearIsMoreThanRange() {
		clickOn("#tabReport1");
		TextField topN = (TextField)s.lookup("#task1TopN");
		topN.setText("1");
		TextField startingYear = (TextField)s.lookup("#task1StartingYear");
		startingYear.setText("1941");
		TextField endingYear = (TextField)s.lookup("#task1EndingYear");
		endingYear.setText("2020");
		clickOn("#task1Report");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nEndingYear is not in [1880, 2019].\n"));
	}
	
	
	/**
	 * Task 1 test case: ending year is smaller than starting year
	 * 
	 */
	@Test
	public void testTask1EndingYearIsSmallerThanStartingYear() {
		clickOn("#tabReport1");
		TextField topN = (TextField)s.lookup("#task1TopN");
		topN.setText("1");
		TextField startingYear = (TextField)s.lookup("#task1StartingYear");
		startingYear.setText("1941");
		TextField endingYear = (TextField)s.lookup("#task1EndingYear");
		endingYear.setText("1940");
		clickOn("#task1Report");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nEndingYear should not be less than StartingYear.\n"));
	}
	
	
	/**
	 * Task 1 test case: All inputs are empty
	 * 
	 */
	@Test
	public void testTask1AllInputEmpty() {
		clickOn("#tabReport1");
		TextField topN = (TextField)s.lookup("#task1TopN");
		topN.setText("");
		TextField startingYear = (TextField)s.lookup("#task1StartingYear");
		startingYear.setText("");
		TextField endingYear = (TextField)s.lookup("#task1EndingYear");
		endingYear.setText("");
		clickOn("#task1Report");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nTop N is empty.\nStartingYear is empty.\nEndingYear is empty.\n"));
	}
	
	
	/**
	 * Task 1 test case: test female button
	 * 
	 */
	@Test
	public void testTask1Female() {
		clickOn("#tabReport1");
		RadioButton task1M = (RadioButton)s.lookup("#task1M");
		task1M.setSelected(false);
		TextField topN = (TextField)s.lookup("#task1TopN");
		topN.setText("1");
		TextField startingYear = (TextField)s.lookup("#task1StartingYear");
		startingYear.setText("1945");
		TextField endingYear = (TextField)s.lookup("#task1EndingYear");
		endingYear.setText("1945");
		clickOn("#task1Report");
		String s1 = t.getText();
		assertTrue(s1.equals(String.format("Year\tTop 1          \t\n" + 
				"1945\t%-15s\t\n" + 
				"Over the period 1945 to 1945, Mary for F has hold the top spot most often for a total of %d times.", AnalyzeNames.getName(1945, 1, "F"), AnalyzeNames.getNumberOfBorn(1945, "Mary", "F"))));		
    }
	
	
	/**
	 * Task 1 test case: testing output for the most used name
	 * 
	 */
	@Test
	public void testMostUsedName() {
		clickOn("#tabReport1");
		TextField topN = (TextField)s.lookup("#task1TopN");
		topN.setText("1");
		TextField startingYear = (TextField)s.lookup("#task1StartingYear");
		startingYear.setText("1952");
		TextField endingYear = (TextField)s.lookup("#task1EndingYear");
		endingYear.setText("1956");
		clickOn("#task1Report");
		String s1 = t.getText();
		assertTrue(s1.equals(String.format("Year\tTop 1          \t\n" + 
				"1952\t%-15s\t\n" + 
				"1953\t%-15s\t\n" + 
				"1954\t%-15s\t\n" + 
				"1955\t%-15s\t\n" + 
				"1956\t%-15s\t\n" + 
				"Over the period 1952 to 1956, Michael for M has hold the top spot most often for a total of 430587 times.",
				AnalyzeNames.getName(1952, 1, "M"), AnalyzeNames.getName(1953, 1, "M"), AnalyzeNames.getName(1954, 1, "M"),
				AnalyzeNames.getName(1955, 1, "M"), AnalyzeNames.getName(1956, 1, "M"))));
	}
	
	
	/**
	 * Application 1 test case: test default input
	 * 
	 */
	@Test
	public void testApplication1DefaultInput() {
		clickOn("#tabApp1");
		clickOn("#application1Reoprt");
		String s1 = t.getText();
		assertTrue(s1.equals(String.format("Recommended name for baby boy according to the NK-T4 Algorithm is %s.\nRecommended name for baby girl according to the NK-T4 Algorithm is %s.",
				AnalyzeNames.getName(2019, AnalyzeNames.getRank(1941,  "David", "M"), "M"), AnalyzeNames.getName(2019, AnalyzeNames.getRank(1945,  "Mary", "F"), "F"))));
	}
	
	
	/**
	 * Application 1 test case: test vintage year is not integer
	 * 
	 */
	@Test
	public void testApplication1VintageYearIsNotInteger() {
		clickOn("#tabApp1");
		TextField vintageYear = (TextField)s.lookup("#task4iVintageYear");
		vintageYear.setText("~");
		clickOn("#application1Reoprt");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nVintage Year is not an integer.\n"));
	}
	
	
	/**
	 * Application 1 test case: test vintage year less than the earliest recorded year
	 * 
	 */
	@Test
	public void testApplication1VintageYearIsLessThanRange() {
		clickOn("#tabApp1");
		TextField vintageYear = (TextField)s.lookup("#task4iVintageYear");
		vintageYear.setText("1879");
		clickOn("#application1Reoprt");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nVintage Year is not in [1880, 2019].\n"));	
	}
	
	
	/**
	 * Application 1 test case: test vintage year less than the latest recorded year
	 * 
	 */
	@Test
	public void testApplication1VintageYearIsMoreThanRange() {
		clickOn("#tabApp1");
		TextField vintageYear = (TextField)s.lookup("#task4iVintageYear");
		vintageYear.setText("2020");
		clickOn("#application1Reoprt");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nVintage Year is not in [1880, 2019].\n"));	
	}
	
	
	/**
	 * Application 1 test case: test dad name is empty
	 * 
	 */
	@Test
	public void testApplication1DadNameIsEmpty() {
		clickOn("#tabApp1");
		TextField iDadName = (TextField)s.lookup("#task4iDadName");
		iDadName.setText("");
		clickOn("#application1Reoprt");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nDad Name is empty.\n"));
	}
	
	
	/**
	 * Application 1 test case: test mom name is empty
	 * 
	 */
	@Test
	public void testApplication1MomNameIsEmpty() {
		clickOn("#tabApp1");
		TextField iMomName = (TextField)s.lookup("#task4iMomName");
		iMomName.setText("");
		clickOn("#application1Reoprt");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nMom Name is empty.\n"));
	}
	
	
	/**
	 * Application 1 test case: test dad name is an integer
	 * 
	 */
	@Test
	public void testApplication1DadNameIsInteger() {
		clickOn("#tabApp1");
		TextField iDadName = (TextField)s.lookup("#task4iDadName");
		iDadName.setText("123");
		clickOn("#application1Reoprt");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nDad Name is invalid.\n"));
	}
	
	
	/**
	 * Application 1 test case: test mom name is an integer
	 * 
	 */
	@Test
	public void testApplication1MomNameIsInteger() {
		clickOn("#tabApp1");
		TextField iMomName = (TextField)s.lookup("#task4iMomName");
		iMomName.setText("123");
		clickOn("#application1Reoprt");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nMom Name is invalid.\n"));
	}
	
	
	/**
	 * Application 1 test case: test dad name starting with a lowercase letter
	 * 
	 */
	@Test
	public void testApplication1DadNameDoesNotStartWithUppercase() {
		clickOn("#tabApp1");
		TextField iDadName = (TextField)s.lookup("#task4iDadName");
		iDadName.setText("david");
		clickOn("#application1Reoprt");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nDad Name is invalid.\n"));
	}
	
	
	/**
	 * Application 1 test case: test mom name starting with a lowercase letter
	 * 
	 */
	@Test
	public void testApplication1MomNameDoesNotStartWithUppercase() {
		clickOn("#tabApp1");
		TextField iMomName = (TextField)s.lookup("#task4iMomName");
		iMomName.setText("mary");
		clickOn("#application1Reoprt");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nMom Name is invalid.\n"));
	}
	
	
	/**
	 * Application 1 test case: test dad name is empty
	 * 
	 */
	@Test
	public void testApplication1iDadYOBIsEmpty() {
		clickOn("#tabApp1");
		TextField iDadYOB = (TextField)s.lookup("#task4iDadYOB");
		iDadYOB.setText("");
		clickOn("#application1Reoprt");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nDad Born Year is empty.\n"));
	}
	
	
	/**
	 * Application 1 test case: test mom name is empty
	 * 
	 */
	@Test
	public void testApplication1iMomYOBIsEmpty() {
		clickOn("#tabApp1");
		TextField iMomYOB = (TextField)s.lookup("#task4iMomYOB");
		iMomYOB.setText("");
		clickOn("#application1Reoprt");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nMom Born Year is empty.\n"));
	}
	
	
	/**
	 * Application 1 test case: test dad year of born with letters
	 * 
	 */
	@Test
	public void testApplication1iDadYOBIsNotInteger() {
		clickOn("#tabApp1");
		TextField iDadYOB = (TextField)s.lookup("#task4iDadYOB");
		iDadYOB.setText("hi");
		clickOn("#application1Reoprt");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nDad Born Year is not an integer.\n"));
	}
	
	
	/**
	 * Application 1 test case: test mom year of born with letters
	 * 
	 */
	@Test
	public void testApplication1iMomYOBIsNotInteger() {
		clickOn("#tabApp1");
		TextField iMomYOB = (TextField)s.lookup("#task4iMomYOB");
		iMomYOB.setText("bye");
		clickOn("#application1Reoprt");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nMom Born Year is not an integer.\n"));
	}
	
	
	/**
	 * Application 1 test case: test dad year of born is less than the earliest recorded year
	 * 
	 */
	@Test
	public void testApplication1iDadYOBIsLessThanRange() {
		clickOn("#tabApp1");
		TextField iDadYOB = (TextField)s.lookup("#task4iDadYOB");
		iDadYOB.setText("1879");
		clickOn("#application1Reoprt");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nDad Born Year is not in [1880, 2019].\n"));	
	}
	
	
	/**
	 * Application 1 test case: test mom year of born is less than the earliest recorded year
	 * 
	 */
	@Test
	public void testApplication1iMomYOBIsLessThanRange() {
		clickOn("#tabApp1");
		TextField iMomYOB = (TextField)s.lookup("#task4iMomYOB");
		iMomYOB.setText("1879");
		clickOn("#application1Reoprt");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nMom Born Year is not in [1880, 2019].\n"));	
	}
	
	
	/**
	 * Application 1 test case: test dad year of born is larger than the latest recorded year
	 * 
	 */
	@Test
	public void testApplication1iDadYOBIsMoreThanRange() {
		clickOn("#tabApp1");
		TextField iDadYOB = (TextField)s.lookup("#task4iDadYOB");
		iDadYOB.setText("2020");
		clickOn("#application1Reoprt");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nDad Born Year is not in [1880, 2019].\n"));	
	}
	
	
	/**
	 * Application 1 test case: test mom year of born is larger than the latest recorded year
	 * 
	 */
	@Test
	public void testApplication1iMomYOBIsMoreThanRange() {
		clickOn("#tabApp1");
		TextField iMomYOB = (TextField)s.lookup("#task4iMomYOB");
		iMomYOB.setText("2020");
		clickOn("#application1Reoprt");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nMom Born Year is not in [1880, 2019].\n"));	
	}
	
	
	/**
	 * Application 1 test case: test all inputs are empty
	 * 
	 */
	@Test
	public void testApplication1AllInputsAreEmpty() {
		clickOn("#tabApp1");
		TextField iDadName = (TextField)s.lookup("#task4iDadName");
		iDadName.setText("");
		TextField iMomName = (TextField)s.lookup("#task4iMomName");
		iMomName.setText("");
		TextField iDadYOB = (TextField)s.lookup("#task4iDadYOB");
		iDadYOB.setText("");
		TextField iMomYOB = (TextField)s.lookup("#task4iMomYOB");
		iMomYOB.setText("");
		clickOn("#application1Reoprt");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nDad Name is empty.\nMom Name is empty.\nDad Born Year is empty.\nMom Born Year is empty.\n"));
	}
	
	
	/**
	 * Application 1 test case: test a valid vintage year
	 * 
	 */
	@Test
	public void testApplication1ChangeVintageYear() {
		clickOn("#tabApp1");
		TextField vintageYear = (TextField)s.lookup("#task4iVintageYear");
		vintageYear.setText("1880");
		clickOn("#application1Reoprt");
		String s1 = t.getText();
		assertTrue(s1.equals(String.format("Recommended name for baby boy according to the NK-T4 Algorithm is %s.\nRecommended name for baby girl according to the NK-T4 Algorithm is %s.",
				AnalyzeNames.getName(1880, AnalyzeNames.getRank(1941,  "David", "M"), "M"), AnalyzeNames.getName(1880, AnalyzeNames.getRank(1945,  "Mary", "F"), "F"))));
	}
	
	
	/**
	 * Application 1 test case: both parents' name not found
	 * 
	 */
	@Test
	public void testApplication1BothParentNameNotFound() {
		clickOn("#tabApp1");
		TextField iDadName = (TextField)s.lookup("#task4iDadName");
		iDadName.setText("Haha");
		TextField iMomName = (TextField)s.lookup("#task4iMomName");
		iMomName.setText("Hehe");
		clickOn("#application1Reoprt");
		String s1 = t.getText();
		assertTrue(s1.equals(String.format("Recommended name for baby boy according to the NK-T4 Algorithm is %s.\nRecommended name for baby girl according to the NK-T4 Algorithm is %s.",
				AnalyzeNames.getName(2019, AnalyzeNames.getRank(1941,  "Haha", "M")+2, "M"), AnalyzeNames.getName(2019, AnalyzeNames.getRank(1945,  "Hehe", "F")+2, "F"))));
	}
	
  @Test
	public void task3NonNumericalTopNInput() {
		clickOn("#tabReport3");
		TextField R3_TopN = (TextField)s.lookup("#textfieldR3_TopN");
		R3_TopN.setText("abc");
		clickOn("#buttonR3_REPORT");
		String ss = t.getText();
		assertTrue(ss.equals("Please only enter numerical data."));
	}
	
	@Test
	public void task3NonNumericalYear1Input() {
		clickOn("#tabReport3");
		TextField R3_Year1 = (TextField)s.lookup("#textfieldR3_Year1");
		R3_Year1.setText("abc");
		clickOn("#buttonR3_REPORT");
		String ss = t.getText();
		assertTrue(ss.equals("Please only enter numerical data."));
	}
	
	@Test
	public void task3NonNumericalYear2Input() {
		clickOn("#tabReport3");
		TextField R3_Year2 = (TextField)s.lookup("#textfieldR3_Year2");
		R3_Year2.setText("abc");
		clickOn("#buttonR3_REPORT");
		String ss = t.getText();
		assertTrue(ss.equals("Please only enter numerical data."));
	}
	
	@Test
	public void task3WithNoGenderChosen() {
		clickOn("#tabReport3");
		clickOn("#buttonR3_REPORT");
		String ss = t.getText();
		assertTrue(ss.equals("Please specify a gender."));
	}
	
	@Test
	public void task3WithTopNEquals0() {
		clickOn("#tabReport3");
		RadioButton R3_M = (RadioButton)s.lookup("#radiobuttonR3_M");
		R3_M.setSelected(true);
		TextField R3_TopN = (TextField)s.lookup("#textfieldR3_TopN");
		R3_TopN.setText("0");
		clickOn("#buttonR3_REPORT");
		String ss = t.getText();
		assertTrue(ss.equals("Please enter a valid topN value."));
	}
	@Test
	public void task3WithYear1GreaterThanYear2() {
		clickOn("#tabReport3");
		RadioButton R3_M = (RadioButton)s.lookup("#radiobuttonR3_M");
		R3_M.setSelected(true);
		TextField R3_Year1 = (TextField)s.lookup("#textfieldR3_Year1");
		R3_Year1.setText("2000");
		TextField R3_Year2 = (TextField)s.lookup("#textfieldR3_Year2");
		R3_Year2.setText("1995");
		
		clickOn("#buttonR3_REPORT");
		String ss = t.getText();
		assertTrue(ss.equals("Please enter a valid range of years between 1880 and 2019 (inclusively)."));
	}
	
	@Test
	public void task3WithYear1EqualsYear2() {
		clickOn("#tabReport3");
		RadioButton R3_M = (RadioButton)s.lookup("#radiobuttonR3_M");
		R3_M.setSelected(true);
		TextField R3_Year1 = (TextField)s.lookup("#textfieldR3_Year1");
		R3_Year1.setText("2000");
		TextField R3_Year2 = (TextField)s.lookup("#textfieldR3_Year2");
		R3_Year2.setText("2000");
		
		clickOn("#buttonR3_REPORT");
		String ss = t.getText();
		assertTrue(ss.equals("Please enter a valid range of years between 1880 and 2019 (inclusively)."));
	}
	
	@Test
	public void task3WithYear1LessThan1880() {
		clickOn("#tabReport3");
		RadioButton R3_M = (RadioButton)s.lookup("#radiobuttonR3_M");
		R3_M.setSelected(true);
		
		TextField R3_Year1 = (TextField)s.lookup("#textfieldR3_Year1");
		R3_Year1.setText("1879");
		
		clickOn("#buttonR3_REPORT");
		String ss = t.getText();
		assertTrue(ss.equals("Please enter a valid range of years between 1880 and 2019 (inclusively)."));
	}
	
	@Test
	public void task3WithYear2GreaterThan2019() {
		clickOn("#tabReport3");
		RadioButton R3_F = (RadioButton)s.lookup("#radiobuttonR3_F");
		R3_F.setSelected(true);

		TextField R3_Year2 = (TextField)s.lookup("#textfieldR3_Year2");
		R3_Year2.setText("2020");
		
		clickOn("#buttonR3_REPORT");
		String ss = t.getText();
		assertTrue(ss.equals("Please enter a valid range of years between 1880 and 2019 (inclusively)."));
	}
	
	@Test
	public void task3WithValidInput1() {
		clickOn("#tabReport3");
		RadioButton R3_F = (RadioButton)s.lookup("#radiobuttonR3_F");
		R3_F.setSelected(true);
		TextField R3_Year1 = (TextField)s.lookup("#textfieldR3_Year1");
		R3_Year1.setText("1941");
		TextField R3_Year2 = (TextField)s.lookup("#textfieldR3_Year2");
		R3_Year2.setText("1945");
		TextField R3_TopN = (TextField)s.lookup("#textfieldR3_TopN");
		R3_TopN.setText("2");
		
		clickOn("#buttonR3_REPORT");
		String ss = t.getText();
		assertTrue(ss.equals("1 names are found to be maintained at a high level of popularity within Top 2 over the period from 1941 to 1945.\n\n"
				+ "Name         \tLowest Rank [in Year]\tHigest Rank [in Year]\tGross Trend\n\nMary         \t1 [1941]\t\t1 [1941]\t\tFLAT\n"));
	}
	
	@Test
	public void task3WithValidInput2() {
		clickOn("#tabReport3");
		RadioButton R3_F = (RadioButton)s.lookup("#radiobuttonR3_F");
		R3_F.setSelected(true);
		TextField R3_Year1 = (TextField)s.lookup("#textfieldR3_Year1");
		R3_Year1.setText("1946");
		TextField R3_Year2 = (TextField)s.lookup("#textfieldR3_Year2");
		R3_Year2.setText("1947");
		TextField R3_TopN = (TextField)s.lookup("#textfieldR3_TopN");
		R3_TopN.setText("3");
		
		clickOn("#buttonR3_REPORT");
		String ss = t.getText();
		assertTrue(ss.equals("3 names are found to be maintained at a high level of popularity within Top 3 over the period from 1946 to 1947.\n\n"
				+ "Name         \tLowest Rank [in Year]\tHigest Rank [in Year]\tGross Trend\n\n"
				+ "Mary         \t2 [1947]\t\t1 [1946]\t\tDOWN\n"
				+ "Linda        \t2 [1946]\t\t1 [1947]\t\tUP\n"
				+ "Patricia     \t3 [1946]\t\t3 [1946]\t\tFLAT\n"));
	}
	
	@Test
	public void task3WithZeroFound() {
		clickOn("#tabReport3");
		RadioButton R3_M = (RadioButton)s.lookup("#radiobuttonR3_F");
		R3_M.setSelected(true);
		TextField R3_Year1 = (TextField)s.lookup("#textfieldR3_Year1");
		R3_Year1.setText("1880");
		TextField R3_Year2 = (TextField)s.lookup("#textfieldR3_Year2");
		R3_Year2.setText("2019");
		TextField R3_TopN = (TextField)s.lookup("#textfieldR3_TopN");
		R3_TopN.setText("25");
		
		clickOn("#buttonR3_REPORT");
		String ss = t.getText();
		assertTrue(ss.equals("0 names are found to be maintained at a high level of popularity within Top 25 over the period from 1880 to 2019.\n\n"
				+ "Name         \tLowest Rank [in Year]\tHigest Rank [in Year]\tGross Trend\n\n"));
	}
	
	@Test
	public void app3WithBlankNames() {
		clickOn("#tabApp3");
		clickOn("#buttonA3_Submit");
		String ss = t.getText();
		assertTrue(ss.equals("Empty names are not accepted."));
	}
	
	@Test
	public void app3WithBlankiName() {
		clickOn("#tabApp3");
		TextField iNameMate = (TextField)s.lookup("#textfieldA3_iNameMate");
		iNameMate.setText("haha");
		clickOn("#buttonA3_Submit");
		String ss = t.getText();
		assertTrue(ss.equals("Empty names are not accepted."));
	}
	
	@Test
	public void app3WithBlankiNameMate() {
		clickOn("#tabApp3");
		TextField iName = (TextField)s.lookup("#textfieldA3_iName");
		iName.setText("haha");
		clickOn("#buttonA3_Submit");
		String ss = t.getText();
		assertTrue(ss.equals("Empty names are not accepted."));
	}
	
	@Test
	public void app3iNameWithSpace() {
		clickOn("#tabApp3");
		
		TextField iName = (TextField)s.lookup("#textfieldA3_iName");
		iName.setText("h aha");
		TextField iNameMate = (TextField)s.lookup("#textfieldA3_iNameMate");
		iNameMate.setText("haha");
		
		clickOn("#buttonA3_Submit");
		String ss = t.getText();
		assertTrue(ss.equals("Names should not contain any space character."));
	}
	
	@Test
	public void app3iNameMateWithSpace() {
		clickOn("#tabApp3");
		
		TextField iName = (TextField)s.lookup("#textfieldA3_iName");
		iName.setText("haha");
		TextField iNameMate = (TextField)s.lookup("#textfieldA3_iNameMate");
		iNameMate.setText("ha ha");
		
		clickOn("#buttonA3_Submit");
		String ss = t.getText();
		assertTrue(ss.equals("Names should not contain any space character."));
	}
	
	@Test
	public void app3iNameWithNumber() {
		clickOn("#tabApp3");
		
		TextField iName = (TextField)s.lookup("#textfieldA3_iName");
		iName.setText("ha1ha");
		TextField iNameMate = (TextField)s.lookup("#textfieldA3_iNameMate");
		iNameMate.setText("haha");
		
		clickOn("#buttonA3_Submit");
		String ss = t.getText();
		assertTrue(ss.equals("Names should not contain any number."));
	}
	
	@Test
	public void app3iNameMateWithNumber() {
		clickOn("#tabApp3");
		
		TextField iName = (TextField)s.lookup("#textfieldA3_iName");
		iName.setText("haha");
		TextField iNameMate = (TextField)s.lookup("#textfieldA3_iNameMate");
		iNameMate.setText("ha123ha");
		
		clickOn("#buttonA3_Submit");
		String ss = t.getText();
		assertTrue(ss.equals("Names should not contain any number."));
	}
	
	@Test
	public void app3iYOBWithNonNumericalInput() {
		clickOn("#tabApp3");
		
		TextField iName = (TextField)s.lookup("#textfieldA3_iName");
		iName.setText("haha");
		TextField iNameMate = (TextField)s.lookup("#textfieldA3_iNameMate");
		iNameMate.setText("haha");
		TextField iYOB = (TextField)s.lookup("#textfieldA3_iYOB");
		iYOB.setText("not a year");
		
		clickOn("#buttonA3_Submit");
		String ss = t.getText();
		assertTrue(ss.equals("Please enter a VALID year of birth."));
	}
	
	@Test
	public void app3iYOBLessThan1880() {
		clickOn("#tabApp3");
		
		TextField iName = (TextField)s.lookup("#textfieldA3_iName");
		iName.setText("haha");
		TextField iNameMate = (TextField)s.lookup("#textfieldA3_iNameMate");
		iNameMate.setText("haha");
		TextField iYOB = (TextField)s.lookup("#textfieldA3_iYOB");
		iYOB.setText("1879");
		
		clickOn("#buttonA3_Submit");
		String ss = t.getText();
		assertTrue(ss.equals("Please provide a year between 1880 and 2019 (inclusively)."));
	}
	
	@Test
	public void app3iYOBGreaterThan2019() {
		clickOn("#tabApp3");
		
		TextField iName = (TextField)s.lookup("#textfieldA3_iName");
		iName.setText("haha");
		TextField iNameMate = (TextField)s.lookup("#textfieldA3_iNameMate");
		iNameMate.setText("haha");
		TextField iYOB = (TextField)s.lookup("#textfieldA3_iYOB");
		iYOB.setText("2020");
		
		clickOn("#buttonA3_Submit");
		String ss = t.getText();
		assertTrue(ss.equals("Please provide a year between 1880 and 2019 (inclusively)."));
	}
	
	@Test
	public void app3withNoiGender() {
		clickOn("#tabApp3");
		
		TextField iName = (TextField)s.lookup("#textfieldA3_iName");
		iName.setText("haha");
		TextField iNameMate = (TextField)s.lookup("#textfieldA3_iNameMate");
		iNameMate.setText("haha");
		TextField iYOB = (TextField)s.lookup("#textfieldA3_iYOB");
		iYOB.setText("2015");
		
		clickOn("#buttonA3_Submit");
		String ss = t.getText();
		assertTrue(ss.equals("Please specify your gender."));
	}
	
	@Test
	public void app3withNoiGenderMate() {
		clickOn("#tabApp3");
		
		TextField iName = (TextField)s.lookup("#textfieldA3_iName");
		iName.setText("haha");
		TextField iNameMate = (TextField)s.lookup("#textfieldA3_iNameMate");
		iNameMate.setText("haha");
		TextField iYOB = (TextField)s.lookup("#textfieldA3_iYOB");
		iYOB.setText("2015");
		RadioButton iGenderM = (RadioButton)s.lookup("#radiobuttonA3_iGenderM");
		iGenderM.setSelected(true);
		
		clickOn("#buttonA3_Submit");
		String ss = t.getText();
		assertTrue(ss.equals("Please specify the gender of the other person."));
	}
	
	@Test
	public void app3WithNoPref() {
		clickOn("#tabApp3");
		
		TextField iName = (TextField)s.lookup("#textfieldA3_iName");
		iName.setText("haha");
		TextField iNameMate = (TextField)s.lookup("#textfieldA3_iNameMate");
		iNameMate.setText("haha");
		TextField iYOB = (TextField)s.lookup("#textfieldA3_iYOB");
		iYOB.setText("2015");
		RadioButton iGenderF = (RadioButton)s.lookup("#radiobuttonA3_iGenderF");
		iGenderF.setSelected(true);
		RadioButton iGenderMateM = (RadioButton)s.lookup("#radiobuttonA3_iGenderMateM");
		iGenderMateM.setSelected(true);
		
		clickOn("#buttonA3_Submit");
		String ss = t.getText();
		assertTrue(ss.equals("Please specify your preference for a younger or older soulmate."));
	}
	
	@Test
	public void app3CannotFindNames() {
		clickOn("#tabApp3");
		
		TextField iName = (TextField)s.lookup("#textfieldA3_iName");
		iName.setText("haha");
		TextField iNameMate = (TextField)s.lookup("#textfieldA3_iNameMate");
		iNameMate.setText("haha");
		TextField iYOB = (TextField)s.lookup("#textfieldA3_iYOB");
		iYOB.setText("2015");
		RadioButton iGenderF = (RadioButton)s.lookup("#radiobuttonA3_iGenderF");
		iGenderF.setSelected(true);
		RadioButton iGenderMateF = (RadioButton)s.lookup("#radiobuttonA3_iGenderMateF");
		iGenderMateF.setSelected(true);
		RadioButton iPrefO = (RadioButton)s.lookup("#radiobuttonA3_iPrefO");
		iPrefO.setSelected(true);		
		
		clickOn("#buttonA3_Submit"); //sleep(10000);
		String ss = t.getText();
		assertTrue(ss.equals("You score 100% for love matching!\n(0%: Not Compatible; 100%: Perfect Match)\n"));
	}

	@Test
	public void app3WithNormalInput() {
		clickOn("#tabApp3");
		
		TextField iName = (TextField)s.lookup("#textfieldA3_iName");
		iName.setText("Harper");
		TextField iNameMate = (TextField)s.lookup("#textfieldA3_iNameMate");
		iNameMate.setText("Zoey");
		TextField iYOB = (TextField)s.lookup("#textfieldA3_iYOB");
		iYOB.setText("2014");
		RadioButton iGenderF = (RadioButton)s.lookup("#radiobuttonA3_iGenderF");
		iGenderF.setSelected(true);
		RadioButton iGenderMateF = (RadioButton)s.lookup("#radiobuttonA3_iGenderMateF");
		iGenderMateF.setSelected(true);
		RadioButton iPrefY = (RadioButton)s.lookup("#radiobuttonA3_iPrefY");
		iPrefY.setSelected(true);		
		
		clickOn("#buttonA3_Submit"); //sleep(10000);
		String ss = t.getText();
		assertTrue(ss.equals("You score 46% for love matching!\n(0%: Not Compatible; 100%: Perfect Match)\n"));
	}
}
