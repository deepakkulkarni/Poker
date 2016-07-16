package com.task.poker.ui;

import org.apache.log4j.Logger;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Created by user on 7/6/2016.
 */
public class View {

    private static final Logger logger = Logger.getLogger(View.class);

    public static final JTextField card1 = new JTextField(4);
    public static final JTextField card2 = new JTextField(4);
    public static final JTextField card3 = new JTextField(4);
    public static final JTextField card4 = new JTextField(4);
    public static final JTextField card5 = new JTextField(4);
    public static final JTextField card6 = new JTextField(4);
    public static final JTextField card7 = new JTextField(4);
    public static final JTextField card8 = new JTextField(4);
    public static final JTextField card9 = new JTextField(4);
    public static final JTextField card10 = new JTextField(4);
    public static final JLabel result = new JLabel();
    public static final JLabel partialOrder = new JLabel();
    public static final JLabel primary = new JLabel();
    public static final JLabel secondary = new JLabel();
    public static final JLabel tertiary = new JLabel();
    public static final JLabel quaternary = new JLabel();
    public static final JLabel quinary = new JLabel();
    public static final Font font = new Font("Courier", Font.BOLD, 12);
    public static final Font headerFont = new Font("Courier", Font.BOLD, 13);
    public static final JCheckBox deck1 = new JCheckBox("Deck 1");
    public static final JCheckBox deck2 = new JCheckBox("Deck 2");
    public static final Border lowerEtched = BorderFactory.createBevelBorder(BevelBorder.LOWERED);
    public static final Border upperEtched = BorderFactory.createBevelBorder(BevelBorder.RAISED);
    public static final JPanel resultPanel = new JPanel();
    public static boolean isDeck1Selected = true;
    public static boolean isDeck2Selected = false;

    private static final String FRAME_NAME = "Poker Hands Evaluator";
    private static final String DISTRIBUTE_PANEL_NAME = "Distribute Cards";
    private static final String RESULT_PANEL_NAME = "RESULT";
    private static final String HAND1_PANEL_NAME = "Hand 1";
    private static final String HAND2_PANEL_NAME = "Hand 2";
    private static final String EVALUATE_RESULT_BUTTON_NAME = "EVALUATE RESULT";
    private static final String DISTRIBUTE_BUTTON_NAME = "DISTRIBUTE / REDISTRIBUTE";

