package com.briup.ch08.service;

import com.briup.ch08.bean.Product;
import com.briup.ch08.common.exception.ServiceException;

public interface IProductService {
	/**
	 * �����Ʒ
	 * @param product
	 */
	public void addProduct(Product product);
	
	/**
	 * ͨ����Ʒidȥɾ����Ʒ
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public void deleteProduct(Long pro_id);

}
