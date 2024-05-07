package com.example.services.calculatorNumSystem;

import com.example.services.calculatorOperations.Operations;

public class Bin implements NumeralSystem {

    @Override
    public int numSystemForRadix() {
        return 2;
    }

    @Override
    public String resultWithNumSystem(int aParse, int bParse, Operations operations) {

        return Integer.toBinaryString(operations.operation(aParse,bParse));
    }
}
