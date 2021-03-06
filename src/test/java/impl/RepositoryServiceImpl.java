package impl;

import Steps.APISteps.APIBaseSteps;
import config.TestConfig;
import groovy.util.logging.Slf4j;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import pojos.gitHub.CreateRepository;
import pojos.gitHub.Repository;
import java.util.ArrayList;
import java.util.List;

import static utils.RunContext.RUN_CONTEXT;
import static utils.CheckVariable.check_variable_in_string;
import static io.restassured.RestAssured.given;

@Slf4j
public class RepositoryServiceImpl extends APIBaseSteps {

    TestConfig testConfig = new TestConfig();
    private static final String OWNER_REPOSITORY = "EVZaykov/";
    private static final String GET_LIST_OF_REPOS = "user/repos";

    private final RequestSpecification REQ_SPEC =
            new RequestSpecBuilder().setBaseUri(testConfig.getURL())
                    .addHeader("Authorization","Bearer " + System.getenv("SECRET_TOKEN"))  //
                    .addHeader("accept","application/vnd.github.v3+json")
                    .setContentType("application/json;charset=UTF-8")
                    .build();

    public ValidatableResponse createRepository(String nameOfRepos) {
        CreateRepository createRepository =
                CreateRepository.builder()
                .name(nameOfRepos)
                .description("just simple repos")
                .homepage("none")
                .build();

        ValidatableResponse rp = given()
                .filter(new AllureRestAssured())
                .spec(REQ_SPEC)
                .basePath(GET_LIST_OF_REPOS)
                .body(createRepository)
                .when().post().then();
        return rp;
    }

    public ValidatableResponse deleteRepository(String nameOfRepos,String varName) {

        String basePath = "repos/" + testConfig.getOwnerOfRepository() + check_variable_in_string(nameOfRepos);

        ValidatableResponse validatableResponse = given()
                .filter(new AllureRestAssured())
                .spec(REQ_SPEC)
                .basePath(basePath)
                .delete().then();
        return validatableResponse;
    }

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
            //log.error("Repositories request exception: " + Arrays.toString(e.getStackTrace()));
        }
        return repositories;
    }
}
