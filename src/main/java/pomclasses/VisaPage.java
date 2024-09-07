package pomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VisaPage {

	WebDriver driver;
	
	@FindBy(xpath="//input[@id='email']")
	public WebElement emailId;
	
	@FindBy(id="name")
	public WebElement name;
	
	@FindBy(id="mobile")
	public WebElement mobNo;
	
	@FindBy(id="country")
	public WebElement selectDestination;//this is drop down but not with select tag but input tag
	
	@FindBy(xpath="//span[@id='visaType_title']")
	public WebElement selectVisaType;
	
	//span[text()='Apply for Visa Online']
	@FindBy(xpath="//span[text()='Apply for Visa Online']")
	public WebElement applyforVisaText;
	
	public VisaPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public void sendEmail()
	{
		emailId.sendKeys("kaido@gmail.com");
	}
	
	public void sendName()
	{
		name.sendKeys("kaido");
	}
	
	public void sendMobileNo()
	{
		mobNo.sendKeys("2084422881");
	}
	
	public void selectDestination()
	{
		selectDestination.sendKeys("Vietnam");
	}
	public void sendEmailNameMobileDestination(String eml,String nam,String mob,String dest)
	{
		emailId.sendKeys(eml);
		name.sendKeys(nam);
		mobNo.sendKeys(mob);
		selectDestination.sendKeys(dest);
	}
	
	public String getApplyforVisaText()
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(applyforVisaText));
		return applyforVisaText.getText();
	}
}
