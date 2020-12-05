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

public class Task5Test extends ApplicationTest {

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
	public void testTask5DefaultInput() {	
		clickOn("#tabApp2");
		clickOn("#dot5");
		String s1 = t.getText();
		assertTrue(s1.equals("The recommanded names for compatible pairs is Judith."));
	}

	@Test
	public void testTask5malepairyoungerfemale() {	
		clickOn("#tabApp2");
		TextField t5Name = (TextField)s.lookup("#t5name");
		t5Name.setText("Tyler");
		RadioButton t5male = (RadioButton)s.lookup("#t5male");
		t5male.setSelected(true);
		TextField t5year = (TextField)s.lookup("#t5year");
		t5year.setText("2000");
		RadioButton t5ifemale = (RadioButton)s.lookup("#t5ifemale");
		t5ifemale.setSelected(true);
		RadioButton t5younger = (RadioButton)s.lookup("#t5younger");
		t5younger.setSelected(true);
		clickOn("#dot5");
		String s1 = t.getText();
		assertTrue(s1.equals("The recommanded names for compatible pairs is Olivia."));
	}
	
	@Test
	public void testTask5malepairolderfemale() {	
		clickOn("#tabApp2");
		TextField t5Name = (TextField)s.lookup("#t5name");
		t5Name.setText("Kevin");
		RadioButton t5male = (RadioButton)s.lookup("#t5male");
		t5male.setSelected(true);
		TextField t5year = (TextField)s.lookup("#t5year");
		t5year.setText("1960");
		RadioButton t5ifemale = (RadioButton)s.lookup("#t5ifemale");
		t5ifemale.setSelected(true);
		RadioButton t5older = (RadioButton)s.lookup("#t5older");
		t5older.setSelected(true);
		clickOn("#dot5");
		String s1 = t.getText();
		assertTrue(s1.equals("The recommanded names for compatible pairs is Kathy."));
	}
	
	@Test
	public void testTask5malepairyoungermale() {	
		clickOn("#tabApp2");
		TextField t5Name = (TextField)s.lookup("#t5name");
		t5Name.setText("Joe");
		RadioButton t5male = (RadioButton)s.lookup("#t5male");
		t5male.setSelected(true);
		TextField t5year = (TextField)s.lookup("#t5year");
		t5year.setText("1880");
		RadioButton t5imale = (RadioButton)s.lookup("#t5imale");
		t5imale.setSelected(true);
		RadioButton t5younger = (RadioButton)s.lookup("#t5younger");
		t5younger.setSelected(true);
		clickOn("#dot5");
		String s1 = t.getText();
		assertTrue(s1.equals("The recommanded names for compatible pairs is Charlie."));
	}
	
	@Test
	public void testTask5malepairoldermale() {	
		clickOn("#tabApp2");
		TextField t5Name = (TextField)s.lookup("#t5name");
		t5Name.setText("Joshua");
		RadioButton t5male = (RadioButton)s.lookup("#t5male");
		t5male.setSelected(true);
		TextField t5year = (TextField)s.lookup("#t5year");
		t5year.setText("2007");
		RadioButton t5imale = (RadioButton)s.lookup("#t5imale");
		t5imale.setSelected(true);
		RadioButton t5older = (RadioButton)s.lookup("#t5older");
		t5older.setSelected(true);
		clickOn("#dot5");
		String s1 = t.getText();
		assertTrue(s1.equals("The recommanded names for compatible pairs is Ethan."));
	}
	
	@Test
	public void testTask5femalepairyoungermale() {	
		clickOn("#tabApp2");
		TextField t5Name = (TextField)s.lookup("#t5name");
		t5Name.setText("Emily");
		RadioButton t5female = (RadioButton)s.lookup("#t5female");
		t5female.setSelected(true);
		TextField t5year = (TextField)s.lookup("#t5year");
		t5year.setText("2010");
		RadioButton t5imale = (RadioButton)s.lookup("#t5imale");
		t5imale.setSelected(true);
		RadioButton t5younger = (RadioButton)s.lookup("#t5younger");
		t5younger.setSelected(true);
		clickOn("#dot5");
		String s1 = t.getText();
		assertTrue(s1.equals("The recommanded names for compatible pairs is Michael."));
	}
	
