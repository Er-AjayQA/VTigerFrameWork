package com.VtigerFrameWork.GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Ajay Kumar
 * This class consist of property file manipulation methods. 
 */

public class PropertyFileUtility {

	/**
	 * This method read the value of given property and return it in string format.
	 * @param property
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String property) throws IOException
	{
		FileInputStream file= new FileInputStream(IConstantUtility.propertyFilePath);
		Properties pro= new Properties();
		pro.load(file);
		return pro.getProperty(property);
	}
	
}
