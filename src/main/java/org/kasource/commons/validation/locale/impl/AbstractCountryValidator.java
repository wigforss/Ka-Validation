package org.kasource.commons.validation.locale.impl;

public class AbstractCountryValidator extends AbstractLocaleBaseValidator {

    private boolean caseSensetive;
    
    protected void initialize(boolean caseSensetive) {
        this.caseSensetive = caseSensetive;
    }
    
    @Override
    protected boolean isValid(Object object) {
        return isValidCountry(object, caseSensetive);
    }

}
