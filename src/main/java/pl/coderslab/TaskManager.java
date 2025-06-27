package pl.coderslab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

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
            int columnsNum = 3;
            String[] rows = fileContent.split("\n");
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


    public static String[][] addTask (String[][] tasks) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add");
        System.out.println("Please add task description");
        String description = scanner.nextLine();
        System.out.println("Please add task due date (in format YYYY-MM-DD)");
        String dueDate = scanner.nextLine();
        System.out.println("Is your task important: true/false");
        String isImportant = scanner.nextLine();
        tasks = Arrays.copyOf(tasks, tasks.length + 1);
        tasks[tasks.length - 1] = new String[3];
        tasks[tasks.length - 1][0] = description;
        tasks[tasks.length - 1][1] = dueDate;
        tasks[tasks.length - 1][2] = isImportant;
        return tasks;
    }
}
