public class Accountant extends BusinessEmployee implements I_BussAccBehavior {
    private TechnicalLead lead;
    private BusinessEmployee manager;
    Accountant(String name) {
        super(name);
    }

    public TechnicalLead getTeamSupported(){
        return lead;
    }

    @Override
    public void setManager(BusinessLead manager) {
        this.manager = manager;
        upCasting(manager);
    }

    @Override
    public void upCasting(BusinessLead manager) {
        super.setManager(manager);
    }

    public void supportTeam(TechnicalLead lead){
        this.lead = lead;
        bonusBudget += lead.getBaseSalary();
        for(SoftwareEngineer se : lead.getDirectReports()){
            bonusBudget += se.getBaseSalary();
        }
        bonusBudget /= 10;

    }
    public boolean approveBonus(double bonus){
        if(lead == null){
            return false;
        }
        return bonusBudget > bonus;
    }

    public String employeeStatus(){
        if(lead == null){
            return super.employeeStatus() + " and no direct reports yet";
        }
        return super.employeeStatus() + " is supporting " + lead.getName();
    }
}
