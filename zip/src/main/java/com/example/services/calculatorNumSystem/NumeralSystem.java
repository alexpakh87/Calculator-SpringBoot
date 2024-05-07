package com.example.services.calculatorNumSystem;

import com.example.services.calculatorOperations.Operations;

public interface NumeralSystem {
    int numSystemForRadix();
    String resultWithNumSystem(int aParse, int bParse, Operations operations);
}
