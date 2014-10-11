package org.kasource.validation.reflection.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.validation.ConstraintValidatorContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kasource.commons.reflection.annotation.AnnotationBuilder;
import org.kasource.validation.reflection.AnnotatedClass;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.easymock.EasyMockUnitils;
import org.unitils.easymock.annotation.Mock;
import org.unitils.inject.annotation.TestedObject;

@RunWith(UnitilsJUnit4TestClassRunner.class)
public class ClassAnnotatedClassValidatorTest {
    @Mock
    private ConstraintValidatorContext context;
    
    @TestedObject
    private ClassAnnotatedClassValidator validator;

    @Test
    public void testHasAnnotation() {
     
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<AnnotatedClass>(AnnotatedClass.class).value(RunWith.class).build());

        assertTrue(validator.isValid(this.getClass(), context));
        
        assertFalse(validator.isValid(String.class, context));
        
    }
    
    
 
}
