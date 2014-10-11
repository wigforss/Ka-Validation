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

import org.kasource.validation.reflection.impl.ArrayJavaClassValidator;
import org.kasource.validation.reflection.impl.ClassJavaClassValidator;
import org.kasource.validation.reflection.impl.IterableJavaClassValidator;
import org.kasource.validation.reflection.impl.JavaClassValidator;


@Documented
@Retention(RUNTIME)
@Target({METHOD, FIELD, CONSTRUCTOR, PARAMETER, ANNOTATION_TYPE})
@Constraint(validatedBy = {JavaClassValidator.class,
                            ClassJavaClassValidator.class,
                            ArrayJavaClassValidator.class,
                            IterableJavaClassValidator.class})
public @interface JavaClass {
    String message() default "{org.kasource.validation.reflection.JavaClassType.ANY}";

    JavaClassType value() default JavaClassType.ANY;
    
    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
