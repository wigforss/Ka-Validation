package org.kasource.commons.validation.locale.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.commons.validation.locale.Language;



public class LanguageValidator extends AbstractLanguageValidator implements ConstraintValidator<Language, String> {
 
    @Override
    public void initialize(Language annotation) {
       super.initialize(annotation.caseSensetive());
        
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return isValid(value);
    }

}
