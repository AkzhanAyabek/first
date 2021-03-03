package kz.aitu.oop.practice.assignment5.entities;

import kz.aitu.oop.practice.assignment5.entities.interfaces.IMember;

public class Manager extends Employee implements IMember {
    private double salary;

    public Manager () {}

    public Manager (String f_name, String l_name, String address, String status, String department, int age, double salary) {
        super(f_name, l_name, address, status, department, age);
        setSalary(salary);
    }

    public Manager (int id, String f_name, String l_name, String address, String status, String department, int age, double salary) {
        super(id, f_name, l_name, address, status, department, age);
        setSalary(salary);
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String work() {
        return ", is working as manager";
    }

    @Override
    public String getSalary() {
        return ", got " + salary + "$ per month";
    }

    @Override
    public String toString() {
        return super.toString() + getSalary() + work() + "\n";
    }
}
