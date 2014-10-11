package org.kasource.validation.url;

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

import org.kasource.validation.url.impl.ArrayUrlValidator;
import org.kasource.validation.url.impl.IterableUrlValidator;
import org.kasource.validation.url.impl.URIUrlValidator;
import org.kasource.validation.url.impl.URLUrlValidator;
import org.kasource.validation.url.impl.UrlValidator;


@Documented
@Retention(RUNTIME)
@Target({METHOD, FIELD, CONSTRUCTOR, PARAMETER, ANNOTATION_TYPE})
@Constraint(validatedBy = {UrlValidator.class, 
                          URLUrlValidator.class, 
                          URIUrlValidator.class, 
                          ArrayUrlValidator.class, 
                          IterableUrlValidator.class})
public @interface Url {
    String message() default "{org.kasource.validation.url.Url}";

    /** schemas to allow. For example http. Default is all supported schemas **/
    String[] value() default {};
    
    
    /** Allow two slashes in the path component of the URL.*/
    boolean allowTwoSlahes() default true;
   
    /** Allow local URLs, such as http://localhost/ or http://machine/ .**/
    boolean allowLocalUrls() default true;

    boolean allowFragments() default true;
    
    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
