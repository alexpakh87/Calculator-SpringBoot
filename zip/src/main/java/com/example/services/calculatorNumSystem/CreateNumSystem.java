package com.example.services.calculatorNumSystem;

public class CreateNumSystem {
    public static NumeralSystem createNumeralSystem(String numeralSystemType) {

        return NumSystemFactory.createNumSystemType(NumeralSystemType.valueOf(numeralSystemType));
    }
}
