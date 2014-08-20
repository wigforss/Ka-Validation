package org.kasource.commons.validation.checkdigit;

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

import org.kasource.commons.validation.checkdigit.impl.ArrayCheckdigitValidator;
import org.kasource.commons.validation.checkdigit.impl.CheckdigitValidator;
import org.kasource.commons.validation.checkdigit.impl.IterableCheckdigitValidator;
import org.kasource.commons.validation.checkdigit.impl.NumberCheckdigitValidator;

/**
 * Validate that the value has a valid check digit according the 
 * selected algorithm.
 * <p>
 * Use the attribute <b>separators</b> to configure which separators that's allowed, default is space( ), dash(-) and slash(/)
 * <p>
 * Set the attribute <b>allowSeparators</b> to false if no separators should be allowed.
 * <p>
 * The attributes <b>prefixLength</b> and <b>suffixLength</b> can be used to ignore a number of characters as a
 * prefix and or suffix.
 * <p>
 * This annotation can validate the following types:
 * <ul> 
 *   <li>String</li>
 *   <li>Short</li>
 *   <li>Integer</li> 
 *   <li>Long</li>
 *   <li>BigInteger</li>
 *   <li>Iterable&lt;? extends Object&gt;</pre></li>
 *   <li>Object[]</li>
 * </ul>
 * @author rikardwi
 **/
@Documented
@Retention(RUNTIME)
@Target({METHOD, FIELD, CONSTRUCTOR, PARAMETER, ANNOTATION_TYPE})
@Constraint(validatedBy = {CheckdigitValidator.class, 
                           NumberCheckdigitValidator.class,
                           ArrayCheckdigitValidator.class,
                           IterableCheckdigitValidator.class})
public @interface Checkdigit {
    String message() default "is not a valid code";

    Algorithm value();
    
    String[] separators() default {"-", " ", "/"};
    
    boolean allowSeparators() default true;
    
    int prefixLength() default 0;
    
    int suffixLength() default 0;
    
    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
