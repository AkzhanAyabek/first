package kz.aitu.oop.practice.assignment5.entities;

public class Project {
    private int p_id;
    private String name;
    private double total_cost;

    public Project() {

    }

    public Project(int id, String name, double total_cost) {
        this.p_id=id;
        this.name = name;
        this.total_cost = total_cost;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotal_cost() {
        return total_cost;
    }

    public void setTotal_cost(double total_cost) {
        this.total_cost = total_cost;
    }

    @Override
    public String toString() {
        return "Project " + name + "\n with id " + p_id +
                "\n total_cost=" + total_cost + "\nAll employees {";
    }
}
