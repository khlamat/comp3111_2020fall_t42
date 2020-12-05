package comp3111.popnames;

import org.apache.commons.csv.CSVRecord;

import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2and5_Checker  {
	
	/**
	 * Function for remove bom
	 * 
	 * @param s     a string that may need to remove the bom
	 * @return 		string with no bom
	 * 
	 */
	public static String removeUTF8BOM(String s) {
		String UTF8_BOM = "\uFEFF";
	    if (s.startsWith(UTF8_BOM)) {
	        s = s.substring(1);
	    }
	    return s;
	}
	
	/**
	 * Function for check empty
	 * 
	 * @param t       a textField that need to check 
	 * @param oReport		  pass the oreport to update oreport
	 * @param specify specify what is missed
	 * @return 		  return the updated report to check having error or not
	 */
	public static String emptymessage(TextField t, String oReport, String specify) {
		if (t.getText().isEmpty() == true) {
			oReport += String.format("%s is missing. Please enter %s.\n", specify, specify);
		}
		return oReport;
	}
	
	/**
	 * Function for check the buttom is selected or not
	 * 
	 * @param r     target radiobutton
	 * @return  	return true if selected,return false if not selected,
	 */
	public static boolean radiocheck(RadioButton r) {
		return r.isSelected();
	}
	
	/**
	 * Function for checking regular expression
	 * 
	 * @param t     target TextField
	 * @param regex  a regular expresion that contain what the input should not have
	 * @return  	return false if the text with no invalid character.
	 */
	public static boolean regexcheck(TextField t, String regex) {
		Pattern p = Pattern.compile(regex);
		Matcher m;
		m = p.matcher(t.getText());
		return (!(m.find() && m.group().equals(t.getText())));
	}
	
	/**
	 * Function for checking the year
	 * 
	 * @param year     target year
	 * @param specify  specify the meaning of the year
	 * @return  	return the error message that indicate what wrong of the year or empty message if no error
	 */
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
	
	/**
	 * Function for checking period
	 * 
	 * @param startingyear     target startingyear
	 * @param endingyear       target endingyear
	 * @return  	return the yearmessage that indicate what wrong of the period empty message if no error
	 */
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
	
	/**
	 * Function for finding the number of people with same name born in a year
	 * 
	 * @param i           target year
	 * @param iname       target name
	 * @param gender      target gender
	 * @return  	return the number of people with same name born in a year
	 */
	public static int rowcount(int i, String iname, String gender) {
		int count = 0;
		for (CSVRecord rec : AnalyzeNames.getFileParser(i)) {
			if ((removeUTF8BOM(rec.get(0))).equals(iname)) {
				if (rec.get(1).equals(gender)) {
					count = Integer.parseInt(rec.get(2));
					break;
				}
			}
		}
		return count;
	}
	
	/**
	 * Function for finding the number of people in a year
	 * 
	 * @param i           target year
	 * @param gender      target gender
	 * @return  	return the number of people born in a year
	 */
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