	@Test
	public void testTask5femalepairoldermale() {	
		clickOn("#tabApp2");
		TextField t5Name = (TextField)s.lookup("#t5name");
		t5Name.setText("Ashley	");
		RadioButton t5female = (RadioButton)s.lookup("#t5female");
		t5female.setSelected(true);
		TextField t5year = (TextField)s.lookup("#t5year");
		t5year.setText("2007");
		RadioButton t5imale = (RadioButton)s.lookup("#t5imale");
		t5imale.setSelected(true);
		RadioButton t5older = (RadioButton)s.lookup("#t5older");
		t5older.setSelected(true);
		clickOn("#dot5");
		String s1 = t.getText();
		assertTrue(s1.equals("The recommanded names for compatible pairs is David."));
	}
	
	@Test
	public void testTask5femalepairyoungerfemale() {	
		clickOn("#tabApp2");
		TextField t5Name = (TextField)s.lookup("#t5name");
		t5Name.setText("Jessica");
		RadioButton t5female = (RadioButton)s.lookup("#t5female");
		t5female.setSelected(true);
		TextField t5year = (TextField)s.lookup("#t5year");
		t5year.setText("1999");
		RadioButton t5ifemale = (RadioButton)s.lookup("#t5ifemale");
		t5ifemale.setSelected(true);
		RadioButton t5younger = (RadioButton)s.lookup("#t5younger");
		t5younger.setSelected(true);
		clickOn("#dot5");
		String s1 = t.getText();
		assertTrue(s1.equals("The recommanded names for compatible pairs is Elizabeth."));
	}
	
	@Test
	public void testTask5femalepairolderfemale() {	
		clickOn("#tabApp2");
		TextField t5Name = (TextField)s.lookup("#t5name");
		t5Name.setText("Bertha");
		RadioButton t5female = (RadioButton)s.lookup("#t5female");
		t5female.setSelected(true);
		TextField t5year = (TextField)s.lookup("#t5year");
		t5year.setText("1899");
		RadioButton t5ifemale = (RadioButton)s.lookup("#t5ifemale");
		t5ifemale.setSelected(true);
		RadioButton t5older = (RadioButton)s.lookup("#t5older");
		t5older.setSelected(true);
		clickOn("#dot5");
		String s1 = t.getText();
		assertTrue(s1.equals("The recommanded names for compatible pairs is Bessie."));
	}
	
	@Test
	public void testTask52019younger(){
		clickOn("#tabApp2");
		TextField t5Name = (TextField)s.lookup("#t5name");
		t5Name.setText("Oliver");
		RadioButton t5male = (RadioButton)s.lookup("#t5male");
		t5male.setSelected(true);
		TextField t5year = (TextField)s.lookup("#t5year");
		t5year.setText("2019");
		RadioButton t5ifemale = (RadioButton)s.lookup("#t5ifemale");
		t5ifemale.setSelected(true);
		RadioButton t5younger = (RadioButton)s.lookup("#t5younger");
		t5younger.setSelected(true);
		clickOn("#dot5");
		String s1 = t.getText();
		assertTrue(s1.equals("There are some invalid input, below is the summary.\n" + 
				"dataset is up to 2019, we cannot predict your younger soulmate. Sorry for inconvenience.\n"));
	}
	
	@Test
	public void testTask52019older(){
		clickOn("#tabApp2");
		TextField t5Name = (TextField)s.lookup("#t5name");
		t5Name.setText("Jackson");
		RadioButton t5male = (RadioButton)s.lookup("#t5male");
		t5male.setSelected(true);
		TextField t5year = (TextField)s.lookup("#t5year");
		t5year.setText("2019");
		RadioButton t5ifemale = (RadioButton)s.lookup("#t5ifemale");
		t5ifemale.setSelected(true);
		RadioButton t5older = (RadioButton)s.lookup("#t5older");
		t5older.setSelected(true);
		clickOn("#dot5");
		String s1 = t.getText();
		assertTrue(s1.equals("The recommanded names for compatible pairs is Sofia."));
	}
	
