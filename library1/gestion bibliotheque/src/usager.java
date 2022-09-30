import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import database.usager_database;

public class usager  extends JFrame implements ActionListener {
	    ImageIcon  img,pic;
	    JPanel usagers,usag,data;
		JLabel nabonne,nom,prenom,statut ,nabonne1;
		JTextField tnabonne,tnom,tprenom,trecherche;
		JRadioButton etudiant,enseignant;
		ButtonGroup statut1;
	    JButton ajouter,supprimer,modifier,recherche, precedent;
	    String[] column_name={"ID ","LastName","Name","Status","Email"};
	    static JTable table;
	    String[][] donnees;
		JScrollPane scrol;
		ArrayList<domain.usager1> arr;
		ArrayList<domain.usager1> list;
		Border emptyBorder = BorderFactory.createEmptyBorder();		
		usager(){
			 this.setTitle("User");
			 this.setVisible(true);
			 this.setSize(700,600);
			 this.setResizable(false);
			 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 this.setLocation(400,150);
			 this.setLayout(null);
			 this.getContentPane().setBackground(Color.black);
			 //img=new ImageIcon("img/Book.png");
			 img=new ImageIcon(getClass().getClassLoader().getResource("Book.png"));
			this.setIconImage(img.getImage());
		usagers=new JPanel();
		this.add(usagers);
		usagers.setLayout(null);
		usagers.setBackground(Color.white);
		usagers.setBounds(0,0,300,600);
		
		
		
	    
	    //bouttons
	    
	    ajouter=new JButton();
	    usagers.add(ajouter);
	    ajouter.setText("ADD");
	    ajouter.setBounds(80,100,130,20);
	    ajouter.setBackground(Color.white);
	    ajouter.setBorder(new RoundedBorder(20));
	    ajouter.setFocusPainted(false);
	    ajouter.addActionListener(this);
	    
	    supprimer=new JButton();
	    usagers.add(  supprimer);
	    supprimer.setText("DELETE");
	    supprimer.setBounds(80,200,130,20);
	    supprimer.setBackground(Color.white);
	    supprimer.setBorder(new RoundedBorder(20));
	    supprimer.setFocusPainted(false);
        supprimer.addActionListener(this);
	    
	    modifier=new JButton();
	    usagers.add(  modifier);
	    modifier.setText("UPDATE");
	    modifier.setBounds(80,300,130,20);
	    modifier.setBackground(Color.white);
	    modifier.setBorder(new RoundedBorder(20));
	    modifier.setFocusPainted(false);
	    modifier.addActionListener(this);
	    
	    
	    precedent=new JButton("<< BACK");
	    usagers.add(precedent);
	    precedent.setBackground(Color.black);
	    precedent.setForeground(Color.white);
	    precedent.setBounds(40,400,130,20);
	    precedent.setFocusPainted(false);
	    precedent.addActionListener(this);
	    
	    
	
	    //
	    data=new JPanel();
	    this.add(data);
	    data.setBounds(302,0,400,600);
	    data.setBackground(Color.white);
	    data.setLayout(null);
	    nabonne1=new JLabel();
	    data.add(nabonne1);
	    nabonne1.setText("USER ID");
	    nabonne1.setBounds(20,20,100,40);
	    nabonne1.setFont(new Font("serif",Font.PLAIN,20));
	    // textfield recherche
	    trecherche=new JTextField();
	    data.add(trecherche);
	    trecherche.setBounds(110,30,100,30);
		// button recherche
		recherche=new JButton();
		data.add(recherche);
		//pic=new ImageIcon("img/search (2).png");
		pic=new ImageIcon(getClass().getClassLoader().getResource("search (2).png"));
		this.setIconImage(img.getImage());
		recherche.setIcon(pic);
		recherche.setBounds(210,30,30,30);
	    recherche.setBackground(Color.white);
	    recherche.setBorder(emptyBorder);
	    recherche.setFocusPainted(false);
	    recherche.addActionListener(this);
	    
	    
	    //table
	    showtable();
}
		public void actionPerformed(ActionEvent e) {
			
			                                      
			if(e.getSource()==precedent) {
				    this.dispose();
				    new main_page2();
			                              }
			if(e.getSource()==ajouter) {
				 new add();
				
                                       }
			if(e.getSource()==supprimer) {
				new delete();
				}
				
				                        
			if(e.getSource()==modifier) {	
				new update();
			                           }
			if(e.getSource()==recherche) {
				if(trecherche.getText().equals("")) {
					showtable();
				}
				else
				{
				list=database.usager_database.search(trecherche.getText());
				donnees=new String[list.size()][5];
			    for(int i=0;i<list.size();i++) {
			    	donnees[i][0]=""+list.get(i).getNabonne();
			    	donnees[i][1]=list.get(i).getNom();
			    	donnees[i][2]=list.get(i).getPrenom();
			    	donnees[i][3]=list.get(i).getStatut();
			    	donnees[i][4]=list.get(i).getEmail();

			    }
			    table=new JTable(donnees,column_name);
			    scrol=new JScrollPane(table);
			    scrol.setBounds(10,100,360,450);
			    data.add(scrol);
				
			}
			}
			
		}
		
		public  void showtable() {
			arr=database.usager_database.get_usager();
			donnees=new String[arr.size()][5];
		    for(int i=0;i<arr.size();i++) {
		    	donnees[i][0]=""+arr.get(i).getNabonne();
		    	donnees[i][1]=arr.get(i).getNom();
		    	donnees[i][2]=arr.get(i).getPrenom();
		    	donnees[i][3]=arr.get(i).getStatut();
		    	donnees[i][4]=arr.get(i).getEmail();
		    }
		    table=new JTable(donnees,column_name);
		    scrol=new JScrollPane(table);
		    scrol.setBounds(10,100,360,450);
		    table.setShowGrid(true);
		    
		    data.add(scrol);
		  
		
}}

