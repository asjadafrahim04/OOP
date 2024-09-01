/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Chapter7;

/**
 *
 * @author HP
 */
// Fig. 7.18: GradeBook2.java
import java.util.Locale;

public class GradeBook2 {

    private String courseName;
    private int[][] grades;

    // Constructor that initializes courseName and grades array
    public GradeBook2(String courseName, int[][] grades) {
        this.courseName = courseName;
        this.grades = grades;
    }

    // Setter for courseName
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    // Getter for courseName
    public String getCourseName() {
        return courseName;
    }

    // Method to process and display grades
    public void processGrades() {
        outputGrades();
        System.out.printf("%n%s %d%n%s %d%n%n",
                "Lowest grade in the grade book is", getMinimum(),
                "Highest grade in the grade book is", getMaximum());
        outputBarChart();
    }

    // Method to find the minimum grade
    public int getMinimum() {
        int lowGrade = grades[0][0];

        // Loop through grades array to find the lowest grade
        for (int[] studentGrades : grades) {
            for (int grade : studentGrades) {
                if (grade < lowGrade) {
                    lowGrade = grade;
                }
            }
        }
        return lowGrade;
    }

    // Method to find the maximum grade
    public int getMaximum() {
        int highGrade = grades[0][0];

        // Loop through grades array to find the highest grade
        for (int[] studentGrades : grades) {
            for (int grade : studentGrades) {
                if (grade > highGrade) {
                    highGrade = grade;
                }
            }
        }
        return highGrade;
    }

    // Method to calculate the average of a set of grades
    public double getAverage(int[] setOfGrades) {
        int total = 0;

        // Calculate the sum of the grades
        for (int grade : setOfGrades) {
            total += grade;
        }
        // Return the average
        return (double) total / setOfGrades.length;
    }

    // Method to output a bar chart of grade distribution
    public void outputBarChart() {
        System.out.println("Overall grade distribution:");

        // Array to store frequency of grades in each range of 10 grades
        int[] frequency = new int[11];

        // Calculate frequency of each grade range
        for (int[] studentGrades : grades) {
            for (int grade : studentGrades) {
                ++frequency[grade / 10];
            }
        }

        // Output each grade range's bar in the chart
        for (int count = 0; count < frequency.length; count++) {
            if (count == 10) {
                System.out.printf("%5d: ", 100);  // Special case for 100
            } else {
                System.out.printf("%02d-%02d: ", count * 10, count * 10 + 9);
            }

            for (int stars = 0; stars < frequency[count]; stars++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // Method to output the grades array and the average for each student
    public void outputGrades() {
        System.out.printf("The grades are:%n%n");
        System.out.print("            ");

        // Output column headers for the tests
        for (int test = 0; test < grades[0].length; test++) {
            System.out.printf("Test %d  ", test + 1);
        }
        System.out.println("Average");

        // Output the grades and averages for each student
        for (int student = 0; student < grades.length; student++) {
            System.out.printf("Student %2d", student + 1);

            for (int test : grades[student]) {
                System.out.printf("%8d", test);
            }

            double average = getAverage(grades[student]);
            System.out.printf(Locale.US, "%9.2f%n", average);
        }
    }
}
