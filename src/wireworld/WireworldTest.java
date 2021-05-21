package wireworld;

import wireworld.Automat.Automat;
import wireworld.Utils.Utils;
import wireworld.structures.*;

import java.io.IOException;
import java.util.Arrays;

public class WireworldTest {
        private final int [][]board;

        public  WireworldTest() throws IOException {
            Structure_list g = Utils.readFile("Test/TestData");
            board = Utils.writeBoard(g,new int[32][32]);
            System.out.println(Arrays.deepToString(board).replace("], ", "],\n"));
        }
        public int [][] getBoard(){
            return this.board;
        }

}
