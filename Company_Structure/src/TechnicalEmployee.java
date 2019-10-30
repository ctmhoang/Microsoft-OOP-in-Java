public class TechnicalEmployee extends Employee
{
    protected int checkIns;
    private static final int DEFAULT_BASE_SALARY = 75000;

    public TechnicalEmployee(String name){
        super(name, DEFAULT_BASE_SALARY);
    }
    @Override
    String employeeStatus() {
        return getEmployeeID() + " " + getName() + " has " + checkIns + " successful check ins";
    }
}
