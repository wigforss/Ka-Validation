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

import org.kasource.validation.xml.impl.ArrayXmlValidator;
import org.kasource.validation.xml.impl.IterableXmlValidator;
import org.kasource.validation.xml.impl.UriXmlValidator;
import org.kasource.validation.xml.impl.UrlXmlValidator;
import org.kasource.validation.xml.impl.XmlValidator;

/**
 * Validate that the value is a valid XML.
 * 
 * If the attribute schemaLocation is set or if the XML contains a schemaLocation attribute the 
 * XML will be validated against the referenced XML Schema (XSD). If schema reference or the schema
 * itself is invalid, the XML is regarded as invalid.
 * 
 * Value might be a String of XML data as well as:
 * <p>
 * <ul>
 *  <li><b>URL reference</b> to the XML to validate like http:// or file://</li>
 *  <li><b>Class path reference</b> to the XML file to validate, with the <b>classpath:</b> prefix
 *  <li><b>File reference</b> to the XML file to validate, with the <b>file:</b> prefix
 *  <li></li>
 * </ul>
 * 
 * @author rikardwi
 **/
@Documented
@Retention(RUNTIME)
@Target({METHOD, FIELD, CONSTRUCTOR, PARAMETER, ANNOTATION_TYPE})
@Constraint(validatedBy = {XmlValidator.class,
                           UrlXmlValidator.class,
                           UriXmlValidator.class,
                           ArrayXmlValidator.class,
                           IterableXmlValidator.class})
public @interface Xml {
    String message() default "{org.kasource.validation.xml.Xml}";
    
    String[] schemaLocation() default {};
     
    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
