package wireworld.Automat;

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


    public Automat( int[][] thisBoard) {
        maxRow = thisBoard.length;
        maxCol = thisBoard[maxRow].length;
        actualBoard = new int[maxRow][maxCol];
        copy_Matrix(thisBoard, actualBoard);

        nextIterationBoard = new int[maxRow][maxCol];
        copy_Matrix(actualBoard, nextIterationBoard);
        updateMatrix();
    }

        public void copy_Matrix (int first[][], int second[][]) {
            for ( int i = 0 ; i < first.length; ++i)
                System.arraycopy(first[i], 0, second[i], 0, first[i].length);
        }

        public int countAliveCells ( int x, int y) {   // x i y to współrzędne punktu
            int sumHeard = 0;
            for (int i = x - 1; i < x + 2; i++)       // iteracja po wierszach w sąsiedstwie
                for (int j = y - 1; j < y + 2; j++)   // iteracja po kolumnach w sąsiedstwie
                    if (( i >= 0 && i < maxRow ) && ( j >= 0 && j < maxCol ) && ( i != x || j != y ))
                        if (actualBoard[i][j] == 2)   // króra  tym momencie jest elektronem
                            sumHeard++;

            return sumHeard;
        }

        public void updateMatrix ( ) {
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
                                nextIterationBoard[i][j] = 2;  // staje się elektronem
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
        }

        public int[][] getActualBoard () {
            return actualBoard;
        }

}
