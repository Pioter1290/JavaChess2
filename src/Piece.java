import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class Piece {
    private String color;
    private String name;
    private int x;
    private int y;
    private ImageIcon icon;

    public Piece(String color, int x, int y, String name) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public abstract ArrayList<Point> getPossibleMoves(JPanel[][] squares, JButton[][] buttons);
}
