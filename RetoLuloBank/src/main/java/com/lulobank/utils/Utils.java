package com.lulobank.utils;

public class Utils {

    public static boolean containsOnlyLetter(String text) {
        for (int x = 0; x < text.length(); x++) {
            char c = text.charAt(x);
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')) {
                return false;
            }
        }
        return true;
    }

}
