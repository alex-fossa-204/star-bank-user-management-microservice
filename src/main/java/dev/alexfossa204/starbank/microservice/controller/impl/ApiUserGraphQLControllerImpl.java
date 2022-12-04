package dev.alexfossa204.starbank.microservice.controller.impl;

import dev.alexfossa204.starbank.microservice.controller.ApiUserGraphQLController;
import dev.alexfossa204.starbank.microservice.repository.ApiUserRepository;
import dev.alexfossa204.starbank.microservice.repository.model.ApiUser;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ApiUserGraphQLControllerImpl implements ApiUserGraphQLController {

    private final ApiUserRepository apiUserRepository;

    @SchemaMapping(typeName = "Query", field = "apiUsersAll")
    @Override
    public List<ApiUser> findAllApiUsersGetRequest() {
        return apiUserRepository.findAll();
    }
}
