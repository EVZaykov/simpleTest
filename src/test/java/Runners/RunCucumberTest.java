package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue = {"Steps"},
        plugin = { "pretty","io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm"}, features = "src/test/resources", tags = "@inWork")
public class RunCucumberTest {
}
