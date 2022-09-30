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

public class delete_exp extends JFrame implements ActionListener{
	JPanel book;
	ImageIcon img;
	JLabel id;
	JTextField tid;
	JButton ok;
	Border emptyBorder = BorderFactory.createEmptyBorder();
	delete_exp(){
	 this.setTitle("book");
	 this.setVisible(true);
	 this.setSize(250,150);
	 this.setResizable(false);
	// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 this.setLocation(600,250);
	 this.setLayout(null);
		// img=new ImageIcon("img/Book.png");
	 img=new ImageIcon(getClass().getClassLoader().getResource("Book.png"));
		this.setIconImage(img.getImage());
book=new JPanel();
this.add(book);
book.setLayout(null);
book.setBackground(Color.white);
book.setBounds(0,0,250,150);

id=new JLabel();
book.add(id);
id.setFont(new Font("serif",Font.PLAIN,20));
id.setBounds(20,20,100,20);
id.setText("ID ");

tid=new JTextField();
book.add(tid);
tid.setBounds(100,20,100,20);


ok=new JButton();
book.add(ok);
ok.setBounds(70,80,100,20);
ok.setText("DELETE");
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
	    	if(tid.getText().equals("")) {
	    		 JOptionPane.showMessageDialog(null, "remplissez les zones de textes ","",JOptionPane.INFORMATION_MESSAGE);
	    	}
	    	else { 
	    		 int x=database.livre_database.delete_ex(tid.getText());
	    		 if(x==1) {
	                      JOptionPane.showMessageDialog(null,"ok ","add",JOptionPane.INFORMATION_MESSAGE);
	                      tid.setText("");
	                      this.dispose();
	    		           }
	               else if(x==0) {
		                	JOptionPane.showMessageDialog(null,"livre n'exist pas","add",JOptionPane.WARNING_MESSAGE);
		                    tid.setText("");
		                    this.dispose();
	                               }
	    		
	    	       }
	         }
	    }
}
