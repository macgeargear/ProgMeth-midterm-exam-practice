package logic;

public class Janitor extends Employee {
    private String area;

    public Janitor(String name, int id, String area) {
        super(name, id, 15);
        this.setArea(area);
    }

    @Override
    public int computeSalary() {
        return BackEndAPI.calculateMonthlySalary(baseSalary, bonus, 30);
    }

    @Override
    String getDescription() {
        return BackEndAPI.getJanitorDescription(id, name, area, bonus);
    }


    public String getArea() {
        return this.area;
    }

    public void setArea(String area) {
        this.area = area;
    }

}
