package com.apium.poc.utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.apium.poc.config.EnvironmentSetUp;

public class GenericFunctions extends EnvironmentSetUp{
	
	 public GenericFunctions(AndroidDriver<AndroidElement> driver)

	    {
	        this.driver = driver;
	    }
	
	static String ScreenShot = "screenshots";
	String destFile;
	File srcFile;
	static File scrShotDir= new java.io.File("./"+ScreenShot+"//"); 
	
	
	public static void hideKeyBoard(AndroidDriver<AndroidElement> driver)
	{
		driver.hideKeyboard();
	}
	
	public String takeScreenshots(AndroidDriver<AndroidElement> driver){
		srcFile= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		SimpleDateFormat dateFormat= new SimpleDateFormat("dd-MM-yyyy__hh-mm-ss");
		new File(ScreenShot).mkdir();
		
		
		destFile = dateFormat.format(new Date()) +".png";
		
		try {
			FileUtils.copyFile(srcFile, new File(ScreenShot+"/"+destFile));
		} catch (IOException e) {
			System.out.println("Image not transferred to Screenshot folder");
			e.printStackTrace();
		}
		return destFile;
	}

	public static Object loadPropertiesFIle(String propertyFilePath) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fs = null;
		Properties locatorProperty= new Properties();
		try {
			fs = new FileInputStream(propertyFilePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		locatorProperty.load(fs);
		return locatorProperty;
	}

}
