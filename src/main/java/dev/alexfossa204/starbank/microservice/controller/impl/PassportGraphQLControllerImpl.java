package dev.alexfossa204.starbank.microservice.controller.impl;

import dev.alexfossa204.starbank.microservice.controller.PassportGraphQLController;
import dev.alexfossa204.starbank.microservice.repository.model.Passport;
import dev.alexfossa204.starbank.microservice.service.PassportService;
import dev.alexfossa204.starbank.microservice.service.exception.impl.PassportNotFoundException;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PassportGraphQLControllerImpl implements PassportGraphQLController {

    private final PassportService passportService;

    public PassportGraphQLControllerImpl(PassportService passportService) {
        this.passportService = passportService;
    }

    @Override
    public Passport findPassportBySerialNumberGetRequest(@Argument String serialNumber) throws PassportNotFoundException {
        return passportService.findPassportBySerialNumber(serialNumber);
    }


    @Override
    public List<Passport> findPassportsByLastNameGetRequest(@Argument String lastname) {
        return passportService.findPassportsByLastName(lastname);
    }

    @Override
    public List<Passport> findAllPassports() {
        return passportService.findAllPassports();
    }


}