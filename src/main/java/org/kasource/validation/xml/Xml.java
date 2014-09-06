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

import org.kasource.validation.DataLocationType;
import org.kasource.validation.xml.impl.ArrayXmlValidator;
import org.kasource.validation.xml.impl.IterableXmlValidator;
import org.kasource.validation.xml.impl.UriXmlValidator;
import org.kasource.validation.xml.impl.UrlXmlValidator;
import org.kasource.validation.xml.impl.XmlValidator;

@Documented
@Retention(RUNTIME)
@Target({METHOD, FIELD, CONSTRUCTOR, PARAMETER, ANNOTATION_TYPE})
@Constraint(validatedBy = {XmlValidator.class,
                           UrlXmlValidator.class,
                           UriXmlValidator.class,
                           ArrayXmlValidator.class,
                           IterableXmlValidator.class})
public @interface Xml {
String message() default "{validation.message.xml}";
    
    String schemaLocation() default "";
    
    DataLocationType schemaLocationType() default DataLocationType.UNKNOWN;
    
    DataLocationType value() default DataLocationType.INLINE;
    
    boolean isLocation() default false;
    
    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
