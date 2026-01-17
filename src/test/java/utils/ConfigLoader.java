package utils;

import java.util.Properties;

public class ConfigLoader {
    private final Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader(){
        properties = PropertyUtils.propertyLoader("src/test/resources/config.properties");
    }
    public static ConfigLoader getInstance(){
        if(configLoader == null){
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public String getBaseUrl(){
        String prop = properties.getProperty("baseUrl");
        if(prop != null) return prop;
        else throw new RuntimeException("Property baseUrl is not specified in the step_config.properties file");
    }

    public String getChrome(){
        String prop =properties.getProperty("chromeDriverPath");
        if(prop!= null) return prop;
        else throw new RuntimeException("Property Chrome path is not specified in step_config.propertiesfile");
    }

    public String getFirefox(){
        String prop =properties.getProperty("firefoxDriverPath");
        if(prop!= null) return prop;
        else throw new RuntimeException("Property Firefox path is not specified in step_config.propertiesfile");
    }
    public String getEdge(){
        String prop = properties.getProperty("edgeDriverPath");
            if (prop != null) return prop;
            else throw new RuntimeException("Property Edge path is not specified in step_config.properties file");
        }
    }



