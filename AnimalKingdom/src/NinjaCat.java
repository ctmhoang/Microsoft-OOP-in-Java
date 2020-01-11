import java.awt.*;
import java.util.Random;

public class NinjaCat extends Critter {
    private Random move;

    public NinjaCat() {
        move = new Random();
    }

    public String toString() {
        return "*";
    }

    public Color getColor() {
        return new Color(move.nextInt(256), move.nextInt(256), move.nextInt(256));
    }

    @Override
    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.WALL || info.getFront() == Neighbor.SAME) {
            return new Action[]{Action.LEFT, Action.RIGHT}[move.nextInt(2)];
        } else {
            return Action.HOP;
        }
    }

}