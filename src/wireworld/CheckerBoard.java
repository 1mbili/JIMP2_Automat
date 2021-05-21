package wireworld;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class CheckerBoard extends JPanel {

    private int[][] matrixBoard;
    private final JPanel[][] colorboard = new JPanel[32][32];

    public CheckerBoard(int [][] matrixBoard) {
        Dimension dims = new Dimension(600/32, 612/32);
        setLayout(new GridLayout(32, 32));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
            for (int i = 0; i < 31; i++) {
                for (int j = 0; j < 31; j++) {
                    JPanel b = new JPanel();
                    b.setPreferredSize(dims);
                    b.setMinimumSize(dims);
                    b.setBorder(new LineBorder(Color.BLACK));
                    b.setBackground(getColor(matrixBoard[i][j]));
                    add(b);
                    colorboard[i][j] = b;

            }
        }
    }
    public Color getColor(int data) {
        switch(data) {
            case 0:
                return Color.BLACK;
            case 1:
                return Color.YELLOW;
            case 2:
                return Color.BLUE;
            case 3:
                return Color.RED;
            default:
                break;
        }
        return null;
    }
}