package wireworld.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public abstract class WireworldWindow {
    private JPanel rootPanel;
    private JButton pathButton;
    private JButton startButton;
    private JLabel nameText;
    private JLabel pathText;
    private JFormattedTextField NumberField;
    private JLabel numberIterText;
    private JLabel infoText;

    public WireworldWindow() {

        pathButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser chooser = new JFileChooser();
                int decision = chooser.showOpenDialog(WireworldWindow.this.rootPanel);
                if (decision == JFileChooser.APPROVE_OPTION) {
                    File selected = chooser.getSelectedFile();
                    pathButton.setText("Opening " + selected.getAbsolutePath());
                    WireworldWindow.this.onOpen(selected.getAbsolutePath());
                }
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
    public JPanel getRootPanel() {
        return this.rootPanel;
    }

    public abstract void onOpen(String path);
}
