package org.kasource.validation.reflection.impl;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintValidatorContext.ConstraintViolationBuilder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kasource.commons.collection.builder.ListBuilder;
import org.kasource.commons.reflection.annotation.AnnotationBuilder;
import org.kasource.validation.reflection.JavaClass;
import org.kasource.validation.reflection.JavaClassType;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.easymock.EasyMockUnitils;
import org.unitils.easymock.annotation.Mock;
import org.unitils.inject.annotation.TestedObject;

@RunWith(UnitilsJUnit4TestClassRunner.class)
public class IterableJavaClassValidatorTest {
    @Mock
    private ConstraintValidatorContext context;

    @Mock
    private ConstraintViolationBuilder builder;

    @TestedObject
    private IterableJavaClassValidator validator;

    @Test
    public void testClassExists() {
        context.disableDefaultConstraintViolation();
        expectLastCall();
        expect(context.buildConstraintViolationWithTemplate("{org.kasource.validation.reflection.JavaClassType.ANY}"))
                    .andReturn(builder);
        expect(builder.addConstraintViolation()).andReturn(context);
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<JavaClass>(JavaClass.class).build());

        assertTrue(validator.isValid(new ListBuilder<String>().add("java.lang.String", "java.lang.Integer").build(), context));

        assertFalse(validator.isValid(new ListBuilder<String>().add("java.lang.String", "qwe.ewqqwe.Ghhjlkj").build(), context));
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

        assertTrue(validator.isValid(new ListBuilder<Class<?>>().add(String.class, Integer.class).build(), context));

        assertFalse(validator.isValid(new ListBuilder<Class<?>>().add(String.class, List.class).build(), context));
    }

  
}
