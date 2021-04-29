package Structures;

public class ElectronTail extends Structure{


    public ElectronTail(int startRow, int startCol) {
        super(startRow, startCol);
    }

    @Override
    public int[][] addstruct(int [][] board) {
        board[startCol][startRow] = 3;
        return board;
    }
}
