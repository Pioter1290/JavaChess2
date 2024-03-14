import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Knight extends Piece{
    private ImageIcon whiteKnight;
    private ImageIcon blackKnight;
    public Knight(String color, int x, int y, String name) {
        super(color, x, y, name);
        whiteKnight = new ImageIcon("images/white_knight.png");
        blackKnight = new ImageIcon("images/black_knight.png");
    }
    public void addKnight(JPanel[][] squares, JButton[][] buttons, int panelX, int panelY) {
        JButton knightButton = buttons[getX()][getY()];
        knightButton.setIcon(getIcon());
        JPanel panel = squares[panelX][panelY];
        JButton button = buttons[panelX][panelY];
        panel.add(knightButton);
    }
    public ArrayList<Point> getPossibleMoves(JPanel[][] squares, JButton[][] buttons) {
        ArrayList<Point> possibleMoves = new ArrayList<>();
        int currentX = getX();
        int currentY = getY();


        if (currentX - 1 >= 0 && currentY + 2 < 8) {
            possibleMoves.add(new Point(currentX - 1, currentY + 2));
        }
        if (currentX + 1 < 8 && currentY + 2 < 8) {
            possibleMoves.add(new Point(currentX + 1, currentY + 2));
        }
        if (currentX - 1 >= 0 && currentY - 2 >= 0) {
            possibleMoves.add(new Point(currentX - 1, currentY - 2));
        }
        if (currentX + 1 < 8 && currentY - 2 >= 0) {
            possibleMoves.add(new Point(currentX + 1, currentY - 2));
        }
        // Now adding moves for horizontal movements
        if (currentX - 2 >= 0 && currentY + 1 < 8) {
            possibleMoves.add(new Point(currentX - 2, currentY + 1));
        }
        if (currentX + 2 < 8 && currentY + 1 < 8) {
            possibleMoves.add(new Point(currentX + 2, currentY + 1));
        }
        if (currentX - 2 >= 0 && currentY - 1 >= 0) {
            possibleMoves.add(new Point(currentX - 2, currentY - 1));
        }
        if (currentX + 2 < 8 && currentY - 1 >= 0) {
            possibleMoves.add(new Point(currentX + 2, currentY - 1));
        }

        return possibleMoves;
    }


    public ImageIcon getIcon() {
        if (getColor().equals("white")) {
            return whiteKnight;
        } else {
            return blackKnight;
        }
    }
}
