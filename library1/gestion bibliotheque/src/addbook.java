import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class addbook extends JFrame implements ActionListener{
	JPanel book;
	ImageIcon img;
	JLabel nisbn,titre,auteur;
	JTextField tnisbn,tid,ttitre,tauteur;
	JButton ok;
	Border emptyBorder = BorderFactory.createEmptyBorder();
	addbook(){
	this.setTitle("book");
	 this.setVisible(true);
	 this.setSize(300,300);
	 this.setResizable(false);
	// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 this.setLocation(600,200);
	 this.setLayout(null);
	 this.getContentPane().setBackground(Color.black);
	// img=new ImageIcon("img/Book.png");
	 img=new ImageIcon(getClass().getClassLoader().getResource("Book.png"));
		this.setIconImage(img.getImage());
book=new JPanel();
this.add(book);
book.setLayout(null);
book.setBackground(Color.white);
book.setBounds(0,0,300,300);

nisbn=new JLabel();
book.add(nisbn);
nisbn.setText("N°isbn");
nisbn.setFont(new Font("serif",Font.PLAIN,20));
nisbn.setBounds(55,20,100,20);
titre=new JLabel();
book.add(titre);
titre.setText("Title");
titre.setFont(new Font("serif",Font.PLAIN,20));
titre.setBounds(65,80,100,20);

auteur=new JLabel();
book.add(auteur);
auteur.setText("Author");
auteur.setFont(new Font("serif",Font.PLAIN,20));
auteur.setBounds(55,140,100,20);
//textfield
tnisbn=new JTextField();
book.add(tnisbn);
tnisbn.setBounds(120,20,100,20);
ttitre=new JTextField();
book.add(ttitre);
ttitre.setBounds(120,80,100,20);
tauteur=new JTextField();
book.add(tauteur);
tauteur.setBounds(120,140,100,20);
//boutton

ok=new JButton();
book.add(ok);
ok.setText("ADD");
ok.setBounds(60,200,170,20);
ok.setForeground(Color.white);
ok.setBackground(Color.black);
ok.setBorder(emptyBorder);
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
			if(tnisbn.equals("")||ttitre.equals("")||tauteur.equals("")) {
				JOptionPane.showMessageDialog(null,"remplissez les zones de textes ","",JOptionPane.INFORMATION_MESSAGE);
			}
			else {
		         int x=database.livre_database.insert_data(tnisbn.getText(),ttitre.getText(),tauteur.getText());
		         if(x==1) {
		                   JOptionPane.showMessageDialog(null,"ok","Ajout",JOptionPane.INFORMATION_MESSAGE);
		                    tnisbn.setText("");
		                    ttitre.setText("");
		                    tauteur.setText("");
		                    this.dispose();
			             	}
		        else if(x==0) {
		                	JOptionPane.showMessageDialog(null,"usager exist","Ajout",JOptionPane.WARNING_MESSAGE);
		                	tnisbn.setText("");
		                    ttitre.setText("");
		                    tauteur.setText("");
		                     }
			  }
				}
		
	}
}