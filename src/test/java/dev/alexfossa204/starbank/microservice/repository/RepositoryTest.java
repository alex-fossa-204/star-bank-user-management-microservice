package dev.alexfossa204.starbank.microservice.repository;

import dev.alexfossa204.starbank.microservice.repository.model.ApiUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class RepositoryTest {

    @Autowired
    private ApiUserRepository apiUserRepository;

    @Test
    public void testFindAllApiUsers() {
        List<ApiUser> users = apiUserRepository.findAll();
        users.forEach(System.out::println);
    }

}
