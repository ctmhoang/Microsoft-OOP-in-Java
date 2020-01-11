import java.awt.*;
import java.util.Random;

public class Tiger extends Critter {
    private Color[] colors;
    private Color color;
    private int count;
    private Random setColor = new Random();


    public Tiger() {
        colors = new Color[]{Color.RED, Color.GREEN, Color.BLUE};
        color = colors[setColor.nextInt(3)];
        count = 0;
    }

    @Override
    public Color getColor() {
        if (count > 3) {
            count = 0;
            Color oldColor = color, newColor;
            while ((newColor = colors[setColor.nextInt(3)]) == oldColor){
                //Do Nothing
            }
            color = newColor;
        }
        return color;
    }

    public String toString() {
        return "TGR";
    }

    public Action getMove(CritterInfo info) {
        count++;
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
            return Action.LEFT;
        } else if (info.getFront() == Neighbor.SAME) {
            return Action.RIGHT;
        } else {
            return Action.HOP;
        }
    }
}
