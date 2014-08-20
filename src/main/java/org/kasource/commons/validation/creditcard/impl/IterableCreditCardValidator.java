package org.kasource.commons.validation.creditcard.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.commons.validation.creditcard.CreditCard;

public class IterableCreditCardValidator extends AbstractCreditCardValidator implements ConstraintValidator<CreditCard, Iterable<? extends Object>> {

    @Override
    public void initialize(CreditCard annotation) {
       super.initialize(annotation);
    }

    @Override
    public boolean isValid(Iterable<? extends Object> value, ConstraintValidatorContext context) {
        return isValidItarable(value);
    }

}
