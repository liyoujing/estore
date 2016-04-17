package com.briup.ch08.service.impl;

import com.briup.ch08.service.ICustomerService;
import com.briup.ch08.common.exception.ServiceException;
import com.briup.ch08.dao.CustomerDao;
import com.briup.ch08.bean.Customer;
/**
 * 涓氬姟閫昏緫灞�
 *   浜嬪姟绠＄悊锛堜簨鍔℃彁浜や互鍙婂洖婊氾級銆�
 *   澶氭璋冪敤Dao灞備唬鐮佸畬鎴愬鍒犳敼鎴�
 *   澶勭悊澶嶆潅涓氬姟閫昏緫
 *   	
 * */
public class CustomerServiceImpl implements ICustomerService {
	private CustomerDao customerDao;

	/**
	 */
	public CustomerServiceImpl() {
		//瀹炰緥鍖朇ustomerDao瀵硅薄
		customerDao = new CustomerDao();
	}

	/**
	 * @param name
	 * @param password
	 * @return com.briup.ch08.bean.Customer
	 */
	public Customer login(String name, String password) throws ServiceException {
		Customer customer = null;
		Customer dbCustomer = customerDao.findByName(name);
		if(dbCustomer!=null){
			if(dbCustomer.getPassword().equals(password)){
				customer = dbCustomer;
			}else{
				throw new ServiceException("密码错误");
			}
		}else{
			throw new ServiceException("用户名不存在");
		}
		return customer;
	}

	/**
	 * 娉ㄥ唽
	 * 	1. 鏌ヨ璇ョ敤鎴峰悕鏄惁宸茬粡琚汉鍗犵敤 find  
	 *  2. 娉ㄥ唽鐢ㄦ埛淇℃伅	save
	 *  3. 鍒濆鍖栫敤鎴蜂俊鎭�	update
	 * @param customer
	 */
	public void register(Customer customer) {
		customerDao.save(customer);
	}
}
