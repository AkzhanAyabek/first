package kz.aitu.oop.practice.assignment5.repositories;

import kz.aitu.oop.practice.assignment5.data.interfaces.IDBManager;
import kz.aitu.oop.practice.assignment5.entities.Employee;
import kz.aitu.oop.practice.assignment5.entities.Manager;
import kz.aitu.oop.practice.assignment5.entities.Programmer;
import kz.aitu.oop.practice.assignment5.entities.Project;
import kz.aitu.oop.practice.assignment5.repositories.interfaces.IEmployeeRepository;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeRepository implements IEmployeeRepository {
    private final IDBManager dbManager;

    public EmployeeRepository(IDBManager dbManager) {
        this.dbManager = dbManager;
    }


    @Override
    public ArrayList<Employee> getAllEmployees() {
        Connection connection = null;

        try{
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM projects LEFT JOIN employees ON projects.p_id = employees.proj_id");

            ResultSet resultSet = preparedStatement.executeQuery(); //get result of query to find all employees in the project

            ArrayList<Employee> employees = new ArrayList<>();

            while(resultSet.next()) {
                Employee emp = new Employee(resultSet.getInt("proj_id"),
                        resultSet.getString("fname"),
                        resultSet.getString("lname"),
                        resultSet.getString("address"),
                        resultSet.getString("status"),
                        resultSet.getString("department"),
                        resultSet.getInt("age")
                ); //filling object emp and adding to arraylist
                employees.add(emp);
            }
            return employees;
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Programmer> getAllProgrammers() {
        Connection connection = null;

        try{
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employees");

            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Programmer> programmers = new ArrayList<>();

            while(resultSet.next()) {
                String position = resultSet.getString("position");
                if (position.equals("programmer")) {
                    Programmer pr = new Programmer(resultSet.getInt("id"),
                            resultSet.getString("fname"),
                            resultSet.getString("lname"),
                            resultSet.getString("address"),
                            resultSet.getString("status"),
                            resultSet.getString("department"),
                            resultSet.getInt("age"),
                            resultSet.getDouble("salary")
                    );
                    programmers.add(pr);
                }
            }
            return programmers;
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Manager> getAllManager() {
        Connection connection = null;

        try{
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employees");

            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Manager> managers = new ArrayList<>();

            while(resultSet.next()) {
                if (resultSet.getString("position").equals("manager")) {
                    Manager pr = new Manager(resultSet.getInt("id"),
                            resultSet.getString("fname"),
                            resultSet.getString("lname"),
                            resultSet.getString("address"),
                            resultSet.getString("status"),
                            resultSet.getString("department"),
                            resultSet.getInt("age"),
                            resultSet.getDouble("salary")
                    );
                    managers.add(pr);
                }
            }
            return managers;
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addEmployee(Employee employee, String position, int p_id, double salary) {
        Connection connection = null;

        try {
            connection = dbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO employees(id,fname,lname,address,status,age,department,position,proj_id,salary) VALUES(DEFAULT,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1, employee.getLname());
            preparedStatement.setString(2, employee.getFname());
            preparedStatement.setString(3, employee.getAddress());
            preparedStatement.setString(4, employee.getStatus());
            preparedStatement.setInt(5, employee.getAge());
            preparedStatement.setString(6, employee.getDepartment());
            preparedStatement.setString(7, position);
            preparedStatement.setInt(8, p_id);
            preparedStatement.setDouble(9, salary);

            preparedStatement.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean removeEmployeeById(int id) {
        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM employees WHERE id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            return true;
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public ArrayList<Project> showAllProjects() {
        Connection connection = null;

        try{
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM projects LEFT JOIN employees ON projects.p_id = employees.proj_id");

            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Project> projects = new ArrayList<>();
            //Find all projects and add to list
            while(resultSet.next()) {
                Project pr = new Project(resultSet.getInt("p_id"),
                            resultSet.getString("name"),
                            resultSet.getDouble("budget")
                );
                projects.add(pr);
            }
            return projects; //return list
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }



}
