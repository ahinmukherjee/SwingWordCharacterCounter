import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class NumberCountingUsingButtons {

    public static void main(String args[]) {

        SampleFrame sf = new SampleFrame();

        sf.setVisible(true);

        sf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class SampleFrame extends JFrame {

    public SampleFrame() {

        Toolkit kit = Toolkit.getDefaultToolkit();

        Dimension srcSize = kit.getScreenSize();

        int w = srcSize.width;

        int h = srcSize.height;

        setSize(420, 350);

        setLocation(w / 4, h / 5);

        setResizable(false);

        setTitle("Digit Counter");

        add(new FramePanel());
    }
}

class FramePanel extends JPanel implements ActionListener {

    JLabel title, counterLabel, valueLabel;

    JButton increase, decrease, reset, exit;

    int count = 0;

    FramePanel() {

        setLayout(null);

        setBackground(new Color(240, 248, 255));

        // ===== TITLE =====

        title = new JLabel("Interactive Counter System");

        title.setFont(new Font("Segoe UI", Font.BOLD, 24));

        title.setForeground(new Color(25, 25, 112));

        title.setBounds(50, 20, 320, 35);

        add(title);

        // ===== COUNTER TEXT =====

        counterLabel = new JLabel("Current Value");

        counterLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));

        counterLabel.setForeground(new Color(60, 60, 60));

        counterLabel.setBounds(135, 80, 150, 30);

        add(counterLabel);

        // ===== VALUE LABEL =====

        valueLabel = new JLabel(String.valueOf(count));

        valueLabel.setHorizontalAlignment(JLabel.CENTER);

        valueLabel.setFont(new Font("Arial", Font.BOLD, 40));

        valueLabel.setForeground(new Color(0, 102, 204));

        valueLabel.setOpaque(true);

        valueLabel.setBackground(Color.WHITE);

        valueLabel.setBorder(
                new LineBorder(
                        new Color(180, 180, 180), 2));

        valueLabel.setBounds(110, 120, 180, 70);

        add(valueLabel);

        // ===== INCREASE BUTTON =====

        increase = new JButton("Increase");

        increase.setFont(new Font("Segoe UI", Font.BOLD, 15));

        increase.setBackground(new Color(0, 153, 76));

        increase.setForeground(Color.WHITE);

        increase.setFocusPainted(false);

        increase.setBounds(40, 230, 120, 45);

        add(increase);

        // ===== DECREASE BUTTON =====

        decrease = new JButton("Decrease");

        decrease.setFont(new Font("Segoe UI", Font.BOLD, 15));

        decrease.setBackground(new Color(220, 53, 69));

        decrease.setForeground(Color.WHITE);

        decrease.setFocusPainted(false);

        decrease.setBounds(240, 230, 120, 45);

        add(decrease);

        // ===== RESET BUTTON =====

        reset = new JButton("Reset");

        reset.setFont(new Font("Segoe UI", Font.BOLD, 14));

        reset.setBackground(new Color(255, 193, 7));

        reset.setForeground(Color.BLACK);

        reset.setBounds(90, 285, 100, 35);

        add(reset);

        // ===== EXIT BUTTON =====

        exit = new JButton("Exit");

        exit.setFont(new Font("Segoe UI", Font.BOLD, 14));

        exit.setBackground(new Color(52, 58, 64));

        exit.setForeground(Color.WHITE);

        exit.setBounds(220, 285, 100, 35);

        add(exit);

        // ===== ACTIONS =====

        increase.addActionListener(this);

        decrease.addActionListener(this);

        reset.addActionListener(this);

        exit.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {

                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == increase) {

            count++;

            valueLabel.setText(String.valueOf(count));
        }

        if (ae.getSource() == decrease) {

            count--;

            valueLabel.setText(String.valueOf(count));
        }

        if (ae.getSource() == reset) {

            count = 0;

            valueLabel.setText(String.valueOf(count));
        }
    }
}


import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.util.Random;

public class GuessNumberWithHistory {

