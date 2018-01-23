package NewActivity;

import java.net.URL;
import java.text.DecimalFormat;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import DateProvider.DateProvider;
import Interface.TestInfo;
import Interface.TitleQueue1;
import uti.Uti;

public class CheckingData{

      @Test(groups = {"task"},dataProvider = "teacherFilePath",dataProviderClass = DateProvider.class)
  public void making(String username,String password,String filePath,String vedioPath) throws Exception {
		   // DesiredCapabilities chromeDesiredcap = DesiredCapabilities.chrome();  
		   // WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeDesiredcap);  		
		    ChromeDriver driver=new ChromeDriver();
		    Uti.ChromeBrowser_setup(driver, username, password);
	    
	    driver.findElement(By.partialLinkText("活动")).click();
	    driver.findElement(By.partialLinkText("内容预览")).click();
	    String content= driver.findElement(By.className("def_pop_msg_nr")).getText();
	    System.out.println(content);
	    driver.findElement(By.className("close")).click();
        driver.findElement(By.xpath("(//a[contains(text(),'提交详情')])[1]")).click();
        Thread.sleep(1000);
	    driver.findElement(By.partialLinkText("内容预览")).click();
	    String content_inner= driver.findElement(By.className("def_pop_msg_nr")).getText();
	    driver.findElement(By.className("close")).click();
	    System.out.println(content_inner);
	    String get_content= TitleQueue1.pop(this.getClass().getName());
	    Assert.assertEquals(content_inner, get_content);                                                                    //验证活动预览的内容与预期相同
	    Assert.assertEquals(content_inner, content);  //验证活动预览的内容与传过来的数据相同
	    String wtjs= driver.findElement(By.xpath("(//span[@class='orange'])[1]")).getText();
	    String wwcs= driver.findElement(By.xpath("(//span[@class='orange'])[2]")).getText();
	    String xpys= driver.findElement(By.xpath("(//span[@class='orange'])[3]")).getText();
	    String ypys= driver.findElement(By.xpath("(//span[@class='orange'])[4]")).getText();
	    driver.findElement(By.linkText("未参加")).click();                                                                     //点击不合格按钮进行筛选	    
	    Thread.sleep(2000);
	    String record1=driver.findElement(By.xpath("//span[contains(text(),'记录')]")).getText();               //根据未参加共有多少记录，得到未参加数量
	    String str2 = record1.replaceAll(" ", "");                                                                                 //去掉字符串中间的空格
	    String wcjs= str2.substring(str2.length()-4,str2.length()-3);                                          //截取字符串的第四位到第三位，取得未参加数量
	    Assert.assertEquals(wtjs, wcjs); 
	    
	    driver.findElement(By.linkText("未完成")).click();                                                                       
	    Thread.sleep(2000);
	    String record2=driver.findElement(By.xpath("//span[contains(text(),'记录')]")).getText();               
	    String str3 = record2.replaceAll(" ", "");                                                                                
	    String wwcsJ= str3.substring(str3.length()-4,str3.length()-3);                                          
	    Assert.assertEquals(wwcsJ, wwcs); 
	    
	    driver.findElement(By.linkText("未批阅")).click();                                                                     	    
	    Thread.sleep(2000);
	    String record3=driver.findElement(By.xpath("//span[contains(text(),'记录')]")).getText();               
	    String str4 = record3.replaceAll(" ", "");                                                                                
	    String wpys= str4.substring(str4.length()-4,str4.length()-3);                                          
	    Assert.assertEquals(xpys, wpys); 
	    
	    driver.findElement(By.linkText("未参加")).click();                                                                         
	    Thread.sleep(2000);
	    String record4=driver.findElement(By.xpath("//span[contains(text(),'记录')]")).getText();               
	    String str5= record4.replaceAll(" ", "");                                                                                 
	    String ypysG= str5.substring(str5.length()-4,str5.length()-3);                                       
	    Assert.assertEquals(ypys, ypysG); 
        driver.findElement(By.linkText("全部提醒")).click();
	    driver.quit();
  }
}
