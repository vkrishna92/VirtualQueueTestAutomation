package com.virtualqueue.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    private static Properties properties = new Properties();
    private static boolean isLoaded = false;

    private PropertyReader() {
        // Prevent instantiation
    }

    /**
     * Loads the properties file only once.
     * Env is taken from system property `env`, defaults to "dev"
     */
    public static void loadProperties(String env) {
        if (!isLoaded) {
            String filePath = String.format("src/test/resources/config/%s.properties", env);

            try (InputStream input = new FileInputStream(filePath)) {
                properties.load(input);
                isLoaded = true;
                System.out.println("Properties loaded from: " + filePath);
            } catch (IOException e) {
                throw new RuntimeException("Failed to load properties file: " + filePath, e);
            }
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
}
