package org.kasource.validation.reflection;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;

import org.kasource.validation.reflection.impl.AnnotatedClassValidator;
import org.kasource.validation.reflection.impl.ArrayAnnotatedClassValidator;
import org.kasource.validation.reflection.impl.ClassAnnotatedClassValidator;
import org.kasource.validation.reflection.impl.IterableAnnotatedClassValidator;


@Documented
@Retention(RUNTIME)
@Target({METHOD, FIELD, CONSTRUCTOR, PARAMETER, ANNOTATION_TYPE})
@Constraint(validatedBy = {AnnotatedClassValidator.class,
                            ClassAnnotatedClassValidator.class,
                            ArrayAnnotatedClassValidator.class,
                            IterableAnnotatedClassValidator.class})
public @interface AnnotatedClass {
    String message() default "{org.kasource.validation.reflection.AnnotatedClass}";

    Class<? extends Annotation>[] value();
    
    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
