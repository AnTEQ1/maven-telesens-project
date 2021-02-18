package com.academy.telesens.lesson20;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.json.simple.JSONObject;

public class RestSamples {
    public static void main(String[] args) {
        RestAssured.baseURI = "http://localhost/rest/json/";
        RestAssured.port = 8081;
        getOneSubscriberDemo();
        getAllSubscribersDemo();
        addSubscriberDemo();
        updateSubscriber();
        deleteSubscriber();

    }

    private static void deleteSubscriber() {
        Response response = RestAssured.given().delete("subscribers/2");
        int code = response.getStatusCode();
        System.out.println(code);
    }

    private static void updateSubscriber() {
        JSONObject json = new JSONObject();
        json.put("id",6668);
        json.put("firstName", "test2Update");
        json.put("lastName", "testLast2Update");
        json.put("age", 55);
        json.put("gender", "m");

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(json.toJSONString())
                .put("/subscribers/6668");
        int code = response.getStatusCode();
        System.out.println("***updateSubscriber***");
        System.out.println(code);


    }

    private static void addSubscriberDemo() {
        String json = generateSubscriberJson();
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(json)
                .post("subscribers");
        int code = response.getStatusCode();
        String location = response.getHeader("Location");

        System.out.println("***addSubscriberDemo***");
        System.out.println(code);
        System.out.println(location);
    }

    private static void getAllSubscribersDemo() {
        Response response = RestAssured.given().get("subscribers");

        int code = response.getStatusCode();
        ResponseBody body = response.getBody();
        String json = body.print();
        int size = body.path("size()");
        int id = body.path("[%s].id","0");
        String firstName = body.path("[%s].firstName", "0");

        System.out.println("***getAllSubscribersDemo***");
        System.out.println("code " + code);
        System.out.println("json " + json);
        System.out.println("size " + size);
        System.out.println("id " + id);
        System.out.println("firstName " + firstName);
    }

    private static void getOneSubscriberDemo() {
        Response response = RestAssured.given().get("subscribers/1");

        int code = response.getStatusCode();
        ResponseBody body = response.getBody();
        String json = body.print();
        System.out.println(code);
        System.out.println(json);

        int id = body.path("id");
        String firstName = body.path("firstName");
        System.out.println("***getOneSubscriberDemo***");
        System.out.println(id);
        System.out.println(firstName);
    }

    private static String generateSubscriberJson() {
        JSONObject json = new JSONObject();

        json.put("id",2);
        json.put("firstName", "test2");
        json.put("lastName", "testLast2");
        json.put("age", 25);
        json.put("gender", "m");

        return json.toJSONString();
    }
}
