package ROT13;

import java.io.IOException;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13  {

    private int shift;


    ROT13(Character cs, Character cf) {
        shift = cf.compareTo(cs);
    }

    ROT13() {
        shift = 0;
    }

    public String crypt(String text) throws UnsupportedOperationException {
        shift = 13;
        return encrypt(text);
    }

    public String encrypt(String text) {
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < text.length(); i++){
            char c = text.charAt(i);
            if      (c >= 'a' && c <= 'z' - shift) c += shift;
            else if (c >= 'A' && c <= 'Z' - shift) c += shift;
            else if (c >= 'a' + shift && c <= 'z') c += shift - 26;
            else if (c >= 'A' + shift && c <= 'Z') c += shift - 26;
            encrypted.append(c);
        }
        return encrypted.toString();
    }

    public String decrypt(String text) {
        shift = 26-shift;
        return encrypt(text);
    }

    public static String rotate(String s, Character c) {
        int i;
        for (i = 0; i < s.length(); i++){
            if (s.charAt(i) == c) break;
        }
        return s.substring(i, s.length()) + s.substring(0, i);
    }



}
