package org.kasource.commons.validation.reflection.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.commons.validation.reflection.JavaClass;

public class ArrayJavaClassValidator extends AbstractJavaClassValidator implements ConstraintValidator<JavaClass, Object[]>{

    @Override
    public void initialize(JavaClass annotation) {
        super.initialize(annotation); 
     }
    
    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {      
        return isValidArray(value);
    }

}
