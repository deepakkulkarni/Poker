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
        return true;
    }


    public static void setResult(String hand, EvaluationResult winner) {
        View.result.setFont(View.font);
        View.partialOrder.setFont(View.font);
        View.primary.setFont(View.font);
        View.secondary.setFont(View.font);
        View.tertiary.setFont(View.font);
        View.quaternary.setFont(View.font);
        View.quinary.setFont(View.font);
        if (winner.isEqual()) View.result.setText("Both hands are identical.");
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
        if (View.card1.getText().equals("") || View.card2.getText().equals("") || View.card3.getText().equals("") || View.card4.getText().equals("") || View.card5.getText().equals("")
                || View.card6.getText().equals("") || View.card7.getText().equals("") || View.card8.getText().equals("") || View.card9.getText().equals("") || View.card10.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter all card details.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private static boolean validateCardsLength() {
        if (View.card1.getText().length() != 2 || View.card2.getText().length() != 2 || View.card3.getText().length() != 2 || View.card4.getText().length() != 2 || View.card5.getText().length() != 2
                || View.card6.getText().length() != 2 || View.card7.getText().length() != 2 || View.card8.getText().length() != 2 || View.card9.getText().length() != 2 || View.card10.getText().length() != 2) {
            JOptionPane.showMessageDialog(null, "Card details should contain only 2 characters.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private static boolean duplicateCardHand1Validation() {

        List<JTextField> hand1 = new ArrayList();
        hand1.add(View.card1);
        hand1.add(View.card2);
        hand1.add(View.card3);
        hand1.add(View.card4);
        hand1.add(View.card5);


        for (int idx = 0; idx < hand1.size(); idx++) {
            int count = 0;
            for (int idy = 0; idy < hand1.size(); idy++) {
                if (idx != idy && hand1.get(idx).getText().equals(hand1.get(idy).getText())) {
                    count++;
                }
            }
            if (count == 1) {
                JOptionPane.showMessageDialog(null, "Hand 1 contains duplicate cards.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        return true;
    }

    private static boolean duplicateCardHand2Validation() {

        List<JTextField> hand2 = new ArrayList();
        hand2.add(View.card6);
        hand2.add(View.card7);
        hand2.add(View.card8);
        hand2.add(View.card9);
        hand2.add(View.card10);

        for (int idx = 0; idx < hand2.size(); idx++) {
            int count = 0;
            for (int idy = 0; idy < hand2.size(); idy++) {
                if (idx != idy && hand2.get(idx).getText().equals(hand2.get(idy).getText())) {
                    count++;
                }
            }
            if (count == 1) {
                JOptionPane.showMessageDialog(null, "Hand 2 contain duplicate cards.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
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
}
