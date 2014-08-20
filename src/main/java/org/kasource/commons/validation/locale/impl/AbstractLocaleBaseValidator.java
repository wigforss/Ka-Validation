package org.kasource.commons.validation.locale.impl;

import java.util.HashSet;
import java.util.Set;

import org.kasource.commons.validation.AbstractValidator;



public abstract class AbstractLocaleBaseValidator extends AbstractValidator {
    private static final Set<String> LOCALE_CODES = new HashSet<String>();
    private static final Set<String> LOCALE_CODES_LC = new HashSet<String>();
    private static final Set<String> LANGS = new HashSet<String>();
    private static final Set<String> COUNTRY_CODES = new HashSet<String>();
    
    static {
        java.util.Locale[] locales = java.util.Locale.getAvailableLocales();
        for (java.util.Locale locale : locales) {
            String lang = locale.getLanguage();
            String country = locale.getCountry();
            
            String code = null;
            if (!country.isEmpty() && !lang.isEmpty()) {
                code = lang + "-" + country;
            } else if (country.isEmpty()) {
                code = lang;
            } else {
                code = country;
            }
            LOCALE_CODES.add(code);
            LOCALE_CODES_LC.add(code.toLowerCase());
        }
        for (String code : java.util.Locale.getISOCountries()) {
            COUNTRY_CODES.add(code);
        }
        for (String code : java.util.Locale.getISOLanguages()) {
            LANGS.add(code);
        }
    }
    
    
    protected boolean isValidLocale(Object value, boolean caseSensetive) {
        if (value == null) {
            return true;
        }  
        if (caseSensetive) {
            return LOCALE_CODES.contains(value.toString());
        } else {
            return LOCALE_CODES_LC.contains(value.toString().toLowerCase());
        }
    }
    
    protected boolean isValidLanguage(Object value, boolean caseSensetive) {
        if (value == null) {
            return true;
        }  
        String code = value.toString();
        if (!caseSensetive) {
            code = code.toLowerCase();
        }
        return LANGS.contains(value.toString());
    }
    
    protected boolean isValidCountry(Object value, boolean caseSensetive) {
        if (value == null) {
            return true;
        }  
        String code = value.toString();
        if (!caseSensetive) {
            code = code.toUpperCase();
        }
        return COUNTRY_CODES.contains(code);
    }
}
