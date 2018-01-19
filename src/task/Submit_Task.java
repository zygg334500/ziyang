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
		
		Uti.ChromeBrowser_setup(driver, "1.44105915053E12", "123123");
	    
	    driver.findElement(By.partialLinkText("��ҵ")).click();
        driver.findElement(By.id("tab3")).click();
        Thread.sleep(2000);

        driver.findElement(By.linkText("��ѧϰ����ҵ3")).click();
        
	    java.util.Set<String> handles1 = driver.getWindowHandles();//��ȡ���д��ھ��  
	    List<String> it1 = new ArrayList<String>(handles1);
	    driver.switchTo().window(it1.get(2));
        Thread.sleep(1000);
        
        driver.switchTo().frame(driver.findElement(By.className("ke-edit-iframe")));
        driver.findElement(By.className("ke-content")).sendKeys("��ʦ�ð����ҷ�������ҵ���ݣ���鿴����!");
        driver.switchTo().defaultContent();
        
        Uti.UploadFile(driver, "C:/Program Files (x86)/Mozilla Firefox/uploadFile.exe","SWFUpload_0");//�ϴ��ļ�
        try {
        	Uti.UploadVedio(driver,"C:/Program Files (x86)/Mozilla Firefox/uploadVideo.exe");//�ϴ���Ƶ����
		} catch (Exception e) {
		}finally{
        Uti.waitForAlertAndCloseAlert(driver);
	    driver.findElement(By.className("video_close")).click();//�رմ���	
	    driver.findElement(By.linkText("�� ��")).click();
	    System.out.println("��ҵ�μӳɹ�");
	    driver.quit();
		}
  }

@Override
public ChromeDriver getDriver() {
	// TODO Auto-generated method stub
	return driver;
}

}
