import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ShowText {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        try {
            System.out.println("Enter 5 elements:");
            for (int i = 0; i < 5; i++) {
                System.out.print("Element " + (i + 1) + ": ");
                list.add(input.nextLine());
            }

            // File path Desktop/lab11
            String filePath = System.getProperty("user.home") + "/Desktop/OOP Lab/Items.txt";
            File file = new File(filePath);

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (String item : list) {
                writer.write(item);
                writer.newLine();
            }
            writer.close();
            System.out.println("\nData written to file successfully.");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            System.out.println("\nItems read from file:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
            if (file.delete()) {
                System.out.println("\nFile deleted successfully.");
            } else {
                System.out.println("\nFile could not be deleted.");
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        input.close();
    }
}