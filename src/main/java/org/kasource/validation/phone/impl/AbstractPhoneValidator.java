package org.kasource.validation.phone.impl;

import java.math.BigInteger;
import java.util.Locale;

import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.AbstractValidator;
import org.kasource.validation.phone.Phone;

import com.google.i18n.phonenumbers.MetadataLoader;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
public abstract class AbstractPhoneValidator extends AbstractValidator {
    private static final String[] SEPERATORS = {" ", "+", "-", "(", ")", "."};
    private String country;
    
    
    protected void initialize(Phone annotation) {
       if (!annotation.country().isEmpty()) {
           country = annotation.country();
       }
        
    }
    
    @Override
    protected boolean isValid(Object value) {
        if (value == null) {
            return true;
        }
       if (country != null && !country.isEmpty()) {
           PhoneNumberUtil util = PhoneNumberUtil.getInstance();
           PhoneNumber number;
            try {
                number = util.parse(value.toString(), country);
                return util.isPossibleNumber(number) && util.isValidNumber(number);
            } catch (NumberParseException e) {
               return false;
            }
                   
       } else {
           return defaultValidator(value.toString());
       }
        
    }
    
    /**
     * Return true if the value is an integer when all separators
     * has been stripped.
     * 
     * @param value Value to validate.
     * 
     * @return true if the value is an integer when all separators
     * has been stripped.
     */
    private boolean defaultValidator(String value) {
        try {
            new BigInteger(stripSeperators(value));
            return true;
        } catch(NumberFormatException nfe) {
            return false;
        }
    }
    
    private String stripSeperators(final String phoneNumber) {
        String number = phoneNumber;
        for (String separator : SEPERATORS) {
            number = number.replace(separator, "");
        }
        return number;
    }
    
    protected void setConstraintMessage(ConstraintValidatorContext context) {
        if (country != null && !country.isEmpty()) {
            String countryName = new Locale("", country).getDisplayCountry(Locale.getDefault());
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("{org.kasource.validation.phone.Phone} " + countryName).addConstraintViolation();
        }
    }
}
