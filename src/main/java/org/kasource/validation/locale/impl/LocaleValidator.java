package org.kasource.validation.locale.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.locale.Locale;



public class LocaleValidator extends AbstractLocaleValidator implements ConstraintValidator<Locale, String> {

   
    
    @Override
    public void initialize(Locale annotation) {
       super.initialize(annotation.caseSensetive());
        
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return isValid(value);
    }

}
