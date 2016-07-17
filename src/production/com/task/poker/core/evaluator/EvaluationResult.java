package com.task.poker.core.evaluator;

import com.task.poker.core.entity.hand.PokerHand;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by user on 7/3/2016.
 */
public final class EvaluationResult {

    private int primary = -1;
    private int secondary = -1;
    private int tertiary = -1;
    private int quaternary = -1;
    private int quinary = -1;
    private PokerHand pokerHand;
    private boolean isEqual = false;

    private int partialOrder;
    private boolean isPartialOrder = false;

    public final static Comparator<EvaluationResult> byPartialOrder = (e1, e2) -> Integer.compare(e1.partialOrder, e2.partialOrder);
    public final static Comparator<EvaluationResult> byPrimary = (e1, e2) -> Integer.compare(e1.primary, e2.primary);
    public final static Comparator<EvaluationResult> bySecondary = (e1, e2) -> Integer.compare(e1.secondary, e2.secondary);
    public final static Comparator<EvaluationResult> byTertiary = (e1, e2) -> Integer.compare(e1.tertiary, e2.tertiary);
    public final static Comparator<EvaluationResult> byQuatinary = (e1, e2) -> Integer.compare(e1.quaternary, e2.quaternary);
    public final static Comparator<EvaluationResult> byQuinary = (e1, e2) -> Integer.compare(e1.quinary, e2.quinary);

    public EvaluationResult getWinner(List<EvaluationResult> evaluationResults) {

        EvaluationResult evaluationResult;
        if (evaluationResults.get(0).getPartialOrder() != evaluationResults.get(1).getPartialOrder()) {
            Collections.sort(evaluationResults, EvaluationResult.byPartialOrder);
            evaluationResult = evaluationResults.get(0);
            return evaluationResult;
        } else if (evaluationResults.get(0).getPrimary() != evaluationResults.get(1).getPrimary()) {
            Collections.sort(evaluationResults, EvaluationResult.byPrimary);
            evaluationResult = evaluationResults.get(1);
            return evaluationResult;
        } else if (evaluationResults.get(0).getSecondary() != evaluationResults.get(1).getSecondary()) {
            Collections.sort(evaluationResults, EvaluationResult.bySecondary);
            evaluationResult = evaluationResults.get(1);
            return evaluationResult;
        } else if (evaluationResults.get(0).getTertiary() != evaluationResults.get(1).getTertiary()) {
            Collections.sort(evaluationResults, EvaluationResult.byTertiary);
            evaluationResult = evaluationResults.get(1);
            return evaluationResult;
        } else if (evaluationResults.get(0).getQuaternary() != evaluationResults.get(1).getQuaternary()) {
            Collections.sort(evaluationResults, EvaluationResult.byQuatinary);
            evaluationResult = evaluationResults.get(1);
            return evaluationResult;
        } else if (evaluationResults.get(0).getQuinary() != evaluationResults.get(1).getQuinary()) {
            Collections.sort(evaluationResults, EvaluationResult.byQuinary);
            evaluationResult = evaluationResults.get(1);
            return evaluationResult;
        } else {
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
