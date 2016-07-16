package com.task.poker;

import com.task.poker.core.entity.Card;
import com.task.poker.core.entity.Deck;
import com.task.poker.ui.Controller;
import com.task.poker.ui.View;
import com.task.poker.util.Constants;
import com.task.poker.core.entity.hand.PokerHand;
import com.task.poker.core.evaluator.EvaluationResult;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by user on 7/9/2016.
 */
public class Facade {

    private static final Logger logger = Logger.getLogger(Facade.class);

    public void launchGUI() {
        View.launchGUI();
    }

    public String[] getHandsWithOneDeck() {
        String hand[] = getCardsForHand(Constants.handSize * 2);
        return hand;
    }

    public String[] getHandsWithMultipleDecks() {
        String hand1[] = getCardsForHand(Constants.handSize);
        String hand2[] = getCardsForHand(Constants.handSize);
        String[] hand = new String[hand1.length + hand2.length];
        System.arraycopy(hand1, 0, hand, 0, hand1.length);
        System.arraycopy(hand2, 0, hand, hand1.length, hand2.length);
        return hand;
    }

    public PokerHand composeHand1() {
        List<Card> cards = new ArrayList<>();
        String input[] = Controller.readHand1();
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
        String input[] = Controller.readHand2();
        for (int idx = 0; idx < input.length; idx++) {
            char temp[] = input[idx].toCharArray();
            Card card = new Card(findSuiteByAbbreviation(Character.toString(temp[0])), findRankByAbbreviation(Character.toString(temp[1])));
            cards.add(card);
        }
        PokerHand pokerHand = new PokerHand(cards);
        return pokerHand;
    }

    public void printResultToConsoleAndFile(EvaluationResult winner) {
        logger.info("-------------------------------------------------------------------------------------");
        logger.info("WINNER HAND : ");
        winner.getPokerHand().listCards();
        logger.info("PARTIAL ORDER : " + Constants.PARTIAL_ORDER.values()[winner.getPartialOrder() - 1]);

        if (winner.getPrimary() != -1)
            logger.info("Primary Rank : " + Constants.RANK.valueOf(winner.getPrimary()) + "  (" + winner.getPrimary() + ")");
        if (winner.getSecondary() != -1)
            logger.info("Secondary Rank : " + Constants.RANK.valueOf(winner.getSecondary()) + "  (" + winner.getSecondary() + ")");
        if (winner.getTertiary() != -1)
            logger.info("Tertiary Rank : " + Constants.RANK.valueOf(winner.getTertiary()) + "  (" + winner.getTertiary() + ")");
        if (winner.getQuaternary() != -1)
            logger.info("Quaternary Rank : " + Constants.RANK.valueOf(winner.getQuaternary()) + "  (" + winner.getQuaternary() + ")");
        if (winner.getQuinary() != -1)
            logger.info("Quinary Rank : " + Constants.RANK.valueOf(winner.getQuinary()) + "  (" + winner.getQuinary() + ")");
        logger.info("-------------------------------------------------------------------------------------");
    }

    public String getWinnerHand(PokerHand winnerHand) {
        StringBuffer buffer = new StringBuffer();
        for (Card card : winnerHand.getOriginalCards()) {
            String suite = Constants.SUITE.valueOf(card.getSuite()).getAbbreviation();
            String rank = Constants.RANK.valueOf(card.getRank()).getAbbreviation();
            buffer.append(suite + rank);
            buffer.append("     ");
        }
        return buffer.toString();
    }

    private static String findRankByAbbreviation(String abbr) {
        for (Constants.RANK rank : Constants.RANK.values()) {
            if (rank.getAbbreviation().equals(abbr)) {
                return rank.name();
            }
        }
        return "";
    }

    public List<PokerHand> composeInput() {
        List<PokerHand> pokerHands = new ArrayList<>();
        PokerHand pokerHand1 = composeHand1();
        PokerHand pokerHand2 = composeHand2();
        pokerHands.add(pokerHand1);
        pokerHands.add(pokerHand2);
        return pokerHands;
    }

    private static String findSuiteByAbbreviation(String abbr) {
        for (Constants.SUITE suite : Constants.SUITE.values()) {
            if (suite.getAbbreviation().equals(abbr)) {
                return suite.name();
            }
        }
        return "";
    }

    private String[] getCardsForHand(int size) {
        String[] hand = new String[size];
        Deck deck = new Deck();
        Set<Card> cards = deck.drawCards(size);
        int idx = 0;
        for (Card card : cards) {
            String suite = Constants.SUITE.valueOf(card.getSuite()).getAbbreviation();
            String rank = Constants.RANK.valueOf(card.getRank()).getAbbreviation();
            hand[idx] = suite + rank;
            idx++;
        }
        return hand;
    }
}
