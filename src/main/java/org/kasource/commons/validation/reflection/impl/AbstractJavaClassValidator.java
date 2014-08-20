package org.kasource.commons.validation.reflection.impl;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.kasource.commons.reflection.Modifier;
import org.kasource.commons.validation.AbstractValidator;
import org.kasource.commons.validation.reflection.JavaClass;

public abstract class AbstractJavaClassValidator extends AbstractValidator {
    private JavaClass annotation;
    
    
    protected void initialize(JavaClass annotation) {
       this.annotation = annotation;
    }
    
    @Override
    protected boolean isValid(Object object) {
        if (object == null) {
            return true;
        }
        
        Class<?> clazz = null;    
        try {
            if (object instanceof Class<?>) {
                clazz = (Class<?>) object;
            } else {
                String className = object.toString();
                clazz = Class.forName(className);
            }
            if (!matchClassType(clazz)) {
                return false;
            }
            if (!hasModifiers(clazz)) {
                return false;
            }
            if (!hasAnnotation(clazz)) {
                return false;
            }
            if (!implementsInterface(clazz)) {
                return false;
            }
            if (!isAssignableFrom(clazz)) {
                return false;
            }
            if (!isAssignableTo(clazz)) {
                return false;
            }
            if (!hasFields(clazz)) {
                return false;
            }
            if(!hasSuperClass(clazz)) {
                return false;
            }
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
       
    }
    private boolean hasAnnotation(Class<?> clazz) {
        for (Class<? extends Annotation> annotationClass : annotation.hasAnnotation()) {
            if (!clazz.isAnnotationPresent(annotationClass)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean hasSuperClass(Class<?> clazz) {
        if (!annotation.superClass().equals(JavaClass.class)) {
            return clazz.getSuperclass().equals(annotation.superClass());
        }
        return true;
    }
    
    private boolean implementsInterface(Class<?> clazz) {
        if (annotation.implementsInterface().length > 0) {
            Set<Class<?>> interfaces = new HashSet<Class<?>>();
            interfaces.addAll(Arrays.asList(clazz.getInterfaces()));
            
            for (Class<?> interfaceClass : annotation.implementsInterface()) {
                if (!interfaces.contains(interfaceClass)) {
                    return false;
                }
            }
        }
        return false;
    }
    
    private boolean hasModifiers(Class<?> clazz) {
        for (Modifier modifier : annotation.hasModifier()) {
            if((clazz.getModifiers() & modifier.getValue()) == 0) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isAssignableFrom(Class<?> clazz) {
        for (Class<?> assignableClass : annotation.assignableFrom()) {
            if (!clazz.isAssignableFrom(assignableClass)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isAssignableTo(Class<?> clazz) {
        for (Class<?> assignableClass : annotation.assignableTo()) {
            if (!assignableClass.isAssignableFrom(clazz)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean hasFields(Class<?> clazz) {
        for (String fieldName : annotation.fields()) {
            try {
                clazz.getDeclaredField(fieldName);
            } catch (Exception e) {
               return false;
            } 
        }
        return true;
    }
    
    private boolean matchClassType(Class<?> clazz) {        
        return annotation.value().getClassFilter().passFilter(clazz);
    }
}
