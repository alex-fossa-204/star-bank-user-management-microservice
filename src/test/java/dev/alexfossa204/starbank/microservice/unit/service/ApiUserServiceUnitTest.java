package dev.alexfossa204.starbank.microservice.unit.service;

import dev.alexfossa204.starbank.microservice.repository.ApiUserRepository;
import dev.alexfossa204.starbank.microservice.repository.model.ApiUser;
import dev.alexfossa204.starbank.microservice.service.exception.impl.ApiUserNotFoundServiceException;
import dev.alexfossa204.starbank.microservice.service.impl.ApiUserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ApiUserServiceUnitTest {

    @InjectMocks
    private ApiUserServiceImpl apiUserService;

    @Mock
    private ApiUserRepository apiUserRepository;

    private static UUID API_USER_UUID_DUMMY;

    private static String API_USER_UUID_STRING_VALUE_DUMMY = "400e4567-e89b-12d3-a456-400614174009";

    private ApiUser API_USER_DUMMY_WHEN_SUCCESS;

    @BeforeEach
    public void beforeEachTest() {
        API_USER_UUID_DUMMY = UUID.fromString(API_USER_UUID_STRING_VALUE_DUMMY);
        API_USER_DUMMY_WHEN_SUCCESS = new ApiUser();
        API_USER_DUMMY_WHEN_SUCCESS.setPublicUuid(API_USER_UUID_DUMMY);
    }

    @Test
    public void when_find_all_api_users_successful() {
        when(apiUserRepository.findAll()).thenReturn(new ArrayList<>());
        List<ApiUser> apiUserListActual = apiUserService.findAllApiUsers();
        List<ApiUser> apiUserListExpected= new ArrayList<>();
        assertThat(apiUserListActual).isEqualTo(apiUserListExpected);
    }

    @Test
    public void when_find_api_user_by_uuid_successful() throws ApiUserNotFoundServiceException {
        when(apiUserRepository.findApiUserByPublicUuid(API_USER_UUID_DUMMY)).thenReturn(Optional.of(API_USER_DUMMY_WHEN_SUCCESS));
        ApiUser apiUserActual = apiUserService.findApiUserByUuid(API_USER_UUID_DUMMY);
        assertThat(apiUserActual).isEqualTo(API_USER_DUMMY_WHEN_SUCCESS);
    }

    @Test
    public void when_find_api_user_by_uuid_unsuccessful_trows_ApiUserNotFoundServiceException() throws ApiUserNotFoundServiceException {
        when(apiUserRepository.findApiUserByPublicUuid(API_USER_UUID_DUMMY))
                .thenReturn(Optional.empty());
        assertThatThrownBy(() -> apiUserService.findApiUserByUuid(API_USER_UUID_DUMMY))
                .isInstanceOf(ApiUserNotFoundServiceException.class);
    }

}
