package org.kasource.commons.validation.locale.impl;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.commons.validation.locale.Language;



public class ArrayLanguageValidator extends AbstractLanguageValidator implements ConstraintValidator<Language, Object[]> {
 
    @Override
    public void initialize(Language annotation) {
        super.initialize(annotation.caseSensetive());
    }

    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {
        return isValidArray(value);
    }

}
