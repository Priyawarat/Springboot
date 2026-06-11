package streamlamdasorting;

import java.time.LocalDate;

public class Employee {
    int id;
    String name;
    int age;
    LocalDate doj;
    int salary;
    String role;

    public Employee(int id, String name, int age, LocalDate doj, int salary, String role) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.doj = doj;
        this.salary = salary;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getDoj() {
        return doj;
    }

    public void setDoj(LocalDate doj) {
        this.doj = doj;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", doj=" + doj +
                ", salary=" + salary +
                ", role='" + role + '\'' +
                '}';
    }
}
