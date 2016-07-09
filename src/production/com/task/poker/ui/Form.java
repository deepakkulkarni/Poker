package com.task.poker.ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by user on 7/6/2016.
 */
public class Form {

    private final JTextField card1 = new JTextField(3);
    private final JTextField card2 = new JTextField(3);
    private final JTextField card3 = new JTextField(3);
    private final JTextField card4 = new JTextField(3);
    private final JTextField card5 = new JTextField(3);
    private final JTextField card6 = new JTextField(3);
    private final JTextField card7 = new JTextField(3);
    private final JTextField card8 = new JTextField(3);
    private final JTextField card9 = new JTextField(3);
    private final JTextField card10 = new JTextField(3);
    private final JCheckBox deck1 = new JCheckBox("Deck 1");
    private final JCheckBox deck2 = new JCheckBox("Deck 2");
    private boolean isdeck1Selected = true;
    private boolean isdeck2Selected = false;

    public void addComponentsToPane(Container pane) {

        pane.setLayout(new GridBagLayout());
        Border lineBorder = BorderFactory.createLineBorder(Color.black);


        makeDistributePanel(pane, lineBorder);
        makeHand1Panel(pane, lineBorder);
        makeHand2Panel(pane, lineBorder);
        makeEvaluatePanel(pane, lineBorder);
        makeResultPanel(pane, lineBorder);
    }

    private void makeDistributePanel(Container pane, Border blackline) {
        GridBagConstraints gBC = new GridBagConstraints();
        gBC.insets = new Insets(0, 15, 0, 15);
        JPanel distributePanel = new JPanel();
        distributePanel.setBorder(BorderFactory.createTitledBorder(blackline, "Distribute Cards"));
        gBC.gridx = 0;
        gBC.gridy = 0;
        gBC.weightx = 1;
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

        JButton distribute = new JButton("Distribute/Redistribute");
        distribute.addActionListener(e -> distributeCards());

        distribute.setPreferredSize(new Dimension(150, 35));
        gc = new GridBagConstraints();
        gc.insets = new Insets(5, 0, 5, 0);
        gc.gridx = 4;
        gc.gridy = 0;
        distributePanel.add(distribute, gc);

        pane.add(distributePanel, gBC);
    }

    public void checkBox1Clicked() {
        isdeck1Selected = deck1.isSelected();
    }

    public void checkBox2Clicked() {
        isdeck2Selected = deck2.isSelected();
    }

    public void evaluateResult() {
        JOptionPane.showMessageDialog(null, "Hello Evaluate Result");
    }

    public void distributeCards() {
        Facade facade = new Facade();
        String hand[] = facade.getHandsWithOneDeck();
        if(isdeck1Selected && isdeck2Selected)
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

    private void makeHand1Panel(Container pane, Border blackline) {

        JPanel hand1Panel = new JPanel();
        hand1Panel.setBorder(BorderFactory.createTitledBorder(blackline, "Hand 1"));
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
        hand1Panel.add(card1, gc);

        gc = new GridBagConstraints();
        gc.insets = new Insets(5, 15, 8, 15);
        gc.gridx = 1;
        gc.gridy = 1;
        hand1Panel.add(card2, gc);

        gc = new GridBagConstraints();
        gc.insets = new Insets(5, 15, 8, 15);
        gc.gridx = 2;
        gc.gridy = 1;
        hand1Panel.add(card3, gc);

        gc = new GridBagConstraints();
        gc.insets = new Insets(5, 15, 8, 15);
        gc.gridx = 3;
        gc.gridy = 1;
        hand1Panel.add(card4, gc);

        gc = new GridBagConstraints();
        gc.insets = new Insets(5, 15, 8, 15);
        gc.gridx = 4;
        gc.gridy = 1;
        hand1Panel.add(card5, gc);

        pane.add(hand1Panel, gBC);
    }

    private void makeHand2Panel(Container pane, Border blackline) {

        GridBagConstraints gBC = new GridBagConstraints();
        gBC.insets = new Insets(15, 15, 15, 15);
        JPanel hand2Panel = new JPanel();
        hand2Panel.setBorder(BorderFactory.createTitledBorder(blackline, "Hand 2"));
        gBC.gridx = 1;
        gBC.gridy = 1;
        gBC.weightx = 1;
        gBC.fill = GridBagConstraints.BOTH;

        hand2Panel.setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(5, 0, 8, 15);
        gc.gridx = 0;
        gc.gridy = 1;
        hand2Panel.add(card6, gc);

        gc = new GridBagConstraints();
        gc.insets = new Insets(5, 15, 8, 15);
        gc.gridx = 1;
        gc.gridy = 1;
        hand2Panel.add(card7, gc);

        gc = new GridBagConstraints();
        gc.insets = new Insets(5, 15, 8, 15);
        gc.gridx = 2;
        gc.gridy = 1;
        hand2Panel.add(card8, gc);

        gc = new GridBagConstraints();
        gc.insets = new Insets(5, 15, 8, 15);
        gc.gridx = 3;
        gc.gridy = 1;
        hand2Panel.add(card9, gc);

        gc = new GridBagConstraints();
        gc.insets = new Insets(5, 15, 8, 15);
        gc.gridx = 4;
        gc.gridy = 1;
        hand2Panel.add(card10, gc);

        pane.add(hand2Panel, gBC);
    }

    private void makeEvaluatePanel(Container pane, Border blackline) {
        GridBagConstraints gBC = new GridBagConstraints();
        gBC.insets = new Insets(0, 15, 0, 15);
        JPanel evaluatePanel = new JPanel();
        evaluatePanel.setBorder(BorderFactory.createTitledBorder(blackline, "Panel 3"));
        gBC.gridx = 0;
        gBC.gridy = 3;
        gBC.weightx = 1;
        gBC.weighty = 0.1;
        gBC.gridwidth = 2;
        gBC.fill = GridBagConstraints.BOTH;

        JButton evaluate = new JButton("Evaluate Result");
        evaluate.addActionListener(e -> evaluateResult());
        evaluate.setPreferredSize(new Dimension(200, 50));
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(5, 0, 25, 0);
        gc.gridx = 3;
        gc.gridy = 0;
        evaluatePanel.add(evaluate, gc);

        pane.add(evaluatePanel, gBC);
    }

    private static void makeResultPanel(Container pane, Border blackline) {
        GridBagConstraints gBC = new GridBagConstraints();
        gBC.insets = new Insets(15, 15, 15, 15);
        JPanel resultPanel = new JPanel();
        resultPanel.setBorder(BorderFactory.createTitledBorder(blackline, "Result"));
        gBC.gridx = 0;
        gBC.gridy = 4;
        gBC.weightx = 1;
        gBC.weighty = 1;
        gBC.gridwidth = 2;
        gBC.fill = GridBagConstraints.BOTH;
        pane.add(resultPanel, gBC);
    }

    private void createAndShowGUI() throws Exception {

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        JFrame frame = new JFrame("Poker Hand Evaluator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        frame.setSize((int) (width / 1.75), (int) (height / 1.75));

        frame.setLocationRelativeTo(null);

        addComponentsToPane(frame.getContentPane());

        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        Form form = new Form();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    form.createAndShowGUI();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
