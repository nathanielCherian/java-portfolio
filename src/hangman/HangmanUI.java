package hangman;

import app.Game;
import calc.CalculatorUI;

import javax.swing.*;
import java.awt.*;

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

    private void getLetter() {
        String text = input.getText();
        char c;
        if (Character.isLetter(text.charAt(0)) && text.length() == 1) {
            c = Character.toUpperCase(text.toCharArray()[0]);
        } else {
            input.setText("Not a letter");
        }
    }

    JTextField input = new JTextField("Enter a letter");

    public HangmanUI() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        getContentPane().setLayout(null);

        input.setBounds(0, 410, 500, 50);
        getContentPane().add(input);

        JButton inputButton = new JButton("Check Letter!");
        inputButton.setBounds(150, 385, 200, 25);
        getContentPane().add(inputButton);
        inputButton.addActionListener(e -> getLetter());
    }


}
