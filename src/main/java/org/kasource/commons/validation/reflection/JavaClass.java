package org.kasource.commons.validation.reflection;

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

import org.kasource.commons.reflection.Modifier;
import org.kasource.commons.validation.reflection.impl.ArrayJavaClassValidator;
import org.kasource.commons.validation.reflection.impl.ClassJavaClassValidator;
import org.kasource.commons.validation.reflection.impl.IterableJavaClassValidator;
import org.kasource.commons.validation.reflection.impl.JavaClassValidator;


@Documented
@Retention(RUNTIME)
@Target({METHOD, FIELD, CONSTRUCTOR, PARAMETER, ANNOTATION_TYPE})
@Constraint(validatedBy = {JavaClassValidator.class,
                            ClassJavaClassValidator.class,
                            ArrayJavaClassValidator.class,
                            IterableJavaClassValidator.class})
public @interface JavaClass {
    String message() default "is not a valid java class";

    JavaClassType value() default JavaClassType.ANY;
    Modifier[] hasModifier() default {};
    Class<?>[] implementsInterface() default {};
    Class<? extends Annotation>[] hasAnnotation() default {};
    /** is super class of **/
    Class<?>[] assignableFrom() default {};
    /** extends or implements **/
    Class<?>[] assignableTo() default {};
    
    String[] fields() default {};
    Class<?> superClass() default JavaClass.class;
    
    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
