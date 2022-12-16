package dev.alexfossa204.starbank.microservice.service;

import dev.alexfossa204.starbank.microservice.repository.model.ApiUser;
import dev.alexfossa204.starbank.microservice.service.exception.impl.ApiUserNotFoundServiceException;

import java.util.List;
import java.util.UUID;

public interface ApiUserService {

    List<ApiUser> findAllApiUsers();

    ApiUser findApiUserByUuid(UUID apiUserUuid) throws ApiUserNotFoundServiceException;

}
