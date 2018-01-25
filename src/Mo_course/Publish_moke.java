package Mo_course;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import Interface.TestInfo;

import uti.Uti;

public class Publish_moke implements TestInfo{
	private static final ChromeDriver driver=new ChromeDriver();

	@Test(groups = {"Mo_course"})
  public void publish_moke() throws Exception {

		Uti.ChromeBrowser_setup(driver, "devteacher", "3edc$RFV");
		
		driver.findElement(By.partialLinkText("磨课")).click();
		driver.findElement(By.linkText("发布")).click();	
		

		driver.findElement(By.name("startTime")).sendKeys(Uti.get_currenttime());
		driver.findElement(By.name("endTime")).sendKeys(Uti.get_currenttime());
		new Select(driver.findElement(By.id("kindId"))).selectByVisibleText("教学设计");
		driver.findElement(By.name("cengji")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("dict_tree_con1_1_check")).click();
		driver.findElement(By.id("dict_tree_con2_1_check")).click();
		driver.findElement(By.linkText("确定")).click();
		driver.findElement(By.id("input_title")).sendKeys("魔克猪1");
		
		Uti.richText(driver,0,"信息概述");
		
		Uti.richText(driver,1,"学习目标内容");
		
		driver.findElement(By.xpath("//li[@id='0'][text()='教学方法']")).click();
		Uti.richText(driver,2,"教学目标内容");
		
		driver.findElement(By.xpath("//li[@id='0'][text()='教学过程']")).click();
		Uti.richText(driver,3,"教学方法内容");

		driver.findElement(By.xpath("//li[@id='0'][text()='板书设计']")).click();
		Uti.richText(driver,4,"板书设计内容");
		
//		Uti.UploadFile(driver, "C:/Program Files (x86)/Mozilla Firefox/uploadFile.exe","SWFUpload_0");
		driver.findElement(By.linkText("发布")).click();
	    System.out.println("磨课发布成功");
	    
	    driver.quit();
  }

	@Override
	public ChromeDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}
}
