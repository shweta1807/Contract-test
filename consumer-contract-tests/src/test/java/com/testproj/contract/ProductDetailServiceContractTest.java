package com.hbc.contract;

import com.hbc.contract.utils.ContractTestConfig;
import com.jayway.restassured.parsing.Parser;
import org.junit.Test;

import static com.hbc.contract.utils.GivenHeaders.givenHeaders;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.not;

public class ProductDetailServiceContractTest extends ContractTestConfig {

    @Test
    public void GETProduct_ProductInventoryCall() {
        //To Check Store availability of the Products

        givenHeaders().
                when().
                get(_url_product).//.body().prettyPrint();
          then().
          using().defaultParser(Parser.JSON).
                log().ifError().
          statusCode(200).
           body("response", not(isEmptyString()));
        System.out.print("GETPRODUCT_Inventory Test Run Result");
    }

    @Test
    public void GETProductService_ProductCall() {
    //To Check Product BOPUS Flag
        givenHeaders().
                when().
                get(_url_prodservice).//.body().prettyPrint();
                then().
                using().defaultParser(Parser.JSON).
                log().ifError().
                statusCode(200).
        body("response", not(isEmptyString()));
        System.out.print("GETProductService_ProductCall Test Run Result");
    }


}

