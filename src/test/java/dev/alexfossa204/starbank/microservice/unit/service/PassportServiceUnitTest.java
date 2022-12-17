package dev.alexfossa204.starbank.microservice.unit.service;

import dev.alexfossa204.starbank.microservice.repository.PassportRepository;
import dev.alexfossa204.starbank.microservice.repository.model.Passport;
import dev.alexfossa204.starbank.microservice.service.exception.impl.PassportNotFoundException;
import dev.alexfossa204.starbank.microservice.service.impl.PassportServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PassportServiceUnitTest {

    @InjectMocks
    private PassportServiceImpl passportService;

    @Mock
    private PassportRepository passportRepository;

    private static List<Passport> PASSPORT_LIST_DUMMY;

    private static List<Passport> PASSPORT_LIST_BY_LAST_NAME_DUMMY;

    private static Passport PASSPORT_BY_SERIAL_NUMBER_DUMMY;

    private static String PASSPORT_LASTNAME_DUMMY = "DUMMY";

    private static String PASSPORT_SERIAL_NUMBER_DUMMY = "DUMMY_SERIAL";

    @BeforeEach
    public void beforeEachTest() {
        PASSPORT_LIST_DUMMY = List.of(
                Passport.builder().build());
        PASSPORT_LIST_BY_LAST_NAME_DUMMY = List.of(
                Passport.builder()
                        .lastname(PASSPORT_LASTNAME_DUMMY)
                        .build(),
                Passport.builder()
                        .lastname(PASSPORT_LASTNAME_DUMMY)
                        .build()
        );
        PASSPORT_BY_SERIAL_NUMBER_DUMMY = Passport.builder()
                .passportSerial(PASSPORT_SERIAL_NUMBER_DUMMY)
                .build();
    }

    @Test
    public void when_find_all_passports_returns_filled_list() {
        Mockito.when(passportRepository.findAll())
                .thenReturn(List.of(Passport.builder().build()));
        List<Passport> passportsActual = passportService.findAllPassports();
        Assertions.assertThat(passportsActual).isEqualTo(PASSPORT_LIST_DUMMY);
    }

    @Test
    public void when_find_passports_by_lastname_returns_filled_list() {
        Mockito.when(passportRepository.findAllPassportsByLastname(PASSPORT_LASTNAME_DUMMY))
                .thenReturn(PASSPORT_LIST_BY_LAST_NAME_DUMMY);
        List<Passport> passportsByLastnameActual = passportService.findPassportsByLastName(PASSPORT_LASTNAME_DUMMY);
        Assertions.assertThat(passportsByLastnameActual).isEqualTo(PASSPORT_LIST_BY_LAST_NAME_DUMMY);
    }

    @Test
    public void when_find_passport_by_serial_number_returns_successful() throws PassportNotFoundException {
        Mockito.when(passportRepository.findPassportByPassportSerial(PASSPORT_SERIAL_NUMBER_DUMMY))
                .thenReturn(Optional.of(
                        Passport.builder()
                                .passportSerial(PASSPORT_SERIAL_NUMBER_DUMMY)
                                .build())
                );
        Passport passportActual = passportService.findPassportBySerialNumber(PASSPORT_SERIAL_NUMBER_DUMMY);
        Assertions.assertThat(passportActual).isEqualTo(PASSPORT_BY_SERIAL_NUMBER_DUMMY);
    }

    @Test
    public void when_find_passport_by_serial_number_throws_exception() {
        Mockito.when(passportRepository.findPassportByPassportSerial(PASSPORT_SERIAL_NUMBER_DUMMY))
                        .thenReturn(Optional.empty());
        Assertions.assertThatThrownBy(() -> passportService.findPassportBySerialNumber(PASSPORT_SERIAL_NUMBER_DUMMY))
                .isInstanceOf(PassportNotFoundException.class);
    }

}
