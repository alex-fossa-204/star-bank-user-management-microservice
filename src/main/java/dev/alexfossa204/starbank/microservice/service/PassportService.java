package dev.alexfossa204.starbank.microservice.service;

import dev.alexfossa204.starbank.microservice.repository.model.Passport;
import dev.alexfossa204.starbank.microservice.service.exception.impl.PassportNotFoundException;

import java.util.List;

public interface PassportService {

    List<Passport> findPassportsByLastName(String lastname);

    Passport findPassportBySerialNumber(String passportSerialNumber) throws PassportNotFoundException;

    List<Passport> findAllPassports();
}
