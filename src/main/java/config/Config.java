package config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    private static final Logger LOGGER = LoggerFactory.getLogger(Config.class);
    private static final Properties prop = new Properties();

    static {
        InputStream is = Config.class.getClassLoader().getResourceAsStream("config.properties");
        if (is != null) {
            try {
                prop.load(is);
                is.close();
            } catch (IOException e) {
                LOGGER.error(e.getMessage());
            }
        } else {
            throw new AssertionError("Couldn't get environment properties from file \"config.properties\"");
        }
    }

    public static String getBaseUrl() {
        return prop.getProperty("url");
    }
}
