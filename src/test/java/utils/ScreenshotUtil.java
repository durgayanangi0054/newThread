package utils;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
    public static String captureScreenshot(WebDriver webDriver, String testCaseName) throws IOException {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String timestamp = now.format(formatter);

        String path = System.getProperty("user.dir") + "\\Test_Reports\\screenshot\\" + testCaseName + "_" + timestamp + ".png";
        TakesScreenshot ts = (TakesScreenshot) webDriver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(path);
        FileUtils.copyFile(source, target);
        return path;
    }
}