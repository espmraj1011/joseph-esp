package com.mkyong.rest;

public class Queries {
	
	
	public static String retrieveAllCategoryQuery(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("select ")
		.append(" c.CategoryID, c.CategoryName, c.Description")
		.append(" from ") 
		.append(" categories c");
		return buffer.toString();
	}

	public static String retrieveAllProductQuery(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("select ")
		.append(" p.ProductID, p.ProductName, p.SupplierID, p.CategoryID, p.Unit, p.Price")
		.append(" from ") 
		.append(" products p");
		return buffer.toString();
	}

}
