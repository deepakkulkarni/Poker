package com.task.poker.evaluator;

/**
 * Created by user on 6/26/2016.
 */
public class TestConstants {

    public enum SUITE {
        HEART("H", 1), DIAMOND("D", 2), SPADE("S", 3), CLUB("C", 4);
        private final int value;
        private final String abbrevation;

        SUITE(String abbrevation ,int value) {
            this.abbrevation = abbrevation;
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum RANK {
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10),
        JACK(11), QUEEN(12), KING(13), ACE(14);

        private final int value;

        RANK(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }

    public enum PARTIAL_ORDER {
        STRAIGHT_FLUSH(1), FOUR_OF_A_KIND(2), FULL_HOUSE(3), FLUSH(4), STRAIGHT(5), THREE_OF_A_KIND(6),
        TWO_PAIRS(7), PAIR(8), HIGH_CARD(9);

        private final int value;

        PARTIAL_ORDER(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
