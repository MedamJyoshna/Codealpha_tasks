import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> names = new ArrayList<>();
        ArrayList<Double> averages = new ArrayList<>();

        ArrayList<Double> highestMarks = new ArrayList<>();
        ArrayList<Double> lowestMarks = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        if (n <= 0) {
            System.out.println("Number of students must be positive.");
            sc.close();
            return;
        }

        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1));

            System.out.print("Enter student name: ");
            String name = sc.nextLine();

            System.out.print("Enter number of subjects: ");
            int subjects = sc.nextInt();

            if (subjects <= 0) {
                System.out.println("Number of subjects must be positive.");
                sc.close();
                return;
            }

            double sum = 0;
            double highest = Double.NEGATIVE_INFINITY;
            double lowest = Double.POSITIVE_INFINITY;

            for (int j = 1; j <= subjects; j++) {
                System.out.print("Enter marks for subject "
                        + j + " (0-100): ");
                double marks = sc.nextDouble();

                if (marks < 0 || marks > 100) {
                    System.out.println("Invalid marks! Enter 0 to 100.");
                    sc.close();
                    return;
                }

                sum += marks;

                if (marks > highest) {
                    highest = marks;
                }

                if (marks < lowest) {
                    lowest = marks;
                }
            }

            double average = sum / subjects;

            names.add(name);
            averages.add(average);
            highestMarks.add(highest);
            lowestMarks.add(lowest);

            sc.nextLine();
        }

        System.out.println("\n========== STUDENT GRADE REPORT ==========");
        System.out.printf("%-20s %-12s %-12s %-12s%n",
                "Student Name", "Average", "Highest", "Lowest");

        for (int i = 0; i < names.size(); i++) {
            System.out.printf("%-20s %-12.2f %-12.2f %-12.2f%n",
                    names.get(i),
                    averages.get(i),
                    highestMarks.get(i),
                    lowestMarks.get(i));
        }

        sc.close();
    }
}    
