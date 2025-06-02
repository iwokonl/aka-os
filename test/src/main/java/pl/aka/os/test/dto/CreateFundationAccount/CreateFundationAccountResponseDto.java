package pl.aka.os.test.dto.CreateFundationAccount;

import pl.aka.os.test.model.Currency;

import java.util.List;
import java.util.UUID;

public record CreateFundationAccountResponseDto(
        UUID id,
        String name,
        String description,
        Currency currency,
        String balance,
        List<Object> fundraisingEvents
) {
}
