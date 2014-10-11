package org.kasource.validation.xml;

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

import org.kasource.validation.xml.impl.ArrayJaxbValidator;
import org.kasource.validation.xml.impl.IterableJaxbValidator;
import org.kasource.validation.xml.impl.JaxbValidator;
import org.kasource.validation.xml.impl.UriJaxbValidator;
import org.kasource.validation.xml.impl.UrlJaxbValidator;

@Documented
@Retention(RUNTIME)
@Target({METHOD, FIELD, CONSTRUCTOR, PARAMETER, ANNOTATION_TYPE})
@Constraint(validatedBy = {JaxbValidator.class,
                           UriJaxbValidator.class,
                           UrlJaxbValidator.class,
                           ArrayJaxbValidator.class,
                           IterableJaxbValidator.class})
public @interface Jaxb {
    String message() default "{org.kasource.validation.xml.Jaxb}";
    
    Class<?> value();  
    
    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
