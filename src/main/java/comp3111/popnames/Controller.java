package comp3111.popnames;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*https://www.geeksforgeeks.org/check-given-string-valid-number-integer-floating-point-java-set-2-regular-expression-approach/*/

public class Controller {

	@FXML
	private Tab tabTaskZero;

	@FXML
	private TextField textfieldNameF;

	@FXML
	private TextField textfieldYear;

	@FXML
	private Button buttonRankM;

	@FXML
	private TextField textfieldNameM;

	@FXML
	private Button buttonRankF;

	@FXML
	private Button buttonTopM;

	@FXML
	private Button buttonTopF;

	@FXML
	private Button buttonSummary;

	@FXML
	private Tab tabReport1;

	@FXML
	private RadioButton task1F;

	@FXML
	private ToggleGroup T1;

	@FXML
	private TextField task1TopN;

	@FXML
	private RadioButton task1M;

	@FXML
	private TextField task1EndingYear;

	@FXML
	private TextField task1StartingYear;

	@FXML
	private Button task1Report;

	@FXML
	private Tab tabReport2;

	@FXML
	private TextField t2startingyear;

	@FXML
	private TextField t2name;

	@FXML
	private RadioButton t2m;

	@FXML
	private ToggleGroup T11;

	@FXML
	private RadioButton t2f;

	@FXML
	private TextField t2endingyear;

	@FXML
	private Button doreport2;

	@FXML
	private Tab tabReport3;

	@FXML
	private RadioButton radiobuttonR3_M;

	@FXML
	private RadioButton radiobuttonR3_F;

	@FXML
	private TextField textfieldR3_Year1;

	@FXML
	private TextField textfieldR3_Year2;

	@FXML
	private TextField textfieldR3_TopN;

	@FXML
	private Button buttonR3_REPORT;

	@FXML
	private ToggleGroup T111;

	@FXML
	private Tab tabApp1;

	@FXML
	private Button application1Reoprt;

	@FXML
	private TextField task4iMomName;

	@FXML
	private TextField task4iDadYOB;

	@FXML
	private TextField task4iMomYOB;

	@FXML
	private TextField task4iDadName;

	@FXML
	private TextField task4iVintageYear;

	@FXML
	private Tab tabApp2;

	@FXML
	private TextField t5name;

	@FXML
	private TextField t5year;

	@FXML
	private RadioButton t5male;

	@FXML
	private RadioButton t5female;

	@FXML
	private RadioButton t5imale;

	@FXML
	private RadioButton t5younger;

	@FXML
	private RadioButton t5ifemale;

	@FXML
	private RadioButton t5older;

	@FXML
	private Button dot5;

	@FXML
	private Tab tabApp3;

	@FXML
	private TextField textfieldA3_iName;

	@FXML
	private TextField textfieldA3_iYOB;

	@FXML
	private RadioButton radiobuttonA3_iGenderM;

	@FXML
	private RadioButton radiobuttonA3_iGenderF;

	@FXML
	private TextField textfieldA3_iNameMate;

	@FXML
	private RadioButton radiobuttonA3_iGenderMateM;

	@FXML
	private RadioButton radiobuttonA3_iGenderMateF;

	@FXML
	private RadioButton radiobuttonA3_iPrefY;

	@FXML
	private RadioButton radiobuttonA3_iPrefO;

	@FXML
	private Button buttonA3_Submit;

	@FXML
	private ToggleGroup TApp3Gender1;

	@FXML
	private ToggleGroup TApp3Gender2;

	@FXML
	private ToggleGroup TApp3Preference;

	@FXML
	private TextArea textAreaConsole;

	/**
	 * Task Zero To be triggered by the "Summary" button on the Task Zero Tab
	 * 
	 */
	@FXML
	void doSummary() {
		int year = Integer.parseInt(textfieldYear.getText());
		String oReport = AnalyzeNames.getSummary(year);
		textAreaConsole.setText(oReport);
	}

