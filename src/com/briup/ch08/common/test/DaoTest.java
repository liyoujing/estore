package com.briup.ch08.common.test;

import com.briup.ch08.bean.Customer;
import com.briup.ch08.bean.Product;
import com.briup.ch08.dao.CustomerDao;
import com.briup.ch08.dao.ProductDao;

public class DaoTest {
	public static void main(String[] args) {
		/*CustomerDao dao = new CustomerDao();
		dao.save(new Customer("xiao", 12, "123321"));
		System.out.println("success!");*/
		
		ProductDao dao = new ProductDao();
		dao.add(new Product("手机", "深圳", 999.0, "好手机"));
		System.out.println("success!");
	}
}
