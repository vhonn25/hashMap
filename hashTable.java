package activity4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class hashTable {
    private HashMap<String, Student> students;
    private Scanner scanner;

    public hashTable() {
        this.students = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    public void addStudent() {
        System.out.print("\nEnter student's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student's ID number: ");
        String id = scanner.nextLine();
        System.out.print("Enter student's course: ");
        String course = scanner.nextLine();

        Student student = new Student(name, id, course);
        students.put(id, student);

        System.out.println("\nStudent added to the directory.\n");
    }

    public void searchStudent() {
        System.out.print("\nEnter student's ID number to search: ");
        String id = scanner.nextLine();

        if (students.containsKey(id)) {
            Student student = students.get(id);
            System.out.println("\nStudent found:");
            System.out.println("Name: " + student.getName());
            System.out.println("ID: " + student.getId());
            System.out.println("Course: " + student.getCourse());
        } else {
        	System.out.println("\n+----------------------------+");
            System.out.println("|      NO STUDENT FOUND      |");
        	System.out.println("+----------------------------+");
        }
    }

    public void deleteStudent() {
        System.out.print("\nEnter student's ID number to delete: ");
        String id = scanner.nextLine();

        if (students.containsKey(id)) {
            students.remove(id);
            System.out.println("Student deleted from the directory.\n");
        } else {
        	System.out.println("\n+----------------------------+");
            System.out.println("|      NO STUDENT FOUND      |");
        	System.out.println("+----------------------------+");
        }
    }

    public void displayStudentRecords() {
        if (students.isEmpty()) {
        	System.out.println("\n+----------------------------+");
            System.out.println("|  NO STUDENT RECORDS FOUND  |");
        	System.out.println("+----------------------------+");

        } else {
        	System.out.println("\n+----------------------------------------------------------------------------------------+");
            System.out.println("|                                    STUDENT RECORDS MENU                                |");
            System.out.println("+----------------------------------------------------------------------------------------+");
            System.out.println("|              Name              |             ID            |          Course           |");
            System.out.println("+--------------------------------+---------------------------+---------------------------+");
            
            for (Map.Entry<String, Student> entry : students.entrySet()) {
                Student student = entry.getValue();
                System.out.printf("| %-30s | %-25s | %-25s |\n", student.getName(), student.getId(), student.getCourse());
            }
            System.out.println("+--------------------------------+---------------------------+---------------------------+");
        }
    }



    public static void main(String[] args) {
        hashTable directory = new hashTable();

        int choice;
        do {
            System.out.println("\n+------------------------------+");
            System.out.println("|      STUDENT DIRECTORY       |");
            System.out.println("+------------------------------+");
            System.out.println("| [1] Add Student              |");
            System.out.println("| [2] Search Student           |");
            System.out.println("| [3] Delete Student           |");
            System.out.println("| [4] Display Student Record   |");
            System.out.println("| [5] Exit                     |");
            System.out.println("+------------------------------+\n");

            System.out.print("Your choice: ");

            // Check if the input is an integer
            if (directory.scanner.hasNextInt()) {
                choice = directory.scanner.nextInt();
                directory.scanner.nextLine(); // Consume the newline character

                // Check if the choice is within the valid range
                if (choice >= 1 && choice <= 5) {
                    switch (choice) {
                        case 1:
                            directory.addStudent();
                            break;
                        case 2:
                            directory.searchStudent();
                            break;
                        case 3:
                            directory.deleteStudent();
                            break;
                        case 4:
                            directory.displayStudentRecords();
                            break;
                        case 5:
                            System.out.println("Exiting...");
                            break;
                    }
                } else {
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                directory.scanner.nextLine(); // Consume the invalid input
                choice = 0; // Set choice to 0 to continue the loop
            }
        } while (choice != 5);
    }

class Student {
    private String name;
    private String id;
    private String course;

    public Student(String name, String id, String course) {
        this.name = name;
        this.id = id;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getCourse() {
        return course;
    }
}
}
