package org.kasource.validation.reflection.impl;

import java.lang.annotation.Annotation;

import org.kasource.commons.reflection.ClassIntrospector;
import org.kasource.commons.reflection.ClassIntrospectorImpl;
import org.kasource.validation.reflection.AnnotatedClass;

public abstract class AbstractAnnotatedClassValidator extends AbstractClassValidator{
 private AnnotatedClass annotation;
    
    
    protected void initialize(AnnotatedClass annotation) {
       this.annotation = annotation;
    }
    
    @Override
    protected boolean isValid(Object object) {
        if (object == null) {
            return true;
        }
        Class<?> clazz = getClass(object);
        if (clazz != null) {
            return hasAnnotation(clazz);
        }
        return false;
    }
    
    private boolean hasAnnotation(Class<?> clazz) {
        ClassIntrospector classIntro =  new ClassIntrospectorImpl(clazz);
        
        for (Class<? extends Annotation> annotationClass : annotation.value()) {
            if (classIntro.getAnnotation(annotationClass) == null) {
                return false;
            }
        }
        return true;
    }
}
