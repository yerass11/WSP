package kz.kbtu.oop.projectv2.courses;

import kz.kbtu.oop.projectv2.courses.Course;
import kz.kbtu.oop.projectv2.courses.Mark;
import kz.kbtu.oop.projectv2.users.students.Student;

import java.util.Map;

public class Transcript {
    private Student student;
    Map<Course, Mark> courseMarks;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Map<Course, Mark> getCourseMarks() {
        return courseMarks;
    }

    public void addCourseMarks(Course course, Mark courseMark) {
        this.courseMarks.put(course, courseMark);
    }
}
