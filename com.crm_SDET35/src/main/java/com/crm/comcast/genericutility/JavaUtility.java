package com.crm.comcast.genericutility;

import java.util.Date;
import java.util.Random;

/**
 * 
 * @chethan
 * its contains java specific libraries like getRandomdata and getSystemDate etc
 * 
 * 
 * 
*/

public class JavaUtility {
	/**
	 * its used to generate the random number within the range of 1000
	 *@return
		*/
	public  int getrandomnumber(){
		Random random= new Random();
		int randnum = random.nextInt(1000);
		return randnum;
	}
	/**
	 * it is used to get system dateandTime in   IST format
	 *@return
	 */
	public String  getSYstemDateAndTimeInISTFormat() {
		Date date= new Date();
		String dateandtime = date.toString();
	return dateandtime;
	}
	/**
	 * it is used to get the current system date based on YYYY-DD-MM format
	 * @return
	 */
		public String  getSYstemDateAndTimeRequiredFormat() {
			Date date= new Date();
			String dateandtime = date.toString();
		    String yyyy = dateandtime.split("")[5];
		    String dd = dateandtime.split("")[2];
		    int mm = date.getMonth()+1;
		    String finalformat = yyyy+""+dd+""+mm;
		    return finalformat;
		
	} 
			 
	 
	 

}
