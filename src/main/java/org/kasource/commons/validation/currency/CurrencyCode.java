package org.kasource.commons.validation.currency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * ISO 4217 Currency Codes.
 * 
 * Note that the IOS standard contains codes that are not pure currencies 
 * such as codes for funds, bonds, commodity and other.
 * 
 * @author rikardwi
 **/
public enum CurrencyCode {
    AED (CurrencyCodeType.CURRENCY, "message.currency.AED", "AE"),
    AFN (CurrencyCodeType.CURRENCY, "message.currency.AFN", "AF"),
    ALL (CurrencyCodeType.CURRENCY, "message.currency.ALL", "AL"),
    AMD (CurrencyCodeType.CURRENCY, "message.currency.AMD", "AM"),
    ANG (CurrencyCodeType.CURRENCY, "message.currency.ANG", "AN", "CW", "SX"),
    AOA (CurrencyCodeType.CURRENCY, "message.currency.AOA", "AO"),
    ARS (CurrencyCodeType.CURRENCY, "message.currency.ARS", "AR"),
    AUD (CurrencyCodeType.CURRENCY, "message.currency.AUD", "AU", "CX", "CC", "HM", "KI", "NR", "NF", "TV"),
    AWG (CurrencyCodeType.CURRENCY, "message.currency.AWG", "AW"),
    AZN (CurrencyCodeType.CURRENCY, "message.currency.AZN", "AZ"),
    BAM (CurrencyCodeType.CURRENCY, "message.currency.BAM", "BA"),
    BBD (CurrencyCodeType.CURRENCY, "message.currency.BBD", "BB"),
    BDT (CurrencyCodeType.CURRENCY, "message.currency.BDT", "BD"),
    BGN (CurrencyCodeType.CURRENCY, "message.currency.BGN", "BG"),
    BHD (CurrencyCodeType.CURRENCY, "message.currency.BHD", "BH"),
    BIF (CurrencyCodeType.CURRENCY, "message.currency.BIF", "BI"),
    BMD (CurrencyCodeType.CURRENCY, "message.currency.BMD", "BM"),
    BND (CurrencyCodeType.CURRENCY, "message.currency.BND", "BN"),
    BOB (CurrencyCodeType.CURRENCY, "message.currency.BOB", "BO"),
    BOV (CurrencyCodeType.FUNDS, "message.currency.BOV", "BO"),
    BRL (CurrencyCodeType.CURRENCY, "message.currency.BRL", "BR"),
    BSD (CurrencyCodeType.CURRENCY, "message.currency.BSD", "BS"),
    BTN (CurrencyCodeType.CURRENCY, "message.currency.BTN", "BT"),
    BWP (CurrencyCodeType.CURRENCY, "message.currency.BWP", "BW"),
    BYR (CurrencyCodeType.CURRENCY, "message.currency.BYR", "BY"),
    BZD (CurrencyCodeType.CURRENCY, "message.currency.BZD", "BZ"),
    CAD (CurrencyCodeType.CURRENCY, "message.currency.CAD", "CA"),
    CDF (CurrencyCodeType.CURRENCY, "message.currency.CDF", "CD"),
    CHE (CurrencyCodeType.COMPLEMENTARY_CURRENCY, "message.currency.CHE", "CH"),
    CHF (CurrencyCodeType.CURRENCY, "message.currency.CHF", "CH", "LI"),
    CHW (CurrencyCodeType.COMPLEMENTARY_CURRENCY, "message.currency.CHW", "CH"),
    CLF (CurrencyCodeType.FUNDS, "message.currency.CLF", "CL"),
    CLP (CurrencyCodeType.CURRENCY, "message.currency.CLP", "CL"),
    CNY (CurrencyCodeType.CURRENCY, "message.currency.CNY", "CN"),
    COP (CurrencyCodeType.CURRENCY, "message.currency.COP", "CO"),
    COU (CurrencyCodeType.FUNDS, "message.currency.COU", "CO"),
    CRC (CurrencyCodeType.CURRENCY, "message.currency.CRC", "CR"),
    CUC (CurrencyCodeType.CURRENCY, "message.currency.CUC", "CU"),
    CUP (CurrencyCodeType.CURRENCY, "message.currency.CUP", "CU"),
    CVE (CurrencyCodeType.CURRENCY, "message.currency.CVE", "CV"),
    CZK (CurrencyCodeType.CURRENCY, "message.currency.CZK", "CZ"),
    DJF (CurrencyCodeType.CURRENCY, "message.currency.DJF", "DJ"),
    DKK (CurrencyCodeType.CURRENCY, "message.currency.DKK", "DK", "FO", "GL"),
    DOP (CurrencyCodeType.CURRENCY, "message.currency.DOP", "DO"),
    DZD (CurrencyCodeType.CURRENCY, "message.currency.DZD", "DZ"),
    EGP (CurrencyCodeType.CURRENCY, "message.currency.EGP", "EG"),
    ERN (CurrencyCodeType.CURRENCY, "message.currency.ERN", "ER"),
    ETB (CurrencyCodeType.CURRENCY, "message.currency.ETB", "ET"),
    EUR (CurrencyCodeType.CURRENCY, "message.currency.EUR", "AD", "AT", "BE", "CY", "EE", "FI", "FR", "DE", "GR", "IE", "IT", "LV", "LU", "MT", "MQ", "YT", "MC", "ME", "NL", "PT", "RE", "SM", "BL", "SK", "SI", "ES", "PM", "VA"),
    FJD (CurrencyCodeType.CURRENCY, "message.currency.FJD", "FJ"),
    FKP (CurrencyCodeType.CURRENCY, "message.currency.FKP", "FK"),
    GBP (CurrencyCodeType.CURRENCY, "message.currency.GBP", "GB", "IM", "JE", "GG", "GS", "IO"),
    GEL (CurrencyCodeType.CURRENCY, "message.currency.GEL", "GE"),
    GHS (CurrencyCodeType.CURRENCY, "message.currency.GHS", "GH"),
    GIP (CurrencyCodeType.CURRENCY, "message.currency.GIP", "GI"),
    GMD (CurrencyCodeType.CURRENCY, "message.currency.GMD", "GM"),
    GNF (CurrencyCodeType.CURRENCY, "message.currency.GNF", "GN"),
    GTQ (CurrencyCodeType.CURRENCY, "message.currency.GTQ", "GT"),
    GYD (CurrencyCodeType.CURRENCY, "message.currency.GYD", "GY"),
    HKD (CurrencyCodeType.CURRENCY, "message.currency.HKD", "HK", "MO"),
    HNL (CurrencyCodeType.CURRENCY, "message.currency.HNL", "HN"),
    HRK (CurrencyCodeType.CURRENCY, "message.currency.HRK", "HR"),
    HTG (CurrencyCodeType.CURRENCY, "message.currency.HTG", "HT"),
    HUF (CurrencyCodeType.CURRENCY, "message.currency.HUF", "HU"),
    IDR (CurrencyCodeType.CURRENCY, "message.currency.IDR", "ID"),
    ILS (CurrencyCodeType.CURRENCY, "message.currency.ILS", "IL", "PS"),
    INR (CurrencyCodeType.CURRENCY, "message.currency.INR", "IN"),
    IQD (CurrencyCodeType.CURRENCY, "message.currency.IQD", "IQ"),
    IRR (CurrencyCodeType.CURRENCY, "message.currency.IRR", "IR"),
    ISK (CurrencyCodeType.CURRENCY, "message.currency.ISK", "IS"),
    JMD (CurrencyCodeType.CURRENCY, "message.currency.JMD", "JM"),
    JOD (CurrencyCodeType.CURRENCY, "message.currency.JOD", "JO"),
    JPY (CurrencyCodeType.CURRENCY, "message.currency.JPY", "JP"),
    KES (CurrencyCodeType.CURRENCY, "message.currency.KES", "KE"),
    KGS (CurrencyCodeType.CURRENCY, "message.currency.KGS", "KG"),
    KHR (CurrencyCodeType.CURRENCY, "message.currency.KHR", "KH"),
    KMF (CurrencyCodeType.CURRENCY, "message.currency.KMF", "KM"),
    KPW (CurrencyCodeType.CURRENCY, "message.currency.KPW", "KP"),
    KRW (CurrencyCodeType.CURRENCY, "message.currency.KRW", "KR"),
    KWD (CurrencyCodeType.CURRENCY, "message.currency.KWD", "KW"),
    KYD (CurrencyCodeType.CURRENCY, "message.currency.KYD", "KY"),
    KZT (CurrencyCodeType.CURRENCY, "message.currency.KZT", "KZ"),
    LAK (CurrencyCodeType.CURRENCY, "message.currency.LAK", "LA"),
    LBP (CurrencyCodeType.CURRENCY, "message.currency.LBP", "LB"),
    LKR (CurrencyCodeType.CURRENCY, "message.currency.LKR", "LK"),
    LRD (CurrencyCodeType.CURRENCY, "message.currency.LRD", "LR"),
    LSL (CurrencyCodeType.CURRENCY, "message.currency.LSL", "LS"),
    LTL (CurrencyCodeType.CURRENCY, "message.currency.LTL", "LT"),
    LYD (CurrencyCodeType.CURRENCY, "message.currency.LYD", "LY"),
    MAD (CurrencyCodeType.CURRENCY, "message.currency.MAD", "MA"),
    MDL (CurrencyCodeType.CURRENCY, "message.currency.MDL", "MD"),
    MGA (CurrencyCodeType.CURRENCY, "message.currency.MGA", "MG"),
    MKD (CurrencyCodeType.CURRENCY, "message.currency.MKD", "MK"),
    MMK (CurrencyCodeType.CURRENCY, "message.currency.MMK", "MM"),
    MNT (CurrencyCodeType.CURRENCY, "message.currency.MNT", "MN"),
    MOP (CurrencyCodeType.CURRENCY, "message.currency.MOP", "MO"),
    MRO (CurrencyCodeType.CURRENCY, "message.currency.MRO", "MR"),
    MUR (CurrencyCodeType.CURRENCY, "message.currency.MUR", "MU"),
    MVR (CurrencyCodeType.CURRENCY, "message.currency.MVR", "MV"),
    MWK (CurrencyCodeType.CURRENCY, "message.currency.MWK", "MW"),
    MXN (CurrencyCodeType.CURRENCY, "message.currency.MXN", "MX"),
    MXV (CurrencyCodeType.FUNDS, "message.currency.MXV", "MX"),
    MYR (CurrencyCodeType.CURRENCY, "message.currency.MYR", "MY"),
    MZN (CurrencyCodeType.CURRENCY, "message.currency.MZN", "MZ"),
    NAD (CurrencyCodeType.CURRENCY, "message.currency.NAD", "NA"),
    NGN (CurrencyCodeType.CURRENCY, "message.currency.NGN", "NG"),
    NIO (CurrencyCodeType.CURRENCY, "message.currency.NIO", "NI"),
    NOK (CurrencyCodeType.CURRENCY, "message.currency.NOK", "NO", "SJ", "BV"),
    NPR (CurrencyCodeType.CURRENCY, "message.currency.NPR", "NP"),
    NZD (CurrencyCodeType.CURRENCY, "message.currency.NZD", "NZ", "CK", "NU", "PN", "TK"),
    OMR (CurrencyCodeType.CURRENCY, "message.currency.OMR", "OM"),
    PAB (CurrencyCodeType.CURRENCY, "message.currency.PAB", "PA"),
    PEN (CurrencyCodeType.CURRENCY, "message.currency.PEN", "PE"),
    PGK (CurrencyCodeType.CURRENCY, "message.currency.PGK", "PG"),
    PHP (CurrencyCodeType.CURRENCY, "message.currency.PHP", "PH"),
    PKR (CurrencyCodeType.CURRENCY, "message.currency.PKR", "PK"),
    PLN (CurrencyCodeType.CURRENCY, "message.currency.PLN", "PL"),
    PYG (CurrencyCodeType.CURRENCY, "message.currency.PYG", "PY"),
    QAR (CurrencyCodeType.CURRENCY, "message.currency.QAR", "QA"),
    RON (CurrencyCodeType.CURRENCY, "message.currency.RON", "RO"),
    RSD (CurrencyCodeType.CURRENCY, "message.currency.RSD", "RS"),
    RUB (CurrencyCodeType.CURRENCY, "message.currency.RUB", "RU"),
    RWF (CurrencyCodeType.CURRENCY, "message.currency.RWF", "RW"),
    SAR (CurrencyCodeType.CURRENCY, "message.currency.SAR", "SA"),
    SBD (CurrencyCodeType.CURRENCY, "message.currency.SBD", "SB"),
    SCR (CurrencyCodeType.CURRENCY, "message.currency.SCR", "SC"),
    SDG (CurrencyCodeType.CURRENCY, "message.currency.SDG", "SD"),
    SEK (CurrencyCodeType.CURRENCY, "message.currency.SEK", "SE"),
    SGD (CurrencyCodeType.CURRENCY, "message.currency.SGD", "SG"),
    SHP (CurrencyCodeType.CURRENCY, "message.currency.SHP", "SH"),
    SLL (CurrencyCodeType.CURRENCY, "message.currency.SLL", "SL"),
    SOS (CurrencyCodeType.CURRENCY, "message.currency.SOS", "SO"),
    SRD (CurrencyCodeType.CURRENCY, "message.currency.SRD", "SR"),
    SSP (CurrencyCodeType.CURRENCY, "message.currency.SSP", "SS"),
    STD (CurrencyCodeType.CURRENCY, "message.currency.STD", "ST"),
    SYP (CurrencyCodeType.CURRENCY, "message.currency.SYP", "SY"),
    SZL (CurrencyCodeType.CURRENCY, "message.currency.SZL", "SZ"),
    THB (CurrencyCodeType.CURRENCY, "message.currency.THB", "TH"),
    TJS (CurrencyCodeType.CURRENCY, "message.currency.TJS", "TJ"),
    TMT (CurrencyCodeType.CURRENCY, "message.currency.TMT", "TM"),
    TND (CurrencyCodeType.CURRENCY, "message.currency.TND", "TN"),
    TOP (CurrencyCodeType.CURRENCY, "message.currency.TOP", "TO"),
    TRY (CurrencyCodeType.CURRENCY, "message.currency.TRY", "TR"),
    TTD (CurrencyCodeType.CURRENCY, "message.currency.TTD", "TT"),
    TWD (CurrencyCodeType.CURRENCY, "message.currency.TWD", "TW"),
    TZS (CurrencyCodeType.CURRENCY, "message.currency.TZS", "TZ"),
    UAH (CurrencyCodeType.CURRENCY, "message.currency.UAH", "UA"),
    UGX (CurrencyCodeType.CURRENCY, "message.currency.UGX", "UG"),
    USD (CurrencyCodeType.CURRENCY, "message.currency.USD", "US", "AS", "BB", "BM", "IO", "VG", "EC", "SV", "GU", "HT", "MH", "FM", "MP", "PW", "PA", "PR", "TL", "TC", "VI", "ZW"),
    USN (CurrencyCodeType.FUNDS, "message.currency.USN", "US"),
    USS (CurrencyCodeType.FUNDS, "message.currency.USS", "US"),
    UYI (CurrencyCodeType.FUNDS, "message.currency.UYI", "UY"),
    UYU (CurrencyCodeType.CURRENCY, "message.currency.UYU", "UY"),
    UZS (CurrencyCodeType.CURRENCY, "message.currency.UZS", "UZ"),
    VEF (CurrencyCodeType.CURRENCY, "message.currency.VEF", "VE"),
    VND (CurrencyCodeType.CURRENCY, "message.currency.VND", "VN"),
    VUV (CurrencyCodeType.CURRENCY, "message.currency.VUV", "VU"),
    WST (CurrencyCodeType.CURRENCY, "message.currency.WST", "WS"),
    XAF (CurrencyCodeType.CURRENCY, "message.currency.XAF", "CM", "CF", "CG", "TD", "GQ", "GA"),
    XAG (CurrencyCodeType.COMMODITY, "message.currency.XAG"),
    XAU (CurrencyCodeType.COMMODITY, "message.currency.XAU"),
    XBA (CurrencyCodeType.BOND, "message.currency.XBA"),
    XBB (CurrencyCodeType.BOND, "message.currency.XBB"),
    XBC (CurrencyCodeType.BOND, "message.currency.XBC"),
    XBD (CurrencyCodeType.BOND, "message.currency.XBD"),
    XCD (CurrencyCodeType.CURRENCY, "message.currency.XCD", "AI", "AG", "DM", "GD", "MS", "KN", "LC", "VC"),
    XDR (CurrencyCodeType.OTHER, "message.currency.XDR"),
    XFU (CurrencyCodeType.OTHER, "message.currency.XDR"),
    XOF (CurrencyCodeType.CURRENCY, "message.currency.XOF", "BJ", "BF", "CI", "GW", "ML", "NE", "SN", "TG"),
    XPD (CurrencyCodeType.COMMODITY, "message.currency.XPD"),
    XPF (CurrencyCodeType.CURRENCY, "message.currency.XPF", "PF", "NC", "WF"),
    XPT (CurrencyCodeType.COMMODITY, "message.currency.XPT"),
    XSU (CurrencyCodeType.OTHER, "message.currency.XSU"),
    XTS (CurrencyCodeType.OTHER, "message.currency.XTS"),
    XUA (CurrencyCodeType.OTHER, "message.currency.XUA"),
    XXX (CurrencyCodeType.OTHER, "message.currency.XXX"),
    YER (CurrencyCodeType.CURRENCY, "message.currency.YER", "YE"),
    ZAR (CurrencyCodeType.CURRENCY, "message.currency.ZAR", "ZA"),
    ZMW (CurrencyCodeType.CURRENCY, "message.currency.ZMW", "ZM"),
    ZWD (CurrencyCodeType.CURRENCY, "message.currency.ZWD", "ZW");
    
