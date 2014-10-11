package org.kasource.validation.xml.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.validation.ConstraintValidatorContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kasource.commons.reflection.annotation.AnnotationBuilder;
import org.kasource.validation.xml.Jaxb;

import org.kasource.validation.xml.impl.note.Note;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.easymock.EasyMockUnitils;
import org.unitils.easymock.annotation.Mock;
import org.unitils.inject.annotation.TestedObject;

@RunWith(UnitilsJUnit4TestClassRunner.class)
public class JaxbValidatorTest {
    @Mock
    private ConstraintValidatorContext context;
    
    @TestedObject
    private JaxbValidator validator;
    
    @Test
    public void testInlineXml() {
        
        String xml="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+
            "<note xmlns=\"http://kasource.org/validation/test/schema/note\">\n"+
            "\t<to>Tove</to>\n"+
            "\t<from>Jani</from>\n"+
            "\t<heading>Reminder</heading>\n"+
            "\t<body>Don\'t forget me this weekend!</body>\n"+
            "</note>\n";
        
        String xmlMissingElement="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+
            "<note xmlns=\"http://kasource.org/validation/test/schema/note\">\n"+
            "\t<from>Jani</from>\n"+
            "\t<heading>Reminder</heading>\n"+
            "\t<body>Don\'t forget me this weekend!</body>\n"+
            "</note>\n";
        
        String xmlWithExtraElement="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+
            "<note xmlns=\"http://kasource.org/validation/test/schema/note\">\n"+
            "\t<to>Tove</to>\n"+
            "\t<from>Jani</from>\n"+
            "\t<heading>Reminder</heading>\n"+
            "\t<body>Don\'t forget me this weekend!</body>\n"+
            "\t<extra>Extra element data</extra>\n"+
            "</note>";
        
        String xmlMissingNamespace="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+
            "<note>\n"+
            "\t<to>Tove</to>\n"+
            "\t<from>Jani</from>\n"+
            "\t<heading>Reminder</heading>\n"+
            "\t<body>Don\'t forget me this weekend!</body>\n"+
            "</note>";
        
        String brokenXml="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+
            "<note xmlns=\"http://kasource.org/validation/test/schema/note\">\n"+
            "\t<to>Tove</to>\n"+
            "\t<from>Jani</from>\n"+
            "\t<heading>Reminder</heading>\n"+
            "\t<body>Don\'t forget me this weekend!</body>\n"+
            "<note>";
        
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Jaxb>(Jaxb.class).value(Note.class).build());
       
       assertTrue(validator.isValid(xml, context));
       assertTrue(validator.isValid(xmlWithExtraElement, context));
       assertTrue(validator.isValid(xmlMissingElement, context));
       assertFalse(validator.isValid(xmlMissingNamespace, context));
       assertFalse(validator.isValid(brokenXml, context));
       
    }
}
