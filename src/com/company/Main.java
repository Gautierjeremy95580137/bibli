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

    }

    public static void main(String[] args) {
    Main myWindow = new Main();
    myWindow.pack();
    // rend la fenêtre visible
    myWindow.setVisible(true);
    }

}
