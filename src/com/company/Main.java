package com.company;
import javax.swing.*;
import java.awt.*;

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
        JMenuItem open = new JMenuItem("Ouvrir");
        file.add(open);


        GridBagLayout myLayout = new GridBagLayout();
        myPanel.setLayout(myLayout);

    }

    public static void main(String[] args) {
    Main myWindow = new Main();
    myWindow.pack();
    // rend la fenêtre visible
    myWindow.setSize(500,400);
    myWindow.setVisible(true);
    }

}
