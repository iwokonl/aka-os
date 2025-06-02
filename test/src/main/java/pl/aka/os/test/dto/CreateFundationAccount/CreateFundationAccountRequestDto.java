package pl.aka.os.test.dto.CreateFundationAccount;

import jakarta.validation.constraints.NotBlank;
import pl.aka.os.test.model.Currency;
import pl.aka.os.test.validation.ValidCurrency;

public record CreateFundationAccountRequestDto(
        @NotBlank(message = "Name cannot be blank")
        String name,
        String description,
        @ValidCurrency(message = "Currency cannot be null or empty")
        Currency currency
) {
}