	/**
	 * Task Zero To be triggered by the "Rank (female)" button on the Task Zero Tab
	 * 
	 */
	@FXML
	void doRankF() {
		String oReport = "";
		String iNameF = textfieldNameF.getText();
		int iYear = Integer.parseInt(textfieldYear.getText());
		int oRank = AnalyzeNames.getRank(iYear, iNameF, "F");
		if (oRank == -1)
			oReport = String.format("The name %s (female) has not been ranked in the year %d.\n", iNameF, iYear);
		else
			oReport = String.format("Rank of %s (female) in year %d is #%d.\n", iNameF, iYear, oRank);
		textAreaConsole.setText(oReport);
	}

	/**
	 * Task Zero To be triggered by the "Rank (male)" button on the Task Zero Tab
	 * 
	 */
	@FXML
	void doRankM() {
		String oReport = "";
		String iNameM = textfieldNameM.getText();
		int iYear = Integer.parseInt(textfieldYear.getText());
		int oRank = AnalyzeNames.getRank(iYear, iNameM, "M");
		if (oRank == -1)
			oReport = String.format("The name %s (male) has not been ranked in the year %d.\n", iNameM, iYear);
		else
			oReport = String.format("Rank of %s (male) in year %d is #%d.\n", iNameM, iYear, oRank);
		textAreaConsole.setText(oReport);
	}

	/**
	 * Task Zero To be triggered by the "Top 5 (female)" button on the Task Zero Tab
	 * 
	 */
	@FXML
	void doTopF() {
		String oReport = "";
		final int topN = 5;
		int iYear = Integer.parseInt(textfieldYear.getText());
		oReport = String.format("Top %d most popular names (female) in the year %d:\n", topN, iYear);
		for (int i = 1; i <= topN; i++)
			oReport += String.format("#%d: %s\n", i, AnalyzeNames.getName(iYear, i, "F"));
		textAreaConsole.setText(oReport);
	}

	/**
	 * Task Zero To be triggered by the "Top 5 (male)" button on the Task Zero Tab
	 * 
	 */
	@FXML
	void doTopM() {
		String oReport = "";
		final int topN = 5;
		int iYear = Integer.parseInt(textfieldYear.getText());
		oReport = String.format("Top %d most popular names (male) in the year %d:\n", topN, iYear);
		for (int i = 1; i <= topN; i++)
			oReport += String.format("#%d: %s\n", i, AnalyzeNames.getName(iYear, i, "M"));
		textAreaConsole.setText(oReport);
	}

	/**
	 * Task 1 A function to check the input of task 1
	 * 
	 * @return The message generated for invalid input
	 * 
	 */
	String task1InputCheck() {
		String oReport = "";
		boolean startingYearValid = false;
		String regex = "[+-]?[0-9]+";
		Pattern p = Pattern.compile(regex);
		Matcher m;
		m = p.matcher(task1TopN.getText());
		if (task1TopN.getText().isEmpty()) {
			oReport += String.format("Top N is empty.\n");
		} else if (!(m.find() && m.group().equals(task1TopN.getText()))) {
			oReport += String.format("Top N is not an integer.\n");
		} else if (Integer.parseInt(task1TopN.getText()) < 1) {
			oReport += String.format("Top N is not positive.\n");
		} else if (Integer.parseInt(task1TopN.getText()) > 10000) {
			oReport += String.format("Top N is more than the number of recorded names for each year.\n");
		}
		m = p.matcher(task1StartingYear.getText());
		if (task1StartingYear.getText().isEmpty()) {
			oReport += String.format("StartingYear is empty.\n");
		} else if (!(m.find() && m.group().equals(task1StartingYear.getText()))) {
			oReport += String.format("StartingYear is not an integer.\n");
		} else if (Integer.parseInt(task1StartingYear.getText()) < 1880
				|| Integer.parseInt(task1StartingYear.getText()) > 2019) {
			oReport += String.format("StartingYear is not in [1880, 2019].\n");
		} else {
			startingYearValid = true;
		}
		m = p.matcher(task1EndingYear.getText());
		if (task1EndingYear.getText().isEmpty()) {
			oReport += String.format("EndingYear is empty.\n");
		} else if (!(m.find() && m.group().equals(task1EndingYear.getText()))) {
			oReport += String.format("EndingYear is not an integer.\n");
		} else if (Integer.parseInt(task1EndingYear.getText()) < 1880
				|| Integer.parseInt(task1EndingYear.getText()) > 2019) {
			oReport += String.format("EndingYear is not in [1880, 2019].\n");
		} else if (startingYearValid
				&& Integer.parseInt(task1EndingYear.getText()) < Integer.parseInt(task1StartingYear.getText())) {
			oReport += String.format("EndingYear should not be less than StartingYear.\n");
		}
		return oReport;
	}

