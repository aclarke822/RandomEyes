package net.austinclarke.randomeyes;

/*
 * @author Austin Clarke
 */

import java.security.SecureRandom;


public class RandomFactory {

    //String input and randomize
    public static char[][] getRString(String customString, int numberofstrings, int length) {
        String stringSet = customString;

        try {
            //String set converted to character set
            char[] characterSet = stringSet.toCharArray();
            //Array of characters [string number][random character]
            char[][] result = new char[numberofstrings][length];

            for (int i = 0; i < numberofstrings; i++) {
                for (int j = 0; j < length; j++) {
                    // picks a random index out of character set > random character
                    int randomCharIndex = new SecureRandom().nextInt(characterSet.length);
                    result[i][j] = characterSet[randomCharIndex];
                }
            }
            return result;

        } catch (IllegalArgumentException err) {
            char[][] catchError = new char[1][4];
            catchError[0][0] = 'W';
            catchError[0][1] = 'T';
            catchError[0][2] = 'F';
            catchError[0][3] = '?';
            return catchError;
        }
    }
    //Random card from a deck of cards
    public static String[] getRCard() {
        GDeck Deck1 = new GDeck();
        GCard Card1 = Deck1.getCard(getRInteger(1, 13), getRInteger(1, 4));
        return Card1.getCard();
    }
    //Random integer from a minimum and maximum integer
    public static int getRInteger(int min, int max) {
        SecureRandom rand = new SecureRandom();
        // nextInt excludes the top value so we have to add 1 to include the top value
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
    //Random float from a minimum and maximum float
    public static double getRFloat(double min, double max) {
        SecureRandom rand = new SecureRandom();
        double randomNum = rand.nextFloat()*(max - min) + min;
        return randomNum;
    }
}
