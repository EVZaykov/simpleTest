package service;

import io.restassured.response.ValidatableResponse;
import models.Repository;

import java.util.List;

public interface RepositoryService {

    ValidatableResponse createRepository(String url);

    //ValidatableResponse deleteRepository(String nameOfRepos, String varName);

    ValidatableResponse deleteRepository(String nameOfRepos, String varName);

    List<Repository> getRepositories(String url, String varName);

    //ValidatableResponse deleteRepository(Object nameOfRepos, String varName);

}