	@Test
	public void testTask51880younger(){
		clickOn("#tabApp2");
		TextField t5Name = (TextField)s.lookup("#t5name");
		t5Name.setText("Ella");
		RadioButton t5female = (RadioButton)s.lookup("#t5female");
		t5female.setSelected(true);
		TextField t5year = (TextField)s.lookup("#t5year");
		t5year.setText("1880");
		RadioButton t5imale = (RadioButton)s.lookup("#t5imale");
		t5imale.setSelected(true);
		RadioButton t5younger = (RadioButton)s.lookup("#t5younger");
		t5younger.setSelected(true);
		clickOn("#dot5");
		String s1 = t.getText();
		assertTrue(s1.equals("The recommanded names for compatible pairs is Walter."));
	}
	
	@Test
	public void testTask51880older(){
		clickOn("#tabApp2");
		TextField t5Name = (TextField)s.lookup("#t5name");
		t5Name.setText("Clara");
		RadioButton t5female = (RadioButton)s.lookup("#t5female");
		t5female.setSelected(true);
		TextField t5year = (TextField)s.lookup("#t5year");
		t5year.setText("1880");
		RadioButton t5imale = (RadioButton)s.lookup("#t5imale");
		t5imale.setSelected(true);
		RadioButton t5older = (RadioButton)s.lookup("#t5older");
		t5older.setSelected(true);
		clickOn("#dot5");
		String s1 = t.getText();
		assertTrue(s1.equals("There are some invalid input, below is the summary.\n" + 
				"dataset is down to 1880, we cannot predict your older soulmate. Sorry for inconvenience.\n"));
	}

	@Test
	public void testTask5EmptyInput() {	
		clickOn("#tabApp2");
		TextField t5Name = (TextField)s.lookup("#t5name");
		t5Name.setText("");
		RadioButton t5male = (RadioButton)s.lookup("#t5male");
		t5male.setSelected(true);
		TextField t5year = (TextField)s.lookup("#t5year");
		t5year.setText("");
		RadioButton t5ifemale = (RadioButton)s.lookup("#t5ifemale");
		t5ifemale.setSelected(true);
		RadioButton t5younger = (RadioButton)s.lookup("#t5younger");
		t5younger.setSelected(true);
		clickOn("#dot5");
		String s1 = t.getText();
		assertTrue(s1.equals("There are some invalid input, below is the summary.\n" + 
				"iName is missing. Please enter iName.\n" + 
				"iYOB is missing. Please enter iYOB.\n"));
	}
	
	@Test
	public void testTask5emptyInvalidInput1() {	
		clickOn("#tabApp2");
		TextField t5Name = (TextField)s.lookup("#t5name");
		t5Name.setText("Dav%id");
		RadioButton t5male = (RadioButton)s.lookup("#t5male");
		t5male.setSelected(true);
		TextField t5year = (TextField)s.lookup("#t5year");
		t5year.setText("1@32");
		RadioButton t5ifemale = (RadioButton)s.lookup("#t5ifemale");
		t5ifemale.setSelected(true);
		RadioButton t5younger = (RadioButton)s.lookup("#t5younger");
		t5younger.setSelected(true);
		clickOn("#dot5");
		String s1 = t.getText();
		assertTrue(s1.equals("There are some invalid input, below is the summary.\n" + 
				"Invalid iName,there are some special characters or number(eg.@,#,1,etc)\n" + 
				"iYOB is not an integer. Please enter a valid iYOB.\n"));
	}
	
	@Test
	public void testTask5emptyInvalidInput2() {	
		clickOn("#tabApp2");
		TextField t5Name = (TextField)s.lookup("#t5name");
		t5Name.setText("1234");
		RadioButton t5male = (RadioButton)s.lookup("#t5male");
		t5male.setSelected(true);
		TextField t5year = (TextField)s.lookup("#t5year");
		t5year.setText("-1234");
		RadioButton t5ifemale = (RadioButton)s.lookup("#t5ifemale");
		t5ifemale.setSelected(true);
		RadioButton t5younger = (RadioButton)s.lookup("#t5younger");
		t5younger.setSelected(true);
		clickOn("#dot5");
		String s1 = t.getText();
		assertTrue(s1.equals("There are some invalid input, below is the summary.\n" + 
				"Invalid iName,there are some special characters or number(eg.@,#,1,etc)\n" + 
				"iYOB is out of boundary. Please enter iYOB between 1880 and 2019.\n"));
	}
	
