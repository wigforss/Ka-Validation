package org.kasource.validation.reflection;

import org.kasource.commons.reflection.filter.classes.ClassFilter;

public enum JavaClassType {
    ANY(new ClassFilter() {
        public boolean passFilter(Class<?> clazz) {
            return true;
        }
    }), 
    CLASS(new ClassFilter() {
        public boolean passFilter(Class<?> clazz) {
            return (!clazz.isPrimitive() 
                        && !clazz.isInterface() 
                        && !clazz.isArray() 
                        && !clazz.isEnum() 
                        && !clazz.isAnnotation());
        }
    }), 
    PRIMITIVE(new ClassFilter() {
        public boolean passFilter(Class<?> clazz) {
            return clazz.isPrimitive();
        }
    }), 
    INTERFACE(new ClassFilter() {
        public boolean passFilter(Class<?> clazz) {
            return clazz.isInterface();
        }
    }), 
    ARRAY(new ClassFilter() {
        public boolean passFilter(Class<?> clazz) {
            return clazz.isArray();
        }
    }), 
    ENUM(new ClassFilter() {
        public boolean passFilter(Class<?> clazz) {
            return clazz.isEnum();
        }
    }), 
    ANNOTATION(new ClassFilter() {
        public boolean passFilter(Class<?> clazz) {
            return clazz.isAnnotation();
        }
    });

    private ClassFilter classFilter;

    JavaClassType(ClassFilter classFilter) {
        this.classFilter = classFilter;
    }

    public ClassFilter getClassFilter() {
        return classFilter;
    }
}
