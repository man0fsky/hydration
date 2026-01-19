package pl.nosky.hydration.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.nosky.hydration.domain.DrinkType;
import pl.nosky.hydration.domain.IntakeEntry;

import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IntakeValidatorTest {


    @Test
    void should_throw_exception_when_date_is_in_future() {
       //given
        IntakeEntry entry = new IntakeEntry(
                LocalDateTime.now().plusDays(1),
                400,
                DrinkType.WATER
        );
        //when&then
        IntakeValidator validator = new IntakeValidator();
        assertThrows(IllegalArgumentException.class,
                () -> validator.validate(entry));
    }

    @Test
    void should_throw_exception_when_drink_type_is_null() {
        //given
        IntakeEntry entry = new IntakeEntry(
                LocalDateTime.now(),
                400,
                null
        );
        IntakeValidator validator = new IntakeValidator();
        //when&then
        assertThrows(IllegalArgumentException.class,
                () -> validator.validate(entry));
    }

    @Test
    void should_throw_exception_when_volume_is_smaller_or_equal_to_zero() {
        //given
        IntakeEntry entry = new IntakeEntry(
                LocalDateTime.now(),
                0,
                DrinkType.WATER
        );
        IntakeValidator validator = new IntakeValidator();
        //when&then
        assertThrows(IllegalArgumentException.class,
                () -> validator.validate(entry));
    }

    @Test
    void should_throw_exception_when_entry_is_null() {
        //given
        IntakeEntry entry = null;
        IntakeValidator validator = new IntakeValidator();
        //when&then
        assertThrows(IllegalArgumentException.class,
                () -> validator.validate(entry));

    }

    @Test
    void assert_does_not_throw() {
        //given
        IntakeEntry entry = new IntakeEntry(LocalDateTime.now(), 250, DrinkType.WATER);
        IntakeValidator validator = new IntakeValidator();
        //when&then
        Assertions.assertDoesNotThrow(()->validator.validate(entry));
    }

}
