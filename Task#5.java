import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FilePermissions {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            File file = new File("Confidential.txt");

            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }

            System.out.print("Enter Designation (Faculty / Student): ");
            String designation = input.nextLine();
            file.setReadable(false, false);
            file.setWritable(false, false);
            file.setExecutable(false, false);
            if (designation.equalsIgnoreCase("Faculty")) {
                file.setReadable(true, true);
                file.setWritable(true, true);
                file.setExecutable(true, true);
            }
            else if (designation.equalsIgnoreCase("Student")) {
                file.setReadable(true, true);
            }
            else {
                System.out.println("Invalid Designation.");
                return;
            }

            System.out.println("\nAccess Rights Status:");
            System.out.println("Readable   : " + file.canRead());
            System.out.println("Writable   : " + file.canWrite());
            System.out.println("Executable : " + file.canExecute());

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        input.close();
    }
}