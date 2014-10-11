package org.kasource.validation.reflection.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.reflection.JavaClass;

public class ClassJavaClassValidator extends AbstractJavaClassValidator implements ConstraintValidator<JavaClass, Class<?>>{

    @Override
    public void initialize(JavaClass annotation) {
        super.initialize(annotation); 
     }
    
    @Override
    public boolean isValid(Class<?> value, ConstraintValidatorContext context) {      
        boolean isValid = isValid(value);
        if (!isValid) {
            setConstraintMessage(context);
        }
        return isValid;
    }

}
