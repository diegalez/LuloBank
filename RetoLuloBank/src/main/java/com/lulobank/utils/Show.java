package com.lulobank.utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class Show {
    public static void information(Class<?> nameClass, String text) {
        Logger LOGGER = LoggerFactory.getLogger(nameClass);
        LOGGER.info(text);
    }
}
