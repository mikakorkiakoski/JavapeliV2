package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
    private final QuizService quizService;

    public MyRestController(QuizService quizService) {
        this.quizService = quizService;
    }

    // Welcomes you to the game and gives a guide how to start the game.
    @GetMapping("/")
    public String getInfo() {
        return "Welcome to the Quiz game! When you are ready, please use /start to launch the game.";
    }

    // Initializes the game and guides to the first question
    @GetMapping("/start")
    public String startGame() {
        quizService.startGame();
        return "Quiz started. Use /question to get the first question.";
    }

    // Gets current question if game is initialized and if there is questions to get.
    @GetMapping("/question")
    public Question getCurrentQuestion() {
        return quizService.getCurrentQuestion();
    }

    // Posts answer for questions. After a post, updates the currentQuestion. Returns Correct or incorrect or game over and updates score.
    @PostMapping("/answer")
    public String submitAnswer(@RequestParam String answerIndex) {
        String response = quizService.submitAnswer(answerIndex);
        return response;
    }
}
