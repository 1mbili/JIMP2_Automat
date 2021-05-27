package wireworld.Utils;


import wireworld.structures.*;


import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

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

    public static int[][] writeBoard(Structure_list slist, int[][] board) {
        // Nie można usuwać podczas iteracji, kod do porawy niezbyt elegancko to wygląda.
        int[] mem = new int[slist.size()]; //usuwam electronhead i tail po indeksie
        int c = 0;
        int n = 0;
        for (Structure st : slist) {
            st.addstruct(board);
            if ((st instanceof ElectronHead || st instanceof ElectronTail)) {
                mem[n++] = c;
                c--;
            }
            c++;
        }
        for (int i : mem)
            if (i != 0)
                slist.remove(i);
        return board;
    }
    public static int[][] writeBoard2(Structure_list slist, int[][] board) {
        // Nie można usuwać podczas iteracji, kod do porawy niezbyt elegancko to wygląda.
         Structure_list tmp = new Structure_list();
        for (Structure st : slist) {
            st.addstruct(board);
            if (!(st instanceof ElectronHead || st instanceof ElectronTail)) {
                tmp.add(st);
            }
        }
        return board;
    }

    private static void writeState(Structure_list slist, int[][] board) {
        int rownum = board.length;
        int colnum = board[0].length;
        for (int i = 0; i < rownum; i++) {
            for (int j = 0; j < colnum; j++)
                if (board[i][j] == 2)
                    slist.add(new ElectronHead(i, j));
                else if (board[i][j] == 3)
                    slist.add(new ElectronTail(i, j));
        }


    }


    public static void writeFile(Structure_list slist, String filepath, int[][] board) throws IOException {
        writeState(slist, board);
        FileWriter writer = new FileWriter(filepath);
        for (Structure st : slist) {
            writer.write(st + "\n");
        }
        writer.close();
    }


}