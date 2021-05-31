package wireworld.structures;

public class Vwire extends Structure {
    private final int endRow;

    public Vwire(int startCol, int startRow, int endRow) {
        super(startCol, startRow);
        this.endRow = endRow;
    }


    @Override
    public void addstruct(int[][] board) {
        System.out.println(startRow+";"+endRow+";"+startCol);
        for (int i = startRow; i < endRow;i++){
            System.out.println(i+"h"+startCol);
            board[i][startCol] = 1;
    }
}}
