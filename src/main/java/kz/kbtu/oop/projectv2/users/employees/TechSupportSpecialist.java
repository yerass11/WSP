package kz.kbtu.oop.projectv2.users.employees;

import java.util.List;

public class TechSupportSpecialist extends Employee {
    public List<TechSupportOrder> getOrders() {
        return null;
    }

    public void acceptOrder(TechSupportOrder order) {
        order.setAccepted(true);
    }

    void rejectOrder(TechSupportOrder order) {
        order.setAccepted(false);
    }
}
