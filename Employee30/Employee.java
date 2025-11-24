package Employee30;
import java.util.*;

public abstract class Employee {
    protected String id;
    protected String name;
    protected double baseSalary;

    public Employee(String id, String name, double baseSalary) {
        this.id = id; this.name = name; this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary();

    public String getEmployeeInfo() {
        return String.format("%s(%s) 基础=%.2f 实发=%.2f",
                name, id, baseSalary, calculateSalary());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        return id.equals(((Employee) o).id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}

/* ===== 三种员工 ===== */
class FullTimeEmployee extends Employee {
    private double bonus;
    public FullTimeEmployee(String id, String name, double base, double bonus) {
        super(id, name, base); this.bonus = bonus;
    }
    public double calculateSalary() { return baseSalary + bonus; }
}

class PartTimeEmployee extends Employee {
    private double hourlyRate; // 时薪
    private int hours;         // 工作小时数

    public PartTimeEmployee(String id, String name, double hourlyRate, int hours) {
        super(id, name, 0); // 基础工资给 0
        this.hourlyRate = hourlyRate;
        this.hours = hours;
    }

    public double calculateSalary() {
        return hourlyRate * hours; // 时薪 × 小时
    }
}
class SalesEmployee extends Employee {
    private double sales;
    public SalesEmployee(String id, String name, double base, double sales) {
        super(id, name, base); this.sales = sales;
    }
    public double calculateSalary() { return baseSalary + sales * 0.05; }
}