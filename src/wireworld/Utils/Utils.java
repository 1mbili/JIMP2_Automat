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
            Class<Structure> c = (Class<Structure>) Class.forName(w[0]);
            if (c.getName().equals("wireworld.structures.Diode") && w.length == 4) {
                return c.getDeclaredConstructor(int.class, int.class, String.class).newInstance(Integer.parseInt(w[1]), Integer.parseInt(w[2]), w[3]);
            }
            if (c.getName().matches("wireworld\\.structures\\.(AND|OR|XOR|NAND|ElectronHead|ElectronTail)") && w.length == 3) {
                return c.getDeclaredConstructor(int.class, int.class).newInstance(Integer.parseInt(w[1]), Integer.parseInt(w[2]));
            }
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            System.err.println(e + w[0] + " Brak takiej klasy lub metody");
        } catch (NumberFormatException e) {
            System.err.println("W lini: " + lineorg + " sa smieci");
        }

        return null;
    }
    private static void removeElectron(Structure_list slist){
        int[] mem = new int[slist.size()]; //usuwam electronhead i tail po indeksie
        int c = 0;
        int n = 0;
        for (Structure st : slist) {
            if ((st instanceof ElectronHead || st instanceof ElectronTail)) {
                mem[n++] = c;
                c--;
            }
            c++;
        }
        for (int i : mem)
            if (i != 0)
                slist.remove(i);
    }

    public static int[][] extendBoard(int [][]matrix){
        int rowNumber = matrix.length;
        int colNumber = matrix[0].length;
        int delta = 6;
        int [][] board = new int[rowNumber+delta][colNumber+delta];
        for (int i=0; i < rowNumber;i++)
            System.arraycopy(matrix[i],0, board[i],0,colNumber);
        return board;
    }


    public static int [][] writeBoard(Structure_list slist) {
        int [][]board  = new int[16][16];
        for (Structure st : slist){
            boolean isOutOfBounds =  true;
            while (isOutOfBounds)
                try{
            st.addstruct(board);
            isOutOfBounds= false;
                }
                catch (ArrayIndexOutOfBoundsException e){
                    board=extendBoard(board);}}
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
        removeElectron(slist);
        writeState(slist, board);
        PrintWriter  writer = new PrintWriter (filepath);
        writer.close();
        PrintWriter  writer2 = new PrintWriter (filepath);
        for (Structure st : slist) {
            writer2.write(st + "\n");
        }
        writer2.close();
    }


}