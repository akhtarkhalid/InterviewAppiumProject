package org.aka.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;

public class TestUtils {
    private static String providerName;
    public final static Duration WAIT = Duration.ofSeconds(10);

    public static void setProviderName(String providerName) {
        TestUtils.providerName = providerName;
    }

    public static String getProviderName() {
        return TestUtils.providerName;
    }


    public static Logger log(){
        return LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
    }




}
