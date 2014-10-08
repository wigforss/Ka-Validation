package org.kasource.validation.enumeration.impl;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang.StringUtils;
import org.kasource.validation.AbstractValidator;
import org.kasource.validation.enumeration.Enumeration;

public abstract class AbstractEnumerationValidator extends AbstractValidator {
    private static final int MAX_MESSAGE_LENGTH = 100;
    private Class<? extends Enum<?>> enumClass;
    private List<String> values = new LinkedList<String>(); 
    protected String message;
    private boolean caseSensetive;
    private String enumMessageKey;
    
    protected void initialize(final Enumeration enumeration) {
        enumClass = enumeration.value();
        caseSensetive = enumeration.caseSensetive();
        enumMessageKey = enumeration.enumMessageKey();
        Object[] constants = enumClass.getEnumConstants();
       
        for (Object constant : constants) {
            values.add(constant.toString());
        }
        message = values.toString();
        message = message.substring(1, message.length() - 1);
        message = StringUtils.abbreviate(message, MAX_MESSAGE_LENGTH);
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
    
    protected void setConstraintMessage(ConstraintValidatorContext context) {
        String enumName = enumClass.getSimpleName();
        if (!enumMessageKey.isEmpty()) {
            enumName = "{"+enumMessageKey+"}";
        }
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate("{org.kasource.validation.enumeration.Enumeration} " + enumName + ", {validation.message.valid.values} [" + message + "]").addConstraintViolation();
        
    }
}
