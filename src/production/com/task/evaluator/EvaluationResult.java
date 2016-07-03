package com.task.evaluator;

import java.util.Comparator;

/**
 * Created by user on 7/3/2016.
 */
public class EvaluationResult {

    private int primary = -1;
    private int secondary = -1;
    private int tertiary = -1;
    private int quaternary = -1;
    private int quinary = -1;

    private int partialOrder;
    private boolean isPartialOrder = false;
    public static Comparator<EvaluationResult> byPartialOrder = (evaluationResult1, evaluationResult2) -> Integer.compare(evaluationResult1.partialOrder, evaluationResult2.partialOrder);
    public static Comparator<EvaluationResult> byPrimary = (evaluationResult1, evaluationResult2) -> Integer.compare(evaluationResult1.primary, evaluationResult2.primary);
    public static Comparator<EvaluationResult> bySecondary = (evaluationResult1, evaluationResult2) -> Integer.compare(evaluationResult1.secondary, evaluationResult2.secondary);
    public static Comparator<EvaluationResult> byTertiary = (evaluationResult1, evaluationResult2) -> Integer.compare(evaluationResult1.tertiary, evaluationResult2.tertiary);
    public static Comparator<EvaluationResult> byQuatinary = (evaluationResult1, evaluationResult2) -> Integer.compare(evaluationResult1.quaternary, evaluationResult2.quaternary);
    public static Comparator<EvaluationResult> byQuinary = (evaluationResult1, evaluationResult2) -> Integer.compare(evaluationResult1.quinary, evaluationResult2.quinary);

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
}
