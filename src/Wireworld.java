import Structures.*;

import java.util.Arrays;

public class Wireworld {
        public static void main(String[] args) {
            Structure s = new Structure(2,2);
            Dioda s1 = new Dioda(0,3, "Normal");
            Dioda s2 = new Dioda(0,9, "Reversed");
          //  OR s2 = new OR(2,2);
            XOR s3 = new XOR(2,2);
            AND sA = new AND(2,2);
            NAND s4 = new NAND(2,2);


            int [] [] board  = new int[30][30];
            //board = s1.addstruct(board);
            //s.addstruct(board);
            s4.addstruct(board);
            System.out.println(Arrays.deepToString(board).replace("], ", "],\n"));
        }
}
