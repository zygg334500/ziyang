package AllexitActivity;


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

public class  Jitibeike_teacher{


  @Test(dataProvider = "teacherKill",dataProviderClass = DateProvider.class)
  public  void publish_activity(String username,String password,String filePath,String vedioPath,String plist,String clist) throws Exception {	
	 
	    DesiredCapabilities chromeDesiredcap = DesiredCapabilities.chrome();  
	    WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeDesiredcap);  		Uti.ChromeBrowser_setup(driver, username, password); 
	  
	driver.findElement(By.partialLinkText("活动")).click();//原来是用xpath或者是用linkText，都不如这个好，这个可变性比较好
    driver.findElement(By.linkText("发布")).click();
    driver.findElement(By.className("jtbk")).click();
    driver.findElement(By.id("activityName")).clear();
    driver.findElement(By.id("activityName")).clear();
    String activityName= Uti.get_activityName();
    TitleQueue.push(activityName,this.getClass().getName(),"Activity.To_joinActivity");
    System.out.println(activityName);
    driver.findElement(By.id("activityName")).sendKeys(activityName);
    Uti.resource(driver);
    driver.findElement(By.id("startTime")).click();
    driver.findElement(By.id("startTime")).clear();
    driver.findElement(By.id("startTime")).sendKeys(Uti.get_currenttime());
    driver.findElement(By.id("endtime")).click();
    driver.findElement(By.id("endtime")).clear();
    driver.findElement(By.id("endtime")).sendKeys(Uti.get_currenttime());
    driver.findElement(By.id("endtime")).click();
    driver.findElement(By.linkText("保存到下一步")).click();
    driver.findElement(By.linkText("编辑")).click();
    driver.findElement(By.id("name")).clear();
    driver.findElement(By.id("name")).sendKeys("不是开玩笑");
    driver.findElement(By.linkText("选择工具")).click();
    driver.findElement(By.id("a3")).click();
    
    
    
    Thread.sleep(1000);
    driver.findElement(By.id("SWFUpload_0")).click();
    driver.findElement(By.id("SWFUpload_0")).click();
    driver.findElement(By.id("SWFUpload_0")).click();
    Runtime.getRuntime().exec("C:/Users/Administrator/Downloads/uploadFile.exe");
    Thread.sleep(6000);//上传文件   
    driver.findElement(By.linkText("保存")).click();
    driver.findElement(By.linkText("发布")).click();
    //集体备课
	driver.findElement(By.partialLinkText("活动")).click();//原来是用xpath或者是用linkText，都不如这个好，这个可变性比较好
    driver.findElement(By.linkText("发布")).click();
    driver.findElement(By.className("tkyg")).click();
    driver.findElement(By.id("activityName")).clear();
    driver.findElement(By.id("activityName")).clear();
    String activityName2= Uti.get_activityName();
    TitleQueue.push(activityName2,this.getClass().getName(),"Activity.To_joinActivity");
    System.out.println(activityName);
    driver.findElement(By.id("activityName")).sendKeys(activityName);
    driver.findElement(By.id("startTime")).click();
    driver.findElement(By.id("startTime")).clear();
    driver.findElement(By.id("startTime")).sendKeys(Uti.get_currenttime());
    driver.findElement(By.id("endtime")).click();
    driver.findElement(By.id("endtime")).clear();
    driver.findElement(By.id("endtime")).sendKeys(Uti.get_currenttime());
    driver.findElement(By.id("endtime")).click();
    driver.findElement(By.linkText("保存到下一步")).click();
    driver.findElement(By.linkText("编辑")).click();
    driver.findElement(By.id("name")).clear();
    driver.findElement(By.id("name")).sendKeys("不是开玩笑");
    driver.findElement(By.linkText("选择工具")).click();
    driver.findElement(By.id("a3")).click();

