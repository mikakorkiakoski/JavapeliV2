package com.example.demo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Question {
    private String questionText;
    private List<String> options;

    @JsonIgnore
    private String correctOptionIndex = "";

    public Question(String questionText, List<String> options, String correctOptionIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public String getCorrectOptionIndex() {
        return correctOptionIndex;
    }

    public void setCorrectOptionIndex(String correctOptionIndex) {
        this.correctOptionIndex = correctOptionIndex;
    }
}