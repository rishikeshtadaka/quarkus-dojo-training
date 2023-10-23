package org.fiserv.dojo.controller;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@QuarkusTest
@Tag("Integration")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestCustomerController {
    @Test
    @Order(1)
    void GetAllCustomers(){
        given()
                .when()
                .get("/customers")
                .then()
                .body("size()",equalTo(0))
                .statusCode(Response.Status.OK.getStatusCode());
    }

    @Test
    @Order(2)
    void GetCustomerById(){

    }


    @Test
    @Order(3)
    void CreateCustomer(){

    }
    @Test
    @Order(4)
    void UpdateCustomer(){

    }
    @Test
    @Order(5)
    void DeleteCustomer(){

    }
}