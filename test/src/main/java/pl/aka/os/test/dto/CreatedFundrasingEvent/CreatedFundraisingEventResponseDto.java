package pl.aka.os.test.dto.CreatedFundrasingEvent;

import java.time.LocalDateTime;
import java.util.UUID;

public record CreatedFundraisingEventResponseDto(
        UUID id,
        String name,
        String description,
        LocalDateTime startDate,
        LocalDateTime endDate
) {
}
