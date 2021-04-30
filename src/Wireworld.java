import Structures.Dioda;
import Structures.OR;
import Structures.Structure;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;

public class Wireworld {
        public static void main(String[] args) {
            Structure s = new Structure(2,2);
            Dioda s1 = new Dioda(3,2, "Reversed");
            OR s2 = new OR(2,2);

            int board [] [] = new int[10][30];
            //board = s1.addstruct(board);
            //s.addstruct(board);
            s2.addstruct(board);
            System.out.println(Arrays.deepToString(board).replace("], ", "]\n"));;
        }
}
