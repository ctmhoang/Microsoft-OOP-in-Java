public class SoftwareEngineer extends TechnicalEmployee implements I_SEBehavior {
    private boolean access;
    private TechnicalLead manager;

    SoftwareEngineer(String name) {
        super(name);
    }

    @Override
    public void setManager(TechnicalLead manager) {
        this.manager = manager;
        upCasting(manager);
    }

    @Override
    public void upCasting(TechnicalLead manager) {
        super.setManager(manager);
    }

    boolean getCodeAccess() {
        return access;
    }

    void setCodeAccess(boolean access) {
        this.access = access;
    }

    int getSuccessfulCheckIns() {
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
