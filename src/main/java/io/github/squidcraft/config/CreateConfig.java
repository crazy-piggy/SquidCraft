package io.github.squidcraft.config;

import java.io.*;
import java.util.Properties;

public class CreateConfig {
    // TODO WIP update to 2020/4/26
    public static final Properties properties = new Properties();
    /**
     *@author baka4n
     */
    public CreateConfig() {
        try {
            properties.load(new BufferedInputStream(new FileInputStream("config.sc")));
        } catch (FileNotFoundException e) {
            properties.put("test", "test1");

            try {
                properties.store(new BufferedOutputStream(new FileOutputStream("config.sc")), "save Config File.");
            } catch (IOException f) {
                f.printStackTrace();
            }
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

}
