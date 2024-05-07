package com.example.services.calculatorOperations;

public class OperationFactory {
    public static Operations createOperationType(OperationType operationType) {
        Operations operations = null;
        switch (operationType) {
            case SUM:
                operations = new Sum();
                break;
            case SUB:
                operations = new Sub();
                break;
            case MUL:
                operations = new Mul();
                break;
            case DIV:
                operations = new Div();
                break;
        }
        return operations;
    }
}




