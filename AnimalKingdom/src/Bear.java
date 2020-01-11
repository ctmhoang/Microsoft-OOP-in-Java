import java.awt.*;

public class Bear extends Critter {
    private boolean isPolar;
    private int steps;

    public Bear(boolean polar) {
        isPolar = polar;
        steps = -1;
    }

    @Override
    public Color getColor() {
        return isPolar ? Color.WHITE : Color.BLACK;
    }

    public String toString() {
        return steps % 2 == 0 ? "/" : "\\";
    }

    public Action getMove(CritterInfo info) {
        steps++;
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return Action.LEFT;
        }
    }

}
