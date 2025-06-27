package pl.coderslab;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class TaskManager {

    public static void main(String[] args) {
        String fileName = "tasks.csv";
        String[] options = {"add", "remove", "list", "exit"};
        displayOptions(options);
        String[][] tasks;

        try {
            tasks = tasks(fileName);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }


    public static String[][] tasks(String fileName) throws IOException {
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
            System.out.println("File " + fileName + " not found.");
            return null;
        }
    }


    public static void displayOptions(String[] options) {
        System.out.println(ConsoleColors.BLUE + "Please select an option:");
        for (String option : options) {
            System.out.println(ConsoleColors.RESET + option);
        }
    }


    public static void displayTasks(String[][] tasks) {
        System.out.println("list");
        for (int i = 0; i < tasks.length; i++) {
            System.out.println(i + " : " + String.join(" ", tasks[i]));
        }
    }


    public static String[][] addTask(String[][] tasks) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add");
        System.out.println("Please add task description. ");
        String description = scanner.nextLine();
        System.out.println("Please add task due date (in format YYYY-MM-DD). ");
        String dueDate = scanner.nextLine();
        System.out.println("Is your task important: true/false? ");
        String isImportant = scanner.nextLine();
        tasks = Arrays.copyOf(tasks, tasks.length + 1);
        tasks[tasks.length - 1] = new String[3];
        tasks[tasks.length - 1][0] = description;
        tasks[tasks.length - 1][1] = dueDate;
        tasks[tasks.length - 1][2] = isImportant;
        return tasks;
    }


    public static String[][] removeTask(String[][] tasks) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("remove");
        System.out.println("Please select number to remove. ");
        String number = scanner.nextLine();
        while (!StringUtils.isNumeric(number)) {
            System.out.println("Incorrect argument passed. Please give number greater or equal 0. ");
            number = scanner.nextLine();
        }
        try {
            tasks = ArrayUtils.remove(tasks, Integer.parseInt(number));
            System.out.println("Value was successfully deleted.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Argument out of bounds.");
        }
        return tasks;
    }


    public static void exitProgram(String[][] tasks, String fileName) {
        System.out.println("exit");
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            if (tasks != null) {
                for (String[] task : tasks) {
                    fileWriter.append(String.join(",", task));
                }
            } else {
                System.out.println("You're saving an empty file.");
            }
            System.out.println(ConsoleColors.RED + "Bye, bye.");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }


    public static void getAction(String[][] tasks, String fileName) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        switch (input) {
            case "add":
                addTask(tasks);
                break;
            case "remove":
                removeTask(tasks);
                break;
            case "list":
                displayTasks(tasks);
                break;
            case "exit":
                exitProgram(tasks, fileName);
                break;
            default:
                System.out.println("Please select a correct option.");
                break;
        }

    }
}
