package pl.aka.os.test.dto.GetAllAnonymizedBoxes;

import java.util.UUID;

public record GetAllAnonymizedBoxesResponseDto(
        UUID id,
        Boolean isAssigned,
        Boolean isEmpty
) {
}
