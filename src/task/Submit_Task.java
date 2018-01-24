package task;

import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import Interface.TestInfo;
import Interface.TitleQueue;
import uti.Uti;

public class Submit_Task implements TestInfo{
	private static final ChromeDriver driver=new ChromeDriver();
  
  @Test(groups = {"task"})
  public void submit_Task() throws Exception {
		
		Uti.ChromeBrowser_setup(driver, "devstudent3", "123123");
	    
	    driver.findElement(By.partialLinkText("作业")).click();
        driver.findElement(By.id("tab3")).click();
        Thread.sleep(2000);
        String zuoyetitle =TitleQueue.pop(this.getClass().getName());
        driver.findElement(By.partialLinkText(zuoyetitle)).click();
        
        Uti.ChangeWindows(driver, 2);
        
        Uti.richText(driver,0,"老师好啊，我发布了作业内容，请查看附件!");//老师发布作业上传了视频，可能会多一个iframe
        
        Uti.richText(driver,1,"老师好啊，我发布了作业内容，请查看附件!");

        
	    java.util.Set<String> handles1 = driver.getWindowHandles();//获取所有窗口句柄  
	    List<String> it1 = new ArrayList<String>(handles1);
	    driver.switchTo().window(it1.get(2));
        Thread.sleep(1000);
        
        Uti.richText(driver,0,"老师好啊，我发布了作业内容，请查看附件!");
        

        Uti.UploadFile(driver, "E:/Downloads/uploadFile.exe","SWFUpload_0");//上传文件
        try {
        	Uti.UploadVedio(driver,"E:/Downloads/uploadVedio.exe");//上传视频方法
		} catch (Exception e) {
		}finally{
        Uti.waitForAlertAndCloseAlert(driver);
	    driver.findElement(By.className("video_close")).click();//关闭窗口	
	    driver.findElement(By.linkText("提 交")).click();
	    System.out.println("作业参加成功");
	    driver.quit();
		}
  }

@Override
public ChromeDriver getDriver() {
	// TODO Auto-generated method stub
	return driver;
}

}
