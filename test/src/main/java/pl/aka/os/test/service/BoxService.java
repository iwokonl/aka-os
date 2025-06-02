package pl.aka.os.test.service;

import lombok.RequiredArgsConstructor;
import pl.aka.os.test.designPatterns.factory.conversionCurrencyFactory.CurrencyConversionFactory;
import pl.aka.os.test.dto.CreatedBox.CreatedBoxResponseDto;
import pl.aka.os.test.dto.GetAllAnonymizedBoxes.GetAllAnonymizedBoxesResponseDto;
import pl.aka.os.test.dto.MoneyDonation.MoneyDonationRequestDto;
import pl.aka.os.test.exception.GeneralAppException;
import pl.aka.os.test.mapper.BoxMapper;
import pl.aka.os.test.model.Box;
import pl.aka.os.test.model.Currency;
import pl.aka.os.test.model.FoundationAccount;
import pl.aka.os.test.repository.BoxRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BoxService {

    private final BoxRepository boxRepository;
    private final CurrencyConversionFactory currencyConversionFactory;


    @Transactional
    public CreatedBoxResponseDto createBox() {

        Box box = boxRepository.save(new Box());

        return BoxMapper.BoxToCratedBoxDto(box);
    }

    @Transactional
    public void moneyDonation(MoneyDonationRequestDto moneyDonationRequestDto) {
        Box box = boxRepository.findById(moneyDonationRequestDto.boxId()).orElseThrow(
                () -> new GeneralAppException("Box not found", HttpStatus.INTERNAL_SERVER_ERROR)
        );
        Map<Currency, BigDecimal> ballanceMap = box.getBallanceMap();
        if (ballanceMap == null) {
            ballanceMap = new HashMap<>();
            box.setBallanceMap(ballanceMap);
        }
        ballanceMap.compute(moneyDonationRequestDto.currency(), (key, value) ->
                value == null ? moneyDonationRequestDto.moneyAmmount() : value.add(moneyDonationRequestDto.moneyAmmount())
        );
    }

    @Transactional(readOnly = true)
    public List<GetAllAnonymizedBoxesResponseDto> getAllAnonymizedBoxes() {
        return boxRepository.findAll().stream()
                .map(box -> new GetAllAnonymizedBoxesResponseDto(
                        box.getId(),
                        box.getFundraisingEvent() != null,
                        box.getBallanceMap().isEmpty()
                ))
                .toList();
    }

    @Transactional
    public void transferToFoundation(UUID boxId) {
        Box box = boxRepository.findById(boxId).orElseThrow(
                () -> new GeneralAppException("Box not found", HttpStatus.INTERNAL_SERVER_ERROR)
        );
        Map<Currency, BigDecimal> ballanceMap = box.getBallanceMap();


        FoundationAccount foundationAccount = box.getFundraisingEvent().getFoundationAccount();
        if (foundationAccount == null) {
            throw new GeneralAppException("Foundation account not found", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        for (Currency currency : ballanceMap.keySet()) {
            currencyConversionFactory.getStrategy(currency, foundationAccount.getCurrencyType())
                    .ifPresent(strategy -> {
                        BigDecimal convertedAmount = strategy.convert(ballanceMap.get(currency));
                        foundationAccount.setBalance(
                                foundationAccount.getBalance().add(convertedAmount)
                        );
                    });
        }
        ballanceMap.clear();
    }

}
