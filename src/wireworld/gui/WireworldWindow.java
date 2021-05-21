package wireworld.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.util.Scanner;

import static wireworld.gui.ErrorWindow.isInteger;

public abstract class WireworldWindow {
    private JPanel rootPanel;
    private JButton pathButton;
    private JButton startButton;
    private JLabel nameText;
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

        pathButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser chooser = new JFileChooser();
                int decision = chooser.showOpenDialog(WireworldWindow.this.rootPanel);
                if (decision == JFileChooser.APPROVE_OPTION) {
                    selected = chooser.getSelectedFile();
                    pathButton.setText("Opening " + selected.getAbsolutePath());
                    WireworldWindow.this.onOpen(selected.getAbsolutePath());
                }
            }
        });


        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ( isFileEmpty() == true || isInteger(numberField.getText()) == false) { // sprawdza czy są wprowadzone dane, jeśli nie, to tworzy nowe okno
                    javax.swing.SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            JFrame frameErr = new JFrame("Error");
                            frameErr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            frameErr.setPreferredSize(new Dimension(350, 300));
                            frameErr.pack();
                            frameErr.setVisible(true);
                            frame.dispose();

                            // tworzenie obiektu, żeby uruchomić okno
                            ErrorWindow window = new ErrorWindow(frameErr) {

                            };
                        }
                    });
                } else {
                    javax.swing.SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            SecondWindow myWindow = new SecondWindow();
                            JFrame newFrame = new JFrame("Automat");
                            myWindow.setFrame(newFrame);
                            newFrame.setContentPane(myWindow.getSecondPanel());
                            newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            newFrame.setPreferredSize(new Dimension(1024, 768));
                            newFrame.pack();
                            newFrame.setVisible(true);
                            frame.dispose();
                        }
                    });
                }
            }
        });
        numberField = new JTextField(20);
        numberField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                direction = numberField.getText();
                intValue = Integer.parseInt(direction);
            }
        });
    }
    public WireworldWindow() {
    }


    public int getNumberField() {
        return intValue;
    }

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
}