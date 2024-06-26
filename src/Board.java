import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

public class Board extends JFrame {

    private JPanel[][] squares = new JPanel[8][8];
    private JButton[][] buttons = new JButton[8][8];
    private int selectedX = -1;
    private int selectedY = -1;
    private String currentTurn = "white";
    private HashMap<Point, String> piecePositions = new HashMap<>();
    private HashMap<Point, String> pieceColor = new HashMap<>();

    public Board() {
        setTitle("Chess");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 700);
        setLayout(new GridLayout(8, 8));
        createChessBoard();
        addPawns();
        addRooks();
        addBishops();
        addKings();
        addQueens();
        addKnights();
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        addPieceListeners();
        setIconImage(Toolkit.getDefaultToolkit().getImage("images/black_king.png"));
    }

    private void createChessBoard() {
        setLayout(new GridLayout(8, 8));
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JPanel panel = new JPanel();
                panel.setBackground((i + j) % 2 == 0 ? Color.WHITE : Color.GRAY);
                squares[i][j] = panel;
                add(panel);
                buttons[i][j] = new JButton();
                buttons[i][j].setPreferredSize(new Dimension(80, 80));
                buttons[i][j].setOpaque(false);
                buttons[i][j].setContentAreaFilled(false);
                buttons[i][j].setBorderPainted(false);

                panel.add(buttons[i][j]);
            }
        }
    }

    private void addPawns() {
        Pawn whitePawns[] = new Pawn[8];
        for (int i = 0; i < 8; i++) {
            whitePawns[i] = new Pawn("white", 1, i, "pawn");
            whitePawns[i].addPawn(squares, buttons, 1, i);
            piecePositions.put(new Point(1, i), "pawn");
            pieceColor.put(new Point(1, i), "white");

        }
        Pawn blackPawns[] = new Pawn[8];
        for (int i = 0; i < 8; i++) {
            blackPawns[i] = new Pawn("black", 6, i, "pawn");
            blackPawns[i].addPawn(squares, buttons, 6, i);
            piecePositions.put(new Point(6, i), "pawn");
            pieceColor.put(new Point(6, i), "black");
        }
    }

    private void addRooks() {
        Rook rooks[] = new Rook[4];
        rooks[0] = new Rook("white", 0, 0, "rook");
        pieceColor.put(new Point(0, 0), "white");
        rooks[1] = new Rook("white", 0, 7, "rook");
        pieceColor.put(new Point(0, 7), "white");
        rooks[2] = new Rook("black", 7, 7, "rook");
        pieceColor.put(new Point(7, 7), "black");
        rooks[3] = new Rook("black", 7, 0, "rook");
        pieceColor.put(new Point(7, 0), "black");
        for (int i = 0; i < rooks.length; i++) {
            rooks[i].addRook(squares, buttons, rooks[i].getX(), rooks[i].getY());
            piecePositions.put(new Point(rooks[i].getX(), rooks[i].getY()), "rook");

        }
    }
    private void addKnights() {
        Knight knights[] = new Knight[4];
        knights[0] = new Knight("white", 0, 1, "knight");
        pieceColor.put(new Point(0, 1), "white");
        knights[1] = new Knight("white", 0, 6, "knight");
        pieceColor.put(new Point(0, 6), "white");
        knights[2] = new Knight("black", 7, 6, "knight");
        pieceColor.put(new Point(7, 6), "black");
        knights[3] = new Knight("black", 7, 1, "knight");
        pieceColor.put(new Point(7, 1), "black");
        for (int i = 0; i < knights.length; i++) {
            knights[i].addKnight(squares, buttons, knights[i].getX(), knights[i].getY());
            piecePositions.put(new Point(knights[i].getX(), knights[i].getY()), "knight");

        }
    }
    private void addBishops(){
        Bishop bishops[] = new Bishop[4];
        bishops[0] = new Bishop("white", 0, 2, "bishop");
        pieceColor.put(new Point(0, 2), "white");
        bishops[1] = new Bishop("white", 0, 5, "bishop");
        pieceColor.put(new Point(0, 5), "white");
        bishops[2] = new Bishop("black", 7, 2, "bishop");
        pieceColor.put(new Point(7, 2), "black");
        bishops[3] = new Bishop("black", 7, 5, "bishop");
        pieceColor.put(new Point(7, 5), "black");
        for (int i = 0; i < bishops.length; i++) {
            bishops[i].addBishop(squares, buttons, bishops[i].getX(), bishops[i].getY());
            piecePositions.put(new Point(bishops[i].getX(), bishops[i].getY()), "bishop");

        }
    }
    private void addKings(){
        King kings[] = new King[2];
        kings[0] = new King("white", 0,3,"king");
        kings[0].addKing(squares, buttons, kings[0].getX(), kings[0].getY());
        piecePositions.put(new Point(kings[0].getX(), kings[0].getY()), "king");
        pieceColor.put(new Point(0, 3), "white");
        kings[1] = new King("black", 7, 4,"king");
        kings[1].addKing(squares, buttons, kings[1].getX(), kings[1].getY());
        piecePositions.put(new Point(kings[1].getX(), kings[1].getY()), "king");
        pieceColor.put(new Point(7, 4), "black");
    }
    private void addQueens(){
        Queen queens[] = new Queen[2];
        queens[0] = new Queen("white", 0,4,"queen");
        queens[0].addQueen(squares, buttons, queens[0].getX(), queens[0].getY());
        piecePositions.put(new Point(queens[0].getX(), queens[0].getY()), "queen");
        pieceColor.put(new Point(0, 4), "white");
        queens[1] = new Queen("black", 7, 3,"queen");
        queens[1].addQueen(squares, buttons, queens[1].getX(), queens[1].getY());
        piecePositions.put(new Point(queens[1].getX(), queens[1].getY()), "queen");
        pieceColor.put(new Point(7, 3), "black");
    }

    private void movePiece(int fromX, int fromY, int toX, int toY) {
        JButton fromButton = buttons[fromX][fromY];
        JButton toButton = buttons[toX][toY];
        Icon icon = fromButton.getIcon();
        String pieceColorAtDestination = getPieceColorAt(toX, toY);

        if (pieceColorAtDestination == null || !pieceColorAtDestination.equals(pieceColor.get(new Point(fromX, fromY)))) {
            if (currentTurn.equals(pieceColor.get(new Point(fromX, fromY)))) {
                toButton.setIcon(icon);
                fromButton.setIcon(null);
                piecePositions.put(new Point(toX, toY), piecePositions.get(new Point(fromX, fromY)));
                piecePositions.put(new Point(fromX, fromY), null);
                pieceColor.put(new Point(toX, toY), pieceColor.get(new Point(fromX, fromY)));
                pieceColor.put(new Point(fromX, fromY), null);
                if (currentTurn.equals("white"))
                    currentTurn = "black";
                else
                    currentTurn = "white";
            } else {
                System.out.println("Not your turn!");
            }
        } else {
            System.out.println("You can't kill your own piece!");
        }
    }

    private String getPieceColorAt(int x, int y) {
        Point point = new Point(x, y);
        return pieceColor.getOrDefault(point, null);
    }

    private void addPieceListeners() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JButton button = buttons[i][j];
                int finalI = i;
                int finalJ = j;
                button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (selectedX != -1 && selectedY != -1) {
                            squares[selectedX][selectedY].setBorder(null);
                            boolean isValidMove = false;
                            ArrayList<Point> possibleMoves;
                            String pieceName = piecePositions.get(new Point(selectedX, selectedY));
                            String color = pieceColor.get(new Point(selectedX, selectedY));
                            if (pieceName != null && pieceName.equals("pawn")) {
                                Pawn pawn = new Pawn(color, selectedX, selectedY, "pawn");
                                possibleMoves = pawn.getPossibleMoves(squares, buttons);
                                for (Point move : possibleMoves) {
                                    if (move.getX() == finalI && move.getY() == finalJ) {
                                        isValidMove = true;
                                        break;
                                    }
                                }
                            }
                            if (pieceName != null && pieceName.equals("rook")) {
                                Rook rook = new Rook(color, selectedX, selectedY, "rook");
                                possibleMoves = rook.getPossibleMoves(squares, buttons);
                                for (Point move : possibleMoves) {
                                    if (move.getX() == finalI && move.getY() == finalJ) {
                                        isValidMove = true;
                                        break;
                                    }
                                }
                            }
                            if (pieceName != null && pieceName.equals("bishop")) {
                                Bishop bishop = new Bishop(color, selectedX, selectedY, "bishop");
                                possibleMoves = bishop.getPossibleMoves(squares, buttons);
                                for (Point move : possibleMoves) {
                                    if (move.getX() == finalI && move.getY() == finalJ) {
                                        isValidMove = true;
                                        break;
                                    }
                                }
                            }
                            if (pieceName != null && pieceName.equals("king")) {
                                King king = new King(color, selectedX, selectedY, "king");
                                possibleMoves = king.getPossibleMoves(squares, buttons);
                                for (Point move : possibleMoves) {
                                    if (move.getX() == finalI && move.getY() == finalJ) {
                                        isValidMove = true;
                                        break;
                                    }
                                }
                            }
                            if (pieceName != null && pieceName.equals("queen")) {
                                Queen queen = new Queen(color, selectedX, selectedY, "queen");
                                possibleMoves = queen.getPossibleMoves(squares, buttons);
                                for (Point move : possibleMoves) {
                                    if (move.getX() == finalI && move.getY() == finalJ) {
                                        isValidMove = true;
                                        break;
                                    }
                                }
                            }
                            if (pieceName != null && pieceName.equals("knight")) {
                                Knight knight = new Knight(color, selectedX, selectedY, "knight");
                                possibleMoves = knight.getPossibleMoves(squares, buttons);
                                for (Point move : possibleMoves) {
                                    if (move.getX() == finalI && move.getY() == finalJ) {
                                        isValidMove = true;
                                        break;
                                    }
                                }
                            }
                            if (isValidMove) {
                                movePiece(selectedX, selectedY, finalI, finalJ);
                            }
                            selectedX = -1;
                            selectedY = -1;
                        } else {
                            selectedX = finalI;
                            selectedY = finalJ;
                            squares[finalI][finalJ].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
                            //System.out.println("Clicked button at position: " + finalI + ", " + finalJ);
                            String pieceName = piecePositions.get(new Point(finalI, finalJ));
                            String color = pieceColor.get(new Point(finalI, finalJ));
                            ArrayList<Point> possibleMoves = new ArrayList<>();
                            if (pieceName != null && pieceName.equals("pawn")) {
                                Pawn pawn = new Pawn(color, selectedX, selectedY, "pawn");
                                possibleMoves = pawn.getPossibleMoves(squares, buttons);
                                //System.out.println(possibleMoves);
                            }
                            if (pieceName != null && pieceName.equals("rook")) {
                                Rook rook = new Rook(color, selectedX, selectedY, "rook");
                                possibleMoves = rook.getPossibleMoves(squares, buttons);
                                //System.out.println(possibleMoves);
                            }
                            if (pieceName != null && pieceName.equals("bishop")) {
                                Bishop bishop = new Bishop(color, selectedX, selectedY, "bishop");
                                possibleMoves = bishop.getPossibleMoves(squares, buttons);
                                //System.out.println(possibleMoves);
                            }
                            if (pieceName != null && pieceName.equals("king")) {
                                King king = new King(color, selectedX, selectedY, "king");
                                possibleMoves = king.getPossibleMoves(squares, buttons);
                                //System.out.println(possibleMoves);
                            }
                            if (pieceName != null && pieceName.equals("queen")) {
                                Queen queen = new Queen(color, selectedX, selectedY, "queen");
                                possibleMoves = queen.getPossibleMoves(squares, buttons);
                                //System.out.println(possibleMoves);
                            }
                            if (pieceName != null && pieceName.equals("knight")) {
                                Knight knight = new Knight(color, selectedX, selectedY, "knight");
                                possibleMoves = knight.getPossibleMoves(squares, buttons);
                                //System.out.println(possibleMoves);
                            }

                        }
                    }
                });
            }
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(Board::new);
    }
}
