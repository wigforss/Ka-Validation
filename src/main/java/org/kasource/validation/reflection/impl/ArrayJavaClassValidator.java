package org.kasource.validation.reflection.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.reflection.JavaClass;

public class ArrayJavaClassValidator extends AbstractJavaClassValidator implements ConstraintValidator<JavaClass, Object[]>{

    @Override
    public void initialize(JavaClass annotation) {
        super.initialize(annotation); 
     }
    
    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {      
        boolean isValid = isValidArray(value);
        if (!isValid) {
            setConstraintMessage(context);
        }
        return isValid;
    }

}
