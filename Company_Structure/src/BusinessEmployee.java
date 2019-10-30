public class BusinessEmployee extends Employee {
    protected double bonusBudget;

    public BusinessEmployee(String name){
        super(name,50000);
    }

    public double getBonusBudget(){
        return bonusBudget;
    }

    @Override
    String employeeStatus() {
        return getEmployeeID() + " " + getName() + " with a budget of " + Math.round(getBonusBudget() * 10) / 10;
    }
}
