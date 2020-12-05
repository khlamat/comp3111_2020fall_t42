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
	
	/* Task 1 Test*/
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
	
	@Test
	public void testTask1TopNIsEmpty() {
		clickOn("#tabReport1");
		TextField topN = (TextField)s.lookup("#task1TopN");
		topN.setText("");
		clickOn("#task1Report");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nTop N is empty.\n"));
	}
	
	@Test
	public void testTask1TopNIsNotInteger() {
		clickOn("#tabReport1");
		TextField topN = (TextField)s.lookup("#task1TopN");
		topN.setText("@");
		clickOn("#task1Report");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nTop N is not an integer.\n"));
	}
	
	@Test
	public void testTask1TopNIsNotPositive() {
		clickOn("#tabReport1");
		TextField topN = (TextField)s.lookup("#task1TopN");
		topN.setText("0");
		clickOn("#task1Report");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nTop N is not positive.\n"));
	}
	
	@Test
	public void testTask1TopNIsTooLarge() {
		clickOn("#tabReport1");
		TextField topN = (TextField)s.lookup("#task1TopN");
		topN.setText("10001");
		clickOn("#task1Report");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nTop N is more than the number of recorded names for each year.\n"));
	}
	
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
	
	/* Application 1 Test*/
	@Test
	public void testApplication1DefaultInput() {
		clickOn("#tabApp1");
		clickOn("#application1Reoprt");
		String s1 = t.getText();
		assertTrue(s1.equals(String.format("Recommended name for baby boy according to the NK-T4 Algorithm is %s.\nRecommended name for baby girl according to the NK-T4 Algorithm is %s.",
				AnalyzeNames.getName(2019, AnalyzeNames.getRank(1941,  "David", "M"), "M"), AnalyzeNames.getName(2019, AnalyzeNames.getRank(1945,  "Mary", "F"), "F"))));
	}
	
	@Test
	public void testApplication1VintageYearIsNotInteger() {
		clickOn("#tabApp1");
		TextField vintageYear = (TextField)s.lookup("#task4iVintageYear");
		vintageYear.setText("~");
		clickOn("#application1Reoprt");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nVintage Year is not an integer.\n"));
	}
	
	@Test
	public void testApplication1VintageYearIsLessThanRange() {
		clickOn("#tabApp1");
		TextField vintageYear = (TextField)s.lookup("#task4iVintageYear");
		vintageYear.setText("1879");
		clickOn("#application1Reoprt");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nVintage Year is not in [1880, 2019].\n"));	
	}
	
	@Test
	public void testApplication1VintageYearIsMoreThanRange() {
		clickOn("#tabApp1");
		TextField vintageYear = (TextField)s.lookup("#task4iVintageYear");
		vintageYear.setText("2020");
		clickOn("#application1Reoprt");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nVintage Year is not in [1880, 2019].\n"));	
	}
	
	@Test
	public void testApplication1DadNameIsEmpty() {
		clickOn("#tabApp1");
		TextField iDadName = (TextField)s.lookup("#task4iDadName");
		iDadName.setText("");
		clickOn("#application1Reoprt");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nDad Name is empty.\n"));
	}
	
	@Test
	public void testApplication1MomNameIsEmpty() {
		clickOn("#tabApp1");
		TextField iMomName = (TextField)s.lookup("#task4iMomName");
		iMomName.setText("");
		clickOn("#application1Reoprt");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nMom Name is empty.\n"));
	}
	
	@Test
	public void testApplication1DadNameIsInteger() {
		clickOn("#tabApp1");
		TextField iDadName = (TextField)s.lookup("#task4iDadName");
		iDadName.setText("123");
		clickOn("#application1Reoprt");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nDad Name is invalid.\n"));
	}
	
	@Test
	public void testApplication1MomNameIsInteger() {
		clickOn("#tabApp1");
		TextField iMomName = (TextField)s.lookup("#task4iMomName");
		iMomName.setText("123");
		clickOn("#application1Reoprt");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nMom Name is invalid.\n"));
	}
	
	@Test
	public void testApplication1DadNameDoesNotStartWithUppercase() {
		clickOn("#tabApp1");
		TextField iDadName = (TextField)s.lookup("#task4iDadName");
		iDadName.setText("david");
		clickOn("#application1Reoprt");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nDad Name is invalid.\n"));
	}
	
	@Test
	public void testApplication1MomNameDoesNotStartWithUppercase() {
		clickOn("#tabApp1");
		TextField iMomName = (TextField)s.lookup("#task4iMomName");
		iMomName.setText("mary");
		clickOn("#application1Reoprt");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nMom Name is invalid.\n"));
	}
	
	@Test
	public void testApplication1iDadYOBIsEmpty() {
		clickOn("#tabApp1");
		TextField iDadYOB = (TextField)s.lookup("#task4iDadYOB");
		iDadYOB.setText("");
		clickOn("#application1Reoprt");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nDad Born Year is empty.\n"));
	}
	
	@Test
	public void testApplication1iMomYOBIsEmpty() {
		clickOn("#tabApp1");
		TextField iMomYOB = (TextField)s.lookup("#task4iMomYOB");
		iMomYOB.setText("");
		clickOn("#application1Reoprt");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nMom Born Year is empty.\n"));
	}
	
	@Test
	public void testApplication1iDadYOBIsNotInteger() {
		clickOn("#tabApp1");
		TextField iDadYOB = (TextField)s.lookup("#task4iDadYOB");
		iDadYOB.setText("hi");
		clickOn("#application1Reoprt");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nDad Born Year is not an integer.\n"));
	}
	
	@Test
	public void testApplication1iMomYOBIsNotInteger() {
		clickOn("#tabApp1");
		TextField iMomYOB = (TextField)s.lookup("#task4iMomYOB");
		iMomYOB.setText("bye");
		clickOn("#application1Reoprt");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nMom Born Year is not an integer.\n"));
	}
	
	@Test
	public void testApplication1iDadYOBIsLessThanRange() {
		clickOn("#tabApp1");
		TextField iDadYOB = (TextField)s.lookup("#task4iDadYOB");
		iDadYOB.setText("1879");
		clickOn("#application1Reoprt");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nDad Born Year is not in [1880, 2019].\n"));	
	}
	
	@Test
	public void testApplication1iMomYOBIsLessThanRange() {
		clickOn("#tabApp1");
		TextField iMomYOB = (TextField)s.lookup("#task4iMomYOB");
		iMomYOB.setText("1879");
		clickOn("#application1Reoprt");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nMom Born Year is not in [1880, 2019].\n"));	
	}
	
	@Test
	public void testApplication1iDadYOBIsMoreThanRange() {
		clickOn("#tabApp1");
		TextField iDadYOB = (TextField)s.lookup("#task4iDadYOB");
		iDadYOB.setText("2020");
		clickOn("#application1Reoprt");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nDad Born Year is not in [1880, 2019].\n"));	
	}
	
	@Test
	public void testApplication1iMomYOBIsMoreThanRange() {
		clickOn("#tabApp1");
		TextField iMomYOB = (TextField)s.lookup("#task4iMomYOB");
		iMomYOB.setText("2020");
		clickOn("#application1Reoprt");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nMom Born Year is not in [1880, 2019].\n"));	
	}
	
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
	
}
