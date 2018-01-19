package Activity;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Interface.TestInfo;

import uti.Uti;

public class  Publish_ActivitywithallStep implements TestInfo{

	private static final ChromeDriver driver=new ChromeDriver();


	@Test(groups = {"Activity"})
	public void publish_activity() throws Exception {


		Uti.ChromeBrowser_setup(driver, "xmgly", "123123");
		driver.findElement(By.partialLinkText("活动")).click();//原来是用xpath或者是用linkText，都不如这个好，这个可变性比较好
		driver.findElement(By.linkText("发布")).click();
		driver.findElement(By.linkText("自定义")).click();
		driver.findElement(By.id("activityName")).clear();
		driver.findElement(By.id("activityName")).sendKeys("奔波儿灞");
		driver.findElement(By.id("startTime")).click();
		driver.findElement(By.id("startTime")).clear();
		driver.findElement(By.id("startTime")).sendKeys(Uti.get_currenttime());
		driver.findElement(By.id("endtime")).click();
		driver.findElement(By.id("endtime")).clear();
		driver.findElement(By.id("endtime")).sendKeys(Uti.get_currenttime());
		driver.findElement(By.id("endtime")).click();
		driver.findElement(By.linkText("保存到下一步")).click();
		driver.findElement(By.linkText("新增环节")).click();
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("不是开玩笑");
		driver.findElement(By.linkText("选择工具")).click();

		driver.findElement(By.id("a1")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("保存")).click();

		driver.findElement(By.linkText("新增环节")).click();
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("不是开玩笑");
		driver.findElement(By.linkText("选择工具")).click();
		driver.findElement(By.id("a2")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("保存")).click();

		driver.findElement(By.linkText("新增环节")).click();
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("嘿嘿");
		driver.findElement(By.linkText("选择工具")).click();
		driver.findElement(By.id("a3")).click();

		Thread.sleep(3000);
		Uti.UploadFile(driver, "C:/Program Files (x86)/Mozilla Firefox/uploadFile.exe","SWFUpload_0");//上传文件

		driver.findElement(By.linkText("保存")).click();

		driver.findElement(By.linkText("新增环节")).click();
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("过的身高大概");
		driver.findElement(By.linkText("选择工具")).click();
		driver.findElement(By.id("a4")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("保存")).click(); 

		driver.findElement(By.linkText("新增环节")).click();
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("资源分型");
		driver.findElement(By.linkText("选择工具")).click();
		driver.findElement(By.id("a5")).click();
		driver.findElement(By.id("zhengfang")).clear();
		driver.findElement(By.id("zhengfang")).sendKeys("正方内容");
		driver.findElement(By.id("fanfang")).clear();
		driver.findElement(By.id("fanfang")).sendKeys("反方辩题");
		Thread.sleep(1000);
		driver.findElement(By.linkText("保存")).click();//前面五个步骤

		driver.findElement(By.linkText("新增环节")).click();
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("手动阀手动阀");
		driver.findElement(By.linkText("选择工具")).click(); 

		driver.findElement(By.id("a6")).click();
		Thread.sleep(1000);

		Uti.UploadVedio(driver,"C:/Program Files (x86)/Mozilla Firefox/uploadVideo.exe");//上传视频方法

		Uti.waitForAlertAndCloseAlert(driver);//十秒内强制等待alert框出现，每秒检查一次，第几秒检查不到，就抛出异常
		driver.findElement(By.className("video_close")).click();//关闭窗口
		Thread.sleep(3000);
		driver.findElement(By.linkText("保存")).click();
		driver.findElement(By.linkText("新增环节")).click();
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("gdsfewr");
		driver.findElement(By.linkText("选择工具")).click();
		driver.findElement(By.id("a7")).click();
		new Select(driver.findElement(By.id("p_list"))).selectByVisibleText("语文教学计划");
		new WebDriverWait(driver, 4).until(ExpectedConditions.presenceOfElementLocated(By.id( "c_list" )));
		//driver.findElement(By.id("c_list")).click();
		new Select(driver.findElement(By.id("c_list"))).selectByVisibleText("高中语文（Ⅰ）课堂教学中语文思辨能力的培养");
		driver.findElement(By.linkText("确认")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("保存")).click();

		driver.findElement(By.linkText("新增环节")).click();
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("fdgewr");
		driver.findElement(By.linkText("选择工具")).click();
		driver.findElement(By.id("a8")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("保存")).click();
		try {
			driver.findElement(By.linkText("发布")).click();
			System.out.println("活动发布成功");
		} catch (Exception e) {
			System.out.println("活动未发布成功");
			// TODO: handle exception
		}

		driver.quit();

	}

	public ChromeDriver getDriver(){
		return driver;   
	}


}
//
//
//  private boolean isElementPresent(By by) {
//    try {
//      driver.findElement(by);
//      return true;
//    } catch (NoSuchElementException e) {
//      return false;
//    }
//  }
//


//
//  private String closeAlertAndGetItsText() {
//    try {
//      Alert alert = driver.switchTo().alert();
//      String alertText = alert.getText();
//      if (acceptNextAlert) {
//        alert.accept();
//      } else {
//        alert.dismiss();
//      }
//      return alertText;
//    } finally {
//      acceptNextAlert = true;
//    }
//  }
//}
