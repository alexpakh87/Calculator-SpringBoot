package com.example.repositorys;

import com.example.models.calculator.Calculator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public interface CalculatorRepository extends JpaRepository<Calculator, Long> {

    List<Calculator> findByOperation(String operation);

    List<Calculator> findByTimeOperation(LocalDateTime time);

    List<Calculator> findByTimeOperationBetween(LocalDateTime start, LocalDateTime end);

    List<Calculator> findByTimeOperationBetweenAndOperationAndNumSystem(LocalDateTime start, LocalDateTime end, String operationType, String numSystem);
}
