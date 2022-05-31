package com.Spicejet.FlightTicket;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrderFlightTicketTest {
	public static void selectDateByJs(WebDriver driver,WebElement ele,String dateVal)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguements[0].setAttribute('value'),'"+dateVal+"');", ele);
	}
	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream fis=new FileInputStream("./src/test/resources/commonData.Properties");
		Properties p=new Properties();
		p.load(fis);
		String url = p.getProperty("url");
	//	FileInputStream fexcel=new FileInputStream("./src/test/resources/FlightExcel.xlsx");
		//Workbook wb = WorkbookFactory.create(fexcel);
	   // String From = wb.getSheet("FlightTicket").getRow(2).getCell(1).getStringCellValue();
	    //String To = wb.getSheet("FlightTicket").getRow(2).getCell(2).getStringCellValue();
		WebDriverManager.chromedriver().setup();
		ChromeOptions otp=new ChromeOptions();
		otp.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(otp);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[.='round trip']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[.='From']/following-sibling::div[1]/input[1]")).sendKeys("Bengaluru");
		//Select s=new Select(ele);
		//s.selectByVisibleText("Bengaluru");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[.='Departure Date']")).click();
		Thread.sleep(2000);
		// driver.findElement(By.xpath("//div[@class='css-76zvg2 r-jwli3a r-ubezar r-16dba41']/..")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[.=15]")).click();
		driver.findElement(By.xpath("//div[.='Return Date']")).click();
		
		driver.findElement(By.xpath("//div[.='To']/following-sibling::div[1]/input[1]")).sendKeys("Delhi");
		
		 //driver.findElement(By.xpath("//div[ .='22' and @class='css-76zvg2 r-jwli3a r-ubezar r-16dba41']")).click();
		driver.findElement(By.xpath("//div[ .='22']")).click();
		
		//selectDateByJs(driver, ele2, dateVal1);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[.='Passengers']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@data-testid='Children-testID-plus-one-cta']")).click();

        driver.close();


	}
	
}
