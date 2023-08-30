import java.util.Scanner;

class Student {
    private String name;
    private Subject[] subjects;

    public Student(String name, Subject[] subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public void inputMarks() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < subjects.length; i++) {
            Subject subject = subjects[i];
            System.out.print("Enter marks obtained in " + subject.getName() + ": ");
            int marks = scanner.nextInt();
            subject.setMarksObtained(marks);
        }
    }


    public int calculateTotalMarks() {
        int totalMarks = 0;
        for (int i = 0; i < subjects.length; i++) {
            totalMarks += subjects[i].getMarksObtained();
        }
        return totalMarks;
    }


    public double calculateAveragePercentage() {
        int totalMarks = calculateTotalMarks();
        int totalSubjects = subjects.length;
        return (double) totalMarks / totalSubjects;
    }

    public String calculateGrade() {
        double averagePercentage = calculateAveragePercentage();
        if (averagePercentage >= 90) {
            return "A";
        } else if (averagePercentage >= 80) {
            return "B";
        } else if (averagePercentage >= 70) {
            return "C";
        } else if (averagePercentage >= 60) {
            return "D";
        }else if (averagePercentage>=50){
            return "E";
        } else {
            return "F";
        }
    }

    public void displayResults() {
        int totalMarks = calculateTotalMarks();
        double averagePercentage = calculateAveragePercentage();
        String grade = calculateGrade();

        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
    }
}
