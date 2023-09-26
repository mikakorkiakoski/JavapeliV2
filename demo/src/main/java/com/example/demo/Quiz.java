package com.example.demo;

import java.util.List;

public class Quiz {
    private List<Question> questions;
    private int currentQuestionIndex;

    public Quiz(List<Question> questions) {
        this.questions = questions;
        this.currentQuestionIndex = 0; // Start with the first question
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public int getCurrentQuestionIndex() {
        return currentQuestionIndex;
    }

    public void setCurrentQuestionIndex(int currentQuestionIndex) {
        this.currentQuestionIndex = currentQuestionIndex;
    }
}
