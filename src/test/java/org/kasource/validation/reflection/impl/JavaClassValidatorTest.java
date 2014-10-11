package org.kasource.validation.reflection.impl;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintValidatorContext.ConstraintViolationBuilder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kasource.commons.reflection.annotation.AnnotationBuilder;
import org.kasource.validation.reflection.JavaClass;
import org.kasource.validation.reflection.JavaClassType;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.easymock.EasyMockUnitils;
import org.unitils.easymock.annotation.Mock;
import org.unitils.inject.annotation.TestedObject;

@RunWith(UnitilsJUnit4TestClassRunner.class)
public class JavaClassValidatorTest {
    @Mock
    private ConstraintValidatorContext context;

    @Mock
    private ConstraintViolationBuilder builder;

    @TestedObject
    private JavaClassValidator validator;

    @Test
    public void testClassExists() {
        context.disableDefaultConstraintViolation();
        expectLastCall();
        expect(context.buildConstraintViolationWithTemplate("{org.kasource.validation.reflection.JavaClassType.ANY}"))
                    .andReturn(builder);
        expect(builder.addConstraintViolation()).andReturn(context);
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<JavaClass>(JavaClass.class).build());

        assertTrue(validator.isValid("java.lang.String", context));

        assertFalse(validator.isValid("qwe.ewqqwe.Ghhjlkj", context));
    }

    @Test
    public void testIsClass() {
        context.disableDefaultConstraintViolation();
        expectLastCall();
        expect(context.buildConstraintViolationWithTemplate("{org.kasource.validation.reflection.JavaClassType.CLASS}"))
                    .andReturn(builder);
        expect(builder.addConstraintViolation()).andReturn(context);
    
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<JavaClass>(JavaClass.class).value(JavaClassType.CLASS).build());

        assertTrue(validator.isValid("java.lang.String", context));

        assertFalse(validator.isValid("java.util.List", context));
    }

    @Test
    public void testIsPrimitive() {
        context.disableDefaultConstraintViolation();
        expectLastCall();
        expect(context.buildConstraintViolationWithTemplate("{org.kasource.validation.reflection.JavaClassType.PRIMITIVE}"))
                    .andReturn(builder);
        expect(builder.addConstraintViolation()).andReturn(context);
       
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<JavaClass>(JavaClass.class).value(JavaClassType.PRIMITIVE).build());

        assertTrue(validator.isValid(int.class.getName(), context));

        assertFalse(validator.isValid("java.lang.Integer", context));
    }

    @Test
    public void testIsInterface() {
        context.disableDefaultConstraintViolation();
        expectLastCall();
        expect(context.buildConstraintViolationWithTemplate("{org.kasource.validation.reflection.JavaClassType.INTERFACE}"))
                    .andReturn(builder);
        expect(builder.addConstraintViolation()).andReturn(context);
        
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<JavaClass>(JavaClass.class).value(JavaClassType.INTERFACE).build());

        assertTrue(validator.isValid("java.util.List", context));

        assertFalse(validator.isValid("java.lang.Integer", context));
    }

    @Test
    public void testIsArray() {
        context.disableDefaultConstraintViolation();
        expectLastCall();
        expect(context.buildConstraintViolationWithTemplate("{org.kasource.validation.reflection.JavaClassType.ARRAY}"))
                    .andReturn(builder);
        expect(builder.addConstraintViolation()).andReturn(context);
        
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<JavaClass>(JavaClass.class).value(JavaClassType.ARRAY).build());

        assertTrue(validator.isValid(String[].class.getName(), context));
        assertTrue(validator.isValid(int[].class.getName(), context));

        assertFalse(validator.isValid("java.lang.Integer", context));
    }

    @Test
    public void testIsEnum() {
        context.disableDefaultConstraintViolation();
        expectLastCall();
        expect(context.buildConstraintViolationWithTemplate("{org.kasource.validation.reflection.JavaClassType.ENUM}"))
                    .andReturn(builder);
        expect(builder.addConstraintViolation()).andReturn(context);
        
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<JavaClass>(JavaClass.class).value(JavaClassType.ENUM).build());

        assertTrue(validator.isValid(TimeUnit.class.getName(), context));

        assertFalse(validator.isValid("java.lang.Integer", context));
    }

    @Test
    public void testIsAnnotation() {
        context.disableDefaultConstraintViolation();
        expectLastCall();
        expect(context.buildConstraintViolationWithTemplate("{org.kasource.validation.reflection.JavaClassType.ANNOTATION}"))
                    .andReturn(builder);
        expect(builder.addConstraintViolation()).andReturn(context);
        
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<JavaClass>(JavaClass.class).value(JavaClassType.ANNOTATION).build());

        assertTrue(validator.isValid(Test.class.getName(), context));

        assertFalse(validator.isValid("java.lang.Integer", context));
    }
    
    @Test
    public void testHasPublicEmptyConstructor() {
        context.disableDefaultConstraintViolation();
        expectLastCall();
        expect(context.buildConstraintViolationWithTemplate("{org.kasource.validation.reflection.JavaClassType.PUBLIC_DEFAULT_CONSTRUCTOR}"))
                    .andReturn(builder);
        expect(builder.addConstraintViolation()).andReturn(context);
        
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<JavaClass>(JavaClass.class).value(JavaClassType.PUBLIC_DEFAULT_CONSTRUCTOR).build());

        assertTrue(validator.isValid("java.lang.String", context));

        assertFalse(validator.isValid("java.lang.Integer", context));
    }

   
}
