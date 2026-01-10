package pl.nosky.hydration.controller.dto;

import pl.nosky.hydration.domain.DrinkType;

public class IntakeRequest {
   private double volume;
   private DrinkType type;

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public DrinkType getType() {
        return type;
    }

    public void setType(DrinkType type) {
        this.type = type;
    }


}
