package Backup_Course;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Interface.TestInfo;

import uti.Uti;

public class Join_bCourse  implements TestInfo{
	private static final ChromeDriver driver=new ChromeDriver();
  @Test(groups = {"Backup_Course"})
  public void join_bCourse() throws Exception {
		
		Uti.ChromeBrowser_setup(driver, "1.44105915053E12", "123123");
		
		driver.findElement(By.partialLinkText("����")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[contains(text(),'ר�ҷ����ı���1')])[1]")).click();
		
		driver.switchTo().frame(1);
		driver.findElement(By.className("ke-content")).sendKeys("���ε�������ȥ��΢�����׶����׶�Ȯ��������rewrite");
		driver.switchTo().defaultContent();
		
		Uti.UploadFile(driver, "C:/Program Files (x86)/Mozilla Firefox/uploadFile.exe","SWFUpload_0");
		driver.findElement(By.linkText("����")).click();

	    System.out.println("���βμӳɹ�");
	    driver.quit();
	  
  }

@Override
public ChromeDriver getDriver() {
	// TODO Auto-generated method stub
	return driver;
}
}