	@Test
	public void testTask5emptyspacebetweenInput() {	
		clickOn("#tabApp2");
		TextField t5Name = (TextField)s.lookup("#t5name");
		t5Name.setText("Dav ide");
		RadioButton t5male = (RadioButton)s.lookup("#t5male");
		t5male.setSelected(true);
		TextField t5year = (TextField)s.lookup("#t5year");
		t5year.setText("19 94");
		RadioButton t5ifemale = (RadioButton)s.lookup("#t5ifemale");
		t5ifemale.setSelected(true);
		RadioButton t5younger = (RadioButton)s.lookup("#t5younger");
		t5younger.setSelected(true);
		clickOn("#dot5");
		String s1 = t.getText();
		assertTrue(s1.equals("There are some invalid input, below is the summary.\n" + 
				"Invalid iName,there are some special characters or number(eg.@,#,1,etc)\n" + 
				"iYOB is not an integer. Please enter a valid iYOB.\n"));
	}
	
	@Test
	public void testTask5lowerboundary() {	
		clickOn("#tabApp2");
		TextField t5Name = (TextField)s.lookup("#t5name");
		t5Name.setText("Bob");
		RadioButton t5male = (RadioButton)s.lookup("#t5male");
		t5male.setSelected(true);
		TextField t5year = (TextField)s.lookup("#t5year");
		t5year.setText("1879");
		RadioButton t5ifemale = (RadioButton)s.lookup("#t5ifemale");
		t5ifemale.setSelected(true);
		RadioButton t5younger = (RadioButton)s.lookup("#t5younger");
		t5younger.setSelected(true);
		clickOn("#dot5");
		String s1 = t.getText();
		assertTrue(s1.equals("There are some invalid input, below is the summary.\n" + 
				"iYOB is out of boundary. Please enter iYOB between 1880 and 2019.\n"));
	}
	
	@Test
	public void testTask5upperboundary() {	
		clickOn("#tabApp2");
		TextField t5Name = (TextField)s.lookup("#t5name");
		t5Name.setText("Tina");
		RadioButton t5female = (RadioButton)s.lookup("#t5female");
		t5female.setSelected(true);
		TextField t5year = (TextField)s.lookup("#t5year");
		t5year.setText("2020");
		RadioButton t5ifemale = (RadioButton)s.lookup("#t5ifemale");
		t5ifemale.setSelected(true);
		RadioButton t5younger = (RadioButton)s.lookup("#t5younger");
		t5younger.setSelected(true);
		clickOn("#dot5");
		String s1 = t.getText();
		assertTrue(s1.equals("There are some invalid input, below is the summary.\n" + 
				"iYOB is out of boundary. Please enter iYOB between 1880 and 2019.\n"));
	}
	
	@Test
	public void testTask5missingradio() {	
		//it is impossible in the real application due to the default value
		clickOn("#tabApp2");
		TextField t5Name = (TextField)s.lookup("#t5name");
		t5Name.setText("August");
		RadioButton t5male = (RadioButton)s.lookup("#t5male");
		t5male.setSelected(false);
		TextField t5year = (TextField)s.lookup("#t5year");
		t5year.setText("1999");
		RadioButton t5ifemale = (RadioButton)s.lookup("#t5ifemale");
		t5ifemale.setSelected(false);
		RadioButton t5younger = (RadioButton)s.lookup("#t5younger");
		t5younger.setSelected(false);
		clickOn("#dot5");
		String s1 = t.getText();
		assertTrue(s1.equals("There are some invalid input, below is the summary.\n"
				+ "iGender is missing. Please select a gender.\n"
				+ "iGenderMate is missing. Please select a gender.\n"
				+ "iPerference is missing. Please select a iPerference.\n"));
	}

