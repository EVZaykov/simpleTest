import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import ru.sbtqa.tag.pagefactory.Tag;


import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(glue = {"ru.sbtqa.tag.stepdefs.en","Steps"},
        plugin = { "pretty", "html:target/cucumber-html-reports", "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm",
        "json:target/cucumber-html-reports/cucumber.json","json:target/cucumber.json"}, features = "src/test/resources", tags = "@qwert1")
public class RunCucumberTest extends Tag {
    @AfterClass
    public static void writeExtentReport() throws IOException {
        //addEnvVar();
    }

}
