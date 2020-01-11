import java.awt.*;

public class WhiteTiger extends Tiger {
    private boolean hasInfected;
    public WhiteTiger(){

    }
    public Color getColor(){
        return Color.WHITE;
    }

    @Override
    public String toString() {
        return hasInfected ?"tgr" : "TGR";
    }
    public Action getMove(CritterInfo info){
        if(info.frontThreat()){
            hasInfected = true;
        }
        return super.getMove(info);
    }
}
