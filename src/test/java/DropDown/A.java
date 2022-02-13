package DropDown;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class A {

	WebDriver driver;

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
		File file = new File("C:\\Users\\ME\\eclipse-workspace\\MavenBegining\\Excel\\InputExcel.xls");
		FileInputStream stream=new FileInputStream(file);
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("Test");	
		
		WebElement dDnSkills = driver.findElement(By.id("Skills"));
		Select select=new Select(dDnSkills);
		List<WebElement> options = select.getOptions();
		
		for (int i = 0; i < options.size(); i++) {
			String text = dDnSkills.getText();
			for (int j = 0; j < sheet.getPhysicalNumberOfRows(); j++) {
				Row row = sheet.createRow(j);
				for (int k= 0; k < row.getPhysicalNumberOfCells(); k++) {
					Cell cell = row.createCell(k);
					cell.setCellValue(text);
					
				}
			}
		}
FileOutputStream out=new FileOutputStream(file);
workbook.write(out);
driver.quit();
System.out.println("Done");
	}



}

