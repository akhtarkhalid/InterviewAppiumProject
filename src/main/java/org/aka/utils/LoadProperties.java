package org.aka.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadProperties {
    private static final Properties PROP = new Properties();
    public static Properties getProperties(){
        InputStream inputStream = null;
        try{
        String propName = "test.properties";
        if(PROP.isEmpty()){

            TestUtils.log().info("loading test configurations..");
                inputStream = LoadProperties.class.getClassLoader().getResourceAsStream(propName);
                PROP.load(inputStream);
        }
        }catch(IOException ioe){
            TestUtils.log().error(ioe.getMessage());
            TestUtils.log().error("Failed to load configurations...");
        }catch(Exception e){
            TestUtils.log().error(e.getMessage());
            TestUtils.log().error("An error occured..");
        }finally{
            if(inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return PROP;
    }
}