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
		
		driver.findElement(By.partialLinkText("ĥ��")).click();
		driver.findElement(By.id("tab1")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[contains(text(),'�鿴�㼣')])[1]")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'�鿴��ϸ')])[1]")).click();
		
		driver.findElement(By.id("kindStyle_0")).click();
		WebElement context1= driver.findElement(By.id("content_content1"));//content_content2
		Assert.assertEquals("ѧϰĿ������", context1.getText());
        driver.findElement(By.id("kindStyle_1")).click();
		WebElement context2= driver.findElement(By.id("content_content2"));
		Assert.assertEquals("��ѧĿ������", context2.getText());
		driver.findElement(By.id("kindStyle_2")).click();
		WebElement context3= driver.findElement(By.id("content_content3"));
		Assert.assertEquals("��ѧ��������", context3.getText());
		driver.findElement(By.id("kindStyle_3")).click();
		WebElement context4= driver.findElement(By.id("content_content4"));
		Assert.assertEquals("�����������", context4.getText());
		driver.navigate().back();
		driver.findElement(By.xpath("(//a[contains(text(),'�鿴��ϸ')])[2]")).click();
		
		driver.findElement(By.id("kindStyle_0_0")).click();
		WebElement context1_1= driver.findElement(By.id("content_0_0"));//content_content2
		Assert.assertEquals("12345678ѧϰĿ������", context1_1.getText());
        driver.findElement(By.id("kindStyle_0_1")).click();
		WebElement context2_1= driver.findElement(By.id("content_0_1"));
		Assert.assertEquals("��ѧĿ������", context2_1.getText());
		driver.findElement(By.id("kindStyle_0_2")).click();
		WebElement context3_1= driver.findElement(By.id("content_0_2"));
		Assert.assertEquals("��ѧ��������", context3_1.getText());
		driver.findElement(By.id("kindStyle_0_3")).click();
		WebElement context4_1= driver.findElement(By.id("content_0_3"));
		Assert.assertEquals("�����������", context4_1.getText());
		System.out.println("ĥ�μ������");
	    driver.quit();

  }

	@Override
	public ChromeDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}
}
