import java.awt.*;

public class Giant extends Critter {
    private String[] moves;
    private int steps;

    public Giant() {
        moves = new String[]{"fee", "fie", "foe", "fum"};

    }

    public Color getColor() {
        return Color.GRAY;
    }

    public Action getMove(CritterInfo info) {
        steps++;
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return Action.RIGHT;
        }
    }

    public String toString() {
        int idicator = 0;
        if (steps >= 0 && steps <= 5) {
        } else if (steps > 5 && steps <= 11) {
            idicator = 1;
        } else if (steps > 11 && steps <= 17) {
            idicator = 2;
        } else if (steps > 17 && steps <= 24) {
            idicator = 3;
        } else {
            steps = 0;
        }
        return moves[idicator];
    }

}
