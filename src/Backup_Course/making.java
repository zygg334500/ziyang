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
		
		driver.findElement(By.partialLinkText("����")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'�鿴����')])[1]")).click();
		
		driver.findElement(By.linkText("δ����")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("δ����")).click();
		try {
			driver.findElement(By.linkText("����")).click();
			
		} catch (Exception e) {
			driver.findElement(By.linkText("����")).click();
			// TODO: handle exception
		}
		
	    driver.findElement(By.xpath("(//input[contains(@value,'good')])")).click();
	    driver.findElement(By.name("remark")).sendKeys("����д�Ĳ����Ƽ�����Ķ�");
	    driver.findElement(By.name("isRecommend")).click();
	    driver.findElement(By.linkText("����")).click();

	  try {
		while(true){
			driver.findElement(By.linkText("����")).click();
			break;
		}
	} catch (Exception e) {
	     Uti.waitForAlertAndCloseAlert(driver);
		// TODO: handle exception
	}
	    System.out.println("�������ĳɹ�");
	    driver.quit();
  }

@Override
public ChromeDriver getDriver() {
	// TODO Auto-generated method stub
	return driver;
} 
}
