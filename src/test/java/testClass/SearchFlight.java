package testClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pomclasses.HomePage;

public class SearchFlight {

	WebDriver driver;
	HomePage homePage;
	
	@Parameters("browsername")
	@BeforeTest
	public void openBrowser(@Optional("chrome") String browserName)
	{
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
				
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	@BeforeClass
	public void PomClass()
	{
		homePage = new HomePage(driver);
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		driver.get("https://www.yatra.com/");
	}
	
	@Test
	public void checkUrlOfTicketBookingPage() throws InterruptedException 
	{
		homePage.searchFlight();
	}
	
//	@Test
//	public void checkTicketNameAndPrice()
//	{
//		
//	}
	
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
