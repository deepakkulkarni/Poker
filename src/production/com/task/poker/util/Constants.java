package com.task.poker.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 6/26/2016.
 */
public class Constants {

    public static final int handSize = 5;
    public static final String EMPTY_STRING = "";
    public static final String SPACE = "  ";

    public enum SUITE {
        HEART("H", 1), DIAMOND("D", 2), SPADE("S", 3), CLUB("C", 4);

        private final int value;
        private final String abbreviation;

        SUITE(String abbreviation, int value) {
            this.abbreviation = abbreviation;
            this.value = value;
        }

        public static boolean contains(String value) {
            for (SUITE suite : SUITE.values()) {
                if (suite.abbreviation.equals(value)) {
                    return true;
                }
            }
            return false;
        }

        public String getAbbreviation() {
            return abbreviation;
        }

        public int getValue() {
            return value;
        }
    }

    public enum RANK {
        TWO("2", 2), THREE("3", 3), FOUR("4", 4), FIVE("5", 5), SIX("6", 6), SEVEN("7", 7), EIGHT("8", 8), NINE("9", 9), TEN("T", 10),
        JACK("J", 11), QUEEN("Q", 12), KING("K", 13), ACE("A", 14);

        private final int value;
        private final String abbreviation;
        private static Map<Integer, RANK> map = new HashMap<Integer, RANK>();

        static {
            for (RANK rank : RANK.values()) {
                map.put(rank.value, rank);
            }
        }

        RANK(String abbreviation, int value) {
            this.abbreviation = abbreviation;
            this.value = value;
        }

        public static RANK valueOf(int value) {
            return map.get(value);
        }

        public String getAbbreviation() {
            return abbreviation;
        }

        public int getValue() {
            return value;
        }

        public static boolean contains(String abbreviation) {
            for (RANK rank : RANK.values()) {
                if (rank.abbreviation.equals(abbreviation)) {
                    return true;
                }
            }
            return false;
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
