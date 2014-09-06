package org.kasource.validation.phone.impl;

import java.math.BigInteger;

import org.kasource.validation.AbstractValidator;
import org.kasource.validation.phone.Phone;

public abstract class AbstractPhoneValidator extends AbstractValidator {
    private static final String[] SEPERATORS = {" ", "+", "-", "(", ")", "."};
    private String country;
    
    
    protected void initialize(Phone annotation) {
       if (!annotation.country().isEmpty()) {
           country = annotation.country();
       }
        
    }
    
    @Override
    protected boolean isValid(Object value) {
        if (value == null) {
            return true;
        }
       if (country != null) {
           return false;
       } else {
           return defaultValidator(value.toString());
       }
        
    }
    
    /**
     * Return true if the value is an integer when all separators
     * has been stripped.
     * 
     * @param value Value to validate.
     * 
     * @return true if the value is an integer when all separators
     * has been stripped.
     */
    private boolean defaultValidator(String value) {
        try {
            new BigInteger(stripSeperators(value));
            return true;
        } catch(NumberFormatException nfe) {
            return false;
        }
    }
    
    private String stripSeperators(final String phoneNumber) {
        String number = phoneNumber;
        for (String separator : SEPERATORS) {
            number = number.replace(separator, "");
        }
        return number;
    }
}
