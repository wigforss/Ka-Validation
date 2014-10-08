package org.kasource.validation.currency.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.currency.Currency;


public class ArrayCurrencyValidator extends AbstractCurrencyValidator implements ConstraintValidator<Currency, Object[]> {

    public void initialize(final Currency annotation) {
        super.initialize(annotation);
    }
    
    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {
        boolean isValid = isValidArray(value);
        if (!isValid) {
            setConstraintMessage(context);
        }
        return isValid;
    }

}
