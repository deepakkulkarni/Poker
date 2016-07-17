package com.task.poker.ui;

import com.task.poker.util.Constants;
import com.task.poker.core.evaluator.EvaluationResult;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 7/12/2016.
 */
public class Model {

    public static boolean validate() {
        if (!validateBlankCards()) return false;
        if (!validateCardsLength()) return false;
        if (!validateData()) return false;
        if (!duplicateCardHand1Validation()) return false;
        if (!duplicateCardHand2Validation()) return false;
        if (!duplicateCardValidationForBothHands()) return false;
        return true;
    }

    public static void setResultToUI(String hand, EvaluationResult winner) {
        setFont();
        if (winner.isEqual()) View.result.setText("BOTH HANDS ARE IDENTICAL. PLEASE REDISTRIBUTE");
        else View.result.setText("Winner Hand : " + hand);

        View.partialOrder.setText("Partial Order : " + Constants.PARTIAL_ORDER.values()[winner.getPartialOrder() - 1].toString());
        if (winner.getPrimary() != -1)
            View.primary.setText("Primary Rank : " + Constants.RANK.valueOf(winner.getPrimary()) + "  (" + winner.getPrimary() + ")");
        if (winner.getSecondary() != -1)
            View.secondary.setText("Secondary Rank : " + Constants.RANK.valueOf(winner.getSecondary()) + "  (" + winner.getSecondary() + ")");
        if (winner.getTertiary() != -1)
            View.tertiary.setText("Tertiary Rank : " + Constants.RANK.valueOf(winner.getTertiary()) + "  (" + winner.getTertiary() + ")");
        if (winner.getQuaternary() != -1)
            View.quaternary.setText("Quaternary Rank : " + Constants.RANK.valueOf(winner.getQuaternary()) + "  (" + winner.getQuaternary() + ")");
        if (winner.getQuinary() != -1)
            View.quinary.setText("Quinary Rank : " + Constants.RANK.valueOf(winner.getQuinary()) + "  (" + winner.getQuinary() + ")");
    }

    private static boolean validateBlankCards() {
        if (checkBlank(View.card1) || checkBlank(View.card2) || checkBlank(View.card3) || checkBlank(View.card4) || checkBlank(View.card5)
                || checkBlank(View.card6) || checkBlank(View.card7) || checkBlank(View.card8) || checkBlank(View.card9) || checkBlank(View.card10)) {
            JOptionPane.showMessageDialog(null, "Please enter all card details.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }


    private static boolean validateCardsLength() {
        if (checkLength(View.card1) || checkLength(View.card2) || checkLength(View.card3) || checkLength(View.card4) || checkLength(View.card5)
                || checkLength(View.card6) || checkLength(View.card7) || checkLength(View.card8) || checkLength(View.card9) || checkLength(View.card10)) {
            JOptionPane.showMessageDialog(null, "Card details should contain only 2 characters.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private static boolean duplicateCardHand1Validation() {
        List<JTextField> hand1 = composeHand1();
        return duplicateCardValidation(hand1, "Hand 1");
    }

    private static boolean duplicateCardHand2Validation() {
        List<JTextField> hand2 = composeHand2();
        return duplicateCardValidation(hand2, "Hand 2");
    }

    private static boolean validateData() {
        if (cardDataValidation(View.card1.getText())) return false;
        if (cardDataValidation(View.card2.getText())) return false;
        if (cardDataValidation(View.card3.getText())) return false;
        if (cardDataValidation(View.card4.getText())) return false;
        if (cardDataValidation(View.card5.getText())) return false;
        if (cardDataValidation(View.card6.getText())) return false;
        if (cardDataValidation(View.card7.getText())) return false;
        if (cardDataValidation(View.card8.getText())) return false;
        if (cardDataValidation(View.card9.getText())) return false;
        if (cardDataValidation(View.card10.getText())) return false;
        return true;
    }

    private static boolean cardDataValidation(String text) {
        char data[] = text.toCharArray();
        if (!Constants.SUITE.contains("" + data[0]) || !Constants.RANK.contains("" + data[1])) {
            JOptionPane.showMessageDialog(null, "Invalid data at " + text, "Validation Error", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        return false;
    }

    private static boolean duplicateCardValidation(List<JTextField> hand, String handNumber) {
        for (int idx = 0; idx < hand.size(); idx++) {
            int count = 0;
            for (int idy = 0; idy < hand.size(); idy++) {
                if (idx != idy && hand.get(idx).getText().equals(hand.get(idy).getText())) {
                    count++;
                }
            }
            if (count == 1) {
                JOptionPane.showMessageDialog(null, handNumber + " contains duplicate cards.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }

    private static boolean duplicateCardValidationForBothHands() {
        List<JTextField> hand1 = composeHand1();
        List<JTextField> hand2 = composeHand2();

        for (int idx = 0; idx < hand1.size(); idx++) {
            int count = 0;
            for (int idy = 0; idy < hand2.size(); idy++) {
                if (idx != idy && hand1.get(idx).getText().equals(hand2.get(idy).getText())) {
                    count++;
                }
            }
            if (count == 1 && !View.isDeck2Selected) {
                JOptionPane.showMessageDialog(null, "Only one deck is used but duplicate cards found in both hands.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }

    private static void setFont() {
        View.result.setFont(View.font);
        View.partialOrder.setFont(View.font);
        View.primary.setFont(View.font);
        View.secondary.setFont(View.font);
        View.tertiary.setFont(View.font);
        View.quaternary.setFont(View.font);
        View.quinary.setFont(View.font);
    }

    private static boolean checkLength(JTextField field) {
        return field.getText().length() != 2;
    }

    private static boolean checkBlank(JTextField field) {
        return field.getText().equals("");
    }

    private static List<JTextField> composeHand2() {
        List<JTextField> hand2 = new ArrayList<>();
        hand2.add(View.card6);
        hand2.add(View.card7);
        hand2.add(View.card8);
        hand2.add(View.card9);
        hand2.add(View.card10);
        return hand2;
    }

    private static List<JTextField> composeHand1() {
        List<JTextField> hand1 = new ArrayList<>();
        hand1.add(View.card1);
        hand1.add(View.card2);
        hand1.add(View.card3);
        hand1.add(View.card4);
        hand1.add(View.card5);
        return hand1;
    }
}