	//in 1996,the last rank of male and female are 10530(Zyler) and 15889(Zyesha) respectively
	 //       the rank 1 of male and female are Michael	and Emily respectively.
	//in 1997,the last rank of male and female are 10810(Zohar) and 16155(Zykerria) 
	//        the rank 1 of male and female are Michael	and Emily respectively.
	
	@Test
	public void testTask5algorithmspecialcase1() {
		clickOn("#tabApp2");
		TextField t5Name = (TextField)s.lookup("#t5name");
		t5Name.setText("Zohar");
		RadioButton t5male = (RadioButton)s.lookup("#t5male");
		t5male.setSelected(true);
		TextField t5year = (TextField)s.lookup("#t5year");
		t5year.setText("1997");
		RadioButton t5imale = (RadioButton)s.lookup("#t5imale");
		t5imale.setSelected(true);
		RadioButton t5older = (RadioButton)s.lookup("#t5older");
		t5older.setSelected(true);
		clickOn("#dot5");
		String s1 = t.getText();
		assertTrue(s1.equals("The recommanded names for compatible pairs is Michael."));
	}
	
	@Test
	public void testTask5algorithmspecialcase2() {
		clickOn("#tabApp2");
		TextField t5Name = (TextField)s.lookup("#t5name");
		t5Name.setText("Zyesha");
		RadioButton t5female = (RadioButton)s.lookup("#t5female");
		t5female.setSelected(true);
		TextField t5year = (TextField)s.lookup("#t5year");
		t5year.setText("1996");
		RadioButton t5imale = (RadioButton)s.lookup("#t5imale");
		t5imale.setSelected(true);
		RadioButton t5younger = (RadioButton)s.lookup("#t5younger");
		t5younger.setSelected(true);
		clickOn("#dot5");
		String s1 = t.getText();
		assertTrue(s1.equals("The recommanded names for compatible pairs is Michael."));
	}
	
	@Test
	public void testTask5algorithmspecialcase3() {
		clickOn("#tabApp2");
		TextField t5Name = (TextField)s.lookup("#t5name");
		t5Name.setText("Zykerria");
		RadioButton t5female = (RadioButton)s.lookup("#t5female");
		t5female.setSelected(true);
		TextField t5year = (TextField)s.lookup("#t5year");
		t5year.setText("1997");
		RadioButton t5ifemale = (RadioButton)s.lookup("#t5ifemale");
		t5ifemale.setSelected(true);
		RadioButton t5older = (RadioButton)s.lookup("#t5older");
		t5older.setSelected(true);
		clickOn("#dot5");
		String s1 = t.getText();
		assertTrue(s1.equals("The recommanded names for compatible pairs is Emily."));
	}
	
	@Test
	public void testTask5algorithmspecialcase4() {
		clickOn("#tabApp2");
		TextField t5Name = (TextField)s.lookup("#t5name");
		t5Name.setText("Zykerria");
		RadioButton t5female = (RadioButton)s.lookup("#t5female");
		t5female.setSelected(true);
		TextField t5year = (TextField)s.lookup("#t5year");
		t5year.setText("1997");
		RadioButton t5imale = (RadioButton)s.lookup("#t5imale");
		t5imale.setSelected(true);
		RadioButton t5older = (RadioButton)s.lookup("#t5older");
		t5older.setSelected(true);
		clickOn("#dot5");
		String s1 = t.getText();
		assertTrue(s1.equals("The recommanded names for compatible pairs is Michael."));
	}
	
	@Test
	public void testTask5algorithmfornameisnotranked() {
		clickOn("#tabApp2");
		TextField t5Name = (TextField)s.lookup("#t5name");
		t5Name.setText("fdgsjfg");
		RadioButton t5male = (RadioButton)s.lookup("#t5male");
		t5male.setSelected(true);
		TextField t5year = (TextField)s.lookup("#t5year");
		t5year.setText("1989");
		RadioButton t5ifemale = (RadioButton)s.lookup("#t5ifemale");
		t5ifemale.setSelected(true);
		RadioButton t5younger = (RadioButton)s.lookup("#t5younger");
		t5younger.setSelected(true);
		clickOn("#dot5");
		String s1 = t.getText();
		assertTrue(s1.equals("The recommanded names for compatible pairs is Jessica."));
	}
}
