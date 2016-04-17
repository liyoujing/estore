package com.briup.ch08.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.briup.ch08.bean.Product;
import com.briup.ch08.common.util.ConnectionFactory;

public class ProductDao {
	public ProductDao(){
		
	}
	public void add(Product product) {
		//6澶ф楠�
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			try{
				//1.2 获取连接
				conn = ConnectionFactory.getConn();
				//3. 插入数据到数据库
				String sql = "insert into product(pro_name,pro_address,price,describle) "
						+ "values(?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, product.getPro_name());
				pstmt.setString(2, product.getPro_address());
				pstmt.setDouble(3, product.getPrice());
				pstmt.setString(4, product.getDescrible());
				//4. 操作数据库
				pstmt.executeUpdate();
				
			} finally {
				//6释放资源
				ConnectionFactory.close(null, pstmt, conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param id
	 */
	public void deleteById(long pro_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			try{
				//1.2  获取连接
				conn = ConnectionFactory.getConn();
				//3. 插入数据到数据库
				String sql = "delete * from product where pro_id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setLong(1,pro_id);
				//4.  操作数据库
				pstmt.executeUpdate();
				
			} finally {
				//6释放资源
				ConnectionFactory.close(null, pstmt, conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		

	}

	/**
	 * @param name
	 * @return com.briup.ch08.bean.Customer
	 */
	public Product findByName(String pro_name) {
		Product product = null;
		//6初始化操作
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			try{
				//1.2 获取连接
				conn = ConnectionFactory.getConn();
				//3. 将数据拿到数据库中
				String sql = "select * from product where pro_name = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, pro_name);
				//4. 操作数据库
				rs = pstmt.executeQuery();
				while(rs.next()){
					long id = rs.getLong("pro_id");
					String address = rs.getString("pro_address");
					double price = rs.getDouble("price");
					String describle = rs.getString("describle");
					product = new Product(pro_name, address, price, describle);
					product.setPro_id(id);
				}
			} finally {
				//6释放资源
				ConnectionFactory.close(rs, pstmt, conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return product;
	}
}
