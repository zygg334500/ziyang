package Mo_course;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Interface.TestInfo;

import uti.Uti;

public class join_moke implements TestInfo{
	private static final ChromeDriver driver=new ChromeDriver();
@Test(groups = {"Mo_course"})
  public void addtomoke() throws Exception {
		Uti.ChromeBrowser_setup(driver, "1.44105915053E12", "123123");
		
		driver.findElement(By.partialLinkText("ĥ��")).click();
		driver.findElement(By.id("tab4")).click();		
		driver.findElement(By.xpath("//a[@title='ħ����1']")).click();
		
		String a= driver.findElement(By.className("cymk_xx")).getText();
		String time = Uti.get_currenttime1();
		System.out.println(time);
		System.out.println("\""+"�����ˣ��㼶ר�� ��Զ�� ��ֹʱ�䣺"+time+"\"");
		if(a.indexOf(time)!=-1){
	    	driver.findElement(By.linkText("����ĥ��")).click();
	    	driver.switchTo().frame(0);
	    	driver.findElement(By.className("ke-content")).sendKeys("12345678");
	    	driver.switchTo().defaultContent();
	    	driver.findElement(By.linkText("����")).click(); 		    
	    }else{
	    driver.findElement(By.linkText("����")).click();
	    System.out.println("����������ĥ��");
	    }
	    System.out.println("ĥ�βμӳɹ�");
	    driver.quit();
  }

@Override
public ChromeDriver getDriver() {
	// TODO Auto-generated method stub
	return driver;
}
}
