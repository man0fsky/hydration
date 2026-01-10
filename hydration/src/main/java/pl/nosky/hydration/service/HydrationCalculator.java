package pl.nosky.hydration.service;

import org.springframework.stereotype.Component;
import pl.nosky.hydration.domain.IntakeEntry;
@Component
public class HydrationCalculator {

   public double calculateHydrationBalance(IntakeEntry intakeEntry){
        double waterAmount=0;
        waterAmount = intakeEntry.getVolumeOfIntake()*intakeEntry.getType().getHydrationFactor();
        return waterAmount;
    }


}
