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
	  
		
		Uti.ChromeBrowser_setup(driver, "devzhuanjia", "3edc$RFV");
		
		driver.findElement(By.partialLinkText("备课")).click();
		driver.findElement(By.id("tab1")).click();
		Thread.sleep(500);
		try {
			driver.findElement(By.xpath("(//a[contains(text(),'查看详情')])[1]")).click();

		} catch (Exception e) {
			//管理员或者专家，批阅的位置不同，全部备课的tab序号不一致，切换账号有可能出问题，因此写了try做判断
			driver.findElement(By.id("tab2")).click();
			Thread.sleep(500);
			driver.findElement(By.xpath("(//a[contains(text(),'查看详情')])[1]")).click();

			// TODO: handle exception
		}
		
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
