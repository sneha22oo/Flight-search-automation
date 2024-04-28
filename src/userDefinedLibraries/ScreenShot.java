package userDefinedLibraries;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScreenShot {

	public static String filePath="C:\\Users\\2327222\\OneDrive - Cognizant\\Documents\\Java WorkSpace\\2327222_Sneha_IRCTCFlightSearchAutomation\\ScreenShot\\";
    
	public static void screenShotOfResultPage(WebDriver driver,String fileName) {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File trg=new File(filePath+fileName);
		try {
			FileUtils.copyFile(src, trg);
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void screenShotOfResults(WebElement element,String fileName) {
		File src1=((TakesScreenshot)element).getScreenshotAs(OutputType.FILE);
		File trg1=new File(filePath+fileName);
		try {
			FileUtils.copyFile(src1, trg1);
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
