package dev.alexfossa204.starbank.microservice.controller;

import dev.alexfossa204.starbank.microservice.repository.model.ApiUser;
import reactor.core.publisher.Flux;

import java.util.List;

public interface ApiUserGraphQLController {

    List<ApiUser> findAllApiUsersGetRequest();

}
