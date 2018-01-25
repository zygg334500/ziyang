package Activity;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Interface.TestInfo;

import uti.Uti;

public class  Advice_to_activity implements TestInfo{

	private static final ChromeDriver driver=new ChromeDriver();
	@Test(groups = {"Activity"})
	public void advice_to_activity() throws Exception {

		Uti.ChromeBrowser_setup(driver, "devguanliyuan", "3edc$RFV");
		driver.findElement(By.partialLinkText("活动")).click();//原来是用xpath或者是用linkText，都不如这个好，这个可变性比较好
		driver.findElement(By.linkText("提交详情")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'未批阅')])")).click();
		Thread.sleep(1000);
		try {
			driver.findElement(By.linkText("查看并批阅")).click();
		} catch (Exception e) {
			// TODO: handle exception
			driver.navigate().refresh();
			driver.findElement(By.xpath("(//a[contains(text(),'未批阅')])")).click();
			Thread.sleep(1000);
			driver.findElement(By.linkText("查看并批阅")).click();
		}

		Uti.ChangeWindows(driver, 2);
		driver.findElement(By.id("RadioGroup1_0")).click();
		driver.findElement(By.id("TextArea2")).sendKeys("干得漂亮，老师相信你");
		driver.findElement(By.name("isRecommend")).click();
		driver.findElement(By.cssSelector("input[class='btn l']")).click();//处理带空格的classname的方法，而不是直接用classname的方法查找，那样子会报错

		Thread.sleep(1000);
		Uti.waitForAlertAndCloseAlert(driver);   
		System.out.println("活动批阅成功");
		driver.quit();
	}

	@Override
	public ChromeDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}
}


