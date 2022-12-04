package dev.alexfossa204.starbank.microservice.controller.impl;

import dev.alexfossa204.starbank.microservice.controller.ApiUserGraphQLController;
import dev.alexfossa204.starbank.microservice.repository.model.ApiUser;
import dev.alexfossa204.starbank.microservice.service.ApiUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ApiUserGraphQLControllerImpl implements ApiUserGraphQLController {

    private final ApiUserService apiUserService;

    @SchemaMapping(typeName = "Query", field = "apiUsersAll")
    @Override
    public List<ApiUser> findAllApiUsersGetRequest() {
        return apiUserService.findAllApiUsers();
    }
}
