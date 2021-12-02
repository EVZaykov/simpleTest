import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue = {"Steps"},
        plugin = { "pretty", "html:target/cucumber-html-reports", "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm",
        "json:target/cucumber-html-reports/cucumber.json","rerun:target/failed_scenarios.txt"}, features = "src/test/resources", tags = "@inWork")
public class RunCucumberTest {
}
