package dev.alexfossa204.starbank.microservice.service;

import dev.alexfossa204.starbank.microservice.repository.model.Passport;

import java.util.List;

public interface PassportService {

    List<Passport> findPassportsByLastName(String lastname);

    Passport findPassportBySerialNumber(String passportSerialNumber);

    List<Passport> findAllPassports();
}
