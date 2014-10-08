package org.kasource.validation.currency.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.currency.Currency;


public class IterableCurrencyValidator extends AbstractCurrencyValidator implements ConstraintValidator<Currency, Iterable<? extends Object>> {

    public void initialize(final Currency annotation) {
        super.initialize(annotation);
    }
    
    @Override
    public boolean isValid(Iterable<? extends Object> value, ConstraintValidatorContext context) {
        boolean isValid = isValidItarable(value);
        if (!isValid) {
            setConstraintMessage(context);
        }
        return isValid;
       
    }

}
