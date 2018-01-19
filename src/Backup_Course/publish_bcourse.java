package Backup_Course;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import Interface.TestInfo;

import uti.Uti;

public class publish_bcourse implements TestInfo{
	
	private static final ChromeDriver driver=new ChromeDriver();
  @Test(groups = {"Backup_Course"})
  public void read_beker() throws Exception {
		
		Uti.ChromeBrowser_setup(driver, "suke", "123123");
		
		driver.findElement(By.partialLinkText("备课")).click();
		driver.findElement(By.linkText("发布")).click();
		
		driver.findElement(By.id("teachingplanTitle")).sendKeys("专家发布的备课1");
		driver.findElement(By.id("endtime")).sendKeys("2018-03-02");
		
		driver.switchTo().frame(0);
		driver.findElement(By.className("ke-content")).sendKeys("备课内容");
		driver.switchTo().defaultContent();
		
		Uti.UploadFile(driver, "C:/Program Files (x86)/Mozilla Firefox/uploadFile.exe","SWFUpload_0");
		
		try {
			driver.findElement(By.linkText("发布")).click();
		} catch (Exception e) {
			System.out.println("备课没有发布成功");
			// TODO: handle exception
		}
	    System.out.println("备课发布成功");
	    driver.quit();
		
//		driver.findElement(By.id("tab1")).click();
//	    Thread.sleep(1000);
//		driver.findElement(By.linkText("专家发布的备课1")).click();//点了不报错，证明全部备课下面存在，有这个课程

  }

@Override
public ChromeDriver getDriver() {
	// TODO Auto-generated method stub
	return driver;
}
}
