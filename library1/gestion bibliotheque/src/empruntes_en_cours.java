import java.awt.Color;
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
import javax.swing.border.Border;

public class empruntes_en_cours extends JFrame implements ActionListener{
	ImageIcon img;
	JPanel data;
	JTable tableau_de_donne;
	String[] header={"ID ","Title","USER ID","Name","Issue Date"};
	String[][] donnees;
	JScrollPane scrol;
	JButton back;
	Border emptyBorder = BorderFactory.createEmptyBorder();
	ArrayList<domain.emprunte1> arr=new ArrayList<domain.emprunte1>();
	empruntes_en_cours(){
		this.setTitle("ISSUES");
		 this.setVisible(true);
		 this.setSize(700,500);
		 this.setResizable(false);
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setLocation(400,150);
		 //img=new ImageIcon("img/Book.png");
		 img=new ImageIcon(getClass().getClassLoader().getResource("Book.png"));
			this.setIconImage(img.getImage());
	    data=new JPanel();
	    this.add(data);
	    data.setLayout(null);
	    data.setBackground(Color.white);
	    arr=database.emprunte_database.get_emprunte();
	    donnees=new String[arr.size()][5];
	    for(int i=0;i<arr.size();i++) {
	    	donnees[i][0]=""+arr.get(i).getId_exp();
	    	donnees[i][1]=arr.get(i).getTitre();
	    	donnees[i][2]=arr.get(i).getId_usa();
	    	donnees[i][3]=arr.get(i).getPrenom();
	    	donnees[i][4]=arr.get(i).getD();
	                                   }
	    tableau_de_donne=new JTable(donnees,header);
	    scrol=new JScrollPane(tableau_de_donne);
	    tableau_de_donne.setShowGrid(true);
	    scrol.setBounds(150,0,550,500);
	    data.add(scrol);
	    back=new JButton("<< BACK");
	    data.add(back);
	    back.setBackground(Color.black);
	    back.setForeground(Color.white);
	    back.setBounds(20,400,100,20);
	    back.setBorder(emptyBorder);
	    back.setFocusPainted(false);
	    back.addActionListener(this);
	    
	    
	}
	public void actionPerformed(ActionEvent e) {
		new emprunte();
		this.dispose();
	}

}