package org.kasource.validation.url.impl;


import java.net.URL;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


import org.kasource.validation.url.Url;

public class URLUrlValidator extends AbstractUrlValidator implements ConstraintValidator<Url, URL> {

    @Override
    public void initialize(Url annotation) {
       super.initialize(annotation);
        
    }

    @Override
    public boolean isValid(URL value, ConstraintValidatorContext context) {
        return super.isValid(value);
    }

}
