package com.task.poker;

import org.apache.log4j.Logger;

/**
 * Created by user on 7/3/2016.
 */
public class App {

    private static final Logger logger = Logger.getLogger(App.class);

    public static void main(String... args) {
        logger.info("Application started");
        Facade facade = new Facade();
        facade.launchGUI();
    }
}
