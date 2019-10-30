import java.util.ArrayList;
import java.util.List;

public class BusinessLead extends BusinessEmployee implements I_Managment, I_BusMBehavior{
    private int headCount, numDR = 0;
    private double budget;
    private List<Accountant> directReport = new ArrayList<>();
    BusinessLead(String name) {
        super(name);
        baseSalary *= 2;
        headCount = 10;
    }

    @Override
    public boolean hasHeadCount() {
        return numDR < headCount;
    }

    @Override
    public boolean addReport(Accountant e, TechnicalLead supportTeam) {
        if(hasHeadCount()){
            directReport.add(e);
            e.setManager(this);
            numDR ++;
            supportTeam.setBonus(this);
            bonusBudget += supportTeam.getBaseSalary() * 0.1;
            return true;
        }
        return false;
    }

    @Override
    public boolean requestBonus(Employee e, Double bonus) {
        if(budget >= bonus){
            e.bonus += bonus;
            budget -= bonus;
            return true;
        }
        return false;
    }

    @Override
    public boolean approveBonus(Employee e, double bonus) {
        for(Accountant acc : directReport) {
            if (acc.getTeamSupported() == e && acc.getBonusBudget() >= bonus) {
                return requestBonus(e, bonus);
            }
        }
        return false;
    }
    public String getTeamStatus(){

        if (directReport.size()==0){
            return this.employeeStatus()+ " and no direct reports yet";
        } else {
            StringBuilder teamStatus= new StringBuilder();
            for (Accountant accountant : directReport) {
                if(accountant.getTeamSupported() == null){
                    continue;
                }
                teamStatus.append("    ").append(accountant.employeeStatus()).append("\n");
            }
            return this.employeeStatus()+" and is managing: \n"+teamStatus;

        }
    }
}
