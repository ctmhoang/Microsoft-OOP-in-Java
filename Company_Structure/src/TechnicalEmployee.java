public class TechnicalEmployee extends Employee
{
    protected int checkIns;

    public TechnicalEmployee(String name){
        super(name, 75000);
    }
    @Override
    String employeeStatus() {
        return getEmployeeID() + " " + getName() + " has " + checkIns + " successful check ins";
    }
}
