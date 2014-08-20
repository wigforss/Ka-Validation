package org.kasource.commons.validation.file;

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

import org.kasource.commons.validation.file.impl.ArrayFileValidator;
import org.kasource.commons.validation.file.impl.FileValidator;
import org.kasource.commons.validation.file.impl.IterableFileValidator;

@Documented
@Retention(RUNTIME)
@Target({METHOD, FIELD, CONSTRUCTOR, PARAMETER, ANNOTATION_TYPE})
@Constraint(validatedBy = {FileValidator.class,
                           ArrayFileValidator.class,
                           IterableFileValidator.class})
public @interface File {
    String message() default "is not a valid file";
    
    FileOperation[] value();
 
    
    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
