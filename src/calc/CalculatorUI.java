package calc;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import calc.MathCalc;
import calc.MathCalc.OPERATOR;

public class CalculatorUI extends JFrame {
    private final JLabel calcArea = new JLabel("");

    private boolean initialCalcAreaInputState;
    private enum STATE { INITIAL, SAVE1, SAVE2, CALC }

    private STATE mathState;

    // calculator values
    private OPERATOR mathOp;
    private double arg1;
    private double arg2;
    private double calcAnswer;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                CalculatorUI frame = new CalculatorUI();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void calculateAnswer()  // method to perform calculation
    {
        calcAnswer = MathCalc.calculateIt(arg1, mathOp, arg2);
        calcArea.setText(String.valueOf(calcAnswer));
        arg1 = Double.parseDouble(calcArea.getText());
        mathState = STATE.CALC;
        initialCalcAreaInputState = true;
    }

    private void updateCalcArea(String string) {
        if (initialCalcAreaInputState) {  // sets text to string on initial key typed
            calcArea.setText(string);
            initialCalcAreaInputState = false;
        } else  {                         // concatenates string to end of text subsequent keys typed
            calcArea.setText(calcArea.getText() + string);
        }
    }

    /**
     * Save values for Calculator.
     */
    private void saveValueOfArg1() { // method to store 1st value in calculation (arg1)
        arg1 = Double.parseDouble((calcArea.getText()));
        mathState = STATE.SAVE1;
        initialCalcAreaInputState = true;
    }

    private void saveValueOfArg2() { // method to store 2nd value in calculation (arg2)
        if (mathState != STATE.CALC) {
            arg2 = Double.parseDouble((calcArea.getText()));
            mathState = STATE.SAVE2;
        }
    }

    private void saveValueOfMathOp(OPERATOR op) { // method to store operator
        mathOp = op;
    }

    private void clearCalculator() {  // helper method to clear and update calculator to default
        // calculator control
        String calcAreaDefault = "0.0";
        calcArea.setText(calcAreaDefault);
        mathState = STATE.INITIAL;
        initialCalcAreaInputState = true;
        arg1 = 0.0;
        arg2 = 0.0;
        calcAnswer = 0.0;
    }

    /**
     * Create the frame.
     */
    public CalculatorUI() {
        getContentPane().setBackground(new Color(175, 238, 238));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 418, 315);
        getContentPane().setLayout(null);
        calcArea.setForeground(Color.WHITE);
        calcArea.setFont(new Font("Lucida Grande", Font.PLAIN, 72));
        calcArea.setHorizontalAlignment(SwingConstants.RIGHT);
        calcArea.setBounds(18, 6, 377, 67);
        getContentPane().add(calcArea);

