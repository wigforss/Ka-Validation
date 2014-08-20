package org.kasource.commons.validation.locale;

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

import org.kasource.commons.validation.locale.impl.ArrayLanguageValidator;
import org.kasource.commons.validation.locale.impl.IterableLanguageValidator;
import org.kasource.commons.validation.locale.impl.LanguageValidator;


@Documented
@Retention(RUNTIME)
@Target({METHOD, FIELD, CONSTRUCTOR, PARAMETER, ANNOTATION_TYPE})
@Constraint(validatedBy = {LanguageValidator.class, 
                           ArrayLanguageValidator.class,
                           IterableLanguageValidator.class})
public @interface Language {
    String message() default "is not a valid email address";

    boolean caseSensetive() default false;
    
    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}