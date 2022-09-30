
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domain.user;
public class login_database {
public static Connection connect() throws SQLException {
	return DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliothequemysql","root","");
}
public static int check(String username,String password) {
	int x=0;
	
	try {
	Connection con=connect();
    PreparedStatement p= con.prepareStatement("select * from login_table");
    ResultSet r=p.executeQuery();
    while(r.next()) {
    	if(r.getString("user_name").equals(username)) {
    		if(r.getString("password").equals(password)) {
    			x=1;
    			break;
    		}
    	    else {
    	    	x= 2;
    	    	break;
    	    }
                                                      }
    	
     else {
    	 x=0;
     }
    	
    }
    con.close();
    }
    catch(Exception e) {
    	System.out.println(e);
    }
	return x;
	
}


}
