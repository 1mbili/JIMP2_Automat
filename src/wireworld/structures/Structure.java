package wireworld.structures;

public class Structure {



    protected int startCol;
    protected int startRow;
    private int rowlend;


    public Structure(int startCol, int startRow) {
        this.startCol = startCol;
        this.startRow = startRow;
    }

    public void addstruct(int [][] board) {}

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+": "+startCol+", "+startRow;

    }


}