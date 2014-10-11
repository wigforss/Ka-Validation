package org.kasource.validation.xml.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

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
public class UrlXmlValidatorTest {
    
    private static final String BASE_DIR = System.getProperty("user.dir") + "/src/test/java/" + UrlXmlValidatorTest.class.getPackage().getName().replace('.', '/');
    
    @Mock
    private ConstraintValidatorContext context;
    
    @TestedObject
    private UrlXmlValidator validator;
    
    @Test
    public void testFileUrlXml() throws MalformedURLException {
        String xml = "file://localhost" + BASE_DIR + "/test-note.xml";
        
        String brokenXml = "file://localhost" + BASE_DIR + "/test-note-broken.xml";
        
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Xml>(Xml.class).build());
       
       assertTrue(validator.isValid(new URL(xml), context));
       assertFalse(validator.isValid(new URL(brokenXml), context));
       
    }
    
  
    
    @Test
    public void testUrlXmlAndSchemaFromUrl() throws MalformedURLException {
    
        String validSpringXml = "file://localhost" + BASE_DIR + "/spring.xml";
        String invalidSpringXml = "file://localhost" + BASE_DIR + "/spring-invalid.xml";
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<Xml>(Xml.class).build());
        
        assertTrue(validator.isValid(new URL(validSpringXml), context));
        assertFalse(validator.isValid(new URL(invalidSpringXml), context));
    }
    
  
    
    @Test
    public void testInlineXmlWithSchemaValidation() throws MalformedURLException {
        String xml = "file://localhost" + BASE_DIR + "/test-note-ns.xml";
        
        String xmlWithExtraElement = "file://localhost" + BASE_DIR + "/test-note-ns-invalid.xml";
        
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Xml>(Xml.class).attr("schemaLocation", "classpath:/org/kasource/validation/xml/impl/test-note.xsd").build());
       
       assertTrue(validator.isValid(new URL(xml), context));
       assertFalse(validator.isValid(new URL(xmlWithExtraElement), context));
       
    }
    
   
}
