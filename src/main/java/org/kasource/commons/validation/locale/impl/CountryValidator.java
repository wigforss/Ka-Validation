package org.kasource.commons.validation.locale.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.commons.validation.locale.Country;



public class CountryValidator extends AbstractCountryValidator implements ConstraintValidator<Country, String> {
    
    @Override
    public void initialize(Country annotation) {
       super.initialize(annotation.caseSensetive());
        
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return isValid(value);
    }

}
