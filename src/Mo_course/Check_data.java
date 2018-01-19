package Mo_course;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import Interface.TestInfo;

import uti.Uti;

public class Check_data implements TestInfo{
	private static final ChromeDriver driver=new ChromeDriver();
	@Test(groups = {"Mo_course"})
  public void check_data() throws Exception {
	  
		
		Uti.ChromeBrowser_setup(driver, "suke", "123123");
		
		driver.findElement(By.partialLinkText("磨课")).click();
		driver.findElement(By.id("tab1")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[contains(text(),'查看足迹')])[1]")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'查看详细')])[1]")).click();
		
		driver.findElement(By.id("kindStyle_0")).click();
		WebElement context1= driver.findElement(By.id("content_content1"));//content_content2
		Assert.assertEquals("学习目标内容", context1.getText());
        driver.findElement(By.id("kindStyle_1")).click();
		WebElement context2= driver.findElement(By.id("content_content2"));
		Assert.assertEquals("教学目标内容", context2.getText());
		driver.findElement(By.id("kindStyle_2")).click();
		WebElement context3= driver.findElement(By.id("content_content3"));
		Assert.assertEquals("教学方法内容", context3.getText());
		driver.findElement(By.id("kindStyle_3")).click();
		WebElement context4= driver.findElement(By.id("content_content4"));
		Assert.assertEquals("板书设计内容", context4.getText());
		driver.navigate().back();
		driver.findElement(By.xpath("(//a[contains(text(),'查看详细')])[2]")).click();
		
		driver.findElement(By.id("kindStyle_0_0")).click();
		WebElement context1_1= driver.findElement(By.id("content_0_0"));//content_content2
		Assert.assertEquals("12345678学习目标内容", context1_1.getText());
        driver.findElement(By.id("kindStyle_0_1")).click();
		WebElement context2_1= driver.findElement(By.id("content_0_1"));
		Assert.assertEquals("教学目标内容", context2_1.getText());
		driver.findElement(By.id("kindStyle_0_2")).click();
		WebElement context3_1= driver.findElement(By.id("content_0_2"));
		Assert.assertEquals("教学方法内容", context3_1.getText());
		driver.findElement(By.id("kindStyle_0_3")).click();
		WebElement context4_1= driver.findElement(By.id("content_0_3"));
		Assert.assertEquals("板书设计内容", context4_1.getText());
		System.out.println("磨课检验完毕");
	    driver.quit();

  }

	@Override
	public ChromeDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}
}
