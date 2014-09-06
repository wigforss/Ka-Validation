package org.kasource.validation.date.impl;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.kasource.validation.AbstractValidator;

public abstract class AbstractDateTimeValidator extends AbstractValidator {
    private static final int[] TIME_PARTS = {Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND, Calendar.MILLISECOND};
    
    private String pattern;
    private boolean checkrange; 
    private int offset;
    private int before;
    private int after;
    private TimeUnit timeUnit;
    private boolean ignoreTimePart;
    
    protected void initialize(String pattern, boolean checkrange, int offset, int before, int after, TimeUnit timeUnit, boolean ignoreTimePart) {
        this.pattern = pattern;
        this.checkrange = checkrange;
        this.offset = offset;
        this.before = before;
        this.after = after;
        this.timeUnit = timeUnit;
        this.ignoreTimePart = ignoreTimePart;
    }
    
    protected void initialize(String pattern) {
        this.pattern = pattern;
    }
    
    
    protected Date getDate(Object value) {
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
    
  
    
    @Override
    protected boolean isValid(Object value) {
        if (value == null) {
            return true;
        }
        Date date = getDate(value);
        
        if (date != null &&  checkrange) {
            Calendar[] range = getRange();
            if (date.getTime() >= range[0].getTimeInMillis()
                        && date.getTime() <= range[1].getTimeInMillis()) {
                return true;
            } else {
                return false;
            }
           
        }
        
        return (date != null);
    }
    
    
    private Calendar[] getRange() {
        Calendar offsetCal = Calendar.getInstance();
        if (ignoreTimePart) {
            removeTime(offsetCal);
        }
        offsetCal.add(Calendar.SECOND, (int) TimeUnit.SECONDS.convert(offset, timeUnit));
        Calendar from = Calendar.getInstance();
        from.setTime(offsetCal.getTime());
        from.add(Calendar.DAY_OF_YEAR, (int) -TimeUnit.SECONDS.convert(before, timeUnit));
        Calendar to = Calendar.getInstance();
        to.setTime(offsetCal.getTime());
        to.add(Calendar.DAY_OF_YEAR, (int) TimeUnit.SECONDS.convert(after, timeUnit));
        return new Calendar[]{from, to};
    }
    
    private void removeTime(Calendar cal) {
        for (int timePart : TIME_PARTS) {
            cal.set(timePart, 0);
        }          
    }
}
