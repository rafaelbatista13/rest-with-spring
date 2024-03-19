package br.com.estudo.util;

public class FormatHelper {

    public static Double covertToDouble(String strNumber) {
        if (strNumber == null)
            throw new NullPointerException();
        String number = strNumber.replace(",", ".");
        if (isNumeric(number))
            return Double.parseDouble(number);
        return 0d;
    }

    public static boolean isNumeric(String strNumber) {
        if (strNumber == null)
            throw new NullPointerException();
        String number = strNumber.replace(",", ".");
        return number.matches("[-+]?\\d*\\.?\\d+");
    }
}
