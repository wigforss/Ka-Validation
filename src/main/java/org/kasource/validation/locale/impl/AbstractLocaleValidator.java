package org.kasource.validation.locale.impl;

public class AbstractLocaleValidator extends AbstractLocaleBaseValidator {

    private boolean caseSensetive;
    
    protected void initialize(boolean caseSensetive) {
        this.caseSensetive = caseSensetive;
    }
    
    @Override
    protected boolean isValid(Object object) {
        return isValidLocale(object, caseSensetive);
    }

}
