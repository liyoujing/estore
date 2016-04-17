package com.briup.ch08.service;

import com.briup.ch08.bean.Product;
import com.briup.ch08.common.exception.ServiceException;

public interface IProductService {
	/**
	 * 添加商品
	 * @param product
	 */
	public void addProduct(Product product);
	
	/**
	 * 通过商品id去删除商品
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public void deleteProduct(Long pro_id);

}
