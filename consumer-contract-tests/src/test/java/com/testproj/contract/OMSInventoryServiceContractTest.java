package com.hbc.contract;

import com.hbc.contract.utils.ContractTestConfig;
import com.jayway.restassured.parsing.Parser;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.hbc.contract.utils.GivenPOSTHeaders.givenPOSTHeaders;
import static org.hamcrest.Matchers.*;


public class OMSInventoryServiceContractTest extends ContractTestConfig {

    @Test
    public void POSTOMSInventory_FISCall() throws IOException {

        givenPOSTHeaders().
                body(new String(Files.readAllBytes(Paths.get(env + "/OMSinventoryDetails.json")))).
                when().
                post(_url_OMS_FIS).//.body().prettyPrint();
                then().
                using().defaultParser(Parser.JSON).
                log().ifError().
                statusCode(200).
                body("response", notNullValue()).
                body("response.results.stores.quantity", not(isEmptyString())).
                body("response.results.stores.distance", not(isEmptyString())).
                body("response.results.stores.store_number", not(isEmptyString())).
                body("response.results.stores.store_name", not(isEmptyString())).
                body("response.results.stores.store_hours",not(isEmptyString())).
                body("response.results.stores.bopus_participating", not(isEmptyString()));
        System.out.print("GETOMSInventory_FIS Test Run Result");
    }


        @Test
        public void POSTOMSInventory_InventoryLookupCall() throws IOException {

            givenPOSTHeaders().
                    body(new String(Files.readAllBytes(Paths.get(env + "/OMSinventoryLookUp.json")))).
                    when().
                    post(_url_OMS_lookupInventory).//.body().prettyPrint();
                    then().
                    using().defaultParser(Parser.JSON).
                    log().ifError().
                    statusCode(200).
                    body("items", notNullValue());
            System.out.print("GETOMSInventory_lookup Test Run Result");

        }

    @Test
    public void POSTOMSInventory_ReservationCall() throws IOException {

        givenPOSTHeaders().
                body(new String(Files.readAllBytes(Paths.get(env + "/OMSReservation.json")))).
                when().
                post(_url_OMS_Reservation).//.body().prettyPrint();
                then().
                using().defaultParser(Parser.JSON).
                log().ifError().
                statusCode(200).
        body("items", notNullValue()).
        body("items.item_id", notNullValue()).
        body("items.fulfillment", notNullValue()).
        body("items.fulfillment.inventory_source", notNullValue()).
        body("items.fulfillment.quantity", notNullValue()).
        body("items.fulfillment.availability_date", notNullValue()).
        body("items.reserve_info", notNullValue()).
        body("expiration_date", notNullValue()).
        body("id", notNullValue());

        System.out.print(" Verify reservation response ");

    }
}

