package org.kasource.validation.reflection;

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

import org.kasource.validation.reflection.impl.ArrayExtendsClassValidator;
import org.kasource.validation.reflection.impl.ClassExtendsClassValidator;
import org.kasource.validation.reflection.impl.ExtendsClassValidator;
import org.kasource.validation.reflection.impl.IterableExtendsClassValidator;


@Documented
@Retention(RUNTIME)
@Target({METHOD, FIELD, CONSTRUCTOR, PARAMETER, ANNOTATION_TYPE})
@Constraint(validatedBy = {ExtendsClassValidator.class,
                            ClassExtendsClassValidator.class,
                            ArrayExtendsClassValidator.class,
                            IterableExtendsClassValidator.class})
public @interface ExtendsClass {
    String message() default "{org.kasource.validation.reflection.ExtendsClass}";

    /** extends or implements **/
    Class<?>[] value();
    
    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
