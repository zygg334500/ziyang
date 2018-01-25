//还有待改善

package gonggao;


import java.net.URL;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import DateProvider.DateProvider;
import Interface.TestInfo;
import Interface.TitleQueue;
import uti.Uti;

public class  Fabugonggao{



	@Test(groups = {"Activity"},dataProvider = "guanliyuanFilePath",dataProviderClass = DateProvider.class)
	public  void publish_activity(String username,String password,String filePath,String vedioPath) throws Exception {	
//		DesiredCapabilities chromeDesiredcap = DesiredCapabilities.chrome();  
//		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeDesiredcap);  

		ChromeDriver driver = new ChromeDriver();
		Uti.ChromeBrowser_setup(driver, username, password); 
		//发公告文本类型//
		driver.findElement(By.partialLinkText("公告")).click();
		driver.findElement(By.linkText("发布")).click();
		driver.findElement(By.id("input_title")).clear();
		driver.findElement(By.id("input_title")).sendKeys("发公告文本类型");
		Uti.resource(driver);//新增资源体系分类
		Thread.sleep(1000);
		/*	    
	    driver.findElement(By.id("SWFUpload_0")).click();
	    driver.findElement(By.id("SWFUpload_0")).click();
	    driver.findElement(By.id("SWFUpload_0")).click();
	    Runtime.getRuntime().exec("C:/Users/Administrator/Downloads/uploadFile.exe");
	    Thread.sleep(6000);//上传文件   
		 */
		Uti.richText(driver,0,"测试");

		driver.findElement(By.linkText("发 布")).click();
		//发公告链接类型//
		driver.findElement(By.partialLinkText("公告")).click();
		driver.findElement(By.linkText("发布")).click();
		driver.findElement(By.id("input_title")).clear();
		driver.findElement(By.id("input_title")).sendKeys("发公告链接类型");
		Thread.sleep(1000);
		driver.findElement(By.id("link")).click();
		driver.findElement(By.id("link_content")).sendKeys("https://www.baidu.com/");
		driver.findElement(By.linkText("发 布")).click();
		driver.findElement(By.partialLinkText("公告")).click();
		driver.findElement(By.linkText("发布")).click();
		driver.findElement(By.id("input_title")).clear();
		driver.findElement(By.id("input_title")).sendKeys("不发布返回");
		Thread.sleep(1000);
		driver.findElement(By.id("link")).click();
		driver.findElement(By.id("link_content")).sendKeys("https://www.baidu.com/");
		driver.findElement(By.linkText("返回")).click();
		//删除//
		driver.findElement(By.linkText("删除")).click();
		driver.findElement(By.linkText("确定")).click();
		//推荐//
		driver.findElement(By.linkText("推荐")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("确定")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("确定")).click();
		Thread.sleep(1000);
		//置顶//
		driver.findElement(By.linkText("置顶")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("确定")).click();  
		Thread.sleep(1000);
		driver.findElement(By.linkText("确定")).click(); 
		//发布//
		driver.findElement(By.linkText("发布")).click();
		driver.findElement(By.id("input_title")).clear();
		//返回//
		driver.findElement(By.id("input_title")).sendKeys("不发布返回");
		Thread.sleep(1000);
		driver.findElement(By.id("link")).click();
		driver.findElement(By.id("link_content")).sendKeys("https://www.baidu.com/");
		//保存草稿//
		driver.findElement(By.linkText("保存为草稿")).click();
		driver.findElement(By.partialLinkText("评论")).click();
		//评论//
		// 进入iframe ，添加富文本内容
		driver.switchTo().frame(driver.findElement(By.className("if_pl")));
		driver.switchTo().frame(driver.findElement(By.id("ueditor_0")));
		driver.findElement(By.tagName("body")).sendKeys("发布公告的内容文字");
		driver.switchTo().parentFrame();
		Thread.sleep(1000);
		driver.findElement(By.className("pl_btn")).click();
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("回复")).click();
		driver.findElement(By.name("$group.context.key")).sendKeys("发布公告的内容文字");
		Thread.sleep(2000);
		driver.findElement(By.className("pl_btn")).click();

		driver.switchTo().defaultContent();//跳出富文本
		driver.findElement(By.id ("tab1")).click();
		Thread.sleep(2000);

		driver.findElement(By.partialLinkText("推荐")).click();
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("确定")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//a[@value='1'and @class='btn'])[2]")).click();  
		driver.findElement(By.id("tab2")).click();
		
		driver.quit();

	}
}