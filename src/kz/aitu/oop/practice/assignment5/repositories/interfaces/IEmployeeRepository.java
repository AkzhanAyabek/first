package kz.aitu.oop.practice.assignment5.repositories.interfaces;

import kz.aitu.oop.practice.assignment5.entities.Employee;
import kz.aitu.oop.practice.assignment5.entities.Manager;
import kz.aitu.oop.practice.assignment5.entities.Programmer;
import kz.aitu.oop.practice.assignment5.entities.Project;

import java.util.ArrayList;

public interface IEmployeeRepository {
    public ArrayList<Employee> getAllEmployees();
    public ArrayList<Programmer> getAllProgrammers();
    public ArrayList<Manager> getAllManager();
    public boolean addEmployee(Employee employee, String position, int p_id, double salary);
    public boolean removeEmployeeById(int id);
    public ArrayList<Project> showAllProjects();
}
