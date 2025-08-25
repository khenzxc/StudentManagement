package activity1;

import java.util.ArrayList;
import java.io.*;

public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();
    private int id = 1;
    private static final String FILE_NAME = "students.txt";

    public StudentManager() {
        loadStudents();
        // Set id to next available value
        for (Student s : students) {
            if (s.getId() >= id)
                id = s.getId() + 1;
        }
    }

    public void addStudent(String name, int age, String course) {
        Student s = new Student(id++, name, age, course);
        students.add(s);
        saveStudents();
        System.out.println("Student added successfully!");
    }

    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    public void updateStudent(int id, String name, int age, String course) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setName(name);
                s.setAge(age);
                s.setCourse(course);
                saveStudents();
                System.out.println("Student updated successfully!");
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    public void deleteStudent(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                students.remove(s);
                saveStudents();
                System.out.println("Student deleted successfully!");
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    public void searchStudent(int id) {
        for (Student s : students) {
            if (id == s.getId()) {
                System.out.println(s);
                return;
            }
        }
        System.out.println("Student ID not Found");
    }

    public void totalUser() {
        System.out.println("Total Users : " + students.size());
    }

    public void updateGrade(int id, double grade) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setGrade(grade);
                saveStudents();
                System.out.println("Grade updated successfully!");
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    public void updateAttendance(int id, int attendance) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setAttendance(attendance);
                saveStudents();
                System.out.println("Attendance updated successfully!");
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    private void saveStudents() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                writer.write(s.getId() + "," + s.getName() + "," + s.getAge() + "," + s.getCourse()
                        + "," + s.getGrade() + "," + s.getAttendance());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving students: " + e.getMessage());
        }
    }

    private void loadStudents() {
        File file = new File(FILE_NAME);
        if (!file.exists())
            return;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", 6);
                if (parts.length >= 4) {
                    int sid = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    int age = Integer.parseInt(parts[2]);
                    String course = parts[3];
                    Student student = new Student(sid, name, age, course);
                    if (parts.length >= 5)
                        student.setGrade(Double.parseDouble(parts[4]));
                    if (parts.length == 6)
                        student.setAttendance(Integer.parseInt(parts[5]));
                    students.add(student);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading students: " + e.getMessage());
        }
    }
}