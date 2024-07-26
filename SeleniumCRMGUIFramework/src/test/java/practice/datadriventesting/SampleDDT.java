package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SampleDDT {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Step 1: get the java representation object of the physical file
		FileInputStream fis=new FileInputStream ("C:\\Users\\suvam\\OneDrive\\Desktop\\TekPyramid\\CommonData.properties");
		//Step 2:Use Properties class load all the keys 
		Properties pObj=new Properties();
		pObj.load(fis);
		//Step 3: Get the value based on key
		System.out.println(pObj.getProperty("Browser"));
	}

}
