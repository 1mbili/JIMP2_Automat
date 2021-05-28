package wireworld.gui;


import javax.swing.*;
import java.awt.*;
import java.io.File;


import static wireworld.gui.ErrorWindow.isInteger;

public abstract class WireworldWindow {
    private JPanel rootPanel;
    private JButton pathButton;
    private JButton startButton;
    private JLabel nameText;        // bez tych zmiennych nie można uruchomić programu
    private JLabel pathText;
    private JLabel numberIterText;
    private JLabel infoText;
    private JTextField numberField;
    private JFrame frame;
    private File selected;

    private String direction;
    private int intValue;


    public WireworldWindow(JFrame oldframe) {
        this.frame = oldframe;
        frame.setContentPane(getRootPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1024, 768));
        frame.pack();
        frame.setVisible(true);


        pathButton.addActionListener(actionEvent -> {
            JFileChooser chooser = new JFileChooser();
            int decision = chooser.showOpenDialog(WireworldWindow.this.rootPanel);
            if (decision == JFileChooser.APPROVE_OPTION) {
                selected = chooser.getSelectedFile();
                pathButton.setText("Opening " + selected.getAbsolutePath());
                WireworldWindow.this.onOpen(selected.getAbsolutePath());
                File f = chooser.getSelectedFile();
                System.out.println(f.getPath());
                direction = f.getPath();
            }
        });
        // używa się lambda
        numberField.addActionListener(e -> {
            String text;
            text = numberField.getText();
            intValue = Integer.parseInt(text);
            WireworldWindow.this.getNumberIter(intValue);
        });

        startButton.addActionListener(e -> {
            if (!isInteger(numberField.getText())) { // sprawdza czy są wprowadzone dane, jeśli nie, to tworzy nowe okno
                SwingUtilities.invokeLater(() -> {
                    System.out.println(numberField.getText());
                    JFrame frameErr = new JFrame("Error");
                    frameErr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frameErr.setPreferredSize(new Dimension(350, 300));
                    frameErr.pack();
                    frameErr.setVisible(true);

                    // tworzenie obiektu, żeby uruchomić okno
                    ErrorWindow window = new ErrorWindow(frameErr);
                });
            } else {
                SwingUtilities.invokeLater(() -> {
                    SecondWindow myWindow;
                    if(isFileEmpty())
                        myWindow = new SecondWindow(intValue);
                    else
                        myWindow = new SecondWindow(intValue, direction);
                    JFrame newFrame = new JFrame("Automat");
                    myWindow.setFrame(newFrame);
                    newFrame.setContentPane(myWindow.getSecondPanel());
                    newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    newFrame.setPreferredSize(new Dimension(1024, 768));
                    newFrame.pack();
                    newFrame.setVisible(true);
                    frame.dispose();
                });
            }
        });
    }
    public WireworldWindow() { }

    public boolean isFileEmpty() {
        return selected == null;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
    public JPanel getRootPanel() {
        return this.rootPanel;
    }


    public abstract void onOpen(String path);

    public abstract void getNumberIter(int numberIter);

}