import java.util.Scanner;

public class StudentGradeCalculator {

    
    public static String calculateLetterGrade(double averageScore) {
        if (averageScore >= 90) {
            return "A";
        } else if (averageScore >= 80) {
            return "B";
        } else if (averageScore >= 70) {
            return "C";
        } else if (averageScore >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        
        String[] studentNames = new String[numStudents];
        double[] studentScores = new double[numStudents];
        double totalClassScore = 0;

        
        for (int i = 0; i < numStudents; i++) {
            scanner.nextLine();
            
            System.out.print("Enter the name of student " + (i + 1) + ": ");
            studentNames[i] = scanner.nextLine();

            System.out.print("Enter the total score for " + studentNames[i] + ": ");
            studentScores[i] = scanner.nextDouble();

            totalClassScore += studentScores[i];
        }

        
        System.out.println("\nStudent Grades:");
        for (int i = 0; i < numStudents; i++) {
            double averageScore = studentScores[i];
            
            String letterGrade = calculateLetterGrade(averageScore);
            System.out.println(studentNames[i] + ": Average Score = " + averageScore + ", Letter Grade = " + letterGrade);
        }

        
        double classAverage = totalClassScore / numStudents;
        System.out.println("\nClass Average Score: " + classAverage);

        
        double highestScore = studentScores[0];
        double lowestScore = studentScores[0];
        String highestScoringStudent = studentNames[0];
        String lowestScoringStudent = studentNames[0];

        for (int i = 1; i < numStudents; i++) {
            if (studentScores[i] > highestScore) {
                highestScore = studentScores[i];
                highestScoringStudent = studentNames[i];
            }
            if (studentScores[i] < lowestScore) {
                lowestScore = studentScores[i];
                lowestScoringStudent = studentNames[i];
            }
        }

        System.out.println("Highest Score: " + highestScore + " by " + highestScoringStudent);
        System.out.println("Lowest Score: " + lowestScore + " by " + lowestScoringStudent);

        scanner.close();
    }
}
