package wireworld.structures;

public class XOR extends Structure {
    private final int  collen = 11;
    private final int rowlend = -2;
    private final int rowlenup = 4;
    public XOR(int startCol, int startRow) {
        super(startCol, startRow);
    }

    @Override
    public void addstruct(int[][] board) {
        int lp = 3; //liczba przewodników
        for (int i =0; i< 3; i+=2)
            for(int j=0; j< lp; j++)
                board[startRow+i][startCol+j] = 1;
        board[startRow-1][startCol+lp]=1;
        board[startRow-2][startCol+lp+1]=1;
        board[startRow-2][startCol+lp+2]=1;
        board[startRow-1][startCol+lp+3]=1;
        board[startRow+3][startCol+lp]=1;
        board[startRow+4][startCol+lp+1]=1;
        board[startRow+4][startCol+lp+2]=1;
        board[startRow+3][startCol+lp+3]=1;
        board[startRow+1][startCol+lp+2]=1;
        for (int i =0; i< 3; i+=2)
            for(int j=lp+2; j< lp+6; j++)
                board[startRow+i][startCol+j] = 1;
        for(int j=lp+4; j< lp+8; j++)
            board[startRow+1][startCol+j] = 1;

    }
}
