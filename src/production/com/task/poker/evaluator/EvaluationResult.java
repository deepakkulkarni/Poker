package com.task.poker.evaluator;

import com.task.poker.entity.PokerHand;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by user on 7/3/2016.
 */
public class EvaluationResult {

    private int primary = -1;
    private int secondary = -1;
    private int tertiary = -1;
    private int quaternary = -1;
    private int quinary = -1;
    private PokerHand pokerHand;
    private boolean isEqual = false;

    private int partialOrder;

    private boolean isPartialOrder = false;

    public static Comparator<EvaluationResult> byPartialOrder = (evaluationResult1, evaluationResult2) -> Integer.compare(evaluationResult1.partialOrder, evaluationResult2.partialOrder);
    public static Comparator<EvaluationResult> byPrimary = (evaluationResult1, evaluationResult2) -> Integer.compare(evaluationResult1.primary, evaluationResult2.primary);
    public static Comparator<EvaluationResult> bySecondary = (evaluationResult1, evaluationResult2) -> Integer.compare(evaluationResult1.secondary, evaluationResult2.secondary);
    public static Comparator<EvaluationResult> byTertiary = (evaluationResult1, evaluationResult2) -> Integer.compare(evaluationResult1.tertiary, evaluationResult2.tertiary);
    public static Comparator<EvaluationResult> byQuatinary = (evaluationResult1, evaluationResult2) -> Integer.compare(evaluationResult1.quaternary, evaluationResult2.quaternary);
    public static Comparator<EvaluationResult> byQuinary = (evaluationResult1, evaluationResult2) -> Integer.compare(evaluationResult1.quinary, evaluationResult2.quinary);
    public EvaluationResult getWinner(List<EvaluationResult> evaluationResults) {

        EvaluationResult evaluationResult = null;
        if (evaluationResults.get(0).getPartialOrder() != evaluationResults.get(1).getPartialOrder()) {
            Collections.sort(evaluationResults, EvaluationResult.byPartialOrder);
            evaluationResult = evaluationResults.get(0);
            return evaluationResult;
        }
        else if (evaluationResults.get(0).getPrimary() != evaluationResults.get(1).getPrimary()) {
            Collections.sort(evaluationResults, EvaluationResult.byPrimary);
            evaluationResult = evaluationResults.get(1);
            return evaluationResult;
        }
        else if (evaluationResults.get(0).getSecondary() != evaluationResults.get(1).getSecondary()) {
            Collections.sort(evaluationResults, EvaluationResult.bySecondary);
            evaluationResult = evaluationResults.get(1);
            return evaluationResult;
        }
        else if (evaluationResults.get(0).getTertiary() != evaluationResults.get(1).getTertiary()) {
            Collections.sort(evaluationResults, EvaluationResult.byTertiary);
            evaluationResult = evaluationResults.get(1);
            return evaluationResult;
        }
        else if (evaluationResults.get(0).getQuaternary() != evaluationResults.get(1).getQuaternary()) {
            Collections.sort(evaluationResults, EvaluationResult.byQuatinary);
            evaluationResult = evaluationResults.get(1);
            return evaluationResult;
        }
        else if (evaluationResults.get(0).getQuinary() != evaluationResults.get(1).getQuinary()) {
            Collections.sort(evaluationResults, EvaluationResult.byQuinary);
            evaluationResult = evaluationResults.get(1);
            return evaluationResult;
        }else{
            evaluationResult = evaluationResults.get(0);
            evaluationResult.setEqual(true);
            return evaluationResult;
        }
    }

    public boolean isPartialOrder() {
        return isPartialOrder;
    }

    public void setPartialOrder(boolean partialOrder) {
        isPartialOrder = partialOrder;
    }

    public int getPrimary() {
        return primary;
    }

    public void setPrimary(int primary) {
        this.primary = primary;
    }

    public int getSecondary() {
        return secondary;
    }

    public void setSecondary(int secondary) {
        this.secondary = secondary;
    }

    public int getTertiary() {
        return tertiary;
    }

    public void setTertiary(int tertiary) {
        this.tertiary = tertiary;
    }

    public int getQuaternary() {
        return quaternary;
    }

    public void setQuaternary(int quaternary) {
        this.quaternary = quaternary;
    }

    public int getQuinary() {
        return quinary;
    }

    public void setQuinary(int quinary) {
        this.quinary = quinary;
    }

    public int getPartialOrder() {
        return partialOrder;
    }

    public void setPartialOrder(int partialOrder) {
        this.partialOrder = partialOrder;
    }

    public PokerHand getPokerHand() {
        return pokerHand;
    }

    public void setPokerHand(PokerHand pokerHand) {
        this.pokerHand = pokerHand;
    }

    public boolean isEqual() {
        return isEqual;
    }

    public void setEqual(boolean equal) {
        isEqual = equal;
    }
}
