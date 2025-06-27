package pl.coderslab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class TaskManager {

    public static void main(String[] args) {
        try {
            readFile("tasks.csv");
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public static void readFile (String fileName) throws IOException {
        Path path = Paths.get(fileName);
        if (Files.exists(path)) {
            String fileContent = Files.readString(path);
            String[] rows = fileContent.split("\n");
            int columnsNum = rows[0].split(",").length;
            String[][] tasks = new String[rows.length][columnsNum];
            for (int i = 0; i < rows.length; i++) {
                tasks[i] = rows[i].split(",");
            }
        } else {
            System.out.println("File " + fileName + " not found");
        }
    }
}
