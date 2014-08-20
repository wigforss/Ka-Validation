package org.kasource.commons.validation.reflection.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.commons.validation.reflection.JavaClass;

public class IterableJavaClassValidator extends AbstractJavaClassValidator implements ConstraintValidator<JavaClass, Iterable<? extends Object> >{

    @Override
    public void initialize(JavaClass annotation) {
        super.initialize(annotation); 
     }
    
    @Override
    public boolean isValid(Iterable<? extends Object>  value, ConstraintValidatorContext context) {      
        return isValid(value);
    }

}
