import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Queen extends Piece {
    private ImageIcon whiteQueen;
    private ImageIcon blackQueen;
    public Queen(String color, int x, int y, String name) {
        super(color, x, y, name);
        whiteQueen = new ImageIcon("images/white_queen.png");
        blackQueen = new ImageIcon("images/black_queen.png");
    }
    public void addQueen(JPanel[][] squares, JButton[][] buttons, int panelX, int panelY) {
        JButton queenButton = buttons[getX()][getY()];
        queenButton.setIcon(getIcon());
        JPanel panel = squares[panelX][panelY];
        JButton button = buttons[panelX][panelY];
        panel.add(queenButton);
    }
    public ArrayList<Point> getPossibleMoves(JPanel[][] squares, JButton[][] buttons) {
        ArrayList<Point> possibleMoves = new ArrayList<>();
        // Ruchy pion i poziom
        for (int i = getX() + 1; i < 8; i++) {
            if (buttons[i][getY()].getIcon() == null) {
                possibleMoves.add(new Point(i, getY()));
            } else {
                if (!getColor().equals(buttons[i][getY()].getIcon().equals(getIcon()))) {
                    possibleMoves.add(new Point(i, getY()));
                }
                break;
            }
        }
        for (int i = getX() - 1; i >= 0; i--) {
            if (buttons[i][getY()].getIcon() == null) {
                possibleMoves.add(new Point(i, getY()));
            } else {
                if (!getColor().equals(buttons[i][getY()].getIcon().equals(getIcon()))) {
                    possibleMoves.add(new Point(i, getY()));
                }
                break;
            }
        }

        for (int j = getY() + 1; j < 8; j++) {
            if (buttons[getX()][j].getIcon() == null) {
                possibleMoves.add(new Point(getX(), j));
            } else {
                if (!getColor().equals(buttons[getX()][j].getIcon().equals(getIcon()))) {
                    possibleMoves.add(new Point(getX(), j));
                }
                break;
            }
        }
        for (int j = getY() - 1; j >= 0; j--) {
            if (buttons[getX()][j].getIcon() == null) {
                possibleMoves.add(new Point(getX(), j));
            } else {
                if (!getColor().equals(buttons[getX()][j].getIcon().equals(getIcon()))) {
                    possibleMoves.add(new Point(getX(), j));
                }
                break;
            }
        }

        // Ruchy na skos
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
            return whiteQueen;
        } else {
            return blackQueen;
        }
    }
}
