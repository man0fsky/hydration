package pl.nosky.hydration.service;

import pl.nosky.hydration.domain.IntakeEntry;
import pl.nosky.hydration.validation.IntakeValidator;

import java.util.ArrayList;
import java.util.List;

public class IntakeService {

    private List<IntakeEntry> intakeEntryList = new ArrayList<>();
    private final IntakeValidator validator;
    private final HydrationCalculator hydrationCalculator;

    public IntakeService(IntakeValidator validator,HydrationCalculator hydrationCalculator) {
        this.validator = validator;
        this.intakeEntryList = new ArrayList<>();
        this.hydrationCalculator = hydrationCalculator;
    }

    public double calculateHydrationSum(){
        double hydrationSum=0;
        for (IntakeEntry el:intakeEntryList){
            hydrationSum+=hydrationCalculator.calculateHydrationBalance(el);
        }
        return hydrationSum;
    }

    public void addEntry(IntakeEntry entry) {
        validator.validate(entry);
        intakeEntryList.add(entry);
    }

    public double getTotalVolume() {
        double totalVolume = 0;
        for (IntakeEntry el : intakeEntryList) {
            totalVolume += el.getVolumeOfIntake();
        }
        return totalVolume;
    }
}
