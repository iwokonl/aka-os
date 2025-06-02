package pl.aka.os.test.mapper;

import pl.aka.os.test.dto.CreateFundationAccount.CreateFundationAccountRequestDto;
import pl.aka.os.test.dto.CreateFundationAccount.CreateFundationAccountResponseDto;
import pl.aka.os.test.model.FoundationAccount;

import java.util.Collections;

public class FoundationAccountMapper {

    public static FoundationAccount CreateFundationAccountRequestDtoToFoundationAccount(CreateFundationAccountRequestDto createFundationAccountRequestDto) {
        return new FoundationAccount(
                null,
                createFundationAccountRequestDto.name(),
                createFundationAccountRequestDto.description(),
                createFundationAccountRequestDto.currency(),
                null,
                null
        );
    }

    public static CreateFundationAccountResponseDto FoundationAccountToCreateFundationAccountResponseDto(FoundationAccount foundationAccount) {
        return new CreateFundationAccountResponseDto(
                foundationAccount.getId(),
                foundationAccount.getName(),
                foundationAccount.getDescription(),
                foundationAccount.getCurrencyType(),
                foundationAccount.getBalance().toString(),
                Collections.emptyList()
        );
    }
}
