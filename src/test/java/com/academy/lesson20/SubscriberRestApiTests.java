package com.academy.lesson20;

import com.academy.ddt.page.HomePage;
import com.academy.telesens.lesson11.ht.task3.Gender;
import com.academy.telesens.lesson6.Subscriber;
import io.netty.handler.logging.LogLevel;
import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.response.Response;
import org.apache.http.impl.conn.LoggingSessionOutputBuffer;
import org.apache.logging.log4j.LogManager;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

public class SubscriberRestApiTests {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "http://localhost/rest/json";
        RestAssured.port = 8081;
    }

    @Test
    public void testGetOneSubscriber() {
        Response response = given()
                .get("/subscribers/{id}", 1);

        String body = response.getBody().print();
        int code = response.getStatusCode();
        int id = response.getBody().path("id" );
        String firstName = response.getBody().path("firstName");
        String lastName = response.getBody().path("lastName");

        System.out.println("Body: " + body);

        System.out.println(String.format("code: %s, id: %d, firstName: %s, lastName: %s",
                code, id, firstName, lastName));
    }

    @Test
    public void testGetSubscribers() {
        Response response = given()
                .log().all()
                .get("/subscribers");

        int code = response.getStatusCode();
        String body = response.getBody().print();
        int size = response.getBody().path("size()");
        int id = response.getBody().path("[%s].id", "0");
        String fName = response.getBody().path("[%s].firstName", "0");
        String lastName = response.getBody().path("[%s].lastName", "0");

        System.out.println(code);
        System.out.println(body);
    }

    @Test
    public void testGetAllSubscribers() {
        given()
                .log().all()
                .when()
                .get("/subscribers")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .body("size()", greaterThanOrEqualTo(1))
                .and()
                .body("[0].id", equalTo(1))
                .and()
                .body("[0].firstName", equalTo("Peter"));


    }

    @Test
    public void testAddSubscriber() {
        //1й шаг  - получить тестового абонента (DataProvider)
        //if exists ->delete

//        List<Abonent> before = getAllSubscribers(); // получить размер (количество элементов в json) и добавлять в список абонетов через цикл
//        String json = "{\"firstName\":\"Ivan3\",\"lastName\":\"Ivanov3\",\"age\":22,\"gender\":\"m\"}";
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("firstName", "Ivan"); // Cast
        jsonObj.put("lastName", "Ivanov");
        jsonObj.put("age", 68);
        jsonObj.put("gender", "m");

        given()
                .log().all()
                .header("Content-Type", "application/json")
                .body(jsonObj.toJSONString())
                .post("/subscribers")
                .then()
                .assertThat()
                .header("Location", containsString("http://localhost:8081/rest/json/subscribers"))
                .statusCode(201);

//        List<Abonent> after = getAllSubscribers();
//        after.equals(before+1);
        //отсортировать списки по id
        // assert (переопределить метод equals для subscriber)
    }

    @Test
    public void testUpdateSubscriber() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("id", 6667);
        jsonObj.put("firstName", "Ivan_upd"); // Cast
        jsonObj.put("lastName", "Ivanov_upd");
        jsonObj.put("age", 68);
        jsonObj.put("gender", "m");

        given()
                .log().all()
                .header("Content-Type", "application/json")
                .body(jsonObj.toJSONString())
                .put("/subscribers/6667")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void testDeleteSubscriber() {
        given()
                .log().all()
                .delete("/subscribers/6667")
                .then()
                .assertThat()
                .statusCode(200);
    }

    private List<Subscriber> getAllSubscribers() {
        return new ArrayList<>();
    }

    private Subscriber getSubscriberById(int id) {
        Subscriber subscriber = new Subscriber();
        Response response = given()
                .get("/subscribers/{id}", id);
        if (response.getStatusCode()!=200) {
            return null;
        }
        String body = response.getBody().print();
        int idFromRest = response.getBody().path("id" );
        String firstName = response.getBody().path("firstName");
        String lastName = response.getBody().path("lastName");
        int age = response.getBody().path("age");
        String gender = response.getBody().path("gender");
        subscriber.setId(idFromRest);
        subscriber.setFirstName(firstName);
        subscriber.setLastName(lastName);
        subscriber.setAge(age);
        subscriber.setGender(Gender.parseGender(gender));
        return subscriber;
    }

    private int deleteSubscriber(int id) {
        int code = 200;
        return code;
    }
}