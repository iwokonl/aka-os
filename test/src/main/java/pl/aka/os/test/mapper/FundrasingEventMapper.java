package pl.aka.os.test.mapper;

import pl.aka.os.test.dto.CreatedFundrasingEvent.CreatedFundraisingEventResponseDto;
import pl.aka.os.test.dto.CreatedFundrasingEvent.CreatedFundrasingEventRequestDto;
import pl.aka.os.test.model.FundraisingEvent;

public class FundrasingEventMapper {


    public static FundraisingEvent createdFundrasingEventRequestDtoToFundraisingEvent(CreatedFundrasingEventRequestDto createdFundrasingEventRequestDto) {
        return new FundraisingEvent(
                null,
                createdFundrasingEventRequestDto.name(),
                createdFundrasingEventRequestDto.description(),
                createdFundrasingEventRequestDto.startDate(),
                createdFundrasingEventRequestDto.endDate(),
                null,
                null

        );
    }

    public static CreatedFundraisingEventResponseDto FundraisingEventToCreatedFundrasingEventResponseDto(FundraisingEvent foundrasingEvent) {
        return new CreatedFundraisingEventResponseDto(
                foundrasingEvent.getId(),
                foundrasingEvent.getName(),
                foundrasingEvent.getDescription(),
                foundrasingEvent.getStartDate(),
                foundrasingEvent.getEndDate()
        );
    }
}
