// filepath: c:\Users\Kent Louie Gabriel\Desktop\activity1\src\main\java\activity1\Student.java
package activity1;

public class Student {
    private int id;
    private String name;
    private int age;
    private String course;
    private double grade;
    private int attendance;

    public Student(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.grade = 0.0;
        this.attendance = 0;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCourse() {
        return course;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Course: " + course +
                ", Grade: " + grade + ", Attendance: " + attendance;
    }
}