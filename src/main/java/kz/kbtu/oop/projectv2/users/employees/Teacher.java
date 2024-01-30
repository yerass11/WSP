package kz.kbtu.oop.projectv2.users.employees;

import kz.kbtu.oop.projectv2.courses.Course;
import kz.kbtu.oop.projectv2.enums.UrgencyLevel;
import kz.kbtu.oop.projectv2.users.students.Student;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Teacher extends Employee {
    private List<Course> courses;

    private List<File> courseFiles;

    {
        courses = new ArrayList<>();
        courseFiles = new ArrayList<>();
    }

    public Teacher() {
    }

    public Teacher(String id, String fullname, String department) {
        super(id, fullname, department);
    }

    public Teacher(String id, String fullname, String email, String password, String department) {
        super(id, fullname, email, password, department);
    }

    public Teacher(String id, String fullname, String email, String password, String department, List<Course> courses) {
        super(id, fullname, email, password, department);
        this.courses = courses;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
    }
    public void sendComplaintAboutStudent(Student student, UrgencyLevel level) {
        student.addComplaints(this, level);
    }

    public void addCourseFile(File f){
        courseFiles.add(f);
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<File> getCourseFiles() {
        return courseFiles;
    }

    public void setCourseFiles(List<File> courseFiles) {
        this.courseFiles = courseFiles;
    }
}
