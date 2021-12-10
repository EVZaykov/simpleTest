package Steps;


import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;
import java.net.URL;



public class Hooks  {

    public  WebDriver driver;

    @Before
    public void openBrowser(Scenario scenario) throws MalformedURLException {
        if(scenario.getSourceTagNames().contains("@api")) {
            return;
        }
        //open("https://grinfer.com/");
        /*
        String host = "localhost";


        DesiredCapabilities dc;


        if(System.getProperty("BROWSER") != null &&
                System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
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
        this.driver = new RemoteWebDriver(new URL(completeUrl), dc); */

        System.setProperty("webdriver.chrome.driver", "C:\\projects\\DemoCucumber-master\\src\\test\\java\\resources\\other\\chromedriver.exe");
        this.driver = new ChromeDriver();

        }

    @After
    public void closeDriver(Scenario scenario) {


        Allure.addAttachment("Screenshot of falling step", new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
        this.driver.quit();
        if(scenario.getSourceTagNames().contains("@api")) {
            return;
        }
        if(scenario.isFailed()) {
            Allure.addAttachment("Screenshot of falling step", new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
            this.driver.quit();
        }
    }
}

