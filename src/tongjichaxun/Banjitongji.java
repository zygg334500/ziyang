package tongjichaxun;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import uti.Uti;
import DateProvider.DateProvider;

public class Banjitongji {private static final ChromeDriver driver=new ChromeDriver();

@Test(groups = {"Activity"},dataProvider = "guanliyuanFilePath",dataProviderClass = DateProvider.class)
public void publish_activity(String username,String password,String filePath,String vedioPath) throws Exception {	
	Uti.ChromeBrowser_setup(driver, username, password);  

	driver.findElement(By.partialLinkText("统计查询")).click();
	Thread.sleep(1000);
	driver.findElement(By.partialLinkText("班级统计")).click();
	Thread.sleep(1000);
	driver.findElement(By.className("tjcx_seach")).click();
	Thread.sleep(1000);
	driver.findElement(By.partialLinkText("导出")).click();
	Thread.sleep(1000);
	try {
		driver.findElement(By.partialLinkText("点击这里直接下载")).click();

	} catch (Exception e) {
		// TODO: handle exception
	}
	Thread.sleep(1000);
}

}
