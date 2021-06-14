/**
 * ILman Nawali 1972003
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ConverterCalculator {
    private static String regex = "\\A[01]+\\Z";


    public static String convertToBinary(int numberstring) {
        return coreConverterFromDecimal(numberstring, 2);
    }

    public static String convertToHexa(int numberstring) {
        return coreConverterFromDecimal(numberstring, 16);
    }

    public static String convertToOctal(int numberstring) {
        return coreConverterFromDecimal(numberstring, 8);
    }

    public static int convertBinaryToDecimal(String numberstring) {
        return coreConverterToDecimal(numberstring, 2);
    }

    public static int convertHexaToDecimal(String numberstring) {
        return coreConverterToDecimal(numberstring, 16);
    }

    private static String coreConverterFromDecimal(int numberstring, int radix) {
        StringBuilder stringbuilder=new StringBuilder();
        int temp=0;
        if (radix==2){
            while (numberstring>0) {
                if (temp%5!=0){
                    stringbuilder.insert(temp,numberstring%2);
                    numberstring = numberstring / 2;
                    temp=temp+1;
                }
                else{
                    stringbuilder.insert(temp, " ");
                    temp=temp+1;
                }
            }
            stringbuilder.reverse();
            return String.valueOf(stringbuilder.toString());
        }
        else if (radix==16){
            char hexadec[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
            while (numberstring>0) {
                if (temp%5!=0){
                    stringbuilder.insert(temp, hexadec[numberstring%16]);
                    numberstring = numberstring / 16;
                    temp = temp+1;
                }
                else{
                    stringbuilder.insert(temp, " ");
                    temp = temp+1;
                }
            }
            stringbuilder.reverse();
            return String.valueOf(stringbuilder.toString());
        }

        else {
            while (numberstring>0) {
                if (temp%4!=0) {
                    stringbuilder.insert(temp, numberstring % 8);
                    numberstring = numberstring / 8;
                    temp = temp+ 1;
                } else {
                    stringbuilder.insert(temp, " ");
                    temp = temp+1;
                }
            }
            stringbuilder.reverse();
        }
        return String.valueOf(stringbuilder.toString());
    }

    private static int coreConverterToDecimal(String numberstring, int radix) {
        numberstring = numberstring.toUpperCase();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcherr = pattern.matcher(numberstring);
        int temp=0;
        if (matcherr.matches() == true) {
            if (radix == 2) {
                double hasil = 0;
                for (int i = 0; i < numberstring.length(); i++) {
                    if (numberstring.charAt(i) == '1') {
                        hasil = (int) (hasil + 1 * Math.pow(2,numberstring.length() - 1 - i));
                    }
                }
                temp = (int) hasil;
            }
        }
        else if (matcherr.matches()==false) {
            if (radix == 16) {
                char hexadec[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
                for (int i = 0; i < numberstring.length(); i++) {
                    for (int j = 0; j < hexadec.length; j++) {
                        if (numberstring.toUpperCase().charAt(i) == hexadec[j]) {
                            temp = (int) (temp + j * Math.pow(16, numberstring.length() - 1 - i));
                        }
                    }
                }
            }
        }
        return temp;
    }
}

