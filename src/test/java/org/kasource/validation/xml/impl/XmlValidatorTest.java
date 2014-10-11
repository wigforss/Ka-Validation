package org.kasource.validation.xml.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
public class XmlValidatorTest {
    @Mock
    private ConstraintValidatorContext context;
    
    @TestedObject
    private XmlValidator validator;
    
    @Test
    public void testInlineXml() {
        String xml="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+
            "<note>\n"+
            "\t<to>Tove</to>\n"+
            "\t<from>Jani</from>\n"+
            "\t<heading>Reminder</heading>\n"+
            "\t<body>Don\'t forget me this weekend!</body>\n"+
            "</note>";
        
        String brokenXml="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+
            "<note>\n"+
            "\t<to>Tove</to>\n"+
            "\t<from>Jani</from>\n"+
            "\t<heading>Reminder</heading>\n"+
            "\t<body>Don\'t forget me this weekend!</body>\n"+
            "<note>";
        
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Xml>(Xml.class).build());
       
       assertTrue(validator.isValid(xml, context));
       assertFalse(validator.isValid(brokenXml, context));
       
    }
    
  
    
    @Test
    public void testInlineXmlAndSchemaFromUrl() {
    
        String validSpringXml="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+
            "<beans xmlns=\"http://www.springframework.org/schema/beans\" \n"+
            " xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n"+
            " xsi:schemaLocation=\"\n"+
            " http://www.springframework.org/schema/beans \n"+
            " http://www.springframework.org/schema/beans/spring-beans-3.0.xsd\">\n"+
            " \n"+
            " \t<bean id=\"webSocketChannelFactory\" class=\"org.kasource.web.websocket.spring.channel.SpringWebSocketChannelFactory\"/> \n"+
            "</beans>";
        String invalidSpringXml="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+
            "<beans xmlns=\"http://www.springframework.org/schema/beans\" \n"+
            " xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n"+
            " xsi:schemaLocation=\"\n"+
            " http://www.springframework.org/schema/beans \n"+
            " http://www.springframework.org/schema/beans/spring-beans-3.0.xsd\">\n"+
            " \n"+
            " \t<bean id=\"webSocketChannelFactory\" class=\"org.kasource.web.websocket.spring.channel.SpringWebSocketChannelFactory\"/> \n"+
            "\t<notALegalElement/>\n"+
            "</beans>";
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<Xml>(Xml.class).build());
        
        assertTrue(validator.isValid(validSpringXml, context));
        assertFalse(validator.isValid(invalidSpringXml, context));
    }
    
  
    
    @Test
    public void testInlineXmlWithSchemaValidation() {
        String xml="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+
            "<note xmlns=\"http://kasource.org/validation/test/schema/note\">\n"+
            "\t<to>Tove</to>\n"+
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
        
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Xml>(Xml.class).attr("schemaLocation", "classpath:/org/kasource/validation/xml/impl/test-note.xsd").build());
       
       assertTrue(validator.isValid(xml, context));
       assertFalse(validator.isValid(xmlWithExtraElement, context));
       
    }
    
   
}
