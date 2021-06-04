package wireworld.structures;

public class Vwire extends Structure {
    private final int endRow;

    public Vwire(int startCol, int startRow, int endRow) {
        super(startCol, startRow);
        this.endRow = endRow;
    }


    @Override
    public void addstruct(int[][] board) {
        for (int i = startRow; i < endRow;i++){
            board[i][startCol] = 1;
    }
}}
