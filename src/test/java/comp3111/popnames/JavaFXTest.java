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
/*
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
		clickOn("#tabTaskZero");
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
		clickOn("#tabTaskZero");
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
	*/
	/* Task 1 Test*//*
	@Test
	public void testDefaultInput() {
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
	public void testTopNIsEmpty() {
		clickOn("#tabReport1");
		TextField topN = (TextField)s.lookup("#task1TopN");
		topN.setText("");
		clickOn("#task1Report");
		String s1 = t.getText();
		assertTrue(s1.equals("Top N is Empty."));
	}
	
	@Test
	public void testTopNIsNotInteger() {
		clickOn("#tabReport1");
		TextField topN = (TextField)s.lookup("#task1TopN");
		topN.setText("@");
		clickOn("#task1Report");
		String s1 = t.getText();
		assertTrue(s1.equals("Top N is not an integer."));
	}
	
	@Test
	public void testTopNIsNotPositive() {
		clickOn("#tabReport1");
		TextField topN = (TextField)s.lookup("#task1TopN");
		topN.setText("-10");
		clickOn("#task1Report");
		String s1 = t.getText();
		assertTrue(s1.equals("Top N is not positive."));
	}
	
	@Test
	public void testStartingYearIsEmpty() {
		clickOn("#tabReport1");
		TextField topN = (TextField)s.lookup("#task1TopN");
		topN.setText("1");
		TextField startingYear = (TextField)s.lookup("#task1StartingYear");
		startingYear.setText("");
		clickOn("#task1Report");
		String s1 = t.getText();
		assertTrue(s1.equals("StartingYear is Empty."));
	}
	
	@Test
	public void testStartingYearIsNotInteger() {
		clickOn("#tabReport1");
		TextField topN = (TextField)s.lookup("#task1TopN");
		topN.setText("1");
		TextField startingYear = (TextField)s.lookup("#task1StartingYear");
		startingYear.setText("f");
		clickOn("#task1Report");
		String s1 = t.getText();
		assertTrue(s1.equals("StartingYear is not an integer."));
	}
	
	@Test
	public void testStartingYearIsNotInRange() {
		clickOn("#tabReport1");
		TextField topN = (TextField)s.lookup("#task1TopN");
		topN.setText("1");
		TextField startingYear = (TextField)s.lookup("#task1StartingYear");
		startingYear.setText("2077");
		clickOn("#task1Report");
		String s1 = t.getText();
		assertTrue(s1.equals("StartingYear is not in [1880, 2019]."));	
	}
	
	@Test
	public void testEndingYearIsEmpty() {
		clickOn("#tabReport1");
		TextField topN = (TextField)s.lookup("#task1TopN");
		topN.setText("1");
		TextField startingYear = (TextField)s.lookup("#task1StartingYear");
		startingYear.setText("1941");
		TextField endingYear = (TextField)s.lookup("#task1EndingYear");
		endingYear.setText("");
		clickOn("#task1Report");
		String s1 = t.getText();
		assertTrue(s1.equals("EndingYear is Empty."));
	}
	
	@Test
	public void testEndingYearIsNotInteger() {
		clickOn("#tabReport1");
		TextField topN = (TextField)s.lookup("#task1TopN");
		topN.setText("1");
		TextField startingYear = (TextField)s.lookup("#task1StartingYear");
		startingYear.setText("1941");
		TextField endingYear = (TextField)s.lookup("#task1EndingYear");
		endingYear.setText("-");
		clickOn("#task1Report");
		String s1 = t.getText();
		assertTrue(s1.equals("EndingYear is not an integer."));
	}
	
	@Test
	public void testEndingYearIsNotInRange() {
		clickOn("#tabReport1");
		TextField topN = (TextField)s.lookup("#task1TopN");
		topN.setText("1");
		TextField startingYear = (TextField)s.lookup("#task1StartingYear");
		startingYear.setText("1941");
		TextField endingYear = (TextField)s.lookup("#task1EndingYear");
		endingYear.setText("2077");
		clickOn("#task1Report");
		String s1 = t.getText();
		assertTrue(s1.equals("EndingYear is not in [1880, 2019]."));
	}
	
	@Test
	public void testEndingYearIsSmallerThanStartingYear() {
		clickOn("#tabReport1");
		TextField topN = (TextField)s.lookup("#task1TopN");
		topN.setText("1");
		TextField startingYear = (TextField)s.lookup("#task1StartingYear");
		startingYear.setText("1941");
		TextField endingYear = (TextField)s.lookup("#task1EndingYear");
		endingYear.setText("1940");
		clickOn("#task1Report");
		String s1 = t.getText();
		assertTrue(s1.equals("EndingYear should not be less than StartingYear."));
	}
	*/
}