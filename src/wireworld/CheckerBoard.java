package wireworld;

import wireworld.Automat.Automat;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class CheckerBoard extends JPanel  {

    private int[][] matrixBoard;
    private final JPanel[][] colorboard = new JPanel[32][32];
    private int c = 0;
    private final Timer timer;
    private final int niter;

    public CheckerBoard(int [][] matrixBoard,int niter) {
        this.niter = niter;
        Dimension dims = new Dimension(600/32, 612/32);
        setLayout(new GridLayout(32, 32));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < 32; j++) {
                JPanel b = new JPanel( new BorderLayout() );
                b.setPreferredSize(dims);
                b.setMinimumSize(dims);
                b.setBorder(new LineBorder(Color.WHITE));
                b.setBackground(getColor(matrixBoard[i][j]));
                add(b);
                colorboard[i][j] = b;}

        }
        Automat automat = new Automat(matrixBoard);
        automat.copy_Matrix(automat.updateMatrix(), matrixBoard);
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                automat.copy_Matrix(automat.updateMatrix(), matrixBoard);
                colorboard[1][1].setBackground(Color.WHITE);
                for (int i = 0; i < 32; i++) {
                    for (int j = 0; j < 32; j++) {
                        colorboard[i][j].setBackground(getColor(matrixBoard[i][j]));
                    }}
                c+=1;
                if (c == niter) {
                    System.err.println("Timer skończył");
                    timer.stop();
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