    public static void launchGUI() {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    createAndShowGUI();
                } catch (Exception e) {
                    logger.error("Error launching GUI", e);
                }
            }
        });
    }

    private static void createAndShowGUI() throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        configureAndDisplayMainFrame();
    }

    private static void configureAndDisplayMainFrame() {
        JFrame frame = new JFrame(FRAME_NAME);
        frame.setFont(font);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        frame.setSize((int) (width / 1.2), (int) (height / 1.6));
        frame.setLocationRelativeTo(null);
        addComponentsToPane(frame.getContentPane());
        frame.setVisible(true);
    }

    private static void addComponentsToPane(Container pane) {
        pane.setLayout(new GridBagLayout());
        makeDistributePanel(pane);
        makeHand1Panel(pane);
        makeHand2Panel(pane);
        makeInformationPanel(pane);
        makeEvaluatePanel(pane);
        makeResultPanel(pane);
    }

    private static void makeInformationPanel(Container pane) {

        GridBagConstraints gBC = new GridBagConstraints();
        gBC.insets = new Insets(5, 15, 15, 15);
        JPanel evaluatePanel = new JPanel();
        TitledBorder title = BorderFactory.createTitledBorder(upperEtched, "", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION, headerFont);
        evaluatePanel.setBorder(title);
        gBC.gridx = 0;
        gBC.gridy = 3;
        gBC.weightx = 1;
        gBC.gridwidth = 2;
        gBC.fill = GridBagConstraints.BOTH;

        Font font = new Font("Courier", Font.ITALIC, 11);
        JLabel information = new JLabel();
        information.setFont(font);
        information.setText("First character in card denotes suite (S,D,H,C) while the second character denotes rank (2,3,4,5,6,7,8,9,10,J,Q,K,A)");
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(5, 0, 25, 0);
        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.BOTH;
        evaluatePanel.add(information, gc);

        pane.add(evaluatePanel, gBC);
    }

    private static void makeDistributePanel(Container pane) {
        GridBagConstraints gBC = new GridBagConstraints();
        gBC.insets = new Insets(5, 15, 0, 15);
        JPanel distributePanel = new JPanel();

        TitledBorder title = BorderFactory.createTitledBorder(lowerEtched, DISTRIBUTE_PANEL_NAME, TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION, headerFont);
        distributePanel.setBorder(title);
        gBC.gridx = 0;
        gBC.gridy = 0;
        gBC.weightx = 1;
        gBC.gridwidth = 2;
        gBC.fill = GridBagConstraints.BOTH;

        distributePanel.setLayout(new GridBagLayout());

        deck1.setSelected(true);
        deck1.setEnabled(false);
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(5, 0, 5, 5);
        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.weightx = 0.0;
        distributePanel.add(deck1, gc);

        deck2.addActionListener(e -> Controller.checkBox2Clicked());
        gc = new GridBagConstraints();
        gc.insets = new Insets(5, 0, 5, 25);
        gc.gridx = 1;
        gc.gridy = 0;
        distributePanel.add(deck2, gc);

        JButton distribute = new JButton(DISTRIBUTE_BUTTON_NAME);
        distribute.setFont(font);
        distribute.addActionListener(e -> Controller.distributeCards());
        distribute.setPreferredSize(new Dimension(250, 40));

        gc = new GridBagConstraints();
        gc.insets = new Insets(5, 25, 5, 20);
        gc.gridx = 2;
        gc.gridy = 0;
        gc.weightx = 0.1;
        gc.anchor = GridBagConstraints.WEST;
        distributePanel.add(distribute, gc);

        pane.add(distributePanel, gBC);
    }

    private static void makeHand1Panel(Container pane) {

        JPanel hand1Panel = new JPanel();
        TitledBorder title = BorderFactory.createTitledBorder(lowerEtched, HAND1_PANEL_NAME, TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION, headerFont);
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
        TitledBorder title = BorderFactory.createTitledBorder(lowerEtched, HAND2_PANEL_NAME, TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION, headerFont);
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
        gBC.gridy = 4;
        gBC.weightx = 1;
        gBC.weighty = 0.1;
        gBC.gridwidth = 2;
        gBC.fill = GridBagConstraints.BOTH;

        JButton evaluate = new JButton(EVALUATE_RESULT_BUTTON_NAME);
        evaluate.setFont(headerFont);
        evaluate.addActionListener(e -> Controller.evaluateResult());
        evaluate.setPreferredSize(new Dimension(350, 50));
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(5, 0, 20, 0);
        gc.gridx = 3;
        gc.gridy = 0;
        evaluatePanel.add(evaluate, gc);

        pane.add(evaluatePanel, gBC);
    }

    private static void makeResultPanel(Container pane) {
        GridBagConstraints gBC = new GridBagConstraints();
        gBC.insets = new Insets(5, 15, 15, 15);

        TitledBorder title = BorderFactory.createTitledBorder(lowerEtched, RESULT_PANEL_NAME, TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION, headerFont);
        resultPanel.setBorder(title);

        gBC.gridx = 0;
        gBC.gridy = 5;
        gBC.weightx = 1;
        gBC.weighty = 1;
        gBC.gridwidth = 2;
        gBC.fill = GridBagConstraints.BOTH;

        resultPanel.setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(0, 15, 8, 15);
        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 0.5;
        gc.fill = GridBagConstraints.BOTH;
        resultPanel.add(result, gc);

        gc = new GridBagConstraints();
        gc.insets = new Insets(5, 15, 8, 15);
        gc.gridx = 0;
        gc.gridy = 1;
        gc.weightx = 0.5;
        gc.fill = GridBagConstraints.BOTH;
        resultPanel.add(partialOrder, gc);

        gc = new GridBagConstraints();
        gc.insets = new Insets(5, 15, 8, 15);
        gc.gridx = 1;
        gc.gridy = 0;
        gc.weightx = 1;
        resultPanel.add(primary, gc);

        gc = new GridBagConstraints();
        gc.insets = new Insets(5, 15, 8, 15);
        gc.gridx = 1;
        gc.gridy = 1;
        gc.weightx = 1;
        resultPanel.add(secondary, gc);

        gc = new GridBagConstraints();
        gc.insets = new Insets(5, 15, 8, 15);
        gc.gridx = 2;
        gc.gridy = 0;
        gc.weightx = 1;
        resultPanel.add(tertiary, gc);

        gc = new GridBagConstraints();
        gc.insets = new Insets(5, 15, 8, 15);
        gc.gridx = 2;
        gc.gridy = 1;
        gc.weightx = 1;
        resultPanel.add(quaternary, gc);

        gc = new GridBagConstraints();
        gc.insets = new Insets(5, 15, 8, 15);
        gc.gridx = 3;
        gc.gridy = 0;
        gc.weightx = 1;
        resultPanel.add(quinary, gc);

        pane.add(resultPanel, gBC);
    }
}
