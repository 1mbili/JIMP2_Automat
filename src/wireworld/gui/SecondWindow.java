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
    public volatile boolean isInterrupted = false;
    private CheckerBoard checkerBoard;
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
        Structure_list g = Utils.readFile(path);
        sboard = Utils.writeBoard(g, new int[32][32]);
        System.out.println(Arrays.deepToString(sboard).replace("], ", "],\n"));
        board = new CheckerBoard(sboard, numberIter, isInterrupted);
    }
    public void setDownloadButton () {
        downloadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    public void setStopButton () {
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isInterrupted = true;
                System.out.println("Przycisk stop");

            }
        });
    }

    public void setNextStepButton () {
        nextStepButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isInterrupted = false;
                System.out.println("Przycisk step");
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

    public boolean getIsInterrupted() {
        return this.isInterrupted;
    }

    public JFrame getFrameInstance () {
        return this.frame;
    }

}