    Thread.sleep(1000);
    driver.findElement(By.id("SWFUpload_0")).click();
    driver.findElement(By.id("SWFUpload_0")).click();
    driver.findElement(By.id("SWFUpload_0")).click();
    Runtime.getRuntime().exec("C:/Users/Administrator/Downloads/uploadFile.exe");
    Thread.sleep(6000);//上传文件   
    driver.findElement(By.linkText("保存")).click();
    driver.findElement(By.linkText("发布")).click();
    //同课异构//
	driver.findElement(By.partialLinkText("活动")).click();//原来是用xpath或者是用linkText，都不如这个好，这个可变性比较好
    driver.findElement(By.linkText("发布")).click();
    driver.findElement(By.className("mkhd")).click();
    driver.findElement(By.id("activityName")).clear();
    driver.findElement(By.id("activityName")).clear();
    String activityName3= Uti.get_activityName();
    TitleQueue.push(activityName3,this.getClass().getName(),"Activity.To_joinActivity");
    System.out.println(activityName);
    driver.findElement(By.id("activityName")).sendKeys(activityName);
    driver.findElement(By.id("startTime")).click();
    driver.findElement(By.id("startTime")).clear();
    driver.findElement(By.id("startTime")).sendKeys(Uti.get_currenttime());
    driver.findElement(By.id("endtime")).click();
    driver.findElement(By.id("endtime")).clear();
    driver.findElement(By.id("endtime")).sendKeys(Uti.get_currenttime());
    driver.findElement(By.id("endtime")).click();
    driver.findElement(By.linkText("保存到下一步")).click();
    driver.findElement(By.linkText("编辑")).click();
    driver.findElement(By.id("name")).clear();
    driver.findElement(By.id("name")).sendKeys("不是开玩笑");
    driver.findElement(By.linkText("选择工具")).click();
    driver.findElement(By.id("a3")).click();
    
    Thread.sleep(1000);
    driver.findElement(By.id("SWFUpload_0")).click();
    driver.findElement(By.id("SWFUpload_0")).click();
    driver.findElement(By.id("SWFUpload_0")).click();
    Runtime.getRuntime().exec("C:/Users/Administrator/Downloads/uploadFile.exe");
    Thread.sleep(6000);//上传文件   
    driver.findElement(By.linkText("保存")).click();
    
    
    driver.findElement(By.xpath("(//a[contains(text(),'编辑')])[2]")).click();
    driver.findElement(By.id("name")).clear();
    driver.findElement(By.id("name")).sendKeys("不是开玩笑");
    driver.findElement(By.linkText("选择工具")).click();
    driver.findElement(By.id("a3")).click();

    
    
    Thread.sleep(1000);
    driver.findElement(By.id("SWFUpload_0")).click();
    driver.findElement(By.id("SWFUpload_0")).click();
    driver.findElement(By.id("SWFUpload_0")).click();
    Runtime.getRuntime().exec("C:/Users/Administrator/Downloads/uploadFile.exe");
    Thread.sleep(6000);//上传文件   
    driver.findElement(By.linkText("保存")).click();
    driver.findElement(By.linkText("发布")).click();
  
    //磨课活动//
	driver.findElement(By.partialLinkText("活动")).click();//原来是用xpath或者是用linkText，都不如这个好，这个可变性比较好
    driver.findElement(By.linkText("发布")).click();
    driver.findElement(By.className("gkyk")).click();
    driver.findElement(By.id("activityName")).clear();
    driver.findElement(By.id("activityName")).clear();
    String activityName4= Uti.get_activityName();
    TitleQueue.push(activityName4,this.getClass().getName(),"Activity.To_joinActivity");
    System.out.println(activityName);
    driver.findElement(By.id("activityName")).sendKeys(activityName);
    driver.findElement(By.id("startTime")).click();
    driver.findElement(By.id("startTime")).clear();
    driver.findElement(By.id("startTime")).sendKeys(Uti.get_currenttime());
    driver.findElement(By.id("endtime")).click();
    driver.findElement(By.id("endtime")).clear();
    driver.findElement(By.id("endtime")).sendKeys(Uti.get_currenttime());
    driver.findElement(By.id("endtime")).click();
    driver.findElement(By.linkText("保存到下一步")).click();
    driver.findElement(By.linkText("编辑")).click();
    driver.findElement(By.id("name")).clear();
    driver.findElement(By.id("name")).sendKeys("不是开玩笑");
    driver.findElement(By.linkText("选择工具")).click();
    driver.findElement(By.id("a3")).click();
    
    
    
