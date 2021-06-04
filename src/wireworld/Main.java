package wireworld;

import wireworld.gui.WireworldWindow;

import javax.swing.*;

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

