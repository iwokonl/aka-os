package pl.aka.os.test.dto.MoneyDonation;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import pl.aka.os.test.model.Currency;

import java.math.BigDecimal;
import java.util.UUID;

public record MoneyDonationRequestDto(
        @NotNull(message = "moneyAmmount cannot be null")
        @DecimalMin(value = "0.0", inclusive = false, message = "moneyAmmount must be greater than 0")
        BigDecimal moneyAmmount,
        @NotNull(message = "boxId cannot be null")
        UUID boxId,
        @NotNull(message = "currency cannot be null")
        Currency currency) {
}