    Thread.sleep(1000);
    driver.findElement(By.id("SWFUpload_0")).click();
    driver.findElement(By.id("SWFUpload_0")).click();
    driver.findElement(By.id("SWFUpload_0")).click();
    Runtime.getRuntime().exec("C:/Users/Administrator/Downloads/uploadFile.exe");
    Thread.sleep(6000);//上传文件   
    driver.findElement(By.linkText("保存")).click();
    
    
    driver.findElement(By.xpath("(//a[contains(text(),'编辑')])[5]")).click();
    driver.findElement(By.id("name")).clear();
    driver.findElement(By.id("name")).sendKeys("不是开玩笑");
    driver.findElement(By.linkText("选择工具")).click();
    driver.findElement(By.id("a3")).click();
        
    Thread.sleep(1000);
    driver.findElement(By.id("SWFUpload_0")).click();
    driver.findElement(By.id("SWFUpload_0")).click();
    driver.findElement(By.id("SWFUpload_0")).click();
    Runtime.getRuntime().exec("C:/Users/Administrator/Downloads/uploadFile.exe");
    Thread.sleep(6000);//上传文件   
    driver.findElement(By.linkText("保存")).click();
    driver.findElement(By.linkText("发布")).click();
  
    //观课议课//
	driver.findElement(By.partialLinkText("活动")).click();//原来是用xpath或者是用linkText，都不如这个好，这个可变性比较好
    driver.findElement(By.linkText("发布")).click();
    driver.findElement(By.className("zjjz")).click();
    driver.findElement(By.id("activityName")).clear();
    driver.findElement(By.id("activityName")).clear();
    String activityName5= Uti.get_activityName();
    TitleQueue.push(activityName5,this.getClass().getName(),"Activity.To_joinActivity");
    System.out.println(activityName);
    driver.findElement(By.id("activityName")).sendKeys(activityName);
    driver.findElement(By.id("startTime")).click();
    driver.findElement(By.id("startTime")).clear();
    driver.findElement(By.id("startTime")).sendKeys(Uti.get_currenttime());
    driver.findElement(By.id("endtime")).click();
    driver.findElement(By.id("endtime")).clear();
    driver.findElement(By.id("endtime")).sendKeys(Uti.get_currenttime());
    driver.findElement(By.id("endtime")).click();
    driver.findElement(By.linkText("保存到下一步")).click();
    driver.findElement(By.linkText("编辑")).click();
    driver.findElement(By.id("name")).clear();
    driver.findElement(By.id("name")).sendKeys("不是开玩笑");
    driver.findElement(By.linkText("选择工具")).click();
    driver.findElement(By.id("a3")).click();
    
    
    
    Thread.sleep(1000);
    driver.findElement(By.id("SWFUpload_0")).click();
    driver.findElement(By.id("SWFUpload_0")).click();
    driver.findElement(By.id("SWFUpload_0")).click();
    Runtime.getRuntime().exec("C:/Users/Administrator/Downloads/uploadFile.exe");
    Thread.sleep(6000);//上传文件   
    driver.findElement(By.linkText("保存")).click();
    driver.findElement(By.linkText("发布")).click();
  
