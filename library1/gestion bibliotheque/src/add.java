import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import database.usager_database;

public class add extends JFrame implements ActionListener{
	ImageIcon img;
	JPanel panel;
	JLabel  nabonne,nom,prenom,statut,email;
	JTextField tnabonne, tnom,tprenom,temail;
	JRadioButton etudiant,enseignant;
	JButton ok;
	ButtonGroup statut1;
	add(){
		 this.setTitle("USER");
		 this.setVisible(true);
		 this.setSize(300,370);
		 this.setResizable(false);
		 //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setLocation(600,250);
		 this.setLayout(null);
		 panel=new JPanel();
		 this.add(panel);
		 panel.setBounds(0,0,300,370);
		 panel.setLayout(null);
		 panel.setBackground(Color.white);
		 //img=new ImageIcon("img/Book.png");
		 img=new ImageIcon(getClass().getClassLoader().getResource("Book.png"));
			this.setIconImage(img.getImage());
        
		 nabonne=new JLabel();
			panel.add(nabonne);
			nabonne.setText("ID");
			nabonne.setFont(new Font("serif",Font.PLAIN,20));
			nabonne.setBounds(35,20,100,20);
		nom=new JLabel();
		panel.add(nom);
		nom.setText("LastName");
		nom.setFont(new Font("serif",Font.PLAIN,20));
		nom.setBounds(35,80,100,20);
		prenom=new JLabel();
		panel.add(prenom);
		prenom.setText("Name");
		prenom.setFont(new Font("serif",Font.PLAIN,20));
		prenom.setBounds(35,140,100,20);
		
		statut=new JLabel();
		panel.add(statut);
		statut.setText("Status");
		statut.setFont(new Font("serif",Font.PLAIN,20));
		statut.setBounds(35,200,100,20);
		email=new JLabel();
		panel.add(email);
		email.setText("Email");
		email.setFont(new Font("serif",Font.PLAIN,20));
		email.setBounds(35,260,100,20);
		
		
	    //textfield
		tnabonne=new JTextField();
	    panel.add(tnabonne);
	    tnabonne.setBounds(150,20,100,20);
	    tnom=new JTextField();
	    panel.add(tnom);
	    tnom.setBounds(150,80,100,20);
	    tprenom=new JTextField();
	    panel.add(tprenom);
	    tprenom.setBounds(150,140,100,20);
	    //radiobutton
	    statut1=new ButtonGroup();
	    etudiant=new JRadioButton("Etudiant");
	    etudiant.setBackground(Color.white);
	    etudiant.setBounds(100,200,80,20);
	    etudiant.setFocusPainted(false);
	    statut1.add(etudiant);
	    panel.add(etudiant);
	    enseignant=new JRadioButton ("Enseignant");
	    enseignant.setBackground(Color.white);
	    enseignant.setBounds(190,200,100,20);
	    enseignant.setFocusPainted(false);
	    statut1.add(enseignant);
	    panel.add(enseignant);
	    temail=new JTextField();
	    panel.add(temail);
	    temail.setBounds(150,260,100,20);
	    
	    //bouttons
	    
	    ok=new JButton();
	    panel.add(ok);
	    ok.setText("Ajouter");
	    ok.setBounds(80,300,130,20);
	    ok.setBackground(Color.black);
	    ok.setForeground(Color.white);
	    ok.setBorder(new RoundedBorder(20));
	    ok.setFocusPainted(false);
	    ok.addActionListener(this);
	    this.addWindowListener (new WindowAdapter() {    
            public void windowClosing (WindowEvent e) {    
                dispose();    
            }    
        }); 
	}
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==ok) {
			   String s="";
	        
	           if(enseignant.isSelected()) {
	                  s="enseignant"; 
	                                        }
	         
	            else if(etudiant.isSelected()) {
					   s="etudiant";
				                             } 
	           if(e.getSource()==ok) {
					 if(tnabonne.getText().equals("")||tnom.getText().equals("")||tprenom.getText().equals("")||s.equals("")||temail.getText().equals("")) {
					    	 JOptionPane.showMessageDialog(null,"remplissez les zones de textes ","",JOptionPane.INFORMATION_MESSAGE);
					   }
					  else {
				         int x=database.usager_database.insert_data(tnabonne.getText(),tnom.getText(),tprenom.getText(),s,temail.getText());
				         if(x==1) {
				                   JOptionPane.showMessageDialog(null,"ok","Ajout",JOptionPane.INFORMATION_MESSAGE);
				                    tnabonne.setText("");
				                    tnom.setText("");
				                    tprenom.setText("");
				                    statut1.clearSelection();
				                    temail.setText("");
				                    this.dispose();
					             	}
				        else if(x==0) {
				                	JOptionPane.showMessageDialog(null,"usager exist","Ajout",JOptionPane.WARNING_MESSAGE);
				                	tnabonne.setText("");
					                tnom.setText("");
					                tprenom.setText("");
					                statut1.clearSelection();
				                    temail.setText("");

				                     }
					  }
	                                       }
			
		}
	}
}
