package com.example.controllers;

import com.example.models.calculator.Calculator;
import com.example.services.calculatorOperations.OperationFactory;
import com.example.services.calculatorOperations.OperationType;
import com.example.services.calculatorOperations.Operations;
import com.example.services.calculatorService.CalculatorService;
import com.example.services.calculatorNumSystem.NumSystemFactory;
import com.example.services.calculatorNumSystem.NumeralSystem;
import com.example.services.calculatorNumSystem.NumeralSystemType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    //    @Autowired
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping
    public Calculator createCalculate(@RequestBody Calculator calculator) {
        return calculatorService.createCalculate(calculator);
    }

    @GetMapping
    public List<Calculator> getAllCalculate() {
        return calculatorService.getAllCalculate();
    }

    @GetMapping("/{id}")
    public Optional<Calculator> getCalculateById(@PathVariable Long id) {
        return calculatorService.getCalculateById(id);
    }

    @GetMapping("/operation/{operation}")
    public List<Calculator> getCalculationByOperation(@PathVariable String operation) {
        return calculatorService.getCalculatorByOperation(operation);
    }

    @PostMapping("/expression")
    public void addExpression(@RequestParam("operation") String operation,
                              @RequestParam("firstNumber") String a,
                              @RequestParam("secondNumber") String b,
                              @RequestParam("numSystem") String numSystem
    ) {
        NumeralSystem numeralSystemType = NumSystemFactory.createNumSystemType(NumeralSystemType.valueOf(numSystem));
        Operations operationType = OperationFactory.createOperationType(OperationType.valueOf(operation));
        String result = operationType.parseNumberDefault(a, b, numeralSystemType,operationType);
        Calculator calculator = new Calculator(a, operation, b, result, LocalDateTime.now(), numSystem);
        calculatorService.createCalculate(calculator);
    }

    @PutMapping("/{id}")
    Calculator changeCalculation(@PathVariable Long id, @RequestBody Calculator details) {
        return calculatorService.changeCalculation(id, details);
    }

    @DeleteMapping
    public String deleteAllCalculation() {
        calculatorService.deleteAllCalculate();
        return "delete all calculate";
    }

    @DeleteMapping("/{id}")
    public void deleteCalculationById(@PathVariable Long id) {
        calculatorService.deleteCalculateById(id);
    }

    @GetMapping("/timeCalc")
    public List<Calculator> getCalculationByTime(@RequestParam("time") LocalDateTime timeOperation) {
        return calculatorService.getCalculatorByTimeOperation(timeOperation);

    }

    @GetMapping("/betweenDateTime")
    public List<Calculator> timeBetween(@RequestParam("start") LocalDateTime start,
                                        @RequestParam("end") LocalDateTime end) {
        return calculatorService.getTimeBetween(start, end);
    }

    @GetMapping("/timeBetweenAndOperationType")
    public List<Calculator> getCalculationByTimeBetweenAndOperationType(
            @RequestParam("start") LocalDateTime start,
            @RequestParam("end") LocalDateTime end,
            @RequestParam("operationType") String operationType,
            @RequestParam("numSystemType")String numSystemType) {
        return calculatorService.getCalculationByTimeBetweenAndOperationType(start, end, operationType,numSystemType);
    }

}
