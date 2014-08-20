package org.kasource.commons.validation.uuid.impl;

import org.kasource.commons.validation.AbstractValidator;
import org.kasource.commons.validation.uuid.Uuid;

public abstract class AbstractUuidValidator extends AbstractValidator {
    private static final String LOWERCASE_DASHES = "^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$";
    private static final String LOWERCASE_NO_DASHES = "^[0-9a-f]{8}[0-9a-f]{4}[0-9a-f]{4}[0-9a-f]{4}[0-9a-f]{12}$";
    private static final String UPPERCASE_DASHES = "^[0-9A-F]{8}-[0-9A-F]{4}-[0-9A-F]{4}-[0-9A-F]{4}-[0-9A-F]{12}$";
    private static final String UPPERCASE_NO_DASHED = "^[0-9A-F]{8}[0-9A-F]{4}[0-9A-F]{4}[0-9A-F]{4}[0-9A-F]{12}$";
   
    private String regExp;
    private boolean ignoreCase;
    
    
    protected void initialize(Uuid annotation) {
       ignoreCase = annotation.ignoreCase();
       if (ignoreCase || annotation.lowercase()) {
           if (annotation.useDashes()) {
               regExp = LOWERCASE_DASHES;
           } else {
               regExp = LOWERCASE_NO_DASHES;
           }
       } else {
           if (annotation.useDashes()) {
               regExp = UPPERCASE_DASHES;
           } else {
               regExp = UPPERCASE_NO_DASHED;
           } 
       }
    }

    @Override
    protected boolean isValid(Object value) {
        if (value == null) {
            return true;
        }
       
        if (ignoreCase) {
           return value.toString().toLowerCase().matches(regExp);
        } else {
            return value.toString().matches(regExp);
        }
    }

}
