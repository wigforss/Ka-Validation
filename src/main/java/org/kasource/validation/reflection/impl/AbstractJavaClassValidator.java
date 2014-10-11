package org.kasource.validation.reflection.impl;

import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.reflection.JavaClass;

public abstract class AbstractJavaClassValidator extends AbstractClassValidator {
    private JavaClass annotation;
    
    
    protected void initialize(JavaClass annotation) {
       this.annotation = annotation;
    }
    
    @Override
    protected boolean isValid(Object object) {
        if (object == null) {
            return true;
        }
        Class<?> clazz = getClass(object);
        if (clazz != null) {
            return matchClassType(clazz);
        }
        return false;
    }
     
    private boolean matchClassType(Class<?> clazz) {        
        return annotation.value().getClassFilter().passFilter(clazz);
    }
    
    protected void setConstraintMessage(ConstraintValidatorContext context) {   
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate("{" + annotation.value().getMessageKey() + "}").addConstraintViolation();     
    }
}
