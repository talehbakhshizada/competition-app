/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import beans.User;
import utill.FileUtill;

/**
 *
 * @author 99451
 */
public class Initialization {

    public static Config config = null;

    public static void initializeConfig(User user) {
        config = new Config(user);
        try {
            Object configObj = FileUtill.readObjectFromFile("config.ser");
            if (configObj == null) {
                config.setUser(user);
            } else {
                config = (Config) configObj;
            }
        } catch (Exception ex) {
            //ignore
            ex.printStackTrace();
        }
    }

    public static void refreshConfig() {
        FileUtill.writeObjectToFile(config, "config.ser");
    }
}
