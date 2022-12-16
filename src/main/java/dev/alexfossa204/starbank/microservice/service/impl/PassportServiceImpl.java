package dev.alexfossa204.starbank.microservice.service.impl;

import dev.alexfossa204.starbank.microservice.repository.PassportRepository;
import dev.alexfossa204.starbank.microservice.repository.model.Passport;
import dev.alexfossa204.starbank.microservice.service.PassportService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassportServiceImpl implements PassportService {

    private final PassportRepository passportRepository;

    public PassportServiceImpl(PassportRepository passportRepository) {
        this.passportRepository = passportRepository;
    }

    @Override
    public List<Passport> findPassportsByLastName(String lastname) {
        return passportRepository.findAllPassportsByLastname(lastname);
    }

    @Override
    public Passport findPassportBySerialNumber(String passportSerialNumber) {
        return passportRepository.findPassportByPassportSerial(passportSerialNumber);
    }

    @Override
    public List<Passport> findAllPassports() {
        return passportRepository.findAll();
    }
}
