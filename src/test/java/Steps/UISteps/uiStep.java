package Steps.UISteps;


import helpers.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ValidatableResponse;

import static com.codeborne.selenide.Selenide.open;
import static helpers.RunContext.RUN_CONTEXT;

public class uiStep extends DriverFactory {

    @Given("User opens browser {string}")
    public void delete_repository_with_name(String nameOfRepos) {
            open(nameOfRepos);
    }

    @Given("^I navigate to github\\.com$")
    public void i_navigate_to_github_com() throws Throwable {

        signInPage.getLoginPage();
    }

    @Given("^I enter a \"([^\"]*)\" Username$")
    public void i_enter_a_Username(String userName) throws Throwable {
        signInPage.enterUsername(userName);
    }

    @Given("^I enter a \"([^\"]*)\" Password$")
    public void i_enter_a_Password(String password) throws Throwable {
        signInPage.enterPassword(password);
    }

    @When("^I click on the Sign in button$")
    public void i_click_on_the_Sign_in_button() throws Throwable {
        signInPage.clickOnSignInButton();
    }

    @Then("^I should be take to the fault message$")
    public void i_should_be_take_to_the_fault_message() throws Throwable {
        signInPage.checkErrorMessage();
    }

    @Then("^I should be take to the successful login$")
    public void i_should_be_take_to_the_successful_login() throws Throwable {
        signInPage.checkSuccessfulLogin();
    }
}
