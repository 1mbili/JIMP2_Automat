package wireworld.structures;

public class AND extends Structure {
    private int collen=14;
    private int rowlend=0;
    private int rowlenup = 7;
    public AND(int startCol, int startRow) {
        super(startCol, startRow);
    }

    @Override
    public void addstruct(int[][] board) {
        int lp =3;
        for (int j=0; j < 4; j+=3)
            for (int i=0; i < lp; i++)
                board[startRow+j][startCol+i] = 1;
        board[startRow+4][startCol+lp] = 1;
        board[startRow+5][startCol+lp] = 1;
        board[startRow+6][startCol+lp] = 1;
        board[startRow+7][startCol+lp+1] = 1;
        board[startRow+6][startCol+lp+2] = 1;
        board[startRow+5][startCol+lp+2] = 1;
        board[startRow+4][startCol+lp+2] = 1;
        board[startRow+3][startCol+lp+3] = 1;
        board[startRow+2][startCol+lp+4] = 1;
        board[startRow+3][startCol+lp+4] = 1;
        board[startRow+4][startCol+lp+4] = 1;
        board[startRow+3][startCol+lp+5] = 1;
        board[startRow+2][startCol+lp+6] = 1;
        board[startRow+4][startCol+lp+6] = 1;
        for (int j=lp;j<lp+7;j++ )
            board[startRow][startCol+j] = 1;
        board[startRow+1][startCol+lp+7] = 1;
        board[startRow+1][startCol+lp+8] = 1;
        board[startRow+1][startCol+lp+9] = 1;
        board[startRow+2][startCol+lp+10] = 1;
        board[startRow+3][startCol+lp+10] = 1;
        board[startRow+4][startCol+lp+10] = 1;
        board[startRow+5][startCol+lp+7] = 1;
        board[startRow+4][startCol+lp+8] = 1;
        board[startRow+5][startCol+lp+8] = 1;
        board[startRow+6][startCol+lp+8] = 1;
        board[startRow+5][startCol+lp+9] = 1;
        board[startRow+6][startCol+lp+10] = 1;
        board[startRow+6][startCol+lp+11] = 1;
        board[startRow+5][startCol+lp+12] = 1;
        board[startRow+4][startCol+lp+13] = 1;
        board[startRow+4][startCol+lp+14] = 1;



    }

}
