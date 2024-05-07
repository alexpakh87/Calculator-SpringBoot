package com.example.services.calculatorNumSystem;

public class NumSystemFactory {
    public static NumeralSystem createNumSystemType(NumeralSystemType numeralSystemType) {


        NumeralSystem numeralSystem;
        numeralSystem = switch (numeralSystemType) {
            case BIN -> new Bin();
            case OCT -> new Oct();
            case DEC -> new Dec();
            case HEX -> new Hex();
        };
        return numeralSystem;
    }
}