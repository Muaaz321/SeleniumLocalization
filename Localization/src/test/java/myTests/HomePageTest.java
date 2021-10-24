package myTests;

import java.io.IOException;
import java.security.PublicKey;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ConfigReader.ConfigPropReader;
import Factory.DriverFactory;
import Pages.Homepage;

public class HomePageTest {
	
	DriverFactory df;
	ConfigPropReader cp;
	Properties prop;
	WebDriver driver;
	Homepage homePage;
	
	@BeforeTest
	public void setUp() throws IOException {
		cp = new ConfigPropReader();
		//prop = cp.initLangProp("english");
		prop = cp.initLangProp();
		df = new DriverFactory();
		driver = df.initDriver("chrome", prop);
		homePage = new Homepage(driver);
	}
	
	@Test
	public void headerTest() {	
		Assert.assertTrue(homePage.isHeaderExist(prop.getProperty("header")));
	}
	
	
	
	@Test
	public void contactFooterTest() {
		Assert.assertTrue(homePage.isContactExist(prop.getProperty("contact")));
	}
	
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	

}
