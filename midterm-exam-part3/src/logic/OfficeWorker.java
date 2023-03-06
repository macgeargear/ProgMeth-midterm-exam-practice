package logic;

public class OfficeWorker extends Employee {
    private String department;

    public OfficeWorker(String name, int id, String department) {
        super(name, id, 30);
        this.setDepartment(department);
    }

    @Override
    public int computeSalary() {
        return BackEndAPI.calculateMonthlySalary(this.getBaseSalary(), bonus, 20);
    }

    @Override
    String getDescription() {
        return BackEndAPI.getOfficeWorkerDescription(id, name, department, bonus);
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

}
