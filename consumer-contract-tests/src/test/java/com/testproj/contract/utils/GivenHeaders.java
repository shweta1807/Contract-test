package com.hbc.contract.utils;

import com.jayway.restassured.response.Header;
import com.jayway.restassured.response.Headers;
import com.jayway.restassured.specification.RequestSpecification;

import static com.jayway.restassured.RestAssured.given;
import static java.util.Arrays.asList;
import static java.util.UUID.randomUUID;

public class GivenHeaders {
    public static RequestSpecification givenHeaders() {
        return given().headers(new Headers(asList(
                new Header( "x-channel", "WEB"),
                new Header( "x-application", "PORTAL" ),
                new Header( "x-user-id", "contract-user" ),
                new Header( "x-context-id", randomUUID().toString() ),
                new Header( "Authorization", "Basic YmF0Y2g6VGV0d1JkZSM4Ng==")
        )));
    }
}
