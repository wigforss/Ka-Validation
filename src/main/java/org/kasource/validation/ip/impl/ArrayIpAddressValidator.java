package org.kasource.validation.ip.impl;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.ip.IpAddress;

public class ArrayIpAddressValidator extends AbstractIpAddressValidator implements ConstraintValidator<IpAddress, Object[]> {

    @Override
    public void initialize(IpAddress ipAddress) {
        ip4Only = ipAddress.ip4Only();     
    }

    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {
        return isValidArray(value);
    }

}
