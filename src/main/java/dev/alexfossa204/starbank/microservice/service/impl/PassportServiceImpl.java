package dev.alexfossa204.starbank.microservice.service.impl;

import dev.alexfossa204.starbank.microservice.repository.PassportRepository;
import dev.alexfossa204.starbank.microservice.repository.model.Passport;
import dev.alexfossa204.starbank.microservice.service.PassportService;
import dev.alexfossa204.starbank.microservice.service.exception.impl.PassportNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Passport findPassportBySerialNumber(String passportSerialNumber) throws PassportNotFoundException {
        Optional<Passport> passportOptional = passportRepository.findPassportByPassportSerial(passportSerialNumber);
        if (passportOptional.isEmpty()) {
            throw new PassportNotFoundException(String.format("There is no any passport with such serial_number = %s", passportSerialNumber));
        }
        return passportOptional.get();
    }

    @Override
    public List<Passport> findAllPassports() {
        return passportRepository.findAll();
    }
}
