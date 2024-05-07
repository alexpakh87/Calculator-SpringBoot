package com.example.services.calculatorOperations;

import com.example.services.calculatorNumSystem.NumeralSystem;

public interface Operations {
    int operation(int a, int b);
    default String parseNumberDefault(String a, String b, NumeralSystem numeralSystem, Operations operations) {
        int numSystem = numeralSystem.numSystemForRadix();
        int aParse = Integer.valueOf((a), numSystem);
        int bParse = Integer.valueOf((b), numSystem);
        return numeralSystem.resultWithNumSystem(aParse, bParse, operations);
    }
}


