package com.example.services.calculatorNumSystem;

import com.example.services.calculatorOperations.Operations;

public class Dec implements NumeralSystem {
    @Override
    public int numSystemForRadix() {
        return 10;
    }

    @Override
    public String resultWithNumSystem(int aParse, int bParse, Operations operations) {
        return String.valueOf(operations.operation(aParse, bParse));
    }
}
