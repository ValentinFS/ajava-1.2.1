package ru.netology.rest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

class MobileBankApiTestV1 {
    @Test
    void shouldReturnDemoAccounts() {
        // Given - When - Then
        // Предусловия
        given()
                .baseUri("http://localhost:9999/api/v1")
                .when()
                .get("/demo/accounts")
                .then()
                .statusCode(200)
//                .header("Content-Type","application/json; charset=UTF-8")
                .body("[0].currency", equalTo("RUB"))
                .body("[1].currency", equalTo("RUB"))
                .body("[2].currency", equalTo("RUB"))
                .body(matchesJsonSchemaInClasspath("accounts.schema.json"))
        ;
    }
}