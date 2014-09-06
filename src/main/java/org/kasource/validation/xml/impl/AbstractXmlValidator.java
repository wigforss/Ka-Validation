package org.kasource.validation.xml.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.kasource.validation.AbstractValidator;
import org.kasource.validation.DataLocationType;
import org.kasource.validation.xml.Xml;

public abstract class AbstractXmlValidator extends AbstractValidator {

    private ByteArrayInputStream schema;
    private DataLocationType locationType;
    
    protected void initialize(Xml annotation, DataLocationType locationType) {
        this.locationType = locationType;
        String schemaLocation = annotation.schemaLocation();
        if (!schemaLocation.isEmpty()) {
           try {
              schema = new ByteArrayInputStream(loadFromLocation(schemaLocation, annotation.schemaLocationType()));
           } catch (Exception e) {
               throw new IllegalStateException(AbstractXmlValidator.class.getSimpleName() +  " could not load schema from " + schemaLocation, e);
           }
        }
    }
   
    @Override
    protected boolean isValidContent(String value) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        DocumentBuilder parser;
        try {
            parser = factory.newDocumentBuilder();
            parser.parse(value);
        } catch (Exception e) {
            return false;
        }           
        return true;
    }
    
   
    @Override
    protected boolean isValid(Object object) {
        if (object == null) {
            return true;
        }
       
        try {
            byte[] data = loadFromLocation(object.toString(), locationType);
            if (!isValidContent(new String(data, "UTF-8"))) {
                return false;
            }
            
            if (schema != null) {
                validateSchemaCompliance(new ByteArrayInputStream(data), schema);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    private boolean validateSchemaCompliance(InputStream xml, InputStream xsd) {
        try
        {
            SchemaFactory factory = 
                SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new StreamSource(xsd));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xml));
            return true;
        }
        catch(Exception ex)
        {
            return false;
        }
    }
   


}
