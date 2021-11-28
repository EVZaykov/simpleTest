package impl;

import Steps.APIBaseSteps;
import config.TestConfig;
import io.restassured.response.ValidatableResponse;
import lombok.extern.log4j.Log4j2;
import models.Repository;
import service.RepositoryService;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static context.RunContext.RUN_CONTEXT;
import static helpers.CheckVariable.check_variable_in_string;
import static io.restassured.RestAssured.given;

@Log4j2
public class RepositoryServiceImpl extends APIBaseSteps implements RepositoryService {


    TestConfig testConfig = new TestConfig();
    private static final String GET_LIST_OF_REPOS = "user/repos";


    @Override
    public ValidatableResponse createRepository(String nameOfRepos) {
        String URL = testConfig.getURL() + GET_LIST_OF_REPOS;

        ValidatableResponse response = postRequest("{\"name\":\"" + nameOfRepos + "\"}",URL);
        //ValidatableResponse response = given().log().all().header("Authorization","Bearer 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")
        //        .header("Content-Type","application/json").body("{\"name\":\""+ nameOfRepos + randomNumber() +"\"}")
        //        .post(URL).then()
         //       .log().all();

        return response;
    }



    @Override
    public ValidatableResponse deleteRepository(String nameOfRepos,String varName) {

        String URL = testConfig.getURL() + "repos/" + testConfig.getOwnerOfRepository() + check_variable_in_string(nameOfRepos);

        ValidatableResponse validatableResponse = given().log().all()
                .header("Authorization","Bearer " + testConfig.getToken())
                .header("Content-Type","application/json")
                .delete(URL).then()
                .log().all();
        RUN_CONTEXT.put(varName,validatableResponse);
        return validatableResponse;
    }


    @Override
    public List<Repository> getRepositories(String url, String varName) {
        String URL = testConfig.getURL() + url;
        List<Repository> repositories = new ArrayList<>();

        ValidatableResponse validatableResponse = given().log().all().header("Authorization","Bearer " + testConfig.getToken()).header("Content-Type","application/json")
                .get(URL).then()
                .log().all();

        RUN_CONTEXT.put(varName,validatableResponse);

        try {
            repositories = validatableResponse.extract().jsonPath().getList(".", Repository.class);
        } catch (Exception e) {
            log.error("Repositories request exception: " + Arrays.toString(e.getStackTrace()));
        }
        return repositories;

    }

}
