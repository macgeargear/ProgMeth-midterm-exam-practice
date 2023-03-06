package logic;

public abstract class Employee {
    protected String name;
    protected int id;
    protected int baseSalary;
    protected int bonus;

    public Employee(String name, int id, int baseSalary) {
        this.setName(name);
        this.setId(id);
        this.setBaseSalary(baseSalary);
    }

    abstract public int computeSalary();
    abstract String getDescription();


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBaseSalary() {
        return this.baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = Math.max(0, baseSalary);
    }

    public int getBonus() {
        return this.bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = Math.max(0, bonus);
    }

}
