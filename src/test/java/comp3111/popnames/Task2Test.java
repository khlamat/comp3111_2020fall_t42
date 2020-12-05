package comp3111.popnames;

import static org.junit.Assert.*;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class Task2Test extends ApplicationTest {

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
	public void testTask2DefaultInput() {	
		clickOn("#tabReport2");
		clickOn("#doreport2");
		String s1 = t.getText();
		assertTrue(s1.equals("           Year           Rank          Count     Percentage\n" + 
				"           1945              6         37,093      2.756594%\n" + 
				"           1944              6         37,374      2.742935%\n" + 
				"           1943              6         37,237      2.609742%\n" + 
				"           1942              6         35,892      2.599412%\n" + 
				"           1941              7         30,551      2.487986%\n" + 
				"In the year 1945, the number of birth with name David is 37,093, "
				+ "which represents 2.756594 percent of total Male birth in 1945."
				+ " The year when the name David was most popular is 1944. In that year,"
				+ " the number of births is 37,374, which represents 2.742935 percent of"
				+ " the total Male birth in 1944."));
	}
	
	@Test
	public void testTask2maleInput() {
		clickOn("#tabReport2");
		TextField t2Name = (TextField)s.lookup("#t2name");
		t2Name.setText("Bob");
		RadioButton t2m = (RadioButton)s.lookup("#t2m");
		t2m.setSelected(true);
		TextField t2startingyear = (TextField)s.lookup("#t2startingyear");
		t2startingyear.setText("2000");
		TextField t2endingyear = (TextField)s.lookup("#t2endingyear");		
		t2endingyear.setText("2007");
		clickOn("#doreport2");
		String s1 = t.getText();
		assertTrue(s1.equals("           Year           Rank          Count     Percentage\n" + 
				"           2007           9012              8      0.000386%\n" + 
				"           2006           6960             11      0.000536%\n" + 
				"           2005           3824             24      0.001203%\n" + 
				"           2004           4434             19      0.000958%\n" + 
				"           2003           7303              9      0.000456%\n" + 
				"           2002           4519             17      0.000876%\n" + 
				"           2001           4137             19      0.000979%\n" + 
				"           2000           2867             31      0.001580%\n" + 
				"In the year 2007, the number of birth with name Bob is 8, which represents"
				+ " 0.000386 percent of total Male birth in 2007. The year when the name Bob"
				+ " was most popular is 2000. In that year, the number of births is 31, which"
				+ " represents 0.001580 percent of the total Male birth in 2000."));
	}
	
	@Test
	public void testTask2femaleInput() {	
		clickOn("#tabReport2");
		TextField t2Name = (TextField)s.lookup("#t2name");
		t2Name.setText("Amy");
		RadioButton t2f = (RadioButton)s.lookup("#t2f");
		t2f.setSelected(true);
		TextField t2startingyear = (TextField)s.lookup("#t2startingyear");
		t2startingyear.setText("1931");
		TextField t2endingyear = (TextField)s.lookup("#t2endingyear");		
		t2endingyear.setText("1940");
		clickOn("#doreport2");
		String s1 = t.getText();
		assertTrue(s1.equals("           Year           Rank          Count     Percentage\n" + 
				"           1940            321            389      0.034024%\n" + 
				"           1939            329            364      0.033196%\n" + 
				"           1938            338            354      0.032086%\n" + 
				"           1937            354            326      0.030643%\n" + 
				"           1936            342            334      0.032109%\n" + 
				"           1935            355            325      0.030999%\n" + 
				"           1934            351            321      0.030746%\n" + 
				"           1933            364            303      0.030068%\n" + 
				"           1932            343            341      0.031959%\n" + 
				"           1931            342            347      0.032598%\n" + 
				"In the year 1940, the number of birth with name Amy is 389, which represents 0.034024 percent"
				+ " of total female birth in 1940. The year when the name Amy was most popular is 1940. In that year,"
				+ " the number of births is 389, which represents 0.034024 percent of the total female birth in 1940."));
	}
	
	@Test
	public void testTask2falsegender1() {	
		clickOn("#tabReport2");
		TextField t2Name = (TextField)s.lookup("#t2name");
		t2Name.setText("Faith");
		RadioButton t2m = (RadioButton)s.lookup("#t2m");
		t2m.setSelected(true);
		TextField t2startingyear = (TextField)s.lookup("#t2startingyear");
		t2startingyear.setText("1941");
		TextField t2endingyear = (TextField)s.lookup("#t2endingyear");		
		t2endingyear.setText("1945");
		clickOn("#doreport2");
		String s1 = t.getText();
		assertTrue(s1.equals("           Year           Rank          Count     Percentage\n" + 
				"           1945            Nil              0      0.000000%\n" + 
				"           1944            Nil              0      0.000000%\n" + 
				"           1943            Nil              0      0.000000%\n" + 
				"           1942            Nil              0      0.000000%\n" + 
				"           1941            Nil              0      0.000000%\n" + 
				"No baby(Male) born between 1941 and 1945 is named as Faith."));
	}
	
	@Test
	public void testTask2falsegender2() {	
		clickOn("#tabReport2");
		TextField t2Name = (TextField)s.lookup("#t2name");
		t2Name.setText("Osvaldo");
		RadioButton t2f = (RadioButton)s.lookup("#t2f");
		t2f.setSelected(true);
		TextField t2startingyear = (TextField)s.lookup("#t2startingyear");
		t2startingyear.setText("2000");
		TextField t2endingyear = (TextField)s.lookup("#t2endingyear");		
		t2endingyear.setText("2007");
		clickOn("#doreport2");
		String s1 = t.getText();
		assertTrue(s1.equals("           Year           Rank          Count     Percentage\n" + 
				"           2007            Nil              0      0.000000%\n" + 
				"           2006            Nil              0      0.000000%\n" + 
				"           2005            Nil              0      0.000000%\n" + 
				"           2004            Nil              0      0.000000%\n" + 
				"           2003            Nil              0      0.000000%\n" + 
				"           2002            Nil              0      0.000000%\n" + 
				"           2001            Nil              0      0.000000%\n" + 
				"           2000            Nil              0      0.000000%\n" + 
				"No baby(female) born between 2000 and 2007 is named as Osvaldo."));
	}	
	
	@Test
	public void testTask2EmptyInput() {
		clickOn("#tabReport2");
		TextField t2Name = (TextField)s.lookup("#t2name");
		t2Name.setText("");
		TextField t2startingyear = (TextField)s.lookup("#t2startingyear");
		t2startingyear.setText("");
		TextField t2endingyear = (TextField)s.lookup("#t2endingyear");		
		t2endingyear.setText("");
		clickOn("#doreport2");
		String s1 = t.getText();
		assertTrue(s1.equals("There are some invalid input, below is the summary.\n" + 
				"Name is missing. Please enter Name.\n"
				+ "Startingyear is missing. Please enter Startingyear.\n"
				+ "Endingyear is missing. Please enter Endingyear.\n"));
	}
	
	@Test
	public void testTask2invalidInput1() {
			clickOn("#tabReport2");
			TextField t2Name = (TextField)s.lookup("#t2name");
			t2Name.setText("D&eme");
			RadioButton t2m = (RadioButton)s.lookup("#t2m");
			t2m.setSelected(true);
			TextField t2startingyear = (TextField)s.lookup("#t2startingyear");
			t2startingyear.setText("18@7");
			TextField t2endingyear = (TextField)s.lookup("#t2endingyear");		
			t2endingyear.setText("200(");
			
			clickOn("#doreport2");
			String s1 = t.getText();
			assertTrue(s1.equals("There are some invalid input, below is the summary.\n"
					+ "Invalid name,there are some special characters or number(eg.@,#,1,etc).\n"
					+"Startingyear is not an integer. Please enter a valid Startingyear.\n"
					+ "Endingyear is not an integer. Please enter a valid Endingyear.\n"));
	}
	
	@Test
	public void testTask2invalidInput2() {
			clickOn("#tabReport2");
			TextField t2Name = (TextField)s.lookup("#t2name");
			t2Name.setText("123");
			RadioButton t2f = (RadioButton)s.lookup("#t2f");
			t2f.setSelected(true);
			TextField t2startingyear = (TextField)s.lookup("#t2startingyear");
			t2startingyear.setText("-1998");
			TextField t2endingyear = (TextField)s.lookup("#t2endingyear");		
			t2endingyear.setText("!200");
			
			clickOn("#doreport2");
			String s1 = t.getText();
			assertTrue(s1.equals("There are some invalid input, below is the summary.\n"
					+ "Invalid name,there are some special characters or number(eg.@,#,1,etc).\n"
					+"Startingyear is out of boundary. Please enter Startingyear between 1880 and 2019.\n"
					+ "Endingyear is not an integer. Please enter a valid Endingyear.\n"));
	}
	
	@Test
	public void testTask2norecord() {
		clickOn("#tabReport2");
		TextField t2Name = (TextField)s.lookup("#t2name");
		t2Name.setText("Dad");
		RadioButton t2m = (RadioButton)s.lookup("#t2m");
		t2m.setSelected(true);
		TextField t2startingyear = (TextField)s.lookup("#t2startingyear");
		t2startingyear.setText("1890");
		TextField t2endingyear = (TextField)s.lookup("#t2endingyear");		
		t2endingyear.setText("1894");
		clickOn("#doreport2");
		String s1 = t.getText();
		assertTrue(s1.equals("           Year           Rank          Count     Percentage\n" + 
				"           1894            Nil              0      0.000000%\n" + 
				"           1893            Nil              0      0.000000%\n" + 
				"           1892            Nil              0      0.000000%\n" + 
				"           1891            Nil              0      0.000000%\n" + 
				"           1890            Nil              0      0.000000%\n" + 
				"No baby(Male) born between 1890 and 1894 is named as Dad."));
	}

	@Test
	public void testTask2partialrecord() {
		clickOn("#tabReport2");
		TextField t2Name = (TextField)s.lookup("#t2name");
		t2Name.setText("Davide");
		RadioButton t2m = (RadioButton)s.lookup("#t2m");
		t2m.setSelected(true);
		TextField t2startingyear = (TextField)s.lookup("#t2startingyear");
		t2startingyear.setText("1941");
		TextField t2endingyear = (TextField)s.lookup("#t2endingyear");		
		t2endingyear.setText("1945");
		clickOn("#doreport2");
		String s1 = t.getText();
		assertTrue(s1.equals("           Year           Rank          Count     Percentage\n" + 
				"           1945            Nil              0      0.000000%\n" + 
				"           1944           2681              8      0.000587%\n" + 
				"           1943            Nil              0      0.000000%\n" + 
				"           1942            Nil              0      0.000000%\n" + 
				"           1941            Nil              0      0.000000%\n" + 
				"In the year 1945, the number of birth with name Davide is 0, which "
				+ "represents 0.000000 percent of total Male birth in 1945. The year "
				+ "when the name Davide was most popular is 1944. In that year, the number "
				+ "of births is 8, which represents 0.000587 percent of the total Male birth in 1944."));
	}
	
	@Test
	public void testTask2periodtest() {
		clickOn("#tabReport2");
		TextField t2Name = (TextField)s.lookup("#t2name");
		t2Name.setText("Leo");
		RadioButton t2m = (RadioButton)s.lookup("#t2m");
		t2m.setSelected(true);
		TextField t2startingyear = (TextField)s.lookup("#t2startingyear");
		TextField t2endingyear = (TextField)s.lookup("#t2endingyear");		
		t2startingyear.setText("1987");
		t2endingyear.setText("1970");
		clickOn("#doreport2");
		String s1 = t.getText();
		assertTrue(s1.equals("There are some invalid input, below is the summary.\n" + 
				"Invalid period,Starting year should not larger than Ending year.\n"));

	}
	
	@Test
	public void testTask2yearboundary1() {
		clickOn("#tabReport2");
		TextField t2Name = (TextField)s.lookup("#t2name");
		t2Name.setText("Grace");
		RadioButton t2f = (RadioButton)s.lookup("#t2f");
		t2f.setSelected(true);
		TextField t2startingyear = (TextField)s.lookup("#t2startingyear");
		t2startingyear.setText("1879");
		TextField t2endingyear = (TextField)s.lookup("#t2endingyear");		
		t2endingyear.setText("2020");
		
		clickOn("#doreport2");
		String s1 = t.getText();
		assertTrue(s1.equals("There are some invalid input, below is the summary.\n" + 
				"Startingyear is out of boundary. Please enter Startingyear between 1880 and 2019.\n"
				+ "Endingyear is out of boundary. Please enter Endingyear between 1880 and 2019.\n"));
	}
	
	@Test
	public void testTask2yearboundary2() {
		clickOn("#tabReport2");
		TextField t2Name = (TextField)s.lookup("#t2name");
		t2Name.setText("Grace");
		RadioButton t2f = (RadioButton)s.lookup("#t2f");
		t2f.setSelected(true);
		TextField t2startingyear = (TextField)s.lookup("#t2startingyear");
		t2startingyear.setText("1880");
		TextField t2endingyear = (TextField)s.lookup("#t2endingyear");		
		t2endingyear.setText("1880");
		
		clickOn("#doreport2");
		String s1 = t.getText();
		assertTrue(s1.equals("           Year           Rank          Count     Percentage\n" + 
				"           1880             19            982      1.079204%\n" + 
				"In the year 1880, the number of birth with name Grace is 982, which represents "
				+ "1.079204 percent of total female birth in 1880. The year when the name Grace "
				+ "was most popular is 1880. In that year, the number of births is 982, which "
				+ "represents 1.079204 percent of the total female birth in 1880."));
	}	
	
	@Test
	public void testTask2yearboundary3() {
		clickOn("#tabReport2");
		TextField t2Name = (TextField)s.lookup("#t2name");
		t2Name.setText("Grace");
		RadioButton t2f = (RadioButton)s.lookup("#t2f");
		t2f.setSelected(true);
		TextField t2startingyear = (TextField)s.lookup("#t2startingyear");
		t2startingyear.setText("2019");
		TextField t2endingyear = (TextField)s.lookup("#t2endingyear");		
		t2endingyear.setText("2019");
		
		clickOn("#doreport2");
		String s1 = t.getText();
		assertTrue(s1.equals("           Year           Rank          Count     Percentage\n" + 
				"           2019             28          6,062      0.364003%\n" + 
				"In the year 2019, the number of birth with name Grace is 6,062, which represents"
				+ " 0.364003 percent of total female birth in 2019. The year when the name Grace was"
				+ " most popular is 2019. In that year, the number of births is 6,062, which represents"
				+ " 0.364003 percent of the total female birth in 2019."));
	}	
	
	
	@Test
	public void testTask2missinggender() {	
		//it is impossible in the real application due to the default value
		clickOn("#tabReport2");
		TextField t2Name = (TextField)s.lookup("#t2name");
		t2Name.setText("Amy");
		RadioButton t2m = (RadioButton)s.lookup("#t2m");
		t2m.setSelected(false);
		TextField t2startingyear = (TextField)s.lookup("#t2startingyear");
		t2startingyear.setText("1931");
		TextField t2endingyear = (TextField)s.lookup("#t2endingyear");		
		t2endingyear.setText("1940");
		clickOn("#doreport2");
		String s1 = t.getText();
		assertTrue(s1.equals("There are some invalid input, below is the summary.\n"
				+ "Gender is missing. Please select a gender.\n"));
	}
	
	@Test
	public void testTask2spacebetweencharacter() {	
		clickOn("#tabReport2");
		TextField t2Name = (TextField)s.lookup("#t2name");
		t2Name.setText("Kay la");
		RadioButton t2f = (RadioButton)s.lookup("#t2f");
		t2f.setSelected(true);
		TextField t2startingyear = (TextField)s.lookup("#t2startingyear");
		t2startingyear.setText("19 1");
		TextField t2endingyear = (TextField)s.lookup("#t2endingyear");		
		t2endingyear.setText("19 40");
		clickOn("#doreport2");
		String s1 = t.getText();
		assertTrue(s1.equals("There are some invalid input, below is the summary.\n" + 
				"Invalid name,there are some special characters or number(eg.@,#,1,etc).\n" + 
				"Startingyear is not an integer. Please enter a valid Startingyear.\n" + 
				"Endingyear is not an integer. Please enter a valid Endingyear.\n"));
	}
}