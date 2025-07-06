public class Employee {
    // Attributes
    private String id;
    private String name;
    private double salary;

    // Constructors
    public Employee(String id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Methods
    public double getAnnualSalary() {
        return salary*12;
    }

    public double raisedSalary(double percent) {
        percent = percent / 100;
        this.setSalary(this.getSalary() + (this.getSalary() * percent));
        return this.getSalary();
    }

    // Getters and Setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    // toString
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
