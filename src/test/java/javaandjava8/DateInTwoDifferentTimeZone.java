package javaandjava8;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateInTwoDifferentTimeZone {

	public static void main(String[] args) throws ParseException {

		//Printing current date with the existing IST timezone
		
		Calendar calender = Calendar.getInstance();
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss z");
		String currentdatetime = formatter.format(calender.getTime());
		
		System.out.println("IST DataTime & Zone : " + currentdatetime);
		
		//Converting timezone to CST and printing it.
		
		TimeZone cstObj = TimeZone.getTimeZone("CST");
		formatter.setTimeZone(cstObj);
		String cstdatetime = formatter.format(calender.getTime());
		System.out.println("CST DataTime & Zone : " + cstdatetime);
		
		//Converting timezone to MST and printing it.
		
		TimeZone mstObj = TimeZone.getTimeZone("MST");
		formatter.setTimeZone(mstObj);
		String mstdatetime = formatter.format(calender.getTime());
		System.out.println("MST DataTime & Zone : " + mstdatetime);

		//Converting timezone to EST and printing it.
		
		TimeZone estObj = TimeZone.getTimeZone("EST");
		formatter.setTimeZone(estObj);
		String estdatetime = formatter.format(calender.getTime());
		System.out.println("EST DataTime & Zone : " + estdatetime);

	}

}
