import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class deletebook extends JFrame implements ActionListener {
	ImageIcon img;
	JPanel panel;
	JLabel  nisbn;
	JTextField tnisbn;
	JButton ok;
	Border emptyBorder = BorderFactory.createEmptyBorder();
	deletebook(){
		 this.setTitle("book");
		 this.setVisible(true);
		 this.setSize(300,150);
		 this.setResizable(false);
		 //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setLocation(600,250);
		 this.setLayout(null);
		 //img=new ImageIcon("img/Book.png");
		 img=new ImageIcon(getClass().getClassLoader().getResource("Book.png"));
			this.setIconImage(img.getImage());
		 panel=new JPanel();
		 this.add(panel);
		 panel.setBounds(0,0,300,150);
		 panel.setLayout(null);
		 panel.setBackground(Color.white);

        
		 nisbn=new JLabel();
			panel.add(nisbn);
			nisbn.setText("N°isbn");
			nisbn.setFont(new Font("serif",Font.PLAIN,20));
			nisbn.setBounds(35,20,100,20);
		
	    //textfield
		tnisbn=new JTextField();
	    panel.add(tnisbn);
	    tnisbn.setBounds(150,20,100,20);
	    //bouttons
	    
	    ok=new JButton();
	    panel.add(ok);
	    ok.setText("DELETE");
	    ok.setBounds(80,80,130,20);
	    ok.setBackground(Color.black);
	    ok.setForeground(Color.white);
	    ok.setFocusPainted(false);
	    ok.setBorder(emptyBorder);
        ok.addActionListener(this);
        this.addWindowListener (new WindowAdapter() {    
            public void windowClosing (WindowEvent e) {    
                dispose();    
            }    
        });  
	
	}
	public void actionPerformed(ActionEvent e) {
			if(e.getSource()==ok) {
				   if(tnisbn.getText().equals("")) {
                        JOptionPane.showMessageDialog(null,"remplissez les zones de textes ","",JOptionPane.INFORMATION_MESSAGE);
                                                      }
                   else {
                         int x=database.livre_database.delet_data(tnisbn.getText());
                         if(x==1) {
                                  JOptionPane.showMessageDialog(null,"ok","supprime",JOptionPane.INFORMATION_MESSAGE);
                                   tnisbn.setText("");
                                   this.dispose();
                                   }
                         else if(x==0) {
                                   JOptionPane.showMessageDialog(null,"usager n'exist pas","supprime",JOptionPane.WARNING_MESSAGE);
                                   tnisbn.setText("");

}
}
		}
	}
}
