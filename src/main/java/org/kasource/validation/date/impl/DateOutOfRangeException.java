package org.kasource.validation.date.impl;

import java.util.Calendar;

public class DateOutOfRangeException extends RuntimeException {
  
    private static final long serialVersionUID = 1L;
    private final Calendar[] range;
    
    public DateOutOfRangeException(Calendar[] range) {
        super("Date is out of range");
        this.range = range;
    }

    /**
     * @return the range
     */
    public Calendar[] getRange() {
        return range;
    }
}
