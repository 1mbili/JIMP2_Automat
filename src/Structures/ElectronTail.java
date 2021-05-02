package Structures;

public class ElectronTail extends Structure{
    public ElectronTail(int startCol, int startRow) {
        super(startCol, startRow);
    }

    @Override
    public void addstruct(int [][] board)  {
        board[startCol][startRow] = 3;
    }
}
