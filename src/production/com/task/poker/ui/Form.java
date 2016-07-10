package com.task.poker.ui;

import com.task.poker.evaluator.EvaluationResult;
import com.task.poker.util.Constants;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Created by user on 7/6/2016.
 */
public class Form {

    private static final JTextField card1 = new JTextField(4);
    private static final JTextField card2 = new JTextField(4);
    private static final JTextField card3 = new JTextField(4);
    private static final JTextField card4 = new JTextField(4);
    private static final JTextField card5 = new JTextField(4);
    private static final JTextField card6 = new JTextField(4);
    private static final JTextField card7 = new JTextField(4);
    private static final JTextField card8 = new JTextField(4);
    private static final JTextField card9 = new JTextField(4);
    private static final JTextField card10 = new JTextField(4);
    private static final JLabel jlabel = new JLabel();
    private static final JLabel jlabel1 = new JLabel();
    private static final JLabel jlabel2 = new JLabel();
    private static final JLabel jlabel3 = new JLabel();
    private static final JLabel jlabel4 = new JLabel();
    private static final JLabel jlabel5 = new JLabel();
    private static final JLabel jlabel6 = new JLabel();
    private static final Font font = new Font("Courier", Font.BOLD, 12);
    private static final JCheckBox deck1 = new JCheckBox("Deck 1");
    private static final JCheckBox deck2 = new JCheckBox("Deck 2");
    private static final Border lowerEtched = BorderFactory.createBevelBorder(BevelBorder.LOWERED);
    private static final JPanel resultPanel = new JPanel();
    private static boolean isdeck1Selected = true;
    private static boolean isdeck2Selected = false;

    public static void addComponentsToPane(Container pane) {

        pane.setLayout(new GridBagLayout());
        makeDistributePanel(pane);
        makeHand1Panel(pane);
        makeHand2Panel(pane);
        makeEvaluatePanel(pane);
        makeResultPanel(pane);
    }

    private static void makeDistributePanel(Container pane) {
        GridBagConstraints gBC = new GridBagConstraints();
        gBC.insets = new Insets(5, 15, 0, 15);
        JPanel distributePanel = new JPanel();

        TitledBorder title = BorderFactory.createTitledBorder(lowerEtched, "DISTRIBUTE CARDS", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION, font);
        distributePanel.setBorder(title);
        gBC.gridx = 0;
        gBC.gridy = 0;
        gBC.weightx = 1;
        gBC.gridwidth = 2;
        gBC.fill = GridBagConstraints.BOTH;

        distributePanel.setLayout(new GridBagLayout());

        deck1.setSelected(true);
        deck1.addActionListener(e -> checkBox1Clicked());
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(5, 0, 5, 20);
        gc.gridx = 0;
        gc.gridy = 0;
        distributePanel.add(deck1, gc);

        deck2.addActionListener(e -> checkBox2Clicked());
        gc = new GridBagConstraints();
        gc.insets = new Insets(5, 0, 5, 20);
        gc.gridx = 1;
        gc.gridy = 0;
        distributePanel.add(deck2, gc);

        JButton distribute = new JButton("Distribute / Redistribute");
        distribute.setFont(font);
        distribute.addActionListener(e -> distributeCards());
        distribute.setPreferredSize(new Dimension(200, 35));

        gc = new GridBagConstraints();
        gc.insets = new Insets(5, 0, 5, 0);
        gc.gridx = 4;
        gc.gridy = 0;
        distributePanel.add(distribute, gc);

        pane.add(distributePanel, gBC);
    }

    public static void checkBox1Clicked() {
        isdeck1Selected = deck1.isSelected();
    }

    public static void checkBox2Clicked() {
        isdeck2Selected = deck2.isSelected();
    }

