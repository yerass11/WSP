package kz.kbtu.oop.projectv2.users.employees;

import kz.kbtu.oop.projectv2.users.User;

public abstract class Employee extends User {
    private String department;

    public Employee() {
    }

    public Employee(String id, String fullname, String department) {
        super(id, fullname);
        this.department = department;
    }

    public Employee(String id, String fullname, String email, String password, String department) {
        super(id, fullname, email, password);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    void setDepartment(String department) {
        this.department = department;
    }
}
