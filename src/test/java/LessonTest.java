import kz.kbtu.oop.projectv2.courses.Course;
import kz.kbtu.oop.projectv2.enums.LessonType;
import kz.kbtu.oop.projectv2.users.employees.Teacher;
import kz.kbtu.oop.projectv2.users.students.UndergraduateStudent;
import org.junit.jupiter.api.Test;
import kz.kbtu.oop.projectv2.courses.Lesson;
public class LessonTest {
    @Test
    void LessonUnitTest() {
        Teacher teacher1 = new Teacher("6B0302", "Mustafin Timur", "MCM");
        Teacher teacher2 = new Teacher("6B0303", "Alimzhan Amanov", "FIT");
        Teacher teacher3 = new Teacher("6B0304", "Pakizar Shamoi", "FIT");

        UndergraduateStudent student1 = new UndergraduateStudent("22B030286", "Saiman Yerassyl", "y_saiman@kbtu.kz", "qwerty");
        UndergraduateStudent student2 = new UndergraduateStudent("21B014322", "Mazhitov Nurdaulet", "n_mazhitov@kbtu.kz", "asdfgh");
        UndergraduateStudent student3 = new UndergraduateStudent("22B013642", "Bob Alice", "b_alice@kbtu.kz", "asdfghsfa");
        UndergraduateStudent student4 = new UndergraduateStudent("22B023764", "Alina Kie", "a_kie@kbtu.kz", "fdafadfd");
        UndergraduateStudent student5 = new UndergraduateStudent("23B071484", "Kamila Kuan", "k_kuan@kbtu.kz", "kamaku");

        Course calc = new Course("MATH1102", "Calculus");
        calc.addInstructor(teacher1);
        calc.addStudent(student1);
        calc.addStudent(student3);
        calc.addStudent(student5);
        calc.setCredits(4);

        Course algo = new Course("CSCI2105", "Algorithms and Data Structures");
        algo.addInstructor(teacher2);
        algo.addStudent(student2);
        algo.setCredits(3);

        Course oop = new Course("CSCI2106", "Object-Oriented Programming");
        oop.addInstructor(teacher3);
        oop.addStudent(student4);
        oop.setCredits(3);


        Lesson L13 = new Lesson(oop, LessonType.LECTURE, 444);
        Lesson P12 = new Lesson(algo, LessonType.PRACTICE, 262);

        System.out.println(L13);
        System.out.println(P12);
    }
}
