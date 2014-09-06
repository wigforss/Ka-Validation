package org.kasource.validation.ip.impl;

import java.net.Inet6Address;
import java.net.UnknownHostException;

import org.apache.commons.validator.routines.InetAddressValidator;
import org.kasource.validation.AbstractValidator;


public abstract class AbstractIpAddressValidator extends AbstractValidator {
    
    private InetAddressValidator ip4Validator = InetAddressValidator.getInstance();
    protected boolean ip4Only;
    
    @Override
    protected boolean isValid(Object value) {
        if (value == null) {
            return true;
        } else if (value.toString().trim().isEmpty()) {
            return false;
        }
        
        if (ip4Only) {
            return ip4Validator.isValid(value.toString());
        } else {    
            try {
    
                Inet6Address.getByName(value.toString());
                return true;
            } catch (UnknownHostException uhe) {
                return false;
            }
        }
    }
}
