package wireworld.structures;

public class ElectronHead extends Structure{
    private int  collen=0;
    private int rowlend=0;
    private int rowlenup=0;
    public ElectronHead(int startCol, int startRow) {
        super(startCol, startRow);
    }

    @Override
    public void addstruct(int [][] board) {
        board[startRow][startCol] = 2;

    }





}
