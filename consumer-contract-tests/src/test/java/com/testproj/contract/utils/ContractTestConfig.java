package com.hbc.contract.utils;



import java.util.Properties;

public class ContractTestConfig {

    public  String env = System.getProperty("env"); //
    protected final Properties getProperty;
    protected final String _url_product;
    protected final String _url_OMS_FIS;
    protected final String _url_OMS_lookupInventory;
    protected final String _url_prodservice;
    protected final String _productId;
    protected final String _url_OMS_Reservation;


    public ContractTestConfig() {
        if( env == null ) env = "local";

        getProperty = new ConfigProperties().get_property(env);
       // _url = getProperty.getProperty("url");
        _url_product = getProperty.getProperty("url_product");
        _url_OMS_FIS = getProperty.getProperty("url_OMS_FIS");
        _url_OMS_lookupInventory = getProperty.getProperty("url_OMS_lookupInventory");
        _url_prodservice = getProperty.getProperty("url_prodservice");
        _productId = getProperty.getProperty("productId");
        _url_OMS_Reservation=getProperty.getProperty("url_reservation");

        env = "src/main/resources/"+ env;
        System.out.print(env);
    }
}
