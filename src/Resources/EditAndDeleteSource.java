package Resources;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import uti.Uti;
import DateProvider.DateProvider;

public class EditAndDeleteSource {

//	public final ChromeDriver driver = createDriver();
	public final ChromeDriver driver = new ChromeDriver();
	
	@Test(dataProvider = "zhuanjia",dataProviderClass = DateProvider.class)
	
	public void uploadSource(String username,String password) throws Exception{
		
		Uti.ChromeBrowser_setup(driver,username,password);
		String s1 = "//a[contains(text(),'资源')][contains(@href,'resourceListNew')]";
		driver.findElement(By.xpath(s1)).click();
		
		Thread.sleep(1000);
		
		driver.findElementByPartialLinkText("我上传的").click();
		Thread.sleep(500);
		driver.findElementByLinkText("编辑").click();
		Thread.sleep(1000);
		
		//修改名称
		driver.findElementById("input_name").click();
		String resourseTitle="修改后"+Uti.get_random();		
		driver.findElementById("input_name").clear();
		driver.findElementById("input_name").sendKeys(resourseTitle);
		
		//修改学段、学科
		try{
			new Select(driver.findElementById("sel_sysDictId1")).selectByIndex(2);  
			Thread.sleep(500);
			new Select(driver.findElementById("sel_sysDictId2")).selectByIndex(1);  
			Thread.sleep(500);
		}catch (Exception e){
			System.out.println("无学段、学科");
		}
				
		//修改教材版本
		try{
			new Select(driver.findElementById("sel_sysDictId3")).selectByIndex(1); 
			Thread.sleep(500);
			new Select(driver.findElementById("sel_sysDictId4")).selectByIndex(1);  
			Thread.sleep(500);
			new Select(driver.findElementById("sel_sysDictId5")).selectByIndex(1);  
			Thread.sleep(500);
			new Select(driver.findElementById("sel_sysDictId6")).selectByIndex(1);  
			Thread.sleep(500);
		}catch (Exception e){
			System.out.println("无教材版本");
		}

		//修改知识点
		try{
			new Select(driver.findElementById("sel_sysDictId8")).selectByIndex(1);  
			Thread.sleep(500);
			new Select(driver.findElementById("sel_sysDictId9")).selectByIndex(1); 
			Thread.sleep(500);
		}catch (Exception e){
			System.out.println("无知识点");
		}

		//修改资源
		try{
			new Select(driver.findElementById("sel_sysDictId11")).selectByIndex(2); 
			Thread.sleep(500);
			new Select(driver.findElementById("sel_sysDictId7")).selectByIndex(2);   
			Thread.sleep(500);
		}catch(Exception e){
			System.out.println("无资源");
		}

		driver.findElementById("gx").click();
		
		//判断是否成功修改
		Assert.assertEquals(isSuccess(resourseTitle),true);
        Thread.sleep(1000);
	    driver.findElement(By.id("tab1")).click();	    
	    Thread.sleep(500);
		try {
			  driver.findElement(By.xpath("(//a[contains(text(),'删除')])[1]")).click();
		} catch (Exception e) {
			driver.findElement(By.xpath("(//a[contains(text(),'删除')])[1]")).click();
			// TODO: handle exception
		}
		  
	      driver.findElement(By.xpath("//a[contains(@value,'1')]")).click(); //删除刚刚发的资源
	      Thread.sleep(500);
		  driver.findElement(By.id("tab1")).click();
	      Thread.sleep(1000);
	      Assert.assertEquals(Uti.isTextPresent(driver, resourseTitle), false);//验证删除之后，我发布的资源不再可见
		  driver.quit();
	}

	
	//以加载个人配置的方式实例化Chrome的方法，适用于61及以后版本flash无法上传的情况，但多线程执行时会出现问题
	public static ChromeDriver createDriver(){
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=C:/Users/Administrator/AppData/Local/Google/Chrome/User Data");
		ChromeDriver driver = new ChromeDriver(options);
		return driver;
		
	}
	
	//用于判断资源是否成功修改的方法
	public boolean isSuccess(String text){
		
		try{
			driver.findElementByPartialLinkText(text);
			return true;
		}catch (Exception e){
			return false;
		}
		
	}
	
}
