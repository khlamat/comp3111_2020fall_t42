package comp3111.popnames;

import org.apache.commons.csv.CSVRecord;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2and5_Checker  {
	public static String removeUTF8BOM(String s) {
		String UTF8_BOM = "\uFEFF";
	    if (s.startsWith(UTF8_BOM)) {
	        s = s.substring(1);
	    }
	    return s;
	}
	
	public static String emptymessage(TextField t, String oReport, String specify) {
		if (t.getText().isEmpty() == true) {
			oReport += String.format("%s is missing. Please enter %s.\n", specify, specify);
		}
		return oReport;
	}

	public static boolean radiocheck(RadioButton r) {
		return r.isSelected();
	}

	public static boolean regexcheck(TextField t, String regex) {
		Pattern p = Pattern.compile(regex);
		Matcher m;
		m = p.matcher(t.getText());
		return (!(m.find() && m.group().equals(t.getText())));
	}

	public static String yearmessage(TextField year, String specify) {
		String temp="";
		if (year.getText().isEmpty() == true) {
			temp += String.format("%s is missing. Please enter %s.\n", specify, specify);
			return temp;
		}
		String regex = "[+-]?[0-9]+";
		if (Task2and5_Checker.regexcheck(year, regex) == true) {
			temp += String.format("%s is not an integer. Please enter a valid %s.\n", specify, specify);
			return temp;
		}
		int start = Integer.parseInt(year.getText());
		if (start < 1880 || start > 2019) {
			temp += String.format("%s is out of boundary. Please enter %s between 1880 and 2019.\n", specify,
					specify);
			return temp;
		}
		return temp;
	}

	public static String periodcheck(TextField startingyear, TextField endingyear) {
		String temp ="";
		temp += yearmessage(startingyear, "Startingyear");
		temp += yearmessage(endingyear, "Endingyear");
		if (temp.equals("")!=true) {
			return temp;
		}
		int start = Integer.parseInt(startingyear.getText());
		int end = Integer.parseInt(endingyear.getText());
		if (start > end) {
			temp += String.format("Invalid period,Starting year should not larger than Ending year.\n");
		}
		return temp;
	}
	
	public static int rowcount(int i, String iname, String gender) {
		int count = 0;
		for (CSVRecord rec : AnalyzeNames.getFileParser(i)) {
			if ((removeUTF8BOM(rec.get(0))).equals(iname)) {
				if (rec.get(1).equals(gender)) {
					count = Integer.parseInt(rec.get(2));
				}
			}
		}
		return count;
	}

	public static int rowtotal(int i, String gender) {
		int total = 0;
		for (CSVRecord rec : AnalyzeNames.getFileParser(i)) {
			if (rec.get(1).equals(gender)) {
				total += Integer.parseInt(rec.get(2));
			}
		}
		return total;
	}
}
