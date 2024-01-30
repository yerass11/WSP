package kz.kbtu.oop.projectv2.users.employees;

import java.util.HashSet;
import java.util.Set;

public class TechSupportOrder {
    private static final Set<TechSupportOrder> techSupportOrderRegistry = new HashSet<>();

    private String orderId;
    private String description;
    private boolean isNew;
    private boolean isAccepted;
    private boolean isDone;
    // Tech support order-specific methods


    public TechSupportOrder(String orderId, String description, boolean isNew, boolean isAccepted, boolean isDone) {
        this.orderId = orderId;
        this.description = description;
        this.isNew = isNew;
        this.isAccepted = isAccepted;
        this.isDone = isDone;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public static void addRegistry(TechSupportOrder techSupportOrder) {
        techSupportOrderRegistry.add(techSupportOrder);
    }

    public static TechSupportOrder findRegistry(String orderId) {
        for (TechSupportOrder techSupportOrder : techSupportOrderRegistry) {
            if (techSupportOrder.getOrderId().equals(orderId)) {
                return techSupportOrder;
            }
        }
        return null;
    }

    public static void removeRegistry(TechSupportOrder techSupportOrder) {
        techSupportOrderRegistry.remove(techSupportOrder);
    }
}