package wireworld;

import wireworld.Automat.Automat;
import wireworld.gui.WireworldWindow;
import wireworld.structures.*;

import javax.swing.*;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Main {
    private static int numberIteration;
    private static WireworldWindow window;
    private static String a;
    private static  boolean isdiasposed;

    public static void main(String[] args) throws InterruptedException {
        Structure_list g = new Structure_list();
        Diode s1 = new Diode(0,3, "Normal");
        Diode s2 = new Diode(0,9, "Reversed");
        //  OR s2 = new OR(2,2);
        g.add(s2);
        g.add(s1);
        XOR s3 = new XOR(2,2);
        AND sA = new AND(2,2);
        NAND s4 = new NAND(2,4);

        int[][] board  = new int[32][32];
        int maxRow = board.length;
        int maxCol = board[maxRow - 1].length;
        System.out.println(maxRow);
        System.out.println(maxCol);
        s1.addstruct(board);
        board[3][1] = 2;
        board[3][0] = 3;

        //System.out.println(Arrays.deepToString(board).replace("], ", "],\n"));
        Automat automat = new Automat(board);

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Wireworld GUI");
                window = new WireworldWindow(frame) {
                    @Override
                    public void onOpen(String path) {
                        a= path;
                    }
                    @Override
                    public void getit(int itnr) {
                        numberIteration = itnr;
                    }

                    @Override
                    public void getisclosed(boolean closed) {
                        isdiasposed = closed;
                    }

                };

            }
        });
        TimeUnit.SECONDS.sleep(13);
        System.out.println(isdiasposed == true);
        System.out.println(a);
        System.out.println("Number: " + numberIteration);

    }
}
