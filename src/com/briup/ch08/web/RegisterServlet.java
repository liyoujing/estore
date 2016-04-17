package com.briup.ch08.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.ch08.bean.Customer;
import com.briup.ch08.service.ICustomerService;
import com.briup.ch08.service.impl.CustomerServiceImpl;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//关联service对象
    private ICustomerService customerService;
    
    public RegisterServlet() {
        super();
        customerService = new CustomerServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. ���ñ���
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// 2.��ȡ����
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		int age = Integer.parseInt(request.getParameter("age"));
		Customer customer = new Customer(name, age, password);
		// 3. ����service�еķ���
		customerService.register(customer);
		// 4. ҳ����ת
		request.getRequestDispatcher("/success.jsp").forward(request, response);
	}

}
