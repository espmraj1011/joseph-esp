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

@Path("/tablepro")

public class Tablepro {
	
	@GET
	@Path("/products")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProductVO> getMsg() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		List<ProductVO> dataArr = new ArrayList<ProductVO>();
		try
		{
			

			String myUrl = "jdbc:mysql://localhost:3306/testdb";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(myUrl, "root", "abcd1234");



			
			String query = "SELECT * FROM products";
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next())
			{
				ProductVO data=new ProductVO();
				String productname = rs.getString("ProductName");
				float price = rs.getFloat("Price");
				
				
				
				System.out.println(productname);
				System.out.println(price);
				
				
				String output = productname +"   "+ price;
				data.setProductname(productname);
				data.setPrice(price);
				
				
				dataArr.add(data);
				System.out.println(dataArr);
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