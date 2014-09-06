package org.kasource.validation.uuid;

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

import org.kasource.validation.uuid.impl.ArrayUuidValidator;
import org.kasource.validation.uuid.impl.IterableUuidValidator;
import org.kasource.validation.uuid.impl.UuidValidator;


@Documented
@Retention(RUNTIME)
@Target({METHOD, FIELD, CONSTRUCTOR, PARAMETER, ANNOTATION_TYPE})
@Constraint(validatedBy = {UuidValidator.class, 
                           ArrayUuidValidator.class,
                          IterableUuidValidator.class})
public @interface Uuid {
    
    String message() default "{validation.message.uuid}";

    boolean lowercase() default true;
    
    boolean useDashes() default true;
    
    boolean ignoreCase() default false;
    
    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
