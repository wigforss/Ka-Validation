package org.kasource.commons.validation.date.impl;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.kasource.commons.validation.AbstractValidator;

public abstract class AbstractDateTimeValidator extends AbstractValidator {
    private String pattern;
    
    protected void initialize(String pattern) {
        this.pattern = pattern;
    }
    
    @Override
    protected boolean isValid(Object value) {
        if (value == null) {
            return true;
        }
      
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        df.setLenient(false);
        ParsePosition pos = new ParsePosition(0);
        Date result = df.parse(value.toString(), pos);
        if (result == null || pos.getErrorIndex() >= 0) {
            return false;
        }
        if (pos.getIndex() != value.toString().length()) {
            return false;
        }
        return true;
        
    }
}
