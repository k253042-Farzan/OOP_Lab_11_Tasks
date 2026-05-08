import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentRegistration {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Enter Student Full Name: ");
            String name = input.nextLine();
            System.out.print("Enter Student ID: ");
            String id = input.nextLine();
            String fileName = name.replaceAll(" ", "_") + ".txt";
            File file = new File(fileName);

            ArrayList<String> courses = new ArrayList<>();
            int totalCredits = 0;
            final int MAX_CREDITS = 15;

            System.out.print("Enter PF Theory Marks: ");
            int pfTheory = input.nextInt();
            System.out.print("Enter PF Lab Marks: ");
            int pfLab = input.nextInt();
            input.nextLine();

            if (pfTheory >= 50 && pfLab >= 50) {
                courses.add("OOP Theory");
                courses.add("OOP Lab");
                totalCredits += 6;
                System.out.println("OOP Theory and OOP Lab registered.");
            } else {
                System.out.println("Student is not eligible for OOP courses.");
            }

            while (totalCredits < MAX_CREDITS) {
                System.out.print("Enter 'course name' or 'done' to finish: ");
                String course = input.nextLine();
                if (course.equalsIgnoreCase("done")) {
                    break;
                }

                if (courses.contains(course)) {
                    System.out.println("Course already added.");
                    continue;
                }

                if (totalCredits + 3 <= MAX_CREDITS) {
                    courses.add(course);
                    totalCredits += 3;
                } else {
                    System.out.println("Cannot exceed 15 credit hours.");
                    break;
                }
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write("Student Name: " + name);
            writer.newLine();

            writer.write("Student ID: " + id);
            writer.newLine();

            writer.write("Registered Courses:");
            writer.newLine();

            for (String course : courses) {
                writer.write(course);
                writer.newLine();
            }

            writer.write("Total Credit Hours: " + totalCredits);
            writer.newLine();
            writer.close();

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            System.out.println("\n--- File Content ---");

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        input.close();
    }
}