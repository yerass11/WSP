import kz.kbtu.oop.projectv2.users.User;
import kz.kbtu.oop.projectv2.users.employees.Admin;
import kz.kbtu.oop.projectv2.users.employees.Teacher;
import kz.kbtu.oop.projectv2.users.students.Student;
import kz.kbtu.oop.projectv2.users.students.UndergraduateStudent;
import org.junit.jupiter.api.Test;

public class MessageTests {
    @Test
    void msgTest() {
        Admin admin = new Admin();
        admin.createUser(new UndergraduateStudent("stud1", "b", "c", "d"));
        admin.createUser(new Teacher("teacher1", "b", "c"));

        User s = User.findUser("stud1");

        s.sendMessage("teacher1", "Hello, World!");

    }
}
