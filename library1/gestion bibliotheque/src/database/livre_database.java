package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class livre_database {
	public static Connection connect() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliothequemysql","root","");
	}
public static int insert_data(String nisbn,String titre,String auteur) {
     
	int x=0;
	try {
		Connection con = connect();
		System.out.println("ok bbdhjbhconnect");
		String query="insert into book values(?,?,?)";
		PreparedStatement ss=con.prepareStatement(query);
		ss.setString(1, nisbn);
		ss.setString(2, titre);
		ss.setString(3,auteur);
		x=ss.executeUpdate();
	} catch (SQLException e) {}
	
	return x;	
	
}
public static int  delet_data(String nisbn) {
	int  x=0;
	Connection con;
	try {
		con = connect();
		String query="delete from book where nisbn = ?";
		PreparedStatement ss=con.prepareStatement(query);
		ss.setString(1, nisbn);
		x=ss.executeUpdate();
		System.out.println("connect");
	} catch (SQLException e) {}
	return x;
	
}
public static int update_data(String nisbn,String titre,String auteur) {
	int  x=0;
	Connection con;
	try {
		con = connect();
		String query="update book set  titre=? , auteur=? where nisbn=?";
		PreparedStatement ss=con.prepareStatement(query);
		ss.setString(1, titre);
		ss.setString(2,auteur);
		ss.setString(3, nisbn);
		x=ss.executeUpdate();
		System.out.println("connect iyygygyg");
	} catch (SQLException e) {}
	return x;
	
}
public static ArrayList<domain.livre1> get_livre(){
	ArrayList<domain.livre1> list=new ArrayList<domain.livre1>();
	try {
		Connection con = connect();
		PreparedStatement s=con.prepareStatement("select * from book");
		ResultSet r=s.executeQuery();
		while(r.next()) {
			list.add(new domain.livre1(r.getString("nisbn"),r.getString("titre"),r.getString("auteur")));
		}
	} catch (SQLException e) {}
	return list;
}
public static ArrayList<domain.livre1> search(String nisbn) {
	ArrayList<domain.livre1> list=new ArrayList<domain.livre1>();
	Connection con;
	try{
		con=connect();
	    String query="select * from book where nisbn=?";
		PreparedStatement ss=con.prepareStatement(query);
		ss.setString(1, nisbn);
		ResultSet r=ss.executeQuery();
		while(r.next()) {
			list.add(new domain.livre1(r.getString("nisbn"),r.getString("titre"),r.getString("auteur")));
		}
		System.out.println(list);
	} catch (SQLException e) {}
	return list;
}
public static int insert_ex(String id,String nisbn) {
	ArrayList<domain.livre1> list=new ArrayList<domain.livre1>();
    list=search(nisbn);
		if(list.size()>0) {
			try {
			    Connection c=connect();
		        String query="insert into exemplaire values(?,?)";
		        PreparedStatement s=c.prepareStatement(query);
		        s.setString(1, id);
		        s.setString(2, nisbn);
		        s.executeUpdate();
	           } catch (SQLException e) {}
			return 1;
		}
		else return 0;
}
public static int delete_ex(String id) {
	int x=0;
	try {
	    Connection c=connect();
        String query="delete from exemplaire where id=?";
        PreparedStatement s=c.prepareStatement(query);
        s.setString(1, id);
        x=s.executeUpdate();
       } catch (SQLException e) {}
	return x;

}
}

