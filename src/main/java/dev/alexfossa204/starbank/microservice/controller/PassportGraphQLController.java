package dev.alexfossa204.starbank.microservice.controller;

import dev.alexfossa204.starbank.microservice.repository.model.Passport;

import java.util.List;

public interface PassportGraphQLController {

    Passport findPassportBySerialNumberGetRequest(String serialNumber);

    List<Passport> findPassportsByLastNameGetRequest(String lastname);

}
