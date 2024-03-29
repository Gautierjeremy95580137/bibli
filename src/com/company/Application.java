package com.company;
import java.awt.Color;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicBorders;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FilenameFilter;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;

public class Application extends JFrame{
    /**
     *
     */


    public Application(){
        super("Bibliothèque");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JPanel myPanel = new JPanel();
        this.setContentPane(myPanel);
        //barre de menu
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        // sous menu
        JMenu file = new JMenu("Fichier");
        menuBar.add(file);
        JMenu edit = new JMenu("Edition");
        menuBar.add(edit);
        JMenu about = new JMenu("A propos");
        menuBar.add(about);
        // sous menus
        JMenuItem open = new JMenuItem("Ouvrir...");
        file.add(open);
        JMenuItem quit = new JMenuItem("Quitter");
        file.add(quit);

        about.addMouseListener(new MouseListener() {
            @Override
            /**
             * Un clic sur le menu "A propos" affiche une boîte de dialogue contenant le n° de version et les créateurs de l'application
             */
            public void mouseClicked(MouseEvent e) {
                JOptionPane jop = new JOptionPane();
                ImageIcon imgUnicorn = new ImageIcon("src/unicorn-2.png");
                jop.showMessageDialog(null,"Version 1.0 \nIvann, Jérémy, Laurent","Informations", JOptionPane.INFORMATION_MESSAGE, imgUnicorn);

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {


            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        open.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            /**
             * Un clic sur le sous-menu "Ouvrir..." ouvre un explorateur de fichier permettant de ne sélectionn er que des fichiers à l'extension .xml
             */
            public void mouseReleased(MouseEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter myFileFilterXML = new FileNameExtensionFilter("Seulement des fichiers XML", "xml");
                fileChooser.setFileFilter(myFileFilterXML);
                fileChooser.showOpenDialog(null);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        quit.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            /**
             * Un clic sur le sous-menu "quitter" ferme l'application
             */
            public void mouseReleased(MouseEvent e) {
                dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        // Nouveau GridBagLayout pour pouvoir manipuler les objets et les déplacer
        GridBagLayout myLayout = new GridBagLayout();
        myPanel.setLayout(myLayout);

        String [][] donnees = {
                {"Harry Potter","J.K Rowling","Orphelin, le jeune Harry Potter peut enfin quitter ses tyranniques oncle et tante Dursley lorsqu'un curieux messager lui révèle qu'il est un sorcier.","5", "2", "2009"},
                {"Eragon","C.Paolini","Eragon mène une vie simple, jusqu'au jour où il ramasse dans la forêt une étrange pierre bleue. Le garçon découvre qu'il s'agit d'un œuf et assiste bientôt à la naissance... d'un dragon !","2", "2", "2000"},
                {"Le Seigneur des anneaux","J.R.R. Tolkien","Aux temps reculés de ce récit, la Terre est peuplée d’innombrables créatures : les Hobbits, apparentés à l’Homme, les Elfes et les Nains vivent en paix dans la Comté. Une paix menacée depuis que l’Anneau de Puissance, forgé par Sauron de Mordor, a été dérobé.","7", "1", "1995"},
                {"Da Vinci Code","D. Brown","De passage à Paris, Robert Langdon, professeur à Havard et spécialiste de symbologie, est appelé d'urgence au Louvre, en pleine nuit. Jacques Saunière, le conservateur en chef a été retrouvé assassiné au milieu de la Grande Galerie.","4", "3", "2003"},
                {"Le Petit Prince","S.E Antoine","'J'ai ainsi vécu seul, sans personne avec qui parler véritablement, jusqu'à une panne dans le désert du Sahara, il y a six ans. Quelque chose s'était cassé dans mon moteur. Et comme je n'avais avec moi ni mécanicien, ni passagers, je me préparai à essayer de réussir, tout seul, une réparation difficile.'","1", "5", "1999"},
                {"Eragon","C.Paolini","Eragon mène une vie simple, jusqu'au jour où il ramasse dans la forêt une étrange pierre bleue. Le garçon découvre qu'il s'agit d'un œuf et assiste bientôt à la naissance... d'un dragon !","2", "2", "2000"},
                {"Le Seigneur des anneaux","J.R.R. Tolkien","Aux temps reculés de ce récit, la Terre est peuplée d’innombrables créatures : les Hobbits, apparentés à l’Homme, les Elfes et les Nains vivent en paix dans la Comté. Une paix menacée depuis que l’Anneau de Puissance, forgé par Sauron de Mordor, a été dérobé.","7", "1", "1995"},
                {"Da Vinci Code","D. Brown","De passage à Paris, Robert Langdon, professeur à Havard et spécialiste de symbologie, est appelé d'urgence au Louvre, en pleine nuit. Jacques Saunière, le conservateur en chef a été retrouvé assassiné au milieu de la Grande Galerie.","4", "3", "2003"},
                {"Eragon","C.Paolini","Eragon mène une vie simple, jusqu'au jour où il ramasse dans la forêt une étrange pierre bleue. Le garçon découvre qu'il s'agit d'un œuf et assiste bientôt à la naissance... d'un dragon !","2", "2", "2000"},
                {"Le Seigneur des anneaux","J.R.R. Tolkien","Aux temps reculés de ce récit, la Terre est peuplée d’innombrables créatures : les Hobbits, apparentés à l’Homme, les Elfes et les Nains vivent en paix dans la Comté. Une paix menacée depuis que l’Anneau de Puissance, forgé par Sauron de Mordor, a été dérobé.","7", "1", "1995"},
                {"Da Vinci Code","D. Brown","De passage à Paris, Robert Langdon, professeur à Havard et spécialiste de symbologie, est appelé d'urgence au Louvre, en pleine nuit. Jacques Saunière, le conservateur en chef a été retrouvé assassiné au milieu de la Grande Galerie.","4", "3", "2003"},
                {"Eragon","C.Paolini","Eragon mène une vie simple, jusqu'au jour où il ramasse dans la forêt une étrange pierre bleue. Le garçon découvre qu'il s'agit d'un œuf et assiste bientôt à la naissance... d'un dragon !","2", "2", "2000"},
                {"Le Seigneur des anneaux","J.R.R. Tolkien","Aux temps reculés de ce récit, la Terre est peuplée d’innombrables créatures : les Hobbits, apparentés à l’Homme, les Elfes et les Nains vivent en paix dans la Comté. Une paix menacée depuis que l’Anneau de Puissance, forgé par Sauron de Mordor, a été dérobé.","7", "1", "1995"},
                {"Da Vinci Code","D. Brown","De passage à Paris, Robert Langdon, professeur à Havard et spécialiste de symbologie, est appelé d'urgence au Louvre, en pleine nuit. Jacques Saunière, le conservateur en chef a été retrouvé assassiné au milieu de la Grande Galerie.","4", "3", "2003"},
                {"Eragon","C.Paolini","Eragon mène une vie simple, jusqu'au jour où il ramasse dans la forêt une étrange pierre bleue. Le garçon découvre qu'il s'agit d'un œuf et assiste bientôt à la naissance... d'un dragon !","2", "2", "2000"},
                {"Le Seigneur des anneaux","J.R.R. Tolkien","Aux temps reculés de ce récit, la Terre est peuplée d’innombrables créatures : les Hobbits, apparentés à l’Homme, les Elfes et les Nains vivent en paix dans la Comté. Une paix menacée depuis que l’Anneau de Puissance, forgé par Sauron de Mordor, a été dérobé.","7", "1", "1995"},
                {"Da Vinci Code","D. Brown","De passage à Paris, Robert Langdon, professeur à Havard et spécialiste de symbologie, est appelé d'urgence au Louvre, en pleine nuit. Jacques Saunière, le conservateur en chef a été retrouvé assassiné au milieu de la Grande Galerie.","4", "3", "2003"},
                {"Eragon","C.Paolini","Eragon mène une vie simple, jusqu'au jour où il ramasse dans la forêt une étrange pierre bleue. Le garçon découvre qu'il s'agit d'un œuf et assiste bientôt à la naissance... d'un dragon !","2", "2", "2000"},
                {"Le Seigneur des anneaux","J.R.R. Tolkien","Aux temps reculés de ce récit, la Terre est peuplée d’innombrables créatures : les Hobbits, apparentés à l’Homme, les Elfes et les Nains vivent en paix dans la Comté. Une paix menacée depuis que l’Anneau de Puissance, forgé par Sauron de Mordor, a été dérobé.","7", "1", "1995"},
                {"Da Vinci Code","D. Brown","De passage à Paris, Robert Langdon, professeur à Havard et spécialiste de symbologie, est appelé d'urgence au Louvre, en pleine nuit. Jacques Saunière, le conservateur en chef a été retrouvé assassiné au milieu de la Grande Galerie.","4", "3", "2003"},
                {"Eragon","C.Paolini","Eragon mène une vie simple, jusqu'au jour où il ramasse dans la forêt une étrange pierre bleue. Le garçon découvre qu'il s'agit d'un œuf et assiste bientôt à la naissance... d'un dragon !","2", "2", "2000"},
                {"Le Seigneur des anneaux","J.R.R. Tolkien","Aux temps reculés de ce récit, la Terre est peuplée d’innombrables créatures : les Hobbits, apparentés à l’Homme, les Elfes et les Nains vivent en paix dans la Comté. Une paix menacée depuis que l’Anneau de Puissance, forgé par Sauron de Mordor, a été dérobé.","7", "1", "1995"},
                {"Da Vinci Code","D. Brown","De passage à Paris, Robert Langdon, professeur à Havard et spécialiste de symbologie, est appelé d'urgence au Louvre, en pleine nuit. Jacques Saunière, le conservateur en chef a été retrouvé assassiné au milieu de la Grande Galerie.","4", "3", "2003"},
                {"Eragon","C.Paolini","Eragon mène une vie simple, jusqu'au jour où il ramasse dans la forêt une étrange pierre bleue. Le garçon découvre qu'il s'agit d'un œuf et assiste bientôt à la naissance... d'un dragon !","2", "2", "2000"},
                {"Le Seigneur des anneaux","J.R.R. Tolkien","Aux temps reculés de ce récit, la Terre est peuplée d’innombrables créatures : les Hobbits, apparentés à l’Homme, les Elfes et les Nains vivent en paix dans la Comté. Une paix menacée depuis que l’Anneau de Puissance, forgé par Sauron de Mordor, a été dérobé.","7", "1", "1995"},
                {"Da Vinci Code","D. Brown","De passage à Paris, Robert Langdon, professeur à Havard et spécialiste de symbologie, est appelé d'urgence au Louvre, en pleine nuit. Jacques Saunière, le conservateur en chef a été retrouvé assassiné au milieu de la Grande Galerie.","4", "3", "2003"}
        };
        Object entetes[] = {"Titre","Auteur","Résumé","Colonne","Rangée","Parution"};

        JTable tableau = new JTable(donnees,entetes);
        DefaultTableModel tableModel = new DefaultTableModel(donnees, entetes);
        tableau.setModel(tableModel);

        //ScrollBar = new JScrollBar

        JScrollPane myJScroll = new JScrollPane(tableau);
        myJScroll.setPreferredSize(new Dimension(550,350));
        //ajout d'une scrollbar
        myJScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        myPanel.add(myJScroll);
        // appliquer couleur différente 1 ligne sur 2
        tableau.setDefaultRenderer(Object.class, new MyCellRenderer(tableau.getDefaultRenderer(Object.class)));

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridheight=9;
        gbc.gridwidth=6;
        myPanel.add(myJScroll, gbc);


        Dimension buttonSize = new Dimension(90,35);
        JButton myBtnAdd = new JButton(new ImageIcon("src/addButton.png"));
        myBtnAdd.setPreferredSize(buttonSize);
        myBtnAdd.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            /**
             * Un clic sur le bouton "+" permet d'ajouter une ligne vierge
             */
            public void mouseReleased(MouseEvent e) {
                DefaultTableModel tableDefault = (DefaultTableModel)tableau.getModel();
                String []  ligneVide = {"","","","","","",};
                tableDefault.addRow(ligneVide);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        JButton myBtnDelete = new JButton(new ImageIcon("src/deleteButton.png"));
        myBtnDelete.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            /**
             * Un clic sur le bouton "x" permet de supprimer une ligne
             */
            public void mouseReleased(MouseEvent e) {
                int[] ligneSelect = tableau.getSelectedRows();
                // condition : si aucune ligne n'est sélectionnée, un message d'erreur s'affiche via une boîte de dialogue.
                if (ligneSelect.length == 0) {
                    JOptionPane optionpane = new JOptionPane();
                    optionpane.showMessageDialog(tableau, "Veuillez sélectionner une ligne dans le tableau", "** Erreur **", JOptionPane.ERROR_MESSAGE);
                } else {
                    for (int i = ligneSelect.length - 1; i > 0; i--) {
                        tableModel.removeRow(ligneSelect[i]);

                    }
                    ((DefaultTableModel) tableau.getModel()).removeRow(tableau.getSelectedRow());
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        myBtnDelete.setPreferredSize(buttonSize);
        gbc.gridx=3;
        gbc.gridy=10;
        gbc.gridheight=1;
        gbc.gridwidth=1;

        myPanel.add(myBtnAdd, gbc);
        // mise en place des dénomination des textFields
        gbc.gridx = 4;
        myPanel.add(myBtnDelete,gbc);
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

        // mise en place d'un textField
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

        Dimension areaSize = new Dimension  (150, 200);
        JTextArea resumerArea = new JTextArea();
        resumerArea.setLineWrap(true);
        gbc.gridy = 6;
        resumerArea.setPreferredSize(areaSize);
        myPanel.add(resumerArea,gbc);

        JButton myBtnOk = new JButton(new ImageIcon("src/checkButton.png"));
        myBtnOk.setPreferredSize(buttonSize);
        gbc.gridy = 7;
        gbc.gridheight=1;
        myPanel.add(myBtnOk, gbc);

        myBtnOk.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            /**
             * Un clic sur le bouton "valider" valide les informations dans le formulaire pour les intégrer au tableau.
             */
            public void mouseReleased(MouseEvent e) {
                int ligneSelectionnee = tableau.getSelectedRow();
                int year = Calendar.getInstance().get(Calendar.YEAR);
                // ne permet qu'une saisie d'année inférieure à celle du système.
                tableau.setValueAt(titreField.getText(), ligneSelectionnee, 0);

                // le texte saisi en dans le textfield "auteur" va remplacer celui inscrit dans la colonne 1 de la ligne sélectionnée.
                tableau.setValueAt(auteurField.getText(), ligneSelectionnee, 1);


                if (Integer.parseInt(parutionField.getText()) <= year) {
                    tableau.setValueAt(parutionField.getText(), ligneSelectionnee, 5);
                }else{
                    JOptionPane parution = new JOptionPane();
                    ImageIcon imgUnicorn = new ImageIcon("src/unicorn.png");
                    parution.showMessageDialog(null,"Veuillez saisir une année antérieur à : "+year,"Date de parution Invalide",JOptionPane.INFORMATION_MESSAGE,imgUnicorn);
                }


                if (Integer.parseInt(colonneField.getText()) > 0 && Integer.parseInt(colonneField.getText()) < 8 ) {
                    tableau.setValueAt(colonneField.getText(), ligneSelectionnee, 3);
                }else {
                    JOptionPane colonne = new JOptionPane();
                    ImageIcon imgUnicorn = new ImageIcon("src/unicorn.png");
                    colonne.showMessageDialog(null, "Veuillez séléctionner un numéro de colonne entre 1 et 8 compris","Colonne invalide",JOptionPane.INFORMATION_MESSAGE, imgUnicorn);
                }


                if (Integer.parseInt(rangeeField.getText()) > 0 && Integer.parseInt(rangeeField.getText()) < 6 ) {
                    tableau.setValueAt(rangeeField.getText(), ligneSelectionnee, 4);
                } else {
                    JOptionPane rangee = new JOptionPane();
                    ImageIcon imgUnicorn = new ImageIcon("src/unicorn.png");
                    rangee.showMessageDialog(null, "Veuillez séléctionner un numéro de rangée entre 1 et 5 compris","Rangée invalide",JOptionPane.INFORMATION_MESSAGE,imgUnicorn);
                }

                tableau.setValueAt(resumerArea.getText(), ligneSelectionnee, 2);

                titreField.setText("");
                auteurField.setText("");
                parutionField.setText("");
                colonneField.setText("");
                rangeeField.setText("");
                resumerArea.setText("");

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        tableau.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            /**
             * Un clic sur une ligne du tableau affiche les données sélectionnées dans le formulaire.
             */
            public void valueChanged(ListSelectionEvent e) {
                int ligneSelectionnee = tableau.getSelectedRow();

                // affiche dans le champ "titre" du formulaire le texte contenu dans la colonne 0 de la ligne sélectionnée.
                titreField.setText(tableau.getValueAt(ligneSelectionnee, 0).toString());
                auteurField.setText(tableau.getValueAt(ligneSelectionnee, 1).toString());
                parutionField.setText(tableau.getValueAt(ligneSelectionnee, 5).toString());
                colonneField.setText(tableau.getValueAt(ligneSelectionnee, 3).toString());
                rangeeField.setText(tableau.getValueAt(ligneSelectionnee, 4).toString());
                resumerArea.setText(tableau.getValueAt(ligneSelectionnee, 2).toString());
            }
        });

    };

    public static void main(String[] args) {
        // création d'une fenêtre
        Application myWindow = new Application();
        myWindow.pack();
        myWindow.setMinimumSize(new Dimension(1200,800));
        // rend la fenêtre visible
        myWindow.setVisible(true);
        myWindow.setLocationRelativeTo(null);
    };
}