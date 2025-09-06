package utils;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	private static ExtentReports extent;
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	@BeforeAll
	public static void beforeAll() {
		extent = ExtentReportManager.extentReports();
	}

	
	@Before
	public void setUp(Scenario scenario) {
		
	 
		
		ExtentTest scenarioTest = extent.createTest(scenario.getName());
		test.set(scenarioTest);
		
		WebDriverManager.chromedriver().driverVersion("LATEST").setup();
		WebDriver webDriver = new ChromeDriver();
		driver.set(webDriver);

		driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get().manage().window().maximize();
	}

	@After
	public void tearDown(Scenario scenario) {
		try {
			if (scenario.isFailed()) {
				if (driver.get() != null)
				{
					String screenshotPath = ScreenshotUtil.captureScreenshot(driver.get(), scenario.getName());
					test.get().fail("Scenario failed, please find the screenshot below",
							MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				} 
				else 
				{
					test.get().fail("Driver was null, could not capture screenshot");
				}
			} 
			else if (scenario.getStatus() == Status.PASSED) 
			{
				
				test.get().pass("Scenario passed");
			} 
			else if (scenario.getStatus() == Status.SKIPPED) 
			{
				test.get().skip("Scenario skippeed");
			}

		} 
		catch (IOException e) 
		{
			test.get().fail("Error capturing screenshot: " + e.getMessage());
		} 
		finally 
		{
			WebDriver webDriver = driver.get();
			if (webDriver != null) 
			{
				try 
				{
					webDriver.quit();
				} catch (Exception e) {
					test.get().fail("Error closing driver: " + e.getMessage());
				} finally {
					driver.remove();
				}
			}
		}
	}

	@AfterAll
	public static void afterAll() 
	{
		if (extent != null) 
		{
			extent.flush();
		}
	}

	public static WebDriver getDriver() 
	{
		return driver.get();
	}
}
