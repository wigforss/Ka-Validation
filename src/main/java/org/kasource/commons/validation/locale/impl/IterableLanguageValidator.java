package org.kasource.commons.validation.locale.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.commons.validation.locale.Language;



public class IterableLanguageValidator extends AbstractLanguageValidator implements ConstraintValidator<Language, Iterable<? extends Object>> {
    
    @Override
    public void initialize(Language annotation) {
        super.initialize(annotation.caseSensetive());
    }

    @Override
    public boolean isValid(Iterable<? extends Object> value, ConstraintValidatorContext context) {
       return isValidItarable(value);
    }

}
