package com.briup.ch08.service.impl;

import com.briup.ch08.bean.Product;
import com.briup.ch08.common.exception.ServiceException;
import com.briup.ch08.dao.ProductDao;
import com.briup.ch08.service.IProductService;

public class ProductServiceImpl implements IProductService {
	private ProductDao productDao;
	
	 public ProductServiceImpl() {
		 //初始化productDao的信息
		 productDao = new ProductDao();
	}

	@Override
	public void addProduct(Product product) {
		
		productDao.add(product);

	}

	@Override
	public void deleteProduct(Long pro_id) {
		productDao.deleteById(pro_id);
		
	}

	

}
