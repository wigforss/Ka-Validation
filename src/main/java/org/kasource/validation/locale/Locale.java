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

/**
 * Validates Locale string of language and country separated by underscore.
 * 
 * The locale string consists of a ISO 639 alpha 2 language followed by an underscore and then a
 * ISO 3166 alpha-2 country code. Example en_GB for English in Great Britain.
 * 
 * @author rikardwi
 **/
@Documented
@Retention(RUNTIME)
@Target({METHOD, FIELD, CONSTRUCTOR, PARAMETER, ANNOTATION_TYPE})
@Constraint(validatedBy = {LocaleValidator.class, 
                           IterableLocaleValidator.class, 
                           ArrayLocaleValidator.class})
public @interface Locale {
    String message() default "{org.kasource.validation.locale.Locale}";

    boolean caseSensetive() default true;
    
    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