	/**
	 * Task 1 A function to generate the result of task 1
	 * 
	 * @return The message that will be shown in the console
	 * 
	 */
	String task1Result() {
		String oReport = "";
		String gender = "";
		int topN = Integer.parseInt(task1TopN.getText());
		int startingYear = Integer.parseInt(task1StartingYear.getText());
		int endingYear = Integer.parseInt(task1EndingYear.getText());
		if (task1M.isSelected())
			gender = "M";
		else
			gender = "F";
		int totalMax = 20000;
		String[] totalName = new String[totalMax];
		int[] totalNumber = new int[totalMax];
		int totalLength = 0;
		oReport = String.format("Year\t");
		for (int i = 1; i <= topN; i++) {
			oReport += String.format("Top %-11d\t", i);
		}
		oReport += String.format("\n");
		for (int i = startingYear; i <= endingYear; i++) {
			oReport += String.format("%4d\t", i);
			for (int j = 1; j <= topN; j++) {
				String name = AnalyzeNames.getName(i, j, gender);
				if (name.equals("information on the name at the specified rank is not available"))
					break;
				oReport += String.format("%-15s\t", name);
			}
			oReport += String.format("\n");
		}
		for (int i = startingYear; i <= endingYear; i++) {
			for (int j = 1; j < 100; j++) {
				String name = AnalyzeNames.getName(i, j, gender);
				boolean totalIsFound = false;
				for (int k = 0; k < totalLength; k++) {
					if (totalName[k].equals(name)) {
						totalNumber[k] += AnalyzeNames.getNumberOfBorn(i, name, gender);
						totalIsFound = true;
						break;
					}
				}
				if (!totalIsFound) {
					totalName[totalLength] = name;
					totalNumber[totalLength] = AnalyzeNames.getNumberOfBorn(i, name, gender);
					totalLength++;
				}
			}
		}
		int temp = 0;
		for (int i = 0; i < totalLength; i++) {
			if (totalNumber[i] > totalNumber[temp])
				temp = i;
		}
		oReport += String.format(
				"Over the period %d to %d, %s for %s has hold the top spot most often for a total of %s times.",
				startingYear, endingYear, totalName[temp], gender, totalNumber[temp]);
		return oReport;
	}

	/**
	 * Task 1 To be triggered by the "REPORT" button on the Task 1 Tab
	 * 
	 */
	@FXML
	void dotask1Report() {
		String oReport = "";
		oReport = task1InputCheck();
		if (!oReport.isEmpty()) {
			oReport = String.format("Invalid input.\n") + oReport;
			textAreaConsole.setText(oReport);
			return;
		}
		textAreaConsole.setText(task1Result());
	}

