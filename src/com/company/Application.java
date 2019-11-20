package com.company;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FilenameFilter;

public class Application extends JFrame{
    /**
     *
     */
    File myFile =null;
    public Application(){
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

        open.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter myFileFilterXML = new FileNameExtensionFilter("Seulement des fichiers XML", "xml");
                fileChooser.setFileFilter(myFileFilterXML);
                fileChooser.showOpenDialog(null);
                myFile = fileChooser.getSelectedFile();
                System.out.println(myFile.getAbsolutePath());
                loadFile(myFile);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

         GridBagLayout myLayout = new GridBagLayout();
         myPanel.setLayout(myLayout);

         Object [] [] donnees= {{"test","test","test","test", "test", "test"},
                 {"test","test","test","test", "test", "test"}};
         String entetes[] = {"Name","Auteur","Résumé","Colonne","Rangée","Parution"};
         JTable tableau = new JTable(donnees,entetes);
         Dimension mySize = new Dimension(550,40);
         tableau.setMinimumSize(mySize);
         JScrollPane myJScroll = new JScrollPane((tableau.getTableHeader()));
         myJScroll.setMinimumSize(mySize);
         getContentPane().add(myJScroll);


         GridBagConstraints gbc = new GridBagConstraints();
         gbc.gridx=0;
         gbc.gridy=1;
         gbc.gridheight=2;
         gbc.gridwidth=1;
         myPanel.add(tableau, gbc);
         JButton myBtnAdd = new JButton("Ajouter");
         JButton myBtnEdit = new JButton("Modifier");
         JButton myBtnDelete = new JButton("Supprimer");


        gbc.gridx=1;
        gbc.gridy=0;
        gbc.gridheight=1;
        myPanel.add(myBtnAdd, gbc);

        gbc.gridy=1;
        myPanel.add(myBtnEdit, gbc);

        gbc.gridy=2;
        myPanel.add(myBtnDelete,gbc);

        }

    /**
     * Dans cette méthode on récupérera via JaxB les infos
     * contenus dans le fichier
     * @param myFile
     */
    private void loadFile(File myFile) {


    }

    public static void main(String[] args) {
    Application myWindow = new Application();
    myWindow.pack();
    // rend la fenêtre visible
    myWindow.setSize(800,600);
    myWindow.setVisible(true);



        };
}
