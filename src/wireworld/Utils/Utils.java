package wireworld.Utils;
import wireworld.structures.*;
import java.io.*;
import java.lang.reflect.InvocationTargetException;

public class Utils {


    public static Structure_list readFile(String path) throws IOException {

        Structure_list s = new Structure_list();
        BufferedReader r = new BufferedReader(new FileReader(path));
        String line;
        Structure tmp;
        while (( line = r.readLine() ) != null) {
            if (( tmp = readStructure(line) ) != null)
                s.add(tmp);
        }
        return s;
    }


    private static Structure readStructure(String lineorg) {
        String line = lineorg.replaceAll(":|,", "");
        String[] w = line.split(" ");
        w[0] = "wireworld.structures." + w[0];

        try {
            Class c = Class.forName(w[0]);
            if (c.getName().equals("wireworld.structures.Diode") && w.length == 4) {
                return (Structure) c.getDeclaredConstructor(int.class, int.class, String.class).newInstance(Integer.parseInt(w[1]), Integer.parseInt(w[2]), w[3]);
            }
            if (c.getName().matches("wireworld\\.structures\\.(Hwire|Vwire)") && w.length == 4) {
                return (Structure) c.getDeclaredConstructor(int.class, int.class, int.class).newInstance(Integer.parseInt(w[1]), Integer.parseInt(w[2]), Integer.parseInt(w[3]));
            }
            if (c.getName().matches("wireworld\\.structures\\.(AND|OR|XOR|NAND|ElectronHead|ElectronTail)") && w.length == 3) {
                return (Structure) c.getDeclaredConstructor(int.class, int.class).newInstance(Integer.parseInt(w[1]), Integer.parseInt(w[2]));
            }
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            System.err.println(e + w[0] + " Brak takiej klasy lub metody");
        } catch (NumberFormatException e) {
            System.err.println("W lini: " + lineorg + " sa smieci");
        }

        return null;
    }

    public static int[][] extendBoard(int [][]matrix){
        int rowNumber = matrix.length;
        int colNumber = matrix[0].length;
        int delta = 4;
        return new int[rowNumber+delta][colNumber+delta];
    }


    public static int [][] writeBoard(Structure_list slist) {
        int [][]board  = new int[16][16];
        boolean isOutOfBounds;
        for (Structure st : slist){
            isOutOfBounds = !st.isOutOfBoard();
            while (isOutOfBounds)
                try{
            st.addstruct(board);
            isOutOfBounds= false;
                }
                catch (ArrayIndexOutOfBoundsException e){
                    board=extendBoard(board);}}
        int rowNumber = board.length;
        int colNumber = board[0].length;
        board = new int[rowNumber][colNumber];
        for (Structure st : slist) {
            if (!st.isOutOfBoard())
            st.addstruct(board);
            else
            System.err.println("Nie można dodać struktury: "+ st+ " Ponieważ jej początkowa pozycaj wiersza jest zbyt mała");
        }
        return board;}

    private static void writeState(Structure_list slist, int[][] board) {
        int rowNumber = board.length; 
        int colNumber = board[0].length;
        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < colNumber; j++)
                if (board[i][j] == 2)
                    slist.add(new ElectronHead(i, j));
                else if (board[i][j] == 3)
                    slist.add(new ElectronTail(i, j));
        }


    }

    public static void writeFile(Structure_list slist, String filepath, int[][] board) throws IOException {
        slist.removeElectron();
        writeState(slist, board);
        PrintWriter  writer = new PrintWriter (filepath);
        for (Structure st : slist) {
            System.out.println(st);
            writer.write(st + "\n");
        }
        writer.close();
    }


}