package org.kasource.validation.phone.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintValidatorContext.ConstraintViolationBuilder;

import static org.easymock.EasyMock.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kasource.commons.reflection.annotation.AnnotationBuilder;

import org.kasource.validation.phone.Phone;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.easymock.EasyMockUnitils;
import org.unitils.easymock.annotation.Mock;
import org.unitils.inject.annotation.TestedObject;

@RunWith(UnitilsJUnit4TestClassRunner.class)
public class PhoneValidatorTest {
    @Mock
    private ConstraintValidatorContext context;
    
    @Mock
    private ConstraintViolationBuilder builder;
    
    @TestedObject
    private PhoneValidator validator;
    
    @Test
    public void testGenericPhone() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Phone>(Phone.class).build());
       
       assertTrue(validator.isValid("+9432987342", context));
       assertTrue(validator.isValid("243234234", context));
       assertTrue(validator.isValid("434-4343 434", context));
       assertTrue(validator.isValid("(687423) 687432", context));
       
       assertFalse(validator.isValid("1232cd12", context));
    }
    
    @Test
    public void testCountrySpecific() {
       
       context.disableDefaultConstraintViolation();
       expectLastCall().times(3);
       expect(context.buildConstraintViolationWithTemplate("{org.kasource.validation.phone.Phone} Sweden")).andReturn(builder).times(3);
       expect(builder.addConstraintViolation()).andReturn(context).times(3); 
       
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Phone>(Phone.class).attr("country", "SE").build());
       
       assertTrue(validator.isValid("+46703834107", context));
       assertTrue(validator.isValid("243234234", context));
       assertTrue(validator.isValid("08-323 42 34", context));
       assertFalse(validator.isValid("434-4343 434", context));
       assertFalse(validator.isValid("(687423) 687432", context));
       assertFalse(validator.isValid("1232cd12", context));
    }
}
