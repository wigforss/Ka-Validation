package org.kasource.validation.xml.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import java.net.URI;
import java.net.URISyntaxException;
import javax.validation.ConstraintValidatorContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kasource.commons.reflection.annotation.AnnotationBuilder;
import org.kasource.validation.xml.Xml;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.easymock.EasyMockUnitils;
import org.unitils.easymock.annotation.Mock;
import org.unitils.inject.annotation.TestedObject;

@RunWith(UnitilsJUnit4TestClassRunner.class)
public class UriXmlValidatorTest {
    
    private static final String BASE_DIR = System.getProperty("user.dir") + "/src/test/java/" + UriXmlValidatorTest.class.getPackage().getName().replace('.', '/');
    
    @Mock
    private ConstraintValidatorContext context;
    
    @TestedObject
    private UriXmlValidator validator;
    
    @Test
    public void testFileUrlXml() throws URISyntaxException {
        String xml = "file://" + BASE_DIR + "/test-note.xml";
        
        String brokenXml = "file://" + BASE_DIR + "/test-note-broken.xml";
        
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Xml>(Xml.class).build());
       
       assertTrue(validator.isValid(new URI(xml), context));
       assertFalse(validator.isValid(new URI(brokenXml), context));
       
    }
    
  
    
    @Test
    public void testUrlXmlAndSchemaFromUrl() throws URISyntaxException {
    
        String validSpringXml = "file://" + BASE_DIR + "/spring.xml";
        String invalidSpringXml = "file://" + BASE_DIR + "/spring-invalid.xml";
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<Xml>(Xml.class).build());
        
        assertTrue(validator.isValid(new URI(validSpringXml), context));
        assertFalse(validator.isValid(new URI(invalidSpringXml), context));
    }
    
  
    
    @Test
    public void testInlineXmlWithSchemaValidation() throws URISyntaxException {
        String xml = "file://" + BASE_DIR + "/test-note-ns.xml";
        
        String xmlWithExtraElement = "file://" + BASE_DIR + "/test-note-ns-invalid.xml";
        
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Xml>(Xml.class).attr("schemaLocation", "classpath:/org/kasource/validation/xml/impl/test-note.xsd").build());
       
       assertTrue(validator.isValid(new URI(xml), context));
       assertFalse(validator.isValid(new URI(xmlWithExtraElement), context));
       
    }
    
   
}
