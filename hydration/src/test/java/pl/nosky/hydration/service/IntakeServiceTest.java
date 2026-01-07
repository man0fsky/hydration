package pl.nosky.hydration.service;

import org.junit.jupiter.api.Test;
import pl.nosky.hydration.domain.DrinkType;
import pl.nosky.hydration.domain.IntakeEntry;
import pl.nosky.hydration.validation.IntakeValidator;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IntakeServiceTest {

    @Test
    void addGoodIntake() {
        IntakeValidator intakeValidator = new IntakeValidator();
        IntakeService service = new IntakeService(intakeValidator);
        IntakeEntry intakeEntry = new IntakeEntry(LocalDateTime.now(), 450, DrinkType.WATER);
        service.addEntry(intakeEntry);
        assertEquals(450.0, service.getTotalVolume(), 0.001);

    }

    @Test
    void sumTwoGoodIntakes(){
        IntakeValidator intakeValidator = new IntakeValidator();
        IntakeService service = new IntakeService(intakeValidator);
        IntakeEntry intakeEntry = new IntakeEntry(LocalDateTime.now(), 450, DrinkType.WATER);
        IntakeEntry intakeEntry2 = new IntakeEntry(LocalDateTime.now(), 550, DrinkType.WATER);
        service.addEntry(intakeEntry);
        service.addEntry(intakeEntry2);
        assertEquals(1000.0,service.getTotalVolume(),0.001);
    }
    @Test
    void shouldThrowExceptionOnWrongIntake(){
        IntakeValidator intakeValidator = new IntakeValidator();
        IntakeService service = new IntakeService(intakeValidator);
        IntakeEntry intakeEntry = new IntakeEntry(LocalDateTime.now(),0,DrinkType.WATER);
        assertThrows(IllegalArgumentException.class,
                ()->service.addEntry(intakeEntry));
        assertEquals(0.0,service.getTotalVolume(),0.001);

    }
}
