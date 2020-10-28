package hangman;

import java.util.ArrayList;


public class hangmanControl {

    public static ArrayList<Integer> checkWord (String word, char letter) {

        ArrayList<Integer> indices = new ArrayList<Integer>();
        char[] letters = word.toCharArray();

        for (int i = 0;  i < letters.length; i++) {
            if (letters[i] == letter) {
                indices.add(i);
            }
        }

        return indices;
    }

}
