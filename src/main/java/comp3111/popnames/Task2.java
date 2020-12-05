package comp3111.popnames;

import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class Task2 {
	private String iname;
	private int start;
	private int end;
	private String gender;
	private int endcount;
	private float endpercentage;
	private int maxyear;
	private int maxcount;
	private float maxpercentage;

	public Task2(TextField t2name, TextField t2startingyear, TextField t2endingyear, RadioButton t2m, RadioButton t2f) {
		iname = t2name.getText();
		start = Integer.parseInt(t2startingyear.getText());
		end = Integer.parseInt(t2endingyear.getText());
		gender = "";
		if (t2m.isSelected()) {
			gender = "M";
		}
		if (t2f.isSelected()) {
			gender = "F";
		}
		endcount = 0;
		endpercentage = 0;
		maxyear = 0;
		maxcount = 0;
		maxpercentage = 0;
	}
	
	public static String check(TextField t2name, TextField t2startingyear, TextField t2endingyear, RadioButton t2m,
			RadioButton t2f) {
		String oReport = "";
		oReport = Task2and5_Checker.emptymessage(t2name, oReport, "Name");
		String regex = "[a-zA-Z]+";
		if (t2name.getText().isEmpty() == false && Task2and5_Checker.regexcheck(t2name, regex) == true) {
			oReport += String.format("Invalid name,there are some special characters or number(eg.@,#,1,etc).\n");
		}
		if (Task2and5_Checker.radiocheck(t2m) == false && Task2and5_Checker.radiocheck(t2f) == false) {
			oReport += String.format("Gender is missing. Please select a gender.\n");
		}
		oReport += Task2and5_Checker.periodcheck(t2startingyear, t2endingyear);
		return oReport;
	}
	
	public int getstart() {
		return start;
	}
	public int getend() {
		return end;
	}
	private void endupdate(int count,float percentage) {
		endcount = count;
		endpercentage = percentage;
	}
	private void maxupdate(int i,int count,float percentage) {
		maxyear = i;
		maxcount = count;
		maxpercentage = percentage;
	}

	public String rowdetail(int i) {
		int rank = AnalyzeNames.getRank(i, iname, gender);
		int count = Task2and5_Checker.rowcount(i, iname, gender);
		int total = Task2and5_Checker.rowtotal(i, gender);
		float percentage = (float) count / total;
		String row = "";
		row += String.format("%15d", i);
		if (rank == -1) {
			row += String.format("%15s", "Nil");
		} else {
			row += String.format("%15d", rank);
		}
		row += String.format("%,15d", count);
		row += String.format("%14f%%%n", percentage * 100);
		if (i == end) {
			endupdate(count,percentage);
		}
		if (count > maxcount) {
			maxupdate(i,count, percentage);
		}
		return row;
	}

	public String summary() {
		String summary = "";
		String gen=gender;
		if (gender.equals("M")) {
			gen = "Male";
		}
		if (gender.equals("F")) {
			gen = "female";
		}
		if (maxcount == 0) {
			summary += String.format("No baby(%s) born between %d and %d is named as %s.",gen, start, end, iname);

		} else {
			summary += String.format(
					"In the year %d, the number of birth with name %s is %,d, which represents %f percent of total %s birth in %d. The year when the name %s was most popular is %d. In that year, the number of births is %,d, which represents %f percent of the total %s birth in %d.",
					end, iname, endcount, endpercentage * 100, gen, end, iname, maxyear, maxcount,
					maxpercentage * 100, gen, maxyear);
		}
		return summary;
	}
}
