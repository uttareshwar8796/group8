package Library_Files;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class UtilityClass {
	
	
	public static String GetInfo(String key) throws IOException
	{
		FileInputStream file = new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Project1\\PrppertyFile.properties");
	
		Properties prop = new Properties();
		
		prop.load(file);
		
		String value = prop.getProperty(key);
		
		return value;
	
	}
	
	
	public static String getExel(int rowIndex, int cellIndex) throws EncryptedDocumentException, IOException
	{
		
		FileInputStream file = new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Project1\\TestData/Excel1.xlsx");
		
		Sheet sh = WorkbookFactory.create(file).getSheet("Sheet4");
		
		String value = sh.getRow(rowIndex).getCell(cellIndex).getStringCellValue();
		
		return value;
	}
	
	
	
	public static void getScreenshot( WebDriver driver, String testCaseId) throws IOException
	{
		File Source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File Destination = new File("C:\\Users\\hp\\eclipse-workspace\\Project1\\ScreenShot\\"+testCaseId+".png");
		
		FileHandler.copy(Source, Destination);
	}
	

}
