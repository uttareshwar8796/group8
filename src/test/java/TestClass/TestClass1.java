package TestClass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Library_Files.BaseClass;

public class TestClass1 extends BaseClass{
	
	
	ModulePage.POM1 P1;
	ModulePage.POM2 P2;
	
	String TestCaseId;
	
	@BeforeClass
	public void openBrowser() throws InterruptedException
	{
		BaseBrowser();
		
		Thread.sleep(2000);
		P1= new ModulePage.POM1(driver);
		
		Thread.sleep(2000);
		P2 = new ModulePage.POM2(driver);
	
	}
	
	@BeforeMethod
	public void Login() throws IOException, InterruptedException
	{ 
		
		Thread.sleep(2000);
		P1.EnterUserName(Library_Files.UtilityClass.GetInfo("UN"));
		
		Thread.sleep(2000);
		P1.EnterPassword(Library_Files.UtilityClass.GetInfo("PWD"));
		
		Thread.sleep(2000);
		P1.ClickButton();
	}
	
	@Test
	public void TC1() throws EncryptedDocumentException, IOException
	{
		TestCaseId="TC1_VerifyUser";
		
		String ActualResult = P2.VerifyUser();
		
		String ExpectedResult = Library_Files.UtilityClass.getExel(0, 0);
		
		Assert.assertEquals(ActualResult, ExpectedResult);
		
	}
	
	@Test
	public void TC2() throws EncryptedDocumentException, IOException
	{
		TestCaseId="TC2_VerifyTitle";
		String ActualTitle = driver.getTitle();
		
		String ExpectTitle = Library_Files.UtilityClass.getExel(0, 1);
		
		Assert.assertEquals(ActualTitle, ExpectTitle);
	}
	
	@AfterMethod
	public void Logout(ITestResult Result) throws InterruptedException, IOException
	{  
		if(Result.getStatus()==ITestResult.FAILURE)
		{
			Library_Files.UtilityClass.getScreenshot(driver, TestCaseId);
		}
		
		P2.clickOnUsername();
		
		Thread.sleep(2000);
		P2.clickOnLogout();

	}
	
	@AfterClass
	public void CloseBroser() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.close();	
	}


}
