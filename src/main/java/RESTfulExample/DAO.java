package RESTfulExample;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DAO {
	private static CatVO[] catArr = null;
	private static ProVO[] proArr = null;
	
	
	public static CatVO[] retrieveAllCategories(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		CatVO tmpCat = null;
		java.util.List<CatVO> data = new ArrayList<CatVO>();
		try {
				conn = Conn.getConnection();
				stmt = conn.createStatement();
				String query = Queries.retrieveAllCategoryQuery();
				rs = stmt.executeQuery(query);
				while(rs.next()) {
					tmpCat = new CatVO();
					tmpCat.setCategoryId(rs.getInt("id"));
					tmpCat.setCategoryName(rs.getString("CategoryName"));
					tmpCat.setDescription(rs.getString("Description"));
					data.add(tmpCat);
				}
				
				catArr = data.toArray(new CatVO[data.size()]);
			}
		catch(Exception exp) {
			
	}
		finally {
			Conn.closeResources(rs, stmt, conn);
		}
		return catArr;
	}

	public static ProVO[] retrieveAllProduct(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ProVO tmpPro = null;
		java.util.List<ProVO> data = new ArrayList<ProVO>();
		try {
				conn = Conn.getConnection();
				stmt = conn.createStatement();
				String query = Queries.retrieveAllCategoryQuery();
				rs = stmt.executeQuery(query);
				while(rs.next()) {
					tmpPro = new ProVO();
					tmpPro.setProductId(rs.getInt("ProductId"));
					tmpPro.setProductName(rs.getString("ProductName"));
					tmpPro.setSupplierId(rs.getInt("SupplierId"));
					tmpPro.setCategoryId(rs.getInt("CategoryId"));
					tmpPro.setUnit(rs.getString("Unit"));
					tmpPro.setPrice(rs.getFloat("Price"));
					data.add(tmpPro);
				}
				
				proArr = data.toArray(new ProVO[data.size()]);
			}
		catch(Exception exp) {
			
	}
		finally {
			Conn.closeResources(rs, stmt, conn);
		}
		return proArr;
	}
	
}
