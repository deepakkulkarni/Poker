package com.task.poker.evaluator;

/**
 * Created by user on 7/1/2016.
 */
public interface Evaluator {

    default EvaluationResult evaluate() {
        return new EvaluationResult();
    }

}
