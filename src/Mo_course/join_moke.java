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
		
		driver.findElement(By.partialLinkText("磨课")).click();
		driver.findElement(By.id("tab4")).click();		
		driver.findElement(By.xpath("//a[@title='魔克猪1']")).click();
		
		String a= driver.findElement(By.className("cymk_xx")).getText();
		String time = Uti.get_currenttime1();
		System.out.println(time);
		System.out.println("\""+"发起人：层级专家 李远玉 截止时间："+time+"\"");
		if(a.indexOf(time)!=-1){
	    	driver.findElement(By.linkText("参与磨课")).click();
	    	Uti.richText(driver,0,"12345678");
	    	driver.findElement(By.linkText("发布")).click(); 		    
	    }else{
	    driver.findElement(By.linkText("返回")).click();
	    System.out.println("不是想参与的磨课");
	    }
	    System.out.println("磨课参加成功");
	    driver.quit();
  }

@Override
public ChromeDriver getDriver() {
	// TODO Auto-generated method stub
	return driver;
}
}
