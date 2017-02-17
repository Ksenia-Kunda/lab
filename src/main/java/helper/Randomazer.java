package helper;

import java.util.Random;

/**
 * Created by Kseniya_Kunda on 2/17/2017.
 */
public class Randomazer {
    private static int randomNumber;

    public static int getRandomNumber() {
        Random random = new Random();
        randomNumber = random.nextInt(10000)+10000;
        return randomNumber;
    }
}
