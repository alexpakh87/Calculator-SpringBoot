package com.example.controllers;

import com.example.repositorys.CalculatorRepository;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.IsEqual.equalTo;

@Testcontainers
@SpringBootTest
@AutoConfigureMockMvc
class CalculatorControllerTest {
    @Container
    @ServiceConnection
    public static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:15.3");


    @Autowired
    CalculatorRepository calculatorRepository;

    @Test
    void findAllCalculationTest() throws Exception {

        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/calculator")
                .then()
                .statusCode(200)
                .body(".", hasSize(2));

    }

    @Test
    void findByIdCalculationTest() throws Exception {

        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/calculator/2")
                .then()
                .statusCode(200)
                .body("id", equalTo(2),
                        "numSystem", equalTo("DEC"),
                        "firstNumber", equalTo("1"),
                        "secondNumber", equalTo("1"),
                        "timeOperation", equalTo("2024-03-22T19:51:37.717353"),
                        "result",equalTo("2")
                );

    }

    @Test
    void findCalculationByFilterTest() throws Exception {

        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/calculator/timeBetweenAndOperationType?start=2024-03-22T15:51:06.526295" +
                        "&end=2024-03-22T20:45:05.463031&operationType=SUM&numSystemType=DEC")
                .then()
                .statusCode(200)
                .body(".", hasSize(2));

    }

}