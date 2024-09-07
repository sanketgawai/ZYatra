package testClass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pomclasses.HomePage;
import pomclasses.VisaPage;
import qa.base.Basee;
import qa.utils.Utility;

public class Visa extends Basee {

	WebDriver driver;
	HomePage homePage;
	VisaPage visaPage;
	@BeforeTest
	public void openBrowser() throws IOException
	{
		loadProperties();
		driver = initializeBrowserAndOpenBrowser(prop.getProperty("browserName"));
		
//		homePage = new HomePage(driver);
//		visaPage = new VisaPage(driver);
//		
//		driver.get("https://www.yatra.com/");
//		homePage.clickOnVisa();
//		ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
//		addr.get(1);

	}
	
	@BeforeClass
	public void PomClass()
	{
		homePage = new HomePage(driver);
		visaPage = new VisaPage(driver);
		
		driver.get("https://www.yatra.com/");
		homePage.clickOnVisa();
		ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
	}
	
//	@BeforeMethod
//	public void beforeMethod()
//	{
//		driver.get("https://www.yatra.com/");
//		homePage.clickOnVisa();
//		ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
//		addr.get(1);
//	}
	
	@Test
	public void checkVisaPageUrl() throws InterruptedException 
	{
//		homePage.clickOnVisa();
//		ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
//		addr.get(1);
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.yatra.com/visa/";
		Assert.assertEquals(actualUrl, expectedUrl);
		//System.out.println(visaPage.getApplyforVisaText());
	}
	
	@Test(dataProvider="dta")
	public void applyVisaOnline(String email,String name,String mobno,String destination)
	{
//		visaPage.sendEmail();
//		visaPage.sendName();
//		visaPage.sendMobileNo();
//		visaPage.selectDestination();
		//visaPage.sendEmailNameMobileDestination("kaido@gmail.com", "kaido", "2084422881", "Vietnam");
		visaPage.sendEmailNameMobileDestination(email, name, mobno, destination);
				
	}
	
	@Test
	public void checkApplyVisaOnlineText()
	{
		String actualText = visaPage.getApplyforVisaText();
		String expectedText = "Apply for Visa Online";
		Assert.assertTrue(true, actualText);
		Assert.assertEquals(actualText, expectedText);
	}
	
	@DataProvider(name="dta")
	public Object[][] getData() throws IOException
	{
		Object[][] data = Utility.sendDataFromExcelSheet("visa");
		return data;
	}
	
//	@AfterMethod
//	public void afterMethod()
//	{
//		System.out.println("after method");
//	}
//	
//	@AfterClass
//	public void makePomObjectNull()
//	{
//		homePage =null;
//	}
//	
//	@AfterTest
//	public void closeandCleanBrowser()
//	{
//		System.gc();
//		driver.quit();
//	}
}
