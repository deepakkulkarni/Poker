package com.task.poker.ui;

import com.task.poker.entity.Card;
import com.task.poker.entity.Deck;
import com.task.poker.entity.PokerHand;
import com.task.poker.evaluator.EvaluationResult;
import com.task.poker.evaluator.HandEvaluator;
import com.task.poker.util.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by user on 7/9/2016.
 */
public class Facade {

    public String[] getHandsWithOneDeck() {
        String hand[] = getHand(10);
        return hand;
    }

    public String[] getHandsWithMultipleDecks() {
        String hand1[] = getHand(5);
        String hand2[] = getHand(5);
        String[] hand = new String[hand1.length + hand2.length];
        System.arraycopy(hand1, 0, hand, 0, hand1.length);
        System.arraycopy(hand2, 0, hand, hand1.length, hand2.length);
        return hand;
    }

    private String[] getHand(int size) {
        String[] hand = new String[size];
        int idx = 0;
        Deck deck = new Deck();
        Set<Card> cards = deck.drawCards(size);
        for (Card card : cards) {
            String suite = Constants.SUITE.valueOf(card.getSuite()).getAbbreviation();
            String rank = Constants.RANK.valueOf(card.getRank()).getAbbreviation();
            hand[idx] = suite + rank;
            idx++;
        }
        return hand;
    }

    public PokerHand composeHand1() {
        List<Card> cards = new ArrayList<>();
        String input[] = Form.readHand1();
        for (int idx = 0; idx < input.length; idx++) {
            char temp[] = input[idx].toCharArray();
            Card card = new Card(findSuiteByAbbreviation(Character.toString(temp[0])), findRankByAbbreviation(Character.toString(temp[1])));
            cards.add(card);
        }
        PokerHand pokerHand = new PokerHand(cards);
        return pokerHand;
    }

    public PokerHand composeHand2() {
        List<Card> cards = new ArrayList<>();
        String input[] = Form.readHand2();
        for (int idx = 0; idx < input.length; idx++) {
            char temp[] = input[idx].toCharArray();
            Card card = new Card(findSuiteByAbbreviation(Character.toString(temp[0])), findRankByAbbreviation(Character.toString(temp[1])));
            cards.add(card);
        }
        PokerHand pokerHand = new PokerHand(cards);
        return pokerHand;
    }

    public void evaluateResult() {
        List<PokerHand> pokerHands = composeInput();
        List<EvaluationResult> evaluationResults = new ArrayList<>();

        for (PokerHand pokerHand : pokerHands) {
            HandEvaluator handEvaluator = new HandEvaluator(pokerHand);
            EvaluationResult evaluationResult = handEvaluator.evaluate();
            evaluationResult.setPokerHand(pokerHand);
            evaluationResults.add(evaluationResult);
        }

        EvaluationResult evaluationResult = new EvaluationResult();
        EvaluationResult winner = evaluationResult.getWinner(evaluationResults);

        Form.setResult(getWinnerHand(winner.getPokerHand()),winner);
        winner.getPokerHand().listCards();
        System.out.println(winner.getPartialOrder());
        System.out.println(Constants.PARTIAL_ORDER.values()[winner.getPartialOrder() - 1]);
        System.out.println(winner.getPrimary());
        System.out.println(winner.getSecondary());
        System.out.println(winner.getTertiary());
        System.out.println(winner.getQuaternary());
        System.out.println(winner.getQuinary());
    }

    private String getWinnerHand(PokerHand winnerHand) {
        StringBuffer buffer = new StringBuffer();
        for (Card card : winnerHand.getOriginalCards()) {
            String suite = Constants.SUITE.valueOf(card.getSuite()).getAbbreviation();
            String rank = Constants.RANK.valueOf(card.getRank()).getAbbreviation();
            buffer.append(suite + rank);
            buffer.append("     ");
        }
        return buffer.toString();
    }

    private static List<PokerHand> composeInput() {
        Facade facade = new Facade();
        List<PokerHand> pokerHands = new ArrayList<>();
        PokerHand pokerHand1 = facade.composeHand1();
        PokerHand pokerHand2 = facade.composeHand2();
        pokerHands.add(pokerHand1);
        pokerHands.add(pokerHand2);
        return pokerHands;
    }

    public void launchGUI() throws Exception {
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

    private static String findRankByAbbreviation(String abbr) {
        for (Constants.RANK rank : Constants.RANK.values()) {
            if (rank.getAbbreviation().equals(abbr)) {
                return rank.name();
            }
        }
        return "";
    }

    private static String findSuiteByAbbreviation(String abbr) {
        for (Constants.SUITE suite : Constants.SUITE.values()) {
            if (suite.getAbbreviation().equals(abbr)) {
                return suite.name();
            }
        }
        return "";
    }
}
