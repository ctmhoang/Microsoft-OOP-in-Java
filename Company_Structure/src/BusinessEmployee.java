public class BusinessEmployee extends Employee {
    private static final int DEFAULT_BASE_SALARY = 50000;
    protected double bonusBudget;

    public BusinessEmployee(String name){
        super(name, DEFAULT_BASE_SALARY);
    }

    public double getBonusBudget(){
        return bonusBudget;
    }

    @Override
    String employeeStatus() {
        return getEmployeeID() + " " + getName() + " with a budget of" + Math.round(getBonusBudget() * 10) / 10;
    }
}
