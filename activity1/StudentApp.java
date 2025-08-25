// filepath: c:\Users\Kent Louie Gabriel\Desktop\activity1\src\main\java\activity1\StudentApp.java
package activity1;

import java.util.Scanner;

public class StudentApp {
    private StudentManager studentManager;
    private LogInPage logInPage;

    public StudentApp() {
        this.studentManager = new StudentManager();
        this.logInPage = new LogInPage();
    }
    public void run() {
        Scanner sc = new Scanner(System.in);

        while (true) { // Loop for login/register and student menu
            boolean loggedIn = false;

            // Login/Register loop
            while (!loggedIn) {
                System.out.println("[1] Register");
                System.out.println("[2] Login");
                System.out.println("[0] Exit");
                System.out.print("Choose: ");
                int choice = sc.nextInt();
                sc.nextLine();

                if (choice == 1) {
                    System.out.print("Enter username: ");
                    String user = sc.nextLine();
                    System.out.print("Enter password: ");
                    String pass = sc.nextLine();
                    logInPage.register(user, pass);
                } else if (choice == 2) {
                    if (!logInPage.hasAccounts()) {
                        System.out.println("No accounts registered. Please register first.");
                        continue;
                    }
                    System.out.print("Enter username: ");
                    String user = sc.nextLine();
                    System.out.print("Enter password: ");
                    String pass = sc.nextLine();
                    if (logInPage.logIn(user, pass)) {
                        System.out.println("Login successful!");
                        loggedIn = true;
                    } else {
                        System.out.println("Invalid credentials.");
                    }
                } else if (choice == 0) {
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                } else {
                    System.out.println("Invalid option.");
                }
            }

            // Student Management Menu
            int choice;
            do {
                System.out.println("\n=== Student Management System ===");
                System.out.println("[1] Add Student");
                System.out.println("[2] View Students");
                System.out.println("[3] Update Student");
                System.out.println("[4] Delete Student");
                System.out.println("[5] Search Student");
                System.out.println("[6] Show Total User");
                System.out.println("[0] Logout");
                System.out.print("Choose an option: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        sc.nextLine();
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Age: ");
                        int age = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Course: ");
                        String course = sc.nextLine();
                        studentManager.addStudent(name, age, course);
                        break;
                    case 2:
                        studentManager.viewStudents();
                        break;
                    case 3:
                        System.out.print("Enter Student ID to update: ");
                        int uid = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter New Name: ");
                        String newName = sc.nextLine();
                        System.out.print("Enter New Age: ");
                        int newAge = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter New Course: ");
                        String newCourse = sc.nextLine();
                        studentManager.updateStudent(uid, newName, newAge, newCourse);

                        System.out.print("Do you want to update grade? (y/n): ");
                        String gAns = sc.next();
                        if (gAns.equalsIgnoreCase("y")) {
                            System.out.print("Enter new grade: ");
                            double grade = sc.nextDouble();
                            studentManager.updateGrade(uid, grade);
                        }
                        System.out.print("Do you want to update attendance? (y/n): ");
                        String aAns = sc.next();
                        if (aAns.equalsIgnoreCase("y")) {
                            System.out.print("Enter new attendance: ");
                            int attendance = sc.nextInt();
                            studentManager.updateAttendance(uid, attendance);
                        }
                        break;
                    case 4:
                        System.out.print("Enter Student ID to delete: ");
                        int did = sc.nextInt();
                        studentManager.deleteStudent(did);
                        break;
                    case 5:
                        System.out.print("Enter ID to Search: ");
                        int id = sc.nextInt();
                        studentManager.searchStudent(id);
                        break;
                    case 6:
                        studentManager.totalUser();
                        break;
                    case 0:
                        System.out.println("Logging out...");
                        break;
                    default:
                        System.out.println("Invalid option!");
                }
            } while (choice != 0);
        }
    }

}