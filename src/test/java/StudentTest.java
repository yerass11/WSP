import kz.kbtu.oop.projectv2.logs.LogsAspect;
import kz.kbtu.oop.projectv2.users.User;
import kz.kbtu.oop.projectv2.users.employees.Employee;
import kz.kbtu.oop.projectv2.users.employees.Teacher;
import kz.kbtu.oop.projectv2.users.students.Student;
import kz.kbtu.oop.projectv2.users.students.UndergraduateStudent;
import org.junit.jupiter.api.Test;

public class StudentTest {
    @Test
    void studentUnitTest() {
        Student s1 = new UndergraduateStudent("22BD030388", "Mazhitov Nurdaulet", "n_mazhitov@kbtu.kz", "12345678");

        User.addUser(s1);
        System.out.println(s1.authenticate("n_mazhitov@kbtu.kz", "1111111"));
        System.out.println(s1.authenticate("n_mazhitov@kbtu.kz", "12345678"));

        System.out.println(User.findUser("22BD030388"));

        Employee t1 = new Teacher("12345TT", "Kalmurzaev", "kalmurzaev@kbtu.kz", "ihatestudents", "basic");
        User.addUser(t1);

        var x = LogsAspect.userLogger;
        System.out.println(x);
    }
}
