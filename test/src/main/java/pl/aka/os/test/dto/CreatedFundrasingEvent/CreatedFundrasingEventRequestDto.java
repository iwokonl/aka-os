package pl.aka.os.test.dto.CreatedFundrasingEvent;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import pl.aka.os.test.exception.GeneralAppException;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.UUID;
// import pl.aka.os.test.
// import pl.aka.os.test.
public record CreatedFundrasingEventRequestDto(
        @NotBlank(message = "Name cannot be blank")
        String name,
        String description,
        @NotNull(message = "Start date cannot be null")
        LocalDateTime startDate,
        @NotNull(message = "End date cannot be null")
        LocalDateTime endDate,
        @NotNull(message = "Foundation account cannot be blank")
        UUID foundationAccountId
) {

    public CreatedFundrasingEventRequestDto {
        if (startDate != null && endDate != null && !startDate.isBefore(endDate)) {
            throw new GeneralAppException("Start date must be before end date", HttpStatus.BAD_REQUEST);
        }
    }
}
