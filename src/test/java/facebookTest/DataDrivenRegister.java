package facebookTest;

import java.io.FileNotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DataDrivenRegister {

	static WebDriver driver;
	
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ME\\eclipse-workspace\\SeleniumTask\\Lib\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		driver.get("http://demo.automationtesting.in/Register.html");
	}
	

}
