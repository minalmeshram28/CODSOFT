import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Subject physics = new Subject("Physics");
        Subject chemistry = new Subject("Chemistry");
        Subject maths = new Subject("Maths");
        Subject biology = new Subject("Biology");
        Subject it = new Subject("IT");

        Subject[] subjects = { physics, chemistry, maths, biology, it };

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student's name: ");
        String studentName = sc.nextLine();

        Student student = new Student(studentName, subjects);
        student.inputMarks();
        student.displayResults();
    }
}