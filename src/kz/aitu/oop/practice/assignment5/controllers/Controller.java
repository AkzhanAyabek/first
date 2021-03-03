package kz.aitu.oop.practice.assignment5.controllers;

import kz.aitu.oop.practice.assignment5.entities.Employee;
import kz.aitu.oop.practice.assignment5.entities.Project;
import kz.aitu.oop.practice.assignment5.repositories.interfaces.IEmployeeRepository;

import java.util.ArrayList;

public class Controller {
    private final IEmployeeRepository employeeRepository;

    public Controller(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public String showAllEmployee() {
        String managers = employeeRepository.getAllManager().toString();
        String programmers = employeeRepository.getAllProgrammers().toString();
        return managers + "\n" + programmers; //it is sum of showAllManagers() and showAllProgrammers()
    }

    public String showAllManagers() {
        return employeeRepository.getAllManager().toString();
    }

    public String showAllProgrammers() {
        return employeeRepository.getAllProgrammers().toString();
    }

    public String addEmployee(String f_name, String l_name, String address, String status, String department, int age, String position, int p_id, double salary) {
        boolean add = employeeRepository.addEmployee(new Employee(f_name, l_name, address, status, department, age), position, p_id, salary);
        if(add) return "Employee was added"; //if it is added return this text
        return "Employee was not added"; //else this text will be returned
    }

    public String removeEmployeeById(int id) {
        boolean remove = employeeRepository.removeEmployeeById(id);
        if (remove) return "Employee was removed";
        return "Employee was not removed";
    }

    public void showAllProjects() {
        ArrayList<Employee> employees = employeeRepository.getAllEmployees(); //get employees
        ArrayList<Project> projects = employeeRepository.showAllProjects(); //get projects
        int k =0, j=0, l=0; //introduce extra values
        for (Project p:projects) {
            if (p.getP_id() == 1 && k == 0) {
                System.out.println(p.toString()); //we can once output this
                for (Employee e : employees) {
                    if (e.getId() == 1) System.out.println(e.toString()); //checking all employees ahd output who is in this project
                }
                System.out.println("}");
                k++;
            }
            if (p.getP_id() == 2 && j==0) {
                System.out.println(p.toString());
                for (Employee e : employees) {
                    if (e.getId() == 2) System.out.println(e.toString()); //the same as previous
                }
                System.out.println("}");
                j++;
            }
            if (p.getP_id() == 3 && l == 0) {
                System.out.println(p.toString());
                for (Employee e : employees) {
                    if (e.getId() == 3) System.out.println(e.toString()); //the same as previous
                }
                System.out.println("}");
                l++;
            }
        }
    }
}