        JButton button_1 = new JButton("1");
        button_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_1.setBackground(Color.BLACK);
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                button_1.setBackground(Color.BLACK);
            }
        });
        button_1.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
        button_1.setOpaque(true);
        button_1.setForeground(Color.WHITE);
        button_1.setBackground(Color.BLACK);
        button_1.addActionListener(e -> updateCalcArea(button_1.getText()));
        button_1.setBounds(35, 86, 75, 40);
        getContentPane().add(button_1);

        JButton button_2 = new JButton("2");
        button_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_2.setBackground(Color.BLACK);
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                button_2.setBackground(Color.BLACK);
            }
        });
        button_2.addActionListener(e -> updateCalcArea(button_2.getText()));
        button_2.setOpaque(true);
        button_2.setForeground(Color.WHITE);
        button_2.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
        button_2.setBackground(Color.BLACK);
        button_2.setBounds(122, 86, 75, 40);
        getContentPane().add(button_2);

        JButton button_3 = new JButton("3");
        button_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_3.setBackground(Color.BLACK);
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                button_3.setBackground(Color.BLACK);
            }
        });
        button_3.addActionListener(e -> updateCalcArea(button_3.getText()));
        button_3.setOpaque(true);
        button_3.setForeground(Color.WHITE);
        button_3.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
        button_3.setBackground(Color.BLACK);
        button_3.setBounds(209, 86, 75, 40);
        getContentPane().add(button_3);

        JButton button_4 = new JButton("4");
        button_4.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_4.setBackground(Color.BLACK);
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                button_4.setBackground(Color.BLACK);
            }
        });
        button_4.addActionListener(e -> updateCalcArea(button_4.getText()));
        button_4.setOpaque(true);
        button_4.setForeground(Color.WHITE);
        button_4.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
        button_4.setBackground(Color.BLACK);
        button_4.setBounds(35, 138, 75, 40);
        getContentPane().add(button_4);

        JButton button_5 = new JButton("5");
        button_5.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_5.setBackground(Color.BLACK);
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                button_5.setBackground(Color.BLACK);
            }
        });
        button_5.addActionListener(e -> updateCalcArea(button_5.getText()));
        button_5.setOpaque(true);
        button_5.setForeground(Color.WHITE);
        button_5.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
        button_5.setBackground(Color.BLACK);
        button_5.setBounds(122, 138, 75, 40);
        getContentPane().add(button_5);

        JButton button_6 = new JButton("6");
        button_6.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_6.setBackground(Color.BLACK);
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                button_6.setBackground(Color.BLACK);
            }
        });
        button_6.addActionListener(e -> updateCalcArea(button_6.getText()));
        button_6.setOpaque(true);
        button_6.setForeground(Color.WHITE);
        button_6.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
        button_6.setBackground(Color.BLACK);
        button_6.setBounds(209, 138, 75, 40);
        getContentPane().add(button_6);

        JButton button_7 = new JButton("7");
        button_7.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_7.setBackground(Color.BLACK);
            }

            public void mouseReleased(MouseEvent e) {
                button_7.setBackground(Color.BLACK);
            }
        });
        button_7.addActionListener(e -> updateCalcArea(button_7.getText()));
        button_7.setOpaque(true);
        button_7.setForeground(Color.WHITE);
        button_7.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
        button_7.setBackground(Color.BLACK);
        button_7.setBounds(35, 190, 75, 40);
        getContentPane().add(button_7);

        JButton button_8 = new JButton("8");
        button_8.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_8.setBackground(Color.BLACK);
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                button_8.setBackground(Color.BLACK);
            }
        });
        button_8.addActionListener(e -> updateCalcArea(button_8.getText()));
        button_8.setOpaque(true);
        button_8.setForeground(Color.WHITE);
        button_8.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
        button_8.setBackground(Color.BLACK);
        button_8.setBounds(122, 190, 75, 40);
        getContentPane().add(button_8);

        JButton button_9 = new JButton("9");
        button_9.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_9.setBackground(Color.BLACK);
            }

            public void mouseReleased(MouseEvent e) {
                button_9.setBackground(Color.BLACK);
            }
        });
        button_9.addActionListener(e -> updateCalcArea(button_9.getText()));
        button_9.setOpaque(true);
        button_9.setForeground(Color.WHITE);
        button_9.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
        button_9.setBackground(Color.BLACK);
        button_9.setBounds(209, 190, 75, 40);
        getContentPane().add(button_9);

        JButton button_0 = new JButton("0");
        button_0.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_0.setBackground(Color.BLACK);
            }

            public void mouseReleased(MouseEvent e) {
                button_0.setBackground(Color.BLACK);
            }
        });
        button_0.addActionListener(e -> updateCalcArea(button_0.getText()));
        button_0.setOpaque(true);
        button_0.setForeground(Color.WHITE);
        button_0.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
        button_0.setBackground(Color.BLACK);
        button_0.setBounds(122, 242, 75, 40);
        getContentPane().add(button_0);

        JButton button_plus = new JButton("+");
        button_plus.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_plus.setBackground(Color.WHITE);
            }

            public void mouseReleased(MouseEvent e) {
                button_plus.setBackground(Color.BLACK);
            }
        });
        button_plus.addActionListener(e -> {
            saveValueOfArg1();
            saveValueOfMathOp(OPERATOR.PLUS);
        });
        button_plus.setOpaque(true);
        button_plus.setForeground(Color.WHITE);
        button_plus.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
        button_plus.setBackground(Color.BLACK);
        button_plus.setBounds(327, 138, 75, 40);
        getContentPane().add(button_plus);

        JButton button_minus = new JButton("-");
        button_minus.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_minus.setBackground(Color.WHITE);
            }

            public void mouseReleased(MouseEvent e) {
                button_minus.setBackground(Color.BLACK);
            }
        });
        button_minus.addActionListener(e -> {
            saveValueOfArg1();
            saveValueOfMathOp(OPERATOR.MINUS);
        });
        button_minus.setOpaque(true);
        button_minus.setForeground(Color.WHITE);
        button_minus.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
        button_minus.setBackground(Color.BLACK);
        button_minus.setBounds(327, 190, 75, 40);
        getContentPane().add(button_minus);

        JButton button_equals = new JButton("=");
        button_equals.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_equals.setBackground(Color.WHITE);
            }

            public void mouseReleased(MouseEvent e) {
                button_equals.setBackground(Color.BLACK);
            }
        });
        button_equals.addActionListener(e -> {
            saveValueOfArg2();
            calculateAnswer();
        });
        button_equals.setOpaque(true);
        button_equals.setForeground(Color.WHITE);
        button_equals.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
        button_equals.setBackground(Color.BLACK);
        button_equals.setBounds(209, 242, 75, 40);
        getContentPane().add(button_equals);

        JButton button_multiply = new JButton("*");
        button_multiply.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_multiply.setBackground(Color.WHITE);
            }

            public void mouseReleased(MouseEvent e) {
                button_multiply.setBackground(Color.BLACK);
            }
        });
        button_multiply.addActionListener(e -> {
            saveValueOfArg1();
            saveValueOfMathOp(OPERATOR.MULTIPLY);
        });
        button_multiply.setOpaque(true);
        button_multiply.setForeground(Color.WHITE);
        button_multiply.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
        button_multiply.setBackground(Color.BLACK);
        button_multiply.setBounds(327, 240, 75, 40);
        getContentPane().add(button_multiply);

        JButton button_divide = new JButton("/");
        button_multiply.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_divide.setBackground(Color.WHITE);
            }

            public void mouseReleased(MouseEvent e) {
                button_divide.setBackground(Color.BLACK);
            }
        });
        button_divide.addActionListener(e -> {
            saveValueOfArg1();
            saveValueOfMathOp(OPERATOR.DIVIDE);
        });
        button_divide.setOpaque(true);
        button_divide.setForeground(Color.WHITE);
        button_divide.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
        button_divide.setBackground(Color.BLACK);
        button_divide.setBounds(327, 290, 75, 40);
        getContentPane().add(button_divide);

        JButton button_square = new JButton("x²");
        button_square.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_square.setBackground(Color.WHITE);
            }

            public void mouseReleased(MouseEvent e) {
                button_square.setBackground(Color.BLACK);
            }
        });
        button_square.addActionListener(e -> {
            saveValueOfArg1();
            saveValueOfMathOp(OPERATOR.SQUARE);
            calculateAnswer();
        });
        button_square.setOpaque(true);
        button_square.setForeground(Color.WHITE);
        button_square.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
        button_square.setBackground(Color.BLACK);
        button_square.setBounds(415, 85, 75, 40);
        getContentPane().add(button_square);

        JButton button_cosine = new JButton("cos");
        button_cosine.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_cosine.setBackground(Color.WHITE);
            }

            public void mouseReleased(MouseEvent e) {
                button_cosine.setBackground(Color.BLACK);
            }
        });
        button_cosine.addActionListener(e -> {
            saveValueOfArg1();
            saveValueOfMathOp(OPERATOR.COSINE);
            calculateAnswer();
        });
        button_cosine.setOpaque(true);
        button_cosine.setForeground(Color.WHITE);
        button_cosine.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
        button_cosine.setBackground(Color.BLACK);
        button_cosine.setBounds(415, 138, 75, 40);
        getContentPane().add(button_cosine);

        JButton button_sine = new JButton("sin");
        button_sine.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_sine.setBackground(Color.WHITE);
            }

            public void mouseReleased(MouseEvent e) {
                button_sine.setBackground(Color.BLACK);
            }
        });
        button_sine.addActionListener(e -> {
            saveValueOfArg1();
            saveValueOfMathOp(OPERATOR.SINE);
            calculateAnswer();
        });
        button_sine.setOpaque(true);
        button_sine.setForeground(Color.WHITE);
        button_sine.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
        button_sine.setBackground(Color.BLACK);
        button_sine.setBounds(415, 190, 75, 40);
        getContentPane().add(button_sine);

        JButton button_tangent = new JButton("tan");
        button_tangent.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_tangent.setBackground(Color.WHITE);
            }

            public void mouseReleased(MouseEvent e) {
                button_tangent.setBackground(Color.BLACK);
            }
        });
        button_tangent.addActionListener(e -> {
            saveValueOfArg1();
            saveValueOfMathOp(OPERATOR.TANGENT);
            calculateAnswer();
        });
        button_tangent.setOpaque(true);
        button_tangent.setForeground(Color.WHITE);
        button_tangent.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
        button_tangent.setBackground(Color.BLACK);
        button_tangent.setBounds(415, 240, 75, 40);
        getContentPane().add(button_tangent);

        JButton button_log = new JButton("log");
        button_log.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_log.setBackground(Color.WHITE);
            }

            public void mouseReleased(MouseEvent e) {
                button_log.setBackground(Color.BLACK);
            }
        });
        button_log.addActionListener(e -> {
            saveValueOfArg1();
            saveValueOfMathOp(OPERATOR.LOG);
            calculateAnswer();
        });
        button_log.setOpaque(true);
        button_log.setForeground(Color.WHITE);
        button_log.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
        button_log.setBackground(Color.BLACK);
        button_log.setBounds(415, 290, 75, 40);
        getContentPane().add(button_log);

        JButton button_clear = new JButton("AC");
        button_clear.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button_clear.setBackground(Color.BLACK);
            }

            public void mouseReleased(MouseEvent e) {
                button_clear.setBackground(Color.PINK);
            }
        });
        button_clear.addActionListener(e -> clearCalculator());
        button_clear.setOpaque(true);
        button_clear.setForeground(Color.BLACK);
        button_clear.setBorder(new MatteBorder(4, 4, 4, 4, Color.WHITE));
        button_clear.setBackground(new Color(221, 160, 221));
        button_clear.setBounds(327, 85, 75, 40);
        getContentPane().add(button_clear);

        JLabel lblTriosCalculator = new JLabel("Trio Basic Calculator");
        lblTriosCalculator.setBounds(6, 6, 134, 16);
        getContentPane().add(lblTriosCalculator);

    }
}
