package Structures;

public class Structure {



    protected int startCol;
    protected int startRow;


    public Structure(int startCol, int startRow) {
        this.startCol = startCol;
        this.startRow = startRow;
    }

    public void addstruct(int [][] board) {}

    @Override
    public String toString() {
        return this.getClass().getName()+": "+startCol+", "+startRow;

    }


}