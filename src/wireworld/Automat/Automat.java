package wireworld.Automat;

import wireworld.structures.*;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

/* stany:
 0 - puste
 1 - przewodnik
 2 - głowa elektronu
 3 - ogon elektronu
*/

public class Automat {
    private int [][] actualBoard;
    private int [][] nextIterationBoard;
    private int maxRow;
    private int maxCol;

    public static void main(String[] args) {
        Structure_list g = new Structure_list();
        Diode s1 = new Diode(0,3, "Normal");
        Diode s2 = new Diode(0,9, "Reversed");
        //  OR s2 = new OR(2,2);
        g.add(s2);
        g.add(s1);
        XOR s3 = new XOR(2,2);
        AND sA = new AND(2,2);
        NAND s4 = new NAND(2,4);

        int[][] board  = new int[16][30];
        int maxRow = board.length;
        int maxCol = board[maxRow - 1].length;
        System.out.println(maxRow);
        System.out.println(maxCol);
        board[7][5] = 3;
        board[0][1] = 2;
        s4.addstruct(board);
        System.out.println(Arrays.deepToString(board).replace("], ", "],\n"));

        Automat automat = new Automat(board);
        System.out.println("\n");

        automat.copy_Matrix(automat.updateMatrix(), board);
//        automat.copy_Matrix(automat.getActualBoard(), board);
        System.out.println(Arrays.deepToString(board).replace("], ", "],\n"));
    }

    public Automat( int[][] thisBoard) {

        maxRow = thisBoard.length;
        maxCol = thisBoard[maxRow - 1].length;
        actualBoard = new int[maxRow][maxCol];
        //this.actualBoard = thisBoard;
        copy_Matrix(thisBoard, actualBoard);
    }

        public void copy_Matrix (int first[][], int second[][]) {
            for ( int i = 0 ; i < maxRow; ++i)
                System.arraycopy(first[i], 0, second[i], 0, first[i].length );
        }

        public int countAliveCells ( int x, int y) {   // x i y to współrzędne punktu
            int sumHeard = 0;
            for (int i = x - 1; i < x + 2; i++)       // iteracja po wierszach w sąsiedstwie
                for (int j = y - 1; j < y + 2; j++)   // iteracja po kolumnach w sąsiedstwie
                    if (( i >= 0 && i < maxRow) && ( j >= 0 && j < maxCol ) && ( i != x || j != y ))
                        if (actualBoard[i][j] == 2)   // króra  tym momencie jest elektronem
                            sumHeard++;

            return sumHeard;
        }

        public int[][] updateMatrix () {

            nextIterationBoard = new int[maxRow][maxCol];
            copy_Matrix(actualBoard, nextIterationBoard);

            for (int i = 0; i < maxRow; i++)
                for (int j = 0; j < maxCol; j++) {
                    int sumHeard = 0;
                    sumHeard = countAliveCells(i, j);
                    int data = nextIterationBoard[i][j];
                    switch (data) {
                        case 0:
                            nextIterationBoard[i][j] = 0;
                        case 1:
                            if (sumHeard == 1 || sumHeard == 2)
                                nextIterationBoard[i][j] = 2;  // staje się głową elektronu
                            else if (sumHeard == 0 || sumHeard == 3)
                                nextIterationBoard[i][j] = 1;  // staje się przewodnikiem
                        case 2:
                            nextIterationBoard[i][j] = 3;
                        case 3:
                            nextIterationBoard[i][j] = 1;
                        default:
                            nextIterationBoard[i][j] = 0;
                    }
                }
            copy_Matrix(nextIterationBoard, actualBoard);
                return actualBoard;
        }

        public int[][] getActualBoard () {
            return this.actualBoard;
        }

}