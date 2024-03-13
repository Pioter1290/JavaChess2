import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Bishop extends Piece{
    private ImageIcon whiteBishop;
    private ImageIcon blackBishop;
    public Bishop(String color, int x, int y, String name) {
        super(color, x, y, name);
        whiteBishop = new ImageIcon("images/white_bishop.png");
        blackBishop = new ImageIcon("images/black_bishop.png");
    }
    public void addBishop(JPanel[][] squares, JButton[][] buttons, int panelX, int panelY) {
        JButton bishopButton = buttons[getX()][getY()];
        bishopButton.setIcon(getIcon());
        JPanel panel = squares[panelX][panelY];
        JButton button = buttons[panelX][panelY];
        panel.add(bishopButton);
    }
    public ArrayList<Point> getPossibleMoves(JPanel[][] squares, JButton[][] buttons) {
        ArrayList<Point> possibleMoves = new ArrayList<>();

        // Check diagonal moves to the top-right
        for (int i = getX() + 1, j = getY() + 1; i < 8 && j < 8; i++, j++) {
            if (buttons[i][j].getIcon() == null) {
                possibleMoves.add(new Point(i, j));
            } else {
                if (!getColor().equals(buttons[i][j].getIcon().equals(getIcon()))) {
                    possibleMoves.add(new Point(i, j));
                }
                break;
            }
        }

        // Check diagonal moves to the top-left
        for (int i = getX() - 1, j = getY() + 1; i >= 0 && j < 8; i--, j++) {
            if (buttons[i][j].getIcon() == null) {
                possibleMoves.add(new Point(i, j));
            } else {
                if (!getColor().equals(buttons[i][j].getIcon().equals(getIcon()))) {
                    possibleMoves.add(new Point(i, j));
                }
                break;
            }
        }

        // Check diagonal moves to the bottom-right
        for (int i = getX() + 1, j = getY() - 1; i < 8 && j >= 0; i++, j--) {
            if (buttons[i][j].getIcon() == null) {
                possibleMoves.add(new Point(i, j));
            } else {
                if (!getColor().equals(buttons[i][j].getIcon().equals(getIcon()))) {
                    possibleMoves.add(new Point(i, j));
                }
                break;
            }
        }

        // Check diagonal moves to the bottom-left
        for (int i = getX() - 1, j = getY() - 1; i >= 0 && j >= 0; i--, j--) {
            if (buttons[i][j].getIcon() == null) {
                possibleMoves.add(new Point(i, j));
            } else {
                if (!getColor().equals(buttons[i][j].getIcon().equals(getIcon()))) {
                    possibleMoves.add(new Point(i, j));
                }
                break;
            }
        }

        return possibleMoves;
    }

    public ImageIcon getIcon() {
        if (getColor().equals("white")) {
            return whiteBishop;
        } else {
            return blackBishop;
        }
    }
}
