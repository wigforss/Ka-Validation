package org.kasource.commons.validation.reflection.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.commons.validation.reflection.JavaClass;

public class JavaClassValidator extends AbstractJavaClassValidator implements ConstraintValidator<JavaClass, String>{

    @Override
    public void initialize(JavaClass annotation) {
        super.initialize(annotation); 
     }
    
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {      
        return isValid(value);
    }

}
