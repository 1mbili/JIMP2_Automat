package wireworld.gui;

import wireworld.Automat.Automat;
import wireworld.gui.SecondWindow;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

import static javax.swing.UIManager.getColor;

public class CheckerBoard extends JPanel{

    public int[][] getMatrixBoard() {
        return matrixBoard;
    }

    private int[][] matrixBoard;
    private  JPanel[][] colorboard;
    private int c = 0;
    private Timer timer;
    private int niter;
    private int rowLength;
    private int colLength;

    public void setInterrupted(boolean interrupted) {
        isInterrupted = interrupted;
    }

    private volatile boolean isInterrupted;

    public CheckerBoard() {
    }

    public CheckerBoard(int [][] matrixBoard, int niter) throws InterruptedException {
        this.matrixBoard = matrixBoard;

        this.niter = niter;
        this.rowLength = matrixBoard.length;
        this.colLength = matrixBoard[0].length;
        this.colorboard = new JPanel[rowLength][colLength];
        System.out.println(colLength+"j"+rowLength);
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
                colorboard[i][j] = b;
            }

        }
        Automat automat = new Automat(matrixBoard);
        automat.copy_Matrix(automat.updateMatrix(), matrixBoard);
        timer = new Timer(800, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isInterrupted == false){
                automat.copy_Matrix(automat.updateMatrix(), matrixBoard);
                for (int i = 0; i < rowLength; i++) {
                    for (int j = 0; j < colLength; j++) {
                        colorboard[i][j].setBackground(getColor(matrixBoard[i][j]));
                        }
                }
                c++;
                if (c == niter) {
                    System.err.println("Timer skończył");
                    timer.stop();
                }
            }
            }});
        timer.start();
    }
    public Timer getTimer() {
        return this.timer;
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