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
            }
        });

         GridBagLayout myLayout = new GridBagLayout();
         myPanel.setLayout(myLayout);
         GridBagConstraints gbc = new GridBagConstraints();
         Object [] [] donnees= {{"test","test","test","test", "test", "test"}};
         String entetes[] = {"Name","Auteur","Résumé","Colonne","Rangée","Parution"};
         JTable tableau = new JTable(donnees,entetes);
         getContentPane().add((new JScrollPane(tableau.getTableHeader())));
         gbc.gridx=0;
         gbc.gridy=1;
         gbc.gridheight=1;
         gbc.gridwidth=1;
         myPanel.add(tableau, gbc);


        }

    public static void main(String[] args) {
    Main myWindow = new Main();
    myWindow.pack();
    // rend la fenêtre visible
    myWindow.setSize(500,400);
    myWindow.setVisible(true);



        };
}
