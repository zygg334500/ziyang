package Activity;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import DateProvider.DateProvider;
import Interface.TestInfo;
import Interface.TitleQueue;
import uti.Uti;

public class  Publish_ActivitywithallStep implements TestInfo{

	private static final ChromeDriver driver=new ChromeDriver();


	@Test(groups = {"Activity"},dataProvider = "guanliyuanFilePath",dataProviderClass = DateProvider.class)
	public void publish_activity(String username,String password, String filepath,String vediopath) throws Exception {


		Uti.ChromeBrowser_setup(driver, username, password);
		driver.findElement(By.partialLinkText("活动")).click();//原来是用xpath或者是用linkText，都不如这个好，这个可变性比较好
		driver.findElement(By.linkText("发布")).click();
		driver.findElement(By.className("zdy")).click();
		driver.findElement(By.id("activityName")).clear();
		String activityTitle= Uti.get_activityName();
		TitleQueue.push(activityTitle,this.getClass().getName(),"NewActivity.JoinActivity");//将标题放入全局队列中
		driver.findElement(By.id("activityName")).sendKeys(activityTitle);
		driver.findElement(By.id("startTime")).click();
		driver.findElement(By.id("startTime")).clear();
		driver.findElement(By.id("startTime")).sendKeys(Uti.get_currenttime());
		driver.findElement(By.id("endtime")).click();
		driver.findElement(By.id("endtime")).clear();
		driver.findElement(By.id("endtime")).sendKeys(Uti.get_currenttime());
		driver.findElement(By.id("endtime")).click();
		Uti.richText(driver, 0, "这是输入的活动内容");
		driver.findElement(By.linkText("保存到下一步")).click();
		driver.findElement(By.linkText("新增环节")).click();
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("不是开玩笑");
		driver.findElement(By.linkText("选择工具")).click();

		driver.findElement(By.id("a1")).click();
		Thread.sleep(1000);
		Uti.richText(driver, 0, "这是输入的活动步骤");
		driver.findElement(By.linkText("保存")).click();

		driver.findElement(By.linkText("新增环节")).click();
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("不是开玩笑");
		driver.findElement(By.linkText("选择工具")).click();
		driver.findElement(By.id("a2")).click();
		Thread.sleep(1000);
		Uti.richText(driver, 0, "这是输入的活动步骤");
		driver.findElement(By.linkText("保存")).click();

		driver.findElement(By.linkText("新增环节")).click();
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("嘿嘿");
		driver.findElement(By.linkText("选择工具")).click();
		driver.findElement(By.id("a3")).click();
		Thread.sleep(3000);
		Uti.richText(driver, 0, "这是输入的活动步骤");
		Uti.UploadFile(driver, filepath,"SWFUpload_0");//上传文件

		driver.findElement(By.linkText("保存")).click();

		driver.findElement(By.linkText("新增环节")).click();
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("过的身高大概");
		driver.findElement(By.linkText("选择工具")).click();
		
		driver.findElement(By.id("a4")).click();
		Thread.sleep(1000);
		Uti.richText(driver, 0, "这是输入的活动步骤");
		driver.findElement(By.linkText("保存")).click(); 

		driver.findElement(By.linkText("新增环节")).click();
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("资源分型");
		driver.findElement(By.linkText("选择工具")).click();
		driver.findElement(By.id("a5")).click();
		Uti.richText(driver, 0, "这是输入的活动步骤");
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
		Uti.richText(driver, 0, "这是输入的活动步骤");
		Uti.UploadVedio(driver,vediopath);//上传视频
		Uti.waitForAlertAndCloseAlert(driver);//十秒内强制等待alert框出现，每秒检查一次，第几秒检查不到，就抛出异常
		driver.findElement(By.className("video_close")).click();//关闭窗口
		Thread.sleep(3000);
		driver.findElement(By.linkText("保存")).click();
		driver.findElement(By.linkText("新增环节")).click();
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("gdsfewr");
		driver.findElement(By.linkText("选择工具")).click();
		
		driver.findElement(By.id("a7")).click();
		Uti.richText(driver, 0, "这是输入的活动步骤");
		new Select(driver.findElement(By.id("p_list"))).selectByIndex(1);
		new WebDriverWait(driver, 4).until(ExpectedConditions.presenceOfElementLocated(By.id( "c_list" )));
		//driver.findElement(By.id("c_list")).click();
		new Select(driver.findElement(By.id("c_list"))).selectByIndex(1);
		driver.findElement(By.linkText("确认")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("保存")).click();

		driver.findElement(By.linkText("新增环节")).click();
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("fdgewr");
		driver.findElement(By.linkText("选择工具")).click();
		driver.findElement(By.id("a8")).click();
		Thread.sleep(3000);
		Uti.richText(driver, 0, "这是输入的活动步骤");
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
