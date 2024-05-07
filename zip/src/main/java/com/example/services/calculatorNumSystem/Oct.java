package com.example.services.calculatorNumSystem;

import com.example.services.calculatorOperations.Operations;

public class Oct implements NumeralSystem{
    @Override
    public int numSystemForRadix() {
        return 8;
    }

    @Override
    public String resultWithNumSystem(int aParse, int bParse, Operations operations) {
        return Integer.toOctalString(operations.operation(aParse,bParse));
    }
}
