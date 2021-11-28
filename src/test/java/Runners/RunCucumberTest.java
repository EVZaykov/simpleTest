package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue = {"Steps"},plugin = {"pretty"}, features = "src/test/resources", tags = "@helloWorld1")
public class RunCucumberTest {
}
