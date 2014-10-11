package org.kasource.validation.uuid.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.validation.ConstraintValidatorContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kasource.commons.reflection.annotation.AnnotationBuilder;
import org.kasource.validation.url.Url;
import org.kasource.validation.url.impl.UrlValidator;
import org.kasource.validation.uuid.Uuid;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.easymock.EasyMockUnitils;
import org.unitils.easymock.annotation.Mock;
import org.unitils.inject.annotation.TestedObject;

@RunWith(UnitilsJUnit4TestClassRunner.class)
public class ArrayUuidValidatorTest {
    @Mock
    private ConstraintValidatorContext context;
    
    @TestedObject
    private ArrayUuidValidator validator;
    
    @Test
    public void testDefaultUUid() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Uuid>(Uuid.class).build());
       
       assertTrue(validator.isValid(new String[]{"f47ac10b-58cc-4372-a567-0e02b2c3d479"}, context));
       assertFalse(validator.isValid(new String[]{"F47AC10B-58CC-4372-A567-0E02B2C3D479"}, context));
       assertFalse(validator.isValid(new String[]{"f47ac10b-58cc-4372-a567-0e02b2c3d479", "f47ac10b58cc4372a5670e02b2c3d479"}, context));
    }
    
    @Test
    public void testIgnoreCase() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Uuid>(Uuid.class).attr("ignoreCase", true).build());
       
       assertTrue(validator.isValid(new String[]{"f47ac10b-58cc-4372-a567-0e02b2c3d479"}, context));
       assertTrue(validator.isValid(new String[]{"F47AC10B-58CC-4372-A567-0E02B2C3D479"}, context));
       assertFalse(validator.isValid(new String[]{"f47ac10b-58cc-4372-a567-0e02b2c3d479", "f47ac10b58cc4372a5670e02b2c3d479"}, context));
    }
    
    @Test
    public void testUpperCase() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Uuid>(Uuid.class).attr("lowerCase", false).build());
       
       assertTrue(validator.isValid(new String[]{"F47AC10B-58CC-4372-A567-0E02B2C3D479"}, context));
       assertFalse(validator.isValid(new String[]{"f47ac10b-58cc-4372-a567-0e02b2c3d479"}, context));
       assertFalse(validator.isValid(new String[]{"F47AC10B-58CC-4372-A567-0E02B2C3D479", "f47ac10b58cc4372a5670e02b2c3d479"}, context));
    }
    
    @Test
    public void testNoDashes() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Uuid>(Uuid.class).attr("useDashes", false).build());
       assertTrue(validator.isValid(new String[]{"f47ac10b58cc4372a5670e02b2c3d479"}, context));
       
       assertFalse(validator.isValid(new String[]{"f47ac10b-58cc-4372-a567-0e02b2c3d479"}, context));
       assertFalse(validator.isValid(new String[]{"F47AC10B-58CC-4372-A567-0E02B2C3D479"}, context));
      
    }
    
    @Test
    public void testNoDashesUpperCase() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Uuid>(Uuid.class).attr("useDashes", false).attr("lowerCase", false).build());
       
       assertTrue(validator.isValid(new String[]{"F47AC10B58CC4372A5670E02B2C3D479"}, context));
       
       assertFalse(validator.isValid(new String[]{"f47ac10b58cc4372a5670e02b2c3d479"}, context));
       assertFalse(validator.isValid(new String[]{"f47ac10b-58cc-4372-a567-0e02b2c3d479"}, context));
       assertFalse(validator.isValid(new String[]{"F47AC10B-58CC-4372-A567-0E02B2C3D479"}, context));
      
    }
}
