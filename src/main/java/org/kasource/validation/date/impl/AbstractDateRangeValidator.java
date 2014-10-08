package org.kasource.validation.date.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.date.DateRange;

public class AbstractDateRangeValidator extends AbstractDateTimeValidator {
    private static final int[] TIME_PARTS = {Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND, Calendar.MILLISECOND};
    
    private String pattern;
    private int offset;
    private int before;
    private int after;
    private TimeUnit timeUnit;
    private boolean ignoreTimePart;
    private String messageDatePattern;
    private String messageTimePattern;
    
    protected void initialize(DateRange annotation) {
        super.initialize(annotation.value());
        this.pattern = annotation.value();
        this.offset = annotation.offset();
        this.before = annotation.before();
        this.after = annotation.after();
        this.timeUnit = annotation.timeUnit();
        this.ignoreTimePart = annotation.ignoreTimePart();
        this.messageDatePattern = annotation.messageDatePattern();
        this.messageTimePattern = annotation.messageTimePattern();
    }
    
    
    @Override
    protected boolean isValid(Object value) {
        if (value == null) {
            return true;
        }
        Date date = getDate(value);
       
        if (date != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            if (ignoreTimePart) {
                removeTime(cal);
            }
            Calendar[] range = getRange();
            if (cal.getTimeInMillis() >= range[0].getTimeInMillis()
                        && cal.getTimeInMillis() <= range[1].getTimeInMillis()) {
                return true;
            } else {
                throw new DateOutOfRangeException(range);
            }
           
        }
        
        return (date != null);
    }
    
    private Calendar[] getRange() {
        Calendar offsetCal = Calendar.getInstance();
        if (ignoreTimePart) {
            removeTime(offsetCal);
        }
        offsetCal.add(getTimePart(timeUnit), offset);
        Calendar from = Calendar.getInstance();
        from.setTime(offsetCal.getTime());
        from.add(getTimePart(timeUnit), -before);
        Calendar to = Calendar.getInstance();
        to.setTime(offsetCal.getTime());
        to.add(getTimePart(timeUnit), after);
        return new Calendar[]{from, to};
    }
    
    private int getTimePart(TimeUnit timeUnit) {
        switch(timeUnit) {
        case DAYS:
            return Calendar.DAY_OF_YEAR;
        case HOURS:
            return Calendar.HOUR_OF_DAY;
        case MINUTES:
            return Calendar.MINUTE;
        case SECONDS:
            return Calendar.SECOND;
        case MILLISECONDS:
            return Calendar.MILLISECOND;
        default:
            throw new IllegalArgumentException(timeUnit.name() + " is not supported");
        }
    }
    
    private void removeTime(Calendar cal) {
        for (int timePart : TIME_PARTS) {
            cal.set(timePart, 0);
        }          
    }
    
    protected void setConstraintMessage(ConstraintValidatorContext context, Calendar[] range) {
         String suffix = "alt";
         String dateFormat = messageDatePattern;
         if (!ignoreTimePart) {
             dateFormat += " " + messageTimePattern;
         }
         String fromDate = new SimpleDateFormat(dateFormat).format(range[0].getTime());
         String toDate = new SimpleDateFormat(dateFormat).format(range[1].getTime());
         if (range[0].equals(range[1])) {
             suffix += ".one";
             context.disableDefaultConstraintViolation();
             context.buildConstraintViolationWithTemplate("{org.kasource.validation.date.DateRange."+suffix+"}" + " " + fromDate)
                    .addConstraintViolation();
         } else if (before == Integer.MAX_VALUE) {
             suffix += ".lesser";
             context.disableDefaultConstraintViolation();
             context.buildConstraintViolationWithTemplate("{org.kasource.validation.date.DateRange."+suffix+"}" + " " + toDate)
                    .addConstraintViolation();
         } else if (after == Integer.MAX_VALUE) {
             suffix += ".greater";
             context.disableDefaultConstraintViolation();
             context.buildConstraintViolationWithTemplate("{org.kasource.validation.date.DateRange."+suffix+"}" + " " + fromDate)
                    .addConstraintViolation();
         } else {
             suffix += ".range";
             context.disableDefaultConstraintViolation();
             context.buildConstraintViolationWithTemplate("{org.kasource.validation.date.DateRange."+suffix+"}" + " " + fromDate + " " + "{validation.message.and}" + " " + toDate)
                    .addConstraintViolation();
         }
         
         
        
        
    }
}
