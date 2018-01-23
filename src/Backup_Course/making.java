package Backup_Course;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Interface.TestInfo;

import uti.Uti;

public class making implements TestInfo {
private static final ChromeDriver driver=new ChromeDriver();
  @Test(groups = {"Backup_Course"})
  public void read() throws Exception {
	  
		
		Uti.ChromeBrowser_setup(driver, "suke", "123123");
		
		driver.findElement(By.partialLinkText("备课")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'查看详情')])[1]")).click();
		
		driver.findElement(By.linkText("未批阅")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("未批阅")).click();
		try {
			driver.findElement(By.linkText("批阅")).click();
			
		} catch (Exception e) {
			driver.findElement(By.linkText("批阅")).click();
			// TODO: handle exception
		}
		
	    driver.findElement(By.xpath("(//input[contains(@value,'good')])")).click();
	    driver.findElement(By.name("remark")).sendKeys("备课写的不错，推荐大家阅读");
	    driver.findElement(By.name("isRecommend")).click();
	    driver.findElement(By.linkText("发布")).click();

	  try {
		while(true){
			driver.findElement(By.linkText("返回")).click();
			break;
		}
	} catch (Exception e) {
	     Uti.waitForAlertAndCloseAlert(driver);
		// TODO: handle exception
	}
	    System.out.println("备课批阅成功");
	    driver.quit();
  }

@Override
public ChromeDriver getDriver() {
	// TODO Auto-generated method stub
	return driver;
} 
}
