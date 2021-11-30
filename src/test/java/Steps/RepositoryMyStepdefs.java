package Steps;


import impl.RepositoryServiceImpl;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.qameta.allure.Allure;
import io.restassured.response.ValidatableResponse;
import models.Repository;
import org.junit.Assert;
import service.RepositoryService;

import java.util.List;

import static context.RunContext.RUN_CONTEXT;
import static helpers.CheckVariable.check_variable_in_string;
import static org.hamcrest.CoreMatchers.equalTo;

public class RepositoryMyStepdefs extends APIBaseSteps {

    RepositoryService repositoryService = new RepositoryServiceImpl();


    @Given("User gets list of repositories {string} and saves response to var {string}")
    public void get_repositories_request(String url, String varName) {
        List<Repository> repositoryList = repositoryService.getRepositories(url,varName);
    }

    @Given("User creates repository with name {string} and saves response to var {string}")
    public void create_repository_and_save_response_to_var(String url, String varName) {
        ValidatableResponse response = repositoryService.createRepository(url);
        RUN_CONTEXT.put(varName,response);

        //ValidatableResponse createRepository = repositoryService.createRepository(url,varName);
    }

    @Then("User gets response {string} and checks status code ER {string}")
    public void get_response_and_validating_status_code(String varName, String status) {
        ValidatableResponse validatableResponse = RUN_CONTEXT.get(varName,ValidatableResponse.class);
        int actualStatus = validatableResponse.extract().statusCode();
        int expectStatus = Integer.parseInt(status);
        Assert.assertEquals(expectStatus,actualStatus);
    }

    @Given("User deletes repository with name {string} and saves response to var {string}")
    public void delete_repository_with_name(String nameOfRepos,String varName) {
        repositoryService.deleteRepository(nameOfRepos,varName);
    }

    @Given("User gets response {string} and checks value form JsonPath {string} ER {string}")
    public void user_gets_response_and_checks_value_form_json_path_er(String varName, String jsonPath, String er) {
        ValidatableResponse response = RUN_CONTEXT.get(varName,ValidatableResponse.class);
        response.assertThat().body(jsonPath,equalTo(er));
    }

    @Given("User checks all params in response {string}")
    public void user_checks_all_params_in_response(String varName, DataTable dataTable) {
        ValidatableResponse response = RUN_CONTEXT.get(varName,ValidatableResponse.class);
        for (int i = 0 ; i < dataTable.height() ; i++) {
            response.assertThat().body(dataTable.row(i).get(0),equalTo(check_variable_in_string(dataTable.row(i).get(1))));
        }
    }

    @Given("User gets value from JsonPath {string} from response {string} and saves to var {string}")
    public void user_gets_value_from_json_path_from_response_and_saves_to_var(String jsonPath1, String varName, String newVar) {
        ValidatableResponse response = RUN_CONTEXT.get(varName,ValidatableResponse.class);
        Object value = response.extract().body().jsonPath().get(jsonPath1);
        System.out.println("----------------------------------------"+ value);
        RUN_CONTEXT.put(newVar,value);
        System.out.println("----------------------------------------"+ RUN_CONTEXT.get(newVar));
    }


}
