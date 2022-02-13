package facebookTest;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenLogin {

	public static void main(String[] args) throws IOException, AWTException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.facebook.com");
		
		Robot robot = new Robot();
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rectangle = new Rectangle(size);
		BufferedImage source = robot.createScreenCapture(rectangle);
		File destination = new File("D://FacebookScreenshot.png");
		ImageIO.write(source, "png", destination);
		
		
		
		
/*		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("D://FacebookLogin.png"));
*/		
		driver.quit();
	}

}
