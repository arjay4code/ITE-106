import java.io.*;
import java.util.*;

public class StudentGradebookV2 {

    public static double calculateAverage(double[] scores) {
        double sum = 0;
        for (double score : scores) {
            sum += score;
        }
        return sum / scores.length;
    }

  
    public static String assignLetterGrade(double average) {
        if (average >= 90) return "A";
        if (average >= 80) return "B";
        if (average >= 70) return "C";
        if (average >= 60) return "D";
        return "F";
    }

   
    public static String formatName(String fullName) {
        String[] nameParts = fullName.split(" ");
        if (nameParts.length == 2) {
            return nameParts[1] + ", " + nameParts[0];
        }
        return fullName;
    }

    public static void main(String[] args) {
        String inputFileName = "student_data.txt";
        String outputFileName = "student_grades_v2.txt";

        try (Scanner scanner = new Scanner(new File(inputFileName));
             PrintWriter writer = new PrintWriter(new FileWriter(outputFileName))) {

     
            writer.printf("%-15s %7s %7s %10s %9s %6s %9s %7s\n", 
                    "Name", "Quiz1", "Quiz2", "Homework", "Midterm", "Final", "Average", "Grade");

         
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");

                if (data.length != 6) {
                    System.out.println("Skipping line due to incorrect format: " + line);
                    continue;
                }

                String name = formatName(data[0].trim());
                double[] scores = new double[5];
                
        
                for (int i = 1; i <= 5; i++) {
                    scores[i - 1] = Double.parseDouble(data[i].trim());
                }

  
                double average = calculateAverage(scores);
                String letterGrade = assignLetterGrade(average);

      
                writer.printf("%-15s %7.0f %7.0f %10.0f %9.0f %6.0f %9.1f %7s\n", 
                        name, scores[0], scores[1], scores[2], scores[3], scores[4], average, letterGrade);
            }

            System.out.println("Processing completed. Output saved to: " + outputFileName);

        } catch (FileNotFoundException e) {
            System.out.println("Error: Input file not found - " + inputFileName);
        } catch (IOException e) {
            System.out.println("Error: Writing to the output file - " + outputFileName);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid score format in the input file.");
        }
    }
}
