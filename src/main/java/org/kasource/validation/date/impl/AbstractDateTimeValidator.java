package org.kasource.validation.date.impl;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.kasource.validation.AbstractValidator;

public abstract class AbstractDateTimeValidator extends AbstractValidator {
    
    private String pattern;
   
    
    protected void initialize(String pattern) {
        this.pattern = pattern;
    }
    
    
    protected Date getDate(Object value) {
        if (value instanceof Date) {
            return (Date) value;
        } else if (value instanceof Calendar) {
            return ((Calendar) value).getTime();
        } else if (value instanceof Long) { 
            return new Date(((Long) value).longValue());
        } else {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            df.setLenient(false);
            ParsePosition pos = new ParsePosition(0);
            Date result = df.parse(value.toString(), pos);
            if (result == null || pos.getErrorIndex() >= 0) {
                return null;
            }
            if (pos.getIndex() != value.toString().length()) {
                return null;
            }
            return result;
        }
    }
    
  
    
    @Override
    protected boolean isValid(Object value) {
        if (value == null) {
            return true;
        }
        Date date = getDate(value); 
        return (date != null);
    }
    
    
   
}
