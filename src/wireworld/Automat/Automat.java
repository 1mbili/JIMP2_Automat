package wireworld.Automat;

import javax.swing.*;
import java.awt.*;

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

    public Automat() {
        maxRow = actualBoard.length - 1;
        maxCol = actualBoard[maxRow].length - 1;
    }

    public int countAliveCells (int x, int y) {   // x i y to współrzędne punktu
        int sumAlive = 0;
        for (int i = x - 1; i < x + 2; i++)       // iteracja po wierszach w sąsiedstwie
            for (int j = y - 1; j < y + 2; j++)   // iteracja po kolumnach w sąsiedstwie
                if (( i >= 0 && i < maxRow ) && ( j >= 0 && j < maxCol ) && ( i != x || j != y ))
                    if (actualBoard[i][j] == 2)   // króra  tym momencie jest elektronem
                        sumAlive++;
                    return sumAlive;
    }

    public int[][] updateMatrix (int x, int y) {
        for (int i = 0; i < maxRow; i++)
            for (int j = 0; j < maxCol; j++) {
                int sumAlive = 0;
                sumAlive = countAliveCells(i, j);
                int data = actualBoard[i][j];
                switch(data) {
                    case 0:
                        actualBoard[i][j] = 0;
                    case 1:
                        if (sumAlive == 1 || sumAlive == 2)
                            actualBoard[i][j] = 2;  // staje się elektronem
                        if (actualBoard[i][j] == 0 || sumAlive == 3)
                            actualBoard[i][j] = 1;  // staje się przewodnikiem
                    case 2:
                        actualBoard[i][j] = 3;
                    case 3:
                        actualBoard[i][j] = 1;
                    default:
                        break;
                }
            }
        nextIterationBoard = actualBoard;
        return nextIterationBoard;
    }

    public void getActualBoard (int [][] thisBoard) {
        this.actualBoard = thisBoard;
    }
}

/*

        }
        else	{
            int i = x;
            int j = y;

            i = x + 1;
            j = y;
            if ( (i >= 0 && i < mat->row) && (j >= 0 && j < mat->col))
                if(mat->data[i][j] == 1 || mat->data[i][j] == 3 )   // króra  tym momencie jest żywa
                    sumAlive++;

            i = x - 1;
            j = y;
            if ( (i >= 0 && i < mat->row) && (j >= 0 && j < mat->col))
                if(mat->data[i][j] == 1 || mat->data[i][j] == 3 )   // króra  tym momencie jest żywa
                    sumAlive++;

            i = x;
            j = y - 1;
            if ( (i >= 0 && i < mat->row) && (j >= 0 && j < mat->col))
                if(mat->data[i][j] == 1 || mat->data[i][j] == 3 )   // króra  tym momencie jest żywa
                    sumAlive++;
            i = x;
            j = y + 1;
            if ( (i >= 0 && i < mat->row) && (j >= 0 && j < mat->col))
                if(mat->data[i][j] == 1 || mat->data[i][j] == 3 )   // króra  tym momencie jest żywa
                    sumAlive++;
        }
        return sumAlive;
    }

Mat* updateMatrix (Mat *mat, int type) {
        Mat *matTemp = createMatrix (mat -> row, mat -> col);
        //matTemp = mat;

        for (int i = 0; i < mat->row; i++)
        for (int j = 0; j < mat->col; j++)
        matTemp -> data[i][j] = mat -> data[i][j];

        int sumAlive = 0;
        for (int i = 0; i < matTemp -> row; i++)
        for (int j = 0; j < matTemp -> col; j++) {
        sumAlive = countAliveCells(matTemp, i, j, type);
            if (matTemp -> data[i][j] == 1 && (sumAlive != 2 && sumAlive != 3))
            matTemp -> data[i][j] = 3;  //ginie

        if (matTemp -> data[i][j] == 0 && sumAlive == 3)
        matTemp -> data[i][j] = 2;   //rodzi się
        }
        matTemp = fixMatrix(matTemp);
        return matTemp;
        }

        Mat* fixMatrix (Mat *mat) {
        for (int i = 0; i < mat->row; i++)
        for (int j = 0; j < mat->col; j++) {
        if (mat->data[i][j] == 2)
        mat->data[i][j] = 1;
        if (mat->data[i][j] == 3)
        mat->data[i][j] = 0;
        }
        return mat;
        }
*/
