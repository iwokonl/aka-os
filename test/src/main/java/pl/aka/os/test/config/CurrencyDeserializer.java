package pl.aka.os.test.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import pl.aka.os.test.model.Currency;


import java.io.IOException;

public class CurrencyDeserializer extends JsonDeserializer<Currency> {

    @Override
    public Currency deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String value = p.getText();
        try {
            return Currency.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}