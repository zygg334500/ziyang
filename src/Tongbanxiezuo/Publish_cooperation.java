package Tongbanxiezuo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import uti.Uti;

import DateProvider.DateProvider;
import Interface.TestInfo;
import Interface.TitleQueue;


public class Publish_cooperation implements TestInfo {


	private static final ChromeDriver driver=new ChromeDriver();
	  @Test(groups = {"Cooperation"},dataProvider = "teacherKill",dataProviderClass = DateProvider.class)
	  public void publish_cooperation(String username,String password,String filePath,String vedioPath,String plist,String clist) throws Exception {
		  Uti.ChromeBrowser_setup(driver, username, password);	
		  driver.findElement(By.partialLinkText("同伴协作")).click();
		  driver.findElement(By.linkText("发布")).click();
		  String title=getCoopertionName();
		  TitleQueue.push(title,this.getClass().getName(),"Tongbanxiezuo.Join_cooperation");
		  driver.findElement(By.id("input_title")).sendKeys(title);
		  
		  driver.findElement(By.name("startTime")).sendKeys(Uti.get_currenttime());
		  
		  driver.findElement(By.name("endTime")).sendKeys(Uti.get_currenttime());
		  driver.findElement(By.xpath("(//*[contains(@type,'radio')])[4]")).click();
		  driver.findElement(By.id("cengji")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.id("dict_tree_con1_1_check")).click();
		  driver.findElement(By.id("dict_tree_con2_1_check")).click();
		  driver.findElement(By.id("selDictRangeSure")).click();
		  driver.switchTo().frame(0);
		  driver.findElement(By.tagName("body")).sendKeys("同伴梦一起来表扬");
		  driver.switchTo().parentFrame();
		  driver.findElement(By.linkText("添加主题")).click();
		  
		  driver.findElement(By.id("input_title")).sendKeys("同伴协作主题标题");
		  driver.switchTo().frame(0);
		  driver.findElement(By.tagName("body")).sendKeys("主题内容");
		  driver.switchTo().parentFrame();
		  driver.findElement(By.linkText("添加研修步骤")).click();
		  
		  //添加步骤
		  driver.findElement(By.linkText("1")).click();
		  driver.findElement(By.id("stepName1")).sendKeys("步骤一标题");
		  driver.findElement(By.id("stepContent1")).sendKeys("步骤的部分内容啊手动阀手动阀士大夫我亲耳");
		  driver.findElement(By.linkText("选择工具")).click();
		  driver.findElement(By.id("a1")).click();
		  
		  driver.findElement(By.className("add")).click();//点击可以包括这整个css下的所有子超链接
		  driver.findElement(By.id("stepName2")).sendKeys("步骤二标题");
		  driver.findElement(By.id("stepContent2")).sendKeys("步骤的部分内容啊手动阀手动阀士大夫我亲耳");
		  driver.findElement(By.linkText("选择工具")).click();
		  driver.findElement(By.id("a2")).click();
		  
		  driver.findElement(By.className("add")).click();
		  driver.findElement(By.id("stepName3")).sendKeys("步骤三标题");
		  driver.findElement(By.id("stepContent3")).sendKeys("步骤的部分内容啊手动阀手动阀士大夫我亲耳");
		  driver.findElement(By.linkText("选择工具")).click();
		  driver.findElement(By.id("a3")).click();
		  Uti.UploadFile(driver, filePath, "SWFUpload_2");
		  Thread.sleep(3000);
		  
		  driver.findElement(By.className("add")).click();
		  driver.findElement(By.id("stepName4")).sendKeys("步骤四标题");
		  driver.findElement(By.id("stepContent4")).sendKeys("步骤的部分内容啊手动阀手动阀士大夫我亲耳");
		  driver.findElement(By.linkText("选择工具")).click();
		  driver.findElement(By.id("a4")).click();
		  
		  driver.findElement(By.className("add")).click();
		  driver.findElement(By.id("stepName5")).sendKeys("步骤五标题");
		  driver.findElement(By.id("stepContent5")).sendKeys("步骤的部分内容啊手动阀手动阀士大夫我亲耳");
		  driver.findElement(By.linkText("选择工具")).click();
		  driver.findElement(By.id("a5")).click();
		  driver.findElement(By.id("zhengfang5")).sendKeys("正方辩题");
		  driver.findElement(By.id("fanfang5")).sendKeys("正方辩题");
		  
		  driver.findElement(By.className("add")).click();
		  driver.findElement(By.id("stepName6")).sendKeys("步骤六标题");
		  driver.findElement(By.id("stepContent6")).sendKeys("步骤的部分内容啊手动阀手动阀士大夫我亲耳");
		  driver.findElement(By.linkText("选择工具")).click();
		  driver.findElement(By.id("a6")).click();
		  
		  
		  try {
			  Uti.UploadVedio(driver, vedioPath);
			  Uti.waitForAlertAndCloseAlert(driver);
		} catch (Exception e) {
			// TODO: handle exception
			Thread.sleep(2000);
			 Uti.waitForAlertAndCloseAlert(driver);
		}
		  
		  driver.findElement(By.className("video_close")).click();
		  
		  driver.findElement(By.className("add")).click();
		  driver.findElement(By.id("stepName7")).sendKeys("步骤七标题");
		  driver.findElement(By.id("stepContent7")).sendKeys("步骤的部分内容啊手动阀手动阀士大夫我亲耳");
		  driver.findElement(By.linkText("选择工具")).click();
		  driver.findElement(By.id("a7")).click();
		  
		  new Select(driver.findElement(By.id("p_list"))).selectByVisibleText(plist);
		  new WebDriverWait(driver, 4).until(ExpectedConditions.presenceOfElementLocated(By.id( "c_list" )));
		  Thread.sleep(2000);
		  driver.findElement(By.id("c_list")).click();
		  Thread.sleep(4000);
		  new Select(driver.findElement(By.id("c_list"))).selectByVisibleText(clist);
		  driver.findElement(By.linkText("确认")).click();
		  Thread.sleep(1000);
		  
		  driver.findElement(By.linkText("保存草稿")).click();
		  driver.findElement(By.linkText("预览")).click();
		  try {
			  Uti.ChangeWindows(driver, 2);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("超出数组界限");
		}
		  
		  
		  for(int i=1;i<8;i++){
			  String number="jiadd"+i;
			  //System.out.println(number);
			  driver.findElement(By.id(number)).click();
		  }
		  
		  driver.close();
		  Uti.ChangeWindows(driver, 1);
		  driver.findElement(By.linkText("发布"));
		  //By.xpath("(//a[contains(text(),'去学习')])[1]")
		  driver.findElement(By.partialLinkText("同伴协作")).click();
		  driver.findElement(By.xpath("(//a[contains(text(),'编辑')])[1]")).click();
		  try {
			  driver.findElement(By.xpath("(//*[contains(text(),'发布')])[1]")).click();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("第一次没点到");
			driver.findElement(By.xpath("(//a[contains(text(),'发布')])[1]")).click();
		}
		  
		  //driver.findElement(By.linkText("发布")).click();
		  System.out.println("同伴协作发布成功");
		  driver.quit();
	  }
	  
	@Override
	public ChromeDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}
	
	public String getCoopertionName() throws Exception{
		final String coopertionName=Uti.get_cooperationName();
		return coopertionName;
		
	}

}
