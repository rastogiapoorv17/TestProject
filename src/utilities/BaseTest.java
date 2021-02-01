package utilities;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;


public class BaseTest {
	public  WebDriver driver;
	@BeforeMethod
	public void LaunchURL() {
	   System.setProperty("webdriver.chrome.driver", "C:\\MyData\\Software\\chromedriver\\chromedriver.exe");
	   driver= new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.manage().deleteAllCookies();
	   driver.get("chrome://settings/clearBrowserData");
	   driver.findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);
	   driver.get("https://auth.testproject.io/auth/realms/TP/protocol/openid-connect/auth?client_id=tp.app&redirect_uri=https%3A%2F%2Fapp.testproject.io%2Fcallback.html&response_type=id_token%20token&scope=openid%20profile&state=ecb48b28d0a546b1be90894a0846e1a2&nonce=9a4ce0c5523d401a96fe7ae26715a568");
		
		
	}
	
	public void explicitVisible(WebElement waitId1)
	{
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			  wait.until(ExpectedConditions.visibilityOf(waitId1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("resource")
	public String readExcelData(String path, String sheetname, int rownum,int cellnum) throws Exception {
		
		File src= new File(path);
		
			FileInputStream file = new FileInputStream(src);
		
		XSSFWorkbook wb= new XSSFWorkbook(file);
		XSSFSheet sheet= wb.getSheet(sheetname);
		String data= sheet.getRow(rownum).getCell(cellnum).getStringCellValue();
		return data;
		
	}
	
	//Capture Screenshot
	
	

	public String captureScreenshot(WebDriver driver2, String screenshotname) throws IOException {
		String dateName= new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		 TakesScreenshot ts= (TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		 String destinationfile = System.getProperty("user.dir")+"/Extent_20Report/" +screenshotname+ dateName + ".png";
		 File finalDestination = new File(destinationfile);	
		 FileHandler.copy(source, finalDestination);
		 return destinationfile;
			
		}
	
}

