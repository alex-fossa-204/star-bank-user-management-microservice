package dev.alexfossa204.starbank.microservice.repository;

import dev.alexfossa204.starbank.microservice.repository.model.ApiUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class RepositoryTest {

    @Autowired
    private ApiUserRepository apiUserRepository;

    @Test
    public void testFindAllApiUsers() {
        List<ApiUser> users = apiUserRepository.findAll();
        users.forEach(System.out::println);
    }

    @Test
    public void testFindApiUserByUUID() {
        Optional<ApiUser> apiUserOptional = apiUserRepository.findApiUserByPublicUuid(UUID.fromString("123e4567-e89b-12d3-a456-426614174000"));
        //ApiUser apiUserOptional = apiUserRepository.findApiUserByPublicUuid(UUID.fromString("123e4567-e89b-12d3-a456-426614174000"));
        //System.out.println(apiUserOptional.isPresent());
        System.out.println(apiUserOptional.get());
    }

}
