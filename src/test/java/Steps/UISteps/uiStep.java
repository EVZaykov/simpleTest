package Steps.UISteps;

import io.cucumber.java.en.Given;
import io.restassured.response.ValidatableResponse;

import static com.codeborne.selenide.Selenide.open;
import static helpers.RunContext.RUN_CONTEXT;

public class uiStep {

    @Given("User opens browser {string}")
    public void delete_repository_with_name(String nameOfRepos) {
            open(nameOfRepos);
    }
}
