package org.kasource.commons.validation.checkdigit.impl;

import org.apache.commons.validator.routines.checkdigit.CheckDigit;
import org.kasource.commons.validation.AbstractValidator;

public abstract class AbstractCheckdigitValidator extends AbstractValidator {

    private CheckDigit checkDigit;
    private String[] separators;
    private boolean allowSeparators;
    private int prefixLength;
    private int suffixLength;
    
    protected void initialize(org.kasource.commons.validation.checkdigit.Checkdigit annotation) {
        checkDigit =  annotation.value().getCheckDigit();
        separators = annotation.separators();
        allowSeparators = annotation.allowSeparators();
        prefixLength = annotation.prefixLength();
        suffixLength = annotation.suffixLength();
    }
    
    @Override
    protected boolean isValid(Object value) {
        if (value == null) {
            return true;
        }
        try {
            String code = value.toString();
            String codeToValidate = code.substring(prefixLength, code.length() - suffixLength);
            
            if (allowSeparators) {
                for (String sep : separators) {
                    codeToValidate = codeToValidate.replace(sep, "");
                }
            }
            return checkDigit.isValid(codeToValidate);
        } catch (Exception e) {
           return false;
        }
       
    }
}
