import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class main_page2 extends JFrame implements ActionListener{
	ImageIcon img;
	JPanel main_panel1,main_panel2;
	JLabel label1;
	JButton livre,usager;
	JButton emprunte,log;
	Border emptyBorder = BorderFactory.createEmptyBorder();
public main_page2() {
	//initialiser le frame
	this.setVisible(true);
	this.setSize(300,500);
	this.setResizable(false);
	this.setLocation(600,100);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setTitle("main");
	this.setLayout(null);
	//ajouter une icone
	//img=new ImageIcon("img/Book.png");
	img=new ImageIcon(getClass().getClassLoader().getResource("Book.png"));
	this.setIconImage(img.getImage());
	//panel
	main_panel1=new JPanel();
	this.add(main_panel1);
	main_panel1.setBackground(Color.black);
	main_panel1.setBounds(0,0,300,500);
	main_panel1.setLayout(null);
	//labels pour le main_panel
	label1=new JLabel();
	main_panel1.add(label1);
	label1.setText("Library");
	label1.setForeground(Color.white);
	label1.setFont(new Font("MV Boli",Font.PLAIN,30));
	label1.setBounds(90,20,300,50);
	livre=new JButton();
	main_panel1.add(livre);
	livre.setText("Book");
	livre.setForeground(Color.white);
	livre.setBackground(Color.black);
	livre.setFont(new Font("MV Boli",Font.PLAIN,20));
	livre.setFocusPainted(false);
	livre.setBounds(10,100,250,100);
	livre.setBorder(emptyBorder);
	livre.addActionListener(this);
   //
    usager=new JButton();
    main_panel1.add(usager);
    usager.setText("User");
    usager.setForeground(Color.white);
    usager.setBackground(Color.black);
    usager.setFont(new Font("MV Boli",Font.PLAIN,20));
    usager.setFocusPainted(false);
    usager.setBounds(10,200,250,100);
    usager.setBorder(emptyBorder);
    usager.addActionListener(this);
    //
    emprunte=new JButton();
    main_panel1.add(emprunte);
    emprunte.setText("Issues");
    emprunte.setForeground(Color.white);
    emprunte.setBackground(Color.black);
    emprunte.setFont(new Font("MV Boli",Font.PLAIN,20));
    emprunte.setFocusPainted(false);
    emprunte.setBounds(10,300,250,100);
    emprunte.setBorder(emptyBorder);
    emprunte.addActionListener(this);
 
}

public void actionPerformed(ActionEvent e) {
	if(e.getSource()==livre) {
	  new livre();	
	  this.dispose();
	}
	if(e.getSource()==usager) {
		this.dispose();
	new usager();
		
	}
	if(e.getSource()==emprunte) {
		this.dispose();
        new emprunte();
        System.out.print("dsbb cb cdbe");
	}
}

}
