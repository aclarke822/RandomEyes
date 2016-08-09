package net.austinclarke.randomeyes;

/**
 * Created by Austin on 11/3/2015.
 */
public class MCharArraytoStringArray {
    public static String[] getStrArrfromCharArr(char[][] charArr) {
        int charArrLength1 = charArr.length;
        String[] strArr = new String[charArrLength1];
        for (int i = 0; i < charArrLength1; i++) {
            strArr[i] = "";
            int charArrLength2 = charArr[i].length;
            for (int j = 0; j < charArrLength2; j++) {
                strArr[i] = strArr[i] + charArr[i][j];
            }
        }
        return strArr;
    }
}
