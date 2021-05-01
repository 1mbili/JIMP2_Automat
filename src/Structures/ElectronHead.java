package Structures;

public class ElectronHead extends Structure{

    public ElectronHead(int startRow, int startCol) {
        super(startRow, startCol);
    }

    @Override
    public void addstruct(int [][] board) {
        board[startCol][startRow] = 2;

    }





}