	/**
	 * Application 1 A function to check the input of App 1
	 * 
	 * @return The message generated for invalid input
	 * 
	 */
	String application1InputCheck() {
		String oReport = "";
		String regexName = "[A-Z][a-z]+";
		String regexYear = "[+-]?[0-9]+";
		Pattern pName = Pattern.compile(regexName);
		Pattern pYear = Pattern.compile(regexYear);
		Matcher m;
		String iDadName = task4iDadName.getText();
		m = pName.matcher(iDadName);
		if (iDadName.isEmpty()) {
			oReport += String.format("Dad Name is empty.\n");

		} else if (!(m.find() && m.group().equals(iDadName))) {
			oReport += String.format("Dad Name is invalid.\n");
		}
		String iMomName = task4iMomName.getText();
		m = pName.matcher(iMomName);
		if (iMomName.isEmpty()) {
			oReport += String.format("Mom Name is empty.\n");
		} else if (!(m.find() && m.group().equals(iMomName))) {
			oReport += String.format("Mom Name is invalid.\n");
		}
		m = pYear.matcher(task4iDadYOB.getText());
		if (task4iDadYOB.getText().isEmpty()) {
			oReport += String.format("Dad Born Year is empty.\n");
		} else if (!(m.find() && m.group().equals(task4iDadYOB.getText()))) {
			oReport += String.format("Dad Born Year is not an integer.\n");
		} else if (Integer.parseInt(task4iDadYOB.getText()) < 1880 || Integer.parseInt(task4iDadYOB.getText()) > 2019) {
			oReport += String.format("Dad Born Year is not in [1880, 2019].\n");
		}
		m = pYear.matcher(task4iMomYOB.getText());
		if (task4iMomYOB.getText().isEmpty()) {
			oReport += String.format("Mom Born Year is empty.\n");
		} else if (!(m.find() && m.group().equals(task4iMomYOB.getText()))) {
			oReport += String.format("Mom Born Year is not an integer.\n");
		} else if (Integer.parseInt(task4iMomYOB.getText()) < 1880 || Integer.parseInt(task4iMomYOB.getText()) > 2019) {
			oReport += String.format("Mom Born Year is not in [1880, 2019].\n");
		}
		m = pYear.matcher(task4iVintageYear.getText());
		if (task4iVintageYear.getText().isEmpty()) {
		} else if (!(m.find() && m.group().equals(task4iVintageYear.getText()))) {
			oReport += String.format("Vintage Year is not an integer.\n");
		} else if (Integer.parseInt(task4iVintageYear.getText()) < 1880
				|| Integer.parseInt(task4iVintageYear.getText()) > 2019) {
			oReport += String.format("Vintage Year is not in [1880, 2019].\n");
		}
		return oReport;
	}

	/**
	 * Application 1 A function that will return the name of the given parent name,
	 * parent year of born, gender and a vintage year in App 1
	 * 
	 * @param iName       The name of the parent
	 * @param iYOB        The year of born of the parent
	 * @param gender      The gender of the parent
	 * @param vintageYear The vintage year provided
	 * @return The name from the given input
	 * 
	 */
	String NKT4Algorithm(String iName, int iYOB, String gender, int vintageYear) {
		String oName;
		int iRank = AnalyzeNames.getRank(iYOB, iName, gender);
		if (iRank == -1) {
			oName = AnalyzeNames.getName(vintageYear, 1, gender);
		} else {
			oName = AnalyzeNames.getName(vintageYear, iRank, gender);
		}
		return oName;
	}

	/**
	 * Application 1 A function to generate the result of App 1
	 * 
	 * @return The message that will be shown in the console
	 * 
	 */
	String application1Result() {
		String oReport = "";
		String iDadName = task4iDadName.getText();
		String iMomName = task4iMomName.getText();
		int iDadYOB = Integer.parseInt(task4iDadYOB.getText());
		int iMomYOB = Integer.parseInt(task4iMomYOB.getText());
		int vintageYear;
		if (task4iVintageYear.getText().isEmpty()) {
			vintageYear = 2019;
		} else {
			vintageYear = Integer.parseInt(task4iVintageYear.getText());
		}
		String boyName = NKT4Algorithm(iDadName, iDadYOB, "M", vintageYear);
		String girlName = NKT4Algorithm(iMomName, iMomYOB, "F", vintageYear);
		oReport = String.format(
				"Recommended name for baby boy according to the NK-T4 Algorithm is %s.\nRecommended name for baby girl according to the NK-T4 Algorithm is %s.",
				boyName, girlName);
		return oReport;
	}

	/**
	 * Application 1 To be triggered by the "APPLICATION" button on the App 1 Tab
	 * 
	 */
	@FXML
	void doApplication1Report() {
		String oReport = application1InputCheck();
		if (!oReport.isEmpty()) {
			oReport = String.format("Invalid input.\n") + oReport;
			textAreaConsole.setText(oReport);
			return;
		}
		textAreaConsole.setText(application1Result());
	}

