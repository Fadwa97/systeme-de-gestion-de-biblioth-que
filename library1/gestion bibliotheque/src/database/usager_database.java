package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import domain.usager1;

public  class usager_database {
	public static Connection connect() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliothequemysql","root","");
	}
public static int insert_data(String id,String nom,String prenom,String statut,String email) {
     
	int x=0;
	try {
		Connection con = connect();
		String query="insert into usager values(?,?,?,?,?)";
		PreparedStatement ss=con.prepareStatement(query);
		ss.setString(1, id);
		ss.setString(2, nom);
		ss.setString(3, prenom);
		ss.setString(4,statut);
		ss.setString(5,email);
		x=ss.executeUpdate();
		System.out.println("ok bbdhjbhconnect");
	} catch (SQLException e) {}
	
	return x;	
	
}
public static int  delet_data(String id) {
	int  x=0;
	Connection con;
	try {
		con = connect();
		String query="delete from usager where id = ?";
		PreparedStatement ss=con.prepareStatement(query);
		ss.setString(1, id);
		x=ss.executeUpdate();
		System.out.println("connect");
	} catch (SQLException e) {}
	return x;
	
}
public static int update_data(String id,String nom,String prenom,String statut,String email) {
	int  x=0;
	Connection con;
	try {
		con = connect();
		String query="update usager set nom=? , prenom=? , statut=? ,email=?where id=?";
		PreparedStatement ss=con.prepareStatement(query);
		ss.setString(1, nom);
		ss.setString(2, prenom);
		ss.setString(3,statut);
		ss.setString(4,email);
		ss.setString(5, id);
		x=ss.executeUpdate();
		System.out.println("connect iyygygyg");
	} catch (SQLException e) {}
	return x;
	
}
public static ArrayList<domain.usager1> get_usager(){
	ArrayList<domain.usager1> list=new ArrayList<domain.usager1>();
	try {
		Connection con = connect();
		PreparedStatement s=con.prepareStatement("select * from usager");
		ResultSet r=s.executeQuery();
		while(r.next()) {
			list.add(new domain.usager1(r.getString("id"),r.getString("nom"),r.getString("prenom"),r.getString("statut"),r.getString("email")));
		}
	} catch (SQLException e) {}
	return list;
}
public static ArrayList<domain.usager1> search(String id) {
	ArrayList<domain.usager1> list=new ArrayList<domain.usager1>();
	Connection con;
	try {
		con=connect();
		String query="select *from usager where id=?";
		PreparedStatement ss=con.prepareStatement(query);
		ss.setString(1, id);
		ResultSet r=ss.executeQuery();
		while(r.next()) {
			list.add(new domain.usager1(r.getString("id"),r.getString("nom"),r.getString("prenom"),r.getString("statut"),r.getString("email")));
		}
	} catch (SQLException e) {}
	return list;
}

}
