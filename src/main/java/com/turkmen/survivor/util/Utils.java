package com.turkmen.survivor.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;
import java.util.Random;

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