    //专家讲座//
//	driver.findElement(By.partialLinkText("活动")).click();//原来是用xpath或者是用linkText，都不如这个好，这个可变性比较好
//    driver.findElement(By.linkText("发布")).click();
//    driver.findElement(By.className("jtgk")).click();
//    driver.findElement(By.id("activityName")).clear();
//    driver.findElement(By.id("activityName")).clear();
//    String activityName6= Uti.get_activityName();
//    TitleQueue.push(activityName6,this.getClass().getName(),"Activity.To_joinActivity");
//    System.out.println(activityName);
//    driver.findElement(By.id("activityName")).sendKeys(activityName);
//    driver.findElement(By.id("startTime")).click();
//    driver.findElement(By.id("startTime")).clear();
//    driver.findElement(By.id("startTime")).sendKeys(Uti.get_currenttime());
//    driver.findElement(By.id("endtime")).click();
//    driver.findElement(By.id("endtime")).clear();
//    driver.findElement(By.id("endtime")).sendKeys(Uti.get_currenttime());
//    driver.findElement(By.id("endtime")).click();
//    driver.findElement(By.linkText("保存到下一步")).click();
//    driver.findElement(By.linkText("编辑")).click();
//    driver.findElement(By.id("name")).clear();
//    driver.findElement(By.id("name")).sendKeys("不是开玩笑");
//    driver.findElement(By.linkText("选择工具")).click();
//    driver.findElement(By.id("a7")).click();
//    new Select(driver.findElement(By.id("p_list"))).selectByVisibleText(plist);
//    new WebDriverWait(driver, 4).until(ExpectedConditions.presenceOfElementLocated(By.id( "c_list" )));
//    //driver.findElement(By.id("c_list")).click();
//    new Select(driver.findElement(By.id("c_list"))).selectByVisibleText(clist);
//    Thread.sleep(2000);
//    driver.findElement(By.linkText("确认")).click();
//    Thread.sleep(2000);
//    driver.findElement(By.linkText("保存")).click();
//    driver.findElement(By.xpath("(//a[contains(text(),'编辑')])[5]")).click();
//    driver.findElement(By.id("name")).clear();
//    driver.findElement(By.id("name")).sendKeys("不是开玩笑");
//    driver.findElement(By.linkText("选择工具")).click();
//    driver.findElement(By.id("a7")).click();
//    new Select(driver.findElement(By.id("p_list"))).selectByVisibleText(plist);
//    new WebDriverWait(driver, 4).until(ExpectedConditions.presenceOfElementLocated(By.id("c_list")));
//    //driver.findElement(By.id("c_list")).click();
//    new Select(driver.findElement(By.id("c_list"))).selectByVisibleText(clist);
//    Thread.sleep(2000);
//    driver.findElement(By.linkText("确认")).click();
//    Thread.sleep(2000);
//    driver.findElement(By.linkText("保存")).click();
//    driver.findElement(By.linkText("发布")).click();
//    Thread.sleep(1000);
//    System.out.println("发布成功");
    //集体观课//
  driver.findElement(By.partialLinkText("活动")).click();//原来是用xpath或者是用linkText，都不如这个好，这个可变性比较好
  driver.findElement(By.linkText("发布")).click();
  driver.findElement(By.className("yd")).click();
  driver.findElement(By.id("activityName")).clear();
  driver.findElement(By.id("activityName")).clear();
  String activityName7= Uti.get_activityName();
  TitleQueue.push(activityName7,this.getClass().getName(),"Activity.To_joinActivity");
  System.out.println(activityName);
  driver.findElement(By.id("activityName")).sendKeys(activityName);
  driver.findElement(By.id("startTime")).click();
  driver.findElement(By.id("startTime")).clear();
  driver.findElement(By.id("startTime")).sendKeys(Uti.get_currenttime());
  driver.findElement(By.id("endtime")).click();
  driver.findElement(By.id("endtime")).clear();
  driver.findElement(By.id("endtime")).sendKeys(Uti.get_currenttime());
  driver.findElement(By.id("endtime")).click();
  driver.findElement(By.linkText("保存到下一步")).click();
  driver.findElement(By.linkText("编辑")).click();
  driver.findElement(By.id("name")).clear();
  driver.findElement(By.id("name")).sendKeys("不是开玩笑");
  driver.findElement(By.linkText("选择工具")).click();
  driver.findElement(By.id("a3")).click();
  Thread.sleep(1000);
  driver.findElement(By.id("SWFUpload_0")).click();
  driver.findElement(By.id("SWFUpload_0")).click();
  driver.findElement(By.id("SWFUpload_0")).click();
  Runtime.getRuntime().exec("C:/Users/Administrator/Downloads/uploadFile.exe");
  Thread.sleep(6000);//上传文件   
  driver.findElement(By.linkText("保存")).click();
  driver.findElement(By.linkText("发布")).click();
  //研读//
  driver.quit();
  }
}