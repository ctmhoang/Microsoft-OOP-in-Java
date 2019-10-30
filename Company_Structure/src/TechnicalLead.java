import java.util.ArrayList;
import java.util.List;

public class TechnicalLead extends TechnicalEmployee implements I_Managment, I_TechMBehavior {
    private int headCount, numDR;
    private List<SoftwareEngineer> directReports = new ArrayList<>();
    private BusinessLead Bonus;

    TechnicalLead(String name) {
        super(name);
        baseSalary *= 1.3;
        headCount = 4;
    }

    @Override
    public boolean hasHeadCount() {
        return numDR < headCount;
    }

    @Override
    public boolean addReport(SoftwareEngineer e) {
        if (hasHeadCount()) {
            directReports.add(e);
            e.setManager(this);
            numDR++;
            return true;
        }
        return false;
    }

    public void setBonus(BusinessLead lead){
        Bonus = lead;
    }

    public List<SoftwareEngineer> getDirectReports() {
        return directReports;
    }

    @Override
    public boolean approveCheckIn(SoftwareEngineer e) {
        return e.getManager().equals(this) && e.getCodeAccess();
    }

    @Override
    public boolean requestBonus(Employee e, Double bonus) {
        if(Bonus.approveBonus(this, bonus)) {
            return Bonus.requestBonus(this, bonus);
        }
        else return false;
    }

    @Override
    public String getTeamStatus() {
        StringBuilder stat = new StringBuilder(super.toString() + " has " + checkIns + " successful check ins ");
        if (directReports == null) {
            stat.append("and no direct reports yet");
        } else {
            stat.append("and is managing: \n");
            for (SoftwareEngineer SE : directReports) {
                stat.append(SE.toString()).append(" has ").append(SE.getSuccessfulCheckIns()).append("  successful check ins \n");
            }
        }
        return stat.toString();
    }
}
