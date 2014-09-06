package org.kasource.validation.locale.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.locale.Country;



public class ArrayCountryValidator extends AbstractCountryValidator implements ConstraintValidator<Country, Object[]> {

    @Override
    public void initialize(Country annotation) {
       super.initialize(annotation.caseSensetive());
    }

    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {
       return isValidArray(value);
    }
}
