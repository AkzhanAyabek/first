package kz.aitu.oop.practice.assignment5.entities;

import kz.aitu.oop.practice.assignment5.entities.interfaces.IProgrammer;

public class Programmer extends Employee implements IProgrammer {
        private double salary;

        public Programmer() {
            super();
        }

        public Programmer(String f_name, String l_name, String address, String status, String department, int age, double salary) {
            super(f_name, l_name, address, status, department, age);
            setSalary(salary);
        }

        public Programmer(int id, String f_name, String l_name, String address, String status, String department, int age, double salary) {
            super(id, f_name, l_name, address, status, department, age);
            setSalary(salary);
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        @Override
        public String work() {
            return ", is working as programmer";
        }

        @Override
        public String getSalary() {
            return ", got " + salary + "$ per month";
        }

        @Override
        public String programming() {
            return getFname() + " " + getLname() +" is programming...";
        }

        @Override
        public String toString() {
            return super.toString() + getSalary() + work() + "\n";
        }
}
