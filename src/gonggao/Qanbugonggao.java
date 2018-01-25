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

public class  Qanbugonggao{


	@Test(groups = {"Activity"},dataProvider = "guanliyuanFilePath",dataProviderClass = DateProvider.class)
	public  void publish_activity(String username,String password,String filePath,String vedioPath) throws Exception {	
//		DesiredCapabilities chromeDesiredcap = DesiredCapabilities.chrome();  
//		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeDesiredcap);  	  
		ChromeDriver driver = new ChromeDriver();
		Uti.ChromeBrowser_setup(driver, username, password); 
		driver.findElement(By.partialLinkText("公告")).click();
		Thread.sleep(1000); 
		driver.findElement(By.id("tab3")).click();//全部公告
		Thread.sleep(1000); 
		driver.findElement(By.id("roleType_4")).click();//辅导者
		Thread.sleep(2000);
		driver.findElement(By.id("roleType_2")).click();//专家
		Thread.sleep(2000);
		driver.findElement(By.id("tab4")).click();//我的草稿
		Thread.sleep(1000);
		driver.findElement(By.linkText("删除")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("取消")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("删除")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("确定")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("tab5")).click();//推荐公告
		Thread.sleep(1000);
		driver.findElement(By.linkText("编辑")).click();
		driver.findElement(By.id("input_title")).sendKeys("测试标题编辑");
		driver.findElement(By.partialLinkText("返回公告")).click();
		driver.findElement(By.linkText("发布")).click();
		driver.findElement(By.id("input_title")).clear();
		driver.findElement(By.id("input_title")).sendKeys("发公告的草稿");
		Thread.sleep(1000);
		driver.findElement(By.id("link")).click();
		driver.findElement(By.id("link_content")).sendKeys("https://www.baidu.com/");
		driver.findElement(By.linkText("保存为草稿")).click();
		driver.quit();
	}
}