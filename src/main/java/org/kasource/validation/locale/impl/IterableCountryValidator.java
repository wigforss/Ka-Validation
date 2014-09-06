package org.kasource.validation.locale.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.locale.Country;



public class IterableCountryValidator extends AbstractCountryValidator implements ConstraintValidator<Country, Iterable<? extends Object>> {

    
    
    @Override
    public void initialize(Country annotation) {
        super.initialize(annotation.caseSensetive());
    }

    @Override
    public boolean isValid(Iterable<? extends Object> value, ConstraintValidatorContext context) {
        return isValidItarable(value);
    }

}
