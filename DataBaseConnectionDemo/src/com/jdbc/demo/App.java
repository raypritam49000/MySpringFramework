package com.jdbc.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dbj.connection.Connect;
import com.dbj.query.Insert;
import com.dbj.query.Select;

public class App {
	public static void main(String[] args) throws SQLException {
		Connect.Connect("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/test", "root", "1998");
		String[] index = { "name", "city", "salary" };
		String[] value = { "Pritam Ray", "Ropar", "5000" };
		// Insert.Save("employee", index, value);

		Connection con = (Connection) Connect.GetConnect("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/test","root", "1998");
		System.out.println(con);
		//ResultSet rs1 = Select.GetAll(con, "employee");
		//Insert.Save(con, "employee", index, value);
		PreparedStatement ps = con.prepareStatement("select * from employee");
		ResultSet rs = ps.executeQuery();
		System.out.println(ps);
		
		
		

		//ResultSet rs = Select.Get("employee", index, value);
		//ResultSet rs = Select.Get(con,"employee","id","2");
		try {
			while (rs.next()) {
				System.out.println(rs.getString("id") + " " + rs.getString("name") + " " + rs.getString("city") + " "
						+ rs.getString("salary"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
