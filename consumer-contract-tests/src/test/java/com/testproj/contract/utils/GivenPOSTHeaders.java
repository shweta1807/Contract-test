package com.hbc.contract.utils;

import com.jayway.restassured.specification.RequestSpecification;

import static com.jayway.restassured.RestAssured.given;

public class GivenPOSTHeaders {
    public static RequestSpecification givenPOSTHeaders() {
        return given().headers(
                "Content-Type", "application/json",
                "Authorization", "Basic YmF0Y2g6VGV0d1JkZSM4Ng==",
                "x-context-id", "2ff2a044-34c3-4dc7-80eb-ed7f8e292802",
                "x-user-id", "sjain",
                "x-channel", "WEB",
                "x-application", "website");
    }
}
