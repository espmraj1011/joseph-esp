package com.mkyong.rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sun.research.ws.wadl.Response;

@Path("/insert")
public class Insert {
	@GET
	@Path("/marks/{param1}/{param2}/{param3}/{param4}/{param5}/{param6}/{param7}/{param8}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMsg(@PathParam("param1") String msg1,@PathParam ("param2")String msg2,@PathParam ("param3")String msg3,@PathParam ("param4")String msg4,@PathParam ("param5")String msg5,@PathParam ("param6")String msg6,@PathParam ("param7")String msg7,@PathParam ("param8")String msg8) {
		Connection conn = null;
		Statement st = null;
		try
		{
			String myUrl = "jdbc:mysql://localhost:3306/testdb";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(myUrl, "root", "abcd1234");
			st = conn.createStatement();
			int a = Integer.parseInt(msg3);
			int b = Integer.parseInt(msg4);
			int c = Integer.parseInt(msg5);
			int d = Integer.parseInt(msg6);
			int e = Integer.parseInt(msg7);
			int f = Integer.parseInt(msg8);
			int g=a+b+c+d+e+f;
			String query = "INSERT INTO Marks(Name,DateOfBirth,Tamil,English,Mathematics,Physics,Chemistry,Biology,Total)" +
					"VALUES ('"+msg1+"','"+msg2+"',"+a+","+b+","+c+","+d+","+e+","+f+","+g+")";
			st.executeUpdate(query);
		}
		catch (Exception e)
		{
			System.err.println("Got an exception! ");
			e.printStackTrace();
		}
		return null;
		
	}
}
