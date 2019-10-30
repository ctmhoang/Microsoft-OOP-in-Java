public abstract class Employee {

    private String name;
    private double baseSalary;
    private static int EmployeeID;
    private Employee manager;
    public Employee(String name, double baseSalary){
        this.name = name;
        this.baseSalary = baseSalary;
        EmployeeID += 1;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public int getEmployeeID(){
        return EmployeeID;
    }

    public Employee getManager(){
        return manager;
    }

    public boolean equals(Employee other){
        return EmployeeID == other.getEmployeeID();
    }

    public String toString(){
        return EmployeeID + " " + name;
    }

    abstract String employeeStatus();
}
