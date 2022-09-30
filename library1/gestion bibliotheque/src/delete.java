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

public class delete extends JFrame implements ActionListener{
	ImageIcon img;
	JPanel panel;
	JLabel  nabonne;
	JTextField tnabonne;
	JButton ok;
	delete(){
		 this.setTitle("USER");
		 this.setVisible(true);
		 this.setSize(300,150);
		 this.setResizable(false);
		// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setLocation(600,250);
		 this.setLayout(null);
		 panel=new JPanel();
		 this.add(panel);
		 panel.setBounds(0,0,300,150);
		 panel.setLayout(null);
		 panel.setBackground(Color.white);
		// img=new ImageIcon("img/Book.png");
		 img=new ImageIcon(getClass().getClassLoader().getResource("Book.png"));
			this.setIconImage(img.getImage());
        
		 nabonne=new JLabel();
			panel.add(nabonne);
			nabonne.setText("USER ID");
			nabonne.setFont(new Font("serif",Font.PLAIN,20));
			nabonne.setBounds(35,20,100,20);
		
	    //textfield
		tnabonne=new JTextField();
	    panel.add(tnabonne);
	    tnabonne.setBounds(150,20,100,20);
	    //bouttons
	    
	    ok=new JButton();
	    panel.add(ok);
	    ok.setText("DELETE");
	    ok.setBounds(80,80,130,20);
	    ok.setBackground(Color.black);
	    ok.setForeground(Color.white);
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
			   
				                             } 
				if(tnabonne.getText().equals("")) {
				    	 JOptionPane.showMessageDialog(null,"remplissez les zones de textes ","",JOptionPane.INFORMATION_MESSAGE);
				   }
				else {
					int x=database.usager_database.delet_data(tnabonne.getText());
					if(x==1) {
						 JOptionPane.showMessageDialog(null,"ok","supprime",JOptionPane.INFORMATION_MESSAGE);
		                    tnabonne.setText("");
		                    this.dispose();
			             	}
		            else if(x==0) {
		                	JOptionPane.showMessageDialog(null,"usager n'exist pas","supprime",JOptionPane.WARNING_MESSAGE);
		                	tnabonne.setText("");
			                
		                     }
			             }
	}
}

