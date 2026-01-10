package pl.nosky.hydration.validation;


import org.springframework.stereotype.Component;
import pl.nosky.hydration.domain.IntakeEntry;

import java.time.LocalDateTime;
@Component
public class IntakeValidator {

    public void validate(IntakeEntry entry) {
        if (entry == null) {
            throw new IllegalArgumentException("Entry cannot be null");
        }
        if (entry.getType() == null) {
            throw new IllegalArgumentException("Drink type cannot be null");
        }
        if (entry.getDateOfIntake().isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("Date cannot be placed in the future");
        }
        if (entry.getVolumeOfIntake() <= 0) {
            throw new IllegalArgumentException("Volume must be greater than 0");
        }
    }
}
