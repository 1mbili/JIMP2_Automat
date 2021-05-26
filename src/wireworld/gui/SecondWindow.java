package wireworld.gui;


import wireworld.*;
import wireworld.Utils.Utils;
import wireworld.structures.Structure_list;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;


public class SecondWindow {
    private JPanel secondPanel;
    private JButton stopButton;
    private JButton nextStepButton;
    private JButton downloadButton;
    private JButton goBackButton;
    private JPanel board;
    private JFrame actual;
    private JFrame frame;

    private int [][] sboard;
    private String path;
    private int numberIter;
    private CheckerBoard checkerBoard;
    private Structure_list g;
    //private Timer timer;

    public SecondWindow() {
        setGoBackButton();
        setStopButton();
        setNextStepButton();
        setDownloadButton();
    }

    // w przypadku lokalnych danych
    public SecondWindow(int numberIter) {
        super();
        this.numberIter = numberIter;
        this.path = "Test/TestData";
        setGoBackButton();
        setStopButton();
        setNextStepButton();
        setDownloadButton();
    }

    // w przypadku danych z pliku komputera
    public SecondWindow(int numberIter, String path) {
        super();
        this.path = path;
        this.numberIter = numberIter;
        setGoBackButton();
        setStopButton();
        setNextStepButton();
        setDownloadButton();
    }

    private void createUIComponents () throws IOException, InterruptedException {
        System.out.println(path);
        g = Utils.readFile(path);
        sboard = Utils.writeBoard(g, new int[32][32]);
        System.out.println(Arrays.deepToString(sboard).replace("], ", "],\n"));
        checkerBoard = new CheckerBoard(sboard, numberIter);
        board = checkerBoard;
    }

    public void setDownloadButton () {
        downloadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Utils.writeFile(g, "Test/TestOutput", checkerBoard.getMatrixBoard());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
    }
    public void setStopButton () {
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkerBoard.setInterrupted(true);

            }
        });
    }

    public void setNextStepButton () {
        nextStepButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkerBoard.setInterrupted(false);
            }
        });
    }

    public void setGoBackButton () {
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame = new JFrame("Wireworld GUI");
                WireworldWindow window = new WireworldWindow(frame) {
                    @Override
                    public void onOpen(String path) {
                    }

                    @Override
                    public void getIt(int itnr) {
                    }

                };
                actual.dispose();
            }
        });
    }

    public JPanel getSecondPanel() {
        return this.secondPanel;
    }

    public void setFrame(JFrame fr) {
        this.actual = fr;
    }

    public JFrame getFrameInstance () {
        return this.frame;
    }

}

