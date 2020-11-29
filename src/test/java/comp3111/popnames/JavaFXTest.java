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
		assertTrue(s1.equals("Year\tTop 1          \tTop 2          \tTop 3          \tTop 4          \tTop 5          \tTop 6          \tTop 7          \tTop 8          \tTop 9          \tTop 10         \t\n" + 
				"1941\tJames          \tRobert         \tJohn           \tWilliam        \tRichard        \tCharles        \tDavid          \tThomas         \tRonald         \tDonald         \t\n" + 
				"1942\tJames          \tRobert         \tJohn           \tWilliam        \tRichard        \tDavid          \tCharles        \tThomas         \tRonald         \tDonald         \t\n" + 
				"1943\tJames          \tRobert         \tJohn           \tWilliam        \tRichard        \tDavid          \tCharles        \tThomas         \tRonald         \tMichael        \t\n" + 
				"1944\tJames          \tRobert         \tJohn           \tWilliam        \tRichard        \tDavid          \tCharles        \tThomas         \tMichael        \tRonald         \t\n" + 
				"1945\tJames          \tRobert         \tJohn           \tWilliam        \tRichard        \tDavid          \tCharles        \tThomas         \tMichael        \tRonald         \t\n" + 
				"Over the period 1941 to 1945, James for M has hold the top spot most often for a total of 375534 times."));		
    }
	
	@Test
	public void testTask1TopNIsEmpty() {
		clickOn("#tabReport1");
		TextField topN = (TextField)s.lookup("#task1TopN");
		topN.setText("");
		clickOn("#task1Report");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nTop N is Empty.\n"));
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
		topN.setText("-10");
		clickOn("#task1Report");
		String s1 = t.getText();
		assertTrue(s1.equals("Invalid input.\nTop N is not positive.\n"));
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
		assertTrue(s1.equals("Invalid input.\nStartingYear is Empty.\n"));
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
	public void testTask1StartingYearIsNotInRange() {
		clickOn("#tabReport1");
		TextField topN = (TextField)s.lookup("#task1TopN");
		topN.setText("1");
		TextField startingYear = (TextField)s.lookup("#task1StartingYear");
		startingYear.setText("2077");
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
		assertTrue(s1.equals("Invalid input.\nEndingYear is Empty.\n"));
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
	public void testTask1EndingYearIsNotInRange() {
		clickOn("#tabReport1");
		TextField topN = (TextField)s.lookup("#task1TopN");
		topN.setText("1");
		TextField startingYear = (TextField)s.lookup("#task1StartingYear");
		startingYear.setText("1941");
		TextField endingYear = (TextField)s.lookup("#task1EndingYear");
		endingYear.setText("2077");
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
		sleep(1000);
		clickOn("#task1Report");
		String s1 = t.getText();
		assertTrue(s1.equals("Year\tTop 1          \t\n" + 
				"1945\tMary           \t\n" + 
				"Over the period 1945 to 1945, Mary for F has hold the top spot most often for a total of 59284 times."));		
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
		assertTrue(s1.equals("Year\tTop 1          \t\n" + 
				"1952\tJames          \t\n" + 
				"1953\tRobert         \t\n" + 
				"1954\tMichael        \t\n" + 
				"1955\tMichael        \t\n" + 
				"1956\tMichael        \t\n" + 
				"Over the period 1952 to 1956, Michael for M has hold the top spot most often for a total of 430587 times."));
	}
}