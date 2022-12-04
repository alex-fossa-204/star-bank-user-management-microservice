package dev.alexfossa204.starbank.microservice.service.impl;

import dev.alexfossa204.starbank.microservice.repository.PassportRepository;
import dev.alexfossa204.starbank.microservice.repository.model.Passport;
import dev.alexfossa204.starbank.microservice.service.PassportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PassportServiceImpl implements PassportService {

    private final PassportRepository passportRepository;

    @Override
    public List<Passport> findPassportsByLastName(String lastname) {
        return passportRepository.findAllPassportsByLastname(lastname);
    }

    @Override
    public Passport findPassportBySerialNumber(String passportSerialNumber) {
        return passportRepository.findPassportByPassportSerial(passportSerialNumber);
    }
}
