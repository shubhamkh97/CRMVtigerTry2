package com.comcast.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility 
{	String fileLocation;
	public FileUtility(String fileLocation)
	{
		this.fileLocation=fileLocation;
	}

	public String  getDataFromPropertiesFile(String key) throws IOException 
	{
		FileInputStream fis = new FileInputStream(fileLocation);
		Properties pObj = new Properties();
		pObj.load(fis);
		String data=pObj.getProperty(key);
		return data;
	}
}
