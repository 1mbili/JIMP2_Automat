import Structures.*;
import Utils.*;

import java.io.IOException;
import java.nio.file.Paths;

public class WireworldTest {
        public static void main(String[] args) {
            Structure_list g = new Structure_list();
            Diode s1 = new Diode(0,3, "Normal");
            Diode s2 = new Diode(0,9, "Reversed");
          //  OR s2 = new OR(2,2);

            XOR s3 = new XOR(2,2);
            AND sA = new AND(2,2);
            NAND s4 = new NAND(2,2);


            int [] [] board  = new int[30][30];
            //board = s1.addstruct(board);
            //s.addstruct(board);
            s4.addstruct(board);
            //System.out.println(Arrays.deepToString(board).replace("], ", "],\n"));
            try {
                Structure_list s = Utils.readFile(Paths.get("").toAbsolutePath().toString()+"\\Test\\TestData");
                Utils.writeFile(s,"toDownload\\test2");
            } catch ( IOException e) {
            }

        }
}
