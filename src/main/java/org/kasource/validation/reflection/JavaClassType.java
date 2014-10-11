package org.kasource.validation.reflection;

import org.kasource.commons.reflection.filter.classes.ClassFilter;

public enum JavaClassType {
    ANY(new ClassFilter() {
        public boolean passFilter(Class<?> clazz) {
            return true;
        }
    },
    "org.kasource.validation.reflection.JavaClassType.ANY"), 
    CLASS(new ClassFilter() {
        public boolean passFilter(Class<?> clazz) {
            return (!clazz.isPrimitive() 
                        && !clazz.isInterface() 
                        && !clazz.isArray() 
                        && !clazz.isEnum() 
                        && !clazz.isAnnotation());
        }
    },
    "org.kasource.validation.reflection.JavaClassType.CLASS"), 
    PRIMITIVE(new ClassFilter() {
        public boolean passFilter(Class<?> clazz) {
            return clazz.isPrimitive();
        }
    },
    "org.kasource.validation.reflection.JavaClassType.PRIMITIVE"), 
    INTERFACE(new ClassFilter() {
        public boolean passFilter(Class<?> clazz) {
            return clazz.isInterface();
        }
    },
    "org.kasource.validation.reflection.JavaClassType.INTERFACE"), 
    ARRAY(new ClassFilter() {
        public boolean passFilter(Class<?> clazz) {
            return clazz.isArray();
        }
    },
    "org.kasource.validation.reflection.JavaClassType.ARRAY"), 
    ENUM(new ClassFilter() {
        public boolean passFilter(Class<?> clazz) {
            return clazz.isEnum();
        }
    },
    "org.kasource.validation.reflection.JavaClassType.ENUM"), 
    ANNOTATION(new ClassFilter() {
        public boolean passFilter(Class<?> clazz) {
            return clazz.isAnnotation();
        }
    },
    "org.kasource.validation.reflection.JavaClassType.ANNOTATION"), 
    PUBLIC_DEFAULT_CONSTRUCTOR(new ClassFilter() {
        public boolean passFilter(Class<?> clazz) {
            try {
                clazz.getConstructor();
                return true;
            } catch (Exception e) {
                return false;
            } 
        }
    },
    "org.kasource.validation.reflection.JavaClassType.PUBLIC_DEFAULT_CONSTRUCTOR");

    private ClassFilter classFilter;
    private String messageKey;
    
    JavaClassType(ClassFilter classFilter, String messageKey) {
        this.classFilter = classFilter;
        this.messageKey = messageKey;
    }

    public ClassFilter getClassFilter() {
        return classFilter;
    }

    /**
     * @return the messageKey
     */
    public String getMessageKey() {
        return messageKey;
    }
}
