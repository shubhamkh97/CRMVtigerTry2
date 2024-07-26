package com.comcast.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * 
 */
/**
 * 
 */
/**
 * 
 */
public class JavaUtility 
{
public int getRandomNumber(int n)
{
	Random random=new Random();
	int randomnum=random.nextInt(n);
	return randomnum;
}
public StringBuilder getRandomAlphaNum(int n)
{
	String alphaNumrString="12345678980ABCDEFGHIJKLM12345678980nopqrstuvwxyz12345678980abcdefghijklm12345678980NOPQRSTUVWXYZ12345678980";
	StringBuilder sh=new StringBuilder(n);
	for(int k=1;k<=n;k++)
	{
		int index=(int) ((int)alphaNumrString.length()*Math.random());
		sh.append(alphaNumrString.charAt(index));
	}
	return sh;
}

/**
 * @param format
 * Basic Formats: 
	  "dd/MM/yyyy": 02/07/2023 (Day/Month/Year) 
	  "MM/dd/yyyy": 07/02/2023 (Month/Day/Year)
	  "yyyy-MM-dd": 2023-07-02 (ISO 8601 format)
	  "dd-MMM-yyyy": 02-Jul-2023 (Day-Month abbreviation-Year)
	  "EEEE, MMMM dd, yyyy": Sunday, July 02, 2023 (Full day name, full month name)
	  
	Time Formats: 
	  "HH:mm:ss": 14:30:00 (24-hour format)
	  "hh:mm:ss a": 02:30:00 PM (12-hour format with AM/PM marker) 
	  
	Combined Formats: 
	  "dd/MM/yyyy HH:mm:ss": 02/07/2023 14:30:00
	  "yyyy-MM-dd'T'HH:mm:ssZ": 2023-07-02T14:30:00+0530 (ISO8601 with time zone)
 */
public String getCurrentDate(String format) 
{

	
	Date dateobj = new Date();
	SimpleDateFormat sim = new SimpleDateFormat(format);
	String actDate = sim.format(dateobj);
	return actDate;
	
}


/**
 * @param format
 * @param days
 * Basic Formats: 
	  "dd/MM/yyyy": 02/07/2023 (Day/Month/Year) 
	  "MM/dd/yyyy": 07/02/2023 (Month/Day/Year)
	  "yyyy-MM-dd": 2023-07-02 (ISO 8601 format)
	  "dd-MMM-yyyy": 02-Jul-2023 (Day-Month abbreviation-Year)
	  "EEEE, MMMM dd, yyyy": Sunday, July 02, 2023 (Full day name, full month name)
	  
	  Time Formats: 
	  "HH:mm:ss": 14:30:00 (24-hour format)
	  "hh:mm:ss a": 02:30:00 PM (12-hour format with AM/PM marker) 
	  
	  Combined Formats: 
	  "dd/MM/yyyy HH:mm:ss": 02/07/2023 14:30:00
	  "yyyy-MM-dd'T'HH:mm:ssZ": 2023-07-02T14:30:00+0530 (ISO8601 with time zone)
 */
public  String getRequiredDate(String format, int days) 
{	
	Date dateobj = new Date();
	SimpleDateFormat sim = new SimpleDateFormat(format);
	sim.format(dateobj);
	Calendar cal = sim.getCalendar();
	cal.add(Calendar.DAY_OF_MONTH, days);
	String dateRequries= sim.format(cal.getTime());
	return dateRequries;
}	
}
