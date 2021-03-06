package NewActivity;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import DateProvider.DateProvider;
import Interface.TestInfo;
import Interface.TitleQueue;

import uti.Uti;

public class JoinActivity implements TestInfo{
	
  private static final ChromeDriver driver=new ChromeDriver();	
  
  @Test(groups = {"Activity"},dataProvider = "xueyuanFilePath",dataProviderClass = DateProvider.class)
  public void studuentakePartActivity(String username,String password,String filePath,String vedioPath)  throws Exception {
	  Uti.ChromeBrowser_setup(driver, username, password);
	  driver.findElement(By.partialLinkText("活动")).click();
	  driver.findElement(By.id("tab1")).click();
	  Thread.sleep(1000);
	  try {
	    	driver.findElement(By.id("msg_close")).click();

		} catch (Exception e) {
			System.out.println("没有弹出框");
			// TODO: handle exception
	  }
		String title=TitleQueue.pop(this.getClass().getName());

		if(null==title){
			driver.findElement(By.xpath("(//a[contains(text(),'参与活动')])[1]")).click();
		}else {
			driver.findElement(By.linkText(title)).click();   
		}

	  Uti.ChangeWindows(driver, 2);
	  Thread.sleep(1000);
      //参与步骤一：资源下载		
      driver.findElement(By.xpath("(//*[contains(@id, 'pl_con_msg')])[1]")).sendKeys("xuexixuexi");
	  driver.findElement(By.cssSelector("#buzhou_div1 > div > form > input.btnbbs")).click();
	  driver.findElement(By.cssSelector("a.downbtn.r")).click();
	  Uti.ChangeWindows(driver, 2);
	  try {
	    	driver.findElement(By.id("msg_close")).click();

		} catch (Exception e) {
			System.out.println("没有弹出框");
			// TODO: handle exception
	  }
	  //参与步骤二：指定提交人
	  driver.findElement(By.cssSelector("#jiadd2 > em")).click();
	  Uti.UploadFile(driver, filePath, "SWFUpload_0");
	  Thread.sleep(1000);
	  //参与步骤三：讨论
	  driver.findElement(By.cssSelector("#jiadd3 > em")).click();
	  driver.findElement(By.xpath("(//*[contains(@id, 'pl_con_msg')])[2]")).sendKeys("xuexixuexi22");
	  driver.findElement(By.cssSelector("#buzhou_div3 > div.bbslist.linexu > form.taolunfrom > input.btnbbs")).click();
	  driver.findElement(By.cssSelector("#jiadd4 > em")).click();
	  driver.findElement(By.xpath("(//a[contains(@class, 'downbtn')])[2]")).click();
      driver.quit();//参与完毕，关闭浏览器
  }
  
  public  boolean isTextPresent(String what) {
	  try{
	  return driver.findElement(By.tagName("body")).getText().contains(what);// 遍历body节点下的所有节点 取其文本值 并判断是否包含文本 what
	  }
	  catch (Exception e){
	  return false;// 没有该文本 则 返回 false
	  }
  }	 
	@Override
	public ChromeDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}
}
