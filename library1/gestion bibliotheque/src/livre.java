import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class livre extends JFrame implements ActionListener {
	ImageIcon img,pic;
    JPanel book,data;
	JLabel id,nisbn,titre,auteur,nisbn1;
	JTextField tid,tnisbn,tauteur,trecherche,ttitre;
	JButton ajouter,supprimer,modifier,recherche,ajouter_ex,supprimer_ex,modifier_ex,precedent;
	Border emptyBorder = BorderFactory.createEmptyBorder();
	JTable table;
	String[] column_name={"N°isbn","Title","Author"};
	String[][] donnees;
	JScrollPane scrol;
	ArrayList<domain.livre1> arr,list;
	livre(){
		this.setTitle("book");
		this.setVisible(true);
		this.setSize(700,650);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(400,100);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.black);
		//img=new ImageIcon("img/Book.png");
		img=new ImageIcon(getClass().getClassLoader().getResource("Book.png"));
		this.setIconImage(img.getImage());
	book=new JPanel();
	this.add(book);
	book.setLayout(null);
	book.setBackground(Color.white);
	book.setBounds(0,0,300,650);

    ajouter=new JButton();
     book.add(ajouter);
    ajouter.setText("ADD");
    ajouter.setBounds(60,50,170,20);
    ajouter.setBackground(Color.white);
    ajouter.setBorder(new RoundedBorder(20));
    ajouter.setFocusPainted(false);
    ajouter.addActionListener(this);
    
    supprimer=new JButton();
    book.add(  supprimer);
    supprimer.setText(" DELETE");
    supprimer.setBounds(60,150,170,20);
    supprimer.setBackground(Color.white);
    supprimer.setBorder(new RoundedBorder(20));
    supprimer.setFocusPainted(false);
    supprimer.addActionListener(this);
    
    modifier=new JButton();
    book.add(  modifier);
    modifier.setText("UPDATE");
    modifier.setBounds(60,250,170,20);
    modifier.setBackground(Color.white);
    modifier.setBorder(new RoundedBorder(20));
    modifier.setFocusPainted(false);
    modifier.addActionListener(this);
    ajouter_ex=new JButton();
    book.add(ajouter_ex);
    ajouter_ex.setText("ADD EXP");
    ajouter_ex.setBounds(60,350,170,20);
    ajouter_ex.setBackground(Color.white);
    ajouter_ex.setBorder(new RoundedBorder(20));
    ajouter_ex.setFocusPainted(false);
    ajouter_ex.addActionListener(this);
    
    supprimer_ex=new JButton();
    book.add( supprimer_ex);
    supprimer_ex.setText("DELETE EXP");
    supprimer_ex.setBounds(60,450,170,20);
    supprimer_ex.setBackground(Color.white);
    supprimer_ex.setBorder(new RoundedBorder(20));
    supprimer_ex.setFocusPainted(false);
    supprimer_ex.addActionListener(this);
    
    precedent=new JButton("<< Back");
    book.add(precedent);
    precedent.setBackground(Color.black);
    precedent.setForeground(Color.white);
    precedent.setBounds(40,550,130,20);
    precedent.setFocusPainted(false);
    precedent.addActionListener(this);
    

    //
    data=new JPanel();
    this.add(data);
    data.setBounds(302,0,400,650);
    data.setBackground(Color.white);
    data.setLayout(null);
    nisbn1=new JLabel();
    data.add(nisbn1);
    nisbn1.setText("N°isbn");
    nisbn1.setBounds(20,20,100,40);
    nisbn1.setFont(new Font("serif",Font.PLAIN,20));
    // textfield recherche
    trecherche=new JTextField();
    data.add(trecherche);
    trecherche.setBounds(110,30,100,30);
	// button recherche
	recherche=new JButton();
	data.add(recherche);
	//pic=new ImageIcon("img/search (2).png");
	pic=new ImageIcon(getClass().getClassLoader().getResource("search (2).png"));
	recherche.setIcon(pic);
	recherche.setBounds(210,30,30,30);
   recherche.setBackground(Color.white); 
    recherche.setBorder(emptyBorder);
    recherche.setFocusPainted(false);
    recherche.addActionListener(this);
    
   //data table
    showtable();
	System.out.print("dsbb cb cdbe");
}
	public void actionPerformed(ActionEvent e) {
	if(e.getSource()==ajouter) {
		new addbook();
	}
	if(e.getSource()==supprimer) {
		new deletebook();
	}
	if(e.getSource()==modifier) {
		new updatebook();
	}
	if(e.getSource()==precedent) {
		this.dispose();
		new main_page2();
	}
	if(e.getSource()==ajouter_ex) {
		new add_exmp();
	}
	if(e.getSource()==supprimer_ex) {
		new delete_exp();
	}
	if(e.getSource()==recherche) {
		if(trecherche.getText().equals("")) {
			showtable();
		}
		else {
		list=database.livre_database.search(trecherche.getText());
		donnees=new String[list.size()][3];
	    for(int i=0;i<list.size();i++) {
	    	donnees[i][0]=""+list.get(i).getNisbn();
	    	donnees[i][1]=list.get(i).getTitre();
	    	donnees[i][2]=list.get(i).getAuteur();
	    	
	    }
	    table=new JTable(donnees,column_name);
	    scrol=new JScrollPane(table);
	    scrol.setBounds(10,100,360,450);
	    table.setShowGrid(true);
	    
	    data.add(scrol);
		
	}}
}
	public  void showtable() {
		arr=database.livre_database.get_livre();
		donnees=new String[arr.size()][3];
	    for(int i=0;i<arr.size();i++) {
	    	donnees[i][0]=""+arr.get(i).getNisbn();
	    	donnees[i][1]=arr.get(i).getTitre();
	    	donnees[i][2]=arr.get(i).getAuteur();
	    	
	    }
	    table=new JTable(donnees,column_name);
	    scrol=new JScrollPane(table);
	    scrol.setBounds(10,100,360,450);
	    table.setShowGrid(true);
	    
	    data.add(scrol);
	  
	
}
	}
