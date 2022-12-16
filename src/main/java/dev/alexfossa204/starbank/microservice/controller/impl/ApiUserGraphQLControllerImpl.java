package dev.alexfossa204.starbank.microservice.controller.impl;

import dev.alexfossa204.starbank.microservice.controller.ApiUserGraphQLController;
import dev.alexfossa204.starbank.microservice.repository.model.ApiUser;
import dev.alexfossa204.starbank.microservice.service.ApiUserService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ApiUserGraphQLControllerImpl implements ApiUserGraphQLController {

    private final ApiUserService apiUserService;

    public ApiUserGraphQLControllerImpl(ApiUserService apiUserService) {
        this.apiUserService = apiUserService;
    }

    @Override
    public List<ApiUser> findAllApiUsersGetRequest() {
        return apiUserService.findAllApiUsers();
    }
}
