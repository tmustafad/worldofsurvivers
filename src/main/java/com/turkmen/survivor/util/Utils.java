package com.turkmen.survivor.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;
import java.util.Random;


/**
 * <h1> The Util class for reading game properties from @worldofsurvivers.properties and for generating random numbers for entity unique ids.</h1>
 *
 *
 * @author  Turkmen
 * @version 1.0
 * @since   2019-01-14
 *
 *
 */
public final class Utils {

    private Utils() {
        throw new UnsupportedOperationException();
    }

    public static Optional<String> getPropertyValue(String value) {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = Utils.class.getResourceAsStream("/worldofsurvivers.properties");
            prop.load(input);
            return Optional.ofNullable(prop.getProperty(value));

        } catch (IOException ex) {
            ex.printStackTrace();
            return Optional.empty();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static int generateRandomInt() {
        Random random = new Random();
        return random.nextInt(Integer.valueOf(getPropertyValue("world.id.range.max").get()).intValue());
    }


}
