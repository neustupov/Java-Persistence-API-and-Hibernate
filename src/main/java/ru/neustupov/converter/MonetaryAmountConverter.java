package ru.neustupov.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import ru.neustupov.model.advanced.MonetaryAmount;

@Converter(autoApply = true)
public class MonetaryAmountConverter implements AttributeConverter<MonetaryAmount, String> {

  @Override
  public String convertToDatabaseColumn(MonetaryAmount attribute) {
    return attribute.toString();
  }

  @Override
  public MonetaryAmount convertToEntityAttribute(String dbData) {
    return MonetaryAmount.fromString(dbData);
  }
}
