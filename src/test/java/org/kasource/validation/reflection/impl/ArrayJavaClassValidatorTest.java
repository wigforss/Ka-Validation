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
import org.kasource.commons.reflection.annotation.AnnotationBuilder;
import org.kasource.validation.reflection.JavaClass;
import org.kasource.validation.reflection.JavaClassType;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.easymock.EasyMockUnitils;
import org.unitils.easymock.annotation.Mock;
import org.unitils.inject.annotation.TestedObject;

@RunWith(UnitilsJUnit4TestClassRunner.class)
public class ArrayJavaClassValidatorTest {
    @Mock
    private ConstraintValidatorContext context;

    @Mock
    private ConstraintViolationBuilder builder;

    @TestedObject
    private ArrayJavaClassValidator validator;

    @Test
    public void testClassExists() {
        context.disableDefaultConstraintViolation();
        expectLastCall();
        expect(context.buildConstraintViolationWithTemplate("{org.kasource.validation.reflection.JavaClassType.ANY}"))
                    .andReturn(builder);
        expect(builder.addConstraintViolation()).andReturn(context);
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<JavaClass>(JavaClass.class).build());

        assertTrue(validator.isValid(new String[]{"java.lang.String", "java.lang.Integer"}, context));

        assertFalse(validator.isValid(new String[]{"java.lang.String", "qwe.ewqqwe.Ghhjlkj"}, context));
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

        assertTrue(validator.isValid(new Class[]{String.class, Integer.class}, context));

        assertFalse(validator.isValid(new Class[]{String.class, List.class}, context));
    }

  
}
