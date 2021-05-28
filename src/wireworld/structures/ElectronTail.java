package wireworld.structures;

public class ElectronTail extends Structure{
    private int  collen;
    private int rowlend;
    private int rowlenup;
    public ElectronTail(int startRow, int startCol) {
        super(startRow, startCol);
    }

    @Override
    public void addstruct(int [][] board)  {
        board[startRow][startCol] = 3;
    }
}
