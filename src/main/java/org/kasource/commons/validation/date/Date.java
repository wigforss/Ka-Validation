package org.kasource.commons.validation.date;

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

import org.kasource.commons.validation.date.impl.ArrayDateValidator;
import org.kasource.commons.validation.date.impl.DateValidator;
import org.kasource.commons.validation.date.impl.IterableDateValidator;

/**
 * Validates that values can be parsed into date by a supplied date pattern.
 * <p>
 * The date pattern is default set to yyyy-MM-dd and can be changed by setting 
 * the <b>value</b> attribute. 
 * <p>
 *  <pre>@Date("dd/MM/yyyy")</pre>
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
@Constraint(validatedBy = {DateValidator.class,
                          ArrayDateValidator.class,
                          IterableDateValidator.class})
public @interface Date {
    String message() default "is not a valid date";

    /** Date Pattern from java.text.SimpleDateFormat **/
    String value() default "yyyy-MM-dd";
    
    boolean allowLocalAddresses() default false;
    
    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
