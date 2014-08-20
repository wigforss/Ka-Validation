package org.kasource.commons.validation.enumeration.impl;

import java.util.HashSet;
import java.util.Set;

import org.kasource.commons.validation.AbstractValidator;
import org.kasource.commons.validation.enumeration.Enumeration;

public abstract class AbstractEnumerationValidator extends AbstractValidator {
    private static final int CONSTANT_TRUNCATE_LIMIT = 20;
    private Class<? extends Enum<?>> enumClass;
    private Set<String> values = new HashSet<String>(); 
    protected String message;
    private boolean caseSensetive;
    
    protected void initialize(final Enumeration enumeration) {
        enumClass = enumeration.value();
        caseSensetive = enumeration.caseSensetive();
        
        Object[] constants = enumClass.getEnumConstants();
        // TODO: Truncate if too many constants
        if (constants.length > CONSTANT_TRUNCATE_LIMIT) {
            
        }
        for (Object constant : constants) {
            values.add(constant.toString());
        }
        message = values.toString();
    }
    
    @Override
    protected boolean isValid(Object value) {      
        if (value == null) {
            return true;
        }
        boolean isValid = false;
        if (!caseSensetive) {
            isValid = values.contains(value.toString().toUpperCase());
        } else {
            isValid = values.contains(value.toString());
        }
       
        return isValid;
       
    }
}
