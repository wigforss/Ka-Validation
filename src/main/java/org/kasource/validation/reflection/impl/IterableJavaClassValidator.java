package org.kasource.validation.reflection.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.reflection.JavaClass;

public class IterableJavaClassValidator extends AbstractJavaClassValidator implements ConstraintValidator<JavaClass, Iterable<? extends Object> >{

    @Override
    public void initialize(JavaClass annotation) {
        super.initialize(annotation); 
     }
    
    @Override
    public boolean isValid(Iterable<? extends Object>  value, ConstraintValidatorContext context) {      
        boolean isValid = isValidItarable(value);
        if (!isValid) {
            setConstraintMessage(context);
        }
        return isValid;
    }

}
