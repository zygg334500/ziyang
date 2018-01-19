package listener_takescreenshot_when_fail;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import uti.Uti;

import Interface.TestInfo;



public class ScreenShotOnFailure {

	private final static String SCREEN_SHOT_PATH = "C:/Users/ziyang/workspace/selenium_testproject/test-output/screen-shot";
	private static String SCREEN_SHOT_NAME = null;
   
	public static void takeScreentShot(String className) throws IOException, Exception{
		File screenShotDir = new File(SCREEN_SHOT_PATH);
		if (!screenShotDir.exists()) {
			screenShotDir.mkdirs();
		}
		TestInfo test=(TestInfo)Class.forName(className).newInstance();
		SCREEN_SHOT_NAME =className+ ".jpg";
		FileUtils.copyFile(test.getDriver().getScreenshotAs(OutputType.FILE),
				new File(SCREEN_SHOT_PATH + "/" + SCREEN_SHOT_NAME));
	}

	public static String getScreenShotPath() {
		return SCREEN_SHOT_PATH;
	}

	public static String getScreenShotName() {
		return SCREEN_SHOT_NAME;
	}
}
