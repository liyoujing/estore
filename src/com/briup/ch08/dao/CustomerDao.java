package com.briup.ch08.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.briup.ch08.bean.Customer;
import com.briup.ch08.common.util.ConnectionFactory;
/**
 * 涓庢暟鎹簱浜や簰鐨勭被锛屼笉鍙備笌涓氬姟閫昏緫杩愮畻
 * save
 * find/query
 * update
 * delete
 * */
public class CustomerDao {

	/**
	 */
	public CustomerDao() {

	}

	/**
	 * @param customer
	 */
	public void save(Customer customer) {
		//6澶ф楠�
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			try{
				//1.2 鑾峰彇杩炴帴
				conn = ConnectionFactory.getConn();
				//3. 鍒涘缓pstmt瀵硅薄
				String sql = "insert into customer(name,password,age) "
						+ "values(?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, customer.getName());
				pstmt.setString(2, customer.getPassword());
				pstmt.setInt(3, customer.getAge());
				//4. 鎵цsql
				pstmt.executeUpdate();
				
			} finally {
				//6閲婃斁璧勬簮
				ConnectionFactory.close(null, pstmt, conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param id
	 */
	public void deleteById(long id) {

	}

	/**
	 * @param name
	 * @return com.briup.ch08.bean.Customer
	 */
	public Customer findByName(String name) {
		Customer customer = null;
		//6澶ф楠�
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			try{
				//1.2 鑾峰彇杩炴帴
				conn = ConnectionFactory.getConn();
				//3. 鍒涘缓pstmt瀵硅薄
				String sql = "select * from customer where name = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, name);
				//4. 鎵цsql
				rs = pstmt.executeQuery();
				while(rs.next()){
					long id = rs.getLong("id");
					String password = rs.getString("password");
					int age = rs.getInt("age");
					customer = new Customer(name, age, password);
					customer.setId(id);
				}
			} finally {
				//6閲婃斁璧勬簮
				ConnectionFactory.close(rs, pstmt, conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return customer;
	}
}
