import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("******************** QUIZ APPLICATION ********************");
        System.out.println("Instructions:");
        System.out.println("1. There are a total of 20 questions in this quiz based on JAVA.");
        System.out.println("2. Time limit for each question is 15 seconds.");
        System.out.println("3. Enter the correct option (1-4).");
        System.out.println("4. 1 mark for each correct answer.");
        System.out.println("5. If the answer is not given in time, it will be considered as incorrect.");
        System.out.println("********************************************************\n");

        String jdbcUrl = "jdbc:mysql://localhost:3306/quiz_database";
        String username = "root";
        String password = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            List<Question> questions = fetchQuestionsFromDatabase(connection);
            Quiz quiz = new Quiz(questions);
            quiz.startQuiz();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static List<Question> fetchQuestionsFromDatabase(Connection connection) {
        List<Question> fetchedQuestions = new ArrayList<>();
        String query = "SELECT question, option1, option2, option3, option4, correct_option_index FROM questions";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String questionText = resultSet.getString("question");
                List<String> options = List.of(
                        resultSet.getString("option1"),
                        resultSet.getString("option2"),
                        resultSet.getString("option3"),
                        resultSet.getString("option4")
                );
                int correctOptionIndex = resultSet.getInt("correct_option_index");
                fetchedQuestions.add(new Question(questionText, options, correctOptionIndex));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return fetchedQuestions;
    }
}
