package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;

	public byte[] screenshot() {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		byte[] b = screenshot.getScreenshotAs(OutputType.BYTES);
		return b;

	}

	public static String getPropertyFileValues(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(System.getProperty("user.dir") + "\\Config\\Config.properties"));
		String value = (String) properties.get(key);
		return value;
	}

	public static void getDriver1(String browserType) {
		switch (browserType) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			break;
		}

	}

	public static String getProjectLoc() {
		String path = System.getProperty("user.dir");
		return path;

	}

	// use static for one package to another package
	public static void getDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	
	// use static for one package to another package
	public static void geturl(String url) {
		driver.get(url);
	}

	// use static for one package to another package
	public static void maximize() {
		driver.manage().window().maximize();

	}

	// use static for one package to another package
	public static void closeWindow() {
		driver.close();

	}

	public void DoubleClick(WebElement element) {
		// WebElement element2 = driver.findElement(By.xpath(xpath));
		Actions action = new Actions(driver);
		action.doubleClick().perform();
	}

	public void contectclick(WebElement element) {

		Actions action = new Actions(driver);
		action.contextClick(element).perform();

	}

	public void referesh() {
		driver.navigate().refresh();

	}

	public void forward() {
		driver.navigate().forward();

	}

	public void backward() {
		driver.navigate().back();

	}

	public void launchUrl(String value) {
		driver.navigate().to(value);

	}

	public String getText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public String getAttribute(WebElement element) {
		String text = element.getAttribute("value");
		return text;
	}

	public void sleep(int num) throws InterruptedException {
		Thread.sleep(num);
	}

	/*
	 * public void implicitlyWait(int num) {
	 * driver.manage().timeouts().implicityWait(Duration.ofSeconds(num));
	 * 
	 * }
	 */

	public Actions moveToElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		return action;
	}

	public void takesScreenShot(String location) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(location);
		FileUtils.copyFile(screenshotAs, file);

	}

	public File file(String value) {
		File file = new File(value);
		return file;

	}

	public Alert alertAccept() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
		return alert;
	}

	public Alert alertdismiss() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		return alert;

	}

	public void selectByIndex(WebElement element, int index) {

		Select s = new Select(element);
		s.selectByIndex(index);

	}

	public void selectByVisibleText(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByVisibleText(value);

	}

	public void selectByvalue(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}

	public void clearText(WebElement element) {
		element.clear();
	}

	public List getAllSelectedOptions(WebElement element) {
		Select s = new Select(element);
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		return allSelectedOptions;

	}

	public List getOptions(WebElement element) {
		Select s = new Select(element);
		List<WebElement> options = s.getOptions();
		return options;
	}

	public WebElement getFirstSelectedOptions(WebElement element) {
		Select s = new Select(element);
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		return firstSelectedOption;
	}

	public void deselectByIndex(WebElement element) {
		Select s = new Select(element);
		s.deselectAll();
	}

	public void deselectByValue(WebElement element, String value) {
		Select s = new Select(element);
		s.deselectByValue(value);
	}

	public void deselectByVisibleText(WebElement element, String value) {
		Select s = new Select(element);
		s.deselectByVisibleText(value);
	}

	public void deselectedByIndex(WebElement element, int index) {
		Select s = new Select(element);
		s.deselectByIndex(index);
	}

	public WebElement firstSelectedOption(WebElement element) {
		Select s = new Select(element);
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		return firstSelectedOption;
	}

	public boolean isMultiple(WebElement element) {
		Select s = new Select(element);
		boolean multiple = s.isMultiple();
		return multiple;
	}

	public String getWindowHandle() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}

	public Set getWindowHandles() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
	}

	public void switchWindow(String value) {
		driver.switchTo().window(value);
	}

	public void framesIndex(int index) {
		driver.switchTo().frame(index);
	}

	public void frameStringValue(String value) {
		driver.switchTo().frame(value);
	}

	public void framesRefName(WebElement element) {
		driver.switchTo().frame(element);
	}

	public void parentFrame() {
		driver.switchTo().parentFrame();
	}

	public void defaulContent() {
		driver.switchTo().defaultContent();
	}

	public void hasCodeValue() {
		driver.switchTo().hashCode();
	}

	public void elementSendKeys(WebElement element, String data) {
		element.sendKeys(data);
	}

	public void elementSendKeysjs(WebElement element, String data) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value',' " + data + " ' )", element);
	}

	public void elementclick(WebElement element) {
		element.click();
	}

	public WebElement findElementById(String attributevalue) {
		WebElement element = driver.findElement(By.id(attributevalue));
		return element;
	}

	public WebElement findLocatorByName(String attributevalue) {
		WebElement element = driver.findElement(By.name(attributevalue));
		return element;
	}

	public WebElement findLocatorByClassName(String attributevalue) {
		WebElement element = driver.findElement(By.className(attributevalue));
		return element;
	}

	public WebElement findLocatorByXpath(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
	}

	public String getApplnTitle() {
		String title = driver.getTitle();
		return title;
	}

	public String getApplnUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public void quiteWindow() {
		driver.quit();
	}

	public String size() {
		String pageSource = driver.getPageSource();
		return pageSource;
	}

	public String toString() {
		String string = driver.toString();
		return string;

	}

	public void writecell(String sheetname, int rownum, int cellnum, String data) throws IOException {
		File file = new File(
				"C:\\Users\\Lenovo\\eclipse-workspace\\DataDrivern\\workbookuserdata\\ExcelUserName 1 1 (1).xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook book = new XSSFWorkbook(fileInputStream);
		Sheet sheet = book.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		Cell cell = row.createCell(cellnum);
		cell.setCellValue(data);
		FileOutputStream out = new FileOutputStream(file);
		book.write(out);
	}

	/*
	 * public void writecellvalue(String sheetname, int rownum, int cellnum, String
	 * data) throws IOException { File file = new File(
	 * "C:\\Users\\Lenovo\\eclipse-workspace\\DataDrivern\\workbookuserdata\\ExcelUserName 1 1 (1).xlsx"
	 * ); FileInputStream fileInputStream = new FileInputStream(file); Workbook book
	 * = new XSSFWorkbook(fileInputStream); Sheet sheet = book.getSheet(sheetname);
	 * Row row = sheet.createRow(rownum); Cell cell = row.createCell(cellnum);
	 * cell.setCellValue(data); FileOutputStream out = new FileOutputStream(file);
	 * book.write(out); }
	 */

	public void updateData(String sheetname, int rownum, int cellnum, String oldnum, String newData)
			throws IOException {
		File file = new File(
				"C:\\Users\\Lenovo\\eclipse-workspace\\OMRBranchAdactinHotelAutomation\\Workbook\\ExcelUserName 1 1 (1).xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook book = new XSSFWorkbook(fileInputStream);
		Sheet sheet = book.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String value = cell.getStringCellValue();
		if (value.equals(oldnum)) {
			cell.setCellValue(newData);
		}
		FileOutputStream out = new FileOutputStream(file);
		book.write(out);

	}

	public String getDataFormCell(String sheetname, int rownum, int cellnum) throws IOException {
		String res = "";
		File file = new File(
				"C:\\Users\\Lenovo\\eclipse-workspace\\OMRBranchAdactinHotelAutomation\\Workbook\\ExcelUserName 1 1 (1).xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook book = new XSSFWorkbook(fileInputStream);
		Sheet sheet = book.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		CellType type = cell.getCellType();
		switch (type) {
		case STRING:
			res = cell.getStringCellValue();
			break;
		case NUMERIC:
			if (DateUtil.isCellInternalDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-YYYY");
				res = dateFormat.format(dateCellValue);
			} else {
				double numericCellValue = cell.getNumericCellValue();
				long check = Math.round(numericCellValue);
				if (numericCellValue == check) {
					res = String.valueOf(check);
				} else {
					res = String.valueOf(numericCellValue);
				}
			}
		default:
			break;
		}
		return res;

	}


}
