package task;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Interface.TestInfo;

import uti.Uti;

public class Publish_Task implements TestInfo{
	private static final ChromeDriver driver=new ChromeDriver();
	  @Test(groups = {"task"})
    public void publish_Task() throws Exception {
		
		Uti.ChromeBrowser_setup(driver, "xmgly", "123123");
		
	    driver.findElement(By.partialLinkText("��ҵ")).click();
	    driver.findElement(By.linkText("����")).click();
	    new Select(driver.findElement(By.id("p_list"))).selectByVisibleText("���Ľ�ѧ�ƻ�");//ѡ�������б��е����Ľ�ѧ�ƻ�
        driver.findElement(By.id("input_title")).sendKeys("��ѧϰ����ҵ3");
	    Thread.sleep(1000);
        driver.findElement(By.id("endtime")).click();
        Thread.sleep(1000);   
        JavascriptExecutor removeAttribute = (JavascriptExecutor)driver;  
        //remove readonly attribute
        removeAttribute.executeScript("var setDate=document.getElementById(\"endtime\");setDate.removeAttribute('readonly');") ;//ͨ��javaScript�Ƴ�readonly�ֶ�
	    driver.findElement(By.id("endtime")).sendKeys(Uti.get_currenttime());
	    
	    //����iframe ����Ӹ��ı�����
	    driver.switchTo().frame(0);
	    driver.findElement(By.className("ke-content")).sendKeys("������ҵ����������");
	    driver.switchTo().defaultContent();//����������ҳ����
	    
	    //�ϴ��ļ�����Ƶ
	    Uti.UploadFile(driver, "C:/Program Files (x86)/Mozilla Firefox/uploadFile.exe","SWFUpload_0");//�ϴ��ļ�	    
	    Uti.UploadVedio(driver,"C:/Program Files (x86)/Mozilla Firefox/uploadVideo.exe");//�ϴ���Ƶ����  
	    Uti.waitForAlertAndCloseAlert(driver);//ʮ����ǿ�Ƶȴ�alert����֣�ÿ����һ�Σ��ڼ����鲻�������׳��쳣     
	    driver.findElement(By.className("video_close")).click();//�رմ���
	    
	    driver.findElement(By.xpath("(//*[contains(text(),'�� ��')])[1]")).click();//��鷢��text֮����һ���ո��
	    driver.findElement(By.linkText("��ѧϰ����ҵ3")).click();
	    driver.navigate().refresh();
	    System.out.println("��ҵ�����ɹ�");
	    driver.quit();
  }

@Override
public ChromeDriver getDriver() {
	// TODO Auto-generated method stub
	return driver;
}
}
