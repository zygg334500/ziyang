package task;

import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import Interface.TestInfo;
import uti.Uti;

public class Making{
      @Test(groups = {"task"})
  public void making() throws Exception {
    	ChromeDriver driver=new ChromeDriver();
		Uti.ChromeBrowser_setup(driver, "devguanliyuan", "3edc$RFV");
	    
	    driver.findElement(By.partialLinkText("作业")).click();

	    driver.findElement(By.xpath("(//a[contains(text(),'去批阅')])[1]")).click();
	    try {
	    	driver.findElement(By.xpath("(//a[contains(text(),'未批阅')])")).click();
	    	Thread.sleep(500);
	    	driver.findElement(By.linkText("批阅")).click();
		} catch (Exception e) {
			// TODO: handle exception
			driver.navigate().refresh();
			driver.findElement(By.xpath("(//a[contains(text(),'未批阅')])")).click();
	    	Thread.sleep(500);
			driver.findElement(By.linkText("批阅")).click();
		}
	    driver.findElement(By.xpath("(//input[contains(@value,'verygood')])")).click();
	    driver.findElement(By.id("TextArea1")).sendKeys("同学钻研的很深啊");
	    driver.findElement(By.name("messages")).sendKeys("老师看好你，再接再厉");
	    driver.findElement(By.name("isRecommend")).click();
	    driver.findElement(By.linkText("批阅完成")).click();
	    try {
		    Thread.sleep(4000);    
		    Alert alt=driver.switchTo().alert();
		    alt.dismiss();
		} catch (Exception e) {
			//不进行连续批阅
			
			// TODO: handle exception
		}

	    System.out.println("作业批阅成功");
	    driver.quit();
  }
}
