package pl.nosky.hydration.domain;

import java.time.LocalDateTime;

public class IntakeEntry {
   private final LocalDateTime dateOfIntake;
   private final double volumeOfIntake;
   private final DrinkType type;


    public IntakeEntry(LocalDateTime dateOfIntake, double volumeOfIntake, DrinkType type) {
        this.dateOfIntake = dateOfIntake;
        this.volumeOfIntake = volumeOfIntake;
        this.type = type;
    }

    public LocalDateTime getDateOfIntake() {
        return dateOfIntake;
    }

    public double getVolumeOfIntake() {
        return volumeOfIntake;
    }

    public DrinkType getType() {
        return type;
    }
}
