package kz.kbtu.oop.projectv2.courses;

import kz.kbtu.oop.projectv2.users.employees.Teacher;
import kz.kbtu.oop.projectv2.users.students.UndergraduateStudent;
import org.junit.jupiter.api.Test;

public class MyTest {
    @Test
    void T() {
        Teacher teacher1 = new Teacher("6B0302", "Atshushi", "MCM");
        UndergraduateStudent student1 = new UndergraduateStudent("22B030286", "Pakita", "y_saiman@kbtu.kz", "qwerty");
        Course course = new Course("aboba", "Research methods");

        course.addInstructor(teacher1);
        course.addStudent(student1);
        course.setCredits(4);

        course.putMark(student1, 17.5, TypeOfMark.FIRST_ATTESTATION);
        course.putMark(student1, 16.5, TypeOfMark.SECOND_ATTESTATION);
        course.putMark(student1, 0, TypeOfMark.FINAL);

        System.out.println("\nResearch Methods Info");
        course.getMarks().forEach((student, mark) -> System.out.println(student.getFullname() + ": " + mark));

        System.out.println(student1);

    }
}
