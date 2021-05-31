package wireworld.structures;

public class Hwire extends Structure {
    private final int endCol;

    public Hwire(int startCol, int startRow, int endCol) {
        super(startCol,startRow);
        this.endCol = endCol;
    }


    @Override
    public void addstruct(int[][] board) {
        int [] boardlen = new int[endCol-startCol];
        for(int i =0; i < endCol-startCol;i++)
            boardlen[i] = 1;
        System.arraycopy(boardlen,0,board[startRow],startCol,endCol-startCol);
    }
}
