package com.epam.automation.helper;

import java.util.Random;

/**
 * Created by Kseniya_Kunda on 2/17/2017.
 */
public class Randomizer {
    private static int randomNumber;

    public static int getNumber() {
        Random random = new Random();
        randomNumber = random.nextInt(100000)+100000;
        return randomNumber;
    }
}
