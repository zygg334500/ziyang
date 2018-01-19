package DeleteTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import uti.Uti;
import DateProvider.DateProvider;
import Interface.TestInfo;

public class TongbanxiezuoDeleteTest implements TestInfo {
	  private static final ChromeDriver driver=new ChromeDriver();
	  private String title;
	  private String tongbanxiezuoTitle;
	  @Test(dataProvider = "guanliyuanFilePath",dataProviderClass = DateProvider.class)
public void xiezuo_delete(String username,String password,String filePath,String vedioPath) throws Exception {
		  Uti.ChromeBrowser_setup(driver, username, password);	
		  driver.findElement(By.partialLinkText("同伴协作")).click();
		  driver.findElement(By.linkText("发布")).click();
		  tongbanxiezuoTitle=Uti.get_cooperationName();
		  driver.findElement(By.id("input_title")).sendKeys(tongbanxiezuoTitle);		  
		  driver.findElement(By.name("startTime")).sendKeys(Uti.get_currenttime());
		  
		  driver.findElement(By.name("endTime")).sendKeys(Uti.get_currenttime());
		  driver.findElement(By.xpath("(//*[contains(@type,'radio')])[4]")).click();
		  driver.findElement(By.id("cengji")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.id("dict_tree_con1_1_check")).click();
		  driver.findElement(By.id("dict_tree_con2_1_check")).click();
		  driver.findElement(By.id("selDictRangeSure")).click();
		  Uti.richText(driver,0,"同伴梦一起来表扬");
		  
		  driver.findElement(By.linkText("发布")).click();
		  System.out.println(tongbanxiezuoTitle);
		  Thread.sleep(1000);
		  Assert.assertEquals(true,isTextPresent(tongbanxiezuoTitle));//发布的磨课在我发起的列表下能看见

		  driver.findElement(By.xpath("(//a[contains(text(),'删除')])[1]")).click();
	      driver.findElement(By.xpath("//a[contains(@value,'1')]")).click(); //我发起的磨课，删除刚刚发的磨课
	      driver.navigate().refresh();
	      Thread.sleep(1000);
	      Assert.assertEquals(false,isTextPresent(tongbanxiezuoTitle));
	      System.out.println("同伴协作删除成功");
	      driver.quit();
	  }
	  
	  public boolean checkdata(){
		  if(title.indexOf("未发布状态")!=-1){
			  return true;
			  }
			  else{
			  return false;
			  }
	  }
	  public boolean checkdata2(){
		  if(title.indexOf(tongbanxiezuoTitle)!=-1){
			  return true;
			  }
			  else{
			  return false;
			  }
		  
	  }
	  public boolean isTitlePresent(String what){
		  try {
			  driver.findElement(By.linkText(what));
			  return true;
		} catch (Exception e) {		
			return false;
			// TODO: handle exception
		}  
		
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