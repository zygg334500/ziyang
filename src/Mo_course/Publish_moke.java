package Mo_course;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import Interface.TestInfo;

import uti.Uti;

public class Publish_moke implements TestInfo{
	private static final ChromeDriver driver=new ChromeDriver();

	@Test(groups = {"Mo_course"})
  public void publish_moke() throws Exception {

		Uti.ChromeBrowser_setup(driver, "suke", "123123");
		
		driver.findElement(By.partialLinkText("ĥ��")).click();
		driver.findElement(By.linkText("����")).click();	
		

		driver.findElement(By.name("startTime")).sendKeys(Uti.get_currenttime());
		driver.findElement(By.name("endTime")).sendKeys(Uti.get_currenttime());
		new Select(driver.findElement(By.id("kindId"))).selectByVisibleText("��ѧ���");
		driver.findElement(By.name("cengji")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("dict_tree_con1_1_check")).click();
		driver.findElement(By.id("dict_tree_con2_1_check")).click();
		driver.findElement(By.linkText("ȷ��")).click();
		driver.findElement(By.id("input_title")).sendKeys("ħ����1");
		
		driver.switchTo().frame(0);
		driver.findElement(By.className("ke-content")).sendKeys("��Ϣ����");
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(1);
		driver.findElement(By.className("ke-content")).sendKeys("ѧϰĿ������");
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(2);
		driver.findElement(By.className("ke-content")).sendKeys("��ѧĿ������");
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(3);
		driver.findElement(By.className("ke-content")).sendKeys("��ѧ��������");
		driver.switchTo().defaultContent();
	  
		driver.switchTo().frame(4);
		driver.findElement(By.className("ke-content")).sendKeys("�����������");
		driver.switchTo().defaultContent();	
		Uti.UploadFile(driver, "C:/Program Files (x86)/Mozilla Firefox/uploadFile.exe","SWFUpload_0");
		driver.findElement(By.linkText("����")).click();
	    System.out.println("ĥ�η����ɹ�");
	    driver.quit();
  }

	@Override
	public ChromeDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}
}