	/**
	 * Report2 To be triggered by the "Report2" button on the Reporting 2 Tab
	 * report2 function is mainly for grouping the output, and how the output come
	 * First,check the input is proper or not, if not return error message 
	 * if the input is proper,then oReport is updated row by row and finally show 
	 * the result.More detail of implementation is in class Task2 and Task2and5_Checker
	 * as it is oo structure.
	 */
	@FXML
	void report2() {
		String oReport = Task2.check(t2name, t2startingyear, t2endingyear, t2m, t2f);
		if (oReport.isEmpty() == false) {
			oReport = "There are some invalid input, below is the summary.\n" + oReport;
			textAreaConsole.setWrapText(true);
			textAreaConsole.setText(oReport);
			return;
		}
		Task2 task2 = new Task2(t2name, t2startingyear, t2endingyear, t2m, t2f);
		oReport += String.format("%15s%15s%15s%15s\n", "Year", "Rank", "Count", "Percentage");
		for (int i = task2.getend(); i >= task2.getstart(); i--) {
			oReport += task2.rowdetail(i);
		}
		oReport += task2.summary();
		textAreaConsole.setWrapText(true);
		textAreaConsole.setText(oReport);
		return;
	}

	/**
	 * FindPair(Application 2) To be triggered by the "Find Pair" button on the FindPair 
	 * Tab. t5 function is mainly for grouping the output, and how the output come from
	 * First,check the input is proper or not(in class Task5 and Task2and5_Checker), if 
	 * not return error message.if the input is proper,then Task5 will response to compute 
	 * the algoritm and finally show the result.
	 */
	@FXML
	void t5() {
		String oReport = Task5.check(t5name, t5year, t5male, t5female, t5imale, t5ifemale, t5younger, t5older);
		if (oReport.isEmpty() == false) {
			oReport = "There are some invalid input, below is the summary.\n" + oReport;
			textAreaConsole.setWrapText(true);
			textAreaConsole.setText(oReport);
			return;
		}
		Task5 task5 = new Task5(t5name, t5year, t5male, t5female, t5imale, t5ifemale, t5younger, t5older);
		String oname = task5.NK_T5Algorithm();
		oReport += String.format("The recommanded names for compatible pairs is %s.", oname);
		textAreaConsole.setWrapText(true);
		textAreaConsole.setText(oReport);
		return;
	}
	
	/**
	  * Reporting 3
	  * A function to implement Reporting 3: Gather all data from the tab
	  * Show the names stay in TopN and show their trend over the period of years provided
	  */
	@FXML
	void doR3REPORT() {
		String string_TopN = textfieldR3_TopN.getText();
		String string_Year1 = textfieldR3_Year1.getText();
		String string_Year2 = textfieldR3_Year2.getText();

		if (!string_TopN.matches("\\d+") || !string_Year1.matches("\\d+") || !string_Year2.matches("\\d+")) {
			textAreaConsole.setText("Please only enter numerical data.");
			return;
		}

		int topN = Integer.parseInt(textfieldR3_TopN.getText());
		int year1 = Integer.parseInt(textfieldR3_Year1.getText());
		int year2 = Integer.parseInt(textfieldR3_Year2.getText());

		String gender;
		if (radiobuttonR3_M.isSelected())
			gender = "M";
		else if (radiobuttonR3_F.isSelected())
			gender = "F";
		else {
			textAreaConsole.setText("Please specify a gender.");
			return;
		}

		if (topN < 1) {
			textAreaConsole.setText("Please enter a valid topN value.");
			return;
		}
		if (year1 >= year2 || year1 < 1880 || year2 > 2019) {
			textAreaConsole.setText("Please enter a valid range of years between 1880 and 2019 (inclusively).");
			return;
		}

		String[] names = new String[topN];
		boolean[] remainPopAllTheseYears = new boolean[topN];
		int[] lowestYears = new int[topN];
		int[] highestYears = new int[topN];

		for (int i = 0; i < topN; ++i) {
			names[i] = AnalyzeNames.getName(year1, i + 1, gender);
			remainPopAllTheseYears[i] = true;
			lowestYears[i] = year1;
			highestYears[i] = year1;
		}
		for (int yr = year1 + 1; yr <= year2; ++yr) {
			for (int i = 0; i < topN; ++i) {
				if (remainPopAllTheseYears[i] == false)
					continue;

				int rank = AnalyzeNames.getRank(yr, names[i], gender);
				if (rank < 1 || rank > topN) {
					remainPopAllTheseYears[i] = false;
					continue;
				}

				if (rank < AnalyzeNames.getRank(highestYears[i], names[i], gender))
					highestYears[i] = yr;
				if (rank > AnalyzeNames.getRank(lowestYears[i], names[i], gender))
					lowestYears[i] = yr;
			}
		}

		int count = 0;
		for (int i = 0; i < topN; ++i)
			if (remainPopAllTheseYears[i] == true)
				count++;

		String oReport = "";
		oReport = String.format(
				"%d names are found to be maintained at a high level of popularity within Top %d over the period from %d to %d.\n",
				count, topN, year1, year2);
		oReport += String.format("\nName         \tLowest Rank [in Year]\tHigest Rank [in Year]\tGross Trend\n\n");
		for (int i = 0; i < topN; ++i) {
			if (remainPopAllTheseYears[i] == true) {
				int lowestRank = AnalyzeNames.getRank(lowestYears[i], names[i], gender);
				int highestRank = AnalyzeNames.getRank(highestYears[i], names[i], gender);
				String grossTrend;
				if (lowestYears[i] < highestYears[i])
					grossTrend = "UP";
				else if (lowestYears[i] > highestYears[i])
					grossTrend = "DOWN";
				else
					grossTrend = "FLAT";
				oReport += String.format("%-13s\t%d [%d]\t\t%d [%d]\t\t%s\n", names[i], lowestRank, lowestYears[i],
						highestRank, highestYears[i], grossTrend);

			}
		}
		textAreaConsole.setText(oReport);

	}
	
