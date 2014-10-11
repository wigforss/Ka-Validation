package org.kasource.validation.reflection.impl;

import org.kasource.validation.reflection.ExtendsClass;

public abstract class AbstractExtendsClassValidator extends AbstractClassValidator {
 private ExtendsClass annotation;
    
    
    protected void initialize(ExtendsClass annotation) {
       this.annotation = annotation;
    }
    
    @Override
    protected boolean isValid(Object object) {
        if (object == null) {
            return true;
        }
        Class<?> clazz = getClass(object);
        if (clazz != null) {
            return isAssignableTo(clazz);
        }
        return false;
    }
    
    private boolean isAssignableTo(Class<?> clazz) {
        for (Class<?> assignableClass : annotation.value()) {
            if (!assignableClass.isAssignableFrom(clazz)) {
                return false;
            }
        }
        return true;
    }
}
