package hangman;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.util.ArrayList;

public class HangmanUI extends JFrame {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                HangmanUI frame = new HangmanUI();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    //starts game; sets lives to 6 and chooses a word
    private void startGame() {
        updateLives(6);
        selectWord();
    }

    //func name self-explanatory
    private void updateLives (int l) {
        lives = l;
        shownLives.setText("Lives: " + l);
    }

    //receives letter from text field and even gives an error message if its not a letter
    private boolean getLetter() {
        String text = input.getText();
        if (Character.isLetter(text.charAt(0)) && text.length() == 1) {
            c = Character.toUpperCase(text.toCharArray()[0]);
            return true;
        } else {
            input.setText("Not a letter");
            return false;
        }
    }

    //updates word after pressing "Check Letter!" button
    private void updateWord() {
        //check for if valid letter
        if (getLetter()) {
            //check for if the letter is in the word
            if (hangman.hangmanControl.checkLetter(word, c)) {

                //updates the hidden word to include the new characters
                ArrayList<Integer> letters = hangman.hangmanControl.checkWord(word, c);
                char[] letterArray = shownWord.getText().toCharArray();
                for (int i : letters) {
                    letterArray[i] = c;
                }
                shownWord.setText(new String(letterArray));

            } else {
                updateLives(lives - 1);
                wrongLetters.setText(wrongLetters.getText().concat(" " + c));
            }
        }

        //check for win
        if (shownWord.getText() == word) {
            shownWord.setText("YOU WIN!");
        }
    }

    //chooses a word and provides the user with a hidden version
    private void selectWord() {
        String[] words = {"INTELLIJ", "MORTENSEN", "DEL NORTE", "T'CHALLA", "WALRUS", "OPERATOR", "JAZZ", "COOL", "NATHANIEL", "ANTHONY", "JETT", "BENNY", "BRENDAN"};
        word = words[(int)( Math.random()* (words.length-1) )];
        String hidden = "";
        for (int i=0; i < word.length(); i++) {
            if (Character.isLetter(word.toCharArray()[i])) {
                hidden += "X";
            } else {
                hidden += word.toCharArray()[i];
            }
        }
        shownWord.setText(hidden);
    }

    //initializing variables that the code interacts with; Model
    char c;
    String word;
    int lives;
    JTextField input = new JTextField("Enter a letter");
    JLabel shownWord = new JLabel("Word", SwingConstants.CENTER);
    JLabel shownLives = new JLabel("Lives: ", SwingConstants.CENTER);
    JLabel wrongLetters = new JLabel("Letters Missed:", SwingConstants.CENTER);

    //creating UI; View
    public HangmanUI() {
        //setting standards for color and font
        Font f = new Font("Comic Sans MS", Font.PLAIN, 20);
        MatteBorder b = new MatteBorder(4, 4, 4, 4, Color.BLACK);
        Color c = new Color(0, 255, 85);

        //operations to set up the JFrame
        getContentPane().setBackground(new Color(3, 252, 198));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        getContentPane().setLayout(null);

        //init TextField
        input.setBounds(0, 410, 500, 50);
        getContentPane().add(input);

        //setting up buttons for UI
        JButton inputButton = new JButton("Check Letter!");
        inputButton.setBounds(150, 385, 200, 25);
        inputButton.setBorder(b);
        inputButton.setBackground(c);
        inputButton.setOpaque(true);
        getContentPane().add(inputButton);
        inputButton.addActionListener(e -> updateWord());

        JButton startButton = new JButton("Start a new game");
        startButton.setBounds(150, 0, 200, 25);
        startButton.setBorder(b);
        startButton.setBackground(c);
        startButton.setOpaque(true);
        getContentPane().add(startButton);
        startButton.addActionListener(e -> startGame());

        //setting up labels for UI
        shownWord.setBounds(50, 100, 400, 100);
        shownWord.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
        getContentPane().add(shownWord);

        shownLives.setBounds(150, 200, 200, 50);
        shownLives.setFont(f);
        getContentPane().add(shownLives);

        wrongLetters.setBounds(0, 250, 500, 50);
        wrongLetters.setFont(f);
        getContentPane().add(wrongLetters);
    }


}
