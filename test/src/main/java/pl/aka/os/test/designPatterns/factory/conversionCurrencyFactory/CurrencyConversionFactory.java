package pl.aka.os.test.designPatterns.factory.conversionCurrencyFactory;

import pl.aka.os.test.designPatterns.strategy.conversionCurrencyStrategy.CurrencyConversionStrategy;
import pl.aka.os.test.model.Currency;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
public class CurrencyConversionFactory {

    private final Map<String, CurrencyConversionStrategy> strategies;
    private final CurrencyConversionStrategy defaultStrategy;

    public CurrencyConversionFactory(Map<String, CurrencyConversionStrategy> strategies) {
        this.strategies = strategies;
        this.defaultStrategy = strategies.get("DEFAULT");
    }

    public Optional<CurrencyConversionStrategy> getStrategy(Currency from, Currency to) {
        if (from.equals(to)) {
            return Optional.of(defaultStrategy);
        }

        String key = from.name() + "->" + to.name();
        return Optional.ofNullable(strategies.get(key));
    }
}