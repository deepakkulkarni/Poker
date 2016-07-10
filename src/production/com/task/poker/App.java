package com.task.poker;

import com.task.poker.ui.Facade;

/**
 * Created by user on 7/3/2016.
 */
public class App {

    public static void main(String... args) throws Exception{
        Facade facade = new Facade();
        facade.launchGUI();
    }
}
