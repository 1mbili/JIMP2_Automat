package wireworld.structures;


public class Diode extends Structure {

    private final String type;
    private int collen = 2;
    private int rowlend = -1;
    private int rowlenup = 1;

    public Diode(int startCol, int startRow, String type) {
        super(startCol, startRow);
        this.type = type;
    }

    @Override
    public void addstruct(int [][] board) {
        int lp = 6; //liczba przewodnikw
        // Sześć przewodników
        for (int i = 0; i < lp; i++)
            board[startRow][startCol + i] = 1;

        // robie prostokąt 2x3 i zamieniam na 0 jedno pole w zależności odd typu diody
        for (int j = 0; j < 2; j++)
            for (int i = -1; i < 2; i++)
                board[startRow + i][startCol + j + lp] = 1;
        String typed = "Reversed";
        if (type.equals(typed)) {
            board[startRow][startCol + lp] = 0;
        } else {
            board[startRow][startCol + lp + 1] = 0;
        }

        // Sześć przewodników
        for (int i = lp + 2; i < 2 * lp + 2; i++)
            board[startRow][startCol + i] = 1;

    }
    @Override
    public String toString() {
        return this.getClass().getSimpleName()+": "+startCol+", "+startRow+", "+type;

    }

}
