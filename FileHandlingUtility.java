import java.io.*;
import java.util.Scanner;

/**
 * FileHandlingUtility
 * A simple Java program to demonstrate reading, writing, and modifying text files.
 * Author: [Your Name]
 * Date: [Today's Date]
 */
public class FileHandlingUtility {

    // Method to write content to a file
    public static void writeFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            System.out.println("✅ File written successfully.");
        } catch (IOException e) {
            System.out.println("❌ Error writing file: " + e.getMessage());
        }
    }

    // Method to read and display file content
    public static void readFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            System.out.println("📄 File Content:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("   " + line);
            }
        } catch (IOException e) {
            System.out.println("❌ Error reading file: " + e.getMessage());
        }
    }

    // Method to modify file content by replacing a word
    public static void modifyFile(String filePath, String oldWord, String newWord) {
        try {
            // Read original content
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            StringBuilder content = new StringBuilder();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                content.append(line.replaceAll(oldWord, newWord)).append("\n");
            }
            scanner.close();

            // Write modified content back to the file
            FileWriter writer = new FileWriter(file);
            writer.write(content.toString());
            writer.close();

            System.out.println("✏️ File modified successfully (Replaced '" + oldWord + "' with '" + newWord + "').");
        } catch (IOException e) {
            System.out.println("❌ Error modifying file: " + e.getMessage());
        }
    }

    // Main method to demonstrate operations
    public static void main(String[] args) {
        String filePath = "sample.txt";

        // Step 1: Write to file
        writeFile(filePath, "This is a Java File Handling example.\nFile operations are fun to learn!");

        // Step 2: Read the file
        readFile(filePath);

        // Step 3: Modify file (replace a word)
        modifyFile(filePath, "fun", "essential");

        // Step 4: Read again to see changes
        readFile(filePath);
    }
}
