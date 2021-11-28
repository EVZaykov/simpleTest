package by.ful.allure;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue = {"src/test/java/by/ful/allure/steps"},plugin = {"pretty"}, features = "src/test/resources", tags = "@helloWorld")
public class RunCucumberTest {
}
