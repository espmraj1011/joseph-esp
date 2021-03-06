package com.mkyong.rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("/grouptemp")
public class Group {
	
		@GET
		@Path("/Temp")
		@Produces(MediaType.APPLICATION_JSON)
		public List<GroupVO> getMsg() {
			Connection conn = null;
			Statement st = null;
			ResultSet rs = null;
			List<GroupVO> dataArr = new ArrayList<GroupVO>();
		
		try
		{
			// create our mysql database connection
			//	      String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://localhost:3306/testdb";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(myUrl, "root", "abcd1234");
			
			
			String query = "SELECT MAX(Temperature) AS maxi, MONTH(Day) AS month, MONTHNAME(Day) AS month_name FROM Temp group by MONTH(Day)";
			
			st = conn.createStatement();

			// execute the query, and get a java resultset
			rs = st.executeQuery(query);

			// iterate through the java resultset
			while (rs.next())
			{
				GroupVO data=new GroupVO();	
			System.out.println(rs.getString("month_name"));
				float maxi = rs.getFloat("maxi");
				String month = rs.getString("month");
				String month_name = rs.getString("month_name");


				System.out.println(maxi);
				System.out.println(month);
				System.out.println(month_name);
				
				String output = maxi +"   "+ month+"   "+ month_name;
				data.setMaxi(maxi);
				data.setMonth(month);
				data.setMonth_name(month_name);
				
				
				dataArr.add(data);
			
			}
		}
		catch (Exception e)
		{
			System.err.println("Got an exception! ");
			e.printStackTrace();
		}


		finally {
			try {
				if(st!= null){
					st.close();}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				if(rs!= null){
					rs.close();}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				if(conn!= null){
					conn.close();}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


		return dataArr;
		
	}

}
