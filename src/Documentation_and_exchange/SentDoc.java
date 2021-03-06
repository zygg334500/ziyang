package Documentation_and_exchange;


import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import Interface.TestInfo;

import uti.Uti;

public class SentDoc implements TestInfo{
	private static final ChromeDriver driver=new ChromeDriver();
	@Test(groups = {"Documentation_and_exchange"})
  public void sent_doc() throws Exception {
   
    Uti.ChromeBrowser_setup( driver, "devguanliyuan", "3edc$RFV");
    driver.findElement(By.partialLinkText("文章")).click();
    driver.findElement(By.linkText("发布")).click();
    driver.findElement(By.id("input_title")).clear();
    driver.findElement(By.id("input_title")).sendKeys("文章标题");
    Uti.richText(driver, 0, "文章内容");
    Uti.UploadFile(driver, "E:/Downloads/uploadFile.exe","SWFUpload_0");//上传文件	    
    Uti.UploadVedio(driver,"E:/Downloads/uploadvedio.exe");//上传视频方法  
    Uti.waitForAlertAndCloseAlert(driver);//十秒内强制等待alert框出现，每秒检查一次，第几秒检查不到，就抛出异常     
    driver.findElement(By.className("video_close")).click();//关闭窗口    
    driver.findElement(By.linkText("发 布")).click();
    driver.findElement(By.linkText("退出")).click();
    System.out.println("文章发布成功");
    driver.quit();
    }

	@Override
	public ChromeDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}
}
