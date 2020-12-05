package comp3111.popnames;

import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class Task5 {
	private String iname;
	private String igender;
	private int iyob;
	private String igendermate;
	private String perfer;

	public Task5(TextField t5name, TextField t5year, RadioButton t5male, RadioButton t5female, RadioButton t5imale,
			RadioButton t5ifemale, RadioButton t5younger, RadioButton t5older) {
		iname = t5name.getText();
		if (t5male.isSelected()) {
			igender = "M";
		}
		if (t5female.isSelected()) {
			igender = "F";
		}
		iyob = Integer.parseInt(t5year.getText());
		igendermate = "";
		if (t5imale.isSelected()) {
			igendermate = "M";
		}
		if (t5ifemale.isSelected()) {
			igendermate = "F";
		}
		perfer = "";
		if (t5younger.isSelected()) {
			perfer = "younger";
		}
		if (t5older.isSelected()) {
			perfer = "older";
		}

	}

	public static String check(TextField t5name, TextField t5year, RadioButton t5male, RadioButton t5female,
			RadioButton t5imale, RadioButton t5ifemale, RadioButton t5younger, RadioButton t5older) {
		String oReport = "";
		oReport = Task2and5_Checker.emptymessage(t5name, oReport, "iName");
		String regex = "[a-zA-Z]+";
		if (t5name.getText().isEmpty() == false && Task2and5_Checker.regexcheck(t5name, regex) == true) {
			oReport += String.format("Invalid iName,there are some special characters or number(eg.@,#,1,etc)\n");
		}
		if (Task2and5_Checker.radiocheck(t5male) == false && Task2and5_Checker.radiocheck(t5female) == false) {
			oReport += String.format("iGender is missing. Please select a gender.\n");
		}
		oReport += Task2and5_Checker.yearmessage(t5year, "iYOB");
		if((t5year.getText().equals("2019"))&&(t5younger.isSelected()== true)) {
			oReport += String.format("dataset is up to 2019, we cannot predict your younger soulmate. Sorry for inconvenience.\n");
		}
		if((t5year.getText().equals("1880"))&&(t5older.isSelected()== true)) {
			oReport += String.format("dataset is down to 1880,"
					+ " we cannot predict your older soulmate. Sorry for inconvenience.\n");
		}
		
		if (Task2and5_Checker.radiocheck(t5imale) == false && Task2and5_Checker.radiocheck(t5ifemale) == false) {
			oReport += String.format("iGenderMate is missing. Please select a gender.\n");
		}
		if (Task2and5_Checker.radiocheck(t5younger) == false && Task2and5_Checker.radiocheck(t5older) == false) {
			oReport += String.format("iPerference is missing. Please select a iPerference.\n");
		}
		return oReport;
	}

	public String NK_T5Algorithm() {
		int orank = 0;
		orank = AnalyzeNames.getRank(iyob, iname, igender);
		if (orank == -1) {
			orank = 1;
		}
		int oyob = 0;
		if (perfer.equals("younger")) {
			oyob = iyob + 1;
		}
		if (perfer.equals("older")) {
			oyob = iyob - 1;
			;
		}
		String oname = AnalyzeNames.getName(oyob, orank, igendermate);
		if (oname.equals("information on the name at the specified rank is not available")) {
			oname = AnalyzeNames.getName(oyob, 1, igendermate);
		}
		return oname;
	}
}
