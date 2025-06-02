package pl.aka.os.test.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import pl.aka.os.test.dto.CreatedFundrasingEvent.CreatedFundraisingEventResponseDto;
import pl.aka.os.test.dto.CreatedFundrasingEvent.CreatedFundrasingEventRequestDto;
import pl.aka.os.test.service.FundraisingEventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/fundraisingEvent")
@RequiredArgsConstructor
public class FundraisingEventController {

    private final FundraisingEventService fundraisingEventService;

    @PostMapping("/create")
    public ResponseEntity<CreatedFundraisingEventResponseDto> crateFundraisingEvent(@RequestBody @Valid CreatedFundrasingEventRequestDto createdFundrasingEventRequestDto) {
        return ResponseEntity.ok(fundraisingEventService.createFundraisingEvent(createdFundrasingEventRequestDto));
    }

    @PutMapping("/removeBox")
    @ResponseStatus(HttpStatus.OK)
    public void removeBox(@RequestParam("boxId") UUID boxId) {
        fundraisingEventService.removeBox(boxId);
    }

    @PutMapping("/assignBox")
    @ResponseStatus(HttpStatus.OK)
    public void assignBoxToFundraisingEvent(@RequestParam("boxId") UUID boxId, @RequestParam("fundraisingEventId") UUID fundraisingEventId) {
        fundraisingEventService.assignBox(boxId, fundraisingEventId);
    }

}
