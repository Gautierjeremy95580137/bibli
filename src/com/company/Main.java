package com.company;
import javax.swing.JFrame;
public class Main {

    public static void main(String[] args) {
 JFrame fenetre= new JFrame();
        // definition du titre
        fenetre.setTitle("Ma bibliothèque");
        // définit sa taille
        fenetre.setSize(400, 100);
        // nous demandons a notre fenetre de se positionner au centre
        fenetre.setLocationRelativeTo(null);
        //termine le processus avec la croix rouge
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //fenetre visible
        fenetre.setVisible(true);
    }

}
