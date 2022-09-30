import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
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
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class emprunte extends JFrame implements ActionListener{
	ImageIcon img,pic;
	JPanel book_panel,user_panel,emprunte_panel;
	JLabel id,nisbn,titre,auteur,nabonne,nom,prenom,statut,user,book, date;
	JTextField tid,tnisbn,tauteur,ttitre,tnabonne,tnom,tprenom,tdate;
	JRadioButton etudiant,enseignant;
	ButtonGroup statut1;
	Border blackline ;
	JButton recherche1,recherche2 ,emprunte,retour, emprunte_en_cours,historique,precedent;
	Border emptyBorder = BorderFactory.createEmptyBorder();
	Date d;
	ArrayList<domain.livre1> list;
	ArrayList<domain.usager1> arr;

	//
	emprunte(){
	 this.setTitle("ISSUES");
	 this.setVisible(true);
	 this.setSize(700,500);
	 this.setResizable(false);
	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 this.setLocation(400,150);
	 this.setLayout(null);
	 this.getContentPane().setBackground(Color.black);
	 //img=new ImageIcon("img/Book.png");
	 img=new ImageIcon(getClass().getClassLoader().getResource("Book.png"));
	 this.setIconImage(img.getImage());
	 book_panel=new JPanel();
	 this.add(book_panel);
	 book_panel.setBounds(0,0,300,300);
	 book_panel.setBackground(Color.white);
	 book_panel.setLayout(null);
	 //book_panel.setBackground(Color.black);
	    book=new JLabel();
	    book.setText("-------BOOK------");
	    book_panel.add(book);
	    book.setBounds(100,10,100,20);
	    id=new JLabel();
		book_panel.add(id);
		id.setText("ID");
		id.setFont(new Font("serif",Font.PLAIN,20));
		id.setBounds(80,50,100,20);
		nisbn=new JLabel();
		book_panel.add(nisbn);
		nisbn.setText("N°isbn");
		nisbn.setFont(new Font("serif",Font.PLAIN,20));
		nisbn.setBounds(65,110,100,20);
		titre=new JLabel();
		book_panel.add(titre);
		titre.setText("Title");
		titre.setFont(new Font("serif",Font.PLAIN,20));
		titre.setBounds(75,170,100,20);
		
		auteur=new JLabel();
		book_panel.add(auteur);
		auteur.setText("Author");
		auteur.setFont(new Font("serif",Font.PLAIN,20));
	    auteur.setBounds(65,230,100,20);
	    //textfield
	    tid=new JTextField();
	    book_panel.add(tid);
	    tid.setBounds(140,50,100,20);
	    tnisbn=new JTextField();
	    book_panel.add(tnisbn);
	    tnisbn.setBounds(140,110,100,20);
	    ttitre=new JTextField();
	    book_panel.add(ttitre);
	    ttitre.setBounds(140,170,100,20);
	    tauteur=new JTextField();
	    book_panel.add(tauteur);
	    tauteur.setBounds(140,230,100,20);
    
	 user_panel=new JPanel();
	 this.add(user_panel);
	 user_panel.setLayout(null);
	 user_panel.setBounds(303,0,450,300);
	 user_panel.setBackground(Color.white);
	 user=new JLabel();
	    user.setText("-------USER------");
	    user_panel.add(user);
	    user.setBounds(150,10,100,20);
	    nabonne=new JLabel();
		user_panel.add(nabonne);
		nabonne.setText("USER ID");
		nabonne.setFont(new Font("serif",Font.PLAIN,20));
		nabonne.setBounds(75,50,100,20);
		nom=new JLabel();
		user_panel.add(nom);
		nom.setText("LastName");
		nom.setFont(new Font("serif",Font.PLAIN,20));
		nom.setBounds(75,110,100,20);
		prenom=new JLabel();
		user_panel.add(prenom);
		prenom.setText("Name");
		prenom.setFont(new Font("serif",Font.PLAIN,20));
		prenom.setBounds(75,170,100,20);
		
		statut=new JLabel();
		user_panel.add(statut);
		statut.setText("Status");
		statut.setFont(new Font("serif",Font.PLAIN,20));
		statut.setBounds(75,230,100,20);
	    //textfield
		tnabonne=new JTextField();
		user_panel.add(tnabonne);
	    tnabonne.setBounds(200,50,100,20);
	    tnom=new JTextField();
	    user_panel.add(tnom);
	    tnom.setBounds(200,110,100,20);
	    tprenom=new JTextField();
	    user_panel.add(tprenom);
	    tprenom.setBounds(200,170,100,20);
	    //radiobutton
	    statut1=new ButtonGroup();
	    etudiant=new JRadioButton("Student");
	    etudiant.setBackground(Color.white);
	    etudiant.setBounds(150,230,80,20);
	    statut1.add(etudiant);
	    user_panel.add(etudiant);
	    enseignant=new JRadioButton ("Teacher");
	    enseignant.setBackground(Color.white);
	    enseignant.setBounds(250,230,100,20);
	    statut1.add(enseignant);
	    user_panel.add(enseignant);
	    //pic=new ImageIcon("img/search (2).png");  
	    pic=new ImageIcon(getClass().getClassLoader().getResource("search (2).png"));
	    recherche1=new JButton();
	    recherche1.setIcon(pic);            
	    book_panel.add(recherche1);
	    recherche1.setBounds(250,45,30,30);  
	    recherche1.setBackground(Color.white); 
	    recherche1.setFocusPainted(false);
	    recherche1.setBorder(emptyBorder);
	    recherche1.addActionListener(this);
	    
	    recherche2=new JButton();
	    recherche2.setIcon(pic);
	    user_panel.add(recherche2);
	    recherche2.setBackground(Color.white);
	    recherche2.setBounds(320,45,30,30);
	    recherche2.setFocusPainted(false);
	    recherche2.setBorder(emptyBorder);
	    recherche2.addActionListener(this);
	    date=new JLabel();
	    user_panel.add(date);
	    date.setText("Date");
	    date.setBounds(100,270,50,20);
	    tdate=new JTextField();
	    user_panel.add(tdate);
	    tdate.setBounds(200,270,100,20);
	    d=new Date(System.currentTimeMillis());
        tdate.setText(d.toLocalDate().toString());	    
	    
	    emprunte_panel=new JPanel();
	    this.add(emprunte_panel);
	    emprunte_panel.setLayout(null);
	    emprunte_panel.setBounds(0, 300, 700, 200);
	    emprunte_panel.setBackground(Color.white);
	    
	    emprunte=new JButton("ISSUE");
	    emprunte_panel.add(emprunte);
	    emprunte.setBackground(Color.white);
	   // emprunte.setForeground(Color.white);
	    emprunte.setBounds(40,40,100,40);
	   // emprunte.setBorder(emptyBorder);
	    emprunte.setFocusPainted(false);
	    emprunte.addActionListener(this);

	   retour=new JButton("RETURN");
	    emprunte_panel.add(retour);
	    retour.setBackground(Color.white);
	    //retour.setForeground(Color.white);
	    retour.setBounds(180,40,100,40);
	   // retour.setBorder(emptyBorder);
	    retour.setFocusPainted(false);
	    retour.addActionListener(this);
	    
	    emprunte_en_cours=new JButton("ISSUES");
	    emprunte_panel.add(emprunte_en_cours);
	    emprunte_en_cours.setBackground(Color.white);
	    emprunte_en_cours.setBounds(320,40,150,40);
	   // emprunte_en_cours.setForeground(Color.white);
	   // emprunte_en_cours.setBorder(emptyBorder);
	    emprunte_en_cours.setFocusPainted(false);
	    emprunte_en_cours.addActionListener(this);
	    
	    historique=new JButton("HISTORY");
	    emprunte_panel.add(historique);
	    historique.setBackground(Color.white);
	    historique.setBounds(500,40,150,40);
	   // historique.setForeground(Color.white);
	    //historique.setBorder(emptyBorder);
	    historique.setFocusPainted(false);
	    historique.addActionListener(this);
	    
	    precedent=new JButton("<< BACK");
	    emprunte_panel.add(precedent);
	    precedent.setBackground(Color.black);
	    precedent.setForeground(Color.white);
	    precedent.setBounds(40,120,130,20);
	    precedent.setFocusPainted(false);
	    precedent.addActionListener(this);
	    

}
	public void actionPerformed(ActionEvent ee) {
		if(ee.getSource()==emprunte) {
			if(tid.getText().equals("")|| ttitre.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"ERROR","",JOptionPane.WARNING_MESSAGE);
			}
			else {
			int x=database.emprunte_database.emprunte(tid.getText(), ttitre.getText(), tnabonne.getText(), tprenom.getText(),tdate.getText() );
			if(x==1) {
				JOptionPane.showMessageDialog(null,"ok","",JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null,"no book","",JOptionPane.INFORMATION_MESSAGE);
			}
		}}
		if(ee.getSource()==retour) {
			if(tid.getText().equals("")|| ttitre.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"ERROR","",JOptionPane.WARNING_MESSAGE);
			}
			else {
			int x=database.emprunte_database.retour(tid.getText(), ttitre.getText(), tnabonne.getText(), tprenom.getText(),tdate.getText() );
			if(x==1) {
				JOptionPane.showMessageDialog(null,"ok","",JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null,"pas d'exemplaire","",JOptionPane.INFORMATION_MESSAGE);
			}
		}}
		if(ee.getSource()==historique) {
			new historique();
			this.dispose();
		}
		if(ee.getSource()==emprunte_en_cours) {
			new empruntes_en_cours();
			this.dispose();
		           }
		if(ee.getSource()==recherche1) {
			list=new ArrayList<domain.livre1>();
			list=database.emprunte_database.search(tid.getText());
			if(list.size()>0) {
				tnisbn.setText(list.get(0).getNisbn());
				ttitre.setText(list.get(0).getTitre());
				tauteur.setText(list.get(0).getAuteur());
			}
			else {
				JOptionPane.showMessageDialog(null,"livre n'exist pas","add",JOptionPane.WARNING_MESSAGE);
			}
		}
		if(ee.getSource()==recherche2) {
			arr=new ArrayList<domain.usager1>();
			arr=database.usager_database.search(tnabonne.getText());
			if(arr.size()>0) {
				 tnom.setText(arr.get(0).getNom());
				 tprenom.setText(arr.get(0).getPrenom());
				  if(arr.get(0).getStatut().equals("etudiant")) {
					   etudiant.setSelected(true);
				                                                 }
				 else {
					enseignant.setSelected(true);
				      }
			}
			else {
				JOptionPane.showMessageDialog(null,"usager n'exist pas","",JOptionPane.WARNING_MESSAGE);
			}
			
		}
		if(ee.getSource()==precedent) {
			this.dispose();
			new main_page2();
			}
			
	}
	}
