package ModulePage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM2 {
	

	@FindBy(xpath="//p[@class='oxd-userdropdown-name']") private WebElement User;
	
	@FindBy(xpath="//a[text()='Logout']") private WebElement LogoutOption;
	
	
	
	public POM2(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String VerifyUser() throws EncryptedDocumentException, IOException
	{
		String Actual = User.getText();
		
		return Actual;
	}
	
	
	public void clickOnUsername()
	{
		User.click();
	}
	
	public void clickOnLogout()
	{
		LogoutOption.click();
	}

}
