package org.kasource.validation.creditcard.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.creditcard.CreditCard;

public class ArrayCreditCardValidator extends AbstractCreditCardValidator implements ConstraintValidator<CreditCard, Object[]> {

    @Override
    public void initialize(CreditCard annotation) {
       super.initialize(annotation);
    }

    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {
        return isValidArray(value);
    }

}
