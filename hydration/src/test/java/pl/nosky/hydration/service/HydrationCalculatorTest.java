package pl.nosky.hydration.service;

import org.junit.jupiter.api.Test;
import pl.nosky.hydration.domain.DrinkType;
import pl.nosky.hydration.domain.IntakeEntry;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HydrationCalculatorTest {

    @Test
    void should_calculate_correct_hydration_for_water(){
        //given
        IntakeEntry intakeEntry = new IntakeEntry(LocalDateTime.now(),450, DrinkType.WATER);
        HydrationCalculator hydrationCalculator = new HydrationCalculator();
        //when&then
        assertEquals(450.0,hydrationCalculator.calculateHydrationBalance(intakeEntry),0.001);
    }

    @Test
    void should_calculate_proper_hydration_for_coffee(){
        //given
        IntakeEntry intakeEntry = new IntakeEntry(LocalDateTime.now(),1000,DrinkType.COFFEE);
        HydrationCalculator hydrationCalculator = new HydrationCalculator();
        //when&then
        assertEquals(800.0,hydrationCalculator.calculateHydrationBalance(intakeEntry),0.001);
    }
    @Test
    void should_calculate_proper_hydration_for_liquor(){
        //given
        IntakeEntry intakeEntry = new IntakeEntry(LocalDateTime.now(),1000,DrinkType.LIQUOR);
        HydrationCalculator hydrationCalculator = new HydrationCalculator();
        //when&then
        assertEquals(-200.0,hydrationCalculator.calculateHydrationBalance(intakeEntry),0.001);
    }
}
