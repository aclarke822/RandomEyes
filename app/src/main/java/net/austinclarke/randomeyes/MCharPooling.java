package net.austinclarke.randomeyes;

import java.util.ArrayList;

/**
 * Created by Austin on 11/4/2015.
 */
public class MCharPooling {

    private static final String CHARSET_az = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHARSET_AZ = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String CHARSET_09 = "0123456789";
    private static final String CHARSET_HEX = "0123456789ABCDEF";
    //private static final String CHARSET_SPECIAL = "`~!@#$%^&*()_+-=[]\\;',./{}|:<>?";
    private static final String CHARSET_SPECIAL = "!@#$%&?";
    private static final String CHARSET_BINARY = "01";
    private static final String CHARSET_OTHER = "Second most paid, second most laid";


    public static String getPoolChars(ArrayList<Integer> charSetOption) {
        String charPool = "";

        for (int i = 0; i < charSetOption.size(); i++) {
            switch (charSetOption.get(i)) {
                case 1:
                    charPool += CHARSET_az;
                    break;
                case 2:
                    charPool += CHARSET_AZ;
                    break;
                case 3:
                    charPool += CHARSET_09;
                    break;
                case 4:
                    charPool += CHARSET_HEX;
                    break;
                case 5:
                    charPool += CHARSET_SPECIAL;
                    break;
                case 6:
                    charPool += CHARSET_BINARY;
                    break;
                case 7:
                    charPool += CHARSET_OTHER;
                    break;
                default:
                    charPool += "0";
                    break;
            }
        }
        return charPool;
    }
}
