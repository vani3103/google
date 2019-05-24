package com.qa.googlesearch.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestBase {
public static WebDriver driver;
public static Properties prop;

	public TestBase()
	{
		prop=new Properties();
		try {
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/qa/googlesearch/properties/config.properties");
		     try {
				prop.load(fis);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void initialization()
	{
		String browsername=prop.getProperty("browser");
		if(browsername.equalsIgnoreCase("chrome")) {
			System.setProperty(prop.getProperty("chromedriver_key"), prop.getProperty("chromedriver_path"));
			ChromeOptions options=new ChromeOptions();
			options.addArguments("disable-infobars");
			//options.addArguments("--headless");
			driver=new ChromeDriver(options);
		}
		else {
			driver=new FirefoxDriver();
			//appropriate code
		}
		
		

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("implicitwait")), TimeUnit.MILLISECONDS);
		driver.get(prop.getProperty("url"));
	}
}
