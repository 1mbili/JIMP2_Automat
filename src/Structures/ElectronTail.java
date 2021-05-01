package Structures;

public class ElectronTail extends Structure{


    public ElectronTail(int startRow, int startCol) {
        super(startRow, startCol);
    }

    @Override
    public void addstruct(int [][] board)  {
        board[startCol][startRow] = 3;
    }
}
