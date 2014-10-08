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
public class EmailValidatorTest {
    @Mock
    private ConstraintValidatorContext context;
        
    @TestedObject
    private EmailValidator validator;
    
    @Test
    public void testValidEmail() {
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<Email>(Email.class).build());
        assertTrue(validator.isValid("rikard.wigforss@example.com", context));
    }
    
    @Test
    public void testValidLocalEmail() {
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<Email>(Email.class).attr("allowLocalAddresses", true).build());
        assertTrue(validator.isValid("rikard.wigforss@local", context));
    }
    
    @Test
    public void testInvalidEmail() {
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<Email>(Email.class).build());
        
        assertFalse(validator.isValid("rikard.wigforss@local", context));
        assertFalse(validator.isValid("Abc.example.com", context));
        assertFalse(validator.isValid("A@b@c@example.com", context));
        assertFalse(validator.isValid("a\"b(c)d,e:f;g<h>i[j\\k]l@example.com", context));
        assertFalse(validator.isValid("just\"not\"right@example.com", context));
        assertFalse(validator.isValid("this is\\\"not\\allowed@example.com", context));
        assertFalse(validator.isValid("this\\ still\\\"not\\\\allowed@example.com", context));
        assertFalse(validator.isValid("john..doe@example.com", context));
        assertFalse(validator.isValid("john.doe@example..com", context));

      
    }
}
