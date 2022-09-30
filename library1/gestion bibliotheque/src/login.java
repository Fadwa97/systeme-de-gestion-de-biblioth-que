import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import database.login_database;

public class login extends JFrame implements ActionListener {
	ImageIcon img,img1;
	JPanel login_panel;
	JLabel login_label,username_label,password_label;
	JPasswordField password;
	JTextField username_textfield;
	JButton login_button;
	Border emptyBorder = BorderFactory.createEmptyBorder();
 public login() {
	 this.setTitle("login");
	 this.setVisible(true);
	 this.setSize(700,350);
	 this.setResizable(false);
	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 this.setLocation(400,150);
	 //img=new ImageIcon("img/Book.png");
	 img=new ImageIcon(getClass().getClassLoader().getResource("Book.png"));
	 this.setIconImage(img.getImage());
	 login_panel=new JPanel();
	 login_panel.setBackground(Color.white);
	 login_panel.setLayout(null);
	 this.add(login_panel);
	 login_label=new JLabel();
	 username_label=new JLabel();
	 username_textfield=new JTextField();
	 password_label=new JLabel();
	 password=new JPasswordField();
	 login_button=new JButton();
	 username_label.setText("Username ");
	 password_label.setText("Password ");
	 //ajout des composant au panel
	 login_panel.add(login_label);
	 login_panel.add(username_label);
	 login_panel.add(username_textfield);
	 login_panel.add(password_label);
	 login_panel.add(password);
	 login_panel.add(login_button);
	 //ajout de text
	 login_label.setText("There Is No Friend As Loyal As Book");
	 login_label.setFont(new Font("MV Boli",Font.PLAIN,15));
	 //ajout d'image
	// img1=new ImageIcon("img/book1.png");
	 img1=new ImageIcon(getClass().getClassLoader().getResource("book1.png"));
	 login_label.setIcon(img1);
	 //position de la photo par rapport au text
	 login_label.setHorizontalTextPosition(JLabel.CENTER);
	 login_label.setVerticalTextPosition(JLabel.TOP);
	 //position des differents composantes 
	 login_label.setBounds(10, 40, 350, 200);
	 username_label.setBounds(500,20,650,50);
	 username_textfield.setBounds(400,60,260,40);
	 password_label.setBounds(500,100,650,50);
	 password.setBounds(400,140,260,40);
	 login_button.setBounds(480,200,100,30);
	 login_button.setText("login");
	 login_button.setBorder(emptyBorder);
	 login_button.setFocusPainted(false);
	 login_button.setBackground(Color.black);
	 login_button.setForeground(Color.white);
	 login_button.addActionListener(this);
	 
 }
 public void actionPerformed(ActionEvent ee) {
	 if (ee.getSource()==login_button) {
		 
		int x=database.login_database.check(username_textfield.getText(), password.getText());
		if(x==1) {
			this.dispose();
			new main_page2();
		}
		else if(x==2) {
			JOptionPane.showMessageDialog(null,"Wrong Password","Password",JOptionPane.WARNING_MESSAGE);
			username_textfield.setText("");
			password.setText("");
		}
		else {
			JOptionPane.showMessageDialog(null,"Wrong UserName","UserName",JOptionPane.WARNING_MESSAGE);
			username_textfield.setText("");
			password.setText("");
		}
		 }
	 
 }
	 
 }

