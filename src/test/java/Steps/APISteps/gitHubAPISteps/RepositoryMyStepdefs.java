package Steps.APISteps.gitHubAPISteps;

import Steps.APISteps.APIBaseSteps;
import impl.RepositoryServiceImpl;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.qameta.allure.Allure;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import pojos.gitHub.Repository;
import java.util.List;

import static helpers.RunContext.RUN_CONTEXT;
import static helpers.AssertionsWithMessage.assertWithMessage;
import static helpers.CheckVariable.check_variable_in_string;
import static org.hamcrest.CoreMatchers.equalTo;

public class RepositoryMyStepdefs extends APIBaseSteps {

    RepositoryServiceImpl repositoryService = new RepositoryServiceImpl();

    @Given("User creates repository with name {string} and saves response to var {string}")
    public void create_repository_and_save_response_to_var(String nameOfRepositiry, String varName) {
        ValidatableResponse rp = repositoryService.createRepository(nameOfRepositiry);
        RUN_CONTEXT.put(varName,rp);
    }

    @Given("User gets list of repositories {string} and saves response to var {string}")
    public void get_repositories_request(String url, String varName) {
        List<Repository> repositoryList = repositoryService.getRepositories(url,varName);
    }

    @Given("User deletes repository with name {string} and saves response to var {string}")
    public void delete_repository_with_name(String nameOfRepos,String varName) {
        ValidatableResponse rp = repositoryService.deleteRepository(nameOfRepos,varName);
        RUN_CONTEXT.put(varName,rp);
    }

    @Given("User gets value from JsonPath {string} from response {string} and saves to var {string}")
    public void user_gets_value_from_json_path_from_response_and_saves_to_var(String jsonPath1, String varName, String newVar) {
        ValidatableResponse response = RUN_CONTEXT.get(varName,ValidatableResponse.class);
        Object value = response.extract().body().jsonPath().get(jsonPath1);
        RUN_CONTEXT.put(newVar,value);
        Allure.step(value + "was saved in " + newVar);
    }

    @Given("User compare two variables {string} {string}")
    public void user_compare_two_variables(String var1, String var2) {
        Object var = check_variable_in_string(var1);
        Object varSec = check_variable_in_string(var2);
        assertWithMessage(var,varSec);
        //String response = RUN_CONTEXT.get(var1,String.class);
    }

    @Then("User gets response {string} and checks status code ER {string}")
    public void get_response_and_validating_status_code(String varName, String status) {
        ValidatableResponse validatableResponse = RUN_CONTEXT.get(varName,ValidatableResponse.class);
        int actualStatus = validatableResponse.extract().statusCode();
        int expectStatus = Integer.parseInt(status);
        assertWithMessage(expectStatus,actualStatus);

    }

    @Given("User gets response {string} and checks value form JsonPath {string} ER {string}")
    public void user_gets_response_and_checks_value_form_json_path_er(String varName, String jsonPath, String er) {
        ValidatableResponse response = RUN_CONTEXT.get(varName,ValidatableResponse.class);
        response.assertThat().body(jsonPath,equalTo(er));
    }

    @Given("User checks all params in response {string}")
    public void user_checks_all_params_in_response(String varName, DataTable dataTable) {
        ValidatableResponse response = RUN_CONTEXT.get(varName,ValidatableResponse.class);
        JsonPath JSString = rawToJson(response);
        for (int i = 0 ; i < dataTable.height() ; i++) {
            //response.assertThat().body(JSString.get(dataTable.row(i).get(0)),equalTo(check_variable_in_string(dataTable.row(i).get(1))));
            assertWithMessage(JSString.get(dataTable.row(i).get(0)),equalTo(check_variable_in_string(dataTable.row(i).get(1))));
            System.out.println(response.extract().body().jsonPath());
            System.out.println(check_variable_in_string(dataTable.row(i).get(1)));
            assertWithMessage(dataTable.row(i).get(0),check_variable_in_string(dataTable.row(i).get(1)));
        }
    }
}
