package org.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBase {

	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","athik");
			
			String s= "select * from newcolleg";
			
			PreparedStatement ps = con.prepareStatement(s);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int reg = rs.getInt("regno");
				System.out.println(reg);
				
				String str = rs.getString("name");
				System.out.println(str);
				
				String str1 = rs.getString("dept");
				System.out.println(str1);
			}
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
