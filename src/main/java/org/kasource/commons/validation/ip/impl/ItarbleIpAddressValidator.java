package org.kasource.commons.validation.ip.impl;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.commons.validation.ip.IpAddress;

public class ItarbleIpAddressValidator extends AbstractIpAddressValidator implements ConstraintValidator<IpAddress, Iterable<? extends Object>> {

    @Override
    public void initialize(IpAddress ipAddress) {
        ip4Only = ipAddress.ip4Only();     
    }

    @Override
    public boolean isValid(Iterable<? extends Object> value, ConstraintValidatorContext context) {
        return isValidItarable(value);
    }

}
