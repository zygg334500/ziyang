package task;

import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import Interface.TestInfo;

import uti.Uti;

public class Submit_Task implements TestInfo{
	private static final ChromeDriver driver=new ChromeDriver();
  
  @Test(groups = {"task"})
  public void submit_Task() throws Exception {
		
		Uti.ChromeBrowser_setup(driver, "devstudent2", "123123");
	    
	    driver.findElement(By.partialLinkText("作业")).click();
        driver.findElement(By.id("tab3")).click();
        Thread.sleep(2000);

        driver.findElement(By.partialLinkText("新学习的作业3")).click();
        
	    java.util.Set<String> handles1 = driver.getWindowHandles();//获取所有窗口句柄  
	    List<String> it1 = new ArrayList<String>(handles1);
	    driver.switchTo().window(it1.get(2));
        Thread.sleep(1000);
        
        Uti.richText(driver,0,"老师好啊，我发布了作业内容，请查看附件!");
        
        Uti.UploadFile(driver, "C:/Program Files (x86)/Mozilla Firefox/uploadFile.exe","SWFUpload_0");//上传文件
        try {
        	Uti.UploadVedio(driver,"C:/Program Files (x86)/Mozilla Firefox/uploadVideo.exe");//上传视频方法
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
