package ModulePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class POM1 {

	@FindBy(xpath="//input[@name='username']") private WebElement UN;
	@FindBy(xpath="//input[@name='password']") private WebElement PWD;
	@FindBy(xpath="//button[@type='submit']") private WebElement LoginBTN;
	
	
	public POM1(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void EnterUserName(String UserName)
	{
		UN.sendKeys(UserName);
	
	}
	
	public void EnterPassword(String Password)
	{
		PWD.sendKeys(Password);
	}
	
	public void ClickButton()
	{
		LoginBTN.click();
	}

	
	
}
