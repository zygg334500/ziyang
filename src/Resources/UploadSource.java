package Resources;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import uti.Uti;
import DateProvider.DateProvider;

public class UploadSource {
		
	//此处可根据实际情况调整，实例化浏览器时是否加载个人配置

//	public final ChromeDriver driver = createDriver();

	public final ChromeDriver driver = new ChromeDriver();
	
	@Test(dataProvider = "zhuanjiaFilePath",dataProviderClass = DateProvider.class)
	
	public void uploadSource(String username,String password,String path,String vedioPath) throws Exception{
		
		Uti.ChromeBrowser_setup(driver,username,password);
		
		String s1 = "//a[contains(text(),'资源')][contains(@href,'resourceListNew')]";
		driver.findElement(By.xpath(s1)).click();
		
		driver.findElementByLinkText("上传").click();
		
        Uti.resource(driver);
		//上传附件

		driver.findElementById("SWFUpload_0").click();
		driver.findElementById("SWFUpload_0").click();
		//String path = "D:/eclipse/upload.exe";

		Runtime.getRuntime().exec(path);
		Thread.sleep(5000);
		
		//重命名后发表

		driver.findElementById("input_name").click();
		driver.findElementById("input_name").clear();
		driver.findElementById("input_name").sendKeys("文档资源"+Uti.get_random());
		driver.findElementById("fb").click();
		Thread.sleep(2000);
		
		//判断是否成功

		Assert.assertEquals(isSuccess("文档资源"),true);
		
		//退出登录

		driver.findElementByLinkText("退出").click();
		Thread.sleep(1000);
		driver.quit();
	}
	//以加载个人配置的方式实例化Chrome的方法，适用于61及以后版本flash无法上传的情况，但多线程执行时会出现问题

	public static ChromeDriver createDriver(){
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=C:/Users/Administrator/AppData/Local/Google/Chrome/User Data");
		ChromeDriver driver = new ChromeDriver(options);
		return driver;
		
	}
	
	//用于判断资源是否成功上传的方法

	public boolean isSuccess(String text){
		
		try{
			driver.findElementByPartialLinkText(text);
			return true;
		}catch (Exception e){
			return false;
		}
		
	}
}