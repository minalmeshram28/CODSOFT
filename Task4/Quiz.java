import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Scanner;

class Quiz {

    private List<Question> questions;
    private int currentQuestionIndex;
    private int score;
    private Timer timer;

    public Quiz(List<Question> questions) {
        this.questions = questions;
        this.currentQuestionIndex = 0;
        this.score = 0;
        this.timer = new Timer();
    }

    public void startQuiz() {
        displayCurrentQuestion();
    }

    private void displayCurrentQuestion() {
        if (currentQuestionIndex < questions.size()) {
            Question currentQuestion = questions.get(currentQuestionIndex);
            System.out.println(currentQuestion.getQuestion());

            List<String> options = currentQuestion.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }

            startTimer(currentQuestion);
            System.out.println("DEBUG: Timer started.");

            int selectedOptionIndex = getUserChoice(options.size());
            System.out.println("DEBUG: Selected option: " + selectedOptionIndex);
            processAnswer(selectedOptionIndex);


        } else {
            showResult();
        }
    }

    private int getUserChoice(int maxOption) {
        Scanner scanner = new Scanner(System.in);
        int selectedOptionIndex = -1;

        while (selectedOptionIndex < 0 || selectedOptionIndex >= maxOption) {
            System.out.print("Enter your answer (1-4): ");
            selectedOptionIndex = scanner.nextInt()-1;

            if (selectedOptionIndex < 0 || selectedOptionIndex >=maxOption) {
                System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

        return selectedOptionIndex;
    }

    private void startTimer(Question question) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                processAnswer(-1);
            }
        }, 15000);
    }




    public void processAnswer(int selectedOptionIndex) {
        Question currentQuestion = questions.get(currentQuestionIndex);
        if (selectedOptionIndex == -1) {
            System.out.println("Time's up! You didn't answer this question.\n");
            currentQuestionIndex++;
            displayNextOrShowResult();
//            return;
        }

        if (currentQuestion.isCorrect(selectedOptionIndex)) {
            System.out.println("Correct!\n");
            score++;
        } else {
            System.out.println("Incorrect.\n");
        }

        currentQuestionIndex++;
        displayNextOrShowResult();
    }

    private void displayNextOrShowResult() {
        if (currentQuestionIndex < questions.size()) {
            displayCurrentQuestion();

        } else {
            showResult();
        }
    }


    private void showResult() {

        System.out.println("Quiz ended. Your score: " + score + "/" + questions.size());
    }
}


