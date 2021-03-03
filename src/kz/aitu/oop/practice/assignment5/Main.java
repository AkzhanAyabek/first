package kz.aitu.oop.practice.assignment5;

import kz.aitu.oop.practice.assignment5.controllers.Controller;
import kz.aitu.oop.practice.assignment5.data.DBManager;
import kz.aitu.oop.practice.assignment5.data.interfaces.IDBManager;
import kz.aitu.oop.practice.assignment5.repositories.EmployeeRepository;
import kz.aitu.oop.practice.assignment5.repositories.interfaces.IEmployeeRepository;

public class Main {

    public static void main(String[] args) {
        IDBManager dbManager = new DBManager();
        IEmployeeRepository employeeRepository = new EmployeeRepository(dbManager);
        Controller controller = new Controller(employeeRepository);
        MyApplication myApplication = new MyApplication(controller);
        myApplication.start();
    }
}
