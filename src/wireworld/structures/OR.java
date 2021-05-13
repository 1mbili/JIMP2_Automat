package wireworld.structures;

public class OR extends Structure {
    public OR(int startCol, int startRow) {
        super(startCol, startRow);
    }

    @Override
    public void addstruct(int [][] board) {
        int lp = 3; //liczba przewodnikw;
        // dwa przewody po 3 przewodniki
        for (int i = 0 ; i < 3; i+=2)
            for(int j = 0; j < lp; j++)
                board[startRow+i][startCol+j] = 1;
            //wzór bramki

        board[startRow-1][startCol+lp] = 1;
        board[startRow-1][startCol+lp+1] = 1;
        board[startRow+3][startCol+lp] = 1;
        board[startRow+3][startCol+lp+1] = 1;
        board[startRow+2][startCol+lp+2] = 1;
        board[startRow][startCol+lp+2] = 1;

        for(int i =lp+1; i < 2*lp+3 ; i++)
            board[startRow+1][startCol+i] = 1;

    }

}
