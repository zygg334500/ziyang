package task;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import DateProvider.DateProvider;
import Interface.TestInfo;
import Interface.TitleQueue1;
import uti.Uti;
//检查老师自己发布的作业内容是否正确，包括附件和视频检查
public class CheckOverviewofTask implements TestInfo{
	private static final ChromeDriver driver=new ChromeDriver();
      @Test(groups = {"task"},dataProvider = "teacherFilePath",dataProviderClass = DateProvider.class)
  public void making(String username,String password,String filePath,String vedioPath) throws Exception {
    	  Uti.ChromeBrowser_setup(driver, username, password);
	    
	    driver.findElement(By.partialLinkText("作业")).click();
        driver.findElement(By.partialLinkText("内容预览")).click();
        String Actualcontextdriver=driver.findElement(By.className("def_pop_msg_nr")).getText();
        System.out.println(Actualcontextdriver);
        String expectcontexdriver=TitleQueue1.pop(this.getClass().getName());
        Assert.assertEquals(Actualcontextdriver, expectcontexdriver);//验证在全部列表下点击内容预览的内容与发布时填写的内容一致
        driver.findElement(By.linkText("关闭")).click();
        driver.findElement(By.xpath("(//a[contains(text(),'去批阅')])[1]")).click();
        driver.findElement(By.partialLinkText("内容预览")).click();
        Assert.assertEquals(Actualcontextdriver, expectcontexdriver);//验证在批阅详情页下点击内容预览的内容与发布时填写的内容一致
        driver.findElement(By.linkText("关闭")).click();
        driver.findElement(By.partialLinkText("查看视频")).click();//点击查看视频
        driver.findElement(By.linkText("关闭")).click();
        driver.findElement(By.linkText("下载")).click();
        driver.findElement(By.linkText("全部提醒")).click();
        driver.quit();
  }

@Override
public ChromeDriver getDriver() {
	// TODO Auto-generated method stub
	return driver;
}
}
