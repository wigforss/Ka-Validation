package org.kasource.validation.currency.impl;

import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.AbstractValidator;
import org.kasource.validation.currency.Currency;
import org.kasource.validation.currency.CurrencyCode;
import org.kasource.validation.currency.CurrencyCodeType;

public abstract class AbstractCurrencyValidator extends AbstractValidator {
   
   
    private Map<String, CurrencyCode> values = new HashMap<String, CurrencyCode>(); 
    private CurrencyCodeType currencyType;
    private boolean caseSensetive;
    private int numberOfConfiguredCurrencies = 0;
    
    protected void initialize(final Currency annotation) {
        currencyType = annotation.currencyType();
        caseSensetive = annotation.caseSensetive();
        if (annotation.value().length == 0) {
            addAllCurrencies();
        } else {
            numberOfConfiguredCurrencies = annotation.value().length;
            addCurrencies(annotation.value());
        }    
    }
    
    protected void setConstraintMessage(ConstraintValidatorContext context) {
        if (numberOfConfiguredCurrencies > 0) {
            String suffix = ".one";
            if (numberOfConfiguredCurrencies > 1) {
                suffix = ".many";
            }
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("{org.kasource.validation.currency.Currency.alt"+suffix+"}").addConstraintViolation();
        }
    }
    
    private void addCurrencies(CurrencyCode[] currencies) {
        for (CurrencyCode currency : currencies) {
            values.put(currency.toString(), currency);
        }
    }
    
    private void addAllCurrencies() {
        Object[] constants = CurrencyCode.class.getEnumConstants();
        
        for (Object constant : constants) {
            values.put(constant.toString(), CurrencyCode.valueOf(constant.toString()));
        }
    }
    
    @Override
    protected boolean isValid(Object value) {      
        if (value == null) {
            return true;
        }
        boolean isValid = false;
        String currency = value.toString();
        if (!caseSensetive) {
           currency = currency.toUpperCase();
        } 
        CurrencyCode code = values.get(currency);
        if (code != null) {
            isValid = code.getCurrencyType().equals(currencyType);
        }
       
        return isValid;
       
    }
}
