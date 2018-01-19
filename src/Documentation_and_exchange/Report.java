package Documentation_and_exchange;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import uti.Uti;

public class Report {

	public static void report(WebDriver driver) throws Exception{
		
		//driver.findElementByPartialLinkText(content_title).click();
		//Thread.sleep(500);
		
		//Uti.ChangeWindows(driver, 2);
		String xpath_report = "//span[@id='btn'][@onclick='report()']";
		driver.findElement(By.xpath(xpath_report)).click();
		Thread.sleep(500);
		
		String xpath_selector = "//input[@type='radio'][@value='5']";
		driver.findElement(By.xpath(xpath_selector)).click();
		
		driver.switchTo().frame(0);
		driver.findElement(By.className("ke-content")).sendKeys("举报内容"+Uti.get_random());
		driver.switchTo().defaultContent();		
		driver.findElement(By.linkText("提交")).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		
		
	}
	
}
