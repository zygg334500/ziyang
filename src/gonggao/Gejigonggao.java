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

public class Gejigonggao{

	@Test(groups = {"Activity"},dataProvider = "guanliyuanFilePath",dataProviderClass = DateProvider.class)
	public void publish_activity(String username,String password,String filePath,String vedioPath) throws Exception {	
//		DesiredCapabilities chromeDesiredcap = DesiredCapabilities.chrome();  
//		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeDesiredcap);  

		ChromeDriver driver = new ChromeDriver();
		Uti.ChromeBrowser_setup(driver, username, password); 

		driver.findElement(By.partialLinkText("公告")).click();
		driver.findElement(By.xpath("(//li[contains(text(),'各级公告')])[1]")).click();
		driver.findElement(By.id("tab2")).click();
		Thread.sleep(1000);  
		driver.findElement(By.linkText("编辑")).click();
		driver.findElement(By.id("input_title")).sendKeys("测试标题编辑");
		Thread.sleep(1000);  
		Uti.richText(driver,0,"测试文本重新编辑");
		driver.findElement(By.linkText("更 新")).click();
		driver.findElement(By.xpath("(//li[contains(text(),'各级公告')])[1]")).click();
		driver.findElement(By.id("tab2")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("删除")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("取消")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("推荐")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("确定")).click();
		driver.findElement(By.linkText("取消")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("置顶")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("确定")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("确定")).click();
		Thread.sleep(2000);
		driver.quit();
	}
}