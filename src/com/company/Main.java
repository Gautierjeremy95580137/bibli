package com.company;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main extends JFrame{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Main(){
        super("Bibliothèque");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JPanel myPanel = new JPanel();
        this.setContentPane(myPanel);
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        JMenu file = new JMenu("Fichier");
        menuBar.add(file);
        JMenuItem open = new JMenuItem("Ouvrir...");
        file.add(open);

        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Ouvrir un fichier");
                FileNameExtensionFilter xmlFilter = new FileNameExtensionFilter(
                        "xml files", "xml");

                fileChooser.setFileFilter(xmlFilter);
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    System.out.println("You chose to open this file: " +
                            fileChooser.getSelectedFile().getName());
                }
            }
        });



        GridBagLayout myLayout = new GridBagLayout();
        myPanel.setLayout(myLayout);

    }

    public static void main(String[] args) {
    Main myWindow = new Main();
    myWindow.pack();
    // rend la fenêtre visible
    myWindow.setSize(500,400);
    myWindow.setVisible(true);


        };
}
