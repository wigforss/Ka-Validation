package org.kasource.validation.reflection.impl;

import org.kasource.commons.reflection.util.ClassUtils;
import org.kasource.validation.AbstractValidator;

public abstract class AbstractClassValidator extends AbstractValidator {
    protected Class<?> getClass(Object object) {
        Class<?> clazz = null;    
        try {
            if (object instanceof Class<?>) {
                return (Class<?>) object;
            } else {
                String className = object.toString();
                clazz = ClassUtils.getPrimitiveClass(className);
                if (clazz == null) {
                    clazz = Class.forName(className);
                }
                return clazz;
            }
          } catch (ClassNotFoundException e) {
                return null;
          }
    }
}
