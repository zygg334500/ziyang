package HomePage;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import uti.Uti;



import DateProvider.DateProvider;

//管理员，专家，辅导老师，辅导状况按钮工作验证
public class EveryRole_HomePage{
	

  @Test(dataProvider = "devAccount_account",dataProviderClass = DateProvider.class)
  public void raimn(String username,String password) throws Exception {
	    DesiredCapabilities chromeDesiredcap = DesiredCapabilities.chrome();  
	    WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeDesiredcap);  		Uti.ChromeBrowser_setup(driver, username, password);
		
	    driver.findElement(By.className("active")).click();
		Uti.ChangeWindows(driver, 2);
//		int number1 = driver.findElements(By.linkText("去发布")).size();
//		int number2 = driver.findElements(By.linkText("去评论")).size();
//		int number3 = driver.findElements(By.linkText("去回复")).size();
//		int number4 = driver.findElements(By.linkText("去推荐")).size();
//		int number5 = driver.findElements(By.linkText("去查看")).size();
//		int number6 = driver.findElements(By.linkText("去参与")).size();
//		int number7 = driver.findElements(By.linkText("去批阅")).size();
//		System.out.println(number1 + " " + number2 + " " + number3 + " "
//				+ number4 + " " + number5 + " " + number6 + " " + number7);
		driver.findElement(By.xpath("(//a[contains(text(),'去批阅')])[1]")).click();
		Thread.sleep(500);
		Assert.assertEquals(true, Uti.isTextPresent(driver, "全部作业"));
		Thread.sleep(500);
		driver.navigate().back();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//a[contains(text(),'去推荐')])[1]")).click();
		Thread.sleep(500);
		Assert.assertEquals(true, Uti.isTextPresent(driver, "全部作业"));
		Thread.sleep(500);
		driver.navigate().back();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//a[contains(text(),'去发布')])[1]")).click();
		Thread.sleep(500);
		Assert.assertEquals(true, Uti.isTextPresent(driver, "发布作业"));
		Thread.sleep(500);
		driver.navigate().back();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//a[contains(text(),'去查看')])[1]"))
				.click();
		Thread.sleep(500);
		Assert.assertEquals(true, Uti.isTextPresent(driver, "全部客观题"));
		Thread.sleep(500);
		driver.navigate().back();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//a[contains(text(),'去评论')])[1]"))
				.click();
		Thread.sleep(500);
		Assert.assertEquals(true, Uti.isTextPresent(driver, "我发布的文章"));
		Thread.sleep(500);
		driver.navigate().back();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//a[contains(text(),'去推荐')])[2]"))
			.click();
		Thread.sleep(500);
		Assert.assertEquals(true, Uti.isTextPresent(driver, "我发布的文章"));
		Thread.sleep(500);
		driver.navigate().back();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//a[contains(text(),'去上传')])[1]"))
				.click();
		Thread.sleep(500);
		Assert.assertEquals(true, Uti.isTextPresent(driver, "我上传的资源"));
		Thread.sleep(500);
		driver.navigate().back();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//a[contains(text(),'去下载')])[1]"))
				.click();
		Thread.sleep(500);
		Assert.assertEquals(true, Uti.isTextPresent(driver, "我上传的资源"));
		Thread.sleep(500);
		driver.navigate().back();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//a[contains(text(),'去评论')])[2]"))
				.click();
		Thread.sleep(500);
		Assert.assertEquals(true, Uti.isTextPresent(driver, "我上传的资源"));
		Thread.sleep(500);
		driver.navigate().back();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//a[contains(text(),'去上传')])[2]"))
				.click();
		Thread.sleep(500);
		Assert.assertEquals(true, Uti.isTextPresent(driver, "我上传的视频"));
		Thread.sleep(500);
		driver.navigate().back();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//a[contains(text(),'去浏览')])[1]"))
				.click();
		Thread.sleep(500);
		Assert.assertEquals(true, Uti.isTextPresent(driver, "我上传的视频"));
		Thread.sleep(500);
		driver.navigate().back();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//a[contains(text(),'去评论')])[3]"))
				.click();
		Thread.sleep(500);
		Assert.assertEquals(true, Uti.isTextPresent(driver, "我上传的视频"));
		Thread.sleep(500);
		driver.navigate().back();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//a[contains(text(),'去回复')])[1]"))
				.click();
		Thread.sleep(500);
		Assert.assertEquals(true, Uti.isTextPresent(driver, "我发布的交流"));
		Thread.sleep(500);
		driver.navigate().back();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//a[contains(text(),'去评论')])[4]"))
				.click();
		Thread.sleep(500);
		Assert.assertEquals(true, Uti.isTextPresent(driver, "我发布的公告"));
		Thread.sleep(500);
		driver.navigate().back();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//a[contains(text(),'去推荐')])[3]"))
				.click();
		Thread.sleep(500);
		Assert.assertEquals(true, Uti.isTextPresent(driver, "我发布的公告"));
		Thread.sleep(500);
		driver.navigate().back();
		Thread.sleep(500);
		driver.findElement(By.xpath("//li[contains(text(),'研修部分')]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//a[contains(text(),'去批阅')])[1]"))
				.click();
		Thread.sleep(500);
		Assert.assertEquals(true, Uti.isTextPresent(driver, "全部备课"));
		Thread.sleep(500);
		driver.navigate().back();
		Thread.sleep(500);
		driver.findElement(By.xpath("//li[contains(text(),'研修部分')]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//a[contains(text(),'去推荐')])[1]"))
				.click();
		Thread.sleep(500);
		Assert.assertEquals(true, Uti.isTextPresent(driver, "全部备课"));
		Thread.sleep(500);
		driver.navigate().back();
		Thread.sleep(500);
		driver.findElement(By.xpath("//li[contains(text(),'研修部分')]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//a[contains(text(),'去发布')])[1]"))
				.click();
		Thread.sleep(500);
		Assert.assertEquals(true, Uti.isTextPresent(driver, "发布备课"));
		Thread.sleep(500);
		driver.navigate().back();
		driver.findElement(By.xpath("//li[contains(text(),'研修部分')]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//a[contains(text(),'去批阅')])[2]"))
		.click();
		Thread.sleep(500);
		Assert.assertEquals(true, Uti.isTextPresent(driver, "全部活动"));
		Thread.sleep(500);
		driver.navigate().back();
		driver.findElement(By.xpath("//li[contains(text(),'研修部分')]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//a[contains(text(),'去推荐')])[2]"))
		.click();
		Thread.sleep(500);
		Assert.assertEquals(true, Uti.isTextPresent(driver, "全部活动"));
		Thread.sleep(500);
		driver.navigate().back();
		driver.findElement(By.xpath("//li[contains(text(),'研修部分')]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//a[contains(text(),'去发布')])[2]"))
		.click();
		Thread.sleep(600);
		Assert.assertEquals(true, Uti.isTextPresent(driver, "研修活动"));
		Thread.sleep(500);
		driver.navigate().back();
		driver.findElement(By.xpath("//li[contains(text(),'研修部分')]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//a[contains(text(),'增加主题')])[1]"))
		.click();
		Thread.sleep(500);
		Assert.assertEquals(true, Uti.isTextPresent(driver, "我发布的同伴协作"));
		Thread.sleep(500);
		driver.navigate().back();
		driver.findElement(By.xpath("//li[contains(text(),'研修部分')]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//a[contains(text(),'去参与')])[1]"))
		.click();
		Thread.sleep(500);
		Assert.assertEquals(true, Uti.isTextPresent(driver, "我发布的同伴协作"));
		Thread.sleep(500);
		driver.navigate().back();
		driver.findElement(By.xpath("//li[contains(text(),'研修部分')]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//a[contains(text(),'去发布')])[3]"))
		.click();
		Thread.sleep(500);
		Assert.assertEquals(true, Uti.isTextPresent(driver, "发布同伴协作"));
		Thread.sleep(500);
		driver.navigate().back();
		driver.quit();
  }
  

}
