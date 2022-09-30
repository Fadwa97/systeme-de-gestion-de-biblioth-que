package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class emprunte_database {
	public static Connection connect() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliothequemysql","root","");
	}
	public static  ArrayList<domain.livre1> search(String id){
		Connection c;
		ArrayList<domain.livre1> list=new ArrayList<domain.livre1>();
		try {
			c=connect();
			String query="select*from book where nisbn in(select nisbn from exemplaire where id=?)";
			PreparedStatement s= c.prepareStatement(query);
			s.setString(1, id);
			ResultSet r=s.executeQuery();
			while(r.next()) {
				list.add(new domain.livre1(r.getString("nisbn"),r.getString("titre"),r.getString("auteur")));
			}
        c.close();
		} catch (SQLException e) {}
		return list;
	}
	public static int emprunte(String idb,String titre,String idu,String prenom,String d) {
		Connection c;
		int x=0;
		try {
			c=connect();
			String query="insert into emprunte values(?,?,?,?,?)";
			PreparedStatement s=c.prepareStatement(query);
			s.setString(1,idb);
			s.setString(2,titre);
			s.setString(3,idu);
			s.setString(4,prenom);
			s.setString(5,d);
			x=s.executeUpdate();
			c.close();
		} catch (SQLException e) {
			
		}
		return x;
		
	}
	public static int retour(String idb,String titre,String idu,String prenom,String d)  {
		Connection c;
		int x=0;
		try {
			c=connect();
			String de=seek(idb);
			String query2="insert into historique values(?,?,?,?,?,?)";
			PreparedStatement s1=c.prepareStatement(query2);
			s1.setString(1,idb);
			s1.setString(2,titre);
			s1.setString(3,idu);
			s1.setString(4,prenom);
			s1.setString(5, de);
			s1.setString(6,d);
		    s1.execute();
				String query="delete from emprunte where id_exemplaire=?";
				PreparedStatement s=c.prepareStatement(query);
				s.setString(1,idb);
				x=s.executeUpdate();
			c.close();
			}
		 catch (SQLException e) {}
		return x;
		
	}
	public static ArrayList<domain.emprunte1> get_emprunte(){
		ArrayList<domain.emprunte1> list1=new ArrayList<domain.emprunte1>();
		try {
			Connection con = connect();
			PreparedStatement s=con.prepareStatement("select * from emprunte");
			ResultSet r=s.executeQuery();
			while(r.next()) {
				list1.add(new domain.emprunte1(r.getString("id_exemplaire"),r.getString("titre"),r.getString("id_usager"),r.getString("prenom"),r.getString("date_emprunte")));
			}
			con.close();
		} catch (SQLException e) {}
		return list1;
	}
	public static ArrayList<domain.historique1> get_history(){
		ArrayList<domain.historique1> list=new ArrayList<domain.historique1>();
		try {
			Connection con = connect();
			PreparedStatement s=con.prepareStatement("select * from  historique");
			ResultSet r=s.executeQuery();
			while(r.next()) {
				list.add(new domain.historique1(r.getString("id_exemplaire"),r.getString("titre"),r.getString("id_usager"),r.getString("prenom"),r.getString("date_emprunte"),r.getString("date_retour")));
				System.out.println(list.size());
			}
			con.close();
		} catch (SQLException e) {}
		return list;	
	}
	public static String seek(String id) {
		ArrayList<domain.emprunte1> list=new ArrayList<domain.emprunte1>();
		Connection c;
		try {
			c = connect();
			String query1="select *from emprunte where id_exemplaire=?";
			PreparedStatement s0=c.prepareStatement(query1);
			s0.setString(1, id);
			ResultSet r=s0.executeQuery();
			while(r.next()) {
				list.add(new domain.emprunte1(r.getString("id_exemplaire"),r.getString("titre"),r.getString("id_usager"),r.getString("prenom"),r.getString("date_emprunte")));
			}
			
		} catch (SQLException e) {
		}
		return list.get(0).getD();
		
	}
}