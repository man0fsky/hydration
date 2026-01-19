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
    void add_good_intake() {
        //given
        IntakeValidator intakeValidator = new IntakeValidator();
        HydrationCalculator hydrationCalculator = new HydrationCalculator();
        IntakeService service = new IntakeService(intakeValidator,hydrationCalculator);
        IntakeEntry intakeEntry = new IntakeEntry(LocalDateTime.now(), 450, DrinkType.WATER);
        service.addEntry(intakeEntry);
        //when&then
        assertEquals(450.0, service.getTotalVolume(), 0.001);

    }

    @Test
    void sum_two_good_intakes(){
        //given
        IntakeValidator intakeValidator = new IntakeValidator();
        HydrationCalculator hydrationCalculator = new HydrationCalculator();
        IntakeService service = new IntakeService(intakeValidator,hydrationCalculator);
        IntakeEntry intakeEntry = new IntakeEntry(LocalDateTime.now(), 450, DrinkType.WATER);
        IntakeEntry intakeEntry2 = new IntakeEntry(LocalDateTime.now(), 550, DrinkType.WATER);
        service.addEntry(intakeEntry);
        service.addEntry(intakeEntry2);
        //when&then
        assertEquals(1000.0,service.getTotalVolume(),0.001);
    }
    @Test
    void should_calculate_hydration_sum_for_multiple_drink_types(){
        //given
        IntakeValidator intakeValidator = new IntakeValidator();
        HydrationCalculator hydrationCalculator = new HydrationCalculator();
        IntakeService service = new IntakeService(intakeValidator,hydrationCalculator);
        IntakeEntry intakeEntry = new IntakeEntry(LocalDateTime.now(), 1000, DrinkType.WATER);
        IntakeEntry intakeEntry2 = new IntakeEntry(LocalDateTime.now(), 1000, DrinkType.COFFEE);
        IntakeEntry intakeEntry3 = new IntakeEntry(LocalDateTime.now(), 1000, DrinkType.LIQUOR);

        service.addEntry(intakeEntry);
        service.addEntry(intakeEntry2);
        service.addEntry(intakeEntry3);
        //when&then
        assertEquals(1600.0,service.calculateHydrationSum(),0.001);
    }
    @Test
    void should_throw_exception_on_wrong_intake(){
        //given
        IntakeValidator intakeValidator = new IntakeValidator();
        HydrationCalculator hydrationCalculator = new HydrationCalculator();
        IntakeService service = new IntakeService(intakeValidator,hydrationCalculator);
        IntakeEntry intakeEntry = new IntakeEntry(LocalDateTime.now(),0,DrinkType.WATER);
        //when
        IllegalArgumentException exception =assertThrows(IllegalArgumentException.class,
                ()->service.addEntry(intakeEntry));
        //then
        assertEquals(0.0,service.getTotalVolume(),0.001);


    }
}
