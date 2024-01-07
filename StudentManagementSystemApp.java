import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String grade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + " | Roll Number: " + rollNumber + " | Grade: " + grade;
    }
}

class StudentManagementSystem {
    private ArrayList<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

public class StudentManagementSystemApp {

    public static void main(String[] args) {
        StudentManagementSystem smSystem = new StudentManagementSystem();
        try (Scanner scanner = new Scanner(System.in)) {

            while (true) {

                System.out.println("\nStudent Management System");
                System.out.println("1. Add Student");
                System.out.println("2. Remove Student");
                System.out.println("3. Search for Student");
                System.out.println("4. Display All Students");
                System.out.println("5. Exit");
                System.out.println("Enter your choice: ");

                int choiceSelect = scanner.nextInt();
                scanner.nextLine();

                switch (choiceSelect) {
                    case 1:
                        System.out.print("Enter student name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter roll number: ");
                        int rollNumber = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter grade: ");
                        String grade = scanner.nextLine();

                        Student student = new Student(name, rollNumber, grade);
                        smSystem.addStudent(student);
                        System.out.println("Student added successfully.");
                        break;
                    case 2:
                        System.out.print("Enter roll number of the student to remove: ");
                        int rollToRemove = scanner.nextInt();
                        smSystem.removeStudent(rollToRemove);
                        System.out.println("Student removed successfully.");
                        break;
                    case 3:
                        System.out.print("Enter roll number of the student to search: ");
                        int rollToSearch = scanner.nextInt();
                        Student foundStudent = smSystem.searchStudent(rollToSearch);
                        if (foundStudent != null) {
                            System.out.println("Student found: " + foundStudent);
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;
                    case 4:
                        smSystem.displayAllStudents();
                        break;
                    case 5:
                        System.out.println("Exiting Student Management System. Goodbye!");
                        System.exit(choiceSelect);

                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                        break;

                }
            }
        }

    }

}
