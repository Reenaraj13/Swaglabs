package com.teck.swaglabs.generic.webdriverutility;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int getRandomNumber() {
		
		Random rd= new Random();
		int randomNumber=rd.nextInt(5000);
	
		return randomNumber;
	
	}

	public String getSystemDateYYYYDDMM() {
		
		Date dateobj= new Date();
	    SimpleDateFormat sdf=new SimpleDateFormat("yyy-MM-dd");
		String date=sdf.format(dateobj);
		return date;
		
	}
	public String getRequiredDateYYYYDDMM(int days) {
		
	    SimpleDateFormat sim=new SimpleDateFormat("yyy-MM-dd");
 
		
		Calendar cal=sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,days);
		String requireddate = sim.format(cal.getTime());
		
		return requireddate;
	}

}
