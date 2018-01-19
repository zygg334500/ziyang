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
   
    Uti.ChromeBrowser_setup( driver, "xmgly", "123123");
    driver.findElement(By.partialLinkText("����")).click();
    driver.findElement(By.linkText("����")).click();
    driver.findElement(By.id("input_title")).clear();
    driver.findElement(By.id("input_title")).sendKeys("���±���");
    driver.switchTo().frame(0);
    driver.findElement(By.className("ke-content")).sendKeys("����������");
    driver.switchTo().defaultContent();    
    Uti.UploadFile(driver, "C:/Program Files (x86)/Mozilla Firefox/uploadFile.exe","SWFUpload_0");//�ϴ��ļ�	    
    Uti.UploadVedio(driver,"C:/Program Files (x86)/Mozilla Firefox/uploadVideo.exe");//�ϴ���Ƶ����  
    Uti.waitForAlertAndCloseAlert(driver);//ʮ����ǿ�Ƶȴ�alert����֣�ÿ����һ�Σ��ڼ����鲻�������׳��쳣     
    driver.findElement(By.className("video_close")).click();//�رմ���    
    driver.findElement(By.linkText("�� ��")).click();
    driver.findElement(By.linkText("�˳�")).click();
    System.out.println("���·����ɹ�");
    driver.quit();
    }

	@Override
	public ChromeDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}
}
