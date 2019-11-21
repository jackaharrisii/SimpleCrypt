package ROT13;

import java.io.IOException;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13  {

    private int shift;


    ROT13(Character cs, Character cf) {
        shift = cf-cs;
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
            if      (c >= 'a' && c <= 'm') c += 13;
            else if (c >= 'A' && c <= 'M') c += 13;
            else if (c >= 'n' && c <= 'z') c -= 13;
            else if (c >= 'N' && c <= 'Z') c -= 13;
            encrypted.append(c);
        }
        return encrypted.toString();
    }

    public String decrypt(String text) {
        return crypt(text);
    }

    public static String rotate(String s, Character c) {
        int i;
        for (i = 0; i < s.length(); i++){
            if (s.charAt(i) == c) break;
        }
        return s.substring(i, s.length()) + s.substring(0, i);
    }

}
