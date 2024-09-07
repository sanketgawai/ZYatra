package pomclasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	
	//test case 1)search flight visa(data driven),2)cab ifrme
	@FindBy(xpath="//a[@id='booking_engine_visa']")
	private WebElement visa;
	
	@FindBy(xpath="//a[@id='booking_engine_cabs']")
	private WebElement cabs;
	
	
	
	@FindBy(xpath="//input[@id='BE_flight_origin_city']")
	private WebElement departfrom;
	
	@FindBy(xpath="//p[text()='Mumbai ']/parent::div/parent::li")
	private WebElement selectMumbai;
	
	@FindBy(xpath="//p[text()='Goa ']/parent::div/parent::li")
	private WebElement selectGoa;
	
	@FindBy(xpath="//input[@id='BE_flight_arrival_city']")
	private WebElement goingTo; 
	
	@FindBy(xpath="(//input[@id='BE_flight_flsearch_btn'])[1]")
	private WebElement searchFlig;
	
		
	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
		Actions act = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebDriverWait wait = new WebDriverWait(driver,10);
	}


	public void clickOnVisa()
	{
		visa.click();
	}
	
	public void clickOnCabs()
	{
		cabs.click();
	}
	
	public void searchFlight() throws InterruptedException
	{
		departfrom.click();
		selectMumbai.click();
		FunctionalClass.waitforElement(driver,goingTo);
		selectGoa.click();
		//FunctionalClass.javascriptClick(driver, selectGoa);
		goingTo.click();
		goingTo.sendKeys("Goa");
		goingTo.sendKeys(Keys.ENTER);


		
		goingTo.click();
		FunctionalClass.waitforElement(driver,searchFlig);
		searchFlig.click();
	}
}
