package org.kasource.validation.creditcard;

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

import org.kasource.validation.creditcard.impl.ArrayCreditCardValidator;
import org.kasource.validation.creditcard.impl.CreditCardValidator;
import org.kasource.validation.creditcard.impl.IterableCreditCardValidator;


/**
 * Validates credit card numbers.
 * <p>
 * Supports: <ul>
 * <li>Visa</li>
 * <li>Master Card</li>
 * <li>American Express</li>
 * <li>Diners</li>
 * <li>Discover</li>
 * </ul>
 * <p>
 * To limit what card types to allow, set the <b>value</b> to the allowed card types:
 * <p>
 * <pre>@CreditCard(CardType.VISA, CardType.MASTER_CARD)</pre> for only Visa and Master Card.
 * <p>
 * This annotation can validate the following types: String, Iterable<? extends Object> and Object[].
 * @author rikardwi
 **/
@Documented
@Retention(RUNTIME)
@Target({METHOD, FIELD, CONSTRUCTOR, PARAMETER, ANNOTATION_TYPE})
@Constraint(validatedBy = {CreditCardValidator.class, 
                           ArrayCreditCardValidator.class, 
                           IterableCreditCardValidator.class})
public @interface CreditCard {
    
    CardType[] value() default {};
    
    String message() default  "{org.kasource.validation.creditcard.CreditCard}";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
