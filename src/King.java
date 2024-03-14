import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class King extends Piece{
    private ImageIcon whiteKing;
    private ImageIcon blackKing;
    public King(String color, int x, int y, String name) {
        super(color, x, y, name);
        whiteKing = new ImageIcon("images/white_king.png");
        blackKing = new ImageIcon("images/black_king.png");
    }
    public void addKing(JPanel[][] squares, JButton[][] buttons, int panelX, int panelY) {
        JButton kingButton = buttons[getX()][getY()];
        kingButton.setIcon(getIcon());
        JPanel panel = squares[panelX][panelY];
        JButton button = buttons[panelX][panelY];
        panel.add(kingButton);
    }


    public ArrayList<Point> getPossibleMoves(JPanel[][] squares, JButton[][] buttons) {
        ArrayList<Point> possibleMoves = new ArrayList<>();
        int currentX = getX();
        int currentY = getY();

        if (currentX + 1 < 8) {
            possibleMoves.add(new Point(currentX + 1, currentY));
        }
        if (currentX - 1 >= 0) {
            possibleMoves.add(new Point(currentX - 1, currentY));
        }
        if (currentY + 1 < 8) {
            possibleMoves.add(new Point(currentX, currentY + 1));
        }
        if (currentY - 1 >= 0) {
            possibleMoves.add(new Point(currentX, currentY - 1));
        }
        if (currentX + 1 < 8 && currentY + 1 < 8) {
            possibleMoves.add(new Point(currentX + 1, currentY + 1));
        }
        if (currentX - 1 >= 0 && currentY + 1 < 8) {
            possibleMoves.add(new Point(currentX - 1, currentY + 1));
        }
        if (currentX + 1 < 8 && currentY - 1 >= 0) {
            possibleMoves.add(new Point(currentX + 1, currentY - 1));
        }
        if (currentX - 1 >= 0 && currentY - 1 >= 0) {
            possibleMoves.add(new Point(currentX - 1, currentY - 1));
        }

        return possibleMoves;
    }


    public ImageIcon getIcon() {
        if (getColor().equals("white")) {
            return whiteKing;
        } else {
            return blackKing;
        }
    }
}