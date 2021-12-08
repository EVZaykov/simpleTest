package helpers;

import io.cucumber.core.api.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.SignIn_Page;


import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
	public static WebDriver driver;
	public static SignIn_Page signInPage;

	public WebDriver getDriver() {
		try {
			//if(scenario.getSourceTagNames().contains("@api")) {
				//return;
			//}
			//open("https://grinfer.com/");
			String host = "localhost";
			DesiredCapabilities dc;

			if(System.getenv("BROWSER") != null &&
					System.getenv("BROWSER").equalsIgnoreCase("Firefox")){
				dc = DesiredCapabilities.firefox();
			}else{
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--no-sandbox");
				options.addArguments("--disable-dev-shm-usage");
				dc = DesiredCapabilities.chrome().merge(options);
			}

			if(System.getProperty("HUB_HOST") != null){
				host = System.getProperty("HUB_HOST");
			}
			String completeUrl = "http://" + host + ":4444/wd/hub";
			this.driver = new RemoteWebDriver(new URL(completeUrl), dc);
			//System.setProperty("webdriver.chrome.driver", "C:\\projects\\DemoCucumber-master\\src\\test\\java\\resources\\other\\chromedriver.exe");
			//this.driver = new ChromeDriver();
		} catch (Exception e) {
			System.out.println("Unable to load browser: " + e.getMessage());
		} finally {
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			signInPage = PageFactory.initElements(driver, SignIn_Page.class);
		}
		return driver;
	}
}
