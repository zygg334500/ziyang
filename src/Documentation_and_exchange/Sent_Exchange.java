package Documentation_and_exchange;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Interface.TestInfo;

import uti.Uti;

public class Sent_Exchange implements TestInfo{
	private static final ChromeDriver driver=new ChromeDriver();
  @Test(groups = {"Documentation_and_exchange"})
  public void sent_exchange() throws Exception {
	    
	    Uti.ChromeBrowser_setup( driver, "xmgly", "123123");
	    driver.findElement(By.partialLinkText("����")).click();
	    driver.findElement(By.linkText("����")).click();
	    driver.findElement(By.id("input_title")).clear();
	    driver.findElement(By.id("input_title")).sendKeys("��������");
	    driver.switchTo().frame(0);
	    driver.findElement(By.className("ke-content")).sendKeys("����������");
	    driver.switchTo().defaultContent();    
	    Uti.UploadFile(driver, "C:/Program Files (x86)/Mozilla Firefox/uploadFile.exe","SWFUpload_0");//�ϴ��ļ�	    	
	    driver.findElement(By.linkText("�� ��")).click();
	    driver.findElement(By.linkText("�˳�")).click();
	    System.out.println("���������ɹ�");
	    driver.quit();
  }

@Override
public ChromeDriver getDriver() {
	// TODO Auto-generated method stub
	return driver;
}
}
