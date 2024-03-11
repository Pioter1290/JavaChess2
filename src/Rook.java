import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Rook extends Piece {
    private ImageIcon whiteRook;
    private ImageIcon blackRook;

    public Rook(String color, int x, int y, String name) {
        super(color, x, y, name);
        try {
            whiteRook = new ImageIcon(ImageIO.read(new File("images/white_rook.png")));
            blackRook = new ImageIcon(ImageIO.read(new File("images/black_rook.png")));
        } catch (IOException e) {
            System.err.println("Error " + e.getMessage());
        }
    }

    public void addRook(JPanel[][] squares, JButton[][] buttons, int panelX, int panelY) {
        JButton rookButton = buttons[getX()][getY()];
        rookButton.setIcon(getIcon());
        JPanel panel = squares[panelX][panelY];
        JButton button = buttons[panelX][panelY];
        panel.add(rookButton);
    }

    public ArrayList<Point> getPossibleMoves(JPanel[][] squares, JButton[][] buttons) {
        ArrayList<Point> possibleMoves = new ArrayList<>();

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

        return possibleMoves;
    }

    public ImageIcon getIcon() {
        if (getColor().equals("white")) {
            return whiteRook;
        } else {
            return blackRook;
        }
    }

}
