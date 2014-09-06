package org.kasource.validation.locale;

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

import org.kasource.validation.locale.impl.ArrayLocaleValidator;
import org.kasource.validation.locale.impl.IterableLocaleValidator;
import org.kasource.validation.locale.impl.LocaleValidator;


@Documented
@Retention(RUNTIME)
@Target({METHOD, FIELD, CONSTRUCTOR, PARAMETER, ANNOTATION_TYPE})
@Constraint(validatedBy = {LocaleValidator.class, 
                           IterableLocaleValidator.class, 
                           ArrayLocaleValidator.class})
public @interface Locale {
    String message() default "{validation.message.locale}";

    boolean caseSensetive() default true;
    
    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
