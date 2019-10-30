public class SoftwareEngineer extends TechnicalEmployee implements I_SEBehavior {
    protected boolean access;
    public TechnicalLead manager;

    SoftwareEngineer(String name) {
        super(name);
    }

    @Override
    public void setManager(TechnicalLead manager) {
        this.manager = manager;
    }

    public boolean getCodeAccess() {
        return access;
    }

    public void setCodeAccess(boolean access) {
        this.access = access;
    }

    public int getSuccessfulCheckIns() {
        return checkIns;
    }

    public boolean CheckInCode() {
        if(manager.approveCheckIn(this)){
            checkIns ++;
            return true;
        }
        return false;
    }


}
