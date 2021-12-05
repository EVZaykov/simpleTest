import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.IOException;

import static helpers.AddEnv.addEnvVar;

@RunWith(Cucumber.class)
@CucumberOptions(glue = {"Steps"},
        plugin = { "pretty", "html:target/cucumber-html-reports", "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm",
        "json:target/cucumber-html-reports/cucumber.json","rerun:target/failed_scenarios.txt"}, features = "src/test/resources", tags = "@login")
public class RunCucumberTest {
    @AfterClass
    public static void writeExtentReport() throws IOException {
        addEnvVar();
    }

}
