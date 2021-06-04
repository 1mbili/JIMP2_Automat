package wireworld.gui;

import wireworld.Automat.Automat;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class CheckerBoard extends JPanel{

    public int[][] getMatrixBoard() {
        return matrixBoard;
    }

    private final int[][] matrixBoard;
    private final JPanel[][] colorBoard;
    private final Timer timer;
    private final int rowLength;
    private final int colLength;

    public void setInterrupted(boolean interrupted) {
        isInterrupted = interrupted;
    }

    private volatile boolean isInterrupted;

    public CheckerBoard(int [][] matrixBoard, int niter) {
        this.matrixBoard = matrixBoard;
        this.rowLength = matrixBoard.length;
        this.colLength = matrixBoard[0].length;
        this.colorBoard = new JPanel[rowLength][colLength];
        Dimension dims = new Dimension(400 / rowLength, 400 / colLength);
        setLayout(new GridLayout(rowLength, colLength));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                JPanel b = new JPanel(new BorderLayout());
                b.setPreferredSize(dims);
                b.setMinimumSize(dims);
                b.setBorder(new LineBorder(Color.WHITE));
                b.setBackground(getColor(matrixBoard[i][j]));
                add(b);
                colorBoard[i][j] = b;
            }

        }
        Automat automat = new Automat(matrixBoard);
        timer = new Timer(750, new ActionListener() {
            int counter = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isInterrupted && niter !=0){
                    automat.copy_Matrix(automat.updateMatrix(), matrixBoard);

                    for (int i = 0; i < rowLength; i++) {
                    for (int j = 0; j < colLength; j++) {
                        colorBoard[i][j].setBackground(getColor(matrixBoard[i][j]));
                        }
                }
                counter++;
                if (counter == niter) {
                    timer.stop();
                }
            }
            }});
        timer.start();
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