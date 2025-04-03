import java.util.Scanner;
import java.util.ArrayList;

// Encapsulation: Student class with private variables and public methods
class Student {
    private int id;
    private String name;
    private int marks;
    private char grade;

    // Constructor
    public Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.grade = calculateGrade(marks);
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    public char getGrade() {
        return grade;
    }

    // Setter method to update marks and recalculate grade
    public void setMarks(int marks) {
        this.marks = marks;
        this.grade = calculateGrade(marks);
    }

    // Function to calculate grade using ternary operator
    private char calculateGrade(int marks) {
        return (marks >= 90) ? 'A' : (marks >= 80) ? 'B' : (marks >= 70) ? 'C' : (marks >= 60) ? 'D' : 'F';
    }

    // Function to display student details
    public void displayStudent() {
        System.out.println("ID: " + id + ", Name: " + name + ", Marks: " + marks + ", Grade: " + grade);
    }
}

// Main class
public class SMS {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n🎓 Student Management System 🎓");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Marks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateMarks();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again");
            }

        }

    }

    // Function to add a new student
    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Marks: ");
        int marks = scanner.nextInt();

        students.add(new Student(id, name, marks));

        System.out.println("✅ Student Added Successfully!");
    }

    // Function to view all students
    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("⚠ No students found!");
            return;
        }
        System.out.println("\n📋 Student List:");
        for (Student student : students) {
            student.displayStudent();
        }
    }

    // Function to update marks of a student
    private static void updateMarks() {
        System.out.print("Enter Student ID to Update Marks: ");
        int id = scanner.nextInt();

        for (Student student : students) {
            if (student.getId() == id) {
                System.out.print("Enter New Marks: ");
                int newMarks = scanner.nextInt();
                student.setMarks(newMarks);
                System.out.println("✅ Marks Updated Successfully!");
                return;
            }
        }
        System.out.println("⚠ Student Not Found!");
    }

}