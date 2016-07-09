package com.task.poker.util;

/**
 * Created by user on 6/26/2016.
 */
public class Constants {

    public enum SUITE {
        HEART("H", 1), DIAMOND("D", 2), SPADE("S", 3), CLUB("C", 4);
        private final int value;
        private final String abbreviation;

        public String getAbbreviation() {
            return abbreviation;
        }

        SUITE(String abbreviation , int value) {
            this.abbreviation = abbreviation;
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum RANK {
        TWO("2",2), THREE("3",3), FOUR("4",4), FIVE("5",5), SIX("6",6), SEVEN("7",7), EIGHT("8",8), NINE("9",9), TEN("T",10),
        JACK("J",11), QUEEN("Q",12), KING("K",13), ACE("A",14);

        private final int value;
        private final String abbreviation;

        public String getAbbreviation() {
            return abbreviation;
        }

        RANK(String abbreviation, int value) {
            this.abbreviation = abbreviation;
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