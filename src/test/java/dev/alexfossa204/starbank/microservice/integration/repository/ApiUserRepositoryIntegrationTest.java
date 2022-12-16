package dev.alexfossa204.starbank.microservice.integration.repository;

import dev.alexfossa204.starbank.microservice.integration.repository.database.StarBankPostgresExtension;
import dev.alexfossa204.starbank.microservice.repository.ApiUserRepository;
import dev.alexfossa204.starbank.microservice.repository.model.ApiUser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(StarBankPostgresExtension.class)
@SpringBootTest
public class ApiUserRepositoryIntegrationTest {

    @Autowired
    private ApiUserRepository apiUserRepository;

    private static  final String API_USER_PUBLIC_UUID_DUMMY = "123e4567-e89b-12d3-a456-426614174000";

    @Test
    public void testFindAllApiUsers() {
        List<ApiUser> users = apiUserRepository.findAll();
        assertThat(users).isNotNull();
    }

    @Test
    public void testFindApiUserByUUID() {
        UUID uuid = UUID.fromString(API_USER_PUBLIC_UUID_DUMMY);
        Optional<ApiUser> apiUserOptional = apiUserRepository.findApiUserByPublicUuid(uuid);
        assertThat(apiUserOptional.get().getPublicUuid()).isEqualTo(UUID.fromString(API_USER_PUBLIC_UUID_DUMMY));
    }

}
