package Steps;

import Steps.UISteps.Fofo;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;

public class Hooks {

    private Fofo fofo;
    private WebDriver driver;

    @Step
    @Given("User opens browser {string}")
    public void user_opens_browser(String string) {
        fofo = new Fofo(driver);
        fofo.goTo(string);

    }

    @Step
    @Given("User enter credential {string} {string}")
    public void user_enter_credential(String login, String password){

        fofo.enterUserCredentials(login,password);

    }


    @Before
    public void openUrl() throws MalformedURLException {
        //RestAssured.filters(new AllureRestAssured());
        //open("https://grinfer.com/");
          /*  String host = "localhost";
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
            //open(completeUrl,dc);
            Allure.step(System.getProperty("BROWSER"));
            this.driver = new RemoteWebDriver(new URL(completeUrl), dc); */

            //System.setProperty("webdriver.chrome.driver", "C:\\projects\\DemoCucumber-master\\src\\test\\java\\resources\\other\\chromedriver.exe");
            //this.driver = new ChromeDriver();
        }

    @After
    public void closeDriver(Scenario scenario) {
        System.out.println("-------------------------------- " + driver.getTitle());
        if(scenario.isFailed() && driver.getTitle() == null) {
            Allure.addAttachment("Screenshot of falling step", new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
            return;
        }
        this.driver.quit();
    }
}

