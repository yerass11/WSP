import kz.kbtu.oop.projectv2.courses.Course;
import kz.kbtu.oop.projectv2.courses.TypeOfMark;
import kz.kbtu.oop.projectv2.users.employees.Teacher;
import kz.kbtu.oop.projectv2.users.students.UndergraduateStudent;
import org.junit.jupiter.api.Test;

public class CoursesTest {
    @Test
    void coursesUnitTests() {
        Teacher teacher1 = new Teacher("6B0302", "Mustafin Timur", "MCM");
        Teacher teacher2 = new Teacher("6B0303", "Alimzhan Amanov", "FIT");

        UndergraduateStudent student1 = new UndergraduateStudent("22B030286", "Saiman Yerassyl", "y_saiman@kbtu.kz", "qwerty");
        UndergraduateStudent student2 = new UndergraduateStudent("21B014322", "Mazhitov Nurdaulet", "n_mazhitov@kbtu.kz", "asdfgh");
        UndergraduateStudent student3 = new UndergraduateStudent("22B013642", "Bob Alice", "b_alice@kbtu.kz", "asdfghsfa");
        UndergraduateStudent student4 = new UndergraduateStudent("22B023764", "Alina Kie", "a_kie@kbtu.kz", "fdafadfd");
        UndergraduateStudent student5 = new UndergraduateStudent("23B071484", "Kamila Kuan", "k_kuan@kbtu.kz", "kamaku");

        Course mathCourse = new Course("MATH1102", "Calculus");
        mathCourse.addInstructor(teacher1);
        mathCourse.addStudent(student1);
        mathCourse.addStudent(student2);

        mathCourse.addStudent(student3);

        mathCourse.addStudent(student4);

        mathCourse.addStudent(student5);
        mathCourse.setCredits(4);

        Course csCourse = new Course("CSCI2105", "Algorithms and Data Structures");
        csCourse.addInstructor(teacher2);
        csCourse.addStudent(student1);
        csCourse.addStudent(student2);
        csCourse.addStudent(student3);
        csCourse.addStudent(student4);
        csCourse.addStudent(student5);
        csCourse.setCredits(3);

        // Отображаем информацию о курсах
        System.out.println("Math Course Information:");
        System.out.println(mathCourse);

        System.out.println("\ncs Course Information:");
        System.out.println(csCourse);

        // Добавляем оценки для студентов
        mathCourse.putMark(student1, 28, TypeOfMark.FIRST_ATTESTATION);
        mathCourse.putMark(student1, 31, TypeOfMark.SECOND_ATTESTATION);
        mathCourse.putMark(student1, 40, TypeOfMark.FINAL);

        mathCourse.putMark(student2, 24, TypeOfMark.FIRST_ATTESTATION);
        mathCourse.putMark(student2, 36, TypeOfMark.SECOND_ATTESTATION);
        mathCourse.putMark(student2, 40, TypeOfMark.FINAL);

        mathCourse.putMark(student3, 0, TypeOfMark.FIRST_ATTESTATION);
        mathCourse.putMark(student3, 30, TypeOfMark.SECOND_ATTESTATION);
        mathCourse.putMark(student3, 40, TypeOfMark.FINAL);

        mathCourse.putMark(student4, 0, TypeOfMark.FIRST_ATTESTATION);
        mathCourse.putMark(student4, 28, TypeOfMark.SECOND_ATTESTATION);
        mathCourse.putMark(student4, 0, TypeOfMark.FINAL);

        mathCourse.putMark(student5, 10, TypeOfMark.FIRST_ATTESTATION);
        mathCourse.putMark(student5, 26, TypeOfMark.SECOND_ATTESTATION);
        mathCourse.putMark(student5, 26, TypeOfMark.FINAL);

        // Отображаем оценки студентов
        System.out.println("\nMath Course Marks:");
        mathCourse.getMarks().forEach((student, mark) -> System.out.println(student.getFullname() + ": " + mark));

        System.out.println("\nComputer Science Course Marks:");
        csCourse.getMarks().forEach((student, mark) -> System.out.println(student.getFullname() + ": " + mark));

        System.out.println("\nMath Course average GPA:");
        System.out.println(mathCourse.calculateAverageGpa());

        System.out.println("\nComputer Science Course average GPA:");
        System.out.println(csCourse.calculateAverageGpa());

    }

}
