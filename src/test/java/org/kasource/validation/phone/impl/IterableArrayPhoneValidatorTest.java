package org.kasource.validation.phone.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.easymock.EasyMock.*;

import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintValidatorContext.ConstraintViolationBuilder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kasource.commons.collection.builder.ListBuilder;
import org.kasource.commons.reflection.annotation.AnnotationBuilder;

import org.kasource.validation.phone.Phone;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.easymock.EasyMockUnitils;
import org.unitils.easymock.annotation.Mock;
import org.unitils.inject.annotation.TestedObject;

@RunWith(UnitilsJUnit4TestClassRunner.class)
public class IterableArrayPhoneValidatorTest {
    @Mock
    private ConstraintValidatorContext context;
    
    @Mock
    private ConstraintViolationBuilder builder;
    
    @TestedObject
    private IterablePhoneValidator validator;
    
    @Test
    public void testGenericPhone() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Phone>(Phone.class).build());
       
       assertTrue(validator.isValid(new ListBuilder<String>().add("+9432987342","243234234","434-4343 434","(687423) 687432").build(), context));   
       assertFalse(validator.isValid(new ListBuilder<String>().add("243234234", "1232cd12").build(), context));
    }
    
    @Test
    public void testCountrySpecific() {
        context.disableDefaultConstraintViolation();
        expectLastCall();
        expect(context.buildConstraintViolationWithTemplate("{org.kasource.validation.phone.Phone} Sweden")).andReturn(builder);
        expect(builder.addConstraintViolation()).andReturn(context); 
        
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<Phone>(Phone.class).attr("country", "SE").build());
       
        assertTrue(validator.isValid(new ListBuilder<String>().add("+46703834107", "243234234", "08-323 42 34").build(), context));   
        assertFalse(validator.isValid(new ListBuilder<String>().add("+46703834107", "434-4343 434").build(), context));
      
    }
}
