package com.mkyong.rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/data")
public class Data {
	
	@GET
	@Path("/marks/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public MarksVO getMsg(@PathParam("param") String msg) {
		return readData(msg);
	}


	private MarksVO readData(String msg){
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try
		{
			MarksVO data=new MarksVO();

			String myUrl = "jdbc:mysql://localhost:3306/testdb";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(myUrl, "root", "abcd1234");



			
			String query = "SELECT * FROM Marks "
					+ "WHERE Name='"+msg+"'";
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next())
			{
				String name = rs.getString("Name");
				String dateOfBirth = rs.getString("DateOfBirth");
				int tamil  = rs.getInt("Tamil");
				int english  = rs.getInt("English");
				int mathematics  = rs.getInt("Mathematics");
				int physics  = rs.getInt("Physics");
				int chemistry  = rs.getInt("Chemistry");
				int biology  = rs.getInt("Biology");
				int total  = rs.getInt("Total");



				// print the results
				System.out.println(name);
				System.out.println(dateOfBirth);
				System.out.println(tamil);
				System.out.println(english);
				System.out.println(mathematics);
				System.out.println(physics);
				System.out.println(chemistry);
				System.out.println(biology);
				System.out.println(total);
				String output = name +"   "+ dateOfBirth+" "+tamil+" "+english+" "+mathematics+" "+physics+" "+chemistry+" "+biology+" "+total;
				data.setName(name);
				data.setDateofbirth(dateOfBirth);
				data.setTamil(tamil);
				data.setEnglish(english);
				data.setMathematics(mathematics);
				data.setPhysics(physics);
				data.setChemistry(chemistry);
				data.setBiology(biology);
				data.setTotal(total);



				return data;
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


		return null;
	}
}