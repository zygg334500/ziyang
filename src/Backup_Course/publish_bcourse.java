package Backup_Course;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import Interface.TestInfo;

import uti.Uti;

public class publish_bcourse implements TestInfo{
	
	private static final ChromeDriver driver=new ChromeDriver();
  @Test(groups = {"Backup_Course"})
  public void read_beker() throws Exception {
		
		Uti.ChromeBrowser_setup(driver, "suke", "123123");
		
		driver.findElement(By.partialLinkText("����")).click();
		driver.findElement(By.linkText("����")).click();
		
		driver.findElement(By.id("teachingplanTitle")).sendKeys("ר�ҷ����ı���1");
		driver.findElement(By.id("endtime")).sendKeys("2018-03-02");
		
		driver.switchTo().frame(0);
		driver.findElement(By.className("ke-content")).sendKeys("��������");
		driver.switchTo().defaultContent();
		
		Uti.UploadFile(driver, "C:/Program Files (x86)/Mozilla Firefox/uploadFile.exe","SWFUpload_0");
		
		try {
			driver.findElement(By.linkText("����")).click();
		} catch (Exception e) {
			System.out.println("����û�з����ɹ�");
			// TODO: handle exception
		}
	    System.out.println("���η����ɹ�");
	    driver.quit();
		
//		driver.findElement(By.id("tab1")).click();
//	    Thread.sleep(1000);
//		driver.findElement(By.linkText("ר�ҷ����ı���1")).click();//���˲�����֤��ȫ������������ڣ�������γ�

  }

@Override
public ChromeDriver getDriver() {
	// TODO Auto-generated method stub
	return driver;
}
}
