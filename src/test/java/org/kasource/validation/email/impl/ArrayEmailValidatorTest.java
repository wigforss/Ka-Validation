package org.kasource.validation.email.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.validation.ConstraintValidatorContext;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.kasource.commons.reflection.annotation.AnnotationBuilder;
import org.kasource.validation.email.Email;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.easymock.EasyMockUnitils;
import org.unitils.easymock.annotation.Mock;
import org.unitils.inject.annotation.TestedObject;

@RunWith(UnitilsJUnit4TestClassRunner.class)
public class ArrayEmailValidatorTest {
    @Mock
    private ConstraintValidatorContext context;
        
    @TestedObject
    private ArrayEmailValidator validator;
    
    @Test
    public void testValidEmail() {
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<Email>(Email.class).build());
        assertTrue(validator.isValid(new String[]{"rikard.wigforss@example.com", "rikard.wigforss@somedomain.com"}, context));
    }
    
    @Test
    public void testValidLocalEmail() {
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<Email>(Email.class).attr("allowLocalAddresses", true).build());
        assertTrue(validator.isValid(new String[]{"rikard.wigforss@example.com","rikard.wigforss@local"}, context));
    }
    
    @Test
    public void testInvalidEmail() {
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<Email>(Email.class).build());
        
        assertFalse(validator.isValid(new String[]{"rikard.wigforss@local", "rikard.wigforss@example.com"}, context));
        assertFalse(validator.isValid(new String[]{"rikard.wigforss@example.com", "Abc.example.com"}, context));
    }
}
