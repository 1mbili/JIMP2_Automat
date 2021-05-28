package wireworld;

import wireworld.Automat.Automat;
import wireworld.Utils.Utils;
import wireworld.gui.WireworldWindow;
import wireworld.structures.*;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Main {
    private static int numberIteration;
    private static WireworldWindow window;
    private static String pathA;

    public static void main(String[] args) {

        // wywołanie okna, które uruchamia program
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Wireworld GUI");
                window = new WireworldWindow(frame) {
                    @Override
                    public void onOpen(String path) {
                        pathA = path;
                    }
                    @Override
                    public void getNumberIter(int itnr) {
                        numberIteration = itnr;
                    }
                };
            }});


    }
}

