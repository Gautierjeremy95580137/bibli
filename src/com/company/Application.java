package com.company;
import java.awt.Color;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicBorders;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
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

         Object [][] donnees = {
                 {"Harry Potter","J.K Rowling","Orphelin, le jeune Harry Potter peut enfin quitter ses tyranniques oncle et tante Dursley lorsqu'un curieux messager lui révèle qu'il est un sorcier.","5", "2", "2009"},
                 {"Eragon","C.Paolini","Eragon mène une vie simple, jusqu'au jour où il ramasse dans la forêt une étrange pierre bleue. Le garçon découvre qu'il s'agit d'un œuf et assiste bientôt à la naissance... d'un dragon !","2", "2", "2000"},
                 {"Le Seigneur des anneaux","J.R.R. Tolkien","Aux temps reculés de ce récit, la Terre est peuplée d’innombrables créatures : les Hobbits, apparentés à l’Homme, les Elfes et les Nains vivent en paix dans la Comté. Une paix menacée depuis que l’Anneau de Puissance, forgé par Sauron de Mordor, a été dérobé.","7", "1", "1995"},
                 {"Da Vinci Code","D. Brown","De passage à Paris, Robert Langdon, professeur à Havard et spécialiste de symbologie, est appelé d'urgence au Louvre, en pleine nuit. Jacques Saunière, le conservateur en chef a été retrouvé assassiné au milieu de la Grande Galerie.","4", "3", "2003"},
                 {"Le Petit Prince","S.E Antoine","'J'ai ainsi vécu seul, sans personne avec qui parler véritablement, jusqu'à une panne dans le désert du Sahara, il y a six ans. Quelque chose s'était cassé dans mon moteur. Et comme je n'avais avec moi ni mécanicien, ni passagers, je me préparai à essayer de réussir, tout seul, une réparation difficile.'","9", "5", "1999"}
         };
         String entetes[] = {"Name","Auteur","Résumé","Colonne","Rangée","Parution"};
         JTable tableau = new JTable(donnees,entetes);

         tableau.setPreferredSize(new Dimension(550,150));
         JScrollPane myJScroll = new JScrollPane(tableau);
         //myJScroll.setPreferredSize(new Dimension(550,35));
         myPanel.add(myJScroll);
         // appliquer couleur différente 1 ligne sur 2
         tableau.setDefaultRenderer(Object.class, new MyCellRenderer(tableau.getDefaultRenderer(Object.class)));



         GridBagConstraints gbc = new GridBagConstraints();
/*         gbc.gridx=0;
         gbc.gridy=1;
         gbc.gridheight=5;
         gbc.gridwidth=6;
         myPanel.add(tableau, gbc);*/

        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridheight=8;
        gbc.gridwidth=6;
        myPanel.add(myJScroll, gbc);


         Dimension buttonSize = new Dimension(90,35);
         JButton myBtnAdd = new JButton("Ajouter");
         myBtnAdd.setPreferredSize(buttonSize);
         JButton myBtnEdit = new JButton(new ImageIcon("src/editButton.png"));
         myBtnEdit.setPreferredSize(buttonSize);
         JButton myBtnDelete = new JButton("Supprimer");
         myBtnDelete.setPreferredSize(buttonSize);



        gbc.gridx=3;
        gbc.gridy=9;
        gbc.gridheight=1;
        gbc.gridwidth=1;

        myPanel.add(myBtnAdd, gbc);
       // myBtnAdd.setHorizontalAlignment(SwingConstants.CENTER);

        gbc.gridx = 4;
        myPanel.add(myBtnDelete,gbc);
        //myBtnAdd.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel titre = new JLabel("Titre :");
        JLabel auteur = new JLabel("Auteur :");
        JLabel parution = new JLabel("Parution :");
        JLabel colonne = new JLabel("Colonne :");
        JLabel rangée = new JLabel("Rangée :");
        JLabel resume = new JLabel("Résumé :");

        gbc.gridx = 7;
        gbc.gridy = 1;
        gbc.gridheight=1;
        myPanel.add(titre, gbc);

        gbc.gridy = 2;
        myPanel.add(auteur, gbc);

        gbc.gridy = 3;
        myPanel.add(parution, gbc);

        gbc.gridy = 4;
        myPanel.add(colonne, gbc);

        gbc.gridy = 5;
        myPanel.add(rangée, gbc);

        gbc.gridy = 6;
        myPanel.add(resume, gbc);


        Dimension fieldSize = new Dimension  (150, 20);
        JTextField titreField = new JTextField();
        gbc.gridx = 8;
        gbc.gridy = 1;
        gbc.gridheight=1;
        titreField.setPreferredSize(fieldSize);
        myPanel.add(titreField,gbc);

        JTextField auteurField = new JTextField();
        gbc.gridy = 2;
        auteurField.setPreferredSize(fieldSize);
        myPanel.add(auteurField,gbc);

        JTextField parutionField = new JTextField();
        gbc.gridy = 3;
        parutionField.setPreferredSize(fieldSize);
        myPanel.add(parutionField,gbc);

        JTextField colonneField = new JTextField();
        gbc.gridy = 4;
        colonneField.setPreferredSize(fieldSize);
        myPanel.add(colonneField,gbc);

        JTextField rangeeField = new JTextField();
        gbc.gridy = 5;
        rangeeField.setPreferredSize(fieldSize);
        myPanel.add(rangeeField,gbc);

        Dimension areaSize = new Dimension  (150, 80);
        JTextArea resumerField = new JTextArea();
        gbc.gridy = 6;
        resumerField.setPreferredSize(areaSize);
        myPanel.add(resumerField,gbc);


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
    myWindow.setMinimumSize(new Dimension(1200,800));
    myWindow.setVisible(true);
        };
}
