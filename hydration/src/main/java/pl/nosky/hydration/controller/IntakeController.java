package pl.nosky.hydration.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.nosky.hydration.controller.dto.IntakeRequest;
import pl.nosky.hydration.domain.IntakeEntry;
import pl.nosky.hydration.service.IntakeService;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/intake")
public class IntakeController {
    final IntakeService intakeService;

    public IntakeController(IntakeService intakeService) {
    this.intakeService = intakeService;
    }
    @PostMapping
    public ResponseEntity<Void> addIntake(@RequestBody IntakeRequest intakeRequest){
        IntakeEntry entry = new IntakeEntry(
                LocalDateTime.now(), intakeRequest.getVolume(), intakeRequest.getType()
        );
        intakeService.addEntry(entry);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/volume")
    public ResponseEntity<Double> getTotalVolume(){
        return ResponseEntity.ok(intakeService.getTotalVolume());
    }
    @GetMapping("/hydration")
    public ResponseEntity<Double> getHydration(){
        return ResponseEntity.ok(intakeService.calculateHydrationSum());
    }

}
