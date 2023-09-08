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
        displayNextQuestion();
    }

    private void displayNextQuestion() {
        if (currentQuestionIndex < questions.size()) {
            Question currentQuestion = questions.get(currentQuestionIndex);
            System.out.println(currentQuestion.getQuestion());
            List<String> options = currentQuestion.getOptions();

            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }

            startTimer(currentQuestion);
            int selectedOptionIndex = getUserChoice(options.size());
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
            selectedOptionIndex = scanner.nextInt() - 1;

            if (selectedOptionIndex < 0 || selectedOptionIndex >= maxOption) {
                System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

        return selectedOptionIndex;
    }

    private void startTimer(Question question) {
        if (timer != null) {
            timer.cancel();
        }

        timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time's up! You didn't answer this question.\n");
                processAnswer(-1);
            }
        }, 15000);
    }


    public void processAnswer(int selectedOptionIndex) {
        timer.cancel();
        Question currentQuestion = questions.get(currentQuestionIndex);

        if (selectedOptionIndex == -1) {
            
            currentQuestionIndex++;
        } else if (currentQuestion.isCorrect(selectedOptionIndex)) {
            System.out.println("Correct!\n");
            score++;
            currentQuestionIndex++;
        } else {
            System.out.println("Incorrect.\n");
            currentQuestionIndex++;
        }

        displayNextQuestion();
    }

    private void showResult() {
        System.out.println("Quiz ended. Your score: " + score + "/" + questions.size());
    }
}
