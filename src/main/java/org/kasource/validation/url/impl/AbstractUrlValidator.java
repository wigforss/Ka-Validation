package org.kasource.validation.url.impl;

import org.apache.commons.validator.routines.UrlValidator;
import org.kasource.validation.AbstractValidator;
import org.kasource.validation.url.Url;

public class AbstractUrlValidator extends AbstractValidator {

    private UrlValidator validator;
    
    protected void initialize(Url annotation) {
        if (annotation.value().length == 0) {    
            validator = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES + getOptions(annotation));
        } else {
            validator = new UrlValidator(annotation.value(), getOptions(annotation));
        }   
    }
    
    private long getOptions(Url annotation) {
        long options = 0;
        if (!annotation.allowFragments()) {
            options += UrlValidator.NO_FRAGMENTS;
        }
        if (annotation.allowLocalUrls()) {
            options += UrlValidator.ALLOW_LOCAL_URLS;
        }
        if (annotation.allowTwoSlahes()) {
            options += UrlValidator.ALLOW_2_SLASHES;
        }
        return options;
    }
    
    @Override
    protected boolean isValid(Object value) {
        if (value == null) {
            return true;
        }
        return validator.isValid(value.toString());
    }
}
