package pl.nosky.hydration.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.nosky.hydration.domain.DrinkType;
import pl.nosky.hydration.domain.IntakeEntry;

import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IntakeValidatorTest {


    @Test
    void shouldThrowExceptionWhenDateIsInFuture() {
        IntakeEntry entry = new IntakeEntry(
                LocalDateTime.now().plusDays(1),
                400,
                DrinkType.WATER
        );
        IntakeValidator validator = new IntakeValidator();
        assertThrows(IllegalArgumentException.class,
                () -> validator.validate(entry));
    }

    @Test
    void shouldThrowExceptionWhenDrinkTypeIsNull() {
        IntakeEntry entry = new IntakeEntry(
                LocalDateTime.now(),
                400,
                null
        );
        IntakeValidator validator = new IntakeValidator();
        assertThrows(IllegalArgumentException.class,
                () -> validator.validate(entry));
    }

    @Test
    void shouldThrowExceptionWhenVolumeIsSmallerOrEqualToZero() {
        IntakeEntry entry = new IntakeEntry(
                LocalDateTime.now(),
                0,
                DrinkType.WATER
        );
        IntakeValidator validator = new IntakeValidator();
        assertThrows(IllegalArgumentException.class,
                () -> validator.validate(entry));
    }

    @Test
    void shouldThrowExceptionWhenEntryIsNull() {
        IntakeEntry entry = null;
        IntakeValidator validator = new IntakeValidator();
        assertThrows(IllegalArgumentException.class,
                () -> validator.validate(entry));

    }

    @Test
    void assertDoesNotThrow() {
        IntakeEntry entry = new IntakeEntry(LocalDateTime.now(), 250, DrinkType.WATER);
        IntakeValidator validator = new IntakeValidator();
        Assertions.assertDoesNotThrow(()->validator.validate(entry));
    }

}
