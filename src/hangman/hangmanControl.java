package hangman;

import java.util.ArrayList;


public class hangmanControl {

    //checks the given word for places where the letter is
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

    //checks if the letter is in the word
    public static boolean checkLetter (String word, char letter) {
        for (char c : word.toCharArray()) {
            if (letter == c) {
                return true;
            }
        }
        return false;
    }
}
