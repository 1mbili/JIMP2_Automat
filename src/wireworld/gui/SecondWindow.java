package wireworld.gui;

import wireworld.Utils.Utils;
import wireworld.structures.Structure_list;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class SecondWindow {
    private JPanel secondPanel;
    private JButton stopButton;
    private JButton nextStepButton;
    private JButton downloadButton;
    private JButton goBackButton;
    private JPanel board;
    private JFrame actual;
    private JFrame frame;

    private int[][] sboard;
    private final String path;
    private final int numberIter;
    private CheckerBoard checkerBoard;
    private Structure_list g;
    private String fileName = null;

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

    private void createUIComponents() throws IOException {
        System.out.println(path);
        g = Utils.readFile(path);
        sboard = Utils.writeBoard(g);
        checkerBoard = new CheckerBoard(sboard, numberIter);
        board = checkerBoard;
    }

    public void setDownloadButton() {
        downloadButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int returnVal = fileChooser.showOpenDialog((Component) e.getSource());
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    fileName = file.toString();
                } catch (Exception ex) {
                    System.out.println("problem accessing file" + file.getAbsolutePath());
                }
            } else {
                System.out.println("File access cancelled by user.");
            }

            try {
                Utils.writeFile(g, fileName, checkerBoard.getMatrixBoard());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
    }

    public void setStopButton() {
        stopButton.addActionListener(e -> checkerBoard.setInterrupted(true));
    }

    public void setNextStepButton() {
        nextStepButton.addActionListener(e -> checkerBoard.setInterrupted(false));
    }

    public void setGoBackButton() {
        goBackButton.addActionListener(e -> {
            frame = new JFrame("Wireworld GUI");
            WireworldWindow window = new WireworldWindow(frame) {
                @Override
                public void onOpen(String path) {
                }

                @Override
                public void getNumberIter(int itnr) {
                }

            };
            actual.dispose();
        });
    }

    public JPanel getSecondPanel() {
        return this.secondPanel;
    }

    public void setFrame(JFrame fr) {
        this.actual = fr;
    }

}

