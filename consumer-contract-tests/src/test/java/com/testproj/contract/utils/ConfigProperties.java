package com.hbc.contract.utils;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ConfigProperties {


    public Properties get_property(String env) {

        FileInputStream fileInput = null;
        String filename = "src/main/resources/" +env + "/"+ env +".properties";
        System.out.print(filename);

        try {

            fileInput = new FileInputStream(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties prop = new Properties();

        //load properties file
        try {
            prop.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;

    }
}
