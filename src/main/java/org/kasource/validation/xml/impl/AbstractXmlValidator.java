package org.kasource.validation.xml.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Queue;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.kasource.validation.AbstractValidator;
import org.kasource.validation.xml.Xml;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public abstract class AbstractXmlValidator extends AbstractValidator {
    static final String JAXP_SCHEMA_LANGUAGE =
        "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
    static final String JAXP_SCHEMA_SOURCE =
        "http://java.sun.com/xml/jaxp/properties/schemaSource";
  
    private InputStream[] schemas;
    
    protected void initialize(Xml annotation) {
      
        String[] schemaLocation = annotation.schemaLocation();
        if (schemaLocation.length > 0) {
           try {
              schemas = new InputStream[schemaLocation.length];
              for(int i = 0; i < schemaLocation.length; i++) {
                  schemas[i] = new ByteArrayInputStream(loadFromLocation(schemaLocation[i]));
              }
           } catch (Exception e) {
               throw new IllegalStateException(AbstractXmlValidator.class.getSimpleName() +  " could not load schema from " + schemaLocation, e);
           }
        }
    }
   
    protected Document getContent(byte[] value) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        
        try {
            DocumentBuilder parser = factory.newDocumentBuilder();
            XmlErrorHandler errorHandler = new XmlErrorHandler();
            parser.setErrorHandler(errorHandler);
            Document document = parser.parse(new ByteArrayInputStream(value));
            if (errorHandler.getErrors().size() > 0) {
                return null;
            }
            return document;
        } catch (Exception e) {
            return null;
        }           
       
    }
   
    protected boolean validContent(byte[] value) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        factory.setNamespaceAware(true);
        factory.setAttribute(JAXP_SCHEMA_LANGUAGE, XMLConstants.W3C_XML_SCHEMA_NS_URI);
        if (schemas != null) {         
            factory.setAttribute(JAXP_SCHEMA_SOURCE, schemas);
        }
        try {
            DocumentBuilder parser = factory.newDocumentBuilder();
            XmlErrorHandler errorHandler = new XmlErrorHandler();
            parser.setErrorHandler(errorHandler);
            parser.parse(new ByteArrayInputStream(value));
            if (errorHandler.getErrors().size() > 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }           
       
    }
    
   
    @Override
    protected boolean isValid(Object object) {
        if (object == null) {
            return true;
        }
       
        try {
            byte[] data = loadFromLocation(object.toString());
           Document document = getContent(data);
            if (document == null) {
                return false;
            }
            if (doValidation(document)) {
                return validContent(data);
            }
            /*
            if (schema != null) {
               
                return validateSchemaCompliance(document);
            }*/
           return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    private boolean doValidation(Document document) {
        if (schemas != null) {
            return true;
        }
        Element element = document.getDocumentElement();
        if (!element.getAttribute("xmlns").isEmpty() && 
                    !element.getAttribute("xmlns:xsi").isEmpty() &&
                    !element.getAttribute("xsi:schemaLocation").isEmpty()) {
            return true;
        }
        return false;
    }
    
    /*
    private boolean validateSchemaCompliance(Document document) {
       
        try
        {
            Element element = document.getDocumentElement();
            if (element.getAttribute("xmlns").isEmpty()) {
               
                element.setAttribute("xmlns", schema.getDocumentElement().getAttribute("targetNamespace"));
                element.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
            }
            
            SchemaFactory factory = 
                SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new StreamSource(new ByteArrayInputStream(schemaBytes)));
          
            
            Validator validator = schema.newValidator();
           
            validator.validate(new DOMSource(document));
            return true;
        } catch(Exception ex) {
            return false;
        }
    }
   */

    private static class XmlErrorHandler implements ErrorHandler {

        private Queue<SAXParseException> errorQueue = new LinkedList<SAXParseException>();
        
        @Override
        public void warning(SAXParseException saxParseException) throws SAXException {
            errorQueue.add(saxParseException);
        }

        @Override
        public void error(SAXParseException saxParseException) throws SAXException {
            errorQueue.add(saxParseException);
            
        }

        @Override
        public void fatalError(SAXParseException saxParseException) throws SAXException {
            errorQueue.add(saxParseException);
            
        }
        
        public Queue getErrors() {
            return errorQueue;
        }
    }
}
