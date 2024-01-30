package kz.kbtu.oop.projectv2.users.students;

import kz.kbtu.oop.projectv2.courses.Course;
import kz.kbtu.oop.projectv2.courses.Transcript;
import kz.kbtu.oop.projectv2.enums.UrgencyLevel;
import kz.kbtu.oop.projectv2.users.User;
import kz.kbtu.oop.projectv2.users.employees.Teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Student extends User {
    private String studentId;
    private String department;
    private List<Course> enrolledCourses;
    private Map<Teacher, UrgencyLevel> complaints;


    {
        this.enrolledCourses = new ArrayList<>();
        this.complaints = new HashMap<>();
    }

    public Student() {
    }

    public Student(String id, String fullname, String email, String password) {
        super(id, fullname, email, password);
    }

    public Student(String id, String fullname, String email, String password, List<Course> enrolledCourses) {
        super(id, fullname, email, password);
    }


    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void enrollCourse(Course course) {
        enrolledCourses.add(course);
    }

    public Transcript getTranscript() {
        return null;
    }

    public Map<Teacher, UrgencyLevel> getComplaints() {
        return complaints;
    }

    public void addComplaints(Teacher teacher, UrgencyLevel urgencyLevel) {
        this.complaints.put(teacher, urgencyLevel);
    }

    public double getGPA() {
        return 0;
    }
    public String getDepartment() {
        return "";
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", department='" + department + '\'' +
                //", enrolledCourses=" + enrolledCourses +
                ", complaints=" + complaints +
                "} " + super.toString();
    }
}
