package pl.nosky.hydration.service;

import pl.nosky.hydration.domain.IntakeEntry;
import pl.nosky.hydration.validation.IntakeValidator;

import java.util.ArrayList;
import java.util.List;

public class IntakeService {

    private List<IntakeEntry> intakeEntryList = new ArrayList<>();
    private IntakeValidator validator;

    public IntakeService(IntakeValidator validator) {
        this.validator = validator;
        this.intakeEntryList = new ArrayList<>();
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
