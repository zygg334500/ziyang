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

		Uti.ChromeBrowser_setup(driver, "xmgly", "123123");
		//driver.manage().window().maximize();
		driver.findElement(By.partialLinkText("�")).click();//ԭ������xpath��������linkText������������ã�����ɱ��ԱȽϺ�
		driver.findElement(By.linkText("�ύ����")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'δ����')])")).click();
		Thread.sleep(1000);
		try {
			driver.findElement(By.linkText("�鿴������")).click();
		} catch (Exception e) {
			// TODO: handle exception
			driver.navigate().refresh();
			driver.findElement(By.xpath("(//a[contains(text(),'δ����')])")).click();
			Thread.sleep(1000);
			driver.findElement(By.linkText("�鿴������")).click();
		}

		Uti.ChangeWindows(driver, 2);
		driver.findElement(By.id("RadioGroup1_0")).click();
		driver.findElement(By.id("TextArea2")).sendKeys("�ɵ�Ư������ʦ������");
		driver.findElement(By.name("isRecommend")).click();
		driver.findElement(By.cssSelector("input[class='btn l']")).click();//������ո��classname�ķ�����������ֱ����classname�ķ������ң������ӻᱨ��

		Thread.sleep(1000);
		Uti.waitForAlertAndCloseAlert(driver);   
		System.out.println("����ĳɹ�");
		driver.quit();
	}

	@Override
	public ChromeDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}
}


