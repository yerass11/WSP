import kz.kbtu.oop.projectv2.users.employees.Admin;
import kz.kbtu.oop.projectv2.users.employees.Teacher;
import kz.kbtu.oop.projectv2.users.students.PhDStudent;
import org.junit.jupiter.api.Test;

public class AdminTests {
    @Test
    void adminUnitTests() {
        Admin admin = new Admin();
        Teacher t1 = (Teacher) admin.createUser(new Teacher());

        //admin.createUser(new PhDStudent("a", "b", "c", "d", "e"));
    }
}
