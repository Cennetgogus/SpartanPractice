package com.spartantest.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    // first step, create the object of properties
    private static Properties properties = new Properties();
    static {
        try {
            // getting the path and open the file
            FileInputStream file=new FileInputStream("configuration.properties");

            //load the opened file into properties object
            properties.load(file);

            // close the file in JVM memory
            file.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    // used the object to read from the configuration.properties
    public static String getProperty(String keyword){
        return properties.getProperty(keyword);
    }
}
