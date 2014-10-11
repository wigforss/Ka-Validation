package org.kasource.validation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Iterator;

import org.apache.commons.io.IOUtils;

public abstract class AbstractValidator {

    private static final String FILE_PREFIX = "file:";
    private static final String CLASSPATH_PREFIX = "classpath:";

    protected boolean isValidArray(Object[] value) {
        if (value == null) {
            return true;
        }    
     
        for (Object element : value) {
         
            if (!isValid(element)) {
                return false;
            }
        }
        return true;
    }
    
    
    protected boolean isValidItarable(Iterable<? extends Object> value) {
        if (value == null) {
            return true;
        }    
        Iterator<? extends Object> iter = value.iterator();
        while (iter.hasNext()) {
            Object element = iter.next();
            if (!isValid(element)) {
                return false;
            }
        }
        return true;
    }
    
    protected abstract boolean isValid(Object object);
    
 
    
    protected byte[] loadFromLocation(String location) throws Exception {
        
        if (asUrl(location.trim()) != null){
            return loadFromUrl(asUrl(location.trim()));
        } else if (location.startsWith(CLASSPATH_PREFIX)) {
            return loadFromClasspath(location);
        } else if (location.startsWith(FILE_PREFIX)) {
            return loadFromFile(location);
        } else {
            return location.getBytes(Charset.forName("UTF-8"));
        }
    }
   
    
   
    
    protected byte[] loadFromClasspath(String location) throws IOException {
        if (location.startsWith(CLASSPATH_PREFIX)) {
            location = location.substring(CLASSPATH_PREFIX.length());
        }
        InputStream is = getClass().getResourceAsStream(location);
        byte[] data = IOUtils.toByteArray(is);
        is.close();
        return data;
    }
    
    protected byte[] loadFromUrl(URL schemaLocation) throws IOException {
        return IOUtils.toByteArray(schemaLocation.openConnection());
    }
    
    protected byte[] loadFromFile(String schemaLocation) throws FileNotFoundException, IOException {
        return IOUtils.toByteArray(new FileInputStream(schemaLocation));
    }
    
    private URL asUrl(String url) {
        try {
            return new URL(url);
        } catch (MalformedURLException e) {
           return null;
        }
    }
    
}
