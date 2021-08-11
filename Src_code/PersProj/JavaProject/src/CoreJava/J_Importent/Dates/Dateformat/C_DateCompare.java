package CoreJava.J_Importent.Dates.Dateformat;
import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class C_DateCompare {

	static final String DATE_TIME_FORMAT = "yyyy/MM/dd HH:MM:YY";
	static final String DATE_FORMAT = "yyyy/MM/dd";


	public static void main(String[] args)  {
		// TODO Auto-generated method stub

		// ValidateDate();
		//ValidateDateFormat();
		
		validatePastDate("2018/12/12");

	}


	public static void  ValidateDate(){

		SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT);
		String datestr1 = "2019/12/10";
		String datestr2 = "2019/11/12";		 
		String time1 = "";
		String time2 = "";

		Date date1 = null;
		Date date2 = null;
		try {
			date1 = sdf.parse(datestr1 + " " + time1);
			date2 = sdf.parse(datestr2 + " " + time2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("invalid date");
		}


		if (date1.compareTo(date2) > 0) {
			System.out.println("Date1 is after Date2");
		} else if (date1.compareTo(date2) < 0) {
			System.out.println("Date1 is before Date2");
		} else if (date1.compareTo(date2) == 0) {
			System.out.println("Date1 is equal to Date2");
		} else {
			System.out.println("How to get here?");
		}

	}

	public static Date  ValidateDateFormat(String dateStr){

		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		sdf.setLenient(false);
		String datestr1 = dateStr;

		Date date1 = null;
		try {
			date1 = sdf.parse(datestr1);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("invalid date");
		}
		System.out.println("Correct date");
		return date1;

	}

	private static void validatePastDate(String dateStr)  {

		Date date = ValidateDateFormat(dateStr);
		Date now = new Date();
		if (date.compareTo(now) < 0){
			System.out.println("Date is in past");		
		}else{
			System.out.println("Date is in future");	
		}
	}	

}
