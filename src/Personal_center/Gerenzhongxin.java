
package Personal_center;

import java.net.URL;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import DateProvider.DateProvider;
import Interface.TestInfo;




import uti.Uti;

public class Gerenzhongxin{
	private static final ChromeDriver driver=new ChromeDriver();

@Test(dataProvider = "xueyuan",dataProviderClass = DateProvider.class)
public   void laoshu17(String username,String password) throws Exception{
    //WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeDesiredcap);           Uti.ChromeBrowser_setup(driver, username, password);
	Uti.ChromeBrowser_setup(driver, username, password);		
     
	Uti.ChangeWindows(driver, 1);//切换第二个标签页，标签页从0开始计数
	     Thread.sleep(3000);
	     driver.findElement(By.xpath("//a[contains(text(),'修改资料')]")).click();
	     Thread.sleep(2000);
	     Uti.ChangeWindows(driver, 2);//切换第二个标签页，标签页从0开始计数
	     
	     
	     //基本资料
	    driver.findElement(By.xpath("(//input[contains( @name,'_fm.m._0.r')])[1]")).sendKeys("中国");//真实姓名
		driver.findElement(By.xpath("//input[@value='2' and @type='radio']")).click();//性别
		 driver.findElement(By.xpath("(//input[contains( @name,'_fm.m._0.r')])[2]")).sendKeys("中国");//民族
		 driver.findElement(By.id("sfzhm")).clear();
		 driver.findElement(By.id("sfzhm")).sendKeys(""+Uti.get_randomContainsThreeMath()+Uti.get_randomContainsThreeMath()+Uti.get_randomContainsThreeMath()+Uti.get_randomContainsThreeMath()+Uti.get_randomContainsThreeMath()+Uti.get_randomContainsThreeMath());//身份证
		//用js去掉日期框的只读属性，再把日期填进去
	     JavascriptExecutor removeAttribute = (JavascriptExecutor) driver;
			// remove readonly attribute
			removeAttribute.executeScript("var setDate=document.getElementById(\"birthday\");setDate.removeAttribute('readonly');");// 通过javaScript移除readonly字段
			driver.findElement(By.id("birthday")).sendKeys("2018-3-30");
			 driver.findElement(By.name("_fm.m._0.t")).clear();
			 driver.findElement(By.name("_fm.m._0.t")).sendKeys("010-12345678");
			 driver.findElement(By.name("_fm.m._0.p")).clear();
			 driver.findElement(By.name("_fm.m._0.p")).sendKeys("14766565544");
			 new Select(driver.findElement(By.id("teachingAge_sel"))).selectByVisibleText("2");
		
			 new Select(driver.findElement(By.id("scStage_sel"))).selectByVisibleText("初中");
		     Thread.sleep(2000);
			 new Select(driver.findElement(By.id("special_sel"))).selectByVisibleText("化学");
			 new Select(driver.findElement(By.className("area_select"))).selectByVisibleText("广东");
			 Thread.sleep(2000);
			 new Select( driver.findElement(By.xpath("(//select[contains(@class,'area_select')])[2]"))).selectByVisibleText("广州");
			 Thread.sleep(2000);
			 new Select( driver.findElement(By.xpath("(//select[contains(@class,'area_select')])[3]"))).selectByVisibleText("天河区");
			 driver.findElement(By.name("_fm.m._0.ad")).clear();
			 driver.findElement(By.name("_fm.m._0.ad")).sendKeys("中兴大厦");
			 driver.findElement(By.name("_fm.m._0.po")).sendKeys("000000");
			 driver.findElement(By.name("_fm.m._0.q")).sendKeys("000000");
			 driver.findElement(By.name("_fm.m._0.n")).sendKeys("建国大业，明天开播");
			 new Select(driver.findElement(By.id("political"))).selectByVisibleText("群众");
			 driver.findElement(By.name("_fm.m._0.te")).sendKeys("si123");
			 Thread.sleep(2000);

			 driver.findElement(By.linkText("保 存")).click();
			 //driver.navigate().refresh();
			 //Thread.sleep(1000);
		     try {
			 driver.findElement(By.linkText("关闭")).click();
		     } catch (Exception e) {
			// TODO: handle exception
		     }
		    //其他资料
		     Thread.sleep(5000);
		
		       driver.findElement(By.linkText("其他资料")).click();
		       //用js去掉日期框的只读属性，再把日期填进去
		       JavascriptExecutor removeAttribute2 = (JavascriptExecutor) driver;
				// remove readonly attribute
				removeAttribute.executeScript("var setDate=document.getElementById(\"goSchoolTime\");setDate.removeAttribute('readonly');");// 通过javaScript移除readonly字段
				driver.findElement(By.id("goSchoolTime")).clear();
				driver.findElement(By.id("goSchoolTime")).sendKeys("2014-03-30");
				removeAttribute.executeScript("var setDate=document.getElementById(\"leaveSchoolTime\");setDate.removeAttribute('readonly');");
				driver.findElement(By.id("leaveSchoolTime")).clear();
				driver.findElement(By.id("leaveSchoolTime")).sendKeys("2018-03-30");
				 new Select(driver.findElement(By.name("_fm.o._0.edu_"))).selectByVisibleText("博士");
				 driver.findElement(By.name("_fm.o._0.edu_s")).sendKeys("哲学史");
				 removeAttribute.executeScript("var setDate=document.getElementById(\"workStart_Time\");setDate.removeAttribute('readonly');");
				 driver.findElement(By.id("workStart_Time")).clear();
				 driver.findElement(By.id("workStart_Time")).sendKeys("2018-03-30");
				driver.findElement(By.name("_fm.o._0.wor")).sendKeys("老师");
				driver.findElement(By.name("_fm.o._0.work")).sendKeys("教授");	
				new Select(driver.findElement(By.name("_fm.o._0.work_"))).selectByVisibleText("一级");	
				driver.findElement(By.linkText("保 存")).click();	
				 Thread.sleep(3000);
	 	        Alert alt = driver.switchTo().alert();
	 	        alt.accept();
	 	  	   
	 	  	   //个人头像
	 	  	   Thread.sleep(5000);	
	 	     
	 	       driver.findElement(By.partialLinkText("个人头像")).click();
	 	      driver.findElement(By.id("face_file")).sendKeys("C:/Users/Public/Pictures/Sample Pictures/css.jpg");
	 	    Thread.sleep(7000);
	 	     Actions action = new Actions(driver); 
	 	     //获取滑动滑块的标签元素
	 	    WebElement source = driver.findElement(By.xpath("(//div[@class='jcrop-tracker'])[2]"));
	 	     action.clickAndHold(source).moveByOffset((int)(Math.random()*200)+80, 0);
	 	    Thread.sleep(2000);
	 	    	//拖动完释放鼠标
	 	     //action.moveToElement(source).release();
	 	    Action actions = action.build();
	 	    actions.perform();
	 	    driver.findElement(By.linkText("保存")).click();	 	       
	 	     //修改密码	
	 	  	 Thread.sleep(5000);	
	 	     driver.findElement(By.partialLinkText("修改密码")).click();
	 	     driver.findElement(By.name("_fm.p._0.o")).sendKeys(password);
	 	     String passwordRandom= password+Uti.get_random()+"a";
	 	     driver.findElement(By.id("mypwdNew")).sendKeys(passwordRandom); 
	 	     driver.findElement(By.id("mypwdNewCopy")).sendKeys(passwordRandom); 
	 	     driver.findElement(By.partialLinkText("保 存")).click();
	 	     Alert alt2 = driver.switchTo().alert();
 	         alt2.accept();
 	         
 	         //消息中心
	         Thread.sleep(5000);	
	         driver.findElement(By.xpath("//a[text()='消息']")).click();
	         Thread.sleep(2000);	
	        try {
				driver.findElement(By.linkText("回复")).click();
				//进入iframe ，添加富文本内容
				driver.switchTo().frame(0);
				driver.findElement(By.className("ke-content")).sendKeys("发送消息");
				driver.switchTo().defaultContent();//跳出富文本
				driver.findElement(By.linkText("发送")).click();
				
			} catch (Exception e) {
				// TODO: handle exception
			} 


                     //发消息
	        Thread.sleep(5000);	
	         driver.findElement(By.xpath("//a[text()='消息']")).click();
	         driver.findElement(By.xpath("//a[text()='发短消息']")).click();  
	 	       driver.findElement(By.linkText("同步好友")).click();
	         driver.findElement(By.id("recievername")).sendKeys("内网");  
	         Thread.sleep(3000);
	         new Select( driver.findElement(By.xpath("(//select[contains(@class,'select_ch')])[1]"))).selectByIndex(0);
	         // 进入iframe ，添加富文本内容
				driver.switchTo().frame(0);
				driver.findElement(By.className("ke-content")).sendKeys("发送消息");
				driver.switchTo().defaultContent();//跳出富文本
	 	       driver.findElement(By.linkText("发送")).click();	 	       
	 	       
	 	       //好友
	 	      driver.findElement(By.xpath("//a[text()='好友']")).click();
	 	     
	 	    try {
	 	    	driver.findElement(By.linkText("好友申请")).click();
	 	    	 Thread.sleep(3000);
	 	    	driver.findElement(By.linkText("同意")).click();
				
			} catch (Exception e) {
				// TODO: handle exception
			
				
			}
	 	    //加好友
	 	      driver.findElement(By.linkText("好友管理")).click(); 
	 	     Thread.sleep(3000);
	 	     driver.findElement(By.id("searchFrends")).sendKeys("张三");  
	         Thread.sleep(3000);
	         driver.findElement(By.className("ui-corner-all")).click();
	         driver.findElement(By.linkText("加为好友")).click(); 
	         Thread.sleep(3000);
	         Alert alt3 = driver.switchTo().alert();
 	         alt3.accept(); 
 	        

           //加关注
	     driver.findElement(By.xpath("//a[text()='好友']")).click();    
	     driver.findElement(By.linkText("我的关注")).click(); 
 	     Thread.sleep(3000);
 	     driver.findElement(By.id("searchFrends")).sendKeys("张三");  
         Thread.sleep(3000);
         driver.findElement(By.className("ui-corner-all")).click();
         driver.findElement(By.linkText("加为关注")).click(); 
         Thread.sleep(3000);
         Alert alt4 = driver.switchTo().alert();
	      alt4.accept(); 
 	             
	}

}
