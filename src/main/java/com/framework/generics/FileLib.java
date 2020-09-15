package com.framework.generics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 
 * @author Somu
 *
 */
public class FileLib {
	public Properties file() throws IOException {
		FileInputStream fis = new FileInputStream("./Data/commondata.property");
		Properties p = new Properties();
		p.load(fis);
		return p;
	}

	/**
	 * 
	 * @return url
	 * @throws IOException
	 */
	public String data() throws IOException {
		Properties prop = file();
		String url = prop.getProperty("url");
		return url;
	}

	/**
	 * 
	 * @return browserName
	 * @throws IOException
	 */
	public String browserName() throws IOException {
		Properties prop = file();
		String drive = prop.getProperty("browser");
		return drive;
	}
}
