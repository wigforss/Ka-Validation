package org.kasource.commons.validation.ip;

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

import org.kasource.commons.validation.ip.impl.ArrayIpAddressValidator;
import org.kasource.commons.validation.ip.impl.IpAddressValidator;
import org.kasource.commons.validation.ip.impl.ItarbleIpAddressValidator;

/**
 * Validates IP Addresses, either both IP v4 and IP v6 or only IP v4, default is both. 
 * 
 * To restrict the validation to only IP v4 set the <b>ip4Only</b> attribute to true.
 * 
 * This annotation can validate the following types: String, Iterable<? extends Object> and Object[].
 * 
 * @author rikardwi
 **/
@Documented
@Retention(RUNTIME)
@Target({METHOD, FIELD, CONSTRUCTOR, PARAMETER, ANNOTATION_TYPE})
@Constraint(validatedBy = {IpAddressValidator.class,
                           ArrayIpAddressValidator.class,
                           ItarbleIpAddressValidator.class})
public @interface IpAddress {
    String message() default "is not a valid IP address";

    /** Set to true to restrict to only IP v4 addresses **/
    boolean ip4Only() default false;
    
    Class<?>[] groups() default {};

    Class<?>[] payload() default {};

}
