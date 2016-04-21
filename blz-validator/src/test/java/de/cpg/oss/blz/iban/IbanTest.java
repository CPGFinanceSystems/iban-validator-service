package de.cpg.oss.blz.iban;

import org.junit.Test;

public class IbanTest {

    @Test(expected = IllegalArgumentException.class)
    public void parseTest1() throws IbanParseException {
        Iban.parse("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseTest2() throws IbanParseException {

        Iban.parse(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseTest3() throws IbanParseException {
        Iban.parse("DE");
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseTest4() throws IbanParseException {
        Iban.parse("DE11");
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseTest5() throws IbanParseException {
        Iban.parse("001122");
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseTest6() throws IbanParseException {
        Iban.parse("DE1122");
    }

    @Test(expected = IbanParseException.class)
    public void parseTest7() throws IbanParseException {
        Iban.parse("DE08700901001234567891");
    }

    @Test
    public void parseTest8() throws IbanParseException {
        Iban.parse("AL47 2121 1009 0000 0002 3569 8741");
        Iban.parse("AD12 0001 2030 2003 5910 0100");
        Iban.parse("AT61 1904 3002 3457 3201");
        Iban.parse("AZ21 NABZ 0000 0000 1370 1000 1944");
        Iban.parse("BH67 BMAG 0000 1299 1234 56");
        Iban.parse("BE62 5100 0754 7061");
        Iban.parse("BA39 1290 0794 0102 8494");
        Iban.parse("BG80 BNBG 9661 1020 3456 78");
        Iban.parse("HR12 1001 0051 8630 0016 0");
        Iban.parse("CY17 0020 0128 0000 0012 0052 7600");
        Iban.parse("CZ65 0800 0000 1920 0014 5399");
        Iban.parse("DK50 0040 0440 1162 43");
        Iban.parse("EE38 2200 2210 2014 5685");
        Iban.parse("FO97 5432 0388 8999 44");
        Iban.parse("FI21 1234 5600 0007 85");
        Iban.parse("FR14 2004 1010 0505 0001 3M02 606");
        Iban.parse("GE29 NB00 0000 0101 9049 17");
        Iban.parse("DE89 3704 0044 0532 0130 00");
        Iban.parse("GI75 NWBK 0000 0000 7099 453");
        Iban.parse("GR16 0110 1250 0000 0001 2300 695");
        Iban.parse("GL56 0444 9876 5432 10");
        Iban.parse("HU42 1177 3016 1111 1018 0000 0000");
        Iban.parse("IS14 0159 2600 7654 5510 7303 39");
        Iban.parse("IE29 AIBK 9311 5212 3456 78");
        Iban.parse("IL62 0108 0000 0009 9999 999");
        Iban.parse("IT40 S054 2811 1010 0000 0123 456");
        Iban.parse("JO94 CBJO 0010 0000 0000 0131 0003 02");
        Iban.parse("KW81 CBKU 0000 0000 0000 1234 5601 01");
        Iban.parse("LV80 BANK 0000 4351 9500 1");
        Iban.parse("LB62 0999 0000 0001 0019 0122 9114");
        Iban.parse("LI21 0881 0000 2324 013A A");
        Iban.parse("LT12 1000 0111 0100 1000");
        Iban.parse("LU28 0019 4006 4475 0000");
        Iban.parse("MK072 5012 0000 0589 84");
        Iban.parse("MT84 MALT 0110 0001 2345 MTLC AST0 01S");
        Iban.parse("MU17 BOMM 0101 1010 3030 0200 000M UR");
        Iban.parse("MD24 AG00 0225 1000 1310 4168");
        Iban.parse("MC93 2005 2222 1001 1223 3M44 555");
        Iban.parse("ME25 5050 0001 2345 6789 51");
        Iban.parse("NL39 RABO 0300 0652 64");
        Iban.parse("NO93 8601 1117 947");
        Iban.parse("PK36 SCBL 0000 0011 2345 6702");
        Iban.parse("PL60 1020 1026 0000 0422 7020 1111");
        Iban.parse("PT50 0002 0123 1234 5678 9015 4");
        Iban.parse("QA58 DOHB 0000 1234 5678 90AB CDEF G");
        Iban.parse("RO49 AAAA 1B31 0075 9384 0000");
        Iban.parse("SM86 U032 2509 8000 0000 0270 100");
        Iban.parse("SA03 8000 0000 6080 1016 7519");
        Iban.parse("RS35 2600 0560 1001 6113 79");
        Iban.parse("SK31 1200 0000 1987 4263 7541");
        Iban.parse("SI56 1910 0000 0123 438");
        Iban.parse("ES80 2310 0001 1800 0001 2345");
        Iban.parse("SE35 5000 0000 0549 1000 0003");
        Iban.parse("CH93 0076 2011 6238 5295 7");
        Iban.parse("TN59 1000 6035 1835 9847 8831");
        Iban.parse("TR33 0006 1005 1978 6457 8413 26");
        Iban.parse("AE07 0331 2345 6789 0123 456");
    }
}
