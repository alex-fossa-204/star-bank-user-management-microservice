package dev.alexfossa204.starbank.microservice.service;

import dev.alexfossa204.starbank.microservice.repository.model.ApiUser;

import java.util.List;

public interface ApiUserService {

    List<ApiUser> findAllApiUsers();

}
