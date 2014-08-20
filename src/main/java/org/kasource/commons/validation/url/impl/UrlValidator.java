package org.kasource.commons.validation.url.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


import org.kasource.commons.validation.url.Url;

public class UrlValidator extends AbstractUrlValidator implements ConstraintValidator<Url, String> {

    @Override
    public void initialize(Url annotation) {
       super.initialize(annotation);
        
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return super.isValid(value);
    }

}
