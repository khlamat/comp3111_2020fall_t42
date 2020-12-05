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