    private static final Map<String, Set<CurrencyCode>> COUNTRY_MAPPING = new HashMap<String, Set<CurrencyCode>>();
   
    private static final Map<CurrencyCodeType, List<CurrencyCode>> CODES_BY_TYPE = new HashMap<CurrencyCodeType, List<CurrencyCode>>();
    
    
    static {
        for (CurrencyCode code : CurrencyCode.values()) {
            if (code.getCurrencyType().equals(CurrencyCodeType.CURRENCY) 
                        || code.getCurrencyType().equals(CurrencyCodeType.COMPLEMENTARY_CURRENCY)) {
                Set<String> countries = code.getCountries();
                for (String country : countries) {
                    Set<CurrencyCode> codes = COUNTRY_MAPPING.get(country);
                    if (codes == null) {
                        codes = new HashSet<CurrencyCode>();
                        COUNTRY_MAPPING.put(country, codes);
                    }
                    codes.add(code);
                }
                    
            }
            List<CurrencyCode> codes = CODES_BY_TYPE.get(code.getCurrencyType());
            if (codes == null) {
                codes = new ArrayList<CurrencyCode>();
                CODES_BY_TYPE.put(code.getCurrencyType(), codes);
            }
            codes.add(code);
            
       
        }
    }
    
    private String messageKey;
    private CurrencyCodeType currencyCodeType;
    private Set<String> countries = new HashSet<String>();
    
    CurrencyCode(CurrencyCodeType type, String messageKey, String...country) {
        this.messageKey = messageKey;
        if (country != null) {
            countries.addAll(Arrays.asList(country));
        }
    
    }
    
    public String getMessageKey() {
        return messageKey;
    }

    /**
     * @return the currencyType
     */
    public CurrencyCodeType getCurrencyType() {
        return currencyCodeType;
    }

    /**
     * @return the countries
     */
    public Set<String> getCountries() {
        return countries;
    }
    
    public static Set<CurrencyCode> currencyForCountry(String countryCode) {
        return COUNTRY_MAPPING.get(countryCode);
    }
    
    public static List<CurrencyCode> getAll(CurrencyCodeType type) {
        return CODES_BY_TYPE.get(type);
    }
}
