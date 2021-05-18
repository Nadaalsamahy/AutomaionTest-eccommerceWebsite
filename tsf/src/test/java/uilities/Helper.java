package uilities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class Helper {
	// Method to take screenShot when the test case fail

	public static void captureScreenShot(WebDriver driver , String screenshotname) {
		Path des = Paths.get("./ScreenShot",screenshotname+".png");
		try {
			java.nio.file.Files.createDirectories(des.getParent());
			FileOutputStream out = new FileOutputStream(des.toString());
			out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
			//out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Exeption while taking screenshot " +e.getMessage());

			e.printStackTrace();
		}
		
		
		}

}
