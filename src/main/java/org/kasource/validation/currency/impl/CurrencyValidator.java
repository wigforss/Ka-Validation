package org.kasource.validation.currency.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.currency.Currency;


public class CurrencyValidator extends AbstractCurrencyValidator implements ConstraintValidator<Currency, String> {

    public void initialize(final Currency annotation) {
        super.initialize(annotation);
    }
    
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean isValid = isValid(value);
        if (!isValid) {
            setConstraintMessage(context);
        }
        return isValid;
    }

}
