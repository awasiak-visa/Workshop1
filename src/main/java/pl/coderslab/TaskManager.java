package pl.coderslab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class TaskManager {

    public static void main(String[] args) {
        try {
            String[][] tasks = tasks("tasks.csv");
        } catch (IOException e) {
            throw new RuntimeException();
        }

        String[] options = {"add", "remove", "list", "exit"};
        displayOptions(options);
    }


    public static String[][] tasks (String fileName) throws IOException {
        Path path = Paths.get(fileName);
        if (Files.exists(path)) {
            String fileContent = Files.readString(path);
            String[] rows = fileContent.split("\n");
            int columnsNum = rows[0].split(",").length;
            String[][] tasks = new String[rows.length][columnsNum];
            for (int i = 0; i < rows.length; i++) {
                tasks[i] = rows[i].split(",");
            }
            return tasks;
        } else {
            System.out.println("File " + fileName + " not found");
            return null;
        }
    }


    public static void displayOptions (String[] options) {
        System.out.println(ConsoleColors.BLUE + "Please select an option:");
        for (String option : options) {
            System.out.println(ConsoleColors.RESET + option);
        }
    }


    public static void displayTasks (String[][] tasks) {
        System.out.println("list");
        for (int i = 0; i < tasks.length; i++) {
            System.out.println(i + " : " + String.join(" ", tasks[i]));
        }
    }
}
