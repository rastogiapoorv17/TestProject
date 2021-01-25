package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	public WebDriver driver;
	@BeforeTest
	public void LaunchURL() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\MyData\\Software\\chromedriver\\chromedriver.exe");
	   driver= new ChromeDriver();
	   driver.manage().window().maximize();
		driver.get("https://auth.testproject.io/auth/realms/TP/protocol/openid-connect/auth?client_id=tp.app&redirect_uri=https%3A%2F%2Fapp.testproject.io%2Fcallback.html&response_type=id_token%20token&scope=openid%20profile&state=ecb48b28d0a546b1be90894a0846e1a2&nonce=9a4ce0c5523d401a96fe7ae26715a568");
		
		
	}

}
