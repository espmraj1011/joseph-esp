package RESTfulExample;

public class Queries {
	
	
	public static String retrieveAllCategoryQuery(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("select ")
		.append(" c.CategoryId, c.CategoryName, c.Description")
		.append(" from ") 
		.append(" [categories] c");
		return buffer.toString();
	}

	public static String retrieveAllProductQuery(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("select ")
		.append(" p.ProductId, p.ProductName, p.SupplierId, p.CategoryId, p.Unit, p.Price")
		.append(" from ") 
		.append(" [products] p");
		return buffer.toString();
	}

}
