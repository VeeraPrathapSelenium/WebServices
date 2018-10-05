package com.readingpropertiesfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadProperties {
	
	
	@Test
	public static void loadPropertiesFile() throws IOException
	{
		File f=new File("Env.properties");
		FileInputStream fis = new FileInputStream(f);
		Properties prop = new Properties();
		prop.load(fis);
		prop.get("BaseUrl");
		System.out.println(prop.get("BaseUrl"));
		
		
	}
	
	
	
	

}
