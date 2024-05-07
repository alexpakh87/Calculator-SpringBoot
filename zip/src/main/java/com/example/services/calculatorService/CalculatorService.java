package com.example.services.calculatorService;


//import com.example.models.User;

import com.example.models.calculator.Calculator;
import com.example.repositorys.CalculatorRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CalculatorService {
    //    @Autowired
    private final CalculatorRepository calculatorRepository;

    public CalculatorService(CalculatorRepository calculatorRepository) {
        this.calculatorRepository = calculatorRepository;
    }

    public void deleteAllCalculate() {
        calculatorRepository.deleteAll();
    }

    public Calculator createCalculate(Calculator calculator) {
        return calculatorRepository.save(calculator);
    }

    public List<Calculator> getAllCalculate() {
        return calculatorRepository.findAll();
    }

    public Optional<Calculator> getCalculateById(Long id) {
        return calculatorRepository.findById(id);
    }

    public List<Calculator> getCalculatorByOperation(String operation) {
        return calculatorRepository.findByOperation(operation);
    }

    public List<Calculator> getCalculatorByTimeOperation(LocalDateTime time) {
        return calculatorRepository.findByTimeOperation(time);
    }

    public List<Calculator> getTimeBetween(LocalDateTime start, LocalDateTime end) {
        return calculatorRepository.findByTimeOperationBetween(start, end);
    }

    public void deleteCalculateById(Long id) {
        calculatorRepository.deleteById(id);
    }

    public List<Calculator> getCalculationByTimeBetweenAndOperationType(LocalDateTime start, LocalDateTime end, String operationType, String numSystemType) {
        return calculatorRepository.findByTimeOperationBetweenAndOperationAndNumSystem(start, end, operationType, numSystemType);
    }

    public Calculator changeCalculation(Long id, Calculator details) {
        Optional<Calculator> calculation = calculatorRepository.findById(id);
        if (calculation.isPresent()) {

            Calculator existingCalculation = calculation.get();
            existingCalculation.setOperation(details.getOperation());
            existingCalculation.setFirstNumber(details.getFirstNumber());
            existingCalculation.setResult(details.getResult());
            existingCalculation.setSecondNumber(details.getSecondNumber());
            existingCalculation.setTimeOperation(LocalDateTime.now());
            existingCalculation.setNumSystem(details.getNumSystem());

            return calculatorRepository.save(existingCalculation);
        }
        return null;
    }
}
