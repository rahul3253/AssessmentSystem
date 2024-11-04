package Assesment.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;

	@BeforeMethod
	@Parameters("browser")
	public void Init(String browser) {
		setupDriver(browser);
		driver.get(Constants.url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}

	public void setupDriver(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			Map prefs = new HashMap();
			prefs.put("profile.default_content_settings.cookies", 1);
			options.setExperimentalOption("prefs", prefs);

			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);

		} else {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
	}
}
