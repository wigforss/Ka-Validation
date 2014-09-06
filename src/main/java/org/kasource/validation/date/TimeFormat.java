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

import javax.validation.Constraint;

import org.kasource.validation.date.impl.ArrayTimeValidator;
import org.kasource.validation.date.impl.IterableTimeValidator;
import org.kasource.validation.date.impl.TimeValidator;

/**
 * Validates that values can be parsed into time by a supplied date pattern.
 * <p>
 * The time pattern is default set to HH:mm:ss and can be changed by setting 
 * the <b>value</b> attribute. 
 * <p>
 *  <pre>@Date("h:mm a")</pre>
 * <p>
 * This validator uses patterns from java.text.SimpleDateFormat to verify the input.
 * <p>
 * This annotation can validate the following types: String, Iterable<? extends Object> and Object[].
 * 
 * @author rikardwi
 **/
@Documented
@Retention(RUNTIME)
@Target({METHOD, FIELD, CONSTRUCTOR, PARAMETER, ANNOTATION_TYPE})
@Constraint(validatedBy = {TimeValidator.class, 
                           ArrayTimeValidator.class, 
                           IterableTimeValidator.class})
public @interface TimeFormat {
    String message() default "{validation.message.timeformat}";

    /** Time Pattern from java.text.SimpleDateFormat **/
    String value() default "HH:mm:ss";
    
    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