	/**
	  * Application 3
	  * A function to implement Application 3: Gather all data from the tab and calculate a score
	  * 
	  */
	@FXML
	void doApp3() {
		String iName = textfieldA3_iName.getText();
		String iNameMate = textfieldA3_iNameMate.getText();
		if (iName.isBlank() || iNameMate.isBlank()) {
			textAreaConsole.setText("Empty names are not accepted.");
			return;
		}

		if (iName.contains(" ") || iNameMate.contains(" ")) {
			textAreaConsole.setText("Names should not contain any space character.");
			return;
		}

		for (int i = 0; i < 10; ++i) {
			if (iName.contains(String.valueOf(i)) || iNameMate.contains(String.valueOf(i))) {
				textAreaConsole.setText("Names should not contain any number.");
				return;
			}
		}

		String string_iYOB = textfieldA3_iYOB.getText();
		if (!string_iYOB.matches("\\d+")) {
			textAreaConsole.setText("Please enter a VALID year of birth.");
			return;
		}

		int iYOB = Integer.parseInt(string_iYOB);
		if (iYOB < 1880 || iYOB > 2019) {
			textAreaConsole.setText("Please provide a year between 1880 and 2019 (inclusively).");
			return;
		}

		String iGender, iGenderMate;

		if (radiobuttonA3_iGenderM.isSelected())
			iGender = "M";
		else if (radiobuttonA3_iGenderF.isSelected())
			iGender = "F";
		else {
			textAreaConsole.setText("Please specify your gender.");
			return;
		}

		if (radiobuttonA3_iGenderMateM.isSelected())
			iGenderMate = "M";
		else if (radiobuttonA3_iGenderMateF.isSelected())
			iGenderMate = "F";
		else {
			textAreaConsole.setText("Please specify the gender of the other person.");
			return;
		}

		int oRank = AnalyzeNames.getRank(iYOB, iName, iGender);
		if (oRank == -1)
			oRank = 1;

		int oYOB;
		if (radiobuttonA3_iPrefY.isSelected())
			oYOB = iYOB - 1;
		else if (radiobuttonA3_iPrefO.isSelected())
			oYOB = iYOB + 1;
		else {
			textAreaConsole.setText("Please specify your preference for a younger or older soulmate.");
			return;
		}

		int oRankMate = AnalyzeNames.getRank(oYOB, iNameMate, iGenderMate);
		if (oRankMate == -1)
			oRankMate = 1;

		float diff = Math.abs(oRank - oRankMate); // convert from int to float
		float max = Math.max(oRank, oRankMate);
		float oScore = (1.0f - diff / max) * 100.0f;
		int ooScore = Math.round(oScore);
		String oReport = String
				.format("You score %d%% for love matching!\n(0%%: Not Compatible; 100%%: Perfect Match)\n", ooScore);
		textAreaConsole.setText(oReport);
	}

}
