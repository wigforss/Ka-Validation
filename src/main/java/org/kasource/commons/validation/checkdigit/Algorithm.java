package org.kasource.commons.validation.checkdigit;

import org.apache.commons.validator.routines.checkdigit.ABANumberCheckDigit;
import org.apache.commons.validator.routines.checkdigit.CUSIPCheckDigit;
import org.apache.commons.validator.routines.checkdigit.CheckDigit;
import org.apache.commons.validator.routines.checkdigit.EAN13CheckDigit;
import org.apache.commons.validator.routines.checkdigit.IBANCheckDigit;
import org.apache.commons.validator.routines.checkdigit.ISBNCheckDigit;
import org.apache.commons.validator.routines.checkdigit.ISINCheckDigit;
import org.apache.commons.validator.routines.checkdigit.LuhnCheckDigit;
import org.apache.commons.validator.routines.checkdigit.SedolCheckDigit;
import org.apache.commons.validator.routines.checkdigit.VerhoeffCheckDigit;

public enum Algorithm {
    LUHN("Luhn", new LuhnCheckDigit()), 
    VERHOEFF("Verhoeff", new VerhoeffCheckDigit()),
    ISBN("ISBN", new ISBNCheckDigit()),
    IBAN("IBAN", new IBANCheckDigit()),
    EAN_13_UPC("EAN-13 / UPC", new EAN13CheckDigit()),
    ISIN("ISIN", new ISINCheckDigit()),
    ABAN("ABAN", new ABANumberCheckDigit()),
    CUSIP("CUSIP", new CUSIPCheckDigit()),
    SEDOL("SEDOL", new SedolCheckDigit());
    
    private String algorithmName;
    private CheckDigit checkDigit;
    
    Algorithm(String algorithmName, CheckDigit checkDigit) {
        this.algorithmName = algorithmName;
        this.checkDigit = checkDigit;
    }
    
    public CheckDigit getCheckDigit() {
        return checkDigit;
    }

    /**
     * @return the algorithmName
     */
    public String getAlgorithmName() {
        return algorithmName;
    }
    
}
