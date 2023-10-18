package edu.ifrs;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.equalTo;

@QuarkusTest
public class StartTest {
//1 - Escreva um teste usando Rest Assured para verificar se a resposta ao chamar o endpoint /getVehicle/{index} com um índice válido retorna um status de resposta 200 OK.
    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/logistics/getVehicle/1")
          .then()
             .statusCode(200);
    }

// 2 - Desenvolva um teste para verificar se o endpoint /getVehicles retorna um status de resposta 200 OK.

    @Test
    public void testHelloEndpoint1() {
        given()
          .when().get("/logistics/getVehicles")
          .then()
             .statusCode(200);
    }

// 3 Escreva um teste para verificar se a lista de veículos retornada ao chamar o endpoint /getVehicles contém pelo menos um veículo.

    @Test
    public void testHelloEndpoint2() {
        given()
          .when().get("/logistics/getVehicles")
          .then()
             .statusCode(200)
             .body("size()", greaterThan(1));
    }

//4 - Desenvolva um teste para verificar se a resposta ao acessar /getVehicles retorna uma lista de veículos com a quantidade correta de elementos com base na lista de veículos no servidor.

    @Test
    public void testHelloEndpoint3() {
        given()
          .when().get("/logistics/getVehicles")
          .then()
             .statusCode(200)
             .body("size()", is(2));
    }

// 5 - Crie um teste para garantir que ao acessar /getVehicles, o primeiro veículo da lista seja igual ao veículo obtido ao acessar /getVehicle/0.
    @Test
    public void testHelloEndpoint4() {
        Response response1 = given()
          .when().get("/logistics/getVehicle/0");
          
        given()
          .when().get("/logistics/getVehicles")
          .then()
             .statusCode(200)
             .body("[0].maximumWeightLimit", equalTo(response1.path("maximumWeightLimit")));
    }

}