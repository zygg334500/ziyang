package task;

import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import Interface.TestInfo;
import uti.Uti;

public class Making implements TestInfo{
	private static final ChromeDriver driver=new ChromeDriver();
      @Test(groups = {"task"})
  public void making() throws Exception {
		Uti.ChromeBrowser_setup(driver, "xmgly", "123123");
	    
	    driver.findElement(By.partialLinkText("��ҵ")).click();

	    driver.findElement(By.xpath("(//a[contains(text(),'ȥ����')])[1]")).click();
	    try {
	    	driver.findElement(By.xpath("(//a[contains(text(),'δ����')])")).click();
	    	driver.findElement(By.linkText("����")).click();
		} catch (Exception e) {
			// TODO: handle exception
			driver.navigate().refresh();
			driver.findElement(By.xpath("(//a[contains(text(),'δ����')])")).click();
			driver.findElement(By.linkText("����")).click();
		}
	    driver.findElement(By.xpath("(//input[contains(@value,'verygood')])")).click();
	    driver.findElement(By.id("TextArea1")).sendKeys("ͬѧ���еĺ��");
	    driver.findElement(By.name("messages")).sendKeys("��ʦ�����㣬�ٽ�����");
	    driver.findElement(By.name("isRecommend")).click();
	    driver.findElement(By.linkText("�������")).click();
	    Thread.sleep(4000);    
	    Alert alt=driver.switchTo().alert();
	    alt.dismiss();
	    System.out.println("��ҵ���ĳɹ�");
	    driver.quit();
  }

@Override
public ChromeDriver getDriver() {
	// TODO Auto-generated method stub
	return driver;
}
}
