package kz.aitu.oop.practice.assignment5;

import kz.aitu.oop.practice.assignment5.controllers.Controller;

import java.util.Scanner;

public class MyApplication {
    private final Controller controller;
    private final Scanner sc;


    public MyApplication(Controller controller) {
        this.controller = controller;
        sc = new Scanner(System.in);
    }

    public void start() {
        while (0<1) {
            System.out.println("All operations:\n1) Show all employees\n2) Show all programmers\n3) Show all managers\n4) Add employee\n5) Remove employee by id\n6) Show all projects\n0) Exit");
            System.out.println("Choose one number:");
            int chose = sc.nextInt();

            if (chose == 1) showAllEmployeeMenu();
            else if (chose == 2) showAllProgrammersMenu();
            else if (chose == 3) showAllManagersMenu();
            else if (chose == 4) addEmployee();
            else if (chose == 5) removeEmployeeByIdMenu();
            else if (chose==6) showAllProjectsMenu();
            else break;
            System.out.println("*****======************************======*****");
        }
    }

    public void showAllEmployeeMenu() {
        System.out.println(controller.showAllEmployee());
    }

    public void showAllManagersMenu() {
        System.out.println(controller.showAllManagers());
    }

    public void showAllProgrammersMenu() {
        System.out.println(controller.showAllProgrammers());
    }

    public void addEmployee() {
        System.out.println("Please write a first name of employee");
        String f_name = sc.next();
        System.out.println("Please write a last name of employee");
        String l_name = sc.next();
        System.out.println("Please write an address of employee");
        String address = sc.next();
        System.out.println("Please write a status of employee");
        String status = sc.next();
        System.out.println("Please write a department of employee");
        String dep = sc.next();
        System.out.println("Please write an age of employee");
        int age = sc.nextInt();
        System.out.println("Please write a position of employee (manager or programmer)");
        String position = sc.next();
        System.out.println("Please write a project id of employee");
        int p_id = sc.nextInt();
        System.out.println("Please write a salary of employee");
        double salary = sc.nextDouble();
        System.out.println(controller.addEmployee(f_name, l_name, address, status, dep, age, position, p_id, salary));
    }

    public void removeEmployeeByIdMenu() {
        System.out.println("Please write an id of employee");
        int id = sc.nextInt();
        System.out.println(controller.removeEmployeeById(id));
    }

    public void showAllProjectsMenu() {
        controller.showAllProjects();
    }
}
