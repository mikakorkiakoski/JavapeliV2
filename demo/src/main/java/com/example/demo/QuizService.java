package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class QuizService {
    private Quiz quiz;
    private int score = 0;

    public void startGame() {
        // Initialize the quiz and questions here and set score to 0

        score = 0;
        List<Question> questions = new ArrayList<>();

        Question question1 = new Question("What is the capital of France?", Arrays.asList("A: London", "B: Berlin", "C: Paris"), "C");
        Question question2 = new Question("Which planet is known as the Red Planet?", Arrays.asList("A: Earth", "B: Mars", "C: Venus"), "B");
        Question question3 = new Question("What is the largest mammal in the world?", Arrays.asList("A: Elephant", "B: Giraffe", "C: Blue Whale"), "C");

        questions.add(question1);
        questions.add(question2);
        questions.add(question3);

        quiz = new Quiz(questions);
    }

    public Question getCurrentQuestion() {
        if (quiz != null && quiz.getQuestions() != null && !quiz.getQuestions().isEmpty()) {
            int currentQuestionIndex = quiz.getCurrentQuestionIndex();

            if (currentQuestionIndex >= 0 && currentQuestionIndex < 4) {
                return quiz.getQuestions().get(currentQuestionIndex);
            }
        }
        return null;
    }

    public String submitAnswer(String answerIndex) {
        if (quiz != null && quiz.getQuestions() != null && !quiz.getQuestions().isEmpty()) {
            int currentQuestionIndex = quiz.getCurrentQuestionIndex();

            if (currentQuestionIndex + 1 <= quiz.getQuestions().size()) {
                Question currentQuestion = quiz.getQuestions().get(currentQuestionIndex);

                // Check if the answerIndex matches the correctOptionIndex
                if (answerIndex.equals(currentQuestion.getCorrectOptionIndex())) {
                    // Add score always if answer is right.
                    score++;

                    if (currentQuestionIndex + 1 == quiz.getQuestions().size()) {
                        quiz.setCurrentQuestionIndex(currentQuestionIndex + 1);
                        return "Correct! Game Over! Your Score: " + score + " / " + quiz.getQuestions().size() + ". Start again by initializing /start.";
                    } else {
                        quiz.setCurrentQuestionIndex(currentQuestionIndex + 1);
                        return "Correct! Move to the next question in /question .";
                    }
                } else {
                    if (currentQuestionIndex + 1 == quiz.getQuestions().size()) {
                        quiz.setCurrentQuestionIndex(currentQuestionIndex + 1);
                        return "Incorrect! Game Over! Your Score: " + score + " / " + quiz.getQuestions().size() + ". Start again by initializing /start.";
                    } else {
                        quiz.setCurrentQuestionIndex(currentQuestionIndex + 1);
                        return "Incorrect! Move to the next question in /question .";
                    }
                }
                //If user tries to post after the game is over, we give no more points, we just tell that the game is over.
            } else if (currentQuestionIndex == quiz.getQuestions().size()) {
                return "Game Over! Your Score: " + score + " / " + quiz.getQuestions().size() + ". Start again by initializing /start.";
            }
        }

        return "Error!"; // Return an error message if there's an issue with the game state
    }

}
