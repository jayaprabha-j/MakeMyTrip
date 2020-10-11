package com.pages;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.http.client.protocol.RequestExpectContinue;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utilities.BrowserSelection;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class MakeMyTripProject {
WebDriver driver;
	
	@BeforeMethod
	public void OpenBrowser()
	{	
		
		driver = BrowserSelection.UsingChrome();				
	}
	
	@Test
	public void CreateAccount()throws InterruptedException, AWTException, Throwable{
		driver.get("https://www.makemytrip.com/");		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(5000);
		
		
		try {
			
			driver.findElement(By.xpath("//p[text()=' Login or Create Account'] ")).click();
			Thread.sleep(5000);
			try {
			if(null!= driver.findElement(By.xpath("//iframe[@name='notification-frame-~19715a043']")) ) {
			//driver.findElement(By.xpath("//div[@class='login__card makeFlex hrtlCenter cursorPointer appendBottom10']")).click();
			WebDriverWait wait = new WebDriverWait(driver, 15);
		    Thread.sleep(5000);
		    driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='notification-frame-~19715a043']")));
		    driver.findElement(By.xpath(".//a[@id='webklipper-publisher-widget-container-notification-close-div']")).click();
		    Thread.sleep(2000);
			}
			}
			catch(Exception e) {
				System.out.println("continuing");
			}
			driver.findElement(By.id("username")).sendKeys("jpneenajp@gmail.com");
			driver.findElement(By.xpath("//span[text()='Continue']")).click();
			driver.findElement(By.id("password")).sendKeys("Makemytrip@1");
			driver.findElement(By.xpath("//span[text()='Login']")).click();
			driver.findElement(By.xpath("//span[@data-cy='modalClose']")).click();
			//Thread.sleep(5000);
			
			//hotel selection
			driver.findElement(By.xpath("//span[text()='Hotels']")).click();
			try {
			if(driver.findElement(By.xpath("//iframe[@name='notification-frame-~5587113a']")) != null) {
			WebDriverWait waits = new WebDriverWait(driver, 15);
		    Thread.sleep(5000);
		    driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='notification-frame-~5587113a']")));
		    driver.findElement(By.xpath(".//a[@id='webklipper-publisher-widget-container-notification-close-div']")).click();
		    Thread.sleep(2000);
			}}
			catch (Exception e) {
				System.out.println("working");
			}
			//driver.findElement(By.xpath("//span[text()='Hotels']")).click();
			driver.findElement(By.xpath("//span[text()='City / Hotel / Area / Building']")).click();
			driver.findElement(By.xpath("//input[@placeholder='Enter city/ Hotel/ Area/ Building']")).click();
			WebElement from=driver.findElement(By.xpath("//input[@placeholder='Enter city/ Hotel/ Area/ Building']"));
			from.sendKeys("Sydney");
			Thread.sleep(5000);
			from.sendKeys(Keys.ARROW_DOWN);
			from.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			
			//check-in and check-out
			
			driver.findElement(By.id("checkin")).click();
			driver.findElement(By.xpath("//div[@aria-label='Thu Nov 12 2020']")).click();
			Thread.sleep(3000);
			
			driver.findElement(By.id("checkout")).click();
			driver.findElement(By.xpath("//div[@aria-label='Tue Nov 24 2020']")).click();
			Thread.sleep(3000);
			
			driver.findElement(By.id("guest")).click();
			driver.findElement(By.xpath("//li[@data-cy='adults-3']")).click();
			driver.findElement(By.xpath("//button[@data-cy='submitGuest']")).click();
			Thread.sleep(5000);
			
			driver.findElement(By.id("hsw_search_button")).click();
			Thread.sleep(5000);
			
			
			driver.findElement(By.xpath("//label[text()='Near Indian Restaurants']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//label[text()='Pay @ Hotel Available']")).click();
			Thread.sleep(5000);
			//driver.findElement(By.xpath("//span[text()='Little India' ]")).click();
			//Thread.sleep(3000);
			driver.findElement(By.xpath("//label[text()='5 Star']")).click();
			
			Thread.sleep(5000);
			
			
			//Handle new tab-selecting a hotel
			
			String parentwindowHandle=driver.getWindowHandle();
			System.out.println(parentwindowHandle);
			
			driver.findElement(By.xpath("//span[@id='htl_id_seo_4190725563808544']")).click();
			Thread.sleep(3000);
			
			for (String handle: driver.getWindowHandles()) {
				   System.out.println(handle);
				   driver.switchTo().window(handle);

				  }
			
			driver.findElement(By.xpath("//a[@id='detpg_headerright_book_now']")).click();
			Thread.sleep(5000);
			
			//payment option
			
			
			Select title = new Select(driver.findElement(By.id("title")));
			title.selectByVisibleText("Ms");
			
			driver.findElement(By.id("fName")).sendKeys("Vibin");
			driver.findElement(By.id("lName")).sendKeys("Sree");
			driver.findElement(By.id("mNo")).sendKeys("9756784567");
			driver.findElement(By.id("pan")).sendKeys("BE12345FQ");
			
			
			driver.findElement(By.xpath("//div[text()='Pay Now']")).click();
			Thread.sleep(5000);
			
			//payment
			driver.findElement(By.id("PAYMENT_pancard")).sendKeys("BE12345FQ");
			driver.findElement(By.id("payment_pan_name")).sendKeys("Vibin Sree");
			driver.findElement(By.id("PanView")).click();
			driver.findElement(By.xpath("//span[text()='Credit/Debit Cards']")).click();
			driver.findElement(By.id("PAYMENT_cardNumber")).sendKeys("543567896");
			driver.findElement(By.id("PAYMENT_nameOnCard")).sendKeys("VibinSree");
			Select month = new Select(driver.findElement(By.id("PAYMENT_expiryMonth")));
			month.selectByVisibleText("09");
			Select year = new Select(driver.findElement(By.id("PAYMENT_expiryYear")));
			year.selectByVisibleText("2025");
			driver.findElement(By.id("PAYMENT_cvv")).sendKeys("546");
			
			
			Select country = new Select(driver.findElement(By.id("PAYMENT_billingCountry")));
			country.selectByVisibleText("India");
			
			driver.findElement(By.id("PAYMENT_billingAddress")).sendKeys("cv villas france");
			driver.findElement(By.id("PAYMENT_billingCity")).sendKeys("westfort");
			Thread.sleep(5000);
			driver.findElement(By.id("PAYMENT_billingPin")).sendKeys("44335");
			driver.findElement(By.id("PAYMENT_billingState")).sendKeys("Kochi");
			driver.findElement(By.id("widgetPayBtn")).click();
			
			Thread.sleep(5000);
			
			Screenshot screenshot= new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);

			ImageIO.write(screenshot.getImage(), "jpg", new File("C:\\Users\\JAYAPRABHA J\\Documents\\workspace-spring-tool-suite-4-4.8.0.RELEASE\\MakeMyTrip\\Screenshot\\ElementScreenshot.jpg"));
			}catch(WebDriverException e)
		{
			System.out.println("Exception is: ---"+e+"\n");
			System.out.println("hiiii");
		}	
		
	
	}	
	@AfterMethod
	public void CloseBrowser()
	{
		driver.quit();
	}
	

}