import javax.swing.*;
import java.awt.*;


public class Board extends JFrame {

    private JPanel[][] squares = new JPanel[8][8];

    public Board() {
        setTitle("Chess");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 700);
        setLayout(new GridLayout(8, 8));
        createChessBoard();
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage("images/black_king.png"));
    }

    private void createChessBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JPanel panel = new JPanel();
                panel.setBackground((i + j) % 2 == 0 ? Color.WHITE : Color.GRAY);
                squares[i][j] = panel;
                add(panel);
            }
        }
    }
    



    public static void main(String[] args) {
        SwingUtilities.invokeLater(Board::new);
    }
}
