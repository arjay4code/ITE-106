import java.util.Scanner;

public class StudentGradebook {

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
        System.out.print("Enter the number of assignments: ");
        int numAssignments = scanner.nextInt();

        String[] studentNames = new String[numStudents];
        double[][] grades = new double[numStudents][numAssignments];
        double[] averageScores = new double[numStudents];

        for (int i = 0; i < numStudents; i++) {
            scanner.nextLine();
            
            System.out.print("Enter the name of student " + (i + 1) + ": ");
            studentNames[i] = scanner.nextLine();

            double totalScore = 0;
            for (int j = 0; j < numAssignments; j++) {
                System.out.print("Enter score for " + studentNames[i] + "'s assignment " + (j + 1) + ": ");
                grades[i][j] = scanner.nextDouble();
                totalScore += grades[i][j];
            }
            averageScores[i] = totalScore / numAssignments; 
        }

   
        System.out.println("\nStudent Grades:");
        System.out.printf("%-15s", "Name");
        for (int j = 0; j < numAssignments; j++) {
            System.out.printf("%10s", "A" + (j + 1)); 
        }
        System.out.printf("%15s%15s\n", "Average", "Letter Grade");

        for (int i = 0; i < numStudents; i++) {
            System.out.printf("%-15s", studentNames[i]);
            for (int j = 0; j < numAssignments; j++) {
                System.out.printf("%10.2f", grades[i][j]);
            }
            String letterGrade = calculateLetterGrade(averageScores[i]);
            System.out.printf("%15.2f%15s\n", averageScores[i], letterGrade);
        }

     
        double highestAverage = averageScores[0];
        double lowestAverage = averageScores[0];
        String highestScoringStudent = studentNames[0];
        String lowestScoringStudent = studentNames[0];

        for (int i = 1; i < numStudents; i++) {
            if (averageScores[i] > highestAverage) {
                highestAverage = averageScores[i];
                highestScoringStudent = studentNames[i];
            }
            if (averageScores[i] < lowestAverage) {
                lowestAverage = averageScores[i];
                lowestScoringStudent = studentNames[i];
            }
        }

        System.out.println("\nHighest Average: " + highestAverage + " by " + highestScoringStudent);
        System.out.println("Lowest Average: " + lowestAverage + " by " + lowestScoringStudent);

      
        for (int i = 0; i < numStudents - 1; i++) {
            for (int j = 0; j < numStudents - i - 1; j++) {
                if (averageScores[j] < averageScores[j + 1]) {
                   
                    double tempScore = averageScores[j];
                    averageScores[j] = averageScores[j + 1];
                    averageScores[j + 1] = tempScore;

               
                    String tempName = studentNames[j];
                    studentNames[j] = studentNames[j + 1];
                    studentNames[j + 1] = tempName;

                    
                    double[] tempGrades = grades[j];
                    grades[j] = grades[j + 1];
                    grades[j + 1] = tempGrades;
                }
            }
        }

      
        System.out.println("\nSorted Students by Average Score:");
        System.out.printf("%-15s%15s\n", "Name", "Average Score");
        for (int i = 0; i < numStudents; i++) {
            System.out.printf("%-15s%15.2f\n", studentNames[i], averageScores[i]);
        }

        scanner.close();
    }
}
