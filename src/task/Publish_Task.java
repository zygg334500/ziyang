package task;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Interface.TestInfo;
import Interface.TitleQueue;
import uti.Uti;

public class Publish_Task {
	
	  @Test(groups = {"task"})
    public void publish_Task() throws Exception {
		ChromeDriver driver=new ChromeDriver();
		Uti.ChromeBrowser_setup(driver, "devguanliyuan", "3edc$RFV");
	    driver.findElement(By.partialLinkText("作业")).click();
	    driver.findElement(By.linkText("发布")).click();
	    new Select(driver.findElement(By.id("p_list"))).selectByIndex(2);;//根据顺序2，选择下拉列表中的语文教学计划
  	    String taskTitle=Uti.get_zuoyeName();//生成作业标题
  	    TitleQueue.push(taskTitle,this.getClass().getName(),"task.Submit_Task");//将作业标题放入全局队列，以便制定的类可以接收
	    driver.findElement(By.id("input_title")).sendKeys(taskTitle);
	    Thread.sleep(1000);
        driver.findElement(By.id("endtime")).click();
        Thread.sleep(1000);   
        JavascriptExecutor removeAttribute = (JavascriptExecutor)driver;  
        //remove readonly attribute
        removeAttribute.executeScript("var setDate=document.getElementById(\"endtime\");setDate.removeAttribute('readonly');") ;//通过javaScript移除readonly字段
	    driver.findElement(By.id("endtime")).sendKeys(Uti.get_currenttime());
	    
	    //进入iframe ，添加富文本内容
	    Uti.richText(driver,0,"发布作业的内容文字");
	    
	    //上传文件和视频
	    Uti.UploadFile(driver, "E:/Downloads/uploadFile.exe","SWFUpload_0");//上传文件	    
	    Uti.UploadVedio(driver,"E:/Downloads/uploadvedio.exe");//上传视频方法  
	    Uti.waitForAlertAndCloseAlert(driver);//十秒内强制等待alert框出现，每秒检查一次，第几秒检查不到，就抛出异常     
	    driver.findElement(By.className("video_close")).click();//关闭窗口
	    
	    driver.findElement(By.xpath("(//*[contains(text(),'发 布')])[1]")).click();//这块发布text之间有一个空格的
	    driver.findElement(By.linkText(taskTitle)).click();
	    driver.navigate().refresh();
	    System.out.println("作业发布成功");
	    driver.quit();
  }


}
