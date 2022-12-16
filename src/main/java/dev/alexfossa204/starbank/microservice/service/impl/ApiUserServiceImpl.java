package dev.alexfossa204.starbank.microservice.service.impl;

import dev.alexfossa204.starbank.microservice.repository.ApiUserRepository;
import dev.alexfossa204.starbank.microservice.repository.model.ApiUser;
import dev.alexfossa204.starbank.microservice.service.ApiUserService;
import dev.alexfossa204.starbank.microservice.service.exception.impl.ApiUserNotFoundServiceException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ApiUserServiceImpl implements ApiUserService {

    private final ApiUserRepository apiUserRepository;

    public ApiUserServiceImpl(ApiUserRepository apiUserRepository) {
        this.apiUserRepository = apiUserRepository;
    }

    @Override
    public List<ApiUser> findAllApiUsers() {
        return apiUserRepository.findAll();
    }

    @Override
    public ApiUser findApiUserByUuid(UUID apiUserUuid) throws ApiUserNotFoundServiceException {
        Optional<ApiUser> apiUserOptional = apiUserRepository.findApiUserByPublicUuid(apiUserUuid);
        if (apiUserOptional.isEmpty()) {
            throw new ApiUserNotFoundServiceException(String.format("There is no any ApiUser with such UUID = %s", apiUserUuid));
        }
        return apiUserOptional.get();
    }

}
