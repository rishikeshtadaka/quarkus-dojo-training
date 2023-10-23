package org.fiserv.dojo.controller;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

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
                .body("size()",equalTo(2))
                .body("id",hasItems(1,2))
                .body("firstName",hasItems("fn-1","fn-2"))
                .statusCode(Response.Status.OK.getStatusCode());
    }

    @Test
    @Order(2)
    void GetCustomerById(){
        given()
                .when()
                .get("/customers/1")
                .then()
                .body("id",equalTo(1))
                .body("firstName",equalTo("fn-1"))
                .statusCode(Response.Status.OK.getStatusCode());
    }


    @Test
    @Order(3)
    void CreateCustomer(){
        JsonObject jsonObject= Json.createObjectBuilder()
                .add("firstName","fn3")
                .add("lastName","ln3")
                .add("address","addr3")
                .build();
        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(jsonObject.toString())
                .when()
                .post("/customers")
                .then()
                .statusCode(Response.Status.CREATED.getStatusCode());
    }
    @Test
    @Order(4)
    void UpdateCustomer(){
        JsonObject jsonObject= Json.createObjectBuilder()
                .add("firstName","updated")
                .add("lastName","ln3")
                .add("address","addr3")
                .build();
        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(jsonObject.toString())
                .when()
                .put("/customers/1")
                .then()
                .statusCode(Response.Status.OK.getStatusCode());
    }
    @Test
    @Order(5)
    void DeleteCustomer(){
        given()
                .when()
                .delete("/customers/1")
                .then()
                .statusCode(Response.Status.OK.getStatusCode());

        given()
                .when()
                .get("/customers/1")
                .then()
                .statusCode(Response.Status.NO_CONTENT.getStatusCode());
    }
}
