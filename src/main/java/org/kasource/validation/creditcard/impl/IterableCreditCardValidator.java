package org.kasource.validation.creditcard.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.creditcard.CreditCard;

public class IterableCreditCardValidator extends AbstractCreditCardValidator implements ConstraintValidator<CreditCard, Iterable<? extends Object>> {

    @Override
    public void initialize(CreditCard annotation) {
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
