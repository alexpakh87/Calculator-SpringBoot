package com.example.models.calculator;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "myTable")
public class Calculator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numSystem;
    private String firstNumber;
    private String secondNumber;
    private LocalDateTime timeOperation;
    private String result;
    private String operation;


    public Calculator() {
    }

    public String getNumSystem() {
        return numSystem;
    }

    public void setNumSystem(String numSystem) {
        this.numSystem = numSystem;
    }

    public Calculator(String a, String operation, String b, String result, LocalDateTime timeOperation, String numSystem) {
        this.firstNumber = String.valueOf(a);
        this.secondNumber = String.valueOf(b);
        this.operation = operation;
        this.result = String.valueOf(result);
        this.timeOperation = timeOperation;
        this.numSystem = numSystem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(String firstNumber) {
        this.firstNumber = firstNumber;
    }

    public String getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(String secondNumber) {
        this.secondNumber = secondNumber;
    }

    public LocalDateTime getTimeOperation() {
        return timeOperation;
    }

    public void setTimeOperation(LocalDateTime timeOperation) {
        this.timeOperation = timeOperation;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
