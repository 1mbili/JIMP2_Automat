import Structures.Dioda;
import Structures.OR;
import Structures.Structure;
import Structures.XOR;

import java.util.Arrays;

public class Wireworld {
        public static void main(String[] args) {
            Structure s = new Structure(2,2);
            Dioda s1 = new Dioda(3,2, "Reversed");
            OR s2 = new OR(2,2);
            XOR s3 = new XOR(2,2);

            int [] [] board  = new int[10][30];
            //board = s1.addstruct(board);
            //s.addstruct(board);
            s3.addstruct(board);
            System.out.println(Arrays.deepToString(board).replace("], ", "]\n"));
        }
}
