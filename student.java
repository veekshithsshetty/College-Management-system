import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;

    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }
}

class StudentInformationSystem {
    private ArrayList<Student> studentList;

    public StudentInformationSystem() {
        this.studentList = new ArrayList<>();
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void displayAllStudents() {
        System.out.println("Student List:");
        for (Student student : studentList) {
            System.out.println("Roll Number: " + student.getRollNumber() + ", Name: " + student.getName());
        }
    }

    public void removeStudent(int rollNumber) {
        for (Student student : studentList) {
            if (student.getRollNumber() == rollNumber) {
                studentList.remove(student);
                System.out.println("Student with Roll Number " + rollNumber + " removed successfully.");
                return;
            }
        }
        System.out.println("Student with Roll Number " + rollNumber + " not found.");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentInformationSystem sis = new StudentInformationSystem();

        while (true) {
            System.out.println("\n1. Add Student\n2. Display All Students\n3. Remove Student\n4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    scanner.nextLine(); // Consume the newline character
                    String name = scanner.nextLine();
                    System.out.print("Enter roll number: ");
                    int rollNumber = scanner.nextInt();
                    sis.addStudent(new Student(name, rollNumber));
                    break;

                case 2:
                    sis.displayAllStudents();
                    break;

                case 3:
                    System.out.print("Enter roll number to remove: ");
                    int rollToRemove = scanner.nextInt();
                    sis.removeStudent(rollToRemove);
                    break;

                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
