package com.briup.ch08.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.ch08.bean.Product;
import com.briup.ch08.service.IProductService;
import com.briup.ch08.service.impl.ProductServiceImpl;

@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private IProductService productService;
   
    public AddProductServlet() {
    	  super();
    	productService = new ProductServiceImpl();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.设置编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//2.获取参数
		String pro_name = request.getParameter("pro_name");
		String pro_address = request.getParameter("pro_address");
		Double price = Double.parseDouble(request.getParameter("price"));
		String describle = request.getParameter("describle");
		Product product = new Product(pro_name, pro_address, price, describle);
		//3.调到service中的方法
		productService.addProduct(product);
		//4.页面跳转
		request.getRequestDispatcher("/success.jsp").forward(request, response);
		
	}

}
