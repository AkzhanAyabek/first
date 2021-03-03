package kz.aitu.oop.practice.assignment5.entities;

public class Employee {
    private int id;
    private String fname;
    private String lname;
    private String address;
    private String status;
    private String department;
    private int age;

    public Employee () {

    }

    public Employee (String f_name, String l_name, String address, String status, String department, int age) {
        setFname(f_name);
        setLname(l_name);
        setAddress(address);
        setStatus(status);
        setDepartment(department);
        setAge(age);
    }

    public Employee (int id,String f_name, String l_name, String address, String status, String department, int age) {
        setId(id);
        setFname(f_name);
        setLname(l_name);
        setAddress(address);
        setStatus(status);
        setDepartment(department);
        setAge(age);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String name) {
        this.lname = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    @Override
    public String toString() {
        return getFname() + ' ' + getLname() +
                ", with id " + getId() +
                ", address: " + getAddress()+
                ", age: " + getAge() +
                ", department: " + getDepartment() +
                ", status: " + getStatus();
    }
}
