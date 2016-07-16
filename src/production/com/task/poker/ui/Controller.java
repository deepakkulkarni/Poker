package com.task.poker.ui;

import com.task.poker.Facade;
import com.task.poker.core.entity.hand.PokerHand;
import com.task.poker.core.evaluator.EvaluationResult;
import com.task.poker.util.Constants;

import java.util.List;

/**
 * Created by user on 7/13/2016.
 */
public class Controller {

    public static void evaluateResult() {
        if (!Model.validate())
            return;
        resetResultPanel();
        evaluateWinner();
    }

    public static void distributeCards() {
        Facade facade = new Facade();

        String hand[] = facade.getHandsWithOneDeck();
        if (View.isDeck1Selected && View.isDeck2Selected)
            hand = facade.getHandsWithMultipleDecks();

        View.card1.setText(hand[0]);
        View.card2.setText(hand[1]);
        View.card3.setText(hand[2]);
        View.card4.setText(hand[3]);
        View.card5.setText(hand[4]);
        View.card6.setText(hand[5]);
        View.card7.setText(hand[6]);
        View.card8.setText(hand[7]);
        View.card9.setText(hand[8]);
        View.card10.setText(hand[9]);
    }

    public static String[] readHand1() {
        String input[] = new String[5];
        input[0] = View.card1.getText();
        input[1] = View.card2.getText();
        input[2] = View.card3.getText();
        input[3] = View.card4.getText();
        input[4] = View.card5.getText();
        return input;
    }

    public static String[] readHand2() {
        String input[] = new String[5];
        input[0] = View.card6.getText();
        input[1] = View.card7.getText();
        input[2] = View.card8.getText();
        input[3] = View.card9.getText();
        input[4] = View.card10.getText();
        return input;
    }

    private static void evaluateWinner() {
        Facade facade = new Facade();
        List<PokerHand> pokerHands = facade.composeInput();
        EvaluationResult winner = facade.getEvaluationResult(pokerHands);
        Model.setResult(facade.getWinnerHandDetails(winner.getPokerHand()), winner);
        facade.printResultToConsoleAndFile(winner);
    }

    private static void resetResultPanel() {
        View.result.setText(Constants.EMPTY_STRING);
        View.partialOrder.setText(Constants.EMPTY_STRING);
        View.primary.setText(Constants.EMPTY_STRING);
        View.secondary.setText(Constants.EMPTY_STRING);
        View.tertiary.setText(Constants.EMPTY_STRING);
        View.quaternary.setText(Constants.EMPTY_STRING);
        View.quinary.setText(Constants.EMPTY_STRING);
    }

    public static void checkBox2Clicked() {
        View.isDeck2Selected = View.deck2.isSelected();
    }
}
