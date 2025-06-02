package pl.aka.os.test.dto.FinancialReport;

import pl.aka.os.test.model.Currency;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public record FinancialReportResponseDto(String foundationName,
                                         BigDecimal fundationAmmount,
                                         Currency currency,
                                         List<FundraisingEventResponseDto> fundrasingEvents) {
    public record FundraisingEventResponseDto(String name, Map<Currency, BigDecimal> amounts) {

    }

}
