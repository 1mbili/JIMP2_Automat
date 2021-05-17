package wireworld;

import wireworld.Automat.Automat;
import wireworld.structures.*;

import java.util.Arrays;

public class WireworldTest {
    private static int[][] board;

        public static void main(String[] args) {
            Structure_list g = new Structure_list();
            Diode s1 = new Diode(0,3, "Normal");
            Diode s2 = new Diode(0,9, "Reversed");
          //  OR s2 = new OR(2,2);
            g.add(s2);
            g.add(s1);
            XOR s3 = new XOR(2,2);
            AND sA = new AND(2,2);
            NAND s4 = new NAND(2,4);

            board  = new int[16][30];
            int maxRow = board.length;
            int maxCol = board[maxRow - 1].length;
            System.out.println(maxRow);
            System.out.println(maxCol);
            board[7][5] = 3;
            board[0][1] = 2;
            //board = s1.addstruct(board);
            //s.addstruct(board);
            s4.addstruct(board);
            //System.out.println(Arrays.deepToString(board).replace("], ", "],\n"));
//            try {
//                wireworld.structures.Structure_list s = Utils.readFile(Paths.get("").toAbsolutePath().toString()+"\\Test\\TestData");
//                System.out.println(s.size());
//                Utils.writeState(s,board);
//                Utils.writeFile(s,"toDownload\\test2");
//            } catch ( IOException e) {
//            }

            //System.out.println(Arrays.deepToString(board).replace("], ", "],\n"));

            Automat automat = new Automat(board);
            for (int i = 0; i < 4; i++) {
                System.out.println("\n");
                automat.copy_Matrix(automat.getActualBoard(), board);
                System.out.println(Arrays.deepToString(board).replace("], ", "],\n"));
                automat.updateMatrix();
            }
//            Utils.writeState(g,board);


        }
    public static int[][] getBoard() {
        return board;
    }
}