    public static void main(String args[]) {

        FrameTest ft = new FrameTest();

        ft.setVisible(true);

        ft.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class FrameTest extends JFrame {

    public FrameTest() {

        Toolkit kit = Toolkit.getDefaultToolkit();

        Dimension scrsize = kit.getScreenSize();

        int w = scrsize.width;

        int h = scrsize.height;

        setSize(560, 550);

        setLocation(w / 5, h / 8);

        setTitle("Advanced Guess Number Game");

        setResizable(false);

        add(new FramePanels());
    }
}

class FramePanels extends JPanel implements ActionListener {

    JLabel title, subtitle, label, result;

    JTextField numberField;

    JButton clickButton, restartButton, exitButton;

    JTextArea historyArea;

    JScrollPane scrollPane;

    int number;

    int attempts = 0;

    int maxAttempts = 5;

    FramePanels() {

        setLayout(null);

        setBackground(new Color(18, 18, 35));

        // ===== TITLE =====

        title = new JLabel("NUMBER GUESS SYSTEM");

        title.setFont(new Font("Segoe UI", Font.BOLD, 28));

        title.setForeground(new Color(0, 255, 255));

        title.setBounds(80, 20, 400, 40);

        add(title);

        // ===== SUBTITLE =====

        subtitle = new JLabel("Guess a number between 1 to 100");

        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 15));

        subtitle.setForeground(Color.WHITE);

        subtitle.setBounds(135, 60, 260, 25);

        add(subtitle);

        // ===== LABEL =====

        label = new JLabel("Enter Number");

        label.setFont(new Font("Segoe UI", Font.BOLD, 16));

        label.setForeground(Color.WHITE);

        label.setBounds(40, 115, 140, 30);

        add(label);

        // ===== TEXT FIELD =====

        numberField = new JTextField();

        numberField.setFont(new Font("Consolas", Font.BOLD, 18));

        numberField.setHorizontalAlignment(JTextField.CENTER);

        numberField.setBackground(new Color(40, 40, 60));

        numberField.setForeground(Color.CYAN);

        numberField.setCaretColor(Color.WHITE);

        numberField.setBorder(
                new LineBorder(Color.CYAN, 2));

        numberField.setBounds(190, 110, 180, 40);

        add(numberField);

        // ===== GUESS BUTTON =====

        clickButton = new JButton("GUESS");

        clickButton.setFont(
                new Font("Segoe UI", Font.BOLD, 15));

        clickButton.setBackground(
                new Color(0, 180, 120));

        clickButton.setForeground(Color.WHITE);

        clickButton.setFocusPainted(false);

        clickButton.setBorder(
                new LineBorder(Color.WHITE, 1));

        clickButton.setBounds(40, 180, 130, 50);

        add(clickButton);

        // ===== RESTART BUTTON =====

        restartButton = new JButton("RESTART");

        restartButton.setFont(
                new Font("Segoe UI", Font.BOLD, 15));

        restartButton.setBackground(
                new Color(255, 170, 0));

        restartButton.setForeground(Color.BLACK);

        restartButton.setFocusPainted(false);

        restartButton.setBounds(200, 180, 130, 50);

        add(restartButton);

        // ===== EXIT BUTTON =====

        exitButton = new JButton("EXIT");

        exitButton.setFont(
                new Font("Segoe UI", Font.BOLD, 15));

        exitButton.setBackground(
                new Color(220, 53, 69));

        exitButton.setForeground(Color.WHITE);

        exitButton.setFocusPainted(false);

        exitButton.setBounds(360, 180, 130, 50);

        add(exitButton);

        // ===== RESULT =====

        result = new JLabel("Game Started");

        result.setFont(
                new Font("Segoe UI", Font.BOLD, 18));

        result.setForeground(Color.YELLOW);

        result.setBounds(160, 250, 250, 30);

        add(result);

        // ===== HISTORY AREA =====

        historyArea = new JTextArea();

        historyArea.setEditable(false);

        historyArea.setFont(
                new Font("Consolas", Font.PLAIN, 15));

        historyArea.setBackground(
                new Color(25, 25, 45));

        historyArea.setForeground(
                new Color(0, 255, 140));

        historyArea.setCaretColor(Color.WHITE);

        historyArea.setBorder(
                new EmptyBorder(10, 10, 10, 10));

        scrollPane = new JScrollPane(historyArea);

        scrollPane.setBounds(40, 300, 450, 180);

        scrollPane.setBorder(
                new LineBorder(Color.CYAN, 2));

        add(scrollPane);

        // ===== EVENTS =====

        clickButton.addActionListener(this);

        restartButton.addActionListener(this);

        exitButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {

                System.exit(0);
            }
        });

        startGame();
    }

    public void startGame() {

        number = new Random().nextInt(100) + 1;

        attempts = 0;

        numberField.setText("");

        historyArea.setText(
                "========== NEW GAME ==========\n\n");

        historyArea.append(
                "Attempts Left: 5\n");

        result.setText("Guess The Number");

        numberField.setEnabled(true);

        clickButton.setEnabled(true);
    }

    public void checkGuess() {

        try {

            int guess =
                    Integer.parseInt(numberField.getText());

            attempts++;

            int left = maxAttempts - attempts;

            if (guess < number) {

                result.setText("Too Low!");

                historyArea.append(
                        "\nAttempts Left " + left +
                        " -> Too Low!" +
                        "\nEntered Number: " +
                        guess + "\n");
            }

            else if (guess > number) {

                result.setText("Too High!");

                historyArea.append(
                        "\nAttempts Left " + left +
                        " -> Too High!" +
                        "\nEntered Number: " +
                        guess + "\n");
            }

            else {

                result.setText("Correct Number!");

                historyArea.append(
                        "\nCorrect! Number Was: "
                        + guess + "\n");

                historyArea.append(
                        "\n====== YOU WIN ======\n");

                clickButton.setEnabled(false);

                numberField.setEnabled(false);

                return;
            }

            if (attempts >= maxAttempts) {

                historyArea.append(
                        "\n====== GAME OVER ======\n");

                historyArea.append(
                        "Correct Number Was: "
                        + number);

                result.setText("Game Over!");

                clickButton.setEnabled(false);

                numberField.setEnabled(false);
            }

            numberField.setText("");
        }

        catch (Exception ex) {

            result.setText("Invalid Number!");
        }
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == clickButton) {

            checkGuess();
        }

        if (ae.getSource() == restartButton) {

            startGame();
        }
    }
}


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class CountWordCharacterAndIncludingSpaces {

    public static void main(String args[]) {

        FrameTest ft = new FrameTest();

        ft.setVisible(true);

        ft.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class FrameTest extends JFrame {

    public FrameTest() {

        Toolkit kit = Toolkit.getDefaultToolkit();

        Dimension scrsize = kit.getScreenSize();

        int w = scrsize.width;

        int h = scrsize.height;

        setSize(750, 600);

        setLocation(w / 5, h / 8);

        setTitle("Advanced Text Analyzer");

        setResizable(false);

        add(new FramePanels());
    }
}

class FramePanels extends JPanel implements ActionListener {

    JLabel title, label1, label2, label3;

    JTextArea area;

    JScrollPane scrollPane;

    JButton n1, n2, n3, clear, exit;

    FramePanels() {

        setLayout(null);

        setBackground(new Color(20, 25, 45));

        // ===== TITLE =====

        title = new JLabel("TEXT ANALYZER SYSTEM");

        title.setFont(new Font("Segoe UI", Font.BOLD, 30));

        title.setForeground(new Color(0, 255, 200));

        title.setBounds(170, 20, 420, 40);

        add(title);

        // ===== RESULT LABELS =====

        label1 = new JLabel("Word Count Result");

        label2 = new JLabel("Character Count Result");

        label3 = new JLabel("Character With Spaces Result");

        Font resultFont =
                new Font("Segoe UI", Font.BOLD, 15);

        label1.setFont(resultFont);

        label2.setFont(resultFont);

        label3.setFont(resultFont);

        label1.setForeground(Color.WHITE);

        label2.setForeground(Color.WHITE);

        label3.setForeground(Color.WHITE);

        label1.setBounds(30, 80, 650, 25);

        label2.setBounds(30, 110, 650, 25);

        label3.setBounds(30, 140, 650, 25);

        add(label1);

        add(label2);

        add(label3);

        // ===== TEXT AREA =====

        area = new JTextArea();

        area.setFont(new Font("Consolas", Font.PLAIN, 18));

        area.setBackground(new Color(35, 40, 65));

        area.setForeground(Color.WHITE);

        area.setCaretColor(Color.CYAN);

        area.setLineWrap(true);

        area.setWrapStyleWord(true);

        area.setBorder(
                new EmptyBorder(15, 15, 15, 15));

        scrollPane = new JScrollPane(area);

        scrollPane.setBounds(30, 190, 670, 260);

        scrollPane.setBorder(
                new LineBorder(Color.CYAN, 2));

        add(scrollPane);

        // ===== WORD BUTTON =====

        n1 = new JButton("Word Count");

        n1.setFont(new Font("Segoe UI", Font.BOLD, 14));

        n1.setBackground(new Color(0, 153, 255));

        n1.setForeground(Color.WHITE);

        n1.setFocusPainted(false);

        n1.setBounds(20, 490, 130, 45);

        add(n1);

        // ===== CHARACTER BUTTON =====

        n2 = new JButton("Character Count");

        n2.setFont(new Font("Segoe UI", Font.BOLD, 14));

        n2.setBackground(new Color(40, 167, 69));

        n2.setForeground(Color.WHITE);

        n2.setFocusPainted(false);

        n2.setBounds(170, 490, 170, 45);

        add(n2);

        // ===== CHARACTER WITH SPACE BUTTON =====

        n3 = new JButton("Count With Spaces");

        n3.setFont(new Font("Segoe UI", Font.BOLD, 14));

        n3.setBackground(new Color(255, 140, 0));

        n3.setForeground(Color.WHITE);

        n3.setFocusPainted(false);

        n3.setBounds(360, 490, 190, 45);

        add(n3);

        // ===== CLEAR BUTTON =====

        clear = new JButton("Clear");

        clear.setFont(new Font("Segoe UI", Font.BOLD, 14));

        clear.setBackground(new Color(108, 117, 125));

        clear.setForeground(Color.WHITE);

        clear.setFocusPainted(false);

        clear.setBounds(570, 490, 80, 45);

        add(clear);

        // ===== EXIT BUTTON =====

        exit = new JButton("Exit");

        exit.setFont(new Font("Segoe UI", Font.BOLD, 14));

        exit.setBackground(new Color(220, 53, 69));

        exit.setForeground(Color.WHITE);

        exit.setFocusPainted(false);

        exit.setBounds(660, 490, 70, 45);

        add(exit);

        // ===== EVENTS =====

        n1.addActionListener(this);

        n2.addActionListener(this);

        n3.addActionListener(this);

        clear.addActionListener(this);

        exit.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent av) {

                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent av) {

        String s = area.getText().trim();

        if (s.isEmpty()) {

            label1.setText("Please Enter Text");

            label2.setText("Please Enter Text");

            label3.setText("Please Enter Text");

            return;
        }

        String words[] = s.split("\\s+");

        int letters = s.replace(" ", "").length();

        int spaces = s.length() - letters;

        if (av.getSource() == n1) {

            label1.setText(
                    "Total Words: " + words.length);
        }

        if (av.getSource() == n2) {

            label2.setText(
                    "Total Characters Without Spaces: "
                    + letters);
        }

        if (av.getSource() == n3) {

            label3.setText(
                    "Characters With Spaces: "
                    + letters +
                    " Letters + "
                    + spaces +
                    " Spaces = "
                    + s.length());
        }

        if (av.getSource() == clear) {

            area.setText("");

            label1.setText("Word Count Result");

            label2.setText("Character Count Result");

            label3.setText("Character With Spaces Result");
        }
    }
}
