package dev.alexfossa204.starbank.microservice.controller.impl;

import dev.alexfossa204.starbank.microservice.controller.PassportGraphQLController;
import dev.alexfossa204.starbank.microservice.repository.model.Passport;
import dev.alexfossa204.starbank.microservice.service.PassportService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class PassportGraphQLControllerImpl implements PassportGraphQLController {

    private final PassportService passportService;

    @SchemaMapping(typeName = "Query", field = "passportBySerialNumber")
    @Override
    public Passport findPassportBySerialNumberGetRequest(@Argument String serialNumber) {
        return passportService.findPassportBySerialNumber(serialNumber);
    }

    @SchemaMapping(typeName = "Query", field = "passportsByLastName")
    @Override
    public List<Passport> findPassportsByLastNameGetRequest(@Argument String lastname) {
        return passportService.findPassportsByLastName(lastname);
    }


}