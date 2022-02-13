package facebookTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivan {

	public static void main(String[] args) throws IOException  {

		FileInputStream stream = new FileInputStream("C:\\Users\\ME\\eclipse-workspace\\MavenBegining\\Excel\\InputExcel.xls");
		Workbook workbook = new HSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet("Datas");
		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(j);
				CellType cellType = cell.getCellType();
				String cellData= cellType.toString();
				if (cellData.equals("STRING")) {
					String name = cell.getStringCellValue();
					System.out.println(name);
				}if (cellData.equals("NUMERIC")) {

					double cellValue = cell.getNumericCellValue();
					BigDecimal valueOf = BigDecimal.valueOf(cellValue);
					String numbervalue = valueOf.toString();
					System.out.println(numbervalue);
					if (DateUtil.isCellDateFormatted(cell)) {


					}else {	
						SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy");
						String format = simpleDateFormat.format(cell.getDateCellValue());
						System.out.println(format);
					}
				}

			}

		}

	}

}
