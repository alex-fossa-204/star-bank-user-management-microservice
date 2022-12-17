package dev.alexfossa204.starbank.microservice.controller;

import dev.alexfossa204.starbank.microservice.repository.model.Passport;
import dev.alexfossa204.starbank.microservice.service.exception.impl.PassportNotFoundException;
import org.springframework.graphql.data.method.annotation.SchemaMapping;

import java.util.List;

public interface PassportGraphQLController {

    @SchemaMapping(typeName = "Query", field = "passportBySerialNumber")
    Passport findPassportBySerialNumberGetRequest(String serialNumber) throws PassportNotFoundException;

    @SchemaMapping(typeName = "Query", field = "passportsByLastName")
    List<Passport> findPassportsByLastNameGetRequest(String lastname);

    @SchemaMapping(typeName = "Query", field = "allPassports")
    List<Passport> findAllPassports();

}
