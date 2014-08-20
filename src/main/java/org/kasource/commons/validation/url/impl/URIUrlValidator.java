package org.kasource.commons.validation.url.impl;

import java.net.URI;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


import org.kasource.commons.validation.url.Url;

public class URIUrlValidator extends AbstractUrlValidator implements ConstraintValidator<Url, URI> {

    @Override
    public void initialize(Url annotation) {
       super.initialize(annotation);
        
    }

    @Override
    public boolean isValid(URI value, ConstraintValidatorContext context) {
        return super.isValid(value);
    }

}
