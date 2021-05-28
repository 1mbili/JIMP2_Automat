package wireworld.structures;

public class ElectronTail extends Structure{
    private int  collen = 0;
    private final int rowlend = 0;
    private final int rowlenup = 0;
    public ElectronTail(int startRow, int startCol) {
        super(startRow, startCol);
    }

    @Override
    public void addstruct(int [][] board)  {
        board[startRow][startCol] = 3;
    }
}