    private static boolean validate() {
        if (card1.getText().equals("") || card2.getText().equals("") || card3.getText().equals("") || card4.getText().equals("") || card5.getText().equals("")
                || card6.getText().equals("") || card7.getText().equals("") || card8.getText().equals("") || card9.getText().equals("") || card10.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter all card details.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public static void evaluateResult() {
        if (!validate())
            return;
        jlabel.setText("");
        jlabel1.setText("");
        jlabel2.setText("");
        jlabel3.setText("");
        jlabel4.setText("");
        jlabel5.setText("");
        jlabel6.setText("");
        Facade facade = new Facade();
        facade.evaluateResult();
    }

    public static void distributeCards() {
        Facade facade = new Facade();

        String hand[] = facade.getHandsWithOneDeck();
        if (isdeck1Selected && isdeck2Selected)
            hand = facade.getHandsWithMultipleDecks();

        card1.setText(hand[0]);
        card2.setText(hand[1]);
        card3.setText(hand[2]);
        card4.setText(hand[3]);
        card5.setText(hand[4]);

        card6.setText(hand[5]);
        card7.setText(hand[6]);
        card8.setText(hand[7]);
        card9.setText(hand[8]);
        card10.setText(hand[9]);
    }

    private static void makeHand1Panel(Container pane) {

        JPanel hand1Panel = new JPanel();
        TitledBorder title = BorderFactory.createTitledBorder(lowerEtched, "HAND 1", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION, font);
        hand1Panel.setBorder(title);
        GridBagConstraints gBC = new GridBagConstraints();
        gBC.insets = new Insets(15, 15, 15, 15);
        gBC.gridx = 0;
        gBC.gridy = 1;
        gBC.weightx = 1;
        gBC.fill = GridBagConstraints.BOTH;

        hand1Panel.setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(5, 0, 8, 15);
        gc.gridx = 0;
        gc.gridy = 1;
        card1.setFont(font);
        card1.setHorizontalAlignment(JTextField.CENTER);
        hand1Panel.add(card1, gc);

        gc = new GridBagConstraints();
        gc.insets = new Insets(5, 15, 8, 15);
        gc.gridx = 1;
        gc.gridy = 1;
        card2.setFont(font);
        card2.setHorizontalAlignment(JTextField.CENTER);
        hand1Panel.add(card2, gc);

        gc = new GridBagConstraints();
        gc.insets = new Insets(5, 15, 8, 15);
        gc.gridx = 2;
        gc.gridy = 1;
        card3.setFont(font);
        card3.setHorizontalAlignment(JTextField.CENTER);
        hand1Panel.add(card3, gc);

        gc = new GridBagConstraints();
        gc.insets = new Insets(5, 15, 8, 15);
        gc.gridx = 3;
        gc.gridy = 1;
        card4.setFont(font);
        card4.setHorizontalAlignment(JTextField.CENTER);
        hand1Panel.add(card4, gc);

        gc = new GridBagConstraints();
        gc.insets = new Insets(5, 15, 8, 15);
        gc.gridx = 4;
        gc.gridy = 1;
        card5.setFont(font);
        card5.setHorizontalAlignment(JTextField.CENTER);
        hand1Panel.add(card5, gc);

        pane.add(hand1Panel, gBC);
    }

    private static void makeHand2Panel(Container pane) {

        GridBagConstraints gBC = new GridBagConstraints();
        gBC.insets = new Insets(15, 15, 15, 15);
        JPanel hand2Panel = new JPanel();
        TitledBorder title = BorderFactory.createTitledBorder(lowerEtched, "HAND 2", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION, font);
        hand2Panel.setBorder(title);
        gBC.gridx = 1;
        gBC.gridy = 1;
        gBC.weightx = 1;
        gBC.fill = GridBagConstraints.BOTH;

        hand2Panel.setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(5, 0, 8, 15);
        gc.gridx = 0;
        gc.gridy = 1;
        card6.setFont(font);
        card6.setHorizontalAlignment(JTextField.CENTER);
        hand2Panel.add(card6, gc);

        gc = new GridBagConstraints();
        gc.insets = new Insets(5, 15, 8, 15);
        gc.gridx = 1;
        gc.gridy = 1;
        card7.setFont(font);
        card7.setHorizontalAlignment(JTextField.CENTER);
        hand2Panel.add(card7, gc);

        gc = new GridBagConstraints();
        gc.insets = new Insets(5, 15, 8, 15);
        gc.gridx = 2;
        gc.gridy = 1;
        card8.setFont(font);
        card8.setHorizontalAlignment(JTextField.CENTER);
        hand2Panel.add(card8, gc);

        gc = new GridBagConstraints();
        gc.insets = new Insets(5, 15, 8, 15);
        gc.gridx = 3;
        gc.gridy = 1;
        card9.setFont(font);
        card9.setHorizontalAlignment(JTextField.CENTER);
        hand2Panel.add(card9, gc);

        gc = new GridBagConstraints();
        gc.insets = new Insets(5, 15, 8, 15);
        gc.gridx = 4;
        gc.gridy = 1;
        card10.setFont(font);
        card10.setHorizontalAlignment(JTextField.CENTER);
        hand2Panel.add(card10, gc);

        pane.add(hand2Panel, gBC);
    }

    private static void makeEvaluatePanel(Container pane) {
        GridBagConstraints gBC = new GridBagConstraints();
        gBC.insets = new Insets(0, 15, 0, 15);
        JPanel evaluatePanel = new JPanel();
        gBC.gridx = 0;
        gBC.gridy = 3;
        gBC.weightx = 1;
        gBC.weighty = 0.1;
        gBC.gridwidth = 2;
        gBC.fill = GridBagConstraints.BOTH;

        JButton evaluate = new JButton("Evaluate Result");
        evaluate.setFont(font);
        evaluate.addActionListener(e -> evaluateResult());
        evaluate.setPreferredSize(new Dimension(200, 50));
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(5, 0, 25, 0);
        gc.gridx = 3;
        gc.gridy = 0;
        evaluatePanel.add(evaluate, gc);

        pane.add(evaluatePanel, gBC);
    }

    private static void makeResultPanel(Container pane) {
        GridBagConstraints gBC = new GridBagConstraints();
        gBC.insets = new Insets(5, 15, 15, 15);

        TitledBorder title = BorderFactory.createTitledBorder(lowerEtched, "RESULT", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION, font);
        resultPanel.setBorder(title);

        gBC.gridx = 0;
        gBC.gridy = 4;
        gBC.weightx = 1;
        gBC.weighty = 1;
        gBC.gridwidth = 2;
        gBC.fill = GridBagConstraints.BOTH;

        resultPanel.setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(0, 15, 8, 15);
        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.BOTH;
        resultPanel.add(jlabel, gc);

        gc = new GridBagConstraints();
        gc.insets = new Insets(5, 15, 8, 15);
        gc.gridx = 0;
        gc.gridy = 1;
        gc.weightx = 1;
        gc.fill = GridBagConstraints.BOTH;
        resultPanel.add(jlabel1, gc);

        gc = new GridBagConstraints();
        gc.insets = new Insets(5, 15, 8, 15);
        gc.gridx = 1;
        gc.gridy = 0;
        gc.weightx = 1;
        gc.fill = GridBagConstraints.BOTH;
        resultPanel.add(jlabel2, gc);

        gc = new GridBagConstraints();
        gc.insets = new Insets(5, 15, 8, 15);
        gc.gridx = 1;
        gc.gridy = 1;
        gc.weightx = 1;
        gc.fill = GridBagConstraints.BOTH;
        resultPanel.add(jlabel3, gc);

        gc = new GridBagConstraints();
        gc.insets = new Insets(5, 15, 8, 15);
        gc.gridx = 2;
        gc.gridy = 0;
        gc.weightx = 1;
        gc.fill = GridBagConstraints.BOTH;
        resultPanel.add(jlabel4, gc);

        gc = new GridBagConstraints();
        gc.insets = new Insets(5, 15, 8, 15);
        gc.gridx = 2;
        gc.gridy = 1;
        gc.weightx = 1;
        gc.fill = GridBagConstraints.BOTH;
        resultPanel.add(jlabel5, gc);

        gc = new GridBagConstraints();
        gc.insets = new Insets(5, 15, 8, 15);
        gc.gridx = 3;
        gc.gridy = 0;
        gc.weightx = 1;
        gc.fill = GridBagConstraints.BOTH;
        resultPanel.add(jlabel6, gc);

        pane.add(resultPanel, gBC);
    }

    public void createAndShowGUI() throws Exception {

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        JFrame frame = new JFrame("Poker Hand Evaluator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        frame.setSize((int) (width / 1.5), (int) (height / 1.75));
        frame.setLocationRelativeTo(null);

        addComponentsToPane(frame.getContentPane());

        frame.setVisible(true);
    }

    public static String[] readHand1() {
        String input[] = new String[5];
        input[0] = card1.getText();
        input[1] = card2.getText();
        input[2] = card3.getText();
        input[3] = card4.getText();
        input[4] = card5.getText();
        return input;
    }

    public static String[] readHand2() {
        String input[] = new String[5];
        input[0] = card6.getText();
        input[1] = card7.getText();
        input[2] = card8.getText();
        input[3] = card9.getText();
        input[4] = card10.getText();
        return input;
    }

    public static void setResult(String hand, EvaluationResult winner) {
        jlabel.setFont(font);
        if (winner.isEqual()) {
            jlabel.setText("Both hands are identical.");
        } else {
            jlabel.setText("Winner Hand : " + hand);
            jlabel1.setText("Partial Order: " + Constants.PARTIAL_ORDER.values()[winner.getPartialOrder() - 1].toString());
            if (winner.getPrimary() != -1)
                jlabel2.setText("Primary Rank : " + winner.getPrimary() + " " + Constants.RANK.valueOf(winner.getPrimary()));
            if (winner.getSecondary() != -1)
                jlabel3.setText("Secondary Rank : " + winner.getSecondary() + " " + Constants.RANK.valueOf(winner.getSecondary()));
            if (winner.getTertiary() != -1)
                jlabel4.setText("Tertiary Rank : " + winner.getTertiary() + " " + Constants.RANK.valueOf(winner.getTertiary()));
            if (winner.getQuaternary() != -1)
                jlabel5.setText("Quaternary Rank : " + winner.getQuaternary() + " " + Constants.RANK.valueOf(winner.getQuaternary()));
            if (winner.getQuinary() != -1)
                jlabel6.setText("Quinary Rank : " + winner.getQuinary() + " " + Constants.RANK.valueOf(winner.getQuinary()));
        }
    }
}
