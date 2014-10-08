package org.kasource.validation.date;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

import javax.validation.Constraint;

import org.kasource.validation.date.impl.ArrayDateRangeValidator;
import org.kasource.validation.date.impl.CalendarDateRangeValidator;
import org.kasource.validation.date.impl.DateDateRangeValidator;
import org.kasource.validation.date.impl.DateRangeValidator;
import org.kasource.validation.date.impl.IterableDateRangeValidator;
import org.kasource.validation.date.impl.LongDateRangeValidator;

/**
 * Validates that value(s) can be parsed (if not java.util.Date or java.util.Calendar). Checks that
 * the value is within the specified date range relative from the current time stamp. Default settings will be
 * validating against Today.
 * <p>
 * The date pattern is default set to yyyy-MM-dd and can be changed by setting 
 * the <b>value</b> attribute. 
 * <p>
 *  <pre>@DateRange("dd/MM/yyyy h:mm:ss a")</pre>
 * <p>
 * This validator uses patterns from java.text.SimpleDateFormat to parse the input.
 * <p>
 * The <b>offset</b> offset is used to specify an offset from current time stamp in timeUnit units.
 * <p>
 * The <b>before</b> attribute specifies the number of timeUnit for the start of range, which is current time stamp + offset - before;
 * <p>
 * The <b>after</b> attribute specifies the number of timeUnit for the end of the range, which is current time stamp + offset + after;
 * <p>
 * The <b>timeUnit</b> attribute specifies the time unit for offset, before and after, default is DAYS.
 * <p>
 *  Set the <b>ignoreTimePart</b> attribute to ignore the time part when evaluating range.
 *  <p>
 *  <b>Examples</b>
 *   <p>
 *      <pre>@DateRange(offset = 1, after = Integer.MAX)</pre>
 *   <p>
 *   The value should be a future date (not including today).
 *   <p>
 *  <pre>@DateRange(before = 7, after = 7)</pre>
 *  <p>
 *  The value should be at least 7 days before today and at most 7 days into the future. 
 *  <p>
 * This annotation can validate the following types: String, java.util.Date, java.util.Calendar, Iterable<? extends Object> and Object[].
 * 
 * @author rikardwi
 **/
@Documented
@Retention(RUNTIME)
@Target({METHOD, FIELD, CONSTRUCTOR, PARAMETER, ANNOTATION_TYPE})
@Constraint(validatedBy = {DateRangeValidator.class, 
                           DateDateRangeValidator.class, 
                           CalendarDateRangeValidator.class, 
                           LongDateRangeValidator.class, 
                           ArrayDateRangeValidator.class, 
                           IterableDateRangeValidator.class})
public @interface DateRange {
    String message() default "{org.kasource.validation.date.DateRange}";
    
    /** 
     * Parse Date and/or Time Pattern, from java.text.SimpleDateFormat 
     * Ignore if value is java.util.Date or java.util.Calendar 
     **/
    String value() default "yyyy-MM-dd";
    
    /**
     * an offset from current time stamp in timeUnit units
     */
    int offset() default 0;
    
    /**
     *  number of timeUnit before offset + current time stamp to set as lower bound.
     */
    int before() default 0;
    
    /**
     *  number of timeUnit after offset + current time stamp to set as upper bound.
     */
    int after() default 0;
    
    /**
     * time unit for offset, before and after, default is DAYS. MICROSECONDS is not allowed.
     */
    TimeUnit timeUnit() default TimeUnit.DAYS;
    
    /**
     * true to ignore the time part when evaluating range, default is true.
     */
    boolean ignoreTimePart() default true;
    
    /**
     * Date pattern used when formatting date in validation error messages.
     */
    String messageDatePattern() default "yyyy-MM-dd";
    
    /**
     * Time pattern used when formatting date in validation error messages.
     */
    String messageTimePattern() default "HH:mm:ss";
    
    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
