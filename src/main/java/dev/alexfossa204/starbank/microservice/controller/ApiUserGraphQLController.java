package dev.alexfossa204.starbank.microservice.controller;

import dev.alexfossa204.starbank.microservice.repository.model.ApiUser;
import org.springframework.graphql.data.method.annotation.SchemaMapping;

import java.util.List;

public interface ApiUserGraphQLController {

    @SchemaMapping(typeName = "Query", field = "apiUsersAll")
    List<ApiUser> findAllApiUsersGetRequest();

}
