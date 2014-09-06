package org.kasource.validation.ip.impl;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.ip.IpAddress;



public class IpAddressValidator extends AbstractIpAddressValidator implements ConstraintValidator<IpAddress, String> {

    @Override
    public void initialize(final IpAddress ipAddress) {
        ip4Only = ipAddress.ip4Only();
    }

    @Override
    public final boolean isValid(final String value,
                                 final ConstraintValidatorContext context) {
        return isValid(value);
    }
}
