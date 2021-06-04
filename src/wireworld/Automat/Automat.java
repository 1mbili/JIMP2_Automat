package wireworld.Automat;

/* stany:
 0 - puste
 1 - przewodnik
 2 - głowa elektronu
 3 - ogon elektronu
*/

public class Automat {
    private final int [][] actualBoard;
    private int [][] nextIterationBoard;
    private final int maxRow;
    private final int maxCol;


    public Automat( int[][] thisBoard) {

        maxRow = thisBoard.length;
        maxCol = thisBoard[maxRow - 1].length;
        actualBoard = new int[maxRow][maxCol];
        copy_Matrix(thisBoard, actualBoard);
    }

        public void copy_Matrix (int[][] first, int[][] second) {
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
                            break;
                        case 1:
                            if (sumHeard == 1 || sumHeard == 2)
                                nextIterationBoard[i][j] = 2;  // staje się głową elektronu
                            else if (sumHeard == 0 || sumHeard == 3)
                                nextIterationBoard[i][j] = 1;  // staje się przewodnikiem
                            break;
                        case 2:
                            nextIterationBoard[i][j] = 3;
                            break;
                        case 3:
                            nextIterationBoard[i][j] = 1;
                            break;
                        default:
                            nextIterationBoard[i][j] = 0;
                            break;
                    }
                }
            copy_Matrix(nextIterationBoard, actualBoard);
                return actualBoard;
        }

}