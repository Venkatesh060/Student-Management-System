package app;

import service.StudentService;
import java.util.*;
import java.sql.Date;

public class MainApp {
    static Scanner sc = new Scanner(System.in);
    static StudentService s = new StudentService();

    static Date d() {
        System.out.print("yyyy mm dd: ");
        int y = sc.nextInt();
        int m = sc.nextInt();
        int da = sc.nextInt();
        return Date.valueOf(y+"-"+m+"-"+da);
    }

    public static void main(String[] args) throws Exception {
        while (true) {
            System.out.println("\n============================");
            System.out.println("  Student Management System ");
            System.out.println("============================");
            System.out.println("1. Add Part-Time Student");
            System.out.println("2. Add Full-Time Student");
            System.out.println("3. Remove Student");
            System.out.println("4. View Student Details");
            System.out.println("5. View All Students");
            System.out.println("6. Sort Students by Date of Joining");
            System.out.println("7. Sort Students by ID");
            System.out.println("8. Sort Students by First Name");
            System.out.println("9. Exit");
            System.out.print("\nEnter your choice: ");

            int c;
            try {
                c = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 9.");
                sc.nextLine(); // Clear the invalid input
                continue;
            }

            switch (c) {
                case 1:
                    System.out.print("Enter Student ID and First Name: ");
                    try {
                        int id = sc.nextInt();
                        String firstName = sc.next();
                        Date doj = d();
                        s.addP(id, firstName, doj);
                        System.out.println("Part-Time Student added successfully.");
                    } catch (Exception e) {
                        System.out.println("Error adding Part-Time Student. Please try again.");
                        sc.nextLine(); // Clear the invalid input
                    }
                    break;
                case 2:
                    System.out.print("Enter Student ID and First Name: ");
                    try {
                        int id = sc.nextInt();
                        String firstName = sc.next();
                        Date doj = d();
                        s.addF(id, firstName, doj);
                        System.out.println("Full-Time Student added successfully.");
                    } catch (Exception e) {
                        System.out.println("Error adding Full-Time Student. Please try again.");
                        sc.nextLine(); // Clear the invalid input
                    }
                    break;
                case 3:
                    System.out.print("Enter Student ID to remove: ");
                    try {
                        int id = sc.nextInt();
                        s.remove(id);
                        System.out.println("Student removed successfully.");
                    } catch (Exception e) {
                        System.out.println("Error removing Student. Please try again.");
                        sc.nextLine(); // Clear the invalid input
                    }
                    break;
                case 4:
                    System.out.print("Enter Student ID to view details: ");
                    try {
                        int id = sc.nextInt();
                        s.view(id);
                    } catch (Exception e) {
                        System.out.println("Error viewing Student details. Please try again.");
                        sc.nextLine(); // Clear the invalid input
                    }
                    break;
                case 5:
                    System.out.println("List of all students:");
                    s.viewAll();
                    break;
                case 6:
                    System.out.println("Sorting students by Date of Joining...");
                    s.sortByDoj();
                    break;
                case 7:
                    System.out.println("Sorting students by ID...");
                    s.sortById();
                    break;
                case 8:
                    System.out.println("Sorting students by First Name...");
                    s.sortByFn();
                    break;
                case 9:
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a number between 1 and 9.");
            }
        }
    }
}
