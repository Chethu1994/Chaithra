package com.crm.comcast.genericutility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 
 * @author chethu
 *
 */



public class FileUtility {

/**
 * it used to get common data from property file which you have specified as a argument
 * @return 
 * @return
 * @throws Throwable 
 */
		public String getpropertyKeyValue(String key) throws Throwable 
		{
		FileInputStream fis = new FileInputStream("./src/test/resources/dxc.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;
			
		}
		
	

}

