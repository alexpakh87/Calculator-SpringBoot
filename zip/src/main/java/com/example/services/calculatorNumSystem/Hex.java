package com.example.services.calculatorNumSystem;

import com.example.services.calculatorOperations.Operations;


public class Hex implements NumeralSystem {

    @Override
    public int numSystemForRadix() {
        return 16;
    }

    @Override
    public String resultWithNumSystem(int aParse, int bParse, Operations operations) {
        return Integer.toHexString(operations.operation(aParse, bParse));
    }


}
