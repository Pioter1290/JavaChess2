import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Pawn extends Piece {
    private ImageIcon whitePawnIcon;
    private ImageIcon blackPawnIcon;


    public Pawn(String color, int x, int y, String name) {
        super(color, x, y, name);
        whitePawnIcon = new ImageIcon("images/white_pawn.png");
        blackPawnIcon = new ImageIcon("images/black_pawn.png");

    }

    public void addPawn(JPanel[][] squares, JButton[][] buttons, int panelX, int panelY) {
        JButton pawnButton = buttons[getX()][getY()];
        pawnButton.setIcon(getIcon());
        JPanel panel = squares[panelX][panelY];
        JButton button = buttons[panelX][panelY];
        panel.add(pawnButton);
    }


    public ArrayList<Point> getPossibleMoves(JPanel[][] squares, JButton[][] buttons) {
        ArrayList<Point> possibleMoves = new ArrayList<>();
        int currentX = getX();
        int currentY = getY();
        String color = getColor();
        if (color.equals("white")) {
            if (currentX == 1 && buttons[currentX + 2][currentY].getIcon() == null) {
                possibleMoves.add(new Point(currentX + 2, currentY));
            }
            if (currentX + 1 < 8 && buttons[currentX + 1][currentY].getIcon() == null) {
                possibleMoves.add(new Point(currentX + 1, currentY));
            }
        } else {
            if (currentX == 6 && buttons[currentX - 2][currentY].getIcon() == null) {
                possibleMoves.add(new Point(currentX - 2, currentY));
            }
            if (currentX - 1 >= 0 && buttons[currentX - 1][currentY].getIcon() == null) {
                possibleMoves.add(new Point(currentX - 1, currentY));
            }
        }
        return possibleMoves;
    }


    public ImageIcon getIcon() {
        if (getColor().equals("white")) {
            return whitePawnIcon;
        } else {
            return blackPawnIcon;
        }
    }
}